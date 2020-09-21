import cpplint
import sys
import getopt
import codecs
import os
import imp

currFilePath = ''
thirdRuleSet = []
filter_list = []
checkers_options = {}

cpplint._USAGE = """
Syntax: cpplint_external.py [--verbose=#] [--output=emacs|eclipse|vs7|junit|codecc]
                   [--filter=-x,+y,...]
                   [--cfg=-config_path]
                   [--third-rule-path=-third_rules_path]
                   [--counting=total|toplevel|detailed] [--root=subdir]
                   [--repository=path]
                   [--linelength=digits] [--headers=x,y,...]
                   [--recursive]
                   [--exclude=path]
                   [--extensions=hpp,cpp,...]
                   [--quiet]
                   [--version]
        <file> [file] ...

  Style checker for C/C++ source files.
  This is a fork of the Google style checker with minor extensions.

  The style guidelines this tries to follow are those in
    https://google.github.io/styleguide/cppguide.html

  Every problem is given a confidence score from 1-5, with 5 meaning we are
  certain of the problem, and 1 meaning it could be a legitimate construct.
  This will miss some errors, and is not a substitute for a code review.

  To suppress false-positive errors of a certain category, add a
  'NOLINT(category)' comment to the line.  NOLINT or NOLINT(*)
  suppresses errors of all categories on that line.

  The files passed in will be linted; at least one file must be provided.
  Default linted extensions are %s.
  Other file types will be ignored.
  Change the extensions with the --extensions flag.

  Flags:

    output=emacs|eclipse|vs7|junit
      By default, the output is formatted to ease emacs parsing.  Visual Studio
      compatible output (vs7) may also be used.  Further support exists for
      eclipse (eclipse), and JUnit (junit). XML parsers such as those used
      in Jenkins and Bamboo may also be used.  Other formats are unsupported.

    verbose=#
      Specify a number 0-5 to restrict errors to certain verbosity levels.
      Errors with lower verbosity levels have lower confidence and are more
      likely to be false positives.

    quiet
      Don't print anything if no errors are found.

    filter=-x,+y,...
      Specify a comma-separated list of category-filters to apply: only
      error messages whose category names pass the filters will be printed.
      (Category names are printed with the message and look like
      "[whitespace/indent]".)  Filters are evaluated left to right.
      "-FOO" and "FOO" means "do not print categories that start with FOO".
      "+FOO" means "do print categories that start with FOO".

      Examples: --filter=-whitespace,+whitespace/braces
                --filter=whitespace,runtime/printf,+runtime/printf_format
                --filter=-,+build/include_what_you_use

      To see a list of all the categories used in cpplint, pass no arg:
         --filter=

    counting=total|toplevel|detailed
      The total number of errors found is always printed. If
      'toplevel' is provided, then the count of errors in each of
      the top-level categories like 'build' and 'whitespace' will
      also be printed. If 'detailed' is provided, then a count
      is provided for each category like 'build/class'.

    repository=path
      The top level directory of the repository, used to derive the header
      guard CPP variable. By default, this is determined by searching for a
      path that contains .git, .hg, or .svn. When this flag is specified, the
      given path is used instead. This option allows the header guard CPP
      variable to remain consistent even if members of a team have different
      repository root directories (such as when checking out a subdirectory
      with SVN). In addition, users of non-mainstream version control systems
      can use this flag to ensure readable header guard CPP variables.

      Examples:
        Assuming that Alice checks out ProjectName and Bob checks out
        ProjectName/trunk and trunk contains src/chrome/ui/browser.h, then
        with no --repository flag, the header guard CPP variable will be:

        Alice => TRUNK_SRC_CHROME_BROWSER_UI_BROWSER_H_
        Bob   => SRC_CHROME_BROWSER_UI_BROWSER_H_

        If Alice uses the --repository=trunk flag and Bob omits the flag or
        uses --repository=. then the header guard CPP variable will be:

        Alice => SRC_CHROME_BROWSER_UI_BROWSER_H_
        Bob   => SRC_CHROME_BROWSER_UI_BROWSER_H_

    root=subdir
      The root directory used for deriving header guard CPP variable.
      This directory is relative to the top level directory of the repository
      which by default is determined by searching for a directory that contains
      .git, .hg, or .svn but can also be controlled with the --repository flag.
      If the specified directory does not exist, this flag is ignored.

      Examples:
        Assuming that src is the top level directory of the repository (and
        cwd=top/src), the header guard CPP variables for
        src/chrome/browser/ui/browser.h are:

        No flag => CHROME_BROWSER_UI_BROWSER_H_
        --root=chrome => BROWSER_UI_BROWSER_H_
        --root=chrome/browser => UI_BROWSER_H_
        --root=.. => SRC_CHROME_BROWSER_UI_BROWSER_H_

    linelength=digits
      This is the allowed line length for the project. The default value is
      80 characters.

      Examples:
        --linelength=120

    recursive
      Search for files to lint recursively. Each directory given in the list
      of files to be linted is replaced by all files that descend from that
      directory. Files with extensions not in the valid extensions list are
      excluded.

    exclude=path
      Exclude the given path from the list of files to be linted. Relative
      paths are evaluated relative to the current directory and shell globbing
      is performed. This flag can be provided multiple times to exclude
      multiple files.

      Examples:
        --exclude=one.cc
        --exclude=src/*.cc
        --exclude=src/*.cc --exclude=test/*.cc

    extensions=extension,extension,...
      The allowed file extensions that cpplint will check

      Examples:
        --extensions=%s

    headers=x,y,...
      The header extensions that cpplint will treat as .h in checks. Values are
      automatically added to --extensions list.
     (by default, only files with extensions %s will be assumed to be headers)

      Examples:
        --headers=%s
        --headers=hpp,hxx
        --headers=hpp

    cpplint.py supports per-directory configurations specified in CPPLINT.cfg
    files. CPPLINT.cfg file can contain a number of key=value pairs.
    Currently the following options are supported:

      set noparent
      filter=+filter1,-filter2,...
      exclude_files=regex
      linelength=80
      root=subdir
      headers=x,y,...

    "set noparent" option prevents cpplint from traversing directory tree
    upwards looking for more .cfg files in parent directories. This option
    is usually placed in the top-level project directory.

    The "filter" option is similar in function to --filter flag. It specifies
    message filters in addition to the |_DEFAULT_FILTERS| and those specified
    through --filter command-line flag.

    "exclude_files" allows to specify a regular expression to be matched against
    a file name. If the expression matches, the file is skipped and not run
    through the linter.

    "linelength" allows to specify the allowed line length for the project.

    The "root" option is similar in function to the --root flag (see example
    above). Paths are relative to the directory of the CPPLINT.cfg.

    The "headers" option is similar in function to the --headers flag
    (see example above).

    CPPLINT.cfg has an effect on files in the same directory and all
    sub-directories, unless overridden by a nested configuration file.

      Example file:
        filter=-build/include_order,+build/include_alpha
        exclude_files=.*\\.cc

    The above example disables build/include_order warning and enables
    build/include_alpha as well as excludes all .cc from being
    processed by linter, in the current directory (where the .cfg
    file is located) and all sub-directories.
"""

