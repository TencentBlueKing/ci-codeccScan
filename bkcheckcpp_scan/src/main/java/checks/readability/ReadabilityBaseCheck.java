package checks.readability;


import common.BaseCheck;
import common.DefectMessage;
import common.ProperName;
import org.antlr.v4.runtime.ParserRuleContext;
import parser.CPP14Parser;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author camelxiao
 * @version V2.0
 * @date 2020/3/27
 */
public class ReadabilityBaseCheck extends BaseCheck
{

    public Pattern getCasePattern(String caseName)
    {
        switch (caseName)
        {
            case "UPPER_CASE":
                return Pattern.compile("[A-Z_][A-Z0-9_]*");

            case "LOWER_CASE":
                return Pattern.compile("[a-z_][a-z0-9_]*");

            case "CamelCase":
                return Pattern.compile("[A-Z][a-zA-Z0-9_]*");

            case "camelBack":
                return Pattern.compile("[a-z][a-zA-Z0-9_]*");

            case "CamelCaseWithoutUnderscore":
                return Pattern.compile("[A-Z][a-zA-Z0-9]*");

            case "LOWER_CASE_WITH_SUBFIX_UNDERSCORE":
                return Pattern.compile("[a-z0-9_]*_");
        }

        return null;
    }

    public boolean matchTree(ParserRuleContext ctx, String tree)
    {
        List<String> nodes = Arrays.asList(tree.split("\\."));
        Collections.reverse(nodes);
        //System.out.println(new Gson().toJson(nodes));

        for (String expectedNode : nodes)
        {
            String treeNode = getTreeNodeName(ctx);
            //System.out.println(String.format("expNode:%s, treeNode:%s", expectedNode, treeNode));
            if (expectedNode.equals(treeNode) == false)
            {
                return false;
            }
            ctx = ctx.getParent();
        }
        return true;
    }

    private String getTreeNodeName(ParserRuleContext ctx)
    {
        return CPP14Parser.ruleNames[ctx.getRuleIndex()];
    }

    protected void checkNamingStyle(String nameToBeChecked, int line, String caseStyle, String checkerName)
    {
        if(isProperNoun(nameToBeChecked))
        {
            return;
        }

        if (nameToBeChecked.matches(getCasePattern(caseStyle).pattern()) == false)
        {
            DefectMessage msg = new DefectMessage();
            msg.setLineNo(line);
            msg.setCheckerName(checkerName);
            msg.setFilePath(getFilePath());
            msg.setMessage(String.format("\'%s\' 的命名风格不符合配置值:%s", nameToBeChecked, caseStyle));
            this.addMessage(msg);
        }
    }

    protected void checkNamingRegex(String nameToBeChecked, int line, String regexStyle, String checkerName)
    {
        if(isProperNoun(nameToBeChecked))
        {
            return;
        }

        if (nameToBeChecked.matches(regexStyle) == false)
        {
            DefectMessage msg = new DefectMessage();
            msg.setLineNo(line);
            msg.setCheckerName(checkerName);
            msg.setFilePath(getFilePath());
            msg.setMessage(String.format("\'%s\' 的命名风格不符合配置值:%s", nameToBeChecked, regexStyle));
            this.addMessage(msg);
        }
    }

    private boolean isProperNoun(String nameToBeChecked)
    {
        for(String prefix : ProperName.getProperNameList())
        {
            if(nameToBeChecked.startsWith(prefix))
            {
                return true;
            }
        }

        return false;
    }

}

