/**
 * @fileoverview enforce consistent space indentation
 * @author Hongjun Wang
 */
"use strict";

//------------------------------------------------------------------------------
// Rule Definition
//------------------------------------------------------------------------------

/**
 * A helper class to get token-based info related to indentation
 */
class TokenInfo {

    /**
     * @param {SourceCode} sourceCode A SourceCode object
     */
    constructor(sourceCode) {
        this.sourceCode = sourceCode;
        this.firstTokensByLineNumber = sourceCode.tokensAndComments.reduce((map, token) => {
            if (!map.has(token.loc.start.line)) {
                map.set(token.loc.start.line, token);
            }
            if (!map.has(token.loc.end.line) && sourceCode.text.slice(token.range[1] - token.loc.end.column, token.range[1]).trim()) {
                map.set(token.loc.end.line, token);
            }
            return map;
        }, new Map());
    }

    /**
     * Gets the first token on a given token's line
     * @param {Token|ASTNode} token a node or token
     * @returns {Token} The first token on the given line
     */
    getFirstTokenOfLine(token) {
        return this.firstTokensByLineNumber.get(token.loc.start.line);
    }

    /**
     * Determines whether a token is the first token in its line
     * @param {Token} token The token
     * @returns {boolean} `true` if the token is the first on its line
     */
    isFirstTokenOfLine(token) {
        return this.getFirstTokenOfLine(token) === token;
    }

    /**
     * Get the actual indent of a token
     * @param {Token} token Token to examine. This should be the first token on its line.
     * @returns {string} The indentation characters that precede the token
     */
    getTokenIndent(token) {
        return this.sourceCode.text.slice(token.range[0] - token.loc.start.column, token.range[0]);
    }
}

module.exports = {
    meta: {
        type: "layout",

        docs: {
            description: "enforce consistent space indentation",
            category: "Stylistic Issues",
            recommended: false,
            url: "https://eslint.org/docs/rules/space-indent"
        },
        fixable: null,
        schema: [
            {
                type: "integer",
                minimum: 0
            }
        ],
        messages: {
            tabsMustNotBeUsed: "Tabs must not be used.",
            badIndentation: "Expected indentation should be multiple of {{expected}}, but found {{actual}}."
        }
    },

    create(context) {

        // variables should be defined here
        const indentSize = context.options[0] || 4;
        const sourceCode = context.getSourceCode();
        const tokenInfo = new TokenInfo(sourceCode);

        //----------------------------------------------------------------------
        // Helpers
        //----------------------------------------------------------------------

        // any helper functions should go here or else delete this section

        /**
         * Reports if a token's indentation is not correct.
         * @param {Token} token to examine
         * @returns {void}
         */
        function reportBadTokenIndent(token) {
            const indentation = tokenInfo.getTokenIndent(token);

            if (indentation.includes("\t")) {
                context.report({
                    node: token,
                    messageId: "tabsMustNotBeUsed"
                });
            } else if (indentation.length % indentSize !== 0) {
                context.report({
                    node: token,
                    messageId: "badIndentation",
                    data: {
                        expected: indentSize,
                        actual: indentation.length
                    }
                });
            }
        }

        /**
         * Checks program for consistent space indentation.
         * @returns {void}
         */
        function checkForSpaceIndents() {
            sourceCode.lines.forEach((line, index) => {
                const lineNumber = index + 1;

                if (!tokenInfo.firstTokensByLineNumber.has(lineNumber)) {

                    // Don't check indentation on blank lines
                    return;
                }

                const firstTokenOfLine = tokenInfo.firstTokensByLineNumber.get(lineNumber);

                if (firstTokenOfLine.loc.start.line !== lineNumber) {

                    // Don't check the indentation of multi-line tokens (e.g. template literals or block comments)
                    return;
                }

                reportBadTokenIndent(firstTokenOfLine);
            });
        }

        //----------------------------------------------------------------------
        // Public
        //----------------------------------------------------------------------

        return {
            "Program:exit": checkForSpaceIndents
        };
    }
};
