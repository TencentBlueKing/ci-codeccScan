package com.tencent.checks;

import com.puppycrawl.tools.checkstyle.StatelessCheck;
import com.puppycrawl.tools.checkstyle.api.AbstractFileSetCheck;
import com.puppycrawl.tools.checkstyle.api.FileText;

import java.io.File;

/**
 * Checks license headers are present in source files.
 */
@StatelessCheck
public class LicenseCheck extends AbstractFileSetCheck {
    public static final String MSG_MISSING = "license.missing";

    private static final int LICENSE_BEFORE_LINE = 10;
    private static final String LICNESE_TEXT = "Tencent is pleased to support the open source community";

    private int licenseBeforeLine = LICENSE_BEFORE_LINE;

    public void setLicenseBeforeLine(int num) {
        if (0 < num) {
            licenseBeforeLine = num;
        }
    }

    @Override
    protected void processFiltered(File file, FileText fileText) {
        boolean licenseFound = false;

        for (int i = 0; i < fileText.size(); i++) {
            if ( i > licenseBeforeLine) {
                break;
            }

            final String line = fileText.get(i);

            if (line.contains(LICNESE_TEXT)) {
                licenseFound = true;
            }
        }

        if (!licenseFound) {
            log(1, MSG_MISSING, licenseBeforeLine);
        }

    }
}
