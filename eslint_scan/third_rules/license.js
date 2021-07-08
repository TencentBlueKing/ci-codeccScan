/**
 * @fileoverview enforce license headers are present in source files.
 * @author Hongjun Wang
 * @license
 * Tencent is pleased to support the open source community by making this available.
 *
 * Copyright (C) 2017-2018 THL A29 Limited, a Tencent company. All rights reserved.
 *
 * Licensed under the MIT License (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 *
 * http://opensource.org/licenses/MIT
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */

"use strict";

//------------------------------------------------------------------------------
// Requirements
//------------------------------------------------------------------------------

const astUtils = require("../node_modules/eslint/lib/rules/utils/ast-utils");

//------------------------------------------------------------------------------
// Rule Definition
//------------------------------------------------------------------------------

module.exports = {
    meta: {
        type: "suggestion",
        docs: {
            description: "enforce license headers are present in source files.",
            category: "Stylistic Issues",
            recommended: false,
            url: "https://eslint.org/docs/rules/license"
        },
        fixable: null,
        schema: [
            {
                type: "string"
            },
            {
                type: "object",
                properties: {
                    startLine: {
                        type: "integer",
                        minimum: 1
                    },
                    endLine: {
                        type: "integer",
                        minimum: 1
                    }
                }
            }
        ],
        messages: {
            missingLicense: "The license was not found within the range of {{start}}-{{end}} lines."
        }
    },

    create(context) {


        //--------------------------------------------------------------------------
        // Options
        //--------------------------------------------------------------------------
        const ANY_TEXT = "^.+$";

        // const TENCENT_LICENSE_PATTERN = ".+Tencent is pleased to support the open source community.+";
        const pattern = context.options[0] || ANY_TEXT;
        const regexp = new RegExp(pattern);

        const START_LINE = 1;
        const END_LINE = 10;
        const options = context.options[1] || { startLine: START_LINE, endLine: END_LINE };
        const startLine = options.startLine || START_LINE;
        const endLine = Math.max(options.endLine || END_LINE, startLine);

        const sourceCode = context.getSourceCode();

        //----------------------------------------------------------------------
        // Helpers
        //----------------------------------------------------------------------

        /**
         * Checks whether or not the comment contains a license header.
         * @param {ASTNode} comment The comment node to check.
         * @returns {boolean} 'true' if the comment contains a license header, 'false' otherwise.
         */
        function hasLicense(comment) {
            const commentTexts = comment.value.split(astUtils.createGlobalLinebreakMatcher());
            const lineNo = comment.loc.start.line;
            let licenseFound = false;

            commentTexts.forEach((text, index) => {
                if (lineNo + index < startLine) {
                    return;
                }

                if (lineNo + index > endLine) {
                    return;
                }

                if (text.search(regexp) >= 0) {
                    licenseFound = true;
                }
            });

            return licenseFound;
        }

        /**
         * Checks license headers are present in source files.
         * @returns {void}
         */
        function checkLicenseExists() {
            const comments = sourceCode.getAllComments();
            let licenseFound = false;

            comments.forEach(comment => {
                if (comment.loc.start.line > endLine) {
                    return;
                }

                if (hasLicense(comment)) {
                    licenseFound = true;
                }
            });

            if (!licenseFound) {
                context.report({
                    loc: { line: 1, column: 0 },
                    messageId: "missingLicense",
                    data: {
                        start: startLine,
                        end: endLine
                    }
                });
            }
        }

        //----------------------------------------------------------------------
        // Public
        //----------------------------------------------------------------------

        return {
            "Program:exit": checkLicenseExists
        };
    }
};
