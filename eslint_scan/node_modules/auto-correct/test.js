var assert = require('assert');
var correct = require('./');

assert(correct('install', 'install'));
assert(correct('istall', 'install'));
assert(correct('instal', 'install'));
assert(correct('insatll', 'install'));
assert(correct('isntall', 'install'));

assert(!correct('insta', 'install'));
assert(!correct('inastll', 'install'));
assert(!correct('isntal', 'install'));
