package com.tencent.checks;

import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

import java.util.HashMap;
import java.util.Map;

public class EscapeSequenceCheck extends AbstractCheck {
    /**
     * A key is pointing to the warning message text in "messages.properties"
     * file.
     */
    public static final String MSG_ESCAPED_SEQUENCES = "escape.special.characters";

    /**
     * Whether we should check special escape sequence form.
     */
    private boolean checkSpecialEscapeSequence = false;

    private static final Map<Character, String> EscapeSequences;

    static {
        EscapeSequences = new HashMap<Character, String>();
        EscapeSequences.put('\t', "\\t");
        EscapeSequences.put('\b', "\\b");
        EscapeSequences.put('\n', "\\n");
        EscapeSequences.put('\r', "\\r");
        EscapeSequences.put('\f', "\\f");
        EscapeSequences.put('\'', "\\\'");
        EscapeSequences.put('\"', "\\\"");
        EscapeSequences.put('\\', "\\\\");
    }

    public void setCheckSpecialEscapeSequence(boolean checkSpecialEscapeSequence) {
        this.checkSpecialEscapeSequence = checkSpecialEscapeSequence;
    }

    @Override
    public int[] getDefaultTokens() {
        return getRequiredTokens();
    }

    @Override
    public int[] getAcceptableTokens() {
        return getRequiredTokens();
    }

    @Override
    public int[] getRequiredTokens() {
        return new int[]{
                TokenTypes.STRING_LITERAL,
                TokenTypes.CHAR_LITERAL
        };
    }

    @Override
    public void visitToken(DetailAST ast) {
        String text = ast.getText();

        EscapeCharacterReader reader = new EscapeCharacterReader(text);

        while (true) {
            int c = reader.read();
            if (c == -1) {
                break;
            }

            // check the escape character has a special escape sequence.
            if (!EscapeSequences.containsKey((char) c)) {
                continue;
            }

            int position = reader.position();
            String escapeSequence = reader.getEscapeSequence();
            String desiredSequence = EscapeSequences.get((char) c);

            // // check the escape sequence is equal to its special escape sequence.
            if (escapeSequence.compareTo(desiredSequence) == 0) {
                continue;
            }

            int line = ast.getLineNo();
            int column = ast.getColumnNo() + position;
            log(line, column, MSG_ESCAPED_SEQUENCES, desiredSequence, escapeSequence);
        }
    }


    /**
     * 2.3.2 Special escape sequences
     * For any character that has a special escape sequence (\b, \t, \n, \f, \r, \", \' and \\), that sequence is used
     * rather than the corresponding octal (e.g. \012) or Unicode (e.g. \u000a) escape.
     */
    static class EscapeCharacterReader {

        /**
         * Use a manual buffer to easily read and unread upcoming characters, and
         * also so we can create strings without an intermediate StringBuilder.
         */
        private final char[] buffer;
        private int pos;
        private int limit;

        private int escapePos;
        private String escapeSequence;

        EscapeCharacterReader(String s) {
            buffer = s.toCharArray();
            pos = 0;
            limit = buffer.length;

            escapePos = -1;
        }

        /**
         * @return the next escaped character, or -1 if the end of the string is reached.
         */
        public int read() {
            while (pos < limit) {
                int c = buffer[pos++];
                if (c != '\\') {
                    continue;
                }

                escapePos = pos - 1;
                return readEscapeCharacter();
            }

            return -1;
        }

        /**
         * @return the position of the start of the current escape sequence.
         */
        public final int position() {
            return escapePos;
        }


        public String getEscapeSequence() {
            return escapeSequence;
        }

        /**
         * Unescapes the character identified by the character or characters that
         * immediately follow a backslash. The backslash '\' should have already
         * been read. This supports unicode escapes "u000A", two-character
         * escapes "\n" and octal escapes "\12".
         */
        private char readEscapeCharacter() {
            char escaped = buffer[pos++];

            // octal escape sequence.
            if (escaped >= '0' && escaped <= '7') {
                String code = "" + escaped;
                if (pos < limit && buffer[pos] >= '0' && buffer[pos] <= '7') {
                    code += buffer[pos++];
                    if (pos < limit && buffer[pos] >= '0' && buffer[pos] <= '7') {
                        code += buffer[pos++];
                    }
                }

                escapeSequence = "\\" + code;
                char result = (char) Integer.parseInt(code, 8);
                return result;
            }

            // unicode escape sequence.
            if (escaped == 'u') {
                // Equivalent to Integer.parseInt(stringPool.get(buffer, pos, 4), 16);
                char result = 0;
                for (int i = pos, end = i + 4; i < end; i++) {
                    char c = buffer[i];
                    result <<= 4;
                    if (c >= '0' && c <= '9') {
                        result += (c - '0');
                    } else if (c >= 'a' && c <= 'f') {
                        result += (c - 'a' + 10);
                    } else if (c >= 'A' && c <= 'F') {
                        result += (c - 'A' + 10);
                    } else {
                        throw new NumberFormatException("\\u" + new String(buffer, pos, 4));
                    }
                }
                pos += 4;

                escapeSequence = new String(buffer, escapePos, 6);
                return result;
            }

            // two-character escape sequence.
            escapeSequence = new String(buffer, escapePos, 2);
            switch (escaped) {
                case 't':
                    return '\t';

                case 'b':
                    return '\b';

                case 'n':
                    return '\n';

                case 'r':
                    return '\r';

                case 'f':
                    return '\f';

                case '\'':
                case '"':
                case '\\':
                    return escaped;

                default:
                    throw new RuntimeException("Invalid escape sequence");
            }
        }
    }
}
