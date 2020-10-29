{
    "env": {
        "browser": true, 
        "node": false, 
        "commonjs": true, 
        "es6": false
    }, 
    "root": true, 
    "settings": {
        "react": {
            "createClass": "createReactClass", 
            "pragma": "React", 
            "version": "15.0"
        }
    },
    "extends": [
        "plugin:vue/base"
    ], 
    "overrides": [
      {
        "files": ["*.ts", "*.tsx"],
        "extends": ["@tencent/eslint-config-tencent/ts"],
        "rules": {
            "@typescript-eslint/adjacent-overload-signatures": [
                "error"
              ],
              "@typescript-eslint/class-literal-property-style": [
                "error",
                "fields"
              ],
              "@typescript-eslint/consistent-type-assertions": [
                "error",
                {
                  "assertionStyle": "as",
                  "objectLiteralTypeAssertions": "never"
                }
              ],
              "@typescript-eslint/consistent-type-definitions": [
                "off"
              ],
              "@typescript-eslint/explicit-member-accessibility": [
                "warn"
              ],
              "@typescript-eslint/member-ordering": [
                "error",
                {
                  "default": [
                    "public-static-field",
                    "protected-static-field",
                    "private-static-field",
                    "static-field",
                    "public-static-method",
                    "protected-static-method",
                    "private-static-method",
                    "static-method",
                    "public-instance-field",
                    "protected-instance-field",
                    "private-instance-field",
                    "public-field",
                    "protected-field",
                    "private-field",
                    "instance-field",
                    "field",
                    "constructor",
                    "public-instance-method",
                    "protected-instance-method",
                    "private-instance-method",
                    "public-method",
                    "protected-method",
                    "private-method",
                    "instance-method",
                    "method"
                  ]
                }
              ],
              "@typescript-eslint/method-signature-style": [
                "off"
              ],
              "@typescript-eslint/no-empty-interface": [
                "error"
              ],
              "@typescript-eslint/no-inferrable-types": [
                "warn"
              ],
              "@typescript-eslint/no-namespace": [
                "error",
                {
                  "allowDeclarations": true,
                  "allowDefinitionFiles": true
                }
              ],
              "@typescript-eslint/no-non-null-asserted-optional-chain": [
                "error"
              ],
              "@typescript-eslint/no-parameter-properties": [
                "off"
              ],
              "@typescript-eslint/no-require-imports": [
                "error"
              ],
              "@typescript-eslint/no-this-alias": [
                "error",
                {
                  "allowDestructuring": true
                }
              ],
              "@typescript-eslint/no-unused-expressions": [
                "error",
                {
                  "allowShortCircuit": true,
                  "allowTernary": true,
                  "allowTaggedTemplates": true
                }
              ],
              "@typescript-eslint/no-useless-constructor": [
                "warn"
              ],
              "@typescript-eslint/prefer-for-of": [
                "warn"
              ],
              "@typescript-eslint/prefer-function-type": [
                "warn"
              ],
              "@typescript-eslint/prefer-namespace-keyword": [
                "error"
              ],
              "@typescript-eslint/prefer-optional-chain": [
                "error"
              ],
              "@typescript-eslint/triple-slash-reference": [
                "error",
                {
                  "path": "never",
                  "types": "always",
                  "lib": "always"
                }
              ],
              "@typescript-eslint/type-annotation-spacing": [
                "error"
              ],
              "@typescript-eslint/typedef": [
                "error",
                {
                  "arrayDestructuring": false,
                  "arrowParameter": false,
                  "memberVariableDeclaration": false,
                  "objectDestructuring": false,
                  "parameter": false,
                  "propertyDeclaration": true,
                  "variableDeclaration": false
                }
              ],
              "@typescript-eslint/unified-signatures": [
                "error"
              ]
        }
      },
      {
        "files": ["*.vue"],
        "extends": ["@tencent/eslint-config-tencent"],
        "rules": {
          "vue/no-dupe-keys": "off", 
          "vue/no-parsing-error": "error", 
          "vue/no-reservered-keys": "error", 
          "vue/no-shared-component-data": "off", 
          "vue/no-template-key": "off", 
          "vue/require-render-return": "error", 
          "vue/require-valid-default-prop": "off", 
          "vue/return-in-computed-property": "error", 
          "vue/valid-template-root": "error", 
          "vue/valid-v-bind": "error", 
          "vue/valid-v-cloak": "error", 
          "vue/valid-v-else-if": "error", 
          "vue/valid-v-else": "error", 
          "vue/valid-v-for": "error", 
          "vue/valid-v-html": "error", 
          "vue/valid-v-if": "error", 
          "vue/valid-v-model": "error", 
          "vue/valid-v-on": "error", 
          "vue/valid-v-once": "error", 
          "vue/valid-v-pre": "error", 
          "vue/valid-v-show": "error", 
          "vue/valid-v-text": "error", 
          "vue/html-end-tags": "off", 
          "vue/no-async-in-computed-properties": "error", 
          "vue/no-confusing-v-for-v-if": "error", 
          "vue/no-duplicate-attributes": "error", 
          "vue/no-side-effects-in-computed-properties": "off", 
          "vue/no-textarea-mustache": "error", 
          "vue/order-in-components": "error", 
          "vue/require-component-is": "error", 
          "vue/require-prop-types": "off", 
          "vue/require-v-for-key": "error", 
          "vue/attribute-hyphenation": "off", 
          "vue/html-quotes": "error", 
          "vue/html-self-closing": "off", 
          "vue/max-attributes-per-line": "off", 
          "vue/name-property-casing": "off", 
          "vue/no-multi-spaces": "error", 
          "vue/v-bind-style": "off", 
          "vue/v-on-style": "off", 
          "vue/jsx-uses-vars": "error"
        }
      },
      {
        "files": ["*.js", "*.vue"],
        "extends": ["@tencent/eslint-config-tencent"],
        "rules": {
            "import/no-duplicates": "error",
            "import/first": "error",
            "import/no-mutable-exports": "warn",
            "import/no-webpack-loader-syntax": "warn",
            "import/prefer-default-export": "warn",
            "react/boolean-prop-naming": "off", 
            "react/default-props-match-prop-types": "off", 
            "react/display-name": "off", 
            "react/forbid-component-props": "off", 
            "react/forbid-elements": "off", 
            "react/forbid-prop-types": "off", 
            "react/forbid-foreign-prop-types": "off", 
            "react/no-array-index-key": "off", 
            "react/no-children-prop": "error", 
            "react/no-danger": "off", 
            "react/no-danger-with-children": "error", 
            "react/no-deprecated": "error", 
            "react/no-did-mount-set-state": "off", 
            "react/no-did-update-set-state": "error", 
            "react/no-direct-mutation-state": "error", 
            "react/no-find-dom-node": "error", 
            "react/no-is-mounted": "error", 
            "react/no-multi-comp": "off", 
            "react/no-redundant-should-component-update": "error", 
            "react/no-render-return-value": "error", 
            "react/no-set-state": "off", 
            "react/no-typos": "error", 
            "react/no-string-refs": "error", 
            "react/no-unescaped-entities": "error", 
            "react/no-unknown-property": "error", 
            "react/no-unused-prop-types": "off", 
            "react/no-unused-state": "off", 
            "react/no-will-update-set-state": "error", 
            "react/prefer-es6-class": [
                "error", 
                "always"
            ], 
            "react/prefer-stateless-function": "off", 
            "react/prop-types": "off", 
            "react/react-in-jsx-scope": "off", 
            "react/require-default-props": "off", 
            "react/require-optimization": "off", 
            "react/require-render-return": "error", 
            "react/self-closing-comp": "off", 
            "react/sort-comp": "error", 
            "react/sort-prop-types": "off", 
            "react/style-prop-object": "error", 
            "react/void-dom-elements-no-children": "error", 
            "react/jsx-boolean-value": "off", 
            "react/jsx-closing-bracket-location": [
                "error", 
                {
                    "nonEmpty": false, 
                    "selfClosing": "line-aligned"
                }
            ], 
            "react/jsx-closing-tag-location": "off", 
            "react/jsx-curly-spacing": [
                "error", 
                {
                    "when": "never", 
                    "attributes": {
                        "allowMultiline": true
                    }, 
                    "children": true, 
                    "spacing": {
                        "objectLiterals": "never"
                    }
                }
            ], 
            "react/jsx-equals-spacing": [
                "error", 
                "never"
            ], 
            "react/jsx-filename-extension": "off", 
            "react/jsx-first-prop-new-line": "off", 
            "react/jsx-handler-names": "off", 
            "react/jsx-indent": "off", 
            "react/jsx-indent-props": "off", 
            "react/jsx-key": "error", 
            "react/jsx-max-props-per-line": "off", 
            "react/jsx-no-bind": "off", 
            "react/jsx-no-comment-textnodes": "error", 
            "react/jsx-no-duplicate-props": "error", 
            "react/jsx-no-literals": "off", 
            "react/jsx-no-target-blank": "off", 
            "react/jsx-no-undef": "off", 
            "react/jsx-pascal-case": "error", 
            "react/jsx-sort-props": "off", 
            "react/jsx-tag-spacing": [
                "error", 
                {
                    "closingSlash": "never", 
                    "beforeSelfClosing": "always", 
                    "afterOpening": "never"
                }
            ], 
            "react/jsx-uses-react": "error", 
            "react/jsx-uses-vars": "error", 
            "react/jsx-wrap-multilines": "off",
            "license": ["error", ".*Tencent is pleased to support the open source community.+"],
            "func-id-match": ["error", "^[a-zA-Z0-9_]{1,35}$"],
            "comment-ratio": ["error", 10],
            "for-direction": "error", 
            "getter-return": [
                "error", 
                {
                    "allowImplicit": false
                }
            ], 
            "no-await-in-loop": "off", 
            "no-compare-neg-zero": "error", 
            "no-cond-assign": [
                "error", 
                "except-parens"
            ], 
            "no-console": "off", 
            "no-constant-condition": [
                "error", 
                {
                    "checkLoops": false
                }
            ], 
            "no-control-regex": "error", 
            "no-debugger": "error", 
            "no-dupe-args": "error", 
            "no-dupe-keys": "error", 
            "no-duplicate-case": "error", 
            "no-empty": [
                "error", 
                {
                    "allowEmptyCatch": true
                }
            ], 
            "no-empty-character-class": "error", 
            "no-ex-assign": "error", 
            "no-extra-boolean-cast": "error", 
            "no-extra-parens": "off", 
            "no-extra-semi": "error", 
            "no-func-assign": "error", 
            "no-inner-declarations": [
                "error", 
                "both"
            ], 
            "no-invalid-regexp": "error", 
            "no-irregular-whitespace": [
                "error", 
                {
                    "skipStrings": true, 
                    "skipComments": false, 
                    "skipRegExps": true, 
                    "skipTemplates": true
                }
            ], 
            "no-obj-calls": "error", 
            "no-prototype-builtins": "error", 
            "no-regex-spaces": "error", 
            "no-sparse-arrays": "error", 
            "no-template-curly-in-string": "error", 
            "no-unexpected-multiline": "error", 
            "no-unreachable": "error", 
            "no-unsafe-finally": "error", 
            "no-unsafe-negation": "error", 
            "use-isnan": "error", 
            "valid-jsdoc": "off", 
            "valid-typeof": "error", 
            "accessor-pairs": [
                "error", 
                {
                    "setWithoutGet": true, 
                    "getWithoutSet": false
                }
            ], 
            "array-callback-return": "warn", 
            "block-scoped-var": "error", 
            "class-methods-use-this": "off", 
            "complexity": [
                "error", 
                {
                    "max": 20
                }
            ], 
            "consistent-return": "off", 
            "curly": [
                "error", 
                "multi-line", 
                "consistent"
            ], 
            "default-case": "off", 
            "dot-location": [
                "error", 
                "property"
            ], 
            "dot-notation": "warn", 
            "eqeqeq": [
                "warn", 
                "always"            
            ], 
            "guard-for-in": "error", 
            "no-alert": "off", 
            "no-caller": "error", 
            "no-case-declarations": "error", 
            "no-div-regex": "off", 
            "no-else-return": [
            "warn", 
                {
                   "allowElseIf": false
                }
            ],
            "no-empty-function": [
                "error", 
                {
                    "allow": [
                        "functions", 
                        "arrowFunctions"
                    ]
                }
            ], 
            "no-empty-pattern": "error", 
            "no-eq-null": "off", 
            "no-eval": "error", 
            "no-extend-native": "error", 
            "no-extra-bind": "error", 
            "no-extra-label": "error", 
            "no-fallthrough": "error", 
            "no-floating-decimal": "error", 
            "no-global-assign": "error", 
            "no-implicit-coercion": "off", 
            "no-implicit-globals": "error", 
            "no-implied-eval": "error", 
            "no-invalid-this": "off", 
            "no-iterator": "warn", 
            "no-labels": "error", 
            "no-lone-blocks": "error", 
            "no-loop-func": "error", 
            "no-magic-numbers": "off", 
            "no-multi-spaces": [
                "error", 
                {
                    "ignoreEOLComments": true, 
                    "exceptions": {
                        "Property": true, 
                        "BinaryExpression": false, 
                        "VariableDeclarator": true, 
                        "ImportDeclaration": true
                    }
                }
            ], 
            "no-multi-str": "error", 
            "no-new": "error", 
            "no-new-func": "error", 
            "no-new-wrappers": "warn", 
            "no-octal": "error", 
            "no-octal-escape": "error", 
            "no-param-reassign": [
            "warn", 
            {
                "props": true,
                "ignorePropertyModificationsFor": [
                  "acc",
                  "accumulator",
                  "e",
                  "ctx",
                  "req",
                  "request",
                  "res",
                  "response",
                  "$scope",
                  "staticContext",
                  "state"
                ]
              }
            ],
            "no-proto": "error", 
            "no-redeclare": "error", 
            "no-restricted-properties": [
            "warn", 
                {
                    "object": "Math",
                    "property": "pow",
                    "message": "Please use ** instand"
                }
            ],
            "no-return-assign": [
                "error", 
                "always"
            ], 
            "no-return-await": "error", 
            "no-script-url": "off", 
            "no-self-assign": "error", 
            "no-self-compare": "error", 
            "no-sequences": "error", 
            "no-throw-literal": "error", 
            "no-unmodified-loop-condition": "error", 
            "no-unused-expressions": [
                "error", 
                {
                    "allowShortCircuit": true, 
                    "allowTernary": true, 
                    "allowTaggedTemplates": true
                }
            ], 
            "no-unused-labels": "error", 
            "no-useless-call": "error", 
            "no-useless-concat": "error", 
            "no-useless-escape": "error", 
            "no-useless-return": "off", 
            "no-void": "error", 
            "no-warning-comments": "off", 
            "no-with": "error", 
            "prefer-promise-reject-errors": "error", 
            "radix": "warn", 
            "require-await": "off", 
            "vars-on-top": "off", 
            "wrap-iife": [
                "error", 
                "outside"
            ], 
            "yoda": [
                "error", 
                "never", 
                {
                    "onlyEquality": true
                }
            ], 
            "strict": [
                "error", 
                "never"
            ], 
            "init-declarations": "off", 
            "no-catch-shadow": "off", 
            "no-delete-var": "error", 
            "no-label-var": "error", 
            "no-restricted-globals": "off", 
            "no-shadow": [
                "error", 
                {
                    "builtinGlobals": false, 
                    "hoist": "functions", 
                    "allow": [
                        "resolve", 
                        "reject", 
                        "done", 
                        "cb", 
                        "callback", 
                        "error", 
                        "err", 
                        "e"
                    ]
                }
            ], 
            "no-shadow-restricted-names": "error", 
            "no-undef": "error", 
            "no-undef-init": "error", 
            "no-undefined": "error", 
            "no-unused-vars": [
                "error",
                {
                  "args": "after-used",
                  "ignoreRestSiblings": true
                }
              ],
            "no-use-before-define": [
                "error", 
                {
                    "functions": false, 
                    "classes": false, 
                    "variables": false
                }
            ], 
            "callback-return": "off", 
            "global-require": "off", 
            "handle-callback-err": "error", 
            "no-buffer-constructor": "error", 
            "no-mixed-requires": "off", 
            "no-new-require": "error", 
            "no-path-concat": "error", 
            "no-process-env": "off", 
            "no-process-exit": "off", 
            "no-restricted-modules": "off", 
            "no-sync": "off", 
            "array-bracket-newline": "off", 
            "array-bracket-spacing": [
                "error", 
                "never"
            ], 
            "array-element-newline": "off", 
            "block-spacing": [
                "error"
            ], 
            "brace-style": "warn", 
            "camelcase": [
                "error", 
                {
                    "ignoreDestructuring": true,
                    "properties": "never",
                    "ignoreImports": false
                }
            ],
            "capitalized-comments": "off", 
            "comma-dangle": [
                "warn",
                "always-multiline"
            ],		
            "comma-spacing": [
                "error", 
                {
                    "before": false, 
                    "after": true
                }
            ], 
            "comma-style": [
                "error", 
                "last"
            ], 
            "computed-property-spacing": [
                "warn", 
                "never"
            ], 
            "consistent-this": "off", 
            "eol-last": [
                "error",
                "always" 
            ],
            "func-call-spacing": [
                "error", 
                "never"
            ], 
            "func-name-matching": [
                "error", 
                "always", 
                {
                    "includeCommonJSModuleExports": false
                }
            ], 
            "function-paren-newline": [
               "warn",
               "multiline"
            ],
            "func-names": "off", 
            "func-style": [
                "warn", 
                "expression"
            ],
            "id-blacklist": "off", 
            "id-length": "off", 
            "implicit-arrow-linebreak": [
                "warn",
                "beside"
            ],
            "indent": [
            "warn",
            2,
            {
                "SwitchCase": 1,
                "VariableDeclarator": 1,
                "outerIIFEBody": 1,
                "FunctionDeclaration": {
                "parameters": 1,
                "body": 1
            },
            "FunctionExpression": {
              "parameters": 1,
              "body": 1
            },
            "CallExpression": {
              "arguments": 1
            },
            "ArrayExpression": 1,
            "ObjectExpression": 1,
            "ImportDeclaration": 1,
            "flatTernaryExpressions": false,
            "ignoredNodes": [
              "JSXElement",
              "JSXElement > *",
              "JSXAttribute",
              "JSXIdentifier",
              "JSXNamespacedName",
              "JSXMemberExpression",
              "JSXSpreadAttribute",
              "JSXExpressionContainer",
              "JSXOpeningElement",
              "JSXClosingElement",
              "JSXFragment",
              "JSXOpeningFragment",
              "JSXClosingFragment",
              "JSXText",
              "JSXEmptyExpression",
              "JSXSpreadChild"
            ],
            "ignoreComments": false
          }
        ],
            "id-match": "off", 
            "space-indent": ["error", 4], 
            "jsx-quotes": [
                "error", 
                "prefer-double"
            ], 
            "key-spacing": [
                "error"
              ],
            "keyword-spacing": [
              "error",
              {
                "overrides": {
                  "if": {
                    "after": true
                  },
                  "for": {
                    "after": true
                  },
                  "while": {
                    "after": true
                  },
                  "else": {
                    "after": true
                  }
                },
                "before": true,
                "after": true
              }
            ],
            "line-comment-position": "off", 
            "linebreak-style": ["error", "unix"], 
            "lines-around-comment": "off", 
            "max-depth": [
                "error", 
                5
            ], 
            "max-len": [
            "error",
               { 
                "code": 120,
                "ignoreStrings": true,
                "ignoreUrls": true,
                "ignoreRegExpLiterals": true,
                 "ignoreTemplateLiterals": true
               }
            ], 
            "max-lines": "off", 
            "max-nested-callbacks": [
                "error", 
                3
            ], 
            "max-params": [
                "error", 
                7
            ], 
            "max-statements": "off", 
            "max-statements-per-line": "off", 
            "multiline-ternary": "off", 
            "new-cap": [
                "error", 
                {
                    "newIsCap": true,
                    "newIsCapExceptions": [],
                    "capIsNew": false,
                    "capIsNewExceptions": [
                      "Immutable.Map",
                      "Immutable.Set",
                      "Immutable.List"
                    ],
                    "properties": false
                  }
            ], 
            "new-parens": "error", 
            "newline-per-chained-call": [
            "warn",
                {
                    "ignoreChainWithDepth": 2
                }		
            ],
            "no-array-constructor": "error", 
            "no-bitwise": "off", 
            "no-continue": "off", 
            "no-inline-comments": "off", 
            "no-lonely-if": "off", 
            "no-mixed-operators": [
            "error", 
            {
                "groups": [
                  [
                    "%",
                    "**"
                  ],
                  [
                    "%",
                    "+"
                  ],
                  [
                    "%",
                    "-"
                  ],
                  [
                    "%",
                    "*"
                  ],
                  [
                    "%",
                    "/"
                  ],
                  [
                    "/",
                    "*"
                  ],
                  [
                    "&",
                    "|",
                    "<<",
                    ">>",
                    ">>>"
                  ],
                  [
                    "==",
                    "!=",
                    "===",
                    "!=="
                  ],
                  [
                    "&&",
                    "||"
                  ]
                ],
                "allowSamePrecedence": false
              }
            ],
            "no-mixed-spaces-and-tabs": "error", 
            "no-multi-assign": "error", 
            "no-multiple-empty-lines": "error", 
            "no-negated-condition": "off", 
            "no-nested-ternary": "warn", 
            "no-new-object": "error", 
            "no-plusplus": [
            "error", 
                {
                     "allowForLoopAfterthoughts": true
                }
            ],
            "no-restricted-syntax": [
              "warn",
                {
                    "selector": "ForInStatement",
                    "message": "for..in loops iterate over the entire prototype chain, which is virtually never what you want. Use Object.{keys,values,entries}, and iterate over the resulting array."
                },
                {
                    "selector": "ForOfStatement",
                    "message": "iterators/generators require regenerator-runtime, which is too heavyweight for this guide to allow them. Separately, loops should be avoided in favor of array iterations."
                },
                {
                    "selector": "LabeledStatement",
                    "message": "Labels are a form of GOTO; using them makes code confusing and hard to maintain and understand."
                },
                {
                    "selector": "WithStatement",
                    "message": "`with` is disallowed in strict mode because it makes code impossible to predict and optimize."
                }		
            ],
            "no-tabs": "error", 
            "no-ternary": "off", 
            "no-trailing-spaces": "error", 
            "no-underscore-dangle": "warn", 
            "no-unneeded-ternary": "warn", 
            "no-whitespace-before-property": "warn", 
            "nonblock-statement-body-position": [
                "error", 
                "beside"
            ], 
            "object-curly-newline": [
                "error", 
                {
                    "multiline": true, 
                    "consistent": true
                }
            ], 
            "object-curly-spacing": [
                "warn", 
                "always"
            ], 
            "object-property-newline": "off", 
            "one-var": [
                "warn", 
                "never"
            ], 
            "one-var-declaration-per-line": [
                "error", 
                "always"
            ], 
            "operator-assignment": "off", 
            "operator-linebreak":  [
                "error",
                "before",
                {
                    "overrides": {
                        "=": "none"
                    }
                }
            ],
            "padded-blocks": [
                "error",
                "never"
            ], 
            "padding-line-between-statements": "off", 
            "quote-props": [
            "error",
            "as-needed",
                {
                    "keywords": false
                }
            ], 
            "quotes": [
                "warn", 
                "single", 
                {              
                    "allowTemplateLiterals": false
                }
            ], 
            "require-jsdoc": "off", 
            "semi": [
                "error", 
                "always"
            ], 
            "semi-spacing": [
                "error", 
                {
                    "before": false, 
                    "after": true
                }
            ], 
            "semi-style": [
                "error", 
                "last"
            ], 
            "sort-keys": "off", 
            "sort-vars": "off", 
            "space-before-blocks": [
                "error"          
            ], 
            "space-before-function-paren": [
                "error", 
                {
                    "anonymous": "always", 
                    "named": "never", 
                    "asyncArrow": "always"
                }
            ], 
            "space-in-parens": [
                "error", 
                "never"
            ], 
            "space-infix-ops": "error", 
            "space-unary-ops": [
                "error", 
                {
                    "words": true, 
                    "nonwords": false
                }
            ], 
            "spaced-comment": [
                "error", 
                "always"           
            ], 
            "switch-colon-spacing": [
                "error", 
                {
                    "after": true, 
                    "before": false
                }
            ], 
            "template-tag-spacing": [
                "error", 
                "never"
            ], 
            "unicode-bom": [
                "error", 
                "never"
            ], 
            "wrap-regex": "off", 
            "arrow-body-style": [
                "warn",
                "as-needed"
            ],		
            "arrow-parens": [
               "warn",
               "as-needed",
               {
                    "requireForBlockBody": true			   
                }		
            ],
            "arrow-spacing": [
                "warn"         
            ], 
            "constructor-super": "error", 
            "generator-star-spacing": [
                "warn", 
                {
                    "before": false, 
                    "after": true
                }
            ], 
            "no-class-assign": "error", 
            "no-confusing-arrow": "warn", 
            "no-const-assign": "error", 
            "no-dupe-class-members": "error", 
            "no-duplicate-imports": [  
            "error", 
                {
                    "includeExports": true
                }
            ],
            "no-new-symbol": "error", 
            "no-restricted-imports": "off", 
            "no-this-before-super": "error", 
            "no-useless-computed-key": "error", 
            "no-useless-constructor": "warn", 
            "no-useless-rename": "error", 
            "no-var": "error", 
            "object-shorthand": "warn", 
            "prefer-arrow-callback": "warn", 
            "prefer-const": [
            "error",
                {
                    "destructuring": "any",
                    "ignoreReadBeforeAssign": false
                }
            ], 
            "prefer-destructuring": [
             "warn",
             {
                "VariableDeclarator": {
                  "array": false,
                  "object": true
                },
                "AssignmentExpression": {
                  "array": true,
                  "object": false
                }
              },
              {
                "enforceForRenamedProperties": false
              }
            ], 
            "prefer-numeric-literals": "off", 
            "prefer-rest-params": "warn", 
            "prefer-spread": "warn", 
            "prefer-template": "error", 
            "require-yield": "error", 
            "rest-spread-spacing": [
                "error", 
                "never"
            ], 
            "sort-imports": "off", 
            "symbol-description": "error", 
            "template-curly-spacing": [
                "error", 
                "never"
            ], 
            "yield-star-spacing": [
                "error", 
                "after"
            ]
        }
      }
    ],
    "plugins": [
        "react",
        "vue"
    ]
}
