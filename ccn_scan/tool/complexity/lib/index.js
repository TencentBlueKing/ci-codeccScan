#!/usr/bin/env node
const arg = require('arg');
const pkg = require('../package.json');
const help = require('./help');
const getResults = require('./main');
const getReport = require('./report');
const lizardReport = require('./lizard');

const args = arg({
    // flags
	'--help': Boolean,
    '--version': Boolean,
    '--typescript': Boolean,
    '--javascript': Boolean,
    '--threshold': Number,
    '--exclude': [String],
    '--output': String,
    // alias
    '-h': '--help',
    '-v': '--version',
    '-t': '--typescript',
    '-j': '--javascript',
    '-c': '--threshold',
    '-e': '--exclude',
    '-o': '--output',
});

const files = args._;

if (args['--help']) {
    help();
    process.exit(0);
}
if (args['--version']) {
    console.log(pkg.version);
    process.exit(0);
}

if (files.length <= 0) {
    console.error('Files not specified');
    process.exit(1);
}

const result = getResults(args);
const report = getReport(result);
if (args['--output'] === 'json') {
    console.log(report);
} else {
    console.log(lizardReport(report));
}
