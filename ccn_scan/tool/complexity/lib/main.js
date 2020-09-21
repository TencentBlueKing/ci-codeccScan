const CLIEngine = require('eslint').CLIEngine;
const path = require('path');

function resolve(pattern) {
    return path.resolve(process.cwd(), pattern);
}

module.exports = function getResults(options) {
    const threshold = options['--threshold'] !== null
        && options['--threshold'] !== undefined
        && options['--threshold'] >= 0
        ? options['--threshold']
        : 20;
    const cliOptions = {
        useEslintrc: false,
        parser: "@typescript-eslint/parser",
        rules: {
            complexity: ['error', threshold],
        },
        cwd: __dirname,
        allowInlineConfig: false,
        env: {
            es6: true,
        },
        parserOptions: {
            ecmaVersion: 2020,
            sourceType: 'module',
            ecmaFeatures: {
                jsx: true
            },
        },
        extensions: ['.js', '.ts', '.tsx', '.jsx'],
        ignorePattern: options['--exclude'],
    };

    if (options['--typescript']) {
        cliOptions.extensions = ['.ts', '.tsx']
    } else if (options['--javascript']) {
        cliOptions.extensions = ['.js', '.jsx']
    }
    const cli = new CLIEngine(cliOptions);

    var report = cli.executeOnFiles(options._.map(resolve));
    return report.results.filter(x => x.errorCount > 0);
}
