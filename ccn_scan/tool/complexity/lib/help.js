module.exports = function help() {
    console.log(`Usages:
    complexity [--options] files

Options:
    --help, -h: Print Help information
    --version, -v: Print version
    --typescript, -t: Scan typescript files only, defaults false
    --javascript, -j: Scan javascript files only, defaults false
    --threshold: Cyclomatic complexity limit
    --output: Output format, default is lizard-like csv
    --exclude: Ignore Patterns.
`);
}
