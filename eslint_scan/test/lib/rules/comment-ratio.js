/**
 * @fileoverview enforce a minimum comment ratio.
 * @author Hongjun Wang
 */
"use strict";

//------------------------------------------------------------------------------
// Requirements
//------------------------------------------------------------------------------

var rule = require("../../../lib/rules/comment-ratio"),

    RuleTester = require("../../../lib/testers/rule-tester");


//------------------------------------------------------------------------------
// Tests
//------------------------------------------------------------------------------

var ruleTester = new RuleTester();
ruleTester.run("comment-ratio", rule, {

    valid: [

        // give me some code that won't trigger a warning
    ],

    invalid: [
        {
            code: "let foo = { \"bar\": \"The comment ratio is less than 20%.\" };\n\n\n\n\n\n\n\n\n\n\n\n",
            errors: [{
                message: "Fill me in.",
                type: "Me too"
            }]
        }
    ]
});