def ParseArguments(args):
  """Parses the command line arguments.

  This may set the output format and verbosity level as side-effects.

  Args:
    args: The command line arguments:

  Returns:
    The list of filenames to lint.
  """
  try:
    (opts, filenames) = getopt.getopt(args, '', ['help', 'output=', 'verbose=',
                                                 'v=',
                                                 'version',
                                                 'counting=',
                                                 'filter=',
                                                 'cfg=',
                                                 'third-rule-path=',
                                                 'root=',
                                                 'repository=',
                                                 'linelength=',
                                                 'extensions=',
                                                 'exclude=',
                                                 'recursive',
                                                 'headers=',
                                                 'quiet'])
  except getopt.GetoptError:
    cpplint.PrintUsage('Invalid arguments.')

  verbosity = cpplint._VerboseLevel()
  output_format = cpplint._OutputFormat()
  filters = ''
  quiet = cpplint._Quiet()
  counting_style = ''
  recursive = False

  for (opt, val) in opts:
    if opt == '--help':
      cpplint.PrintUsage(None)
    if opt == '--version':
      cpplint.PrintVersion()
    elif opt == '--output':
      if val not in ('emacs', 'vs7', 'eclipse', 'junit', 'codecc'):
        cpplint.PrintUsage('The only allowed output formats are emacs, vs7, eclipse, codecc '
                   'and junit.')
      output_format = val
    elif opt == '--quiet':
      quiet = True
    elif opt == '--verbose' or opt == '--v':
      verbosity = int(val)
    elif opt == '--filter':
      filters = val
      if not filters:
        cpplint.PrintCategories()
    elif opt == '--cfg':
      filters = config_fliter(val)
      if not filters:
        cpplint.PrintCategories()
    elif opt == '--third-rule-path':
      global thirdRuleSet
      thirdRuleSet = third_rules_set(val)
    elif opt == '--counting':
      if val not in ('total', 'toplevel', 'detailed'):
        cpplint.PrintUsage('Valid counting options are total, toplevel, and detailed')
      counting_style = val
    elif opt == '--root':
      cpplint._root = val
    elif opt == '--repository':
      cpplint._repository = val
    elif opt == '--linelength':
      try:
        cpplint._line_length = int(val)
      except ValueError:
        cpplint.PrintUsage('Line length must be digits.')
    elif opt == '--exclude':
      if not cpplint._excludes:
        cpplint._excludes = set()
      cpplint._excludes.update(glob.glob(val))
    elif opt == '--extensions':
      try:
        cpplint._valid_extensions = set(val.split(','))
      except ValueError:
        cpplint.PrintUsage('Extensions must be comma seperated list.')
    elif opt == '--headers':
      cpplint.ProcessHppHeadersOption(val)
    elif opt == '--recursive':
      recursive = True

  if not filenames:
    cpplint.PrintUsage('No files were specified.')

  if recursive:
    filenames = cpplint._ExpandDirectories(filenames)

  if cpplint._excludes:
    filenames = cpplint._FilterExcludedFiles(filenames)

  cpplint._SetOutputFormat(output_format)
  cpplint._SetQuiet(quiet)
  cpplint._SetVerboseLevel(verbosity)
  cpplint._SetFilters(filters)
  cpplint._SetCountingStyle(counting_style)
  return filenames

