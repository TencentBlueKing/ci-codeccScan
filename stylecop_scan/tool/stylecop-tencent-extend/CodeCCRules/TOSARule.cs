using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Linq;

namespace CodeCCRules
{
    using StyleCop;
    using StyleCop.CSharp;

    [SourceAnalyzer(typeof(CsParser))]
    public class TOSARule : SourceAnalyzer
    {
        internal const string LineLength = "LineLength";
        internal const string FunctionNameLength = "FunctionNameLength";
        internal const string SpaceIndentationLength = "SpaceIndentationLength";
        internal const string MinimumCommentRatio= "MinimumCommentRatio";
        

        private int lineLenghtValue = 100;
        private int functionNameLengthValue = 35;
        private int spaceIndentLengthValue = 4;    
        private double minimumCommentRatioValue = 20;

        
        private void CheckTOSASetting(CsDocument document)
        {
            IntProperty lineLengthSetting = this.GetSetting(document.Settings, TOSARule.LineLength) as IntProperty;
            if (lineLengthSetting != null)
            {
                lineLenghtValue = lineLengthSetting.Value;
            }

            IntProperty FunctionNameLengthSetting =
                document.Settings.GetAddInSetting(this, TOSARule.FunctionNameLength) as IntProperty;
            if (FunctionNameLengthSetting != null)
            {
                functionNameLengthValue = FunctionNameLengthSetting.Value;
            }
            
            IntProperty spaceIndentationSetting = this.GetSetting(document.Settings, SpaceIndentationLength) as IntProperty;
            if (spaceIndentationSetting != null)
            {
                spaceIndentLengthValue = spaceIndentationSetting.Value;
            }

            IntProperty minimumCommentRatioSetting = this.GetSetting(document.Settings, MinimumCommentRatio) as IntProperty;
            if (minimumCommentRatioSetting != null)
            {
                minimumCommentRatioValue = minimumCommentRatioSetting.Value;
            }
        }


        public override void AnalyzeDocument(CodeDocument currentCodeDocument)
        {
            Param.RequireNotNull(currentCodeDocument, "currentCodeDocument");

            Console.WriteLine("Using CodeCCRule");
            var codeDocument = (CsDocument) currentCodeDocument;

            CheckTOSASetting(codeDocument);

            if (codeDocument.RootElement != null && !codeDocument.RootElement.Generated)
            {
                // 把这个作为参数，避免AnalyzeDocument多线程运行时的问题。
                string[] sourceLines = ReadSoureCodeLines(codeDocument.SourceCode);

                try
                {
                    CheckHeaderComment(codeDocument);
                    CheckFileEncoding(codeDocument);
                    CheckNewLine(codeDocument);
                    CheckCommentRatio(codeDocument, sourceLines);
                    CheckIndentation(codeDocument, sourceLines);
                    codeDocument.WalkDocument(new CodeWalkerElementVisitor<object>(this.InspectCurrentElement), null,
                        null);
                }
                catch (Exception e)
                {
                    Console.WriteLine(e);
                }
                
                CheckLineLength(codeDocument, sourceLines);
            }
            //Console.WriteLine("header text[begin]:" + codeDocument.FileHeader.HeaderText + "[end]");
        }

        private string[] ReadSoureCodeLines(SourceCode code)
        {
            List<string> lines = new List<string>();

            using (TextReader reader = code.Read())
            {
                if (reader != null)
                {
                    string line = String.Empty;
                    while ((line = reader.ReadLine()) != null)
                    {
                        lines.Add(line);
                    }
                }
            }

            return lines.ToArray();
        }

        private void CheckLineLength(CsDocument document, string[] sourceLines)
        {
            int count = 1;
            
            foreach (string srcLine in sourceLines)
            {
                if (srcLine.Length > lineLenghtValue)
                {
                    this.AddViolation(document.RootElement, count, "TOSALineLength", lineLenghtValue);
                }

                count++;
            }
        }


        private void CheckHeaderComment(CsDocument csDocument)
        {
            string headerText = csDocument.FileHeader.HeaderText;
            if (headerText == "" ||
                !headerText.Contains("Tencent is pleased to support the open source community by making"))
            {
                this.AddViolation(csDocument.RootElement, 1, "TOSAFileShouldHaveLicenseInfo");
            }
        }

