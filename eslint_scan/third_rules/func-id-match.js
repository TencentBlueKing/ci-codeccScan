/**
 * @fileoverview requires identifiers in function definitions to match a specified regular expression.
 * @author Hongjun Wang
 */
"use strict";

//------------------------------------------------------------------------------
// Rule Definition
//------------------------------------------------------------------------------

module.exports = {
    meta: {
        type: "suggestion",
        docs: {
            description: "require identifiers in function definitions to match a specified regular expression.",
            category: "Stylistic Issues",
            recommended: false,
            url: "https://eslint.org/docs/rules/func-id-match"
        },
        fixable: null,
        schema: [
            {
                type: "string"
            }
        ],
        messages: {
            notMatch: "Function name '{{name}}' does not match the pattern '{{pattern}}'."
        }
    },

    create(context) {

        // variables should be defined here
        const ANY_TEXT = "^.+$";
        const pattern = context.options[0] || ANY_TEXT;
        const regexp = new RegExp(pattern);

        //----------------------------------------------------------------------
        // Helpers
        //----------------------------------------------------------------------

        // any helper functions should go here or else delete this section

        /**
         * Checks if a string matches the provided pattern
         * @param {string} name The string to check.
         * @returns {boolean} if the string is a match
         * @private
         */
        function isInvalid(name) {
            return !regexp.test(name);
        }

        /**
         * Checks identifiers in function definitions to match a specified regular expression.
         * @param {ASTNode} node The node to check.
         * @returns {void}
         */
        function checkFuncIdentifer(node) {
            if (node.id) {
                const funcName = node.id.name;

                if (isInvalid(funcName)) {
                    context.report({
                        loc: { line: node.id.loc.start.line, column: node.id.loc.start.column },
                        messageId: "notMatch",
                        data: {
                            name: funcName,
                            pattern
                        }
                    });
                }
            }
        }

        //----------------------------------------------------------------------
        // Public
        //----------------------------------------------------------------------

        return {
            FunctionDeclaration: checkFuncIdentifer,
            FunctionExpression: checkFuncIdentifer
        };
    }
};