def config_fliter(cfg_path):
  global filter_list
  if os.path.exists(cfg_path):
    with open(cfg_path, 'r') as file:
      lines = file.readlines()
      for line in lines:
        line_array = line.strip().split('#')
        if len(line_array) > 1:
          checkers_options[line_array[0][1:]] = line_array[1]
        filter_list.append(line_array[0])
  return ','.join(filter_list)

def thirdError(filename,linenum, checkerName, message):
    Error(filename, linenum, checkerName, 1, message)

def third_rules_set(third_rule_path):
  ruleSet = []
  if os.path.exists(third_rule_path) and os.path.isdir(third_rule_path):
    for file in os.listdir(third_rule_path):
      file_path = os.path.join(third_rule_path, file)
      if os.path.isfile(file_path) and file_path.endswith('.py'):
        filename = os.path.splitext(file)[0]
        str_list = filename.split('_', 1)
        rule = '/'.join(str_list)
        if '+'+rule in filter_list:
          ruleSet.append(file_path)
  return ruleSet

def Error(filename, linenum, category, confidence, message):
  """Logs the fact we've found a lint error.

  We log where the error was found, and also our confidence in the error,
  that is, how certain we are this is a legitimate style regression, and
  not a misidentification or a use that's sometimes justified.

  False positives can be suppressed by the use of
  "cpplint(category)"  comments on the offending line.  These are
  parsed into _error_suppressions.

  Args:
    filename: The name of the file containing the error.
    linenum: The number of the line containing the error.
    category: A string used to describe the "category" this bug
      falls under: "whitespace", say, or "runtime".  Categories
      may have a hierarchy separated by slashes: "whitespace/indent".
    confidence: A number from 1-5 representing a confidence score for
      the error, with 5 meaning that we are certain of the problem,
      and 1 meaning that it could be a legitimate construct.
    message: The error message.
  """
  if cpplint._ShouldPrintError(category, confidence, linenum):
    cpplint._cpplint_state.IncrementErrorCount(category)
    if cpplint._cpplint_state.output_format == 'vs7':
      cpplint._cpplint_state.PrintError('%s(%s): error cpplint: [%s] %s [%d]\n' % (
          filename, linenum, category, message, confidence))
    elif cpplint._cpplint_state.output_format == 'codecc':
      sys.stderr.write('%s->%s->%s->%s\n' % (filename, linenum, category, message))
    elif cpplint._cpplint_state.output_format == 'eclipse':
      sys.stderr.write('%s:%s: warning: %s  [%s] [%d]\n' % (
          filename, linenum, message, category, confidence))
    elif cpplint._cpplint_state.output_format == 'junit':
      cpplint._cpplint_state.AddJUnitFailure(filename, linenum, message, category,
          confidence)
    else:
      final_message = '%s:%s:  %s  [%s] [%d]\n' % (
          filename, linenum, message, category, confidence)
      sys.stderr.write(final_message)

