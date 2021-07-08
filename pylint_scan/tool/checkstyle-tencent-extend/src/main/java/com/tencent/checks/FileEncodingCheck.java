package com.tencent.checks;

import com.puppycrawl.tools.checkstyle.StatelessCheck;
import com.puppycrawl.tools.checkstyle.api.AbstractFileSetCheck;
import com.puppycrawl.tools.checkstyle.api.FileText;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

@StatelessCheck
public class FileEncodingCheck  extends AbstractFileSetCheck {
    public static final String MSG_ERROR = "file.encoding";

    @Override
    protected void processFiltered(File file, FileText fileText) {
        boolean unexpectedCharsetFound = false;

        Charset charset = StandardCharsets.UTF_8;
        CharsetDecoder decoder = charset.newDecoder();

        try (InputStream stream = Files.newInputStream(file.toPath());
             Reader reader = new InputStreamReader(stream, decoder)) {

            final char[] buf = new char[1024];
            while (-1 != reader.read(buf)) {
                // do nothing
            }
        } catch (CharacterCodingException ignore) {
            unexpectedCharsetFound = true;
        } catch (IOException ignore) {}

        if (unexpectedCharsetFound) {
            log(1, MSG_ERROR, charset.displayName());
        }
    }

}
