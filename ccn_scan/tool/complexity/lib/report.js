function flat(arr, d = 1) {
    return d > 0
        ? arr.reduce((acc, val) => acc.concat(Array.isArray(val)
            ? flat(val, d - 1)
            : val
        ), [])
        : arr.slice();
}

module.exports = function getReport(results) {
    const report = results.map(result => {
        // const ccn = result.messages;
        return result.messages
            .filter(rule => rule.ruleId == 'complexity')
            .map((rule) => {
                const [_, name, __, complexity] = rule.message.match(/(\S+) has(\D+)of (\d+)/);
                const funcName = name.replace(/'/g, '');
                const info = {
                    // nloc: 0,
                    ccn: complexity >> 0,
                    // param: 0,
                    length: rule.endLine - rule.line + 1,
                    location: `${funcName}@${rule.line}-${rule.endLine}@${result.filePath}`,
                    path: result.filePath,
                    name: funcName,
                    // signature: 0,
                    start: rule.line,
                    end: rule.endLine,
                };
                return info;
            });
    });
    return flat(report, 2);
}
