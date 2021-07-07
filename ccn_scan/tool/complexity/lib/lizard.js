module.exports = function lizardReport(report) {
    return report.map(rule => [
        rule.nloc || rule.length, // nloc
        rule.ccn || '', // ccn
        '', // token
        0, // param
        rule.length, // length
        JSON.stringify(rule.location), // location
        JSON.stringify(rule.path), // path
        JSON.stringify(rule.name), // name
        JSON.stringify(`${rule.name}()`), // long name
        rule.start, // start line
        rule.end, // end line
    ].join(',')).join('\n');
}