        private void CheckFileEncoding(CsDocument csDocument)
        {
            using (StreamReader sr = new StreamReader(csDocument.SourceCode.Path, true))
            {
                while (sr.Peek() >= 0)
                {
                    sr.Read();
                }

                //Test for the encoding after reading, or at least
                //after the first read.
                //Console.WriteLine("The encoding used was {0}.", sr.CurrentEncoding.CodePage);
                //Console.WriteLine(sr.CurrentEncoding.HeaderName);
                if (sr.CurrentEncoding.HeaderName != "utf-8")
                {
                    this.AddViolation(csDocument.RootElement, 1, "TOSAFileEncodingUTF8");
                }
            }
        }

        private void CheckNewLine(CsDocument csDocument)
        {
            var objReader = csDocument.SourceCode.Read();
            int code;
            while ((code = objReader.Read()) != -1)
            {
                if (code == 13)
                {
                    this.AddViolation(csDocument.RootElement, 1, "TOSAFileHasCR");
                    break;
                }
            }
        }

        private bool InspectCurrentElement(CsElement element, CsElement parentElement, object context)
        {
            //Console.WriteLine(">> " + element.Name + ", " + element.ElementType);

            if (element.ElementType == ElementType.Method)
            {
                Method method = (Method) element;
                if (method.FindParentElement().ElementType == ElementType.Interface)
                {
                    string methodName = method.Name.Split(' ')[1];
                    if (methodName.Length > functionNameLengthValue)
                    {
                        this.AddViolation(element, element.LineNumber, "TOSAFunctionNameLength",
                            functionNameLengthValue);
                    }
                }
            }

            return true;
        }

        private void FlattenCodeLocation(CodeLocation loc, HashSet<int> hashSet)
        {
            for (int i = 0; i < loc.LineSpan; i++)
            {
                hashSet.Add(loc.LineNumber + i);
            }
        }

        private int CountCommentLines(DocumentRoot root)
        {   
            Param.AssertNotNull(root, "root");

            HashSet<int> commentLineNoSet = new HashSet<int>();

            if (root.Tokens != null)
            {
                foreach (CsToken token in root.Tokens)
                {
                    switch (token.CsTokenType)
                    {
                        case CsTokenType.SingleLineComment:
                            commentLineNoSet.Add(token.LineNumber);
                            break;
                        case CsTokenType.MultiLineComment:
                            FlattenCodeLocation(token.Location, commentLineNoSet);
                            break;
                        case CsTokenType.XmlHeader:
                            FlattenCodeLocation(token.Location, commentLineNoSet);
                            break;
                    }
                }
            }

            return commentLineNoSet.Count();
        }

        private void CheckCommentRatio(CsDocument csDocument, string[] sourceLines)
        {
            int commentLineCount = CountCommentLines(csDocument.RootElement);
            int blankLineCount = 0;
            int totalLineCount = 0;

            foreach (var line in sourceLines)
            {
                totalLineCount += 1;

                if (line.Trim().Equals(String.Empty))
                {
                    blankLineCount += 1;
                }
            }

            var codeLineCount = totalLineCount - blankLineCount;
            if (codeLineCount > 0)
            {
                var commentRatio = 1.0 * commentLineCount / codeLineCount * 100;
                if (commentRatio < minimumCommentRatioValue)
                {
//                    Console.WriteLine("Comment ratio {0:0.00}% less than {1:0.00}%", commentRatio, minimumCommentRatioValue);
                    this.AddViolation(csDocument.RootElement, 1, "TOSACommentRatio", commentRatio, minimumCommentRatioValue);
                }
            }
        }

        
        /// <summary>
        /// Returns the length of space indentation on the given line.
        /// </summary>
        /// <param name="line"></param>
        /// <param name="ignoreTabs"></param>
        private static int GetSpaceIndentLength(string line)
        {    
            var indentLength = 0;

            for (var i = 0; i < line.Length; i++)
            {
                if (line[i] == ' ')
                {
                    indentLength += 1;
                }
                else
                {
                    break;
                }
            }

            return indentLength;
        }

        private void CheckIndentation(CsDocument rootDocument, string[] sourceLines)
        {
            for (var i = 0; i < sourceLines.Length; i++)
            {
                if (sourceLines[i].Contains('\t'))
                {
                    this.AddViolation(rootDocument.RootElement, i + 1, "TOSABadIndentation", "禁止使用Tabs");
                    continue;
                }

                var indentLength = GetSpaceIndentLength(sourceLines[i]);
                if ((indentLength % spaceIndentLengthValue) != 0)
                {
                    string message = String.Format("空格缩进的值应该设置为{0}的倍数", spaceIndentLengthValue);
                    this.AddViolation(rootDocument.RootElement, i + 1, "TOSABadIndentation", message);
                }

            }
        }
    }
}