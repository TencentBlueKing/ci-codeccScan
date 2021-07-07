package com.tencent.checks;

import com.puppycrawl.tools.checkstyle.StatelessCheck;
import com.puppycrawl.tools.checkstyle.api.AbstractFileSetCheck;
import com.puppycrawl.tools.checkstyle.api.FileText;
import com.puppycrawl.tools.checkstyle.checks.LineSeparatorOption;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Checks the line separator.
 */
@StatelessCheck
public class LineSeparatorCheck extends AbstractFileSetCheck {

    public static final String MSG_ERROR = "line.separator.error";

    /**
     * The line separator to check against.
     */
    private LineSeparatorOption lineSeparator = LineSeparatorOption.LF;

    /**
     * Regular expression pattern matching all line terminators.
     */
    private static final Pattern LINE_TERMINATOR = Pattern.compile("\\n|\\r\\n?");

    /**
     * Sets the line separator to one of 'crlf', 'lf','cr', 'lf_cr_crlf' or 'system'.
     *
     * @param sep The line separator to set
     * @throws IllegalArgumentException If the specified line separator is not
     *                                  one of 'crlf', 'lf', 'cr', 'lf_cr_crlf' or 'system'
     */
    public void setLineSeparator(String sep) {
        lineSeparator = Enum.valueOf(LineSeparatorOption.class, sep.trim().toUpperCase(Locale.ENGLISH));
    }

    @Override
    protected void processFiltered(File file, FileText fileText) {
        checkLineSeparator(fileText);
    }

    public String toLineSeparatorName(byte... bytes) {
        String name;

        if ('\n' == bytes[0]) {
            name = "LF";
        } else if ('\r' == bytes[0]) {
            if (1 < bytes.length && '\n' == bytes[1]) {
                name = "CRLF";
            } else {
                name = "CR";
            }
        } else {
            throw new IllegalArgumentException(
                    "Not a line separator: " + Arrays.toString(bytes));
        }

        return name;
    }

    private void checkLineSeparator(FileText fileText) {
        final Matcher matcher = LINE_TERMINATOR.matcher(fileText.getFullText());
        while (matcher.find()) {
            byte[] lineSeparatorBytes = matcher.group().getBytes(StandardCharsets.US_ASCII);

            if (!lineSeparator.matches(lineSeparatorBytes)) {
                log(1, MSG_ERROR, lineSeparator, toLineSeparatorName(lineSeparatorBytes));
                break;
            }
        }
    }
}
