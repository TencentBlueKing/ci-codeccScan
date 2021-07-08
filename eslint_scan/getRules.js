const base = require('@tencent/eslint-config-tencent/base')
const jsRules = base.rules

const ts = require('@tencent/eslint-config-tencent/ts')
const tsRules = {...jsRules, ...ts.rules}

// console.log(JSON.stringify(jsRules))
console.log(JSON.stringify(tsRules))