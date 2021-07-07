def runChecker(filePath, codeLineObj, errorHandler, option_info):
	for line in range(1, len(codeLineObj.raw_lines)):
 		if ('require' in codeLineObj.raw_lines[line]) or ('optional' in codeLineObj.raw_lines[line]):
			if 'Des' not in codeLineObj.raw_lines[line]:
				errorHandler(filePath, line, 'build/jce_comment', 'should contains Des tags')
			if 'SuggestInput' not in codeLineObj.raw_lines[line]:
				errorHandler(filePath, line, 'build/jce_comment', 'should contains SuggestInput tags')