def get_lines_for_filename(filename):
  lines = []
  if filename == '-':
    lines = codecs.StreamReaderWriter(sys.stdin,
                                      codecs.getreader('utf8'),
                                      codecs.getwriter('utf8'),
                                      'replace').read().split('\n')
  else:
    lines = codecs.open(filename, 'r', 'utf8', 'replace').read().split('\n')
  
  for linenum in range(len(lines) - 1):
    if lines[linenum].endswith('\r'):
      lines[linenum] = lines[linenum].rstrip('\r')
  
  lines = (['// marker so line numbers and indices both start at 1'] + lines +
         ['// marker so line numbers end in a known way'])
  return lines

if __name__ == '__main__':
  filenames = ParseArguments(sys.argv[1:])
  cpplint.Error = Error
  backup_err = sys.stderr
  try:
    # Change stderr to write with replacement characters so we don't die
    # if we try to print something containing non-ASCII characters.
    sys.stderr = codecs.StreamReader(sys.stderr, 'replace')
    cpplint._cpplint_state.ResetErrorCounts()
    for filename in filenames:
      cpplint.ProcessFile(filename, cpplint._cpplint_state.verbose_level)
      for rule in thirdRuleSet:
          third_checker = imp.load_source("", rule)
          tempfilename = os.path.split(rule)[1]
          rule_file_name = os.path.splitext(tempfilename)[0]
          str_list = rule_file_name.split('_', 1)
          rule_name = '/'.join(str_list)
          option_info = []
          if rule_name in checkers_options:
            option_info = checkers_options[rule_name]
          currFilePath = filename
          plugin_clean_lines = cpplint.CleansedLines(get_lines_for_filename(filename))
          third_checker.runChecker(filename, plugin_clean_lines, thirdError, option_info)
    # If --quiet is passed, suppress printing error count unless there are errors.
    if not cpplint._cpplint_state.quiet or cpplint._cpplint_state.error_count > 0:
      cpplint._cpplint_state.PrintErrorCounts()

    if cpplint._cpplint_state.output_format == 'junit':
      sys.stderr.write(cpplint._cpplint_state.FormatJUnitXML())

  finally:
    sys.stderr = backup_err

  sys.exit(cpplint._cpplint_state.error_count > 0)
