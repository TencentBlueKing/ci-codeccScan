/**
 * @fileoverview enforce a minimum comment ratio.
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
            description: "enforce a minimum comment ratio.",
            category: "Stylistic Issues",
            recommended: false,
            url: "https://eslint.org/docs/rules/comment-ratio"
        },
        fixable: null,
        schema: [
            {
                type: "number",
                minimum: 0
            }
        ],
        messages: {
            lowCommentRatio: "Comment ratio is less than {{min}}% (found {{actual}}%)."
        }
    },

    create(context) {

        // variables should be defined here
        const minimumCommentRatio = context.options[0] || 0,
            sourceCode = context.getSourceCode();

        //----------------------------------------------------------------------
        // Helpers
        //----------------------------------------------------------------------

        /**
         * Counts the number of lines containing comments.
         * @param {ASTNode[]} comments An array of comment tokens.
         * @returns {number} the number of lines containing comments.
         */
        function countCommentLine(comments) {
            let lineCount = 0;

            comments.forEach(comment => {
                lineCount += comment.loc.end.line - comment.loc.start.line + 1;
            });

            return lineCount;
        }

        /**
         * Returns whether or not a comment line has any code.
         * @param {ASTNode} comment The comment node to check.
         * @returns {boolean} 'true' if the comment line containing any code, 'false' otherwise.
         */
        function isCommentLineWithCode(comment) {
            let token;

            token = comment;
            do {
                token = sourceCode.getTokenBefore(token, { includeComments: true });
            } while (token && astUtils.isCommentToken(token));

            if (token && astUtils.isTokenOnSameLine(token, comment)) {
                return true;
            }

            token = comment;
            do {
                token = sourceCode.getTokenAfter(token, { includeComments: true });
            } while (token && astUtils.isCommentToken(token));

            if (token && astUtils.isTokenOnSameLine(token, comment)) {
                return true;
            }

            return false;
        }

        /**
         * Counts the number of comment lines containing code.
         * @param {ASTNode[]} comments An array of comment tokens.
         * @returns {number} The number of comment lines containing code.
         */
        function countCommentLineWithCode(comments) {
            let lineCount = 0;

            comments.forEach(comment => {
                if (isCommentLineWithCode(comment)) {
                    lineCount += 1;
                }
            });

            return lineCount;
        }

        /**
         * Checks the program for minimum comment ratio.
         * @returns {void}
         */
        function checkProgramForMinCommentRatio() {
            const comments = sourceCode.getAllComments();
            const commentLineNumber = countCommentLine(comments);
            const commentLineWithCodeNumber = countCommentLineWithCode(comments);

            // Skip blank lines.
            const lines = sourceCode.lines.filter(text => text.trim() !== "");
            const codeLineNumber = lines.length - commentLineNumber + commentLineWithCodeNumber;

            const commentRatio = (commentLineNumber / codeLineNumber * 100);

            if (commentRatio < minimumCommentRatio) {

                context.report({
                    loc: { line: 1, column: 0 },
                    messageId: "lowCommentRatio",
                    data: {
                        min: minimumCommentRatio.toFixed(2),
                        actual: commentRatio.toFixed(2)
                    }
                });
            }
        }

        //----------------------------------------------------------------------
        // Public
        //----------------------------------------------------------------------

        return {
            "Program:exit": checkProgramForMinCommentRatio
        };
    }
};
