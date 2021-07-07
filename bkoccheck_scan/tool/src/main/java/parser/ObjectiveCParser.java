package parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ObjectiveCParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		AUTO=1, BREAK=2, CASE=3, CHAR=4, CONST=5, CONTINUE=6, DEFAULT=7, DO=8, 
		DOUBLE=9, ELSE=10, ENUM=11, EXTERN=12, FLOAT=13, FOR=14, GOTO=15, IF=16, 
		INLINE=17, INT=18, LONG=19, REGISTER=20, RESTRICT=21, RETURN=22, SHORT=23, 
		SIGNED=24, SIZEOF=25, STATIC=26, STRUCT=27, SWITCH=28, TYPEDEF=29, UNION=30, 
		UNSIGNED=31, VOID=32, VOLATILE=33, WHILE=34, BOOL_=35, COMPLEX=36, IMAGINERY=37, 
		TRUE=38, FALSE=39, BOOL=40, Class=41, BYCOPY=42, BYREF=43, ID=44, IMP=45, 
		IN=46, INOUT=47, NIL=48, NO=49, NULL=50, ONEWAY=51, OUT=52, PROTOCOL_=53, 
		SEL=54, SELF=55, SUPER=56, YES=57, AUTORELEASEPOOL=58, CATCH=59, CLASS=60, 
		DYNAMIC=61, ENCODE=62, END=63, FINALLY=64, IMPLEMENTATION=65, INTERFACE=66, 
		IMPORT=67, PACKAGE=68, PROTOCOL=69, OPTIONAL=70, PRIVATE=71, PROPERTY=72, 
		PROTECTED=73, PUBLIC=74, REQUIRED=75, SELECTOR=76, SYNCHRONIZED=77, SYNTHESIZE=78, 
		THROW=79, TRY=80, ATOMIC=81, NONATOMIC=82, RETAIN=83, ATTRIBUTE=84, AUTORELEASING_QUALIFIER=85, 
		BLOCK=86, BRIDGE=87, BRIDGE_RETAINED=88, BRIDGE_TRANSFER=89, COVARIANT=90, 
		CONTRAVARIANT=91, DEPRECATED=92, KINDOF=93, STRONG_QUALIFIER=94, TYPEOF=95, 
		UNSAFE_UNRETAINED_QUALIFIER=96, UNUSED=97, WEAK_QUALIFIER=98, NULL_UNSPECIFIED=99, 
		NULLABLE=100, NONNULL=101, NULL_RESETTABLE=102, NS_INLINE=103, NS_ENUM=104, 
		NS_OPTIONS=105, ASSIGN=106, COPY=107, GETTER=108, SETTER=109, STRONG=110, 
		READONLY=111, READWRITE=112, WEAK=113, UNSAFE_UNRETAINED=114, IB_OUTLET=115, 
		IB_OUTLET_COLLECTION=116, IB_INSPECTABLE=117, IB_DESIGNABLE=118, NS_ASSUME_NONNULL_BEGIN=119, 
		NS_ASSUME_NONNULL_END=120, EXTERN_SUFFIX=121, IOS_SUFFIX=122, MAC_SUFFIX=123, 
		TVOS_PROHIBITED=124, IDENTIFIER=125, LP=126, RP=127, LBRACE=128, RBRACE=129, 
		LBRACK=130, RBRACK=131, SEMI=132, COMMA=133, DOT=134, STRUCTACCESS=135, 
		AT=136, ASSIGNMENT=137, GT=138, LT=139, BANG=140, TILDE=141, QUESTION=142, 
		COLON=143, EQUAL=144, LE=145, GE=146, NOTEQUAL=147, AND=148, OR=149, INC=150, 
		DEC=151, ADD=152, SUB=153, MUL=154, DIV=155, BITAND=156, BITOR=157, BITXOR=158, 
		MOD=159, ADD_ASSIGN=160, SUB_ASSIGN=161, MUL_ASSIGN=162, DIV_ASSIGN=163, 
		AND_ASSIGN=164, OR_ASSIGN=165, XOR_ASSIGN=166, MOD_ASSIGN=167, LSHIFT_ASSIGN=168, 
		RSHIFT_ASSIGN=169, ELIPSIS=170, CHARACTER_LITERAL=171, STRING_START=172, 
		HEX_LITERAL=173, OCTAL_LITERAL=174, BINARY_LITERAL=175, DECIMAL_LITERAL=176, 
		FLOATING_POINT_LITERAL=177, WS=178, MULTI_COMMENT=179, SINGLE_COMMENT=180, 
		BACKSLASH=181, SHARP=182, STRING_NEWLINE=183, STRING_END=184, STRING_VALUE=185, 
		DIRECTIVE_IMPORT=186, DIRECTIVE_INCLUDE=187, DIRECTIVE_PRAGMA=188, DIRECTIVE_DEFINE=189, 
		DIRECTIVE_DEFINED=190, DIRECTIVE_IF=191, DIRECTIVE_ELIF=192, DIRECTIVE_ELSE=193, 
		DIRECTIVE_UNDEF=194, DIRECTIVE_IFDEF=195, DIRECTIVE_IFNDEF=196, DIRECTIVE_ENDIF=197, 
		DIRECTIVE_TRUE=198, DIRECTIVE_FALSE=199, DIRECTIVE_ERROR=200, DIRECTIVE_WARNING=201, 
		DIRECTIVE_BANG=202, DIRECTIVE_LP=203, DIRECTIVE_RP=204, DIRECTIVE_EQUAL=205, 
		DIRECTIVE_NOTEQUAL=206, DIRECTIVE_AND=207, DIRECTIVE_OR=208, DIRECTIVE_LT=209, 
		DIRECTIVE_GT=210, DIRECTIVE_LE=211, DIRECTIVE_GE=212, DIRECTIVE_STRING=213, 
		DIRECTIVE_ID=214, DIRECTIVE_DECIMAL_LITERAL=215, DIRECTIVE_FLOAT=216, 
		DIRECTIVE_NEWLINE=217, DIRECTIVE_MULTI_COMMENT=218, DIRECTIVE_SINGLE_COMMENT=219, 
		DIRECTIVE_BACKSLASH_NEWLINE=220, DIRECTIVE_TEXT_NEWLINE=221, DIRECTIVE_TEXT=222;
	public static final int
		RULE_translationUnit = 0, RULE_topLevelDeclaration = 1, RULE_importDeclaration = 2, 
		RULE_classInterface = 3, RULE_categoryInterface = 4, RULE_classImplementation = 5, 
		RULE_categoryImplementation = 6, RULE_genericTypeSpecifier = 7, RULE_protocolDeclaration = 8, 
		RULE_protocolDeclarationSection = 9, RULE_protocolDeclarationList = 10, 
		RULE_classDeclarationList = 11, RULE_protocolList = 12, RULE_propertyDeclaration = 13, 
		RULE_propertyAttributesList = 14, RULE_propertyAttribute = 15, RULE_protocolName = 16, 
		RULE_instanceVariables = 17, RULE_visibilitySection = 18, RULE_accessModifier = 19, 
		RULE_interfaceDeclarationList = 20, RULE_classMethodDeclaration = 21, 
		RULE_instanceMethodDeclaration = 22, RULE_methodDeclaration = 23, RULE_implementationDefinitionList = 24, 
		RULE_classMethodDefinition = 25, RULE_instanceMethodDefinition = 26, RULE_methodDefinition = 27, 
		RULE_methodSelector = 28, RULE_keywordDeclarator = 29, RULE_selector = 30, 
		RULE_methodType = 31, RULE_propertyImplementation = 32, RULE_propertySynthesizeList = 33, 
		RULE_propertySynthesizeItem = 34, RULE_blockType = 35, RULE_genericsSpecifier = 36, 
		RULE_typeSpecifierWithPrefixes = 37, RULE_dictionaryExpression = 38, RULE_dictionaryPair = 39, 
		RULE_arrayExpression = 40, RULE_boxExpression = 41, RULE_blockParameters = 42, 
		RULE_typeVariableDeclaratorOrName = 43, RULE_blockExpression = 44, RULE_messageExpression = 45, 
		RULE_receiver = 46, RULE_messageSelector = 47, RULE_keywordArgument = 48, 
		RULE_keywordArgumentType = 49, RULE_selectorExpression = 50, RULE_selectorName = 51, 
		RULE_protocolExpression = 52, RULE_encodeExpression = 53, RULE_typeVariableDeclarator = 54, 
		RULE_throwStatement = 55, RULE_tryBlock = 56, RULE_catchStatement = 57, 
		RULE_synchronizedStatement = 58, RULE_autoreleaseStatement = 59, RULE_functionDeclaration = 60, 
		RULE_functionDefinition = 61, RULE_functionSignature = 62, RULE_attribute = 63, 
		RULE_attributeName = 64, RULE_attributeParameters = 65, RULE_attributeParameterList = 66, 
		RULE_attributeParameter = 67, RULE_attributeParameterAssignment = 68, 
		RULE_declaration = 69, RULE_functionCallExpression = 70, RULE_enumDeclaration = 71, 
		RULE_varDeclaration = 72, RULE_typedefDeclaration = 73, RULE_typeDeclaratorList = 74, 
		RULE_typeDeclarator = 75, RULE_declarationSpecifiers = 76, RULE_attributeSpecifier = 77, 
		RULE_initDeclaratorList = 78, RULE_initDeclarator = 79, RULE_structOrUnionSpecifier = 80, 
		RULE_fieldDeclaration = 81, RULE_specifierQualifierList = 82, RULE_ibOutletQualifier = 83, 
		RULE_arcBehaviourSpecifier = 84, RULE_nullabilitySpecifier = 85, RULE_storageClassSpecifier = 86, 
		RULE_typePrefix = 87, RULE_typeQualifier = 88, RULE_protocolQualifier = 89, 
		RULE_typeSpecifier = 90, RULE_typeofExpression = 91, RULE_fieldDeclaratorList = 92, 
		RULE_fieldDeclarator = 93, RULE_enumSpecifier = 94, RULE_enumeratorList = 95, 
		RULE_enumerator = 96, RULE_enumeratorIdentifier = 97, RULE_directDeclarator = 98, 
		RULE_declaratorSuffix = 99, RULE_parameterList = 100, RULE_pointer = 101, 
		RULE_macro = 102, RULE_arrayInitializer = 103, RULE_structInitializer = 104, 
		RULE_initializerList = 105, RULE_typeName = 106, RULE_abstractDeclarator = 107, 
		RULE_abstractDeclaratorSuffix = 108, RULE_parameterDeclarationList = 109, 
		RULE_parameterDeclaration = 110, RULE_declarator = 111, RULE_statement = 112, 
		RULE_labeledStatement = 113, RULE_rangeExpression = 114, RULE_compoundStatement = 115, 
		RULE_selectionStatement = 116, RULE_switchStatement = 117, RULE_switchBlock = 118, 
		RULE_switchSection = 119, RULE_switchLabel = 120, RULE_iterationStatement = 121, 
		RULE_whileStatement = 122, RULE_doStatement = 123, RULE_forStatement = 124, 
		RULE_forLoopInitializer = 125, RULE_forInStatement = 126, RULE_jumpStatement = 127, 
		RULE_expressions = 128, RULE_expression = 129, RULE_assignmentOperator = 130, 
		RULE_castExpression = 131, RULE_initializer = 132, RULE_constantExpression = 133, 
		RULE_unaryExpression = 134, RULE_unaryOperator = 135, RULE_postfixExpression = 136, 
		RULE_postfix = 137, RULE_argumentExpressionList = 138, RULE_argumentExpression = 139, 
		RULE_primaryExpression = 140, RULE_constant = 141, RULE_stringLiteral = 142, 
		RULE_identifier = 143;
	private static String[] makeRuleNames() {
		return new String[] {
			"translationUnit", "topLevelDeclaration", "importDeclaration", "classInterface", 
			"categoryInterface", "classImplementation", "categoryImplementation", 
			"genericTypeSpecifier", "protocolDeclaration", "protocolDeclarationSection", 
			"protocolDeclarationList", "classDeclarationList", "protocolList", "propertyDeclaration", 
			"propertyAttributesList", "propertyAttribute", "protocolName", "instanceVariables", 
			"visibilitySection", "accessModifier", "interfaceDeclarationList", "classMethodDeclaration", 
			"instanceMethodDeclaration", "methodDeclaration", "implementationDefinitionList", 
			"classMethodDefinition", "instanceMethodDefinition", "methodDefinition", 
			"methodSelector", "keywordDeclarator", "selector", "methodType", "propertyImplementation", 
			"propertySynthesizeList", "propertySynthesizeItem", "blockType", "genericsSpecifier", 
			"typeSpecifierWithPrefixes", "dictionaryExpression", "dictionaryPair", 
			"arrayExpression", "boxExpression", "blockParameters", "typeVariableDeclaratorOrName", 
			"blockExpression", "messageExpression", "receiver", "messageSelector", 
			"keywordArgument", "keywordArgumentType", "selectorExpression", "selectorName", 
			"protocolExpression", "encodeExpression", "typeVariableDeclarator", "throwStatement", 
			"tryBlock", "catchStatement", "synchronizedStatement", "autoreleaseStatement", 
			"functionDeclaration", "functionDefinition", "functionSignature", "attribute", 
			"attributeName", "attributeParameters", "attributeParameterList", "attributeParameter", 
			"attributeParameterAssignment", "declaration", "functionCallExpression", 
			"enumDeclaration", "varDeclaration", "typedefDeclaration", "typeDeclaratorList", 
			"typeDeclarator", "declarationSpecifiers", "attributeSpecifier", "initDeclaratorList", 
			"initDeclarator", "structOrUnionSpecifier", "fieldDeclaration", "specifierQualifierList", 
			"ibOutletQualifier", "arcBehaviourSpecifier", "nullabilitySpecifier", 
			"storageClassSpecifier", "typePrefix", "typeQualifier", "protocolQualifier", 
			"typeSpecifier", "typeofExpression", "fieldDeclaratorList", "fieldDeclarator", 
			"enumSpecifier", "enumeratorList", "enumerator", "enumeratorIdentifier", 
			"directDeclarator", "declaratorSuffix", "parameterList", "pointer", "macro", 
			"arrayInitializer", "structInitializer", "initializerList", "typeName", 
			"abstractDeclarator", "abstractDeclaratorSuffix", "parameterDeclarationList", 
			"parameterDeclaration", "declarator", "statement", "labeledStatement", 
			"rangeExpression", "compoundStatement", "selectionStatement", "switchStatement", 
			"switchBlock", "switchSection", "switchLabel", "iterationStatement", 
			"whileStatement", "doStatement", "forStatement", "forLoopInitializer", 
			"forInStatement", "jumpStatement", "expressions", "expression", "assignmentOperator", 
			"castExpression", "initializer", "constantExpression", "unaryExpression", 
			"unaryOperator", "postfixExpression", "postfix", "argumentExpressionList", 
			"argumentExpression", "primaryExpression", "constant", "stringLiteral", 
			"identifier"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'auto'", "'break'", "'case'", "'char'", "'const'", "'continue'", 
			"'default'", "'do'", "'double'", null, "'enum'", "'extern'", "'float'", 
			"'for'", "'goto'", null, "'inline'", "'int'", "'long'", "'register'", 
			"'restrict'", "'return'", "'short'", "'signed'", "'sizeof'", "'static'", 
			"'struct'", "'switch'", "'typedef'", "'union'", "'unsigned'", "'void'", 
			"'volatile'", "'while'", "'_Bool'", "'_Complex'", "'_Imaginery'", "'true'", 
			"'false'", "'BOOL'", "'Class'", "'bycopy'", "'byref'", "'id'", "'IMP'", 
			"'in'", "'inout'", "'nil'", "'NO'", "'NULL'", "'oneway'", "'out'", "'Protocol'", 
			"'SEL'", "'self'", "'super'", "'YES'", "'@autoreleasepool'", "'@catch'", 
			"'@class'", "'@dynamic'", "'@encode'", "'@end'", "'@finally'", "'@implementation'", 
			"'@interface'", "'@import'", "'@package'", "'@protocol'", "'@optional'", 
			"'@private'", "'@property'", "'@protected'", "'@public'", "'@required'", 
			"'@selector'", "'@synchronized'", "'@synthesize'", "'@throw'", "'@try'", 
			"'atomic'", "'nonatomic'", "'retain'", "'__attribute__'", "'__autoreleasing'", 
			"'__block'", "'__bridge'", "'__bridge_retained'", "'__bridge_transfer'", 
			"'__covariant'", "'__contravariant'", "'__deprecated'", "'__kindof'", 
			"'__strong'", null, "'__unsafe_unretained'", "'__unused'", "'__weak'", 
			null, null, null, "'null_resettable'", "'NS_INLINE'", "'NS_ENUM'", "'NS_OPTIONS'", 
			"'assign'", "'copy'", "'getter'", "'setter'", "'strong'", "'readonly'", 
			"'readwrite'", "'weak'", "'unsafe_unretained'", "'IBOutlet'", "'IBOutletCollection'", 
			"'IBInspectable'", "'IB_DESIGNABLE'", null, null, null, null, null, "'__TVOS_PROHIBITED'", 
			null, null, null, "'{'", "'}'", "'['", "']'", "';'", "','", "'.'", "'->'", 
			"'@'", "'='", null, null, null, "'~'", "'?'", "':'", null, null, null, 
			null, null, null, "'++'", "'--'", "'+'", "'-'", "'*'", "'/'", "'&'", 
			"'|'", "'^'", "'%'", "'+='", "'-='", "'*='", "'/='", "'&='", "'|='", 
			"'^='", "'%='", "'<<='", "'>>='", "'...'", null, null, null, null, null, 
			null, null, null, null, null, "'\\'", null, null, null, null, null, null, 
			null, null, "'defined'", null, "'elif'", null, "'undef'", "'ifdef'", 
			"'ifndef'", "'endif'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "AUTO", "BREAK", "CASE", "CHAR", "CONST", "CONTINUE", "DEFAULT", 
			"DO", "DOUBLE", "ELSE", "ENUM", "EXTERN", "FLOAT", "FOR", "GOTO", "IF", 
			"INLINE", "INT", "LONG", "REGISTER", "RESTRICT", "RETURN", "SHORT", "SIGNED", 
			"SIZEOF", "STATIC", "STRUCT", "SWITCH", "TYPEDEF", "UNION", "UNSIGNED", 
			"VOID", "VOLATILE", "WHILE", "BOOL_", "COMPLEX", "IMAGINERY", "TRUE", 
			"FALSE", "BOOL", "Class", "BYCOPY", "BYREF", "ID", "IMP", "IN", "INOUT", 
			"NIL", "NO", "NULL", "ONEWAY", "OUT", "PROTOCOL_", "SEL", "SELF", "SUPER", 
			"YES", "AUTORELEASEPOOL", "CATCH", "CLASS", "DYNAMIC", "ENCODE", "END", 
			"FINALLY", "IMPLEMENTATION", "INTERFACE", "IMPORT", "PACKAGE", "PROTOCOL", 
			"OPTIONAL", "PRIVATE", "PROPERTY", "PROTECTED", "PUBLIC", "REQUIRED", 
			"SELECTOR", "SYNCHRONIZED", "SYNTHESIZE", "THROW", "TRY", "ATOMIC", "NONATOMIC", 
			"RETAIN", "ATTRIBUTE", "AUTORELEASING_QUALIFIER", "BLOCK", "BRIDGE", 
			"BRIDGE_RETAINED", "BRIDGE_TRANSFER", "COVARIANT", "CONTRAVARIANT", "DEPRECATED", 
			"KINDOF", "STRONG_QUALIFIER", "TYPEOF", "UNSAFE_UNRETAINED_QUALIFIER", 
			"UNUSED", "WEAK_QUALIFIER", "NULL_UNSPECIFIED", "NULLABLE", "NONNULL", 
			"NULL_RESETTABLE", "NS_INLINE", "NS_ENUM", "NS_OPTIONS", "ASSIGN", "COPY", 
			"GETTER", "SETTER", "STRONG", "READONLY", "READWRITE", "WEAK", "UNSAFE_UNRETAINED", 
			"IB_OUTLET", "IB_OUTLET_COLLECTION", "IB_INSPECTABLE", "IB_DESIGNABLE", 
			"NS_ASSUME_NONNULL_BEGIN", "NS_ASSUME_NONNULL_END", "EXTERN_SUFFIX", 
			"IOS_SUFFIX", "MAC_SUFFIX", "TVOS_PROHIBITED", "IDENTIFIER", "LP", "RP", 
			"LBRACE", "RBRACE", "LBRACK", "RBRACK", "SEMI", "COMMA", "DOT", "STRUCTACCESS", 
			"AT", "ASSIGNMENT", "GT", "LT", "BANG", "TILDE", "QUESTION", "COLON", 
			"EQUAL", "LE", "GE", "NOTEQUAL", "AND", "OR", "INC", "DEC", "ADD", "SUB", 
			"MUL", "DIV", "BITAND", "BITOR", "BITXOR", "MOD", "ADD_ASSIGN", "SUB_ASSIGN", 
			"MUL_ASSIGN", "DIV_ASSIGN", "AND_ASSIGN", "OR_ASSIGN", "XOR_ASSIGN", 
			"MOD_ASSIGN", "LSHIFT_ASSIGN", "RSHIFT_ASSIGN", "ELIPSIS", "CHARACTER_LITERAL", 
			"STRING_START", "HEX_LITERAL", "OCTAL_LITERAL", "BINARY_LITERAL", "DECIMAL_LITERAL", 
			"FLOATING_POINT_LITERAL", "WS", "MULTI_COMMENT", "SINGLE_COMMENT", "BACKSLASH", 
			"SHARP", "STRING_NEWLINE", "STRING_END", "STRING_VALUE", "DIRECTIVE_IMPORT", 
			"DIRECTIVE_INCLUDE", "DIRECTIVE_PRAGMA", "DIRECTIVE_DEFINE", "DIRECTIVE_DEFINED", 
			"DIRECTIVE_IF", "DIRECTIVE_ELIF", "DIRECTIVE_ELSE", "DIRECTIVE_UNDEF", 
			"DIRECTIVE_IFDEF", "DIRECTIVE_IFNDEF", "DIRECTIVE_ENDIF", "DIRECTIVE_TRUE", 
			"DIRECTIVE_FALSE", "DIRECTIVE_ERROR", "DIRECTIVE_WARNING", "DIRECTIVE_BANG", 
			"DIRECTIVE_LP", "DIRECTIVE_RP", "DIRECTIVE_EQUAL", "DIRECTIVE_NOTEQUAL", 
			"DIRECTIVE_AND", "DIRECTIVE_OR", "DIRECTIVE_LT", "DIRECTIVE_GT", "DIRECTIVE_LE", 
			"DIRECTIVE_GE", "DIRECTIVE_STRING", "DIRECTIVE_ID", "DIRECTIVE_DECIMAL_LITERAL", 
			"DIRECTIVE_FLOAT", "DIRECTIVE_NEWLINE", "DIRECTIVE_MULTI_COMMENT", "DIRECTIVE_SINGLE_COMMENT", 
			"DIRECTIVE_BACKSLASH_NEWLINE", "DIRECTIVE_TEXT_NEWLINE", "DIRECTIVE_TEXT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "ObjectiveCParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ObjectiveCParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class TranslationUnitContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(ObjectiveCParser.EOF, 0); }
		public List<TopLevelDeclarationContext> topLevelDeclaration() {
			return getRuleContexts(TopLevelDeclarationContext.class);
		}
		public TopLevelDeclarationContext topLevelDeclaration(int i) {
			return getRuleContext(TopLevelDeclarationContext.class,i);
		}
		public TranslationUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_translationUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterTranslationUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitTranslationUnit(this);
		}
	}

	public final TranslationUnitContext translationUnit() throws RecognitionException {
		TranslationUnitContext _localctx = new TranslationUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_translationUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AUTO) | (1L << CHAR) | (1L << CONST) | (1L << DOUBLE) | (1L << ENUM) | (1L << EXTERN) | (1L << FLOAT) | (1L << INLINE) | (1L << INT) | (1L << LONG) | (1L << REGISTER) | (1L << RESTRICT) | (1L << SHORT) | (1L << SIGNED) | (1L << STATIC) | (1L << STRUCT) | (1L << TYPEDEF) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID) | (1L << VOLATILE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << CLASS))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (IMPLEMENTATION - 65)) | (1L << (INTERFACE - 65)) | (1L << (IMPORT - 65)) | (1L << (PROTOCOL - 65)) | (1L << (ATOMIC - 65)) | (1L << (NONATOMIC - 65)) | (1L << (RETAIN - 65)) | (1L << (ATTRIBUTE - 65)) | (1L << (AUTORELEASING_QUALIFIER - 65)) | (1L << (BLOCK - 65)) | (1L << (BRIDGE - 65)) | (1L << (BRIDGE_RETAINED - 65)) | (1L << (BRIDGE_TRANSFER - 65)) | (1L << (COVARIANT - 65)) | (1L << (CONTRAVARIANT - 65)) | (1L << (DEPRECATED - 65)) | (1L << (KINDOF - 65)) | (1L << (STRONG_QUALIFIER - 65)) | (1L << (TYPEOF - 65)) | (1L << (UNSAFE_UNRETAINED_QUALIFIER - 65)) | (1L << (UNUSED - 65)) | (1L << (WEAK_QUALIFIER - 65)) | (1L << (NULL_UNSPECIFIED - 65)) | (1L << (NULLABLE - 65)) | (1L << (NONNULL - 65)) | (1L << (NULL_RESETTABLE - 65)) | (1L << (NS_INLINE - 65)) | (1L << (NS_ENUM - 65)) | (1L << (NS_OPTIONS - 65)) | (1L << (ASSIGN - 65)) | (1L << (COPY - 65)) | (1L << (GETTER - 65)) | (1L << (SETTER - 65)) | (1L << (STRONG - 65)) | (1L << (READONLY - 65)) | (1L << (READWRITE - 65)) | (1L << (WEAK - 65)) | (1L << (UNSAFE_UNRETAINED - 65)) | (1L << (IB_OUTLET - 65)) | (1L << (IB_OUTLET_COLLECTION - 65)) | (1L << (IB_INSPECTABLE - 65)) | (1L << (IB_DESIGNABLE - 65)) | (1L << (IDENTIFIER - 65)))) != 0)) {
				{
				{
				setState(288);
				topLevelDeclaration();
				}
				}
				setState(293);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(294);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TopLevelDeclarationContext extends ParserRuleContext {
		public ImportDeclarationContext importDeclaration() {
			return getRuleContext(ImportDeclarationContext.class,0);
		}
		public FunctionDeclarationContext functionDeclaration() {
			return getRuleContext(FunctionDeclarationContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public ClassInterfaceContext classInterface() {
			return getRuleContext(ClassInterfaceContext.class,0);
		}
		public ClassImplementationContext classImplementation() {
			return getRuleContext(ClassImplementationContext.class,0);
		}
		public CategoryInterfaceContext categoryInterface() {
			return getRuleContext(CategoryInterfaceContext.class,0);
		}
		public CategoryImplementationContext categoryImplementation() {
			return getRuleContext(CategoryImplementationContext.class,0);
		}
		public ProtocolDeclarationContext protocolDeclaration() {
			return getRuleContext(ProtocolDeclarationContext.class,0);
		}
		public ProtocolDeclarationListContext protocolDeclarationList() {
			return getRuleContext(ProtocolDeclarationListContext.class,0);
		}
		public ClassDeclarationListContext classDeclarationList() {
			return getRuleContext(ClassDeclarationListContext.class,0);
		}
		public FunctionDefinitionContext functionDefinition() {
			return getRuleContext(FunctionDefinitionContext.class,0);
		}
		public TopLevelDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_topLevelDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterTopLevelDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitTopLevelDeclaration(this);
		}
	}

	public final TopLevelDeclarationContext topLevelDeclaration() throws RecognitionException {
		TopLevelDeclarationContext _localctx = new TopLevelDeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_topLevelDeclaration);
		try {
			setState(307);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(296);
				importDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(297);
				functionDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(298);
				declaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(299);
				classInterface();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(300);
				classImplementation();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(301);
				categoryInterface();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(302);
				categoryImplementation();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(303);
				protocolDeclaration();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(304);
				protocolDeclarationList();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(305);
				classDeclarationList();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(306);
				functionDefinition();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ImportDeclarationContext extends ParserRuleContext {
		public TerminalNode IMPORT() { return getToken(ObjectiveCParser.IMPORT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ObjectiveCParser.SEMI, 0); }
		public ImportDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterImportDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitImportDeclaration(this);
		}
	}

	public final ImportDeclarationContext importDeclaration() throws RecognitionException {
		ImportDeclarationContext _localctx = new ImportDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_importDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(309);
			match(IMPORT);
			setState(310);
			identifier();
			setState(311);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassInterfaceContext extends ParserRuleContext {
		public GenericTypeSpecifierContext className;
		public IdentifierContext superclassName;
		public TerminalNode INTERFACE() { return getToken(ObjectiveCParser.INTERFACE, 0); }
		public TerminalNode END() { return getToken(ObjectiveCParser.END, 0); }
		public GenericTypeSpecifierContext genericTypeSpecifier() {
			return getRuleContext(GenericTypeSpecifierContext.class,0);
		}
		public TerminalNode IB_DESIGNABLE() { return getToken(ObjectiveCParser.IB_DESIGNABLE, 0); }
		public TerminalNode COLON() { return getToken(ObjectiveCParser.COLON, 0); }
		public TerminalNode LT() { return getToken(ObjectiveCParser.LT, 0); }
		public ProtocolListContext protocolList() {
			return getRuleContext(ProtocolListContext.class,0);
		}
		public TerminalNode GT() { return getToken(ObjectiveCParser.GT, 0); }
		public InstanceVariablesContext instanceVariables() {
			return getRuleContext(InstanceVariablesContext.class,0);
		}
		public InterfaceDeclarationListContext interfaceDeclarationList() {
			return getRuleContext(InterfaceDeclarationListContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ClassInterfaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classInterface; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterClassInterface(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitClassInterface(this);
		}
	}

	public final ClassInterfaceContext classInterface() throws RecognitionException {
		ClassInterfaceContext _localctx = new ClassInterfaceContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_classInterface);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IB_DESIGNABLE) {
				{
				setState(313);
				match(IB_DESIGNABLE);
				}
			}

			setState(316);
			match(INTERFACE);
			setState(317);
			((ClassInterfaceContext)_localctx).className = genericTypeSpecifier();
			setState(320);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(318);
				match(COLON);
				setState(319);
				((ClassInterfaceContext)_localctx).superclassName = identifier();
				}
			}

			setState(326);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(322);
				match(LT);
				setState(323);
				protocolList();
				setState(324);
				match(GT);
				}
			}

			setState(329);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACE) {
				{
				setState(328);
				instanceVariables();
				}
			}

			setState(332);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AUTO) | (1L << CHAR) | (1L << CONST) | (1L << DOUBLE) | (1L << ENUM) | (1L << EXTERN) | (1L << FLOAT) | (1L << INLINE) | (1L << INT) | (1L << LONG) | (1L << REGISTER) | (1L << RESTRICT) | (1L << SHORT) | (1L << SIGNED) | (1L << STATIC) | (1L << STRUCT) | (1L << TYPEDEF) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID) | (1L << VOLATILE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (PROPERTY - 72)) | (1L << (ATOMIC - 72)) | (1L << (NONATOMIC - 72)) | (1L << (RETAIN - 72)) | (1L << (ATTRIBUTE - 72)) | (1L << (AUTORELEASING_QUALIFIER - 72)) | (1L << (BLOCK - 72)) | (1L << (BRIDGE - 72)) | (1L << (BRIDGE_RETAINED - 72)) | (1L << (BRIDGE_TRANSFER - 72)) | (1L << (COVARIANT - 72)) | (1L << (CONTRAVARIANT - 72)) | (1L << (DEPRECATED - 72)) | (1L << (KINDOF - 72)) | (1L << (STRONG_QUALIFIER - 72)) | (1L << (TYPEOF - 72)) | (1L << (UNSAFE_UNRETAINED_QUALIFIER - 72)) | (1L << (UNUSED - 72)) | (1L << (WEAK_QUALIFIER - 72)) | (1L << (NULL_UNSPECIFIED - 72)) | (1L << (NULLABLE - 72)) | (1L << (NONNULL - 72)) | (1L << (NULL_RESETTABLE - 72)) | (1L << (NS_INLINE - 72)) | (1L << (NS_ENUM - 72)) | (1L << (NS_OPTIONS - 72)) | (1L << (ASSIGN - 72)) | (1L << (COPY - 72)) | (1L << (GETTER - 72)) | (1L << (SETTER - 72)) | (1L << (STRONG - 72)) | (1L << (READONLY - 72)) | (1L << (READWRITE - 72)) | (1L << (WEAK - 72)) | (1L << (UNSAFE_UNRETAINED - 72)) | (1L << (IB_OUTLET - 72)) | (1L << (IB_OUTLET_COLLECTION - 72)) | (1L << (IB_INSPECTABLE - 72)) | (1L << (IB_DESIGNABLE - 72)) | (1L << (IDENTIFIER - 72)))) != 0) || _la==ADD || _la==SUB) {
				{
				setState(331);
				interfaceDeclarationList();
				}
			}

			setState(334);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CategoryInterfaceContext extends ParserRuleContext {
		public GenericTypeSpecifierContext categoryName;
		public IdentifierContext className;
		public TerminalNode INTERFACE() { return getToken(ObjectiveCParser.INTERFACE, 0); }
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public TerminalNode END() { return getToken(ObjectiveCParser.END, 0); }
		public GenericTypeSpecifierContext genericTypeSpecifier() {
			return getRuleContext(GenericTypeSpecifierContext.class,0);
		}
		public TerminalNode LT() { return getToken(ObjectiveCParser.LT, 0); }
		public ProtocolListContext protocolList() {
			return getRuleContext(ProtocolListContext.class,0);
		}
		public TerminalNode GT() { return getToken(ObjectiveCParser.GT, 0); }
		public InstanceVariablesContext instanceVariables() {
			return getRuleContext(InstanceVariablesContext.class,0);
		}
		public InterfaceDeclarationListContext interfaceDeclarationList() {
			return getRuleContext(InterfaceDeclarationListContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public CategoryInterfaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_categoryInterface; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterCategoryInterface(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitCategoryInterface(this);
		}
	}

	public final CategoryInterfaceContext categoryInterface() throws RecognitionException {
		CategoryInterfaceContext _localctx = new CategoryInterfaceContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_categoryInterface);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(336);
			match(INTERFACE);
			setState(337);
			((CategoryInterfaceContext)_localctx).categoryName = genericTypeSpecifier();
			setState(338);
			match(LP);
			setState(340);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0)) {
				{
				setState(339);
				((CategoryInterfaceContext)_localctx).className = identifier();
				}
			}

			setState(342);
			match(RP);
			setState(347);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(343);
				match(LT);
				setState(344);
				protocolList();
				setState(345);
				match(GT);
				}
			}

			setState(350);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACE) {
				{
				setState(349);
				instanceVariables();
				}
			}

			setState(353);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AUTO) | (1L << CHAR) | (1L << CONST) | (1L << DOUBLE) | (1L << ENUM) | (1L << EXTERN) | (1L << FLOAT) | (1L << INLINE) | (1L << INT) | (1L << LONG) | (1L << REGISTER) | (1L << RESTRICT) | (1L << SHORT) | (1L << SIGNED) | (1L << STATIC) | (1L << STRUCT) | (1L << TYPEDEF) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID) | (1L << VOLATILE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (PROPERTY - 72)) | (1L << (ATOMIC - 72)) | (1L << (NONATOMIC - 72)) | (1L << (RETAIN - 72)) | (1L << (ATTRIBUTE - 72)) | (1L << (AUTORELEASING_QUALIFIER - 72)) | (1L << (BLOCK - 72)) | (1L << (BRIDGE - 72)) | (1L << (BRIDGE_RETAINED - 72)) | (1L << (BRIDGE_TRANSFER - 72)) | (1L << (COVARIANT - 72)) | (1L << (CONTRAVARIANT - 72)) | (1L << (DEPRECATED - 72)) | (1L << (KINDOF - 72)) | (1L << (STRONG_QUALIFIER - 72)) | (1L << (TYPEOF - 72)) | (1L << (UNSAFE_UNRETAINED_QUALIFIER - 72)) | (1L << (UNUSED - 72)) | (1L << (WEAK_QUALIFIER - 72)) | (1L << (NULL_UNSPECIFIED - 72)) | (1L << (NULLABLE - 72)) | (1L << (NONNULL - 72)) | (1L << (NULL_RESETTABLE - 72)) | (1L << (NS_INLINE - 72)) | (1L << (NS_ENUM - 72)) | (1L << (NS_OPTIONS - 72)) | (1L << (ASSIGN - 72)) | (1L << (COPY - 72)) | (1L << (GETTER - 72)) | (1L << (SETTER - 72)) | (1L << (STRONG - 72)) | (1L << (READONLY - 72)) | (1L << (READWRITE - 72)) | (1L << (WEAK - 72)) | (1L << (UNSAFE_UNRETAINED - 72)) | (1L << (IB_OUTLET - 72)) | (1L << (IB_OUTLET_COLLECTION - 72)) | (1L << (IB_INSPECTABLE - 72)) | (1L << (IB_DESIGNABLE - 72)) | (1L << (IDENTIFIER - 72)))) != 0) || _la==ADD || _la==SUB) {
				{
				setState(352);
				interfaceDeclarationList();
				}
			}

			setState(355);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassImplementationContext extends ParserRuleContext {
		public GenericTypeSpecifierContext className;
		public IdentifierContext superclassName;
		public TerminalNode IMPLEMENTATION() { return getToken(ObjectiveCParser.IMPLEMENTATION, 0); }
		public TerminalNode END() { return getToken(ObjectiveCParser.END, 0); }
		public GenericTypeSpecifierContext genericTypeSpecifier() {
			return getRuleContext(GenericTypeSpecifierContext.class,0);
		}
		public TerminalNode COLON() { return getToken(ObjectiveCParser.COLON, 0); }
		public InstanceVariablesContext instanceVariables() {
			return getRuleContext(InstanceVariablesContext.class,0);
		}
		public ImplementationDefinitionListContext implementationDefinitionList() {
			return getRuleContext(ImplementationDefinitionListContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ClassImplementationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classImplementation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterClassImplementation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitClassImplementation(this);
		}
	}

	public final ClassImplementationContext classImplementation() throws RecognitionException {
		ClassImplementationContext _localctx = new ClassImplementationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_classImplementation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(357);
			match(IMPLEMENTATION);
			setState(358);
			((ClassImplementationContext)_localctx).className = genericTypeSpecifier();
			setState(361);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(359);
				match(COLON);
				setState(360);
				((ClassImplementationContext)_localctx).superclassName = identifier();
				}
			}

			setState(364);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACE) {
				{
				setState(363);
				instanceVariables();
				}
			}

			setState(367);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AUTO) | (1L << CHAR) | (1L << CONST) | (1L << DOUBLE) | (1L << ENUM) | (1L << EXTERN) | (1L << FLOAT) | (1L << INLINE) | (1L << INT) | (1L << LONG) | (1L << REGISTER) | (1L << RESTRICT) | (1L << SHORT) | (1L << SIGNED) | (1L << STATIC) | (1L << STRUCT) | (1L << TYPEDEF) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID) | (1L << VOLATILE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << DYNAMIC))) != 0) || ((((_la - 78)) & ~0x3f) == 0 && ((1L << (_la - 78)) & ((1L << (SYNTHESIZE - 78)) | (1L << (ATOMIC - 78)) | (1L << (NONATOMIC - 78)) | (1L << (RETAIN - 78)) | (1L << (ATTRIBUTE - 78)) | (1L << (AUTORELEASING_QUALIFIER - 78)) | (1L << (BLOCK - 78)) | (1L << (BRIDGE - 78)) | (1L << (BRIDGE_RETAINED - 78)) | (1L << (BRIDGE_TRANSFER - 78)) | (1L << (COVARIANT - 78)) | (1L << (CONTRAVARIANT - 78)) | (1L << (DEPRECATED - 78)) | (1L << (KINDOF - 78)) | (1L << (STRONG_QUALIFIER - 78)) | (1L << (TYPEOF - 78)) | (1L << (UNSAFE_UNRETAINED_QUALIFIER - 78)) | (1L << (UNUSED - 78)) | (1L << (WEAK_QUALIFIER - 78)) | (1L << (NULL_UNSPECIFIED - 78)) | (1L << (NULLABLE - 78)) | (1L << (NONNULL - 78)) | (1L << (NULL_RESETTABLE - 78)) | (1L << (NS_INLINE - 78)) | (1L << (NS_ENUM - 78)) | (1L << (NS_OPTIONS - 78)) | (1L << (ASSIGN - 78)) | (1L << (COPY - 78)) | (1L << (GETTER - 78)) | (1L << (SETTER - 78)) | (1L << (STRONG - 78)) | (1L << (READONLY - 78)) | (1L << (READWRITE - 78)) | (1L << (WEAK - 78)) | (1L << (UNSAFE_UNRETAINED - 78)) | (1L << (IB_OUTLET - 78)) | (1L << (IB_OUTLET_COLLECTION - 78)) | (1L << (IB_INSPECTABLE - 78)) | (1L << (IB_DESIGNABLE - 78)) | (1L << (IDENTIFIER - 78)))) != 0) || _la==ADD || _la==SUB) {
				{
				setState(366);
				implementationDefinitionList();
				}
			}

			setState(369);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CategoryImplementationContext extends ParserRuleContext {
		public GenericTypeSpecifierContext categoryName;
		public IdentifierContext className;
		public TerminalNode IMPLEMENTATION() { return getToken(ObjectiveCParser.IMPLEMENTATION, 0); }
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public TerminalNode END() { return getToken(ObjectiveCParser.END, 0); }
		public GenericTypeSpecifierContext genericTypeSpecifier() {
			return getRuleContext(GenericTypeSpecifierContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ImplementationDefinitionListContext implementationDefinitionList() {
			return getRuleContext(ImplementationDefinitionListContext.class,0);
		}
		public CategoryImplementationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_categoryImplementation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterCategoryImplementation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitCategoryImplementation(this);
		}
	}

	public final CategoryImplementationContext categoryImplementation() throws RecognitionException {
		CategoryImplementationContext _localctx = new CategoryImplementationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_categoryImplementation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(371);
			match(IMPLEMENTATION);
			setState(372);
			((CategoryImplementationContext)_localctx).categoryName = genericTypeSpecifier();
			setState(373);
			match(LP);
			setState(374);
			((CategoryImplementationContext)_localctx).className = identifier();
			setState(375);
			match(RP);
			setState(377);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AUTO) | (1L << CHAR) | (1L << CONST) | (1L << DOUBLE) | (1L << ENUM) | (1L << EXTERN) | (1L << FLOAT) | (1L << INLINE) | (1L << INT) | (1L << LONG) | (1L << REGISTER) | (1L << RESTRICT) | (1L << SHORT) | (1L << SIGNED) | (1L << STATIC) | (1L << STRUCT) | (1L << TYPEDEF) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID) | (1L << VOLATILE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << DYNAMIC))) != 0) || ((((_la - 78)) & ~0x3f) == 0 && ((1L << (_la - 78)) & ((1L << (SYNTHESIZE - 78)) | (1L << (ATOMIC - 78)) | (1L << (NONATOMIC - 78)) | (1L << (RETAIN - 78)) | (1L << (ATTRIBUTE - 78)) | (1L << (AUTORELEASING_QUALIFIER - 78)) | (1L << (BLOCK - 78)) | (1L << (BRIDGE - 78)) | (1L << (BRIDGE_RETAINED - 78)) | (1L << (BRIDGE_TRANSFER - 78)) | (1L << (COVARIANT - 78)) | (1L << (CONTRAVARIANT - 78)) | (1L << (DEPRECATED - 78)) | (1L << (KINDOF - 78)) | (1L << (STRONG_QUALIFIER - 78)) | (1L << (TYPEOF - 78)) | (1L << (UNSAFE_UNRETAINED_QUALIFIER - 78)) | (1L << (UNUSED - 78)) | (1L << (WEAK_QUALIFIER - 78)) | (1L << (NULL_UNSPECIFIED - 78)) | (1L << (NULLABLE - 78)) | (1L << (NONNULL - 78)) | (1L << (NULL_RESETTABLE - 78)) | (1L << (NS_INLINE - 78)) | (1L << (NS_ENUM - 78)) | (1L << (NS_OPTIONS - 78)) | (1L << (ASSIGN - 78)) | (1L << (COPY - 78)) | (1L << (GETTER - 78)) | (1L << (SETTER - 78)) | (1L << (STRONG - 78)) | (1L << (READONLY - 78)) | (1L << (READWRITE - 78)) | (1L << (WEAK - 78)) | (1L << (UNSAFE_UNRETAINED - 78)) | (1L << (IB_OUTLET - 78)) | (1L << (IB_OUTLET_COLLECTION - 78)) | (1L << (IB_INSPECTABLE - 78)) | (1L << (IB_DESIGNABLE - 78)) | (1L << (IDENTIFIER - 78)))) != 0) || _la==ADD || _la==SUB) {
				{
				setState(376);
				implementationDefinitionList();
				}
			}

			setState(379);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GenericTypeSpecifierContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public GenericsSpecifierContext genericsSpecifier() {
			return getRuleContext(GenericsSpecifierContext.class,0);
		}
		public TerminalNode LT() { return getToken(ObjectiveCParser.LT, 0); }
		public ProtocolListContext protocolList() {
			return getRuleContext(ProtocolListContext.class,0);
		}
		public TerminalNode GT() { return getToken(ObjectiveCParser.GT, 0); }
		public GenericTypeSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_genericTypeSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterGenericTypeSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitGenericTypeSpecifier(this);
		}
	}

	public final GenericTypeSpecifierContext genericTypeSpecifier() throws RecognitionException {
		GenericTypeSpecifierContext _localctx = new GenericTypeSpecifierContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_genericTypeSpecifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(381);
			identifier();
			setState(387);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				{
				setState(382);
				match(LT);
				setState(383);
				protocolList();
				setState(384);
				match(GT);
				}
				}
				break;
			case 2:
				{
				setState(386);
				genericsSpecifier();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProtocolDeclarationContext extends ParserRuleContext {
		public TerminalNode PROTOCOL() { return getToken(ObjectiveCParser.PROTOCOL, 0); }
		public ProtocolNameContext protocolName() {
			return getRuleContext(ProtocolNameContext.class,0);
		}
		public TerminalNode END() { return getToken(ObjectiveCParser.END, 0); }
		public TerminalNode LT() { return getToken(ObjectiveCParser.LT, 0); }
		public ProtocolListContext protocolList() {
			return getRuleContext(ProtocolListContext.class,0);
		}
		public TerminalNode GT() { return getToken(ObjectiveCParser.GT, 0); }
		public List<ProtocolDeclarationSectionContext> protocolDeclarationSection() {
			return getRuleContexts(ProtocolDeclarationSectionContext.class);
		}
		public ProtocolDeclarationSectionContext protocolDeclarationSection(int i) {
			return getRuleContext(ProtocolDeclarationSectionContext.class,i);
		}
		public ProtocolDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_protocolDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterProtocolDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitProtocolDeclaration(this);
		}
	}

	public final ProtocolDeclarationContext protocolDeclaration() throws RecognitionException {
		ProtocolDeclarationContext _localctx = new ProtocolDeclarationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_protocolDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(389);
			match(PROTOCOL);
			setState(390);
			protocolName();
			setState(395);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(391);
				match(LT);
				setState(392);
				protocolList();
				setState(393);
				match(GT);
				}
			}

			setState(400);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AUTO) | (1L << CHAR) | (1L << CONST) | (1L << DOUBLE) | (1L << ENUM) | (1L << EXTERN) | (1L << FLOAT) | (1L << INLINE) | (1L << INT) | (1L << LONG) | (1L << REGISTER) | (1L << RESTRICT) | (1L << SHORT) | (1L << SIGNED) | (1L << STATIC) | (1L << STRUCT) | (1L << TYPEDEF) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID) | (1L << VOLATILE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (OPTIONAL - 70)) | (1L << (PROPERTY - 70)) | (1L << (REQUIRED - 70)) | (1L << (ATOMIC - 70)) | (1L << (NONATOMIC - 70)) | (1L << (RETAIN - 70)) | (1L << (ATTRIBUTE - 70)) | (1L << (AUTORELEASING_QUALIFIER - 70)) | (1L << (BLOCK - 70)) | (1L << (BRIDGE - 70)) | (1L << (BRIDGE_RETAINED - 70)) | (1L << (BRIDGE_TRANSFER - 70)) | (1L << (COVARIANT - 70)) | (1L << (CONTRAVARIANT - 70)) | (1L << (DEPRECATED - 70)) | (1L << (KINDOF - 70)) | (1L << (STRONG_QUALIFIER - 70)) | (1L << (TYPEOF - 70)) | (1L << (UNSAFE_UNRETAINED_QUALIFIER - 70)) | (1L << (UNUSED - 70)) | (1L << (WEAK_QUALIFIER - 70)) | (1L << (NULL_UNSPECIFIED - 70)) | (1L << (NULLABLE - 70)) | (1L << (NONNULL - 70)) | (1L << (NULL_RESETTABLE - 70)) | (1L << (NS_INLINE - 70)) | (1L << (NS_ENUM - 70)) | (1L << (NS_OPTIONS - 70)) | (1L << (ASSIGN - 70)) | (1L << (COPY - 70)) | (1L << (GETTER - 70)) | (1L << (SETTER - 70)) | (1L << (STRONG - 70)) | (1L << (READONLY - 70)) | (1L << (READWRITE - 70)) | (1L << (WEAK - 70)) | (1L << (UNSAFE_UNRETAINED - 70)) | (1L << (IB_OUTLET - 70)) | (1L << (IB_OUTLET_COLLECTION - 70)) | (1L << (IB_INSPECTABLE - 70)) | (1L << (IB_DESIGNABLE - 70)) | (1L << (IDENTIFIER - 70)))) != 0) || _la==ADD || _la==SUB) {
				{
				{
				setState(397);
				protocolDeclarationSection();
				}
				}
				setState(402);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(403);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProtocolDeclarationSectionContext extends ParserRuleContext {
		public Token modifier;
		public TerminalNode REQUIRED() { return getToken(ObjectiveCParser.REQUIRED, 0); }
		public TerminalNode OPTIONAL() { return getToken(ObjectiveCParser.OPTIONAL, 0); }
		public List<InterfaceDeclarationListContext> interfaceDeclarationList() {
			return getRuleContexts(InterfaceDeclarationListContext.class);
		}
		public InterfaceDeclarationListContext interfaceDeclarationList(int i) {
			return getRuleContext(InterfaceDeclarationListContext.class,i);
		}
		public ProtocolDeclarationSectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_protocolDeclarationSection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterProtocolDeclarationSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitProtocolDeclarationSection(this);
		}
	}

	public final ProtocolDeclarationSectionContext protocolDeclarationSection() throws RecognitionException {
		ProtocolDeclarationSectionContext _localctx = new ProtocolDeclarationSectionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_protocolDeclarationSection);
		int _la;
		try {
			int _alt;
			setState(417);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPTIONAL:
			case REQUIRED:
				enterOuterAlt(_localctx, 1);
				{
				setState(405);
				((ProtocolDeclarationSectionContext)_localctx).modifier = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==OPTIONAL || _la==REQUIRED) ) {
					((ProtocolDeclarationSectionContext)_localctx).modifier = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(409);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(406);
						interfaceDeclarationList();
						}
						} 
					}
					setState(411);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
				}
				}
				break;
			case AUTO:
			case CHAR:
			case CONST:
			case DOUBLE:
			case ENUM:
			case EXTERN:
			case FLOAT:
			case INLINE:
			case INT:
			case LONG:
			case REGISTER:
			case RESTRICT:
			case SHORT:
			case SIGNED:
			case STATIC:
			case STRUCT:
			case TYPEDEF:
			case UNION:
			case UNSIGNED:
			case VOID:
			case VOLATILE:
			case BOOL:
			case Class:
			case BYCOPY:
			case BYREF:
			case ID:
			case IMP:
			case IN:
			case INOUT:
			case ONEWAY:
			case OUT:
			case PROTOCOL_:
			case SEL:
			case SELF:
			case SUPER:
			case PROPERTY:
			case ATOMIC:
			case NONATOMIC:
			case RETAIN:
			case ATTRIBUTE:
			case AUTORELEASING_QUALIFIER:
			case BLOCK:
			case BRIDGE:
			case BRIDGE_RETAINED:
			case BRIDGE_TRANSFER:
			case COVARIANT:
			case CONTRAVARIANT:
			case DEPRECATED:
			case KINDOF:
			case STRONG_QUALIFIER:
			case TYPEOF:
			case UNSAFE_UNRETAINED_QUALIFIER:
			case UNUSED:
			case WEAK_QUALIFIER:
			case NULL_UNSPECIFIED:
			case NULLABLE:
			case NONNULL:
			case NULL_RESETTABLE:
			case NS_INLINE:
			case NS_ENUM:
			case NS_OPTIONS:
			case ASSIGN:
			case COPY:
			case GETTER:
			case SETTER:
			case STRONG:
			case READONLY:
			case READWRITE:
			case WEAK:
			case UNSAFE_UNRETAINED:
			case IB_OUTLET:
			case IB_OUTLET_COLLECTION:
			case IB_INSPECTABLE:
			case IB_DESIGNABLE:
			case IDENTIFIER:
			case ADD:
			case SUB:
				enterOuterAlt(_localctx, 2);
				{
				setState(413); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(412);
						interfaceDeclarationList();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(415); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProtocolDeclarationListContext extends ParserRuleContext {
		public TerminalNode PROTOCOL() { return getToken(ObjectiveCParser.PROTOCOL, 0); }
		public ProtocolListContext protocolList() {
			return getRuleContext(ProtocolListContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ObjectiveCParser.SEMI, 0); }
		public ProtocolDeclarationListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_protocolDeclarationList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterProtocolDeclarationList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitProtocolDeclarationList(this);
		}
	}

	public final ProtocolDeclarationListContext protocolDeclarationList() throws RecognitionException {
		ProtocolDeclarationListContext _localctx = new ProtocolDeclarationListContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_protocolDeclarationList);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(419);
			match(PROTOCOL);
			setState(420);
			protocolList();
			setState(421);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassDeclarationListContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(ObjectiveCParser.CLASS, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode SEMI() { return getToken(ObjectiveCParser.SEMI, 0); }
		public List<TerminalNode> COMMA() { return getTokens(ObjectiveCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ObjectiveCParser.COMMA, i);
		}
		public ClassDeclarationListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclarationList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterClassDeclarationList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitClassDeclarationList(this);
		}
	}

	public final ClassDeclarationListContext classDeclarationList() throws RecognitionException {
		ClassDeclarationListContext _localctx = new ClassDeclarationListContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_classDeclarationList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(423);
			match(CLASS);
			setState(424);
			identifier();
			setState(429);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(425);
				match(COMMA);
				setState(426);
				identifier();
				}
				}
				setState(431);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(432);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProtocolListContext extends ParserRuleContext {
		public List<ProtocolNameContext> protocolName() {
			return getRuleContexts(ProtocolNameContext.class);
		}
		public ProtocolNameContext protocolName(int i) {
			return getRuleContext(ProtocolNameContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ObjectiveCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ObjectiveCParser.COMMA, i);
		}
		public ProtocolListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_protocolList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterProtocolList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitProtocolList(this);
		}
	}

	public final ProtocolListContext protocolList() throws RecognitionException {
		ProtocolListContext _localctx = new ProtocolListContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_protocolList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(434);
			protocolName();
			setState(439);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(435);
				match(COMMA);
				setState(436);
				protocolName();
				}
				}
				setState(441);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PropertyDeclarationContext extends ParserRuleContext {
		public TerminalNode PROPERTY() { return getToken(ObjectiveCParser.PROPERTY, 0); }
		public FieldDeclarationContext fieldDeclaration() {
			return getRuleContext(FieldDeclarationContext.class,0);
		}
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public PropertyAttributesListContext propertyAttributesList() {
			return getRuleContext(PropertyAttributesListContext.class,0);
		}
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public IbOutletQualifierContext ibOutletQualifier() {
			return getRuleContext(IbOutletQualifierContext.class,0);
		}
		public TerminalNode IB_INSPECTABLE() { return getToken(ObjectiveCParser.IB_INSPECTABLE, 0); }
		public PropertyDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterPropertyDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitPropertyDeclaration(this);
		}
	}

	public final PropertyDeclarationContext propertyDeclaration() throws RecognitionException {
		PropertyDeclarationContext _localctx = new PropertyDeclarationContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_propertyDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(442);
			match(PROPERTY);
			setState(447);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LP) {
				{
				setState(443);
				match(LP);
				setState(444);
				propertyAttributesList();
				setState(445);
				match(RP);
				}
			}

			setState(450);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(449);
				ibOutletQualifier();
				}
				break;
			}
			setState(453);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				setState(452);
				match(IB_INSPECTABLE);
				}
				break;
			}
			setState(455);
			fieldDeclaration();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PropertyAttributesListContext extends ParserRuleContext {
		public List<PropertyAttributeContext> propertyAttribute() {
			return getRuleContexts(PropertyAttributeContext.class);
		}
		public PropertyAttributeContext propertyAttribute(int i) {
			return getRuleContext(PropertyAttributeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ObjectiveCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ObjectiveCParser.COMMA, i);
		}
		public PropertyAttributesListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyAttributesList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterPropertyAttributesList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitPropertyAttributesList(this);
		}
	}

	public final PropertyAttributesListContext propertyAttributesList() throws RecognitionException {
		PropertyAttributesListContext _localctx = new PropertyAttributesListContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_propertyAttributesList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(457);
			propertyAttribute();
			setState(462);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(458);
				match(COMMA);
				setState(459);
				propertyAttribute();
				}
				}
				setState(464);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PropertyAttributeContext extends ParserRuleContext {
		public TerminalNode ATOMIC() { return getToken(ObjectiveCParser.ATOMIC, 0); }
		public TerminalNode NONATOMIC() { return getToken(ObjectiveCParser.NONATOMIC, 0); }
		public TerminalNode STRONG() { return getToken(ObjectiveCParser.STRONG, 0); }
		public TerminalNode WEAK() { return getToken(ObjectiveCParser.WEAK, 0); }
		public TerminalNode RETAIN() { return getToken(ObjectiveCParser.RETAIN, 0); }
		public TerminalNode ASSIGN() { return getToken(ObjectiveCParser.ASSIGN, 0); }
		public TerminalNode UNSAFE_UNRETAINED() { return getToken(ObjectiveCParser.UNSAFE_UNRETAINED, 0); }
		public TerminalNode COPY() { return getToken(ObjectiveCParser.COPY, 0); }
		public TerminalNode READONLY() { return getToken(ObjectiveCParser.READONLY, 0); }
		public TerminalNode READWRITE() { return getToken(ObjectiveCParser.READWRITE, 0); }
		public TerminalNode GETTER() { return getToken(ObjectiveCParser.GETTER, 0); }
		public TerminalNode ASSIGNMENT() { return getToken(ObjectiveCParser.ASSIGNMENT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode SETTER() { return getToken(ObjectiveCParser.SETTER, 0); }
		public TerminalNode COLON() { return getToken(ObjectiveCParser.COLON, 0); }
		public NullabilitySpecifierContext nullabilitySpecifier() {
			return getRuleContext(NullabilitySpecifierContext.class,0);
		}
		public PropertyAttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyAttribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterPropertyAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitPropertyAttribute(this);
		}
	}

	public final PropertyAttributeContext propertyAttribute() throws RecognitionException {
		PropertyAttributeContext _localctx = new PropertyAttributeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_propertyAttribute);
		try {
			setState(485);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(465);
				match(ATOMIC);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(466);
				match(NONATOMIC);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(467);
				match(STRONG);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(468);
				match(WEAK);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(469);
				match(RETAIN);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(470);
				match(ASSIGN);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(471);
				match(UNSAFE_UNRETAINED);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(472);
				match(COPY);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(473);
				match(READONLY);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(474);
				match(READWRITE);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(475);
				match(GETTER);
				setState(476);
				match(ASSIGNMENT);
				setState(477);
				identifier();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(478);
				match(SETTER);
				setState(479);
				match(ASSIGNMENT);
				setState(480);
				identifier();
				setState(481);
				match(COLON);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(483);
				nullabilitySpecifier();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(484);
				identifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProtocolNameContext extends ParserRuleContext {
		public TerminalNode LT() { return getToken(ObjectiveCParser.LT, 0); }
		public ProtocolListContext protocolList() {
			return getRuleContext(ProtocolListContext.class,0);
		}
		public TerminalNode GT() { return getToken(ObjectiveCParser.GT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode COVARIANT() { return getToken(ObjectiveCParser.COVARIANT, 0); }
		public TerminalNode CONTRAVARIANT() { return getToken(ObjectiveCParser.CONTRAVARIANT, 0); }
		public ProtocolNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_protocolName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterProtocolName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitProtocolName(this);
		}
	}

	public final ProtocolNameContext protocolName() throws RecognitionException {
		ProtocolNameContext _localctx = new ProtocolNameContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_protocolName);
		int _la;
		try {
			setState(495);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LT:
				enterOuterAlt(_localctx, 1);
				{
				setState(487);
				match(LT);
				setState(488);
				protocolList();
				setState(489);
				match(GT);
				}
				break;
			case BOOL:
			case Class:
			case BYCOPY:
			case BYREF:
			case ID:
			case IMP:
			case IN:
			case INOUT:
			case ONEWAY:
			case OUT:
			case PROTOCOL_:
			case SEL:
			case SELF:
			case SUPER:
			case ATOMIC:
			case NONATOMIC:
			case RETAIN:
			case AUTORELEASING_QUALIFIER:
			case BLOCK:
			case BRIDGE_RETAINED:
			case BRIDGE_TRANSFER:
			case COVARIANT:
			case CONTRAVARIANT:
			case DEPRECATED:
			case KINDOF:
			case UNUSED:
			case NULL_UNSPECIFIED:
			case NULLABLE:
			case NONNULL:
			case NULL_RESETTABLE:
			case NS_INLINE:
			case NS_ENUM:
			case NS_OPTIONS:
			case ASSIGN:
			case COPY:
			case GETTER:
			case SETTER:
			case STRONG:
			case READONLY:
			case READWRITE:
			case WEAK:
			case UNSAFE_UNRETAINED:
			case IB_OUTLET:
			case IB_OUTLET_COLLECTION:
			case IB_INSPECTABLE:
			case IB_DESIGNABLE:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(492);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
				case 1:
					{
					setState(491);
					_la = _input.LA(1);
					if ( !(_la==COVARIANT || _la==CONTRAVARIANT) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					break;
				}
				setState(494);
				identifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstanceVariablesContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(ObjectiveCParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ObjectiveCParser.RBRACE, 0); }
		public List<VisibilitySectionContext> visibilitySection() {
			return getRuleContexts(VisibilitySectionContext.class);
		}
		public VisibilitySectionContext visibilitySection(int i) {
			return getRuleContext(VisibilitySectionContext.class,i);
		}
		public InstanceVariablesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instanceVariables; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterInstanceVariables(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitInstanceVariables(this);
		}
	}

	public final InstanceVariablesContext instanceVariables() throws RecognitionException {
		InstanceVariablesContext _localctx = new InstanceVariablesContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_instanceVariables);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(497);
			match(LBRACE);
			setState(501);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CHAR) | (1L << CONST) | (1L << DOUBLE) | (1L << ENUM) | (1L << FLOAT) | (1L << INLINE) | (1L << INT) | (1L << LONG) | (1L << RESTRICT) | (1L << SHORT) | (1L << SIGNED) | (1L << STRUCT) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID) | (1L << VOLATILE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (PACKAGE - 68)) | (1L << (PRIVATE - 68)) | (1L << (PROTECTED - 68)) | (1L << (PUBLIC - 68)) | (1L << (ATOMIC - 68)) | (1L << (NONATOMIC - 68)) | (1L << (RETAIN - 68)) | (1L << (AUTORELEASING_QUALIFIER - 68)) | (1L << (BLOCK - 68)) | (1L << (BRIDGE - 68)) | (1L << (BRIDGE_RETAINED - 68)) | (1L << (BRIDGE_TRANSFER - 68)) | (1L << (COVARIANT - 68)) | (1L << (CONTRAVARIANT - 68)) | (1L << (DEPRECATED - 68)) | (1L << (KINDOF - 68)) | (1L << (STRONG_QUALIFIER - 68)) | (1L << (TYPEOF - 68)) | (1L << (UNSAFE_UNRETAINED_QUALIFIER - 68)) | (1L << (UNUSED - 68)) | (1L << (WEAK_QUALIFIER - 68)) | (1L << (NULL_UNSPECIFIED - 68)) | (1L << (NULLABLE - 68)) | (1L << (NONNULL - 68)) | (1L << (NULL_RESETTABLE - 68)) | (1L << (NS_INLINE - 68)) | (1L << (NS_ENUM - 68)) | (1L << (NS_OPTIONS - 68)) | (1L << (ASSIGN - 68)) | (1L << (COPY - 68)) | (1L << (GETTER - 68)) | (1L << (SETTER - 68)) | (1L << (STRONG - 68)) | (1L << (READONLY - 68)) | (1L << (READWRITE - 68)) | (1L << (WEAK - 68)) | (1L << (UNSAFE_UNRETAINED - 68)) | (1L << (IB_OUTLET - 68)) | (1L << (IB_OUTLET_COLLECTION - 68)) | (1L << (IB_INSPECTABLE - 68)) | (1L << (IB_DESIGNABLE - 68)) | (1L << (IDENTIFIER - 68)))) != 0)) {
				{
				{
				setState(498);
				visibilitySection();
				}
				}
				setState(503);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(504);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VisibilitySectionContext extends ParserRuleContext {
		public AccessModifierContext accessModifier() {
			return getRuleContext(AccessModifierContext.class,0);
		}
		public List<FieldDeclarationContext> fieldDeclaration() {
			return getRuleContexts(FieldDeclarationContext.class);
		}
		public FieldDeclarationContext fieldDeclaration(int i) {
			return getRuleContext(FieldDeclarationContext.class,i);
		}
		public VisibilitySectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_visibilitySection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterVisibilitySection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitVisibilitySection(this);
		}
	}

	public final VisibilitySectionContext visibilitySection() throws RecognitionException {
		VisibilitySectionContext _localctx = new VisibilitySectionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_visibilitySection);
		try {
			int _alt;
			setState(518);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PACKAGE:
			case PRIVATE:
			case PROTECTED:
			case PUBLIC:
				enterOuterAlt(_localctx, 1);
				{
				setState(506);
				accessModifier();
				setState(510);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(507);
						fieldDeclaration();
						}
						} 
					}
					setState(512);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
				}
				}
				break;
			case CHAR:
			case CONST:
			case DOUBLE:
			case ENUM:
			case FLOAT:
			case INLINE:
			case INT:
			case LONG:
			case RESTRICT:
			case SHORT:
			case SIGNED:
			case STRUCT:
			case UNION:
			case UNSIGNED:
			case VOID:
			case VOLATILE:
			case BOOL:
			case Class:
			case BYCOPY:
			case BYREF:
			case ID:
			case IMP:
			case IN:
			case INOUT:
			case ONEWAY:
			case OUT:
			case PROTOCOL_:
			case SEL:
			case SELF:
			case SUPER:
			case ATOMIC:
			case NONATOMIC:
			case RETAIN:
			case AUTORELEASING_QUALIFIER:
			case BLOCK:
			case BRIDGE:
			case BRIDGE_RETAINED:
			case BRIDGE_TRANSFER:
			case COVARIANT:
			case CONTRAVARIANT:
			case DEPRECATED:
			case KINDOF:
			case STRONG_QUALIFIER:
			case TYPEOF:
			case UNSAFE_UNRETAINED_QUALIFIER:
			case UNUSED:
			case WEAK_QUALIFIER:
			case NULL_UNSPECIFIED:
			case NULLABLE:
			case NONNULL:
			case NULL_RESETTABLE:
			case NS_INLINE:
			case NS_ENUM:
			case NS_OPTIONS:
			case ASSIGN:
			case COPY:
			case GETTER:
			case SETTER:
			case STRONG:
			case READONLY:
			case READWRITE:
			case WEAK:
			case UNSAFE_UNRETAINED:
			case IB_OUTLET:
			case IB_OUTLET_COLLECTION:
			case IB_INSPECTABLE:
			case IB_DESIGNABLE:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(514); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(513);
						fieldDeclaration();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(516); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AccessModifierContext extends ParserRuleContext {
		public TerminalNode PRIVATE() { return getToken(ObjectiveCParser.PRIVATE, 0); }
		public TerminalNode PROTECTED() { return getToken(ObjectiveCParser.PROTECTED, 0); }
		public TerminalNode PACKAGE() { return getToken(ObjectiveCParser.PACKAGE, 0); }
		public TerminalNode PUBLIC() { return getToken(ObjectiveCParser.PUBLIC, 0); }
		public AccessModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_accessModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterAccessModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitAccessModifier(this);
		}
	}

	public final AccessModifierContext accessModifier() throws RecognitionException {
		AccessModifierContext _localctx = new AccessModifierContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_accessModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(520);
			_la = _input.LA(1);
			if ( !(((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (PACKAGE - 68)) | (1L << (PRIVATE - 68)) | (1L << (PROTECTED - 68)) | (1L << (PUBLIC - 68)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InterfaceDeclarationListContext extends ParserRuleContext {
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public List<ClassMethodDeclarationContext> classMethodDeclaration() {
			return getRuleContexts(ClassMethodDeclarationContext.class);
		}
		public ClassMethodDeclarationContext classMethodDeclaration(int i) {
			return getRuleContext(ClassMethodDeclarationContext.class,i);
		}
		public List<InstanceMethodDeclarationContext> instanceMethodDeclaration() {
			return getRuleContexts(InstanceMethodDeclarationContext.class);
		}
		public InstanceMethodDeclarationContext instanceMethodDeclaration(int i) {
			return getRuleContext(InstanceMethodDeclarationContext.class,i);
		}
		public List<PropertyDeclarationContext> propertyDeclaration() {
			return getRuleContexts(PropertyDeclarationContext.class);
		}
		public PropertyDeclarationContext propertyDeclaration(int i) {
			return getRuleContext(PropertyDeclarationContext.class,i);
		}
		public List<FunctionDeclarationContext> functionDeclaration() {
			return getRuleContexts(FunctionDeclarationContext.class);
		}
		public FunctionDeclarationContext functionDeclaration(int i) {
			return getRuleContext(FunctionDeclarationContext.class,i);
		}
		public InterfaceDeclarationListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceDeclarationList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterInterfaceDeclarationList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitInterfaceDeclarationList(this);
		}
	}

	public final InterfaceDeclarationListContext interfaceDeclarationList() throws RecognitionException {
		InterfaceDeclarationListContext _localctx = new InterfaceDeclarationListContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_interfaceDeclarationList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(527); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(527);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
					case 1:
						{
						setState(522);
						declaration();
						}
						break;
					case 2:
						{
						setState(523);
						classMethodDeclaration();
						}
						break;
					case 3:
						{
						setState(524);
						instanceMethodDeclaration();
						}
						break;
					case 4:
						{
						setState(525);
						propertyDeclaration();
						}
						break;
					case 5:
						{
						setState(526);
						functionDeclaration();
						}
						break;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(529); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassMethodDeclarationContext extends ParserRuleContext {
		public TerminalNode ADD() { return getToken(ObjectiveCParser.ADD, 0); }
		public MethodDeclarationContext methodDeclaration() {
			return getRuleContext(MethodDeclarationContext.class,0);
		}
		public ClassMethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classMethodDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterClassMethodDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitClassMethodDeclaration(this);
		}
	}

	public final ClassMethodDeclarationContext classMethodDeclaration() throws RecognitionException {
		ClassMethodDeclarationContext _localctx = new ClassMethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_classMethodDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(531);
			match(ADD);
			setState(532);
			methodDeclaration();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstanceMethodDeclarationContext extends ParserRuleContext {
		public TerminalNode SUB() { return getToken(ObjectiveCParser.SUB, 0); }
		public MethodDeclarationContext methodDeclaration() {
			return getRuleContext(MethodDeclarationContext.class,0);
		}
		public InstanceMethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instanceMethodDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterInstanceMethodDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitInstanceMethodDeclaration(this);
		}
	}

	public final InstanceMethodDeclarationContext instanceMethodDeclaration() throws RecognitionException {
		InstanceMethodDeclarationContext _localctx = new InstanceMethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_instanceMethodDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(534);
			match(SUB);
			setState(535);
			methodDeclaration();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodDeclarationContext extends ParserRuleContext {
		public MethodSelectorContext methodSelector() {
			return getRuleContext(MethodSelectorContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ObjectiveCParser.SEMI, 0); }
		public MethodTypeContext methodType() {
			return getRuleContext(MethodTypeContext.class,0);
		}
		public MacroContext macro() {
			return getRuleContext(MacroContext.class,0);
		}
		public MethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterMethodDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitMethodDeclaration(this);
		}
	}

	public final MethodDeclarationContext methodDeclaration() throws RecognitionException {
		MethodDeclarationContext _localctx = new MethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_methodDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(538);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LP) {
				{
				setState(537);
				methodType();
				}
			}

			setState(540);
			methodSelector();
			setState(542);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0)) {
				{
				setState(541);
				macro();
				}
			}

			setState(544);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ImplementationDefinitionListContext extends ParserRuleContext {
		public List<FunctionDefinitionContext> functionDefinition() {
			return getRuleContexts(FunctionDefinitionContext.class);
		}
		public FunctionDefinitionContext functionDefinition(int i) {
			return getRuleContext(FunctionDefinitionContext.class,i);
		}
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public List<ClassMethodDefinitionContext> classMethodDefinition() {
			return getRuleContexts(ClassMethodDefinitionContext.class);
		}
		public ClassMethodDefinitionContext classMethodDefinition(int i) {
			return getRuleContext(ClassMethodDefinitionContext.class,i);
		}
		public List<InstanceMethodDefinitionContext> instanceMethodDefinition() {
			return getRuleContexts(InstanceMethodDefinitionContext.class);
		}
		public InstanceMethodDefinitionContext instanceMethodDefinition(int i) {
			return getRuleContext(InstanceMethodDefinitionContext.class,i);
		}
		public List<PropertyImplementationContext> propertyImplementation() {
			return getRuleContexts(PropertyImplementationContext.class);
		}
		public PropertyImplementationContext propertyImplementation(int i) {
			return getRuleContext(PropertyImplementationContext.class,i);
		}
		public ImplementationDefinitionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_implementationDefinitionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterImplementationDefinitionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitImplementationDefinitionList(this);
		}
	}

	public final ImplementationDefinitionListContext implementationDefinitionList() throws RecognitionException {
		ImplementationDefinitionListContext _localctx = new ImplementationDefinitionListContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_implementationDefinitionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(551); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(551);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
				case 1:
					{
					setState(546);
					functionDefinition();
					}
					break;
				case 2:
					{
					setState(547);
					declaration();
					}
					break;
				case 3:
					{
					setState(548);
					classMethodDefinition();
					}
					break;
				case 4:
					{
					setState(549);
					instanceMethodDefinition();
					}
					break;
				case 5:
					{
					setState(550);
					propertyImplementation();
					}
					break;
				}
				}
				setState(553); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AUTO) | (1L << CHAR) | (1L << CONST) | (1L << DOUBLE) | (1L << ENUM) | (1L << EXTERN) | (1L << FLOAT) | (1L << INLINE) | (1L << INT) | (1L << LONG) | (1L << REGISTER) | (1L << RESTRICT) | (1L << SHORT) | (1L << SIGNED) | (1L << STATIC) | (1L << STRUCT) | (1L << TYPEDEF) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID) | (1L << VOLATILE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << DYNAMIC))) != 0) || ((((_la - 78)) & ~0x3f) == 0 && ((1L << (_la - 78)) & ((1L << (SYNTHESIZE - 78)) | (1L << (ATOMIC - 78)) | (1L << (NONATOMIC - 78)) | (1L << (RETAIN - 78)) | (1L << (ATTRIBUTE - 78)) | (1L << (AUTORELEASING_QUALIFIER - 78)) | (1L << (BLOCK - 78)) | (1L << (BRIDGE - 78)) | (1L << (BRIDGE_RETAINED - 78)) | (1L << (BRIDGE_TRANSFER - 78)) | (1L << (COVARIANT - 78)) | (1L << (CONTRAVARIANT - 78)) | (1L << (DEPRECATED - 78)) | (1L << (KINDOF - 78)) | (1L << (STRONG_QUALIFIER - 78)) | (1L << (TYPEOF - 78)) | (1L << (UNSAFE_UNRETAINED_QUALIFIER - 78)) | (1L << (UNUSED - 78)) | (1L << (WEAK_QUALIFIER - 78)) | (1L << (NULL_UNSPECIFIED - 78)) | (1L << (NULLABLE - 78)) | (1L << (NONNULL - 78)) | (1L << (NULL_RESETTABLE - 78)) | (1L << (NS_INLINE - 78)) | (1L << (NS_ENUM - 78)) | (1L << (NS_OPTIONS - 78)) | (1L << (ASSIGN - 78)) | (1L << (COPY - 78)) | (1L << (GETTER - 78)) | (1L << (SETTER - 78)) | (1L << (STRONG - 78)) | (1L << (READONLY - 78)) | (1L << (READWRITE - 78)) | (1L << (WEAK - 78)) | (1L << (UNSAFE_UNRETAINED - 78)) | (1L << (IB_OUTLET - 78)) | (1L << (IB_OUTLET_COLLECTION - 78)) | (1L << (IB_INSPECTABLE - 78)) | (1L << (IB_DESIGNABLE - 78)) | (1L << (IDENTIFIER - 78)))) != 0) || _la==ADD || _la==SUB );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassMethodDefinitionContext extends ParserRuleContext {
		public TerminalNode ADD() { return getToken(ObjectiveCParser.ADD, 0); }
		public MethodDefinitionContext methodDefinition() {
			return getRuleContext(MethodDefinitionContext.class,0);
		}
		public ClassMethodDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classMethodDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterClassMethodDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitClassMethodDefinition(this);
		}
	}

	public final ClassMethodDefinitionContext classMethodDefinition() throws RecognitionException {
		ClassMethodDefinitionContext _localctx = new ClassMethodDefinitionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_classMethodDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(555);
			match(ADD);
			setState(556);
			methodDefinition();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstanceMethodDefinitionContext extends ParserRuleContext {
		public TerminalNode SUB() { return getToken(ObjectiveCParser.SUB, 0); }
		public MethodDefinitionContext methodDefinition() {
			return getRuleContext(MethodDefinitionContext.class,0);
		}
		public InstanceMethodDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instanceMethodDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterInstanceMethodDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitInstanceMethodDefinition(this);
		}
	}

	public final InstanceMethodDefinitionContext instanceMethodDefinition() throws RecognitionException {
		InstanceMethodDefinitionContext _localctx = new InstanceMethodDefinitionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_instanceMethodDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(558);
			match(SUB);
			setState(559);
			methodDefinition();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodDefinitionContext extends ParserRuleContext {
		public MethodSelectorContext methodSelector() {
			return getRuleContext(MethodSelectorContext.class,0);
		}
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public MethodTypeContext methodType() {
			return getRuleContext(MethodTypeContext.class,0);
		}
		public InitDeclaratorListContext initDeclaratorList() {
			return getRuleContext(InitDeclaratorListContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ObjectiveCParser.SEMI, 0); }
		public MethodDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterMethodDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitMethodDefinition(this);
		}
	}

	public final MethodDefinitionContext methodDefinition() throws RecognitionException {
		MethodDefinitionContext _localctx = new MethodDefinitionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_methodDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(562);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LP) {
				{
				setState(561);
				methodType();
				}
			}

			setState(564);
			methodSelector();
			setState(566);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 40)) & ~0x3f) == 0 && ((1L << (_la - 40)) & ((1L << (BOOL - 40)) | (1L << (Class - 40)) | (1L << (BYCOPY - 40)) | (1L << (BYREF - 40)) | (1L << (ID - 40)) | (1L << (IMP - 40)) | (1L << (IN - 40)) | (1L << (INOUT - 40)) | (1L << (ONEWAY - 40)) | (1L << (OUT - 40)) | (1L << (PROTOCOL_ - 40)) | (1L << (SEL - 40)) | (1L << (SELF - 40)) | (1L << (SUPER - 40)) | (1L << (ATOMIC - 40)) | (1L << (NONATOMIC - 40)) | (1L << (RETAIN - 40)) | (1L << (AUTORELEASING_QUALIFIER - 40)) | (1L << (BLOCK - 40)) | (1L << (BRIDGE_RETAINED - 40)) | (1L << (BRIDGE_TRANSFER - 40)) | (1L << (COVARIANT - 40)) | (1L << (CONTRAVARIANT - 40)) | (1L << (DEPRECATED - 40)) | (1L << (KINDOF - 40)) | (1L << (UNUSED - 40)) | (1L << (NULL_UNSPECIFIED - 40)) | (1L << (NULLABLE - 40)) | (1L << (NONNULL - 40)) | (1L << (NULL_RESETTABLE - 40)) | (1L << (NS_INLINE - 40)))) != 0) || ((((_la - 104)) & ~0x3f) == 0 && ((1L << (_la - 104)) & ((1L << (NS_ENUM - 104)) | (1L << (NS_OPTIONS - 104)) | (1L << (ASSIGN - 104)) | (1L << (COPY - 104)) | (1L << (GETTER - 104)) | (1L << (SETTER - 104)) | (1L << (STRONG - 104)) | (1L << (READONLY - 104)) | (1L << (READWRITE - 104)) | (1L << (WEAK - 104)) | (1L << (UNSAFE_UNRETAINED - 104)) | (1L << (IB_OUTLET - 104)) | (1L << (IB_OUTLET_COLLECTION - 104)) | (1L << (IB_INSPECTABLE - 104)) | (1L << (IB_DESIGNABLE - 104)) | (1L << (IDENTIFIER - 104)) | (1L << (LP - 104)) | (1L << (MUL - 104)))) != 0)) {
				{
				setState(565);
				initDeclaratorList();
				}
			}

			setState(569);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMI) {
				{
				setState(568);
				match(SEMI);
				}
			}

			setState(571);
			compoundStatement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodSelectorContext extends ParserRuleContext {
		public SelectorContext selector() {
			return getRuleContext(SelectorContext.class,0);
		}
		public List<KeywordDeclaratorContext> keywordDeclarator() {
			return getRuleContexts(KeywordDeclaratorContext.class);
		}
		public KeywordDeclaratorContext keywordDeclarator(int i) {
			return getRuleContext(KeywordDeclaratorContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(ObjectiveCParser.COMMA, 0); }
		public TerminalNode ELIPSIS() { return getToken(ObjectiveCParser.ELIPSIS, 0); }
		public MethodSelectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodSelector; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterMethodSelector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitMethodSelector(this);
		}
	}

	public final MethodSelectorContext methodSelector() throws RecognitionException {
		MethodSelectorContext _localctx = new MethodSelectorContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_methodSelector);
		int _la;
		try {
			int _alt;
			setState(583);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(573);
				selector();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(575); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(574);
						keywordDeclarator();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(577); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(581);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(579);
					match(COMMA);
					setState(580);
					match(ELIPSIS);
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KeywordDeclaratorContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(ObjectiveCParser.COLON, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public SelectorContext selector() {
			return getRuleContext(SelectorContext.class,0);
		}
		public List<MethodTypeContext> methodType() {
			return getRuleContexts(MethodTypeContext.class);
		}
		public MethodTypeContext methodType(int i) {
			return getRuleContext(MethodTypeContext.class,i);
		}
		public ArcBehaviourSpecifierContext arcBehaviourSpecifier() {
			return getRuleContext(ArcBehaviourSpecifierContext.class,0);
		}
		public KeywordDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keywordDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterKeywordDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitKeywordDeclarator(this);
		}
	}

	public final KeywordDeclaratorContext keywordDeclarator() throws RecognitionException {
		KeywordDeclaratorContext _localctx = new KeywordDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_keywordDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(586);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0)) {
				{
				setState(585);
				selector();
				}
			}

			setState(588);
			match(COLON);
			setState(592);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LP) {
				{
				{
				setState(589);
				methodType();
				}
				}
				setState(594);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(596);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				{
				setState(595);
				arcBehaviourSpecifier();
				}
				break;
			}
			setState(598);
			identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectorContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode RETURN() { return getToken(ObjectiveCParser.RETURN, 0); }
		public SelectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selector; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterSelector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitSelector(this);
		}
	}

	public final SelectorContext selector() throws RecognitionException {
		SelectorContext _localctx = new SelectorContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_selector);
		try {
			setState(602);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOL:
			case Class:
			case BYCOPY:
			case BYREF:
			case ID:
			case IMP:
			case IN:
			case INOUT:
			case ONEWAY:
			case OUT:
			case PROTOCOL_:
			case SEL:
			case SELF:
			case SUPER:
			case ATOMIC:
			case NONATOMIC:
			case RETAIN:
			case AUTORELEASING_QUALIFIER:
			case BLOCK:
			case BRIDGE_RETAINED:
			case BRIDGE_TRANSFER:
			case COVARIANT:
			case CONTRAVARIANT:
			case DEPRECATED:
			case KINDOF:
			case UNUSED:
			case NULL_UNSPECIFIED:
			case NULLABLE:
			case NONNULL:
			case NULL_RESETTABLE:
			case NS_INLINE:
			case NS_ENUM:
			case NS_OPTIONS:
			case ASSIGN:
			case COPY:
			case GETTER:
			case SETTER:
			case STRONG:
			case READONLY:
			case READWRITE:
			case WEAK:
			case UNSAFE_UNRETAINED:
			case IB_OUTLET:
			case IB_OUTLET_COLLECTION:
			case IB_INSPECTABLE:
			case IB_DESIGNABLE:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(600);
				identifier();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 2);
				{
				setState(601);
				match(RETURN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodTypeContext extends ParserRuleContext {
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public MethodTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterMethodType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitMethodType(this);
		}
	}

	public final MethodTypeContext methodType() throws RecognitionException {
		MethodTypeContext _localctx = new MethodTypeContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_methodType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(604);
			match(LP);
			setState(605);
			typeName();
			setState(606);
			match(RP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PropertyImplementationContext extends ParserRuleContext {
		public TerminalNode SYNTHESIZE() { return getToken(ObjectiveCParser.SYNTHESIZE, 0); }
		public PropertySynthesizeListContext propertySynthesizeList() {
			return getRuleContext(PropertySynthesizeListContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ObjectiveCParser.SEMI, 0); }
		public TerminalNode DYNAMIC() { return getToken(ObjectiveCParser.DYNAMIC, 0); }
		public PropertyImplementationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyImplementation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterPropertyImplementation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitPropertyImplementation(this);
		}
	}

	public final PropertyImplementationContext propertyImplementation() throws RecognitionException {
		PropertyImplementationContext _localctx = new PropertyImplementationContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_propertyImplementation);
		try {
			setState(616);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SYNTHESIZE:
				enterOuterAlt(_localctx, 1);
				{
				setState(608);
				match(SYNTHESIZE);
				setState(609);
				propertySynthesizeList();
				setState(610);
				match(SEMI);
				}
				break;
			case DYNAMIC:
				enterOuterAlt(_localctx, 2);
				{
				setState(612);
				match(DYNAMIC);
				setState(613);
				propertySynthesizeList();
				setState(614);
				match(SEMI);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PropertySynthesizeListContext extends ParserRuleContext {
		public List<PropertySynthesizeItemContext> propertySynthesizeItem() {
			return getRuleContexts(PropertySynthesizeItemContext.class);
		}
		public PropertySynthesizeItemContext propertySynthesizeItem(int i) {
			return getRuleContext(PropertySynthesizeItemContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ObjectiveCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ObjectiveCParser.COMMA, i);
		}
		public PropertySynthesizeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertySynthesizeList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterPropertySynthesizeList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitPropertySynthesizeList(this);
		}
	}

	public final PropertySynthesizeListContext propertySynthesizeList() throws RecognitionException {
		PropertySynthesizeListContext _localctx = new PropertySynthesizeListContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_propertySynthesizeList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(618);
			propertySynthesizeItem();
			setState(623);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(619);
				match(COMMA);
				setState(620);
				propertySynthesizeItem();
				}
				}
				setState(625);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PropertySynthesizeItemContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode ASSIGNMENT() { return getToken(ObjectiveCParser.ASSIGNMENT, 0); }
		public PropertySynthesizeItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertySynthesizeItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterPropertySynthesizeItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitPropertySynthesizeItem(this);
		}
	}

	public final PropertySynthesizeItemContext propertySynthesizeItem() throws RecognitionException {
		PropertySynthesizeItemContext _localctx = new PropertySynthesizeItemContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_propertySynthesizeItem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(626);
			identifier();
			setState(629);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGNMENT) {
				{
				setState(627);
				match(ASSIGNMENT);
				setState(628);
				identifier();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockTypeContext extends ParserRuleContext {
		public List<TypeSpecifierContext> typeSpecifier() {
			return getRuleContexts(TypeSpecifierContext.class);
		}
		public TypeSpecifierContext typeSpecifier(int i) {
			return getRuleContext(TypeSpecifierContext.class,i);
		}
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public TerminalNode BITXOR() { return getToken(ObjectiveCParser.BITXOR, 0); }
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public List<NullabilitySpecifierContext> nullabilitySpecifier() {
			return getRuleContexts(NullabilitySpecifierContext.class);
		}
		public NullabilitySpecifierContext nullabilitySpecifier(int i) {
			return getRuleContext(NullabilitySpecifierContext.class,i);
		}
		public BlockParametersContext blockParameters() {
			return getRuleContext(BlockParametersContext.class,0);
		}
		public BlockTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterBlockType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitBlockType(this);
		}
	}

	public final BlockTypeContext blockType() throws RecognitionException {
		BlockTypeContext _localctx = new BlockTypeContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_blockType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(632);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				{
				setState(631);
				nullabilitySpecifier();
				}
				break;
			}
			setState(634);
			typeSpecifier();
			setState(636);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 99)) & ~0x3f) == 0 && ((1L << (_la - 99)) & ((1L << (NULL_UNSPECIFIED - 99)) | (1L << (NULLABLE - 99)) | (1L << (NONNULL - 99)) | (1L << (NULL_RESETTABLE - 99)))) != 0)) {
				{
				setState(635);
				nullabilitySpecifier();
				}
			}

			setState(638);
			match(LP);
			setState(639);
			match(BITXOR);
			setState(642);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
			case 1:
				{
				setState(640);
				nullabilitySpecifier();
				}
				break;
			case 2:
				{
				setState(641);
				typeSpecifier();
				}
				break;
			}
			setState(644);
			match(RP);
			setState(646);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LP) {
				{
				setState(645);
				blockParameters();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GenericsSpecifierContext extends ParserRuleContext {
		public TerminalNode LT() { return getToken(ObjectiveCParser.LT, 0); }
		public TerminalNode GT() { return getToken(ObjectiveCParser.GT, 0); }
		public List<TypeSpecifierWithPrefixesContext> typeSpecifierWithPrefixes() {
			return getRuleContexts(TypeSpecifierWithPrefixesContext.class);
		}
		public TypeSpecifierWithPrefixesContext typeSpecifierWithPrefixes(int i) {
			return getRuleContext(TypeSpecifierWithPrefixesContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ObjectiveCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ObjectiveCParser.COMMA, i);
		}
		public GenericsSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_genericsSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterGenericsSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitGenericsSpecifier(this);
		}
	}

	public final GenericsSpecifierContext genericsSpecifier() throws RecognitionException {
		GenericsSpecifierContext _localctx = new GenericsSpecifierContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_genericsSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(648);
			match(LT);
			setState(657);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CHAR) | (1L << DOUBLE) | (1L << ENUM) | (1L << FLOAT) | (1L << INLINE) | (1L << INT) | (1L << LONG) | (1L << SHORT) | (1L << SIGNED) | (1L << STRUCT) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (TYPEOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0)) {
				{
				setState(649);
				typeSpecifierWithPrefixes();
				setState(654);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(650);
					match(COMMA);
					setState(651);
					typeSpecifierWithPrefixes();
					}
					}
					setState(656);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(659);
			match(GT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeSpecifierWithPrefixesContext extends ParserRuleContext {
		public TypeSpecifierContext typeSpecifier() {
			return getRuleContext(TypeSpecifierContext.class,0);
		}
		public List<TypePrefixContext> typePrefix() {
			return getRuleContexts(TypePrefixContext.class);
		}
		public TypePrefixContext typePrefix(int i) {
			return getRuleContext(TypePrefixContext.class,i);
		}
		public TypeSpecifierWithPrefixesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeSpecifierWithPrefixes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterTypeSpecifierWithPrefixes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitTypeSpecifierWithPrefixes(this);
		}
	}

	public final TypeSpecifierWithPrefixesContext typeSpecifierWithPrefixes() throws RecognitionException {
		TypeSpecifierWithPrefixesContext _localctx = new TypeSpecifierWithPrefixesContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_typeSpecifierWithPrefixes);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(664);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,59,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(661);
					typePrefix();
					}
					} 
				}
				setState(666);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,59,_ctx);
			}
			setState(667);
			typeSpecifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DictionaryExpressionContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(ObjectiveCParser.AT, 0); }
		public TerminalNode LBRACE() { return getToken(ObjectiveCParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ObjectiveCParser.RBRACE, 0); }
		public List<DictionaryPairContext> dictionaryPair() {
			return getRuleContexts(DictionaryPairContext.class);
		}
		public DictionaryPairContext dictionaryPair(int i) {
			return getRuleContext(DictionaryPairContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ObjectiveCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ObjectiveCParser.COMMA, i);
		}
		public DictionaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dictionaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterDictionaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitDictionaryExpression(this);
		}
	}

	public final DictionaryExpressionContext dictionaryExpression() throws RecognitionException {
		DictionaryExpressionContext _localctx = new DictionaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_dictionaryExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(669);
			match(AT);
			setState(670);
			match(LBRACE);
			setState(682);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SIZEOF) | (1L << TRUE) | (1L << FALSE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << NIL) | (1L << NO) | (1L << NULL) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << YES) | (1L << ENCODE))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (PROTOCOL - 69)) | (1L << (SELECTOR - 69)) | (1L << (ATOMIC - 69)) | (1L << (NONATOMIC - 69)) | (1L << (RETAIN - 69)) | (1L << (AUTORELEASING_QUALIFIER - 69)) | (1L << (BLOCK - 69)) | (1L << (BRIDGE_RETAINED - 69)) | (1L << (BRIDGE_TRANSFER - 69)) | (1L << (COVARIANT - 69)) | (1L << (CONTRAVARIANT - 69)) | (1L << (DEPRECATED - 69)) | (1L << (KINDOF - 69)) | (1L << (UNUSED - 69)) | (1L << (NULL_UNSPECIFIED - 69)) | (1L << (NULLABLE - 69)) | (1L << (NONNULL - 69)) | (1L << (NULL_RESETTABLE - 69)) | (1L << (NS_INLINE - 69)) | (1L << (NS_ENUM - 69)) | (1L << (NS_OPTIONS - 69)) | (1L << (ASSIGN - 69)) | (1L << (COPY - 69)) | (1L << (GETTER - 69)) | (1L << (SETTER - 69)) | (1L << (STRONG - 69)) | (1L << (READONLY - 69)) | (1L << (READWRITE - 69)) | (1L << (WEAK - 69)) | (1L << (UNSAFE_UNRETAINED - 69)) | (1L << (IB_OUTLET - 69)) | (1L << (IB_OUTLET_COLLECTION - 69)) | (1L << (IB_INSPECTABLE - 69)) | (1L << (IB_DESIGNABLE - 69)) | (1L << (IDENTIFIER - 69)) | (1L << (LP - 69)) | (1L << (LBRACK - 69)))) != 0) || ((((_la - 136)) & ~0x3f) == 0 && ((1L << (_la - 136)) & ((1L << (AT - 136)) | (1L << (BANG - 136)) | (1L << (TILDE - 136)) | (1L << (INC - 136)) | (1L << (DEC - 136)) | (1L << (ADD - 136)) | (1L << (SUB - 136)) | (1L << (MUL - 136)) | (1L << (BITAND - 136)) | (1L << (BITXOR - 136)) | (1L << (CHARACTER_LITERAL - 136)) | (1L << (STRING_START - 136)) | (1L << (HEX_LITERAL - 136)) | (1L << (OCTAL_LITERAL - 136)) | (1L << (BINARY_LITERAL - 136)) | (1L << (DECIMAL_LITERAL - 136)) | (1L << (FLOATING_POINT_LITERAL - 136)))) != 0)) {
				{
				setState(671);
				dictionaryPair();
				setState(676);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(672);
						match(COMMA);
						setState(673);
						dictionaryPair();
						}
						} 
					}
					setState(678);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
				}
				setState(680);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(679);
					match(COMMA);
					}
				}

				}
			}

			setState(684);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DictionaryPairContext extends ParserRuleContext {
		public CastExpressionContext castExpression() {
			return getRuleContext(CastExpressionContext.class,0);
		}
		public TerminalNode COLON() { return getToken(ObjectiveCParser.COLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DictionaryPairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dictionaryPair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterDictionaryPair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitDictionaryPair(this);
		}
	}

	public final DictionaryPairContext dictionaryPair() throws RecognitionException {
		DictionaryPairContext _localctx = new DictionaryPairContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_dictionaryPair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(686);
			castExpression();
			setState(687);
			match(COLON);
			setState(688);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayExpressionContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(ObjectiveCParser.AT, 0); }
		public TerminalNode LBRACK() { return getToken(ObjectiveCParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(ObjectiveCParser.RBRACK, 0); }
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(ObjectiveCParser.COMMA, 0); }
		public ArrayExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterArrayExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitArrayExpression(this);
		}
	}

	public final ArrayExpressionContext arrayExpression() throws RecognitionException {
		ArrayExpressionContext _localctx = new ArrayExpressionContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_arrayExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(690);
			match(AT);
			setState(691);
			match(LBRACK);
			setState(696);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SIZEOF) | (1L << TRUE) | (1L << FALSE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << NIL) | (1L << NO) | (1L << NULL) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << YES) | (1L << ENCODE))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (PROTOCOL - 69)) | (1L << (SELECTOR - 69)) | (1L << (ATOMIC - 69)) | (1L << (NONATOMIC - 69)) | (1L << (RETAIN - 69)) | (1L << (AUTORELEASING_QUALIFIER - 69)) | (1L << (BLOCK - 69)) | (1L << (BRIDGE_RETAINED - 69)) | (1L << (BRIDGE_TRANSFER - 69)) | (1L << (COVARIANT - 69)) | (1L << (CONTRAVARIANT - 69)) | (1L << (DEPRECATED - 69)) | (1L << (KINDOF - 69)) | (1L << (UNUSED - 69)) | (1L << (NULL_UNSPECIFIED - 69)) | (1L << (NULLABLE - 69)) | (1L << (NONNULL - 69)) | (1L << (NULL_RESETTABLE - 69)) | (1L << (NS_INLINE - 69)) | (1L << (NS_ENUM - 69)) | (1L << (NS_OPTIONS - 69)) | (1L << (ASSIGN - 69)) | (1L << (COPY - 69)) | (1L << (GETTER - 69)) | (1L << (SETTER - 69)) | (1L << (STRONG - 69)) | (1L << (READONLY - 69)) | (1L << (READWRITE - 69)) | (1L << (WEAK - 69)) | (1L << (UNSAFE_UNRETAINED - 69)) | (1L << (IB_OUTLET - 69)) | (1L << (IB_OUTLET_COLLECTION - 69)) | (1L << (IB_INSPECTABLE - 69)) | (1L << (IB_DESIGNABLE - 69)) | (1L << (IDENTIFIER - 69)) | (1L << (LP - 69)) | (1L << (LBRACK - 69)))) != 0) || ((((_la - 136)) & ~0x3f) == 0 && ((1L << (_la - 136)) & ((1L << (AT - 136)) | (1L << (BANG - 136)) | (1L << (TILDE - 136)) | (1L << (INC - 136)) | (1L << (DEC - 136)) | (1L << (ADD - 136)) | (1L << (SUB - 136)) | (1L << (MUL - 136)) | (1L << (BITAND - 136)) | (1L << (BITXOR - 136)) | (1L << (CHARACTER_LITERAL - 136)) | (1L << (STRING_START - 136)) | (1L << (HEX_LITERAL - 136)) | (1L << (OCTAL_LITERAL - 136)) | (1L << (BINARY_LITERAL - 136)) | (1L << (DECIMAL_LITERAL - 136)) | (1L << (FLOATING_POINT_LITERAL - 136)))) != 0)) {
				{
				setState(692);
				expressions();
				setState(694);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(693);
					match(COMMA);
					}
				}

				}
			}

			setState(698);
			match(RBRACK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoxExpressionContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(ObjectiveCParser.AT, 0); }
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public BoxExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boxExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterBoxExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitBoxExpression(this);
		}
	}

	public final BoxExpressionContext boxExpression() throws RecognitionException {
		BoxExpressionContext _localctx = new BoxExpressionContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_boxExpression);
		try {
			setState(710);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(700);
				match(AT);
				setState(701);
				match(LP);
				setState(702);
				expression(0);
				setState(703);
				match(RP);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(705);
				match(AT);
				setState(708);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case TRUE:
				case FALSE:
				case NIL:
				case NO:
				case NULL:
				case YES:
				case ADD:
				case SUB:
				case CHARACTER_LITERAL:
				case HEX_LITERAL:
				case OCTAL_LITERAL:
				case BINARY_LITERAL:
				case DECIMAL_LITERAL:
				case FLOATING_POINT_LITERAL:
					{
					setState(706);
					constant();
					}
					break;
				case BOOL:
				case Class:
				case BYCOPY:
				case BYREF:
				case ID:
				case IMP:
				case IN:
				case INOUT:
				case ONEWAY:
				case OUT:
				case PROTOCOL_:
				case SEL:
				case SELF:
				case SUPER:
				case ATOMIC:
				case NONATOMIC:
				case RETAIN:
				case AUTORELEASING_QUALIFIER:
				case BLOCK:
				case BRIDGE_RETAINED:
				case BRIDGE_TRANSFER:
				case COVARIANT:
				case CONTRAVARIANT:
				case DEPRECATED:
				case KINDOF:
				case UNUSED:
				case NULL_UNSPECIFIED:
				case NULLABLE:
				case NONNULL:
				case NULL_RESETTABLE:
				case NS_INLINE:
				case NS_ENUM:
				case NS_OPTIONS:
				case ASSIGN:
				case COPY:
				case GETTER:
				case SETTER:
				case STRONG:
				case READONLY:
				case READWRITE:
				case WEAK:
				case UNSAFE_UNRETAINED:
				case IB_OUTLET:
				case IB_OUTLET_COLLECTION:
				case IB_INSPECTABLE:
				case IB_DESIGNABLE:
				case IDENTIFIER:
					{
					setState(707);
					identifier();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockParametersContext extends ParserRuleContext {
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public List<TypeVariableDeclaratorOrNameContext> typeVariableDeclaratorOrName() {
			return getRuleContexts(TypeVariableDeclaratorOrNameContext.class);
		}
		public TypeVariableDeclaratorOrNameContext typeVariableDeclaratorOrName(int i) {
			return getRuleContext(TypeVariableDeclaratorOrNameContext.class,i);
		}
		public TerminalNode VOID() { return getToken(ObjectiveCParser.VOID, 0); }
		public List<TerminalNode> COMMA() { return getTokens(ObjectiveCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ObjectiveCParser.COMMA, i);
		}
		public BlockParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterBlockParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitBlockParameters(this);
		}
	}

	public final BlockParametersContext blockParameters() throws RecognitionException {
		BlockParametersContext _localctx = new BlockParametersContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_blockParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(712);
			match(LP);
			setState(724);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AUTO) | (1L << CHAR) | (1L << CONST) | (1L << DOUBLE) | (1L << ENUM) | (1L << EXTERN) | (1L << FLOAT) | (1L << INLINE) | (1L << INT) | (1L << LONG) | (1L << REGISTER) | (1L << RESTRICT) | (1L << SHORT) | (1L << SIGNED) | (1L << STATIC) | (1L << STRUCT) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID) | (1L << VOLATILE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (ATTRIBUTE - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (STRONG_QUALIFIER - 81)) | (1L << (TYPEOF - 81)) | (1L << (UNSAFE_UNRETAINED_QUALIFIER - 81)) | (1L << (UNUSED - 81)) | (1L << (WEAK_QUALIFIER - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0)) {
				{
				setState(715);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,67,_ctx) ) {
				case 1:
					{
					setState(713);
					typeVariableDeclaratorOrName();
					}
					break;
				case 2:
					{
					setState(714);
					match(VOID);
					}
					break;
				}
				setState(721);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(717);
					match(COMMA);
					setState(718);
					typeVariableDeclaratorOrName();
					}
					}
					setState(723);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(726);
			match(RP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeVariableDeclaratorOrNameContext extends ParserRuleContext {
		public TypeVariableDeclaratorContext typeVariableDeclarator() {
			return getRuleContext(TypeVariableDeclaratorContext.class,0);
		}
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TypeVariableDeclaratorOrNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeVariableDeclaratorOrName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterTypeVariableDeclaratorOrName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitTypeVariableDeclaratorOrName(this);
		}
	}

	public final TypeVariableDeclaratorOrNameContext typeVariableDeclaratorOrName() throws RecognitionException {
		TypeVariableDeclaratorOrNameContext _localctx = new TypeVariableDeclaratorOrNameContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_typeVariableDeclaratorOrName);
		try {
			setState(730);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(728);
				typeVariableDeclarator();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(729);
				typeName();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockExpressionContext extends ParserRuleContext {
		public TerminalNode BITXOR() { return getToken(ObjectiveCParser.BITXOR, 0); }
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public TypeSpecifierContext typeSpecifier() {
			return getRuleContext(TypeSpecifierContext.class,0);
		}
		public NullabilitySpecifierContext nullabilitySpecifier() {
			return getRuleContext(NullabilitySpecifierContext.class,0);
		}
		public BlockParametersContext blockParameters() {
			return getRuleContext(BlockParametersContext.class,0);
		}
		public BlockExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterBlockExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitBlockExpression(this);
		}
	}

	public final BlockExpressionContext blockExpression() throws RecognitionException {
		BlockExpressionContext _localctx = new BlockExpressionContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_blockExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(732);
			match(BITXOR);
			setState(734);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
			case 1:
				{
				setState(733);
				typeSpecifier();
				}
				break;
			}
			setState(737);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 99)) & ~0x3f) == 0 && ((1L << (_la - 99)) & ((1L << (NULL_UNSPECIFIED - 99)) | (1L << (NULLABLE - 99)) | (1L << (NONNULL - 99)) | (1L << (NULL_RESETTABLE - 99)))) != 0)) {
				{
				setState(736);
				nullabilitySpecifier();
				}
			}

			setState(740);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LP) {
				{
				setState(739);
				blockParameters();
				}
			}

			setState(742);
			compoundStatement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MessageExpressionContext extends ParserRuleContext {
		public TerminalNode LBRACK() { return getToken(ObjectiveCParser.LBRACK, 0); }
		public ReceiverContext receiver() {
			return getRuleContext(ReceiverContext.class,0);
		}
		public MessageSelectorContext messageSelector() {
			return getRuleContext(MessageSelectorContext.class,0);
		}
		public TerminalNode RBRACK() { return getToken(ObjectiveCParser.RBRACK, 0); }
		public MessageExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_messageExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterMessageExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitMessageExpression(this);
		}
	}

	public final MessageExpressionContext messageExpression() throws RecognitionException {
		MessageExpressionContext _localctx = new MessageExpressionContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_messageExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(744);
			match(LBRACK);
			setState(745);
			receiver();
			setState(746);
			messageSelector();
			setState(747);
			match(RBRACK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReceiverContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TypeSpecifierContext typeSpecifier() {
			return getRuleContext(TypeSpecifierContext.class,0);
		}
		public ReceiverContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_receiver; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterReceiver(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitReceiver(this);
		}
	}

	public final ReceiverContext receiver() throws RecognitionException {
		ReceiverContext _localctx = new ReceiverContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_receiver);
		try {
			setState(751);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,74,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(749);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(750);
				typeSpecifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MessageSelectorContext extends ParserRuleContext {
		public SelectorContext selector() {
			return getRuleContext(SelectorContext.class,0);
		}
		public List<KeywordArgumentContext> keywordArgument() {
			return getRuleContexts(KeywordArgumentContext.class);
		}
		public KeywordArgumentContext keywordArgument(int i) {
			return getRuleContext(KeywordArgumentContext.class,i);
		}
		public MessageSelectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_messageSelector; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterMessageSelector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitMessageSelector(this);
		}
	}

	public final MessageSelectorContext messageSelector() throws RecognitionException {
		MessageSelectorContext _localctx = new MessageSelectorContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_messageSelector);
		int _la;
		try {
			setState(759);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,76,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(753);
				selector();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(755); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(754);
					keywordArgument();
					}
					}
					setState(757); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)) | (1L << (COLON - 81)))) != 0) );
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KeywordArgumentContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(ObjectiveCParser.COLON, 0); }
		public List<KeywordArgumentTypeContext> keywordArgumentType() {
			return getRuleContexts(KeywordArgumentTypeContext.class);
		}
		public KeywordArgumentTypeContext keywordArgumentType(int i) {
			return getRuleContext(KeywordArgumentTypeContext.class,i);
		}
		public SelectorContext selector() {
			return getRuleContext(SelectorContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(ObjectiveCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ObjectiveCParser.COMMA, i);
		}
		public KeywordArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keywordArgument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterKeywordArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitKeywordArgument(this);
		}
	}

	public final KeywordArgumentContext keywordArgument() throws RecognitionException {
		KeywordArgumentContext _localctx = new KeywordArgumentContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_keywordArgument);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(762);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0)) {
				{
				setState(761);
				selector();
				}
			}

			setState(764);
			match(COLON);
			setState(765);
			keywordArgumentType();
			setState(770);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(766);
				match(COMMA);
				setState(767);
				keywordArgumentType();
				}
				}
				setState(772);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KeywordArgumentTypeContext extends ParserRuleContext {
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public NullabilitySpecifierContext nullabilitySpecifier() {
			return getRuleContext(NullabilitySpecifierContext.class,0);
		}
		public TerminalNode LBRACE() { return getToken(ObjectiveCParser.LBRACE, 0); }
		public InitializerListContext initializerList() {
			return getRuleContext(InitializerListContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(ObjectiveCParser.RBRACE, 0); }
		public KeywordArgumentTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keywordArgumentType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterKeywordArgumentType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitKeywordArgumentType(this);
		}
	}

	public final KeywordArgumentTypeContext keywordArgumentType() throws RecognitionException {
		KeywordArgumentTypeContext _localctx = new KeywordArgumentTypeContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_keywordArgumentType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(773);
			expressions();
			setState(775);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,79,_ctx) ) {
			case 1:
				{
				setState(774);
				nullabilitySpecifier();
				}
				break;
			}
			setState(781);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACE) {
				{
				setState(777);
				match(LBRACE);
				setState(778);
				initializerList();
				setState(779);
				match(RBRACE);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectorExpressionContext extends ParserRuleContext {
		public TerminalNode SELECTOR() { return getToken(ObjectiveCParser.SELECTOR, 0); }
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public SelectorNameContext selectorName() {
			return getRuleContext(SelectorNameContext.class,0);
		}
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public SelectorExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectorExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterSelectorExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitSelectorExpression(this);
		}
	}

	public final SelectorExpressionContext selectorExpression() throws RecognitionException {
		SelectorExpressionContext _localctx = new SelectorExpressionContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_selectorExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(783);
			match(SELECTOR);
			setState(784);
			match(LP);
			setState(785);
			selectorName();
			setState(786);
			match(RP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectorNameContext extends ParserRuleContext {
		public List<SelectorContext> selector() {
			return getRuleContexts(SelectorContext.class);
		}
		public SelectorContext selector(int i) {
			return getRuleContext(SelectorContext.class,i);
		}
		public List<TerminalNode> COLON() { return getTokens(ObjectiveCParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(ObjectiveCParser.COLON, i);
		}
		public SelectorNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectorName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterSelectorName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitSelectorName(this);
		}
	}

	public final SelectorNameContext selectorName() throws RecognitionException {
		SelectorNameContext _localctx = new SelectorNameContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_selectorName);
		int _la;
		try {
			setState(797);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,83,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(788);
				selector();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(793); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(790);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0)) {
						{
						setState(789);
						selector();
						}
					}

					setState(792);
					match(COLON);
					}
					}
					setState(795); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)) | (1L << (COLON - 81)))) != 0) );
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProtocolExpressionContext extends ParserRuleContext {
		public TerminalNode PROTOCOL() { return getToken(ObjectiveCParser.PROTOCOL, 0); }
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public ProtocolNameContext protocolName() {
			return getRuleContext(ProtocolNameContext.class,0);
		}
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public ProtocolExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_protocolExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterProtocolExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitProtocolExpression(this);
		}
	}

	public final ProtocolExpressionContext protocolExpression() throws RecognitionException {
		ProtocolExpressionContext _localctx = new ProtocolExpressionContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_protocolExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(799);
			match(PROTOCOL);
			setState(800);
			match(LP);
			setState(801);
			protocolName();
			setState(802);
			match(RP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EncodeExpressionContext extends ParserRuleContext {
		public TerminalNode ENCODE() { return getToken(ObjectiveCParser.ENCODE, 0); }
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public EncodeExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_encodeExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterEncodeExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitEncodeExpression(this);
		}
	}

	public final EncodeExpressionContext encodeExpression() throws RecognitionException {
		EncodeExpressionContext _localctx = new EncodeExpressionContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_encodeExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(804);
			match(ENCODE);
			setState(805);
			match(LP);
			setState(806);
			typeName();
			setState(807);
			match(RP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeVariableDeclaratorContext extends ParserRuleContext {
		public DeclarationSpecifiersContext declarationSpecifiers() {
			return getRuleContext(DeclarationSpecifiersContext.class,0);
		}
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public TypeVariableDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeVariableDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterTypeVariableDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitTypeVariableDeclarator(this);
		}
	}

	public final TypeVariableDeclaratorContext typeVariableDeclarator() throws RecognitionException {
		TypeVariableDeclaratorContext _localctx = new TypeVariableDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_typeVariableDeclarator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(809);
			declarationSpecifiers();
			setState(810);
			declarator();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ThrowStatementContext extends ParserRuleContext {
		public TerminalNode THROW() { return getToken(ObjectiveCParser.THROW, 0); }
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ThrowStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_throwStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterThrowStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitThrowStatement(this);
		}
	}

	public final ThrowStatementContext throwStatement() throws RecognitionException {
		ThrowStatementContext _localctx = new ThrowStatementContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_throwStatement);
		try {
			setState(819);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,84,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(812);
				match(THROW);
				setState(813);
				match(LP);
				setState(814);
				identifier();
				setState(815);
				match(RP);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(817);
				match(THROW);
				setState(818);
				expression(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TryBlockContext extends ParserRuleContext {
		public CompoundStatementContext tryStatement;
		public CompoundStatementContext finallyStatement;
		public TerminalNode TRY() { return getToken(ObjectiveCParser.TRY, 0); }
		public List<CompoundStatementContext> compoundStatement() {
			return getRuleContexts(CompoundStatementContext.class);
		}
		public CompoundStatementContext compoundStatement(int i) {
			return getRuleContext(CompoundStatementContext.class,i);
		}
		public List<CatchStatementContext> catchStatement() {
			return getRuleContexts(CatchStatementContext.class);
		}
		public CatchStatementContext catchStatement(int i) {
			return getRuleContext(CatchStatementContext.class,i);
		}
		public TerminalNode FINALLY() { return getToken(ObjectiveCParser.FINALLY, 0); }
		public TryBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tryBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterTryBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitTryBlock(this);
		}
	}

	public final TryBlockContext tryBlock() throws RecognitionException {
		TryBlockContext _localctx = new TryBlockContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_tryBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(821);
			match(TRY);
			setState(822);
			((TryBlockContext)_localctx).tryStatement = compoundStatement();
			setState(826);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CATCH) {
				{
				{
				setState(823);
				catchStatement();
				}
				}
				setState(828);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(831);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FINALLY) {
				{
				setState(829);
				match(FINALLY);
				setState(830);
				((TryBlockContext)_localctx).finallyStatement = compoundStatement();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CatchStatementContext extends ParserRuleContext {
		public TerminalNode CATCH() { return getToken(ObjectiveCParser.CATCH, 0); }
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public TypeVariableDeclaratorContext typeVariableDeclarator() {
			return getRuleContext(TypeVariableDeclaratorContext.class,0);
		}
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public CatchStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catchStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterCatchStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitCatchStatement(this);
		}
	}

	public final CatchStatementContext catchStatement() throws RecognitionException {
		CatchStatementContext _localctx = new CatchStatementContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_catchStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(833);
			match(CATCH);
			setState(834);
			match(LP);
			setState(835);
			typeVariableDeclarator();
			setState(836);
			match(RP);
			setState(837);
			compoundStatement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SynchronizedStatementContext extends ParserRuleContext {
		public TerminalNode SYNCHRONIZED() { return getToken(ObjectiveCParser.SYNCHRONIZED, 0); }
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public SynchronizedStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_synchronizedStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterSynchronizedStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitSynchronizedStatement(this);
		}
	}

	public final SynchronizedStatementContext synchronizedStatement() throws RecognitionException {
		SynchronizedStatementContext _localctx = new SynchronizedStatementContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_synchronizedStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(839);
			match(SYNCHRONIZED);
			setState(840);
			match(LP);
			setState(841);
			expression(0);
			setState(842);
			match(RP);
			setState(843);
			compoundStatement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AutoreleaseStatementContext extends ParserRuleContext {
		public TerminalNode AUTORELEASEPOOL() { return getToken(ObjectiveCParser.AUTORELEASEPOOL, 0); }
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public AutoreleaseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_autoreleaseStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterAutoreleaseStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitAutoreleaseStatement(this);
		}
	}

	public final AutoreleaseStatementContext autoreleaseStatement() throws RecognitionException {
		AutoreleaseStatementContext _localctx = new AutoreleaseStatementContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_autoreleaseStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(845);
			match(AUTORELEASEPOOL);
			setState(846);
			compoundStatement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDeclarationContext extends ParserRuleContext {
		public FunctionSignatureContext functionSignature() {
			return getRuleContext(FunctionSignatureContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ObjectiveCParser.SEMI, 0); }
		public FunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterFunctionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitFunctionDeclaration(this);
		}
	}

	public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
		FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_functionDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(848);
			functionSignature();
			setState(849);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDefinitionContext extends ParserRuleContext {
		public FunctionSignatureContext functionSignature() {
			return getRuleContext(FunctionSignatureContext.class,0);
		}
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public FunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterFunctionDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitFunctionDefinition(this);
		}
	}

	public final FunctionDefinitionContext functionDefinition() throws RecognitionException {
		FunctionDefinitionContext _localctx = new FunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_functionDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(851);
			functionSignature();
			setState(852);
			compoundStatement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionSignatureContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public DeclarationSpecifiersContext declarationSpecifiers() {
			return getRuleContext(DeclarationSpecifiersContext.class,0);
		}
		public AttributeSpecifierContext attributeSpecifier() {
			return getRuleContext(AttributeSpecifierContext.class,0);
		}
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public FunctionSignatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionSignature; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterFunctionSignature(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitFunctionSignature(this);
		}
	}

	public final FunctionSignatureContext functionSignature() throws RecognitionException {
		FunctionSignatureContext _localctx = new FunctionSignatureContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_functionSignature);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(855);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,87,_ctx) ) {
			case 1:
				{
				setState(854);
				declarationSpecifiers();
				}
				break;
			}
			setState(857);
			identifier();
			{
			setState(858);
			match(LP);
			setState(860);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AUTO) | (1L << CHAR) | (1L << CONST) | (1L << DOUBLE) | (1L << ENUM) | (1L << EXTERN) | (1L << FLOAT) | (1L << INLINE) | (1L << INT) | (1L << LONG) | (1L << REGISTER) | (1L << RESTRICT) | (1L << SHORT) | (1L << SIGNED) | (1L << STATIC) | (1L << STRUCT) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID) | (1L << VOLATILE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (ATTRIBUTE - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (STRONG_QUALIFIER - 81)) | (1L << (TYPEOF - 81)) | (1L << (UNSAFE_UNRETAINED_QUALIFIER - 81)) | (1L << (UNUSED - 81)) | (1L << (WEAK_QUALIFIER - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0)) {
				{
				setState(859);
				parameterList();
				}
			}

			setState(862);
			match(RP);
			}
			setState(865);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ATTRIBUTE) {
				{
				setState(864);
				attributeSpecifier();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributeContext extends ParserRuleContext {
		public AttributeNameContext attributeName() {
			return getRuleContext(AttributeNameContext.class,0);
		}
		public AttributeParametersContext attributeParameters() {
			return getRuleContext(AttributeParametersContext.class,0);
		}
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitAttribute(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_attribute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(867);
			attributeName();
			setState(869);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LP) {
				{
				setState(868);
				attributeParameters();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributeNameContext extends ParserRuleContext {
		public TerminalNode CONST() { return getToken(ObjectiveCParser.CONST, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public AttributeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterAttributeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitAttributeName(this);
		}
	}

	public final AttributeNameContext attributeName() throws RecognitionException {
		AttributeNameContext _localctx = new AttributeNameContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_attributeName);
		try {
			setState(873);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONST:
				enterOuterAlt(_localctx, 1);
				{
				setState(871);
				match(CONST);
				}
				break;
			case BOOL:
			case Class:
			case BYCOPY:
			case BYREF:
			case ID:
			case IMP:
			case IN:
			case INOUT:
			case ONEWAY:
			case OUT:
			case PROTOCOL_:
			case SEL:
			case SELF:
			case SUPER:
			case ATOMIC:
			case NONATOMIC:
			case RETAIN:
			case AUTORELEASING_QUALIFIER:
			case BLOCK:
			case BRIDGE_RETAINED:
			case BRIDGE_TRANSFER:
			case COVARIANT:
			case CONTRAVARIANT:
			case DEPRECATED:
			case KINDOF:
			case UNUSED:
			case NULL_UNSPECIFIED:
			case NULLABLE:
			case NONNULL:
			case NULL_RESETTABLE:
			case NS_INLINE:
			case NS_ENUM:
			case NS_OPTIONS:
			case ASSIGN:
			case COPY:
			case GETTER:
			case SETTER:
			case STRONG:
			case READONLY:
			case READWRITE:
			case WEAK:
			case UNSAFE_UNRETAINED:
			case IB_OUTLET:
			case IB_OUTLET_COLLECTION:
			case IB_INSPECTABLE:
			case IB_DESIGNABLE:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(872);
				identifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributeParametersContext extends ParserRuleContext {
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public AttributeParameterListContext attributeParameterList() {
			return getRuleContext(AttributeParameterListContext.class,0);
		}
		public AttributeParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterAttributeParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitAttributeParameters(this);
		}
	}

	public final AttributeParametersContext attributeParameters() throws RecognitionException {
		AttributeParametersContext _localctx = new AttributeParametersContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_attributeParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(875);
			match(LP);
			setState(877);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONST) | (1L << TRUE) | (1L << FALSE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << NIL) | (1L << NO) | (1L << NULL) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << YES))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0) || ((((_la - 152)) & ~0x3f) == 0 && ((1L << (_la - 152)) & ((1L << (ADD - 152)) | (1L << (SUB - 152)) | (1L << (CHARACTER_LITERAL - 152)) | (1L << (STRING_START - 152)) | (1L << (HEX_LITERAL - 152)) | (1L << (OCTAL_LITERAL - 152)) | (1L << (BINARY_LITERAL - 152)) | (1L << (DECIMAL_LITERAL - 152)) | (1L << (FLOATING_POINT_LITERAL - 152)))) != 0)) {
				{
				setState(876);
				attributeParameterList();
				}
			}

			setState(879);
			match(RP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributeParameterListContext extends ParserRuleContext {
		public List<AttributeParameterContext> attributeParameter() {
			return getRuleContexts(AttributeParameterContext.class);
		}
		public AttributeParameterContext attributeParameter(int i) {
			return getRuleContext(AttributeParameterContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ObjectiveCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ObjectiveCParser.COMMA, i);
		}
		public AttributeParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeParameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterAttributeParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitAttributeParameterList(this);
		}
	}

	public final AttributeParameterListContext attributeParameterList() throws RecognitionException {
		AttributeParameterListContext _localctx = new AttributeParameterListContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_attributeParameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(881);
			attributeParameter();
			setState(886);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(882);
				match(COMMA);
				setState(883);
				attributeParameter();
				}
				}
				setState(888);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributeParameterContext extends ParserRuleContext {
		public AttributeContext attribute() {
			return getRuleContext(AttributeContext.class,0);
		}
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public AttributeParameterAssignmentContext attributeParameterAssignment() {
			return getRuleContext(AttributeParameterAssignmentContext.class,0);
		}
		public AttributeParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterAttributeParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitAttributeParameter(this);
		}
	}

	public final AttributeParameterContext attributeParameter() throws RecognitionException {
		AttributeParameterContext _localctx = new AttributeParameterContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_attributeParameter);
		try {
			setState(893);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,94,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(889);
				attribute();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(890);
				constant();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(891);
				stringLiteral();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(892);
				attributeParameterAssignment();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributeParameterAssignmentContext extends ParserRuleContext {
		public List<AttributeNameContext> attributeName() {
			return getRuleContexts(AttributeNameContext.class);
		}
		public AttributeNameContext attributeName(int i) {
			return getRuleContext(AttributeNameContext.class,i);
		}
		public TerminalNode ASSIGNMENT() { return getToken(ObjectiveCParser.ASSIGNMENT, 0); }
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public AttributeParameterAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeParameterAssignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterAttributeParameterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitAttributeParameterAssignment(this);
		}
	}

	public final AttributeParameterAssignmentContext attributeParameterAssignment() throws RecognitionException {
		AttributeParameterAssignmentContext _localctx = new AttributeParameterAssignmentContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_attributeParameterAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(895);
			attributeName();
			setState(896);
			match(ASSIGNMENT);
			setState(900);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
			case FALSE:
			case NIL:
			case NO:
			case NULL:
			case YES:
			case ADD:
			case SUB:
			case CHARACTER_LITERAL:
			case HEX_LITERAL:
			case OCTAL_LITERAL:
			case BINARY_LITERAL:
			case DECIMAL_LITERAL:
			case FLOATING_POINT_LITERAL:
				{
				setState(897);
				constant();
				}
				break;
			case CONST:
			case BOOL:
			case Class:
			case BYCOPY:
			case BYREF:
			case ID:
			case IMP:
			case IN:
			case INOUT:
			case ONEWAY:
			case OUT:
			case PROTOCOL_:
			case SEL:
			case SELF:
			case SUPER:
			case ATOMIC:
			case NONATOMIC:
			case RETAIN:
			case AUTORELEASING_QUALIFIER:
			case BLOCK:
			case BRIDGE_RETAINED:
			case BRIDGE_TRANSFER:
			case COVARIANT:
			case CONTRAVARIANT:
			case DEPRECATED:
			case KINDOF:
			case UNUSED:
			case NULL_UNSPECIFIED:
			case NULLABLE:
			case NONNULL:
			case NULL_RESETTABLE:
			case NS_INLINE:
			case NS_ENUM:
			case NS_OPTIONS:
			case ASSIGN:
			case COPY:
			case GETTER:
			case SETTER:
			case STRONG:
			case READONLY:
			case READWRITE:
			case WEAK:
			case UNSAFE_UNRETAINED:
			case IB_OUTLET:
			case IB_OUTLET_COLLECTION:
			case IB_INSPECTABLE:
			case IB_DESIGNABLE:
			case IDENTIFIER:
				{
				setState(898);
				attributeName();
				}
				break;
			case STRING_START:
				{
				setState(899);
				stringLiteral();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public FunctionCallExpressionContext functionCallExpression() {
			return getRuleContext(FunctionCallExpressionContext.class,0);
		}
		public EnumDeclarationContext enumDeclaration() {
			return getRuleContext(EnumDeclarationContext.class,0);
		}
		public VarDeclarationContext varDeclaration() {
			return getRuleContext(VarDeclarationContext.class,0);
		}
		public TypedefDeclarationContext typedefDeclaration() {
			return getRuleContext(TypedefDeclarationContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitDeclaration(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_declaration);
		try {
			setState(906);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,96,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(902);
				functionCallExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(903);
				enumDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(904);
				varDeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(905);
				typedefDeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionCallExpressionContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public DirectDeclaratorContext directDeclarator() {
			return getRuleContext(DirectDeclaratorContext.class,0);
		}
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public TerminalNode SEMI() { return getToken(ObjectiveCParser.SEMI, 0); }
		public List<AttributeSpecifierContext> attributeSpecifier() {
			return getRuleContexts(AttributeSpecifierContext.class);
		}
		public AttributeSpecifierContext attributeSpecifier(int i) {
			return getRuleContext(AttributeSpecifierContext.class,i);
		}
		public FunctionCallExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCallExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterFunctionCallExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitFunctionCallExpression(this);
		}
	}

	public final FunctionCallExpressionContext functionCallExpression() throws RecognitionException {
		FunctionCallExpressionContext _localctx = new FunctionCallExpressionContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_functionCallExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(909);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ATTRIBUTE) {
				{
				setState(908);
				attributeSpecifier();
				}
			}

			setState(911);
			identifier();
			setState(913);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ATTRIBUTE) {
				{
				setState(912);
				attributeSpecifier();
				}
			}

			setState(915);
			match(LP);
			setState(916);
			directDeclarator();
			setState(917);
			match(RP);
			setState(918);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumDeclarationContext extends ParserRuleContext {
		public EnumSpecifierContext enumSpecifier() {
			return getRuleContext(EnumSpecifierContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ObjectiveCParser.SEMI, 0); }
		public AttributeSpecifierContext attributeSpecifier() {
			return getRuleContext(AttributeSpecifierContext.class,0);
		}
		public TerminalNode TYPEDEF() { return getToken(ObjectiveCParser.TYPEDEF, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public EnumDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterEnumDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitEnumDeclaration(this);
		}
	}

	public final EnumDeclarationContext enumDeclaration() throws RecognitionException {
		EnumDeclarationContext _localctx = new EnumDeclarationContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_enumDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(921);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ATTRIBUTE) {
				{
				setState(920);
				attributeSpecifier();
				}
			}

			setState(924);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPEDEF) {
				{
				setState(923);
				match(TYPEDEF);
				}
			}

			setState(926);
			enumSpecifier();
			setState(928);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0)) {
				{
				setState(927);
				identifier();
				}
			}

			setState(930);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDeclarationContext extends ParserRuleContext {
		public TerminalNode SEMI() { return getToken(ObjectiveCParser.SEMI, 0); }
		public DeclarationSpecifiersContext declarationSpecifiers() {
			return getRuleContext(DeclarationSpecifiersContext.class,0);
		}
		public InitDeclaratorListContext initDeclaratorList() {
			return getRuleContext(InitDeclaratorListContext.class,0);
		}
		public VarDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterVarDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitVarDeclaration(this);
		}
	}

	public final VarDeclarationContext varDeclaration() throws RecognitionException {
		VarDeclarationContext _localctx = new VarDeclarationContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_varDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(936);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,102,_ctx) ) {
			case 1:
				{
				setState(932);
				declarationSpecifiers();
				setState(933);
				initDeclaratorList();
				}
				break;
			case 2:
				{
				setState(935);
				declarationSpecifiers();
				}
				break;
			}
			setState(938);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypedefDeclarationContext extends ParserRuleContext {
		public TerminalNode TYPEDEF() { return getToken(ObjectiveCParser.TYPEDEF, 0); }
		public TerminalNode SEMI() { return getToken(ObjectiveCParser.SEMI, 0); }
		public DeclarationSpecifiersContext declarationSpecifiers() {
			return getRuleContext(DeclarationSpecifiersContext.class,0);
		}
		public TypeDeclaratorListContext typeDeclaratorList() {
			return getRuleContext(TypeDeclaratorListContext.class,0);
		}
		public AttributeSpecifierContext attributeSpecifier() {
			return getRuleContext(AttributeSpecifierContext.class,0);
		}
		public TypedefDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typedefDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterTypedefDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitTypedefDeclaration(this);
		}
	}

	public final TypedefDeclarationContext typedefDeclaration() throws RecognitionException {
		TypedefDeclarationContext _localctx = new TypedefDeclarationContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_typedefDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(941);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ATTRIBUTE) {
				{
				setState(940);
				attributeSpecifier();
				}
			}

			setState(943);
			match(TYPEDEF);
			setState(948);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,104,_ctx) ) {
			case 1:
				{
				setState(944);
				declarationSpecifiers();
				setState(945);
				typeDeclaratorList();
				}
				break;
			case 2:
				{
				setState(947);
				declarationSpecifiers();
				}
				break;
			}
			setState(950);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeDeclaratorListContext extends ParserRuleContext {
		public List<TypeDeclaratorContext> typeDeclarator() {
			return getRuleContexts(TypeDeclaratorContext.class);
		}
		public TypeDeclaratorContext typeDeclarator(int i) {
			return getRuleContext(TypeDeclaratorContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ObjectiveCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ObjectiveCParser.COMMA, i);
		}
		public TypeDeclaratorListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDeclaratorList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterTypeDeclaratorList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitTypeDeclaratorList(this);
		}
	}

	public final TypeDeclaratorListContext typeDeclaratorList() throws RecognitionException {
		TypeDeclaratorListContext _localctx = new TypeDeclaratorListContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_typeDeclaratorList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(952);
			typeDeclarator();
			setState(957);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(953);
				match(COMMA);
				setState(954);
				typeDeclarator();
				}
				}
				setState(959);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeDeclaratorContext extends ParserRuleContext {
		public DirectDeclaratorContext directDeclarator() {
			return getRuleContext(DirectDeclaratorContext.class,0);
		}
		public PointerContext pointer() {
			return getRuleContext(PointerContext.class,0);
		}
		public TypeDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterTypeDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitTypeDeclarator(this);
		}
	}

	public final TypeDeclaratorContext typeDeclarator() throws RecognitionException {
		TypeDeclaratorContext _localctx = new TypeDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_typeDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(961);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MUL) {
				{
				setState(960);
				pointer();
				}
			}

			setState(963);
			directDeclarator();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationSpecifiersContext extends ParserRuleContext {
		public List<StorageClassSpecifierContext> storageClassSpecifier() {
			return getRuleContexts(StorageClassSpecifierContext.class);
		}
		public StorageClassSpecifierContext storageClassSpecifier(int i) {
			return getRuleContext(StorageClassSpecifierContext.class,i);
		}
		public List<AttributeSpecifierContext> attributeSpecifier() {
			return getRuleContexts(AttributeSpecifierContext.class);
		}
		public AttributeSpecifierContext attributeSpecifier(int i) {
			return getRuleContext(AttributeSpecifierContext.class,i);
		}
		public List<ArcBehaviourSpecifierContext> arcBehaviourSpecifier() {
			return getRuleContexts(ArcBehaviourSpecifierContext.class);
		}
		public ArcBehaviourSpecifierContext arcBehaviourSpecifier(int i) {
			return getRuleContext(ArcBehaviourSpecifierContext.class,i);
		}
		public List<NullabilitySpecifierContext> nullabilitySpecifier() {
			return getRuleContexts(NullabilitySpecifierContext.class);
		}
		public NullabilitySpecifierContext nullabilitySpecifier(int i) {
			return getRuleContext(NullabilitySpecifierContext.class,i);
		}
		public List<IbOutletQualifierContext> ibOutletQualifier() {
			return getRuleContexts(IbOutletQualifierContext.class);
		}
		public IbOutletQualifierContext ibOutletQualifier(int i) {
			return getRuleContext(IbOutletQualifierContext.class,i);
		}
		public List<TypePrefixContext> typePrefix() {
			return getRuleContexts(TypePrefixContext.class);
		}
		public TypePrefixContext typePrefix(int i) {
			return getRuleContext(TypePrefixContext.class,i);
		}
		public List<TypeQualifierContext> typeQualifier() {
			return getRuleContexts(TypeQualifierContext.class);
		}
		public TypeQualifierContext typeQualifier(int i) {
			return getRuleContext(TypeQualifierContext.class,i);
		}
		public List<TypeSpecifierContext> typeSpecifier() {
			return getRuleContexts(TypeSpecifierContext.class);
		}
		public TypeSpecifierContext typeSpecifier(int i) {
			return getRuleContext(TypeSpecifierContext.class,i);
		}
		public DeclarationSpecifiersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationSpecifiers; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterDeclarationSpecifiers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitDeclarationSpecifiers(this);
		}
	}

	public final DeclarationSpecifiersContext declarationSpecifiers() throws RecognitionException {
		DeclarationSpecifiersContext _localctx = new DeclarationSpecifiersContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_declarationSpecifiers);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(973); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(973);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,107,_ctx) ) {
					case 1:
						{
						setState(965);
						storageClassSpecifier();
						}
						break;
					case 2:
						{
						setState(966);
						attributeSpecifier();
						}
						break;
					case 3:
						{
						setState(967);
						arcBehaviourSpecifier();
						}
						break;
					case 4:
						{
						setState(968);
						nullabilitySpecifier();
						}
						break;
					case 5:
						{
						setState(969);
						ibOutletQualifier();
						}
						break;
					case 6:
						{
						setState(970);
						typePrefix();
						}
						break;
					case 7:
						{
						setState(971);
						typeQualifier();
						}
						break;
					case 8:
						{
						setState(972);
						typeSpecifier();
						}
						break;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(975); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,108,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributeSpecifierContext extends ParserRuleContext {
		public TerminalNode ATTRIBUTE() { return getToken(ObjectiveCParser.ATTRIBUTE, 0); }
		public List<TerminalNode> LP() { return getTokens(ObjectiveCParser.LP); }
		public TerminalNode LP(int i) {
			return getToken(ObjectiveCParser.LP, i);
		}
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public List<TerminalNode> RP() { return getTokens(ObjectiveCParser.RP); }
		public TerminalNode RP(int i) {
			return getToken(ObjectiveCParser.RP, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ObjectiveCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ObjectiveCParser.COMMA, i);
		}
		public AttributeSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterAttributeSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitAttributeSpecifier(this);
		}
	}

	public final AttributeSpecifierContext attributeSpecifier() throws RecognitionException {
		AttributeSpecifierContext _localctx = new AttributeSpecifierContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_attributeSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(977);
			match(ATTRIBUTE);
			setState(978);
			match(LP);
			setState(979);
			match(LP);
			setState(980);
			attribute();
			setState(985);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(981);
				match(COMMA);
				setState(982);
				attribute();
				}
				}
				setState(987);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(988);
			match(RP);
			setState(989);
			match(RP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitDeclaratorListContext extends ParserRuleContext {
		public List<InitDeclaratorContext> initDeclarator() {
			return getRuleContexts(InitDeclaratorContext.class);
		}
		public InitDeclaratorContext initDeclarator(int i) {
			return getRuleContext(InitDeclaratorContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ObjectiveCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ObjectiveCParser.COMMA, i);
		}
		public InitDeclaratorListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initDeclaratorList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterInitDeclaratorList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitInitDeclaratorList(this);
		}
	}

	public final InitDeclaratorListContext initDeclaratorList() throws RecognitionException {
		InitDeclaratorListContext _localctx = new InitDeclaratorListContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_initDeclaratorList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(991);
			initDeclarator();
			setState(996);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(992);
				match(COMMA);
				setState(993);
				initDeclarator();
				}
				}
				setState(998);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitDeclaratorContext extends ParserRuleContext {
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public TerminalNode ASSIGNMENT() { return getToken(ObjectiveCParser.ASSIGNMENT, 0); }
		public InitializerContext initializer() {
			return getRuleContext(InitializerContext.class,0);
		}
		public InitDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterInitDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitInitDeclarator(this);
		}
	}

	public final InitDeclaratorContext initDeclarator() throws RecognitionException {
		InitDeclaratorContext _localctx = new InitDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_initDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(999);
			declarator();
			setState(1002);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGNMENT) {
				{
				setState(1000);
				match(ASSIGNMENT);
				setState(1001);
				initializer();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StructOrUnionSpecifierContext extends ParserRuleContext {
		public TerminalNode STRUCT() { return getToken(ObjectiveCParser.STRUCT, 0); }
		public TerminalNode UNION() { return getToken(ObjectiveCParser.UNION, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LBRACE() { return getToken(ObjectiveCParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ObjectiveCParser.RBRACE, 0); }
		public List<FieldDeclarationContext> fieldDeclaration() {
			return getRuleContexts(FieldDeclarationContext.class);
		}
		public FieldDeclarationContext fieldDeclaration(int i) {
			return getRuleContext(FieldDeclarationContext.class,i);
		}
		public StructOrUnionSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structOrUnionSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterStructOrUnionSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitStructOrUnionSpecifier(this);
		}
	}

	public final StructOrUnionSpecifierContext structOrUnionSpecifier() throws RecognitionException {
		StructOrUnionSpecifierContext _localctx = new StructOrUnionSpecifierContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_structOrUnionSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1004);
			_la = _input.LA(1);
			if ( !(_la==STRUCT || _la==UNION) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(1017);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,114,_ctx) ) {
			case 1:
				{
				setState(1005);
				identifier();
				}
				break;
			case 2:
				{
				setState(1007);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0)) {
					{
					setState(1006);
					identifier();
					}
				}

				setState(1009);
				match(LBRACE);
				setState(1011); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1010);
					fieldDeclaration();
					}
					}
					setState(1013); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CHAR) | (1L << CONST) | (1L << DOUBLE) | (1L << ENUM) | (1L << FLOAT) | (1L << INLINE) | (1L << INT) | (1L << LONG) | (1L << RESTRICT) | (1L << SHORT) | (1L << SIGNED) | (1L << STRUCT) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID) | (1L << VOLATILE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (STRONG_QUALIFIER - 81)) | (1L << (TYPEOF - 81)) | (1L << (UNSAFE_UNRETAINED_QUALIFIER - 81)) | (1L << (UNUSED - 81)) | (1L << (WEAK_QUALIFIER - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0) );
				setState(1015);
				match(RBRACE);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldDeclarationContext extends ParserRuleContext {
		public SpecifierQualifierListContext specifierQualifierList() {
			return getRuleContext(SpecifierQualifierListContext.class,0);
		}
		public FieldDeclaratorListContext fieldDeclaratorList() {
			return getRuleContext(FieldDeclaratorListContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ObjectiveCParser.SEMI, 0); }
		public MacroContext macro() {
			return getRuleContext(MacroContext.class,0);
		}
		public FieldDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterFieldDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitFieldDeclaration(this);
		}
	}

	public final FieldDeclarationContext fieldDeclaration() throws RecognitionException {
		FieldDeclarationContext _localctx = new FieldDeclarationContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_fieldDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1019);
			specifierQualifierList();
			setState(1020);
			fieldDeclaratorList();
			setState(1022);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0)) {
				{
				setState(1021);
				macro();
				}
			}

			setState(1024);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SpecifierQualifierListContext extends ParserRuleContext {
		public List<ArcBehaviourSpecifierContext> arcBehaviourSpecifier() {
			return getRuleContexts(ArcBehaviourSpecifierContext.class);
		}
		public ArcBehaviourSpecifierContext arcBehaviourSpecifier(int i) {
			return getRuleContext(ArcBehaviourSpecifierContext.class,i);
		}
		public List<NullabilitySpecifierContext> nullabilitySpecifier() {
			return getRuleContexts(NullabilitySpecifierContext.class);
		}
		public NullabilitySpecifierContext nullabilitySpecifier(int i) {
			return getRuleContext(NullabilitySpecifierContext.class,i);
		}
		public List<IbOutletQualifierContext> ibOutletQualifier() {
			return getRuleContexts(IbOutletQualifierContext.class);
		}
		public IbOutletQualifierContext ibOutletQualifier(int i) {
			return getRuleContext(IbOutletQualifierContext.class,i);
		}
		public List<TypePrefixContext> typePrefix() {
			return getRuleContexts(TypePrefixContext.class);
		}
		public TypePrefixContext typePrefix(int i) {
			return getRuleContext(TypePrefixContext.class,i);
		}
		public List<TypeQualifierContext> typeQualifier() {
			return getRuleContexts(TypeQualifierContext.class);
		}
		public TypeQualifierContext typeQualifier(int i) {
			return getRuleContext(TypeQualifierContext.class,i);
		}
		public List<TypeSpecifierContext> typeSpecifier() {
			return getRuleContexts(TypeSpecifierContext.class);
		}
		public TypeSpecifierContext typeSpecifier(int i) {
			return getRuleContext(TypeSpecifierContext.class,i);
		}
		public SpecifierQualifierListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_specifierQualifierList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterSpecifierQualifierList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitSpecifierQualifierList(this);
		}
	}

	public final SpecifierQualifierListContext specifierQualifierList() throws RecognitionException {
		SpecifierQualifierListContext _localctx = new SpecifierQualifierListContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_specifierQualifierList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1032); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(1032);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,116,_ctx) ) {
					case 1:
						{
						setState(1026);
						arcBehaviourSpecifier();
						}
						break;
					case 2:
						{
						setState(1027);
						nullabilitySpecifier();
						}
						break;
					case 3:
						{
						setState(1028);
						ibOutletQualifier();
						}
						break;
					case 4:
						{
						setState(1029);
						typePrefix();
						}
						break;
					case 5:
						{
						setState(1030);
						typeQualifier();
						}
						break;
					case 6:
						{
						setState(1031);
						typeSpecifier();
						}
						break;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1034); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,117,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IbOutletQualifierContext extends ParserRuleContext {
		public TerminalNode IB_OUTLET_COLLECTION() { return getToken(ObjectiveCParser.IB_OUTLET_COLLECTION, 0); }
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public TerminalNode IB_OUTLET() { return getToken(ObjectiveCParser.IB_OUTLET, 0); }
		public IbOutletQualifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ibOutletQualifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterIbOutletQualifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitIbOutletQualifier(this);
		}
	}

	public final IbOutletQualifierContext ibOutletQualifier() throws RecognitionException {
		IbOutletQualifierContext _localctx = new IbOutletQualifierContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_ibOutletQualifier);
		try {
			setState(1042);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IB_OUTLET_COLLECTION:
				enterOuterAlt(_localctx, 1);
				{
				setState(1036);
				match(IB_OUTLET_COLLECTION);
				setState(1037);
				match(LP);
				setState(1038);
				identifier();
				setState(1039);
				match(RP);
				}
				break;
			case IB_OUTLET:
				enterOuterAlt(_localctx, 2);
				{
				setState(1041);
				match(IB_OUTLET);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArcBehaviourSpecifierContext extends ParserRuleContext {
		public TerminalNode WEAK_QUALIFIER() { return getToken(ObjectiveCParser.WEAK_QUALIFIER, 0); }
		public TerminalNode STRONG_QUALIFIER() { return getToken(ObjectiveCParser.STRONG_QUALIFIER, 0); }
		public TerminalNode AUTORELEASING_QUALIFIER() { return getToken(ObjectiveCParser.AUTORELEASING_QUALIFIER, 0); }
		public TerminalNode UNSAFE_UNRETAINED_QUALIFIER() { return getToken(ObjectiveCParser.UNSAFE_UNRETAINED_QUALIFIER, 0); }
		public ArcBehaviourSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arcBehaviourSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterArcBehaviourSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitArcBehaviourSpecifier(this);
		}
	}

	public final ArcBehaviourSpecifierContext arcBehaviourSpecifier() throws RecognitionException {
		ArcBehaviourSpecifierContext _localctx = new ArcBehaviourSpecifierContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_arcBehaviourSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1044);
			_la = _input.LA(1);
			if ( !(((((_la - 85)) & ~0x3f) == 0 && ((1L << (_la - 85)) & ((1L << (AUTORELEASING_QUALIFIER - 85)) | (1L << (STRONG_QUALIFIER - 85)) | (1L << (UNSAFE_UNRETAINED_QUALIFIER - 85)) | (1L << (WEAK_QUALIFIER - 85)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NullabilitySpecifierContext extends ParserRuleContext {
		public TerminalNode NULL_UNSPECIFIED() { return getToken(ObjectiveCParser.NULL_UNSPECIFIED, 0); }
		public TerminalNode NULLABLE() { return getToken(ObjectiveCParser.NULLABLE, 0); }
		public TerminalNode NONNULL() { return getToken(ObjectiveCParser.NONNULL, 0); }
		public TerminalNode NULL_RESETTABLE() { return getToken(ObjectiveCParser.NULL_RESETTABLE, 0); }
		public NullabilitySpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nullabilitySpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterNullabilitySpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitNullabilitySpecifier(this);
		}
	}

	public final NullabilitySpecifierContext nullabilitySpecifier() throws RecognitionException {
		NullabilitySpecifierContext _localctx = new NullabilitySpecifierContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_nullabilitySpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1046);
			_la = _input.LA(1);
			if ( !(((((_la - 99)) & ~0x3f) == 0 && ((1L << (_la - 99)) & ((1L << (NULL_UNSPECIFIED - 99)) | (1L << (NULLABLE - 99)) | (1L << (NONNULL - 99)) | (1L << (NULL_RESETTABLE - 99)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StorageClassSpecifierContext extends ParserRuleContext {
		public TerminalNode AUTO() { return getToken(ObjectiveCParser.AUTO, 0); }
		public TerminalNode REGISTER() { return getToken(ObjectiveCParser.REGISTER, 0); }
		public TerminalNode STATIC() { return getToken(ObjectiveCParser.STATIC, 0); }
		public TerminalNode EXTERN() { return getToken(ObjectiveCParser.EXTERN, 0); }
		public StorageClassSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_storageClassSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterStorageClassSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitStorageClassSpecifier(this);
		}
	}

	public final StorageClassSpecifierContext storageClassSpecifier() throws RecognitionException {
		StorageClassSpecifierContext _localctx = new StorageClassSpecifierContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_storageClassSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1048);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AUTO) | (1L << EXTERN) | (1L << REGISTER) | (1L << STATIC))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypePrefixContext extends ParserRuleContext {
		public TerminalNode BRIDGE() { return getToken(ObjectiveCParser.BRIDGE, 0); }
		public TerminalNode BRIDGE_TRANSFER() { return getToken(ObjectiveCParser.BRIDGE_TRANSFER, 0); }
		public TerminalNode BRIDGE_RETAINED() { return getToken(ObjectiveCParser.BRIDGE_RETAINED, 0); }
		public TerminalNode BLOCK() { return getToken(ObjectiveCParser.BLOCK, 0); }
		public TerminalNode INLINE() { return getToken(ObjectiveCParser.INLINE, 0); }
		public TerminalNode NS_INLINE() { return getToken(ObjectiveCParser.NS_INLINE, 0); }
		public TerminalNode KINDOF() { return getToken(ObjectiveCParser.KINDOF, 0); }
		public TypePrefixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typePrefix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterTypePrefix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitTypePrefix(this);
		}
	}

	public final TypePrefixContext typePrefix() throws RecognitionException {
		TypePrefixContext _localctx = new TypePrefixContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_typePrefix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1050);
			_la = _input.LA(1);
			if ( !(_la==INLINE || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (BLOCK - 86)) | (1L << (BRIDGE - 86)) | (1L << (BRIDGE_RETAINED - 86)) | (1L << (BRIDGE_TRANSFER - 86)) | (1L << (KINDOF - 86)) | (1L << (NS_INLINE - 86)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeQualifierContext extends ParserRuleContext {
		public TerminalNode CONST() { return getToken(ObjectiveCParser.CONST, 0); }
		public TerminalNode VOLATILE() { return getToken(ObjectiveCParser.VOLATILE, 0); }
		public TerminalNode RESTRICT() { return getToken(ObjectiveCParser.RESTRICT, 0); }
		public ProtocolQualifierContext protocolQualifier() {
			return getRuleContext(ProtocolQualifierContext.class,0);
		}
		public TypeQualifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeQualifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterTypeQualifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitTypeQualifier(this);
		}
	}

	public final TypeQualifierContext typeQualifier() throws RecognitionException {
		TypeQualifierContext _localctx = new TypeQualifierContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_typeQualifier);
		try {
			setState(1056);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONST:
				enterOuterAlt(_localctx, 1);
				{
				setState(1052);
				match(CONST);
				}
				break;
			case VOLATILE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1053);
				match(VOLATILE);
				}
				break;
			case RESTRICT:
				enterOuterAlt(_localctx, 3);
				{
				setState(1054);
				match(RESTRICT);
				}
				break;
			case BYCOPY:
			case BYREF:
			case IN:
			case INOUT:
			case ONEWAY:
			case OUT:
				enterOuterAlt(_localctx, 4);
				{
				setState(1055);
				protocolQualifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProtocolQualifierContext extends ParserRuleContext {
		public TerminalNode IN() { return getToken(ObjectiveCParser.IN, 0); }
		public TerminalNode OUT() { return getToken(ObjectiveCParser.OUT, 0); }
		public TerminalNode INOUT() { return getToken(ObjectiveCParser.INOUT, 0); }
		public TerminalNode BYCOPY() { return getToken(ObjectiveCParser.BYCOPY, 0); }
		public TerminalNode BYREF() { return getToken(ObjectiveCParser.BYREF, 0); }
		public TerminalNode ONEWAY() { return getToken(ObjectiveCParser.ONEWAY, 0); }
		public ProtocolQualifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_protocolQualifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterProtocolQualifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitProtocolQualifier(this);
		}
	}

	public final ProtocolQualifierContext protocolQualifier() throws RecognitionException {
		ProtocolQualifierContext _localctx = new ProtocolQualifierContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_protocolQualifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1058);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BYCOPY) | (1L << BYREF) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeSpecifierContext extends ParserRuleContext {
		public TerminalNode VOID() { return getToken(ObjectiveCParser.VOID, 0); }
		public TerminalNode CHAR() { return getToken(ObjectiveCParser.CHAR, 0); }
		public TerminalNode SHORT() { return getToken(ObjectiveCParser.SHORT, 0); }
		public TerminalNode INT() { return getToken(ObjectiveCParser.INT, 0); }
		public TerminalNode LONG() { return getToken(ObjectiveCParser.LONG, 0); }
		public TerminalNode FLOAT() { return getToken(ObjectiveCParser.FLOAT, 0); }
		public TerminalNode DOUBLE() { return getToken(ObjectiveCParser.DOUBLE, 0); }
		public TerminalNode SIGNED() { return getToken(ObjectiveCParser.SIGNED, 0); }
		public TerminalNode UNSIGNED() { return getToken(ObjectiveCParser.UNSIGNED, 0); }
		public TypeofExpressionContext typeofExpression() {
			return getRuleContext(TypeofExpressionContext.class,0);
		}
		public GenericTypeSpecifierContext genericTypeSpecifier() {
			return getRuleContext(GenericTypeSpecifierContext.class,0);
		}
		public StructOrUnionSpecifierContext structOrUnionSpecifier() {
			return getRuleContext(StructOrUnionSpecifierContext.class,0);
		}
		public EnumSpecifierContext enumSpecifier() {
			return getRuleContext(EnumSpecifierContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public PointerContext pointer() {
			return getRuleContext(PointerContext.class,0);
		}
		public TypeSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterTypeSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitTypeSpecifier(this);
		}
	}

	public final TypeSpecifierContext typeSpecifier() throws RecognitionException {
		TypeSpecifierContext _localctx = new TypeSpecifierContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_typeSpecifier);
		try {
			setState(1077);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,121,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1060);
				match(VOID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1061);
				match(CHAR);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1062);
				match(SHORT);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1063);
				match(INT);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1064);
				match(LONG);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1065);
				match(FLOAT);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1066);
				match(DOUBLE);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1067);
				match(SIGNED);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1068);
				match(UNSIGNED);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1069);
				typeofExpression();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(1070);
				genericTypeSpecifier();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(1071);
				structOrUnionSpecifier();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(1072);
				enumSpecifier();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(1073);
				identifier();
				setState(1075);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,120,_ctx) ) {
				case 1:
					{
					setState(1074);
					pointer();
					}
					break;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeofExpressionContext extends ParserRuleContext {
		public TerminalNode TYPEOF() { return getToken(ObjectiveCParser.TYPEOF, 0); }
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public TypeofExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeofExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterTypeofExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitTypeofExpression(this);
		}
	}

	public final TypeofExpressionContext typeofExpression() throws RecognitionException {
		TypeofExpressionContext _localctx = new TypeofExpressionContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_typeofExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1079);
			match(TYPEOF);
			{
			setState(1080);
			match(LP);
			setState(1081);
			expression(0);
			setState(1082);
			match(RP);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldDeclaratorListContext extends ParserRuleContext {
		public List<FieldDeclaratorContext> fieldDeclarator() {
			return getRuleContexts(FieldDeclaratorContext.class);
		}
		public FieldDeclaratorContext fieldDeclarator(int i) {
			return getRuleContext(FieldDeclaratorContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ObjectiveCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ObjectiveCParser.COMMA, i);
		}
		public FieldDeclaratorListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDeclaratorList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterFieldDeclaratorList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitFieldDeclaratorList(this);
		}
	}

	public final FieldDeclaratorListContext fieldDeclaratorList() throws RecognitionException {
		FieldDeclaratorListContext _localctx = new FieldDeclaratorListContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_fieldDeclaratorList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1084);
			fieldDeclarator();
			setState(1089);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1085);
				match(COMMA);
				setState(1086);
				fieldDeclarator();
				}
				}
				setState(1091);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldDeclaratorContext extends ParserRuleContext {
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public TerminalNode COLON() { return getToken(ObjectiveCParser.COLON, 0); }
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public FieldDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterFieldDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitFieldDeclarator(this);
		}
	}

	public final FieldDeclaratorContext fieldDeclarator() throws RecognitionException {
		FieldDeclaratorContext _localctx = new FieldDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_fieldDeclarator);
		int _la;
		try {
			setState(1098);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,124,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1092);
				declarator();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1094);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 40)) & ~0x3f) == 0 && ((1L << (_la - 40)) & ((1L << (BOOL - 40)) | (1L << (Class - 40)) | (1L << (BYCOPY - 40)) | (1L << (BYREF - 40)) | (1L << (ID - 40)) | (1L << (IMP - 40)) | (1L << (IN - 40)) | (1L << (INOUT - 40)) | (1L << (ONEWAY - 40)) | (1L << (OUT - 40)) | (1L << (PROTOCOL_ - 40)) | (1L << (SEL - 40)) | (1L << (SELF - 40)) | (1L << (SUPER - 40)) | (1L << (ATOMIC - 40)) | (1L << (NONATOMIC - 40)) | (1L << (RETAIN - 40)) | (1L << (AUTORELEASING_QUALIFIER - 40)) | (1L << (BLOCK - 40)) | (1L << (BRIDGE_RETAINED - 40)) | (1L << (BRIDGE_TRANSFER - 40)) | (1L << (COVARIANT - 40)) | (1L << (CONTRAVARIANT - 40)) | (1L << (DEPRECATED - 40)) | (1L << (KINDOF - 40)) | (1L << (UNUSED - 40)) | (1L << (NULL_UNSPECIFIED - 40)) | (1L << (NULLABLE - 40)) | (1L << (NONNULL - 40)) | (1L << (NULL_RESETTABLE - 40)) | (1L << (NS_INLINE - 40)))) != 0) || ((((_la - 104)) & ~0x3f) == 0 && ((1L << (_la - 104)) & ((1L << (NS_ENUM - 104)) | (1L << (NS_OPTIONS - 104)) | (1L << (ASSIGN - 104)) | (1L << (COPY - 104)) | (1L << (GETTER - 104)) | (1L << (SETTER - 104)) | (1L << (STRONG - 104)) | (1L << (READONLY - 104)) | (1L << (READWRITE - 104)) | (1L << (WEAK - 104)) | (1L << (UNSAFE_UNRETAINED - 104)) | (1L << (IB_OUTLET - 104)) | (1L << (IB_OUTLET_COLLECTION - 104)) | (1L << (IB_INSPECTABLE - 104)) | (1L << (IB_DESIGNABLE - 104)) | (1L << (IDENTIFIER - 104)) | (1L << (LP - 104)) | (1L << (MUL - 104)))) != 0)) {
					{
					setState(1093);
					declarator();
					}
				}

				setState(1096);
				match(COLON);
				setState(1097);
				constant();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumSpecifierContext extends ParserRuleContext {
		public TerminalNode ENUM() { return getToken(ObjectiveCParser.ENUM, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode LBRACE() { return getToken(ObjectiveCParser.LBRACE, 0); }
		public EnumeratorListContext enumeratorList() {
			return getRuleContext(EnumeratorListContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(ObjectiveCParser.RBRACE, 0); }
		public TerminalNode COLON() { return getToken(ObjectiveCParser.COLON, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public TerminalNode COMMA() { return getToken(ObjectiveCParser.COMMA, 0); }
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public TerminalNode NS_OPTIONS() { return getToken(ObjectiveCParser.NS_OPTIONS, 0); }
		public TerminalNode NS_ENUM() { return getToken(ObjectiveCParser.NS_ENUM, 0); }
		public EnumSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterEnumSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitEnumSpecifier(this);
		}
	}

	public final EnumSpecifierContext enumSpecifier() throws RecognitionException {
		EnumSpecifierContext _localctx = new EnumSpecifierContext(_ctx, getState());
		enterRule(_localctx, 188, RULE_enumSpecifier);
		int _la;
		try {
			setState(1131);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ENUM:
				enterOuterAlt(_localctx, 1);
				{
				setState(1100);
				match(ENUM);
				setState(1106);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,126,_ctx) ) {
				case 1:
					{
					setState(1102);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0)) {
						{
						setState(1101);
						identifier();
						}
					}

					setState(1104);
					match(COLON);
					setState(1105);
					typeName();
					}
					break;
				}
				setState(1119);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BOOL:
				case Class:
				case BYCOPY:
				case BYREF:
				case ID:
				case IMP:
				case IN:
				case INOUT:
				case ONEWAY:
				case OUT:
				case PROTOCOL_:
				case SEL:
				case SELF:
				case SUPER:
				case ATOMIC:
				case NONATOMIC:
				case RETAIN:
				case AUTORELEASING_QUALIFIER:
				case BLOCK:
				case BRIDGE_RETAINED:
				case BRIDGE_TRANSFER:
				case COVARIANT:
				case CONTRAVARIANT:
				case DEPRECATED:
				case KINDOF:
				case UNUSED:
				case NULL_UNSPECIFIED:
				case NULLABLE:
				case NONNULL:
				case NULL_RESETTABLE:
				case NS_INLINE:
				case NS_ENUM:
				case NS_OPTIONS:
				case ASSIGN:
				case COPY:
				case GETTER:
				case SETTER:
				case STRONG:
				case READONLY:
				case READWRITE:
				case WEAK:
				case UNSAFE_UNRETAINED:
				case IB_OUTLET:
				case IB_OUTLET_COLLECTION:
				case IB_INSPECTABLE:
				case IB_DESIGNABLE:
				case IDENTIFIER:
					{
					setState(1108);
					identifier();
					setState(1113);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,127,_ctx) ) {
					case 1:
						{
						setState(1109);
						match(LBRACE);
						setState(1110);
						enumeratorList();
						setState(1111);
						match(RBRACE);
						}
						break;
					}
					}
					break;
				case LBRACE:
					{
					setState(1115);
					match(LBRACE);
					setState(1116);
					enumeratorList();
					setState(1117);
					match(RBRACE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case NS_ENUM:
			case NS_OPTIONS:
				enterOuterAlt(_localctx, 2);
				{
				setState(1121);
				_la = _input.LA(1);
				if ( !(_la==NS_ENUM || _la==NS_OPTIONS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1122);
				match(LP);
				setState(1123);
				typeName();
				setState(1124);
				match(COMMA);
				setState(1125);
				identifier();
				setState(1126);
				match(RP);
				setState(1127);
				match(LBRACE);
				setState(1128);
				enumeratorList();
				setState(1129);
				match(RBRACE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumeratorListContext extends ParserRuleContext {
		public List<EnumeratorContext> enumerator() {
			return getRuleContexts(EnumeratorContext.class);
		}
		public EnumeratorContext enumerator(int i) {
			return getRuleContext(EnumeratorContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ObjectiveCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ObjectiveCParser.COMMA, i);
		}
		public EnumeratorListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumeratorList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterEnumeratorList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitEnumeratorList(this);
		}
	}

	public final EnumeratorListContext enumeratorList() throws RecognitionException {
		EnumeratorListContext _localctx = new EnumeratorListContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_enumeratorList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1133);
			enumerator();
			setState(1138);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,130,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1134);
					match(COMMA);
					setState(1135);
					enumerator();
					}
					} 
				}
				setState(1140);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,130,_ctx);
			}
			setState(1142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1141);
				match(COMMA);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumeratorContext extends ParserRuleContext {
		public EnumeratorIdentifierContext enumeratorIdentifier() {
			return getRuleContext(EnumeratorIdentifierContext.class,0);
		}
		public TerminalNode ASSIGNMENT() { return getToken(ObjectiveCParser.ASSIGNMENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public EnumeratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumerator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterEnumerator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitEnumerator(this);
		}
	}

	public final EnumeratorContext enumerator() throws RecognitionException {
		EnumeratorContext _localctx = new EnumeratorContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_enumerator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1144);
			enumeratorIdentifier();
			setState(1147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGNMENT) {
				{
				setState(1145);
				match(ASSIGNMENT);
				setState(1146);
				expression(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumeratorIdentifierContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode DEFAULT() { return getToken(ObjectiveCParser.DEFAULT, 0); }
		public EnumeratorIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumeratorIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterEnumeratorIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitEnumeratorIdentifier(this);
		}
	}

	public final EnumeratorIdentifierContext enumeratorIdentifier() throws RecognitionException {
		EnumeratorIdentifierContext _localctx = new EnumeratorIdentifierContext(_ctx, getState());
		enterRule(_localctx, 194, RULE_enumeratorIdentifier);
		try {
			setState(1151);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOL:
			case Class:
			case BYCOPY:
			case BYREF:
			case ID:
			case IMP:
			case IN:
			case INOUT:
			case ONEWAY:
			case OUT:
			case PROTOCOL_:
			case SEL:
			case SELF:
			case SUPER:
			case ATOMIC:
			case NONATOMIC:
			case RETAIN:
			case AUTORELEASING_QUALIFIER:
			case BLOCK:
			case BRIDGE_RETAINED:
			case BRIDGE_TRANSFER:
			case COVARIANT:
			case CONTRAVARIANT:
			case DEPRECATED:
			case KINDOF:
			case UNUSED:
			case NULL_UNSPECIFIED:
			case NULLABLE:
			case NONNULL:
			case NULL_RESETTABLE:
			case NS_INLINE:
			case NS_ENUM:
			case NS_OPTIONS:
			case ASSIGN:
			case COPY:
			case GETTER:
			case SETTER:
			case STRONG:
			case READONLY:
			case READWRITE:
			case WEAK:
			case UNSAFE_UNRETAINED:
			case IB_OUTLET:
			case IB_OUTLET_COLLECTION:
			case IB_INSPECTABLE:
			case IB_DESIGNABLE:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(1149);
				identifier();
				}
				break;
			case DEFAULT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1150);
				match(DEFAULT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DirectDeclaratorContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public List<DeclaratorSuffixContext> declaratorSuffix() {
			return getRuleContexts(DeclaratorSuffixContext.class);
		}
		public DeclaratorSuffixContext declaratorSuffix(int i) {
			return getRuleContext(DeclaratorSuffixContext.class,i);
		}
		public TerminalNode BITXOR() { return getToken(ObjectiveCParser.BITXOR, 0); }
		public BlockParametersContext blockParameters() {
			return getRuleContext(BlockParametersContext.class,0);
		}
		public NullabilitySpecifierContext nullabilitySpecifier() {
			return getRuleContext(NullabilitySpecifierContext.class,0);
		}
		public DirectDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_directDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterDirectDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitDirectDeclarator(this);
		}
	}

	public final DirectDeclaratorContext directDeclarator() throws RecognitionException {
		DirectDeclaratorContext _localctx = new DirectDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 196, RULE_directDeclarator);
		int _la;
		try {
			setState(1176);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,138,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1158);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BOOL:
				case Class:
				case BYCOPY:
				case BYREF:
				case ID:
				case IMP:
				case IN:
				case INOUT:
				case ONEWAY:
				case OUT:
				case PROTOCOL_:
				case SEL:
				case SELF:
				case SUPER:
				case ATOMIC:
				case NONATOMIC:
				case RETAIN:
				case AUTORELEASING_QUALIFIER:
				case BLOCK:
				case BRIDGE_RETAINED:
				case BRIDGE_TRANSFER:
				case COVARIANT:
				case CONTRAVARIANT:
				case DEPRECATED:
				case KINDOF:
				case UNUSED:
				case NULL_UNSPECIFIED:
				case NULLABLE:
				case NONNULL:
				case NULL_RESETTABLE:
				case NS_INLINE:
				case NS_ENUM:
				case NS_OPTIONS:
				case ASSIGN:
				case COPY:
				case GETTER:
				case SETTER:
				case STRONG:
				case READONLY:
				case READWRITE:
				case WEAK:
				case UNSAFE_UNRETAINED:
				case IB_OUTLET:
				case IB_OUTLET_COLLECTION:
				case IB_INSPECTABLE:
				case IB_DESIGNABLE:
				case IDENTIFIER:
					{
					setState(1153);
					identifier();
					}
					break;
				case LP:
					{
					setState(1154);
					match(LP);
					setState(1155);
					declarator();
					setState(1156);
					match(RP);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1163);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LBRACK) {
					{
					{
					setState(1160);
					declaratorSuffix();
					}
					}
					setState(1165);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1166);
				match(LP);
				setState(1167);
				match(BITXOR);
				setState(1169);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,136,_ctx) ) {
				case 1:
					{
					setState(1168);
					nullabilitySpecifier();
					}
					break;
				}
				setState(1172);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0)) {
					{
					setState(1171);
					identifier();
					}
				}

				setState(1174);
				match(RP);
				setState(1175);
				blockParameters();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaratorSuffixContext extends ParserRuleContext {
		public TerminalNode LBRACK() { return getToken(ObjectiveCParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(ObjectiveCParser.RBRACK, 0); }
		public ConstantExpressionContext constantExpression() {
			return getRuleContext(ConstantExpressionContext.class,0);
		}
		public DeclaratorSuffixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaratorSuffix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterDeclaratorSuffix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitDeclaratorSuffix(this);
		}
	}

	public final DeclaratorSuffixContext declaratorSuffix() throws RecognitionException {
		DeclaratorSuffixContext _localctx = new DeclaratorSuffixContext(_ctx, getState());
		enterRule(_localctx, 198, RULE_declaratorSuffix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1178);
			match(LBRACK);
			setState(1180);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << NIL) | (1L << NO) | (1L << NULL) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << YES))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0) || ((((_la - 152)) & ~0x3f) == 0 && ((1L << (_la - 152)) & ((1L << (ADD - 152)) | (1L << (SUB - 152)) | (1L << (CHARACTER_LITERAL - 152)) | (1L << (HEX_LITERAL - 152)) | (1L << (OCTAL_LITERAL - 152)) | (1L << (BINARY_LITERAL - 152)) | (1L << (DECIMAL_LITERAL - 152)) | (1L << (FLOATING_POINT_LITERAL - 152)))) != 0)) {
				{
				setState(1179);
				constantExpression();
				}
			}

			setState(1182);
			match(RBRACK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterListContext extends ParserRuleContext {
		public ParameterDeclarationListContext parameterDeclarationList() {
			return getRuleContext(ParameterDeclarationListContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(ObjectiveCParser.COMMA, 0); }
		public TerminalNode ELIPSIS() { return getToken(ObjectiveCParser.ELIPSIS, 0); }
		public ParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitParameterList(this);
		}
	}

	public final ParameterListContext parameterList() throws RecognitionException {
		ParameterListContext _localctx = new ParameterListContext(_ctx, getState());
		enterRule(_localctx, 200, RULE_parameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1184);
			parameterDeclarationList();
			setState(1187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1185);
				match(COMMA);
				setState(1186);
				match(ELIPSIS);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PointerContext extends ParserRuleContext {
		public TerminalNode MUL() { return getToken(ObjectiveCParser.MUL, 0); }
		public DeclarationSpecifiersContext declarationSpecifiers() {
			return getRuleContext(DeclarationSpecifiersContext.class,0);
		}
		public PointerContext pointer() {
			return getRuleContext(PointerContext.class,0);
		}
		public PointerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pointer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterPointer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitPointer(this);
		}
	}

	public final PointerContext pointer() throws RecognitionException {
		PointerContext _localctx = new PointerContext(_ctx, getState());
		enterRule(_localctx, 202, RULE_pointer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1189);
			match(MUL);
			setState(1191);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,141,_ctx) ) {
			case 1:
				{
				setState(1190);
				declarationSpecifiers();
				}
				break;
			}
			setState(1194);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,142,_ctx) ) {
			case 1:
				{
				setState(1193);
				pointer();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MacroContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public List<PrimaryExpressionContext> primaryExpression() {
			return getRuleContexts(PrimaryExpressionContext.class);
		}
		public PrimaryExpressionContext primaryExpression(int i) {
			return getRuleContext(PrimaryExpressionContext.class,i);
		}
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public List<TerminalNode> COMMA() { return getTokens(ObjectiveCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ObjectiveCParser.COMMA, i);
		}
		public MacroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_macro; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterMacro(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitMacro(this);
		}
	}

	public final MacroContext macro() throws RecognitionException {
		MacroContext _localctx = new MacroContext(_ctx, getState());
		enterRule(_localctx, 204, RULE_macro);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1196);
			identifier();
			setState(1208);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LP) {
				{
				setState(1197);
				match(LP);
				setState(1198);
				primaryExpression();
				setState(1203);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1199);
					match(COMMA);
					setState(1200);
					primaryExpression();
					}
					}
					setState(1205);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1206);
				match(RP);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayInitializerContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(ObjectiveCParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ObjectiveCParser.RBRACE, 0); }
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(ObjectiveCParser.COMMA, 0); }
		public ArrayInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterArrayInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitArrayInitializer(this);
		}
	}

	public final ArrayInitializerContext arrayInitializer() throws RecognitionException {
		ArrayInitializerContext _localctx = new ArrayInitializerContext(_ctx, getState());
		enterRule(_localctx, 206, RULE_arrayInitializer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1210);
			match(LBRACE);
			setState(1215);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SIZEOF) | (1L << TRUE) | (1L << FALSE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << NIL) | (1L << NO) | (1L << NULL) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << YES) | (1L << ENCODE))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (PROTOCOL - 69)) | (1L << (SELECTOR - 69)) | (1L << (ATOMIC - 69)) | (1L << (NONATOMIC - 69)) | (1L << (RETAIN - 69)) | (1L << (AUTORELEASING_QUALIFIER - 69)) | (1L << (BLOCK - 69)) | (1L << (BRIDGE_RETAINED - 69)) | (1L << (BRIDGE_TRANSFER - 69)) | (1L << (COVARIANT - 69)) | (1L << (CONTRAVARIANT - 69)) | (1L << (DEPRECATED - 69)) | (1L << (KINDOF - 69)) | (1L << (UNUSED - 69)) | (1L << (NULL_UNSPECIFIED - 69)) | (1L << (NULLABLE - 69)) | (1L << (NONNULL - 69)) | (1L << (NULL_RESETTABLE - 69)) | (1L << (NS_INLINE - 69)) | (1L << (NS_ENUM - 69)) | (1L << (NS_OPTIONS - 69)) | (1L << (ASSIGN - 69)) | (1L << (COPY - 69)) | (1L << (GETTER - 69)) | (1L << (SETTER - 69)) | (1L << (STRONG - 69)) | (1L << (READONLY - 69)) | (1L << (READWRITE - 69)) | (1L << (WEAK - 69)) | (1L << (UNSAFE_UNRETAINED - 69)) | (1L << (IB_OUTLET - 69)) | (1L << (IB_OUTLET_COLLECTION - 69)) | (1L << (IB_INSPECTABLE - 69)) | (1L << (IB_DESIGNABLE - 69)) | (1L << (IDENTIFIER - 69)) | (1L << (LP - 69)) | (1L << (LBRACK - 69)))) != 0) || ((((_la - 136)) & ~0x3f) == 0 && ((1L << (_la - 136)) & ((1L << (AT - 136)) | (1L << (BANG - 136)) | (1L << (TILDE - 136)) | (1L << (INC - 136)) | (1L << (DEC - 136)) | (1L << (ADD - 136)) | (1L << (SUB - 136)) | (1L << (MUL - 136)) | (1L << (BITAND - 136)) | (1L << (BITXOR - 136)) | (1L << (CHARACTER_LITERAL - 136)) | (1L << (STRING_START - 136)) | (1L << (HEX_LITERAL - 136)) | (1L << (OCTAL_LITERAL - 136)) | (1L << (BINARY_LITERAL - 136)) | (1L << (DECIMAL_LITERAL - 136)) | (1L << (FLOATING_POINT_LITERAL - 136)))) != 0)) {
				{
				setState(1211);
				expressions();
				setState(1213);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(1212);
					match(COMMA);
					}
				}

				}
			}

			setState(1217);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StructInitializerContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(ObjectiveCParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ObjectiveCParser.RBRACE, 0); }
		public List<TerminalNode> DOT() { return getTokens(ObjectiveCParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(ObjectiveCParser.DOT, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ObjectiveCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ObjectiveCParser.COMMA, i);
		}
		public StructInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterStructInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitStructInitializer(this);
		}
	}

	public final StructInitializerContext structInitializer() throws RecognitionException {
		StructInitializerContext _localctx = new StructInitializerContext(_ctx, getState());
		enterRule(_localctx, 208, RULE_structInitializer);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1219);
			match(LBRACE);
			setState(1233);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(1220);
				match(DOT);
				setState(1221);
				expression(0);
				setState(1227);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,147,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1222);
						match(COMMA);
						setState(1223);
						match(DOT);
						setState(1224);
						expression(0);
						}
						} 
					}
					setState(1229);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,147,_ctx);
				}
				setState(1231);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(1230);
					match(COMMA);
					}
				}

				}
			}

			setState(1235);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitializerListContext extends ParserRuleContext {
		public List<InitializerContext> initializer() {
			return getRuleContexts(InitializerContext.class);
		}
		public InitializerContext initializer(int i) {
			return getRuleContext(InitializerContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ObjectiveCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ObjectiveCParser.COMMA, i);
		}
		public InitializerListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializerList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterInitializerList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitInitializerList(this);
		}
	}

	public final InitializerListContext initializerList() throws RecognitionException {
		InitializerListContext _localctx = new InitializerListContext(_ctx, getState());
		enterRule(_localctx, 210, RULE_initializerList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1237);
			initializer();
			setState(1242);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,150,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1238);
					match(COMMA);
					setState(1239);
					initializer();
					}
					} 
				}
				setState(1244);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,150,_ctx);
			}
			setState(1246);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1245);
				match(COMMA);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeNameContext extends ParserRuleContext {
		public SpecifierQualifierListContext specifierQualifierList() {
			return getRuleContext(SpecifierQualifierListContext.class,0);
		}
		public AbstractDeclaratorContext abstractDeclarator() {
			return getRuleContext(AbstractDeclaratorContext.class,0);
		}
		public BlockTypeContext blockType() {
			return getRuleContext(BlockTypeContext.class,0);
		}
		public TypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitTypeName(this);
		}
	}

	public final TypeNameContext typeName() throws RecognitionException {
		TypeNameContext _localctx = new TypeNameContext(_ctx, getState());
		enterRule(_localctx, 212, RULE_typeName);
		int _la;
		try {
			setState(1253);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,153,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1248);
				specifierQualifierList();
				setState(1250);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 126)) & ~0x3f) == 0 && ((1L << (_la - 126)) & ((1L << (LP - 126)) | (1L << (LBRACK - 126)) | (1L << (MUL - 126)))) != 0)) {
					{
					setState(1249);
					abstractDeclarator();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1252);
				blockType();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AbstractDeclaratorContext extends ParserRuleContext {
		public PointerContext pointer() {
			return getRuleContext(PointerContext.class,0);
		}
		public AbstractDeclaratorContext abstractDeclarator() {
			return getRuleContext(AbstractDeclaratorContext.class,0);
		}
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public List<AbstractDeclaratorSuffixContext> abstractDeclaratorSuffix() {
			return getRuleContexts(AbstractDeclaratorSuffixContext.class);
		}
		public AbstractDeclaratorSuffixContext abstractDeclaratorSuffix(int i) {
			return getRuleContext(AbstractDeclaratorSuffixContext.class,i);
		}
		public List<TerminalNode> LBRACK() { return getTokens(ObjectiveCParser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(ObjectiveCParser.LBRACK, i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(ObjectiveCParser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(ObjectiveCParser.RBRACK, i);
		}
		public List<ConstantExpressionContext> constantExpression() {
			return getRuleContexts(ConstantExpressionContext.class);
		}
		public ConstantExpressionContext constantExpression(int i) {
			return getRuleContext(ConstantExpressionContext.class,i);
		}
		public AbstractDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_abstractDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterAbstractDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitAbstractDeclarator(this);
		}
	}

	public final AbstractDeclaratorContext abstractDeclarator() throws RecognitionException {
		AbstractDeclaratorContext _localctx = new AbstractDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 214, RULE_abstractDeclarator);
		int _la;
		try {
			setState(1278);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MUL:
				enterOuterAlt(_localctx, 1);
				{
				setState(1255);
				pointer();
				setState(1257);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 126)) & ~0x3f) == 0 && ((1L << (_la - 126)) & ((1L << (LP - 126)) | (1L << (LBRACK - 126)) | (1L << (MUL - 126)))) != 0)) {
					{
					setState(1256);
					abstractDeclarator();
					}
				}

				}
				break;
			case LP:
				enterOuterAlt(_localctx, 2);
				{
				setState(1259);
				match(LP);
				setState(1261);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 126)) & ~0x3f) == 0 && ((1L << (_la - 126)) & ((1L << (LP - 126)) | (1L << (LBRACK - 126)) | (1L << (MUL - 126)))) != 0)) {
					{
					setState(1260);
					abstractDeclarator();
					}
				}

				setState(1263);
				match(RP);
				setState(1265); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1264);
					abstractDeclaratorSuffix();
					}
					}
					setState(1267); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==LP || _la==LBRACK );
				}
				break;
			case LBRACK:
				enterOuterAlt(_localctx, 3);
				{
				setState(1274); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1269);
					match(LBRACK);
					setState(1271);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << NIL) | (1L << NO) | (1L << NULL) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << YES))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0) || ((((_la - 152)) & ~0x3f) == 0 && ((1L << (_la - 152)) & ((1L << (ADD - 152)) | (1L << (SUB - 152)) | (1L << (CHARACTER_LITERAL - 152)) | (1L << (HEX_LITERAL - 152)) | (1L << (OCTAL_LITERAL - 152)) | (1L << (BINARY_LITERAL - 152)) | (1L << (DECIMAL_LITERAL - 152)) | (1L << (FLOATING_POINT_LITERAL - 152)))) != 0)) {
						{
						setState(1270);
						constantExpression();
						}
					}

					setState(1273);
					match(RBRACK);
					}
					}
					setState(1276); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==LBRACK );
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AbstractDeclaratorSuffixContext extends ParserRuleContext {
		public TerminalNode LBRACK() { return getToken(ObjectiveCParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(ObjectiveCParser.RBRACK, 0); }
		public ConstantExpressionContext constantExpression() {
			return getRuleContext(ConstantExpressionContext.class,0);
		}
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public ParameterDeclarationListContext parameterDeclarationList() {
			return getRuleContext(ParameterDeclarationListContext.class,0);
		}
		public AbstractDeclaratorSuffixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_abstractDeclaratorSuffix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterAbstractDeclaratorSuffix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitAbstractDeclaratorSuffix(this);
		}
	}

	public final AbstractDeclaratorSuffixContext abstractDeclaratorSuffix() throws RecognitionException {
		AbstractDeclaratorSuffixContext _localctx = new AbstractDeclaratorSuffixContext(_ctx, getState());
		enterRule(_localctx, 216, RULE_abstractDeclaratorSuffix);
		int _la;
		try {
			setState(1290);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACK:
				enterOuterAlt(_localctx, 1);
				{
				setState(1280);
				match(LBRACK);
				setState(1282);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << NIL) | (1L << NO) | (1L << NULL) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << YES))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0) || ((((_la - 152)) & ~0x3f) == 0 && ((1L << (_la - 152)) & ((1L << (ADD - 152)) | (1L << (SUB - 152)) | (1L << (CHARACTER_LITERAL - 152)) | (1L << (HEX_LITERAL - 152)) | (1L << (OCTAL_LITERAL - 152)) | (1L << (BINARY_LITERAL - 152)) | (1L << (DECIMAL_LITERAL - 152)) | (1L << (FLOATING_POINT_LITERAL - 152)))) != 0)) {
					{
					setState(1281);
					constantExpression();
					}
				}

				setState(1284);
				match(RBRACK);
				}
				break;
			case LP:
				enterOuterAlt(_localctx, 2);
				{
				setState(1285);
				match(LP);
				setState(1287);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AUTO) | (1L << CHAR) | (1L << CONST) | (1L << DOUBLE) | (1L << ENUM) | (1L << EXTERN) | (1L << FLOAT) | (1L << INLINE) | (1L << INT) | (1L << LONG) | (1L << REGISTER) | (1L << RESTRICT) | (1L << SHORT) | (1L << SIGNED) | (1L << STATIC) | (1L << STRUCT) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID) | (1L << VOLATILE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (ATTRIBUTE - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (STRONG_QUALIFIER - 81)) | (1L << (TYPEOF - 81)) | (1L << (UNSAFE_UNRETAINED_QUALIFIER - 81)) | (1L << (UNUSED - 81)) | (1L << (WEAK_QUALIFIER - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0)) {
					{
					setState(1286);
					parameterDeclarationList();
					}
				}

				setState(1289);
				match(RP);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterDeclarationListContext extends ParserRuleContext {
		public List<ParameterDeclarationContext> parameterDeclaration() {
			return getRuleContexts(ParameterDeclarationContext.class);
		}
		public ParameterDeclarationContext parameterDeclaration(int i) {
			return getRuleContext(ParameterDeclarationContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ObjectiveCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ObjectiveCParser.COMMA, i);
		}
		public ParameterDeclarationListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterDeclarationList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterParameterDeclarationList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitParameterDeclarationList(this);
		}
	}

	public final ParameterDeclarationListContext parameterDeclarationList() throws RecognitionException {
		ParameterDeclarationListContext _localctx = new ParameterDeclarationListContext(_ctx, getState());
		enterRule(_localctx, 218, RULE_parameterDeclarationList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1292);
			parameterDeclaration();
			setState(1297);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,163,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1293);
					match(COMMA);
					setState(1294);
					parameterDeclaration();
					}
					} 
				}
				setState(1299);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,163,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterDeclarationContext extends ParserRuleContext {
		public DeclarationSpecifiersContext declarationSpecifiers() {
			return getRuleContext(DeclarationSpecifiersContext.class,0);
		}
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public TerminalNode VOID() { return getToken(ObjectiveCParser.VOID, 0); }
		public ParameterDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterParameterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitParameterDeclaration(this);
		}
	}

	public final ParameterDeclarationContext parameterDeclaration() throws RecognitionException {
		ParameterDeclarationContext _localctx = new ParameterDeclarationContext(_ctx, getState());
		enterRule(_localctx, 220, RULE_parameterDeclaration);
		try {
			setState(1304);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,164,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1300);
				declarationSpecifiers();
				setState(1301);
				declarator();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1303);
				match(VOID);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaratorContext extends ParserRuleContext {
		public DirectDeclaratorContext directDeclarator() {
			return getRuleContext(DirectDeclaratorContext.class,0);
		}
		public PointerContext pointer() {
			return getRuleContext(PointerContext.class,0);
		}
		public DeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitDeclarator(this);
		}
	}

	public final DeclaratorContext declarator() throws RecognitionException {
		DeclaratorContext _localctx = new DeclaratorContext(_ctx, getState());
		enterRule(_localctx, 222, RULE_declarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1307);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MUL) {
				{
				setState(1306);
				pointer();
				}
			}

			setState(1309);
			directDeclarator();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public LabeledStatementContext labeledStatement() {
			return getRuleContext(LabeledStatementContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ObjectiveCParser.SEMI, 0); }
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public SelectionStatementContext selectionStatement() {
			return getRuleContext(SelectionStatementContext.class,0);
		}
		public IterationStatementContext iterationStatement() {
			return getRuleContext(IterationStatementContext.class,0);
		}
		public JumpStatementContext jumpStatement() {
			return getRuleContext(JumpStatementContext.class,0);
		}
		public SynchronizedStatementContext synchronizedStatement() {
			return getRuleContext(SynchronizedStatementContext.class,0);
		}
		public AutoreleaseStatementContext autoreleaseStatement() {
			return getRuleContext(AutoreleaseStatementContext.class,0);
		}
		public ThrowStatementContext throwStatement() {
			return getRuleContext(ThrowStatementContext.class,0);
		}
		public TryBlockContext tryBlock() {
			return getRuleContext(TryBlockContext.class,0);
		}
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 224, RULE_statement);
		try {
			setState(1352);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,176,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1311);
				labeledStatement();
				setState(1313);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,166,_ctx) ) {
				case 1:
					{
					setState(1312);
					match(SEMI);
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1315);
				compoundStatement();
				setState(1317);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,167,_ctx) ) {
				case 1:
					{
					setState(1316);
					match(SEMI);
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1319);
				selectionStatement();
				setState(1321);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,168,_ctx) ) {
				case 1:
					{
					setState(1320);
					match(SEMI);
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1323);
				iterationStatement();
				setState(1325);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,169,_ctx) ) {
				case 1:
					{
					setState(1324);
					match(SEMI);
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1327);
				jumpStatement();
				setState(1329);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,170,_ctx) ) {
				case 1:
					{
					setState(1328);
					match(SEMI);
					}
					break;
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1331);
				synchronizedStatement();
				setState(1333);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,171,_ctx) ) {
				case 1:
					{
					setState(1332);
					match(SEMI);
					}
					break;
				}
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1335);
				autoreleaseStatement();
				setState(1337);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,172,_ctx) ) {
				case 1:
					{
					setState(1336);
					match(SEMI);
					}
					break;
				}
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1339);
				throwStatement();
				setState(1341);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,173,_ctx) ) {
				case 1:
					{
					setState(1340);
					match(SEMI);
					}
					break;
				}
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1343);
				tryBlock();
				setState(1345);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,174,_ctx) ) {
				case 1:
					{
					setState(1344);
					match(SEMI);
					}
					break;
				}
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1347);
				expressions();
				setState(1349);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,175,_ctx) ) {
				case 1:
					{
					setState(1348);
					match(SEMI);
					}
					break;
				}
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(1351);
				match(SEMI);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LabeledStatementContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode COLON() { return getToken(ObjectiveCParser.COLON, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public LabeledStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labeledStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterLabeledStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitLabeledStatement(this);
		}
	}

	public final LabeledStatementContext labeledStatement() throws RecognitionException {
		LabeledStatementContext _localctx = new LabeledStatementContext(_ctx, getState());
		enterRule(_localctx, 226, RULE_labeledStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1354);
			identifier();
			setState(1355);
			match(COLON);
			setState(1356);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RangeExpressionContext extends ParserRuleContext {
		public List<ConstantExpressionContext> constantExpression() {
			return getRuleContexts(ConstantExpressionContext.class);
		}
		public ConstantExpressionContext constantExpression(int i) {
			return getRuleContext(ConstantExpressionContext.class,i);
		}
		public TerminalNode ELIPSIS() { return getToken(ObjectiveCParser.ELIPSIS, 0); }
		public RangeExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rangeExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterRangeExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitRangeExpression(this);
		}
	}

	public final RangeExpressionContext rangeExpression() throws RecognitionException {
		RangeExpressionContext _localctx = new RangeExpressionContext(_ctx, getState());
		enterRule(_localctx, 228, RULE_rangeExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1358);
			constantExpression();
			setState(1361);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELIPSIS) {
				{
				setState(1359);
				match(ELIPSIS);
				setState(1360);
				constantExpression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CompoundStatementContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(ObjectiveCParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ObjectiveCParser.RBRACE, 0); }
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public CompoundStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compoundStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterCompoundStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitCompoundStatement(this);
		}
	}

	public final CompoundStatementContext compoundStatement() throws RecognitionException {
		CompoundStatementContext _localctx = new CompoundStatementContext(_ctx, getState());
		enterRule(_localctx, 230, RULE_compoundStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1363);
			match(LBRACE);
			setState(1368);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AUTO) | (1L << BREAK) | (1L << CHAR) | (1L << CONST) | (1L << CONTINUE) | (1L << DO) | (1L << DOUBLE) | (1L << ENUM) | (1L << EXTERN) | (1L << FLOAT) | (1L << FOR) | (1L << GOTO) | (1L << IF) | (1L << INLINE) | (1L << INT) | (1L << LONG) | (1L << REGISTER) | (1L << RESTRICT) | (1L << RETURN) | (1L << SHORT) | (1L << SIGNED) | (1L << SIZEOF) | (1L << STATIC) | (1L << STRUCT) | (1L << SWITCH) | (1L << TYPEDEF) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID) | (1L << VOLATILE) | (1L << WHILE) | (1L << TRUE) | (1L << FALSE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << NIL) | (1L << NO) | (1L << NULL) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << YES) | (1L << AUTORELEASEPOOL) | (1L << ENCODE))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (PROTOCOL - 69)) | (1L << (SELECTOR - 69)) | (1L << (SYNCHRONIZED - 69)) | (1L << (THROW - 69)) | (1L << (TRY - 69)) | (1L << (ATOMIC - 69)) | (1L << (NONATOMIC - 69)) | (1L << (RETAIN - 69)) | (1L << (ATTRIBUTE - 69)) | (1L << (AUTORELEASING_QUALIFIER - 69)) | (1L << (BLOCK - 69)) | (1L << (BRIDGE - 69)) | (1L << (BRIDGE_RETAINED - 69)) | (1L << (BRIDGE_TRANSFER - 69)) | (1L << (COVARIANT - 69)) | (1L << (CONTRAVARIANT - 69)) | (1L << (DEPRECATED - 69)) | (1L << (KINDOF - 69)) | (1L << (STRONG_QUALIFIER - 69)) | (1L << (TYPEOF - 69)) | (1L << (UNSAFE_UNRETAINED_QUALIFIER - 69)) | (1L << (UNUSED - 69)) | (1L << (WEAK_QUALIFIER - 69)) | (1L << (NULL_UNSPECIFIED - 69)) | (1L << (NULLABLE - 69)) | (1L << (NONNULL - 69)) | (1L << (NULL_RESETTABLE - 69)) | (1L << (NS_INLINE - 69)) | (1L << (NS_ENUM - 69)) | (1L << (NS_OPTIONS - 69)) | (1L << (ASSIGN - 69)) | (1L << (COPY - 69)) | (1L << (GETTER - 69)) | (1L << (SETTER - 69)) | (1L << (STRONG - 69)) | (1L << (READONLY - 69)) | (1L << (READWRITE - 69)) | (1L << (WEAK - 69)) | (1L << (UNSAFE_UNRETAINED - 69)) | (1L << (IB_OUTLET - 69)) | (1L << (IB_OUTLET_COLLECTION - 69)) | (1L << (IB_INSPECTABLE - 69)) | (1L << (IB_DESIGNABLE - 69)) | (1L << (IDENTIFIER - 69)) | (1L << (LP - 69)) | (1L << (LBRACE - 69)) | (1L << (LBRACK - 69)) | (1L << (SEMI - 69)))) != 0) || ((((_la - 136)) & ~0x3f) == 0 && ((1L << (_la - 136)) & ((1L << (AT - 136)) | (1L << (BANG - 136)) | (1L << (TILDE - 136)) | (1L << (INC - 136)) | (1L << (DEC - 136)) | (1L << (ADD - 136)) | (1L << (SUB - 136)) | (1L << (MUL - 136)) | (1L << (BITAND - 136)) | (1L << (BITXOR - 136)) | (1L << (CHARACTER_LITERAL - 136)) | (1L << (STRING_START - 136)) | (1L << (HEX_LITERAL - 136)) | (1L << (OCTAL_LITERAL - 136)) | (1L << (BINARY_LITERAL - 136)) | (1L << (DECIMAL_LITERAL - 136)) | (1L << (FLOATING_POINT_LITERAL - 136)))) != 0)) {
				{
				setState(1366);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,178,_ctx) ) {
				case 1:
					{
					setState(1364);
					declaration();
					}
					break;
				case 2:
					{
					setState(1365);
					statement();
					}
					break;
				}
				}
				setState(1370);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1371);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectionStatementContext extends ParserRuleContext {
		public StatementContext ifBody;
		public StatementContext elseBody;
		public TerminalNode IF() { return getToken(ObjectiveCParser.IF, 0); }
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(ObjectiveCParser.ELSE, 0); }
		public SwitchStatementContext switchStatement() {
			return getRuleContext(SwitchStatementContext.class,0);
		}
		public SelectionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterSelectionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitSelectionStatement(this);
		}
	}

	public final SelectionStatementContext selectionStatement() throws RecognitionException {
		SelectionStatementContext _localctx = new SelectionStatementContext(_ctx, getState());
		enterRule(_localctx, 232, RULE_selectionStatement);
		try {
			setState(1383);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(1373);
				match(IF);
				setState(1374);
				match(LP);
				setState(1375);
				expression(0);
				setState(1376);
				match(RP);
				setState(1377);
				((SelectionStatementContext)_localctx).ifBody = statement();
				setState(1380);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,180,_ctx) ) {
				case 1:
					{
					setState(1378);
					match(ELSE);
					setState(1379);
					((SelectionStatementContext)_localctx).elseBody = statement();
					}
					break;
				}
				}
				break;
			case SWITCH:
				enterOuterAlt(_localctx, 2);
				{
				setState(1382);
				switchStatement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SwitchStatementContext extends ParserRuleContext {
		public TerminalNode SWITCH() { return getToken(ObjectiveCParser.SWITCH, 0); }
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public SwitchBlockContext switchBlock() {
			return getRuleContext(SwitchBlockContext.class,0);
		}
		public SwitchStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterSwitchStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitSwitchStatement(this);
		}
	}

	public final SwitchStatementContext switchStatement() throws RecognitionException {
		SwitchStatementContext _localctx = new SwitchStatementContext(_ctx, getState());
		enterRule(_localctx, 234, RULE_switchStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1385);
			match(SWITCH);
			setState(1386);
			match(LP);
			setState(1387);
			expression(0);
			setState(1388);
			match(RP);
			setState(1389);
			switchBlock();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SwitchBlockContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(ObjectiveCParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ObjectiveCParser.RBRACE, 0); }
		public List<SwitchSectionContext> switchSection() {
			return getRuleContexts(SwitchSectionContext.class);
		}
		public SwitchSectionContext switchSection(int i) {
			return getRuleContext(SwitchSectionContext.class,i);
		}
		public SwitchBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterSwitchBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitSwitchBlock(this);
		}
	}

	public final SwitchBlockContext switchBlock() throws RecognitionException {
		SwitchBlockContext _localctx = new SwitchBlockContext(_ctx, getState());
		enterRule(_localctx, 236, RULE_switchBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1391);
			match(LBRACE);
			setState(1395);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CASE || _la==DEFAULT) {
				{
				{
				setState(1392);
				switchSection();
				}
				}
				setState(1397);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1398);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SwitchSectionContext extends ParserRuleContext {
		public List<SwitchLabelContext> switchLabel() {
			return getRuleContexts(SwitchLabelContext.class);
		}
		public SwitchLabelContext switchLabel(int i) {
			return getRuleContext(SwitchLabelContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public SwitchSectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchSection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterSwitchSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitSwitchSection(this);
		}
	}

	public final SwitchSectionContext switchSection() throws RecognitionException {
		SwitchSectionContext _localctx = new SwitchSectionContext(_ctx, getState());
		enterRule(_localctx, 238, RULE_switchSection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1401); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1400);
				switchLabel();
				}
				}
				setState(1403); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CASE || _la==DEFAULT );
			setState(1406); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1405);
				statement();
				}
				}
				setState(1408); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BREAK) | (1L << CONTINUE) | (1L << DO) | (1L << FOR) | (1L << GOTO) | (1L << IF) | (1L << RETURN) | (1L << SIZEOF) | (1L << SWITCH) | (1L << WHILE) | (1L << TRUE) | (1L << FALSE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << NIL) | (1L << NO) | (1L << NULL) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << YES) | (1L << AUTORELEASEPOOL) | (1L << ENCODE))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (PROTOCOL - 69)) | (1L << (SELECTOR - 69)) | (1L << (SYNCHRONIZED - 69)) | (1L << (THROW - 69)) | (1L << (TRY - 69)) | (1L << (ATOMIC - 69)) | (1L << (NONATOMIC - 69)) | (1L << (RETAIN - 69)) | (1L << (AUTORELEASING_QUALIFIER - 69)) | (1L << (BLOCK - 69)) | (1L << (BRIDGE_RETAINED - 69)) | (1L << (BRIDGE_TRANSFER - 69)) | (1L << (COVARIANT - 69)) | (1L << (CONTRAVARIANT - 69)) | (1L << (DEPRECATED - 69)) | (1L << (KINDOF - 69)) | (1L << (UNUSED - 69)) | (1L << (NULL_UNSPECIFIED - 69)) | (1L << (NULLABLE - 69)) | (1L << (NONNULL - 69)) | (1L << (NULL_RESETTABLE - 69)) | (1L << (NS_INLINE - 69)) | (1L << (NS_ENUM - 69)) | (1L << (NS_OPTIONS - 69)) | (1L << (ASSIGN - 69)) | (1L << (COPY - 69)) | (1L << (GETTER - 69)) | (1L << (SETTER - 69)) | (1L << (STRONG - 69)) | (1L << (READONLY - 69)) | (1L << (READWRITE - 69)) | (1L << (WEAK - 69)) | (1L << (UNSAFE_UNRETAINED - 69)) | (1L << (IB_OUTLET - 69)) | (1L << (IB_OUTLET_COLLECTION - 69)) | (1L << (IB_INSPECTABLE - 69)) | (1L << (IB_DESIGNABLE - 69)) | (1L << (IDENTIFIER - 69)) | (1L << (LP - 69)) | (1L << (LBRACE - 69)) | (1L << (LBRACK - 69)) | (1L << (SEMI - 69)))) != 0) || ((((_la - 136)) & ~0x3f) == 0 && ((1L << (_la - 136)) & ((1L << (AT - 136)) | (1L << (BANG - 136)) | (1L << (TILDE - 136)) | (1L << (INC - 136)) | (1L << (DEC - 136)) | (1L << (ADD - 136)) | (1L << (SUB - 136)) | (1L << (MUL - 136)) | (1L << (BITAND - 136)) | (1L << (BITXOR - 136)) | (1L << (CHARACTER_LITERAL - 136)) | (1L << (STRING_START - 136)) | (1L << (HEX_LITERAL - 136)) | (1L << (OCTAL_LITERAL - 136)) | (1L << (BINARY_LITERAL - 136)) | (1L << (DECIMAL_LITERAL - 136)) | (1L << (FLOATING_POINT_LITERAL - 136)))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SwitchLabelContext extends ParserRuleContext {
		public TerminalNode CASE() { return getToken(ObjectiveCParser.CASE, 0); }
		public TerminalNode COLON() { return getToken(ObjectiveCParser.COLON, 0); }
		public RangeExpressionContext rangeExpression() {
			return getRuleContext(RangeExpressionContext.class,0);
		}
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public TerminalNode DEFAULT() { return getToken(ObjectiveCParser.DEFAULT, 0); }
		public SwitchLabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchLabel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterSwitchLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitSwitchLabel(this);
		}
	}

	public final SwitchLabelContext switchLabel() throws RecognitionException {
		SwitchLabelContext _localctx = new SwitchLabelContext(_ctx, getState());
		enterRule(_localctx, 240, RULE_switchLabel);
		try {
			setState(1422);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CASE:
				enterOuterAlt(_localctx, 1);
				{
				setState(1410);
				match(CASE);
				setState(1416);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case TRUE:
				case FALSE:
				case BOOL:
				case Class:
				case BYCOPY:
				case BYREF:
				case ID:
				case IMP:
				case IN:
				case INOUT:
				case NIL:
				case NO:
				case NULL:
				case ONEWAY:
				case OUT:
				case PROTOCOL_:
				case SEL:
				case SELF:
				case SUPER:
				case YES:
				case ATOMIC:
				case NONATOMIC:
				case RETAIN:
				case AUTORELEASING_QUALIFIER:
				case BLOCK:
				case BRIDGE_RETAINED:
				case BRIDGE_TRANSFER:
				case COVARIANT:
				case CONTRAVARIANT:
				case DEPRECATED:
				case KINDOF:
				case UNUSED:
				case NULL_UNSPECIFIED:
				case NULLABLE:
				case NONNULL:
				case NULL_RESETTABLE:
				case NS_INLINE:
				case NS_ENUM:
				case NS_OPTIONS:
				case ASSIGN:
				case COPY:
				case GETTER:
				case SETTER:
				case STRONG:
				case READONLY:
				case READWRITE:
				case WEAK:
				case UNSAFE_UNRETAINED:
				case IB_OUTLET:
				case IB_OUTLET_COLLECTION:
				case IB_INSPECTABLE:
				case IB_DESIGNABLE:
				case IDENTIFIER:
				case ADD:
				case SUB:
				case CHARACTER_LITERAL:
				case HEX_LITERAL:
				case OCTAL_LITERAL:
				case BINARY_LITERAL:
				case DECIMAL_LITERAL:
				case FLOATING_POINT_LITERAL:
					{
					setState(1411);
					rangeExpression();
					}
					break;
				case LP:
					{
					setState(1412);
					match(LP);
					setState(1413);
					rangeExpression();
					setState(1414);
					match(RP);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1418);
				match(COLON);
				}
				break;
			case DEFAULT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1420);
				match(DEFAULT);
				setState(1421);
				match(COLON);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IterationStatementContext extends ParserRuleContext {
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public DoStatementContext doStatement() {
			return getRuleContext(DoStatementContext.class,0);
		}
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public ForInStatementContext forInStatement() {
			return getRuleContext(ForInStatementContext.class,0);
		}
		public IterationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iterationStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterIterationStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitIterationStatement(this);
		}
	}

	public final IterationStatementContext iterationStatement() throws RecognitionException {
		IterationStatementContext _localctx = new IterationStatementContext(_ctx, getState());
		enterRule(_localctx, 242, RULE_iterationStatement);
		try {
			setState(1428);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,187,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1424);
				whileStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1425);
				doStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1426);
				forStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1427);
				forInStatement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileStatementContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(ObjectiveCParser.WHILE, 0); }
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitWhileStatement(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 244, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1430);
			match(WHILE);
			setState(1431);
			match(LP);
			setState(1432);
			expression(0);
			setState(1433);
			match(RP);
			setState(1434);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DoStatementContext extends ParserRuleContext {
		public TerminalNode DO() { return getToken(ObjectiveCParser.DO, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(ObjectiveCParser.WHILE, 0); }
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public TerminalNode SEMI() { return getToken(ObjectiveCParser.SEMI, 0); }
		public DoStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterDoStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitDoStatement(this);
		}
	}

	public final DoStatementContext doStatement() throws RecognitionException {
		DoStatementContext _localctx = new DoStatementContext(_ctx, getState());
		enterRule(_localctx, 246, RULE_doStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1436);
			match(DO);
			setState(1437);
			statement();
			setState(1438);
			match(WHILE);
			setState(1439);
			match(LP);
			setState(1440);
			expression(0);
			setState(1441);
			match(RP);
			setState(1442);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForStatementContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(ObjectiveCParser.FOR, 0); }
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public List<TerminalNode> SEMI() { return getTokens(ObjectiveCParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(ObjectiveCParser.SEMI, i);
		}
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ForLoopInitializerContext forLoopInitializer() {
			return getRuleContext(ForLoopInitializerContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitForStatement(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 248, RULE_forStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1444);
			match(FOR);
			setState(1445);
			match(LP);
			setState(1447);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AUTO) | (1L << CHAR) | (1L << CONST) | (1L << DOUBLE) | (1L << ENUM) | (1L << EXTERN) | (1L << FLOAT) | (1L << INLINE) | (1L << INT) | (1L << LONG) | (1L << REGISTER) | (1L << RESTRICT) | (1L << SHORT) | (1L << SIGNED) | (1L << SIZEOF) | (1L << STATIC) | (1L << STRUCT) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID) | (1L << VOLATILE) | (1L << TRUE) | (1L << FALSE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << NIL) | (1L << NO) | (1L << NULL) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << YES) | (1L << ENCODE))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (PROTOCOL - 69)) | (1L << (SELECTOR - 69)) | (1L << (ATOMIC - 69)) | (1L << (NONATOMIC - 69)) | (1L << (RETAIN - 69)) | (1L << (ATTRIBUTE - 69)) | (1L << (AUTORELEASING_QUALIFIER - 69)) | (1L << (BLOCK - 69)) | (1L << (BRIDGE - 69)) | (1L << (BRIDGE_RETAINED - 69)) | (1L << (BRIDGE_TRANSFER - 69)) | (1L << (COVARIANT - 69)) | (1L << (CONTRAVARIANT - 69)) | (1L << (DEPRECATED - 69)) | (1L << (KINDOF - 69)) | (1L << (STRONG_QUALIFIER - 69)) | (1L << (TYPEOF - 69)) | (1L << (UNSAFE_UNRETAINED_QUALIFIER - 69)) | (1L << (UNUSED - 69)) | (1L << (WEAK_QUALIFIER - 69)) | (1L << (NULL_UNSPECIFIED - 69)) | (1L << (NULLABLE - 69)) | (1L << (NONNULL - 69)) | (1L << (NULL_RESETTABLE - 69)) | (1L << (NS_INLINE - 69)) | (1L << (NS_ENUM - 69)) | (1L << (NS_OPTIONS - 69)) | (1L << (ASSIGN - 69)) | (1L << (COPY - 69)) | (1L << (GETTER - 69)) | (1L << (SETTER - 69)) | (1L << (STRONG - 69)) | (1L << (READONLY - 69)) | (1L << (READWRITE - 69)) | (1L << (WEAK - 69)) | (1L << (UNSAFE_UNRETAINED - 69)) | (1L << (IB_OUTLET - 69)) | (1L << (IB_OUTLET_COLLECTION - 69)) | (1L << (IB_INSPECTABLE - 69)) | (1L << (IB_DESIGNABLE - 69)) | (1L << (IDENTIFIER - 69)) | (1L << (LP - 69)) | (1L << (LBRACK - 69)))) != 0) || ((((_la - 136)) & ~0x3f) == 0 && ((1L << (_la - 136)) & ((1L << (AT - 136)) | (1L << (BANG - 136)) | (1L << (TILDE - 136)) | (1L << (INC - 136)) | (1L << (DEC - 136)) | (1L << (ADD - 136)) | (1L << (SUB - 136)) | (1L << (MUL - 136)) | (1L << (BITAND - 136)) | (1L << (BITXOR - 136)) | (1L << (CHARACTER_LITERAL - 136)) | (1L << (STRING_START - 136)) | (1L << (HEX_LITERAL - 136)) | (1L << (OCTAL_LITERAL - 136)) | (1L << (BINARY_LITERAL - 136)) | (1L << (DECIMAL_LITERAL - 136)) | (1L << (FLOATING_POINT_LITERAL - 136)))) != 0)) {
				{
				setState(1446);
				forLoopInitializer();
				}
			}

			setState(1449);
			match(SEMI);
			setState(1451);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SIZEOF) | (1L << TRUE) | (1L << FALSE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << NIL) | (1L << NO) | (1L << NULL) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << YES) | (1L << ENCODE))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (PROTOCOL - 69)) | (1L << (SELECTOR - 69)) | (1L << (ATOMIC - 69)) | (1L << (NONATOMIC - 69)) | (1L << (RETAIN - 69)) | (1L << (AUTORELEASING_QUALIFIER - 69)) | (1L << (BLOCK - 69)) | (1L << (BRIDGE_RETAINED - 69)) | (1L << (BRIDGE_TRANSFER - 69)) | (1L << (COVARIANT - 69)) | (1L << (CONTRAVARIANT - 69)) | (1L << (DEPRECATED - 69)) | (1L << (KINDOF - 69)) | (1L << (UNUSED - 69)) | (1L << (NULL_UNSPECIFIED - 69)) | (1L << (NULLABLE - 69)) | (1L << (NONNULL - 69)) | (1L << (NULL_RESETTABLE - 69)) | (1L << (NS_INLINE - 69)) | (1L << (NS_ENUM - 69)) | (1L << (NS_OPTIONS - 69)) | (1L << (ASSIGN - 69)) | (1L << (COPY - 69)) | (1L << (GETTER - 69)) | (1L << (SETTER - 69)) | (1L << (STRONG - 69)) | (1L << (READONLY - 69)) | (1L << (READWRITE - 69)) | (1L << (WEAK - 69)) | (1L << (UNSAFE_UNRETAINED - 69)) | (1L << (IB_OUTLET - 69)) | (1L << (IB_OUTLET_COLLECTION - 69)) | (1L << (IB_INSPECTABLE - 69)) | (1L << (IB_DESIGNABLE - 69)) | (1L << (IDENTIFIER - 69)) | (1L << (LP - 69)) | (1L << (LBRACK - 69)))) != 0) || ((((_la - 136)) & ~0x3f) == 0 && ((1L << (_la - 136)) & ((1L << (AT - 136)) | (1L << (BANG - 136)) | (1L << (TILDE - 136)) | (1L << (INC - 136)) | (1L << (DEC - 136)) | (1L << (ADD - 136)) | (1L << (SUB - 136)) | (1L << (MUL - 136)) | (1L << (BITAND - 136)) | (1L << (BITXOR - 136)) | (1L << (CHARACTER_LITERAL - 136)) | (1L << (STRING_START - 136)) | (1L << (HEX_LITERAL - 136)) | (1L << (OCTAL_LITERAL - 136)) | (1L << (BINARY_LITERAL - 136)) | (1L << (DECIMAL_LITERAL - 136)) | (1L << (FLOATING_POINT_LITERAL - 136)))) != 0)) {
				{
				setState(1450);
				expression(0);
				}
			}

			setState(1453);
			match(SEMI);
			setState(1455);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SIZEOF) | (1L << TRUE) | (1L << FALSE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << NIL) | (1L << NO) | (1L << NULL) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << YES) | (1L << ENCODE))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (PROTOCOL - 69)) | (1L << (SELECTOR - 69)) | (1L << (ATOMIC - 69)) | (1L << (NONATOMIC - 69)) | (1L << (RETAIN - 69)) | (1L << (AUTORELEASING_QUALIFIER - 69)) | (1L << (BLOCK - 69)) | (1L << (BRIDGE_RETAINED - 69)) | (1L << (BRIDGE_TRANSFER - 69)) | (1L << (COVARIANT - 69)) | (1L << (CONTRAVARIANT - 69)) | (1L << (DEPRECATED - 69)) | (1L << (KINDOF - 69)) | (1L << (UNUSED - 69)) | (1L << (NULL_UNSPECIFIED - 69)) | (1L << (NULLABLE - 69)) | (1L << (NONNULL - 69)) | (1L << (NULL_RESETTABLE - 69)) | (1L << (NS_INLINE - 69)) | (1L << (NS_ENUM - 69)) | (1L << (NS_OPTIONS - 69)) | (1L << (ASSIGN - 69)) | (1L << (COPY - 69)) | (1L << (GETTER - 69)) | (1L << (SETTER - 69)) | (1L << (STRONG - 69)) | (1L << (READONLY - 69)) | (1L << (READWRITE - 69)) | (1L << (WEAK - 69)) | (1L << (UNSAFE_UNRETAINED - 69)) | (1L << (IB_OUTLET - 69)) | (1L << (IB_OUTLET_COLLECTION - 69)) | (1L << (IB_INSPECTABLE - 69)) | (1L << (IB_DESIGNABLE - 69)) | (1L << (IDENTIFIER - 69)) | (1L << (LP - 69)) | (1L << (LBRACK - 69)))) != 0) || ((((_la - 136)) & ~0x3f) == 0 && ((1L << (_la - 136)) & ((1L << (AT - 136)) | (1L << (BANG - 136)) | (1L << (TILDE - 136)) | (1L << (INC - 136)) | (1L << (DEC - 136)) | (1L << (ADD - 136)) | (1L << (SUB - 136)) | (1L << (MUL - 136)) | (1L << (BITAND - 136)) | (1L << (BITXOR - 136)) | (1L << (CHARACTER_LITERAL - 136)) | (1L << (STRING_START - 136)) | (1L << (HEX_LITERAL - 136)) | (1L << (OCTAL_LITERAL - 136)) | (1L << (BINARY_LITERAL - 136)) | (1L << (DECIMAL_LITERAL - 136)) | (1L << (FLOATING_POINT_LITERAL - 136)))) != 0)) {
				{
				setState(1454);
				expressions();
				}
			}

			setState(1457);
			match(RP);
			setState(1458);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForLoopInitializerContext extends ParserRuleContext {
		public DeclarationSpecifiersContext declarationSpecifiers() {
			return getRuleContext(DeclarationSpecifiersContext.class,0);
		}
		public InitDeclaratorListContext initDeclaratorList() {
			return getRuleContext(InitDeclaratorListContext.class,0);
		}
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public ForLoopInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forLoopInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterForLoopInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitForLoopInitializer(this);
		}
	}

	public final ForLoopInitializerContext forLoopInitializer() throws RecognitionException {
		ForLoopInitializerContext _localctx = new ForLoopInitializerContext(_ctx, getState());
		enterRule(_localctx, 250, RULE_forLoopInitializer);
		try {
			setState(1464);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,191,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1460);
				declarationSpecifiers();
				setState(1461);
				initDeclaratorList();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1463);
				expressions();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForInStatementContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(ObjectiveCParser.FOR, 0); }
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public TypeVariableDeclaratorContext typeVariableDeclarator() {
			return getRuleContext(TypeVariableDeclaratorContext.class,0);
		}
		public TerminalNode IN() { return getToken(ObjectiveCParser.IN, 0); }
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForInStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forInStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterForInStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitForInStatement(this);
		}
	}

	public final ForInStatementContext forInStatement() throws RecognitionException {
		ForInStatementContext _localctx = new ForInStatementContext(_ctx, getState());
		enterRule(_localctx, 252, RULE_forInStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1466);
			match(FOR);
			setState(1467);
			match(LP);
			setState(1468);
			typeVariableDeclarator();
			setState(1469);
			match(IN);
			setState(1471);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SIZEOF) | (1L << TRUE) | (1L << FALSE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << NIL) | (1L << NO) | (1L << NULL) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << YES) | (1L << ENCODE))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (PROTOCOL - 69)) | (1L << (SELECTOR - 69)) | (1L << (ATOMIC - 69)) | (1L << (NONATOMIC - 69)) | (1L << (RETAIN - 69)) | (1L << (AUTORELEASING_QUALIFIER - 69)) | (1L << (BLOCK - 69)) | (1L << (BRIDGE_RETAINED - 69)) | (1L << (BRIDGE_TRANSFER - 69)) | (1L << (COVARIANT - 69)) | (1L << (CONTRAVARIANT - 69)) | (1L << (DEPRECATED - 69)) | (1L << (KINDOF - 69)) | (1L << (UNUSED - 69)) | (1L << (NULL_UNSPECIFIED - 69)) | (1L << (NULLABLE - 69)) | (1L << (NONNULL - 69)) | (1L << (NULL_RESETTABLE - 69)) | (1L << (NS_INLINE - 69)) | (1L << (NS_ENUM - 69)) | (1L << (NS_OPTIONS - 69)) | (1L << (ASSIGN - 69)) | (1L << (COPY - 69)) | (1L << (GETTER - 69)) | (1L << (SETTER - 69)) | (1L << (STRONG - 69)) | (1L << (READONLY - 69)) | (1L << (READWRITE - 69)) | (1L << (WEAK - 69)) | (1L << (UNSAFE_UNRETAINED - 69)) | (1L << (IB_OUTLET - 69)) | (1L << (IB_OUTLET_COLLECTION - 69)) | (1L << (IB_INSPECTABLE - 69)) | (1L << (IB_DESIGNABLE - 69)) | (1L << (IDENTIFIER - 69)) | (1L << (LP - 69)) | (1L << (LBRACK - 69)))) != 0) || ((((_la - 136)) & ~0x3f) == 0 && ((1L << (_la - 136)) & ((1L << (AT - 136)) | (1L << (BANG - 136)) | (1L << (TILDE - 136)) | (1L << (INC - 136)) | (1L << (DEC - 136)) | (1L << (ADD - 136)) | (1L << (SUB - 136)) | (1L << (MUL - 136)) | (1L << (BITAND - 136)) | (1L << (BITXOR - 136)) | (1L << (CHARACTER_LITERAL - 136)) | (1L << (STRING_START - 136)) | (1L << (HEX_LITERAL - 136)) | (1L << (OCTAL_LITERAL - 136)) | (1L << (BINARY_LITERAL - 136)) | (1L << (DECIMAL_LITERAL - 136)) | (1L << (FLOATING_POINT_LITERAL - 136)))) != 0)) {
				{
				setState(1470);
				expression(0);
				}
			}

			setState(1473);
			match(RP);
			setState(1474);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class JumpStatementContext extends ParserRuleContext {
		public TerminalNode GOTO() { return getToken(ObjectiveCParser.GOTO, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode CONTINUE() { return getToken(ObjectiveCParser.CONTINUE, 0); }
		public TerminalNode BREAK() { return getToken(ObjectiveCParser.BREAK, 0); }
		public TerminalNode RETURN() { return getToken(ObjectiveCParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public JumpStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jumpStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterJumpStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitJumpStatement(this);
		}
	}

	public final JumpStatementContext jumpStatement() throws RecognitionException {
		JumpStatementContext _localctx = new JumpStatementContext(_ctx, getState());
		enterRule(_localctx, 254, RULE_jumpStatement);
		try {
			setState(1484);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case GOTO:
				enterOuterAlt(_localctx, 1);
				{
				setState(1476);
				match(GOTO);
				setState(1477);
				identifier();
				}
				break;
			case CONTINUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1478);
				match(CONTINUE);
				}
				break;
			case BREAK:
				enterOuterAlt(_localctx, 3);
				{
				setState(1479);
				match(BREAK);
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 4);
				{
				setState(1480);
				match(RETURN);
				setState(1482);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,193,_ctx) ) {
				case 1:
					{
					setState(1481);
					expression(0);
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionsContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ObjectiveCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ObjectiveCParser.COMMA, i);
		}
		public ExpressionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterExpressions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitExpressions(this);
		}
	}

	public final ExpressionsContext expressions() throws RecognitionException {
		ExpressionsContext _localctx = new ExpressionsContext(_ctx, getState());
		enterRule(_localctx, 256, RULE_expressions);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1486);
			expression(0);
			setState(1491);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,195,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1487);
					match(COMMA);
					setState(1488);
					expression(0);
					}
					} 
				}
				setState(1493);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,195,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext assignmentExpression;
		public Token op;
		public ExpressionContext trueExpression;
		public ExpressionContext falseExpression;
		public CastExpressionContext castExpression() {
			return getRuleContext(CastExpressionContext.class,0);
		}
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public AssignmentOperatorContext assignmentOperator() {
			return getRuleContext(AssignmentOperatorContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode MUL() { return getToken(ObjectiveCParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(ObjectiveCParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(ObjectiveCParser.MOD, 0); }
		public TerminalNode ADD() { return getToken(ObjectiveCParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(ObjectiveCParser.SUB, 0); }
		public List<TerminalNode> LT() { return getTokens(ObjectiveCParser.LT); }
		public TerminalNode LT(int i) {
			return getToken(ObjectiveCParser.LT, i);
		}
		public List<TerminalNode> GT() { return getTokens(ObjectiveCParser.GT); }
		public TerminalNode GT(int i) {
			return getToken(ObjectiveCParser.GT, i);
		}
		public TerminalNode LE() { return getToken(ObjectiveCParser.LE, 0); }
		public TerminalNode GE() { return getToken(ObjectiveCParser.GE, 0); }
		public TerminalNode NOTEQUAL() { return getToken(ObjectiveCParser.NOTEQUAL, 0); }
		public TerminalNode EQUAL() { return getToken(ObjectiveCParser.EQUAL, 0); }
		public TerminalNode BITAND() { return getToken(ObjectiveCParser.BITAND, 0); }
		public TerminalNode BITXOR() { return getToken(ObjectiveCParser.BITXOR, 0); }
		public TerminalNode BITOR() { return getToken(ObjectiveCParser.BITOR, 0); }
		public TerminalNode AND() { return getToken(ObjectiveCParser.AND, 0); }
		public TerminalNode OR() { return getToken(ObjectiveCParser.OR, 0); }
		public TerminalNode QUESTION() { return getToken(ObjectiveCParser.QUESTION, 0); }
		public TerminalNode COLON() { return getToken(ObjectiveCParser.COLON, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 258;
		enterRecursionRule(_localctx, 258, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1504);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,196,_ctx) ) {
			case 1:
				{
				setState(1495);
				castExpression();
				}
				break;
			case 2:
				{
				setState(1496);
				match(LP);
				setState(1497);
				compoundStatement();
				setState(1498);
				match(RP);
				}
				break;
			case 3:
				{
				setState(1500);
				unaryExpression();
				setState(1501);
				assignmentOperator();
				setState(1502);
				((ExpressionContext)_localctx).assignmentExpression = expression(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1550);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,200,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1548);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,199,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1506);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(1507);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 154)) & ~0x3f) == 0 && ((1L << (_la - 154)) & ((1L << (MUL - 154)) | (1L << (DIV - 154)) | (1L << (MOD - 154)))) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1508);
						expression(14);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1509);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(1510);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1511);
						expression(13);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1512);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(1517);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case LT:
							{
							setState(1513);
							match(LT);
							setState(1514);
							match(LT);
							}
							break;
						case GT:
							{
							setState(1515);
							match(GT);
							setState(1516);
							match(GT);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(1519);
						expression(12);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1520);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(1521);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 138)) & ~0x3f) == 0 && ((1L << (_la - 138)) & ((1L << (GT - 138)) | (1L << (LT - 138)) | (1L << (LE - 138)) | (1L << (GE - 138)))) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1522);
						expression(11);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1523);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(1524);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQUAL || _la==NOTEQUAL) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1525);
						expression(10);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1526);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(1527);
						((ExpressionContext)_localctx).op = match(BITAND);
						setState(1528);
						expression(9);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1529);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(1530);
						((ExpressionContext)_localctx).op = match(BITXOR);
						setState(1531);
						expression(8);
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1532);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(1533);
						((ExpressionContext)_localctx).op = match(BITOR);
						setState(1534);
						expression(7);
						}
						break;
					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1535);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(1536);
						((ExpressionContext)_localctx).op = match(AND);
						setState(1537);
						expression(6);
						}
						break;
					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1538);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(1539);
						((ExpressionContext)_localctx).op = match(OR);
						setState(1540);
						expression(5);
						}
						break;
					case 11:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1541);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(1542);
						match(QUESTION);
						setState(1544);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SIZEOF) | (1L << TRUE) | (1L << FALSE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << NIL) | (1L << NO) | (1L << NULL) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << YES) | (1L << ENCODE))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (PROTOCOL - 69)) | (1L << (SELECTOR - 69)) | (1L << (ATOMIC - 69)) | (1L << (NONATOMIC - 69)) | (1L << (RETAIN - 69)) | (1L << (AUTORELEASING_QUALIFIER - 69)) | (1L << (BLOCK - 69)) | (1L << (BRIDGE_RETAINED - 69)) | (1L << (BRIDGE_TRANSFER - 69)) | (1L << (COVARIANT - 69)) | (1L << (CONTRAVARIANT - 69)) | (1L << (DEPRECATED - 69)) | (1L << (KINDOF - 69)) | (1L << (UNUSED - 69)) | (1L << (NULL_UNSPECIFIED - 69)) | (1L << (NULLABLE - 69)) | (1L << (NONNULL - 69)) | (1L << (NULL_RESETTABLE - 69)) | (1L << (NS_INLINE - 69)) | (1L << (NS_ENUM - 69)) | (1L << (NS_OPTIONS - 69)) | (1L << (ASSIGN - 69)) | (1L << (COPY - 69)) | (1L << (GETTER - 69)) | (1L << (SETTER - 69)) | (1L << (STRONG - 69)) | (1L << (READONLY - 69)) | (1L << (READWRITE - 69)) | (1L << (WEAK - 69)) | (1L << (UNSAFE_UNRETAINED - 69)) | (1L << (IB_OUTLET - 69)) | (1L << (IB_OUTLET_COLLECTION - 69)) | (1L << (IB_INSPECTABLE - 69)) | (1L << (IB_DESIGNABLE - 69)) | (1L << (IDENTIFIER - 69)) | (1L << (LP - 69)) | (1L << (LBRACK - 69)))) != 0) || ((((_la - 136)) & ~0x3f) == 0 && ((1L << (_la - 136)) & ((1L << (AT - 136)) | (1L << (BANG - 136)) | (1L << (TILDE - 136)) | (1L << (INC - 136)) | (1L << (DEC - 136)) | (1L << (ADD - 136)) | (1L << (SUB - 136)) | (1L << (MUL - 136)) | (1L << (BITAND - 136)) | (1L << (BITXOR - 136)) | (1L << (CHARACTER_LITERAL - 136)) | (1L << (STRING_START - 136)) | (1L << (HEX_LITERAL - 136)) | (1L << (OCTAL_LITERAL - 136)) | (1L << (BINARY_LITERAL - 136)) | (1L << (DECIMAL_LITERAL - 136)) | (1L << (FLOATING_POINT_LITERAL - 136)))) != 0)) {
							{
							setState(1543);
							((ExpressionContext)_localctx).trueExpression = expression(0);
							}
						}

						setState(1546);
						match(COLON);
						setState(1547);
						((ExpressionContext)_localctx).falseExpression = expression(4);
						}
						break;
					}
					} 
				}
				setState(1552);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,200,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AssignmentOperatorContext extends ParserRuleContext {
		public TerminalNode ASSIGNMENT() { return getToken(ObjectiveCParser.ASSIGNMENT, 0); }
		public TerminalNode MUL_ASSIGN() { return getToken(ObjectiveCParser.MUL_ASSIGN, 0); }
		public TerminalNode DIV_ASSIGN() { return getToken(ObjectiveCParser.DIV_ASSIGN, 0); }
		public TerminalNode MOD_ASSIGN() { return getToken(ObjectiveCParser.MOD_ASSIGN, 0); }
		public TerminalNode ADD_ASSIGN() { return getToken(ObjectiveCParser.ADD_ASSIGN, 0); }
		public TerminalNode SUB_ASSIGN() { return getToken(ObjectiveCParser.SUB_ASSIGN, 0); }
		public TerminalNode LSHIFT_ASSIGN() { return getToken(ObjectiveCParser.LSHIFT_ASSIGN, 0); }
		public TerminalNode RSHIFT_ASSIGN() { return getToken(ObjectiveCParser.RSHIFT_ASSIGN, 0); }
		public TerminalNode AND_ASSIGN() { return getToken(ObjectiveCParser.AND_ASSIGN, 0); }
		public TerminalNode XOR_ASSIGN() { return getToken(ObjectiveCParser.XOR_ASSIGN, 0); }
		public TerminalNode OR_ASSIGN() { return getToken(ObjectiveCParser.OR_ASSIGN, 0); }
		public AssignmentOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterAssignmentOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitAssignmentOperator(this);
		}
	}

	public final AssignmentOperatorContext assignmentOperator() throws RecognitionException {
		AssignmentOperatorContext _localctx = new AssignmentOperatorContext(_ctx, getState());
		enterRule(_localctx, 260, RULE_assignmentOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1553);
			_la = _input.LA(1);
			if ( !(((((_la - 137)) & ~0x3f) == 0 && ((1L << (_la - 137)) & ((1L << (ASSIGNMENT - 137)) | (1L << (ADD_ASSIGN - 137)) | (1L << (SUB_ASSIGN - 137)) | (1L << (MUL_ASSIGN - 137)) | (1L << (DIV_ASSIGN - 137)) | (1L << (AND_ASSIGN - 137)) | (1L << (OR_ASSIGN - 137)) | (1L << (XOR_ASSIGN - 137)) | (1L << (MOD_ASSIGN - 137)) | (1L << (LSHIFT_ASSIGN - 137)) | (1L << (RSHIFT_ASSIGN - 137)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CastExpressionContext extends ParserRuleContext {
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public CastExpressionContext castExpression() {
			return getRuleContext(CastExpressionContext.class,0);
		}
		public InitializerContext initializer() {
			return getRuleContext(InitializerContext.class,0);
		}
		public CastExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_castExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterCastExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitCastExpression(this);
		}
	}

	public final CastExpressionContext castExpression() throws RecognitionException {
		CastExpressionContext _localctx = new CastExpressionContext(_ctx, getState());
		enterRule(_localctx, 262, RULE_castExpression);
		try {
			setState(1564);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,202,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1555);
				unaryExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(1556);
				match(LP);
				setState(1557);
				typeName();
				setState(1558);
				match(RP);
				}
				setState(1562);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,201,_ctx) ) {
				case 1:
					{
					setState(1560);
					castExpression();
					}
					break;
				case 2:
					{
					setState(1561);
					initializer();
					}
					break;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitializerContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArrayInitializerContext arrayInitializer() {
			return getRuleContext(ArrayInitializerContext.class,0);
		}
		public StructInitializerContext structInitializer() {
			return getRuleContext(StructInitializerContext.class,0);
		}
		public InitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitInitializer(this);
		}
	}

	public final InitializerContext initializer() throws RecognitionException {
		InitializerContext _localctx = new InitializerContext(_ctx, getState());
		enterRule(_localctx, 264, RULE_initializer);
		try {
			setState(1569);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,203,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1566);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1567);
				arrayInitializer();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1568);
				structInitializer();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantExpressionContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public ConstantExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterConstantExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitConstantExpression(this);
		}
	}

	public final ConstantExpressionContext constantExpression() throws RecognitionException {
		ConstantExpressionContext _localctx = new ConstantExpressionContext(_ctx, getState());
		enterRule(_localctx, 266, RULE_constantExpression);
		try {
			setState(1573);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOL:
			case Class:
			case BYCOPY:
			case BYREF:
			case ID:
			case IMP:
			case IN:
			case INOUT:
			case ONEWAY:
			case OUT:
			case PROTOCOL_:
			case SEL:
			case SELF:
			case SUPER:
			case ATOMIC:
			case NONATOMIC:
			case RETAIN:
			case AUTORELEASING_QUALIFIER:
			case BLOCK:
			case BRIDGE_RETAINED:
			case BRIDGE_TRANSFER:
			case COVARIANT:
			case CONTRAVARIANT:
			case DEPRECATED:
			case KINDOF:
			case UNUSED:
			case NULL_UNSPECIFIED:
			case NULLABLE:
			case NONNULL:
			case NULL_RESETTABLE:
			case NS_INLINE:
			case NS_ENUM:
			case NS_OPTIONS:
			case ASSIGN:
			case COPY:
			case GETTER:
			case SETTER:
			case STRONG:
			case READONLY:
			case READWRITE:
			case WEAK:
			case UNSAFE_UNRETAINED:
			case IB_OUTLET:
			case IB_OUTLET_COLLECTION:
			case IB_INSPECTABLE:
			case IB_DESIGNABLE:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(1571);
				identifier();
				}
				break;
			case TRUE:
			case FALSE:
			case NIL:
			case NO:
			case NULL:
			case YES:
			case ADD:
			case SUB:
			case CHARACTER_LITERAL:
			case HEX_LITERAL:
			case OCTAL_LITERAL:
			case BINARY_LITERAL:
			case DECIMAL_LITERAL:
			case FLOATING_POINT_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(1572);
				constant();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryExpressionContext extends ParserRuleContext {
		public Token op;
		public PostfixExpressionContext postfixExpression() {
			return getRuleContext(PostfixExpressionContext.class,0);
		}
		public TerminalNode SIZEOF() { return getToken(ObjectiveCParser.SIZEOF, 0); }
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public TypeSpecifierContext typeSpecifier() {
			return getRuleContext(TypeSpecifierContext.class,0);
		}
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public TerminalNode INC() { return getToken(ObjectiveCParser.INC, 0); }
		public TerminalNode DEC() { return getToken(ObjectiveCParser.DEC, 0); }
		public UnaryOperatorContext unaryOperator() {
			return getRuleContext(UnaryOperatorContext.class,0);
		}
		public CastExpressionContext castExpression() {
			return getRuleContext(CastExpressionContext.class,0);
		}
		public UnaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterUnaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitUnaryExpression(this);
		}
	}

	public final UnaryExpressionContext unaryExpression() throws RecognitionException {
		UnaryExpressionContext _localctx = new UnaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 268, RULE_unaryExpression);
		int _la;
		try {
			setState(1589);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,206,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1575);
				postfixExpression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1576);
				match(SIZEOF);
				setState(1582);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,205,_ctx) ) {
				case 1:
					{
					setState(1577);
					unaryExpression();
					}
					break;
				case 2:
					{
					setState(1578);
					match(LP);
					setState(1579);
					typeSpecifier();
					setState(1580);
					match(RP);
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1584);
				((UnaryExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==INC || _la==DEC) ) {
					((UnaryExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1585);
				unaryExpression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1586);
				unaryOperator();
				setState(1587);
				castExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryOperatorContext extends ParserRuleContext {
		public TerminalNode BITAND() { return getToken(ObjectiveCParser.BITAND, 0); }
		public TerminalNode MUL() { return getToken(ObjectiveCParser.MUL, 0); }
		public TerminalNode ADD() { return getToken(ObjectiveCParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(ObjectiveCParser.SUB, 0); }
		public TerminalNode TILDE() { return getToken(ObjectiveCParser.TILDE, 0); }
		public TerminalNode BANG() { return getToken(ObjectiveCParser.BANG, 0); }
		public UnaryOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterUnaryOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitUnaryOperator(this);
		}
	}

	public final UnaryOperatorContext unaryOperator() throws RecognitionException {
		UnaryOperatorContext _localctx = new UnaryOperatorContext(_ctx, getState());
		enterRule(_localctx, 270, RULE_unaryOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1591);
			_la = _input.LA(1);
			if ( !(((((_la - 140)) & ~0x3f) == 0 && ((1L << (_la - 140)) & ((1L << (BANG - 140)) | (1L << (TILDE - 140)) | (1L << (ADD - 140)) | (1L << (SUB - 140)) | (1L << (MUL - 140)) | (1L << (BITAND - 140)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PostfixExpressionContext extends ParserRuleContext {
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public List<PostfixContext> postfix() {
			return getRuleContexts(PostfixContext.class);
		}
		public PostfixContext postfix(int i) {
			return getRuleContext(PostfixContext.class,i);
		}
		public PostfixExpressionContext postfixExpression() {
			return getRuleContext(PostfixExpressionContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode DOT() { return getToken(ObjectiveCParser.DOT, 0); }
		public TerminalNode STRUCTACCESS() { return getToken(ObjectiveCParser.STRUCTACCESS, 0); }
		public PostfixExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfixExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterPostfixExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitPostfixExpression(this);
		}
	}

	public final PostfixExpressionContext postfixExpression() throws RecognitionException {
		return postfixExpression(0);
	}

	private PostfixExpressionContext postfixExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PostfixExpressionContext _localctx = new PostfixExpressionContext(_ctx, _parentState);
		PostfixExpressionContext _prevctx = _localctx;
		int _startState = 272;
		enterRecursionRule(_localctx, 272, RULE_postfixExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1594);
			primaryExpression();
			setState(1598);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,207,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1595);
					postfix();
					}
					} 
				}
				setState(1600);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,207,_ctx);
			}
			}
			_ctx.stop = _input.LT(-1);
			setState(1612);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,209,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new PostfixExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_postfixExpression);
					setState(1601);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(1602);
					_la = _input.LA(1);
					if ( !(_la==DOT || _la==STRUCTACCESS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(1603);
					identifier();
					setState(1607);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,208,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(1604);
							postfix();
							}
							} 
						}
						setState(1609);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,208,_ctx);
					}
					}
					} 
				}
				setState(1614);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,209,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PostfixContext extends ParserRuleContext {
		public Token RP;
		public List<Token> macroArguments = new ArrayList<Token>();
		public Token _tset3106;
		public Token op;
		public TerminalNode LBRACK() { return getToken(ObjectiveCParser.LBRACK, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RBRACK() { return getToken(ObjectiveCParser.RBRACK, 0); }
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public List<TerminalNode> RP() { return getTokens(ObjectiveCParser.RP); }
		public TerminalNode RP(int i) {
			return getToken(ObjectiveCParser.RP, i);
		}
		public ArgumentExpressionListContext argumentExpressionList() {
			return getRuleContext(ArgumentExpressionListContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(ObjectiveCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ObjectiveCParser.COMMA, i);
		}
		public TerminalNode INC() { return getToken(ObjectiveCParser.INC, 0); }
		public TerminalNode DEC() { return getToken(ObjectiveCParser.DEC, 0); }
		public PostfixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterPostfix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitPostfix(this);
		}
	}

	public final PostfixContext postfix() throws RecognitionException {
		PostfixContext _localctx = new PostfixContext(_ctx, getState());
		enterRule(_localctx, 274, RULE_postfix);
		int _la;
		try {
			setState(1633);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,213,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1615);
				match(LBRACK);
				setState(1616);
				expression(0);
				setState(1617);
				match(RBRACK);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1619);
				match(LP);
				setState(1621);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CHAR) | (1L << DOUBLE) | (1L << ENUM) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << SHORT) | (1L << SIGNED) | (1L << SIZEOF) | (1L << STRUCT) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID) | (1L << TRUE) | (1L << FALSE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << NIL) | (1L << NO) | (1L << NULL) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << YES) | (1L << ENCODE))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (PROTOCOL - 69)) | (1L << (SELECTOR - 69)) | (1L << (ATOMIC - 69)) | (1L << (NONATOMIC - 69)) | (1L << (RETAIN - 69)) | (1L << (AUTORELEASING_QUALIFIER - 69)) | (1L << (BLOCK - 69)) | (1L << (BRIDGE_RETAINED - 69)) | (1L << (BRIDGE_TRANSFER - 69)) | (1L << (COVARIANT - 69)) | (1L << (CONTRAVARIANT - 69)) | (1L << (DEPRECATED - 69)) | (1L << (KINDOF - 69)) | (1L << (TYPEOF - 69)) | (1L << (UNUSED - 69)) | (1L << (NULL_UNSPECIFIED - 69)) | (1L << (NULLABLE - 69)) | (1L << (NONNULL - 69)) | (1L << (NULL_RESETTABLE - 69)) | (1L << (NS_INLINE - 69)) | (1L << (NS_ENUM - 69)) | (1L << (NS_OPTIONS - 69)) | (1L << (ASSIGN - 69)) | (1L << (COPY - 69)) | (1L << (GETTER - 69)) | (1L << (SETTER - 69)) | (1L << (STRONG - 69)) | (1L << (READONLY - 69)) | (1L << (READWRITE - 69)) | (1L << (WEAK - 69)) | (1L << (UNSAFE_UNRETAINED - 69)) | (1L << (IB_OUTLET - 69)) | (1L << (IB_OUTLET_COLLECTION - 69)) | (1L << (IB_INSPECTABLE - 69)) | (1L << (IB_DESIGNABLE - 69)) | (1L << (IDENTIFIER - 69)) | (1L << (LP - 69)) | (1L << (LBRACK - 69)))) != 0) || ((((_la - 136)) & ~0x3f) == 0 && ((1L << (_la - 136)) & ((1L << (AT - 136)) | (1L << (BANG - 136)) | (1L << (TILDE - 136)) | (1L << (INC - 136)) | (1L << (DEC - 136)) | (1L << (ADD - 136)) | (1L << (SUB - 136)) | (1L << (MUL - 136)) | (1L << (BITAND - 136)) | (1L << (BITXOR - 136)) | (1L << (CHARACTER_LITERAL - 136)) | (1L << (STRING_START - 136)) | (1L << (HEX_LITERAL - 136)) | (1L << (OCTAL_LITERAL - 136)) | (1L << (BINARY_LITERAL - 136)) | (1L << (DECIMAL_LITERAL - 136)) | (1L << (FLOATING_POINT_LITERAL - 136)))) != 0)) {
					{
					setState(1620);
					argumentExpressionList();
					}
				}

				setState(1623);
				match(RP);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1624);
				match(LP);
				setState(1627); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(1627);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,211,_ctx) ) {
					case 1:
						{
						setState(1625);
						match(COMMA);
						}
						break;
					case 2:
						{
						setState(1626);
						((PostfixContext)_localctx)._tset3106 = _input.LT(1);
						_la = _input.LA(1);
						if ( _la <= 0 || (_la==RP) ) {
							((PostfixContext)_localctx)._tset3106 = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						((PostfixContext)_localctx).macroArguments.add(((PostfixContext)_localctx)._tset3106);
						}
						break;
					}
					}
					setState(1629); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AUTO) | (1L << BREAK) | (1L << CASE) | (1L << CHAR) | (1L << CONST) | (1L << CONTINUE) | (1L << DEFAULT) | (1L << DO) | (1L << DOUBLE) | (1L << ELSE) | (1L << ENUM) | (1L << EXTERN) | (1L << FLOAT) | (1L << FOR) | (1L << GOTO) | (1L << IF) | (1L << INLINE) | (1L << INT) | (1L << LONG) | (1L << REGISTER) | (1L << RESTRICT) | (1L << RETURN) | (1L << SHORT) | (1L << SIGNED) | (1L << SIZEOF) | (1L << STATIC) | (1L << STRUCT) | (1L << SWITCH) | (1L << TYPEDEF) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID) | (1L << VOLATILE) | (1L << WHILE) | (1L << BOOL_) | (1L << COMPLEX) | (1L << IMAGINERY) | (1L << TRUE) | (1L << FALSE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << NIL) | (1L << NO) | (1L << NULL) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << YES) | (1L << AUTORELEASEPOOL) | (1L << CATCH) | (1L << CLASS) | (1L << DYNAMIC) | (1L << ENCODE) | (1L << END))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (FINALLY - 64)) | (1L << (IMPLEMENTATION - 64)) | (1L << (INTERFACE - 64)) | (1L << (IMPORT - 64)) | (1L << (PACKAGE - 64)) | (1L << (PROTOCOL - 64)) | (1L << (OPTIONAL - 64)) | (1L << (PRIVATE - 64)) | (1L << (PROPERTY - 64)) | (1L << (PROTECTED - 64)) | (1L << (PUBLIC - 64)) | (1L << (REQUIRED - 64)) | (1L << (SELECTOR - 64)) | (1L << (SYNCHRONIZED - 64)) | (1L << (SYNTHESIZE - 64)) | (1L << (THROW - 64)) | (1L << (TRY - 64)) | (1L << (ATOMIC - 64)) | (1L << (NONATOMIC - 64)) | (1L << (RETAIN - 64)) | (1L << (ATTRIBUTE - 64)) | (1L << (AUTORELEASING_QUALIFIER - 64)) | (1L << (BLOCK - 64)) | (1L << (BRIDGE - 64)) | (1L << (BRIDGE_RETAINED - 64)) | (1L << (BRIDGE_TRANSFER - 64)) | (1L << (COVARIANT - 64)) | (1L << (CONTRAVARIANT - 64)) | (1L << (DEPRECATED - 64)) | (1L << (KINDOF - 64)) | (1L << (STRONG_QUALIFIER - 64)) | (1L << (TYPEOF - 64)) | (1L << (UNSAFE_UNRETAINED_QUALIFIER - 64)) | (1L << (UNUSED - 64)) | (1L << (WEAK_QUALIFIER - 64)) | (1L << (NULL_UNSPECIFIED - 64)) | (1L << (NULLABLE - 64)) | (1L << (NONNULL - 64)) | (1L << (NULL_RESETTABLE - 64)) | (1L << (NS_INLINE - 64)) | (1L << (NS_ENUM - 64)) | (1L << (NS_OPTIONS - 64)) | (1L << (ASSIGN - 64)) | (1L << (COPY - 64)) | (1L << (GETTER - 64)) | (1L << (SETTER - 64)) | (1L << (STRONG - 64)) | (1L << (READONLY - 64)) | (1L << (READWRITE - 64)) | (1L << (WEAK - 64)) | (1L << (UNSAFE_UNRETAINED - 64)) | (1L << (IB_OUTLET - 64)) | (1L << (IB_OUTLET_COLLECTION - 64)) | (1L << (IB_INSPECTABLE - 64)) | (1L << (IB_DESIGNABLE - 64)) | (1L << (NS_ASSUME_NONNULL_BEGIN - 64)) | (1L << (NS_ASSUME_NONNULL_END - 64)) | (1L << (EXTERN_SUFFIX - 64)) | (1L << (IOS_SUFFIX - 64)) | (1L << (MAC_SUFFIX - 64)) | (1L << (TVOS_PROHIBITED - 64)) | (1L << (IDENTIFIER - 64)) | (1L << (LP - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (LBRACE - 128)) | (1L << (RBRACE - 128)) | (1L << (LBRACK - 128)) | (1L << (RBRACK - 128)) | (1L << (SEMI - 128)) | (1L << (COMMA - 128)) | (1L << (DOT - 128)) | (1L << (STRUCTACCESS - 128)) | (1L << (AT - 128)) | (1L << (ASSIGNMENT - 128)) | (1L << (GT - 128)) | (1L << (LT - 128)) | (1L << (BANG - 128)) | (1L << (TILDE - 128)) | (1L << (QUESTION - 128)) | (1L << (COLON - 128)) | (1L << (EQUAL - 128)) | (1L << (LE - 128)) | (1L << (GE - 128)) | (1L << (NOTEQUAL - 128)) | (1L << (AND - 128)) | (1L << (OR - 128)) | (1L << (INC - 128)) | (1L << (DEC - 128)) | (1L << (ADD - 128)) | (1L << (SUB - 128)) | (1L << (MUL - 128)) | (1L << (DIV - 128)) | (1L << (BITAND - 128)) | (1L << (BITOR - 128)) | (1L << (BITXOR - 128)) | (1L << (MOD - 128)) | (1L << (ADD_ASSIGN - 128)) | (1L << (SUB_ASSIGN - 128)) | (1L << (MUL_ASSIGN - 128)) | (1L << (DIV_ASSIGN - 128)) | (1L << (AND_ASSIGN - 128)) | (1L << (OR_ASSIGN - 128)) | (1L << (XOR_ASSIGN - 128)) | (1L << (MOD_ASSIGN - 128)) | (1L << (LSHIFT_ASSIGN - 128)) | (1L << (RSHIFT_ASSIGN - 128)) | (1L << (ELIPSIS - 128)) | (1L << (CHARACTER_LITERAL - 128)) | (1L << (STRING_START - 128)) | (1L << (HEX_LITERAL - 128)) | (1L << (OCTAL_LITERAL - 128)) | (1L << (BINARY_LITERAL - 128)) | (1L << (DECIMAL_LITERAL - 128)) | (1L << (FLOATING_POINT_LITERAL - 128)) | (1L << (WS - 128)) | (1L << (MULTI_COMMENT - 128)) | (1L << (SINGLE_COMMENT - 128)) | (1L << (BACKSLASH - 128)) | (1L << (SHARP - 128)) | (1L << (STRING_NEWLINE - 128)) | (1L << (STRING_END - 128)) | (1L << (STRING_VALUE - 128)) | (1L << (DIRECTIVE_IMPORT - 128)) | (1L << (DIRECTIVE_INCLUDE - 128)) | (1L << (DIRECTIVE_PRAGMA - 128)) | (1L << (DIRECTIVE_DEFINE - 128)) | (1L << (DIRECTIVE_DEFINED - 128)) | (1L << (DIRECTIVE_IF - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (DIRECTIVE_ELIF - 192)) | (1L << (DIRECTIVE_ELSE - 192)) | (1L << (DIRECTIVE_UNDEF - 192)) | (1L << (DIRECTIVE_IFDEF - 192)) | (1L << (DIRECTIVE_IFNDEF - 192)) | (1L << (DIRECTIVE_ENDIF - 192)) | (1L << (DIRECTIVE_TRUE - 192)) | (1L << (DIRECTIVE_FALSE - 192)) | (1L << (DIRECTIVE_ERROR - 192)) | (1L << (DIRECTIVE_WARNING - 192)) | (1L << (DIRECTIVE_BANG - 192)) | (1L << (DIRECTIVE_LP - 192)) | (1L << (DIRECTIVE_RP - 192)) | (1L << (DIRECTIVE_EQUAL - 192)) | (1L << (DIRECTIVE_NOTEQUAL - 192)) | (1L << (DIRECTIVE_AND - 192)) | (1L << (DIRECTIVE_OR - 192)) | (1L << (DIRECTIVE_LT - 192)) | (1L << (DIRECTIVE_GT - 192)) | (1L << (DIRECTIVE_LE - 192)) | (1L << (DIRECTIVE_GE - 192)) | (1L << (DIRECTIVE_STRING - 192)) | (1L << (DIRECTIVE_ID - 192)) | (1L << (DIRECTIVE_DECIMAL_LITERAL - 192)) | (1L << (DIRECTIVE_FLOAT - 192)) | (1L << (DIRECTIVE_NEWLINE - 192)) | (1L << (DIRECTIVE_MULTI_COMMENT - 192)) | (1L << (DIRECTIVE_SINGLE_COMMENT - 192)) | (1L << (DIRECTIVE_BACKSLASH_NEWLINE - 192)) | (1L << (DIRECTIVE_TEXT_NEWLINE - 192)) | (1L << (DIRECTIVE_TEXT - 192)))) != 0) );
				setState(1631);
				match(RP);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1632);
				((PostfixContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==INC || _la==DEC) ) {
					((PostfixContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentExpressionListContext extends ParserRuleContext {
		public List<ArgumentExpressionContext> argumentExpression() {
			return getRuleContexts(ArgumentExpressionContext.class);
		}
		public ArgumentExpressionContext argumentExpression(int i) {
			return getRuleContext(ArgumentExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ObjectiveCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ObjectiveCParser.COMMA, i);
		}
		public ArgumentExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentExpressionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterArgumentExpressionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitArgumentExpressionList(this);
		}
	}

	public final ArgumentExpressionListContext argumentExpressionList() throws RecognitionException {
		ArgumentExpressionListContext _localctx = new ArgumentExpressionListContext(_ctx, getState());
		enterRule(_localctx, 276, RULE_argumentExpressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1635);
			argumentExpression();
			setState(1640);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1636);
				match(COMMA);
				setState(1637);
				argumentExpression();
				}
				}
				setState(1642);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentExpressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TypeSpecifierContext typeSpecifier() {
			return getRuleContext(TypeSpecifierContext.class,0);
		}
		public ArgumentExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterArgumentExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitArgumentExpression(this);
		}
	}

	public final ArgumentExpressionContext argumentExpression() throws RecognitionException {
		ArgumentExpressionContext _localctx = new ArgumentExpressionContext(_ctx, getState());
		enterRule(_localctx, 278, RULE_argumentExpression);
		try {
			setState(1645);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,215,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1643);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1644);
				typeSpecifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryExpressionContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public MessageExpressionContext messageExpression() {
			return getRuleContext(MessageExpressionContext.class,0);
		}
		public SelectorExpressionContext selectorExpression() {
			return getRuleContext(SelectorExpressionContext.class,0);
		}
		public ProtocolExpressionContext protocolExpression() {
			return getRuleContext(ProtocolExpressionContext.class,0);
		}
		public EncodeExpressionContext encodeExpression() {
			return getRuleContext(EncodeExpressionContext.class,0);
		}
		public DictionaryExpressionContext dictionaryExpression() {
			return getRuleContext(DictionaryExpressionContext.class,0);
		}
		public ArrayExpressionContext arrayExpression() {
			return getRuleContext(ArrayExpressionContext.class,0);
		}
		public BoxExpressionContext boxExpression() {
			return getRuleContext(BoxExpressionContext.class,0);
		}
		public BlockExpressionContext blockExpression() {
			return getRuleContext(BlockExpressionContext.class,0);
		}
		public PrimaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterPrimaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitPrimaryExpression(this);
		}
	}

	public final PrimaryExpressionContext primaryExpression() throws RecognitionException {
		PrimaryExpressionContext _localctx = new PrimaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 280, RULE_primaryExpression);
		try {
			setState(1662);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,216,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1647);
				identifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1648);
				constant();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1649);
				stringLiteral();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1650);
				match(LP);
				setState(1651);
				expression(0);
				setState(1652);
				match(RP);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1654);
				messageExpression();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1655);
				selectorExpression();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1656);
				protocolExpression();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1657);
				encodeExpression();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1658);
				dictionaryExpression();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1659);
				arrayExpression();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(1660);
				boxExpression();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(1661);
				blockExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantContext extends ParserRuleContext {
		public TerminalNode HEX_LITERAL() { return getToken(ObjectiveCParser.HEX_LITERAL, 0); }
		public TerminalNode OCTAL_LITERAL() { return getToken(ObjectiveCParser.OCTAL_LITERAL, 0); }
		public TerminalNode BINARY_LITERAL() { return getToken(ObjectiveCParser.BINARY_LITERAL, 0); }
		public TerminalNode DECIMAL_LITERAL() { return getToken(ObjectiveCParser.DECIMAL_LITERAL, 0); }
		public TerminalNode ADD() { return getToken(ObjectiveCParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(ObjectiveCParser.SUB, 0); }
		public TerminalNode FLOATING_POINT_LITERAL() { return getToken(ObjectiveCParser.FLOATING_POINT_LITERAL, 0); }
		public TerminalNode CHARACTER_LITERAL() { return getToken(ObjectiveCParser.CHARACTER_LITERAL, 0); }
		public TerminalNode NIL() { return getToken(ObjectiveCParser.NIL, 0); }
		public TerminalNode NULL() { return getToken(ObjectiveCParser.NULL, 0); }
		public TerminalNode YES() { return getToken(ObjectiveCParser.YES, 0); }
		public TerminalNode NO() { return getToken(ObjectiveCParser.NO, 0); }
		public TerminalNode TRUE() { return getToken(ObjectiveCParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(ObjectiveCParser.FALSE, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitConstant(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 282, RULE_constant);
		int _la;
		try {
			setState(1682);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,219,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1664);
				match(HEX_LITERAL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1665);
				match(OCTAL_LITERAL);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1666);
				match(BINARY_LITERAL);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1668);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ADD || _la==SUB) {
					{
					setState(1667);
					_la = _input.LA(1);
					if ( !(_la==ADD || _la==SUB) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(1670);
				match(DECIMAL_LITERAL);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1672);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ADD || _la==SUB) {
					{
					setState(1671);
					_la = _input.LA(1);
					if ( !(_la==ADD || _la==SUB) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(1674);
				match(FLOATING_POINT_LITERAL);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1675);
				match(CHARACTER_LITERAL);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1676);
				match(NIL);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1677);
				match(NULL);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1678);
				match(YES);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1679);
				match(NO);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(1680);
				match(TRUE);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(1681);
				match(FALSE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringLiteralContext extends ParserRuleContext {
		public List<TerminalNode> STRING_START() { return getTokens(ObjectiveCParser.STRING_START); }
		public TerminalNode STRING_START(int i) {
			return getToken(ObjectiveCParser.STRING_START, i);
		}
		public List<TerminalNode> STRING_END() { return getTokens(ObjectiveCParser.STRING_END); }
		public TerminalNode STRING_END(int i) {
			return getToken(ObjectiveCParser.STRING_END, i);
		}
		public List<TerminalNode> STRING_VALUE() { return getTokens(ObjectiveCParser.STRING_VALUE); }
		public TerminalNode STRING_VALUE(int i) {
			return getToken(ObjectiveCParser.STRING_VALUE, i);
		}
		public List<TerminalNode> STRING_NEWLINE() { return getTokens(ObjectiveCParser.STRING_NEWLINE); }
		public TerminalNode STRING_NEWLINE(int i) {
			return getToken(ObjectiveCParser.STRING_NEWLINE, i);
		}
		public StringLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitStringLiteral(this);
		}
	}

	public final StringLiteralContext stringLiteral() throws RecognitionException {
		StringLiteralContext _localctx = new StringLiteralContext(_ctx, getState());
		enterRule(_localctx, 284, RULE_stringLiteral);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1692); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1684);
					match(STRING_START);
					setState(1688);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==STRING_NEWLINE || _la==STRING_VALUE) {
						{
						{
						setState(1685);
						_la = _input.LA(1);
						if ( !(_la==STRING_NEWLINE || _la==STRING_VALUE) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						}
						setState(1690);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1691);
					match(STRING_END);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1694); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,221,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ObjectiveCParser.IDENTIFIER, 0); }
		public TerminalNode BOOL() { return getToken(ObjectiveCParser.BOOL, 0); }
		public TerminalNode Class() { return getToken(ObjectiveCParser.Class, 0); }
		public TerminalNode BYCOPY() { return getToken(ObjectiveCParser.BYCOPY, 0); }
		public TerminalNode BYREF() { return getToken(ObjectiveCParser.BYREF, 0); }
		public TerminalNode ID() { return getToken(ObjectiveCParser.ID, 0); }
		public TerminalNode IMP() { return getToken(ObjectiveCParser.IMP, 0); }
		public TerminalNode IN() { return getToken(ObjectiveCParser.IN, 0); }
		public TerminalNode INOUT() { return getToken(ObjectiveCParser.INOUT, 0); }
		public TerminalNode ONEWAY() { return getToken(ObjectiveCParser.ONEWAY, 0); }
		public TerminalNode OUT() { return getToken(ObjectiveCParser.OUT, 0); }
		public TerminalNode PROTOCOL_() { return getToken(ObjectiveCParser.PROTOCOL_, 0); }
		public TerminalNode SEL() { return getToken(ObjectiveCParser.SEL, 0); }
		public TerminalNode SELF() { return getToken(ObjectiveCParser.SELF, 0); }
		public TerminalNode SUPER() { return getToken(ObjectiveCParser.SUPER, 0); }
		public TerminalNode ATOMIC() { return getToken(ObjectiveCParser.ATOMIC, 0); }
		public TerminalNode NONATOMIC() { return getToken(ObjectiveCParser.NONATOMIC, 0); }
		public TerminalNode RETAIN() { return getToken(ObjectiveCParser.RETAIN, 0); }
		public TerminalNode AUTORELEASING_QUALIFIER() { return getToken(ObjectiveCParser.AUTORELEASING_QUALIFIER, 0); }
		public TerminalNode BLOCK() { return getToken(ObjectiveCParser.BLOCK, 0); }
		public TerminalNode BRIDGE_RETAINED() { return getToken(ObjectiveCParser.BRIDGE_RETAINED, 0); }
		public TerminalNode BRIDGE_TRANSFER() { return getToken(ObjectiveCParser.BRIDGE_TRANSFER, 0); }
		public TerminalNode COVARIANT() { return getToken(ObjectiveCParser.COVARIANT, 0); }
		public TerminalNode CONTRAVARIANT() { return getToken(ObjectiveCParser.CONTRAVARIANT, 0); }
		public TerminalNode DEPRECATED() { return getToken(ObjectiveCParser.DEPRECATED, 0); }
		public TerminalNode KINDOF() { return getToken(ObjectiveCParser.KINDOF, 0); }
		public TerminalNode UNUSED() { return getToken(ObjectiveCParser.UNUSED, 0); }
		public TerminalNode NS_INLINE() { return getToken(ObjectiveCParser.NS_INLINE, 0); }
		public TerminalNode NS_ENUM() { return getToken(ObjectiveCParser.NS_ENUM, 0); }
		public TerminalNode NS_OPTIONS() { return getToken(ObjectiveCParser.NS_OPTIONS, 0); }
		public TerminalNode NULL_UNSPECIFIED() { return getToken(ObjectiveCParser.NULL_UNSPECIFIED, 0); }
		public TerminalNode NULLABLE() { return getToken(ObjectiveCParser.NULLABLE, 0); }
		public TerminalNode NONNULL() { return getToken(ObjectiveCParser.NONNULL, 0); }
		public TerminalNode NULL_RESETTABLE() { return getToken(ObjectiveCParser.NULL_RESETTABLE, 0); }
		public TerminalNode ASSIGN() { return getToken(ObjectiveCParser.ASSIGN, 0); }
		public TerminalNode COPY() { return getToken(ObjectiveCParser.COPY, 0); }
		public TerminalNode GETTER() { return getToken(ObjectiveCParser.GETTER, 0); }
		public TerminalNode SETTER() { return getToken(ObjectiveCParser.SETTER, 0); }
		public TerminalNode STRONG() { return getToken(ObjectiveCParser.STRONG, 0); }
		public TerminalNode READONLY() { return getToken(ObjectiveCParser.READONLY, 0); }
		public TerminalNode READWRITE() { return getToken(ObjectiveCParser.READWRITE, 0); }
		public TerminalNode WEAK() { return getToken(ObjectiveCParser.WEAK, 0); }
		public TerminalNode UNSAFE_UNRETAINED() { return getToken(ObjectiveCParser.UNSAFE_UNRETAINED, 0); }
		public TerminalNode IB_OUTLET() { return getToken(ObjectiveCParser.IB_OUTLET, 0); }
		public TerminalNode IB_OUTLET_COLLECTION() { return getToken(ObjectiveCParser.IB_OUTLET_COLLECTION, 0); }
		public TerminalNode IB_INSPECTABLE() { return getToken(ObjectiveCParser.IB_INSPECTABLE, 0); }
		public TerminalNode IB_DESIGNABLE() { return getToken(ObjectiveCParser.IB_DESIGNABLE, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitIdentifier(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 286, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1696);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 129:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 136:
			return postfixExpression_sempred((PostfixExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 13);
		case 1:
			return precpred(_ctx, 12);
		case 2:
			return precpred(_ctx, 11);
		case 3:
			return precpred(_ctx, 10);
		case 4:
			return precpred(_ctx, 9);
		case 5:
			return precpred(_ctx, 8);
		case 6:
			return precpred(_ctx, 7);
		case 7:
			return precpred(_ctx, 6);
		case 8:
			return precpred(_ctx, 5);
		case 9:
			return precpred(_ctx, 4);
		case 10:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean postfixExpression_sempred(PostfixExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 11:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\u00e0\u06a5\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\4"+
		"`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\4j\tj\4k\t"+
		"k\4l\tl\4m\tm\4n\tn\4o\to\4p\tp\4q\tq\4r\tr\4s\ts\4t\tt\4u\tu\4v\tv\4"+
		"w\tw\4x\tx\4y\ty\4z\tz\4{\t{\4|\t|\4}\t}\4~\t~\4\177\t\177\4\u0080\t\u0080"+
		"\4\u0081\t\u0081\4\u0082\t\u0082\4\u0083\t\u0083\4\u0084\t\u0084\4\u0085"+
		"\t\u0085\4\u0086\t\u0086\4\u0087\t\u0087\4\u0088\t\u0088\4\u0089\t\u0089"+
		"\4\u008a\t\u008a\4\u008b\t\u008b\4\u008c\t\u008c\4\u008d\t\u008d\4\u008e"+
		"\t\u008e\4\u008f\t\u008f\4\u0090\t\u0090\4\u0091\t\u0091\3\2\7\2\u0124"+
		"\n\2\f\2\16\2\u0127\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\5\3\u0136\n\3\3\4\3\4\3\4\3\4\3\5\5\5\u013d\n\5\3\5\3\5\3\5\3\5"+
		"\5\5\u0143\n\5\3\5\3\5\3\5\3\5\5\5\u0149\n\5\3\5\5\5\u014c\n\5\3\5\5\5"+
		"\u014f\n\5\3\5\3\5\3\6\3\6\3\6\3\6\5\6\u0157\n\6\3\6\3\6\3\6\3\6\3\6\5"+
		"\6\u015e\n\6\3\6\5\6\u0161\n\6\3\6\5\6\u0164\n\6\3\6\3\6\3\7\3\7\3\7\3"+
		"\7\5\7\u016c\n\7\3\7\5\7\u016f\n\7\3\7\5\7\u0172\n\7\3\7\3\7\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\5\b\u017c\n\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u0186"+
		"\n\t\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u018e\n\n\3\n\7\n\u0191\n\n\f\n\16\n"+
		"\u0194\13\n\3\n\3\n\3\13\3\13\7\13\u019a\n\13\f\13\16\13\u019d\13\13\3"+
		"\13\6\13\u01a0\n\13\r\13\16\13\u01a1\5\13\u01a4\n\13\3\f\3\f\3\f\3\f\3"+
		"\r\3\r\3\r\3\r\7\r\u01ae\n\r\f\r\16\r\u01b1\13\r\3\r\3\r\3\16\3\16\3\16"+
		"\7\16\u01b8\n\16\f\16\16\16\u01bb\13\16\3\17\3\17\3\17\3\17\3\17\5\17"+
		"\u01c2\n\17\3\17\5\17\u01c5\n\17\3\17\5\17\u01c8\n\17\3\17\3\17\3\20\3"+
		"\20\3\20\7\20\u01cf\n\20\f\20\16\20\u01d2\13\20\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\5\21\u01e8\n\21\3\22\3\22\3\22\3\22\3\22\5\22\u01ef\n\22\3\22"+
		"\5\22\u01f2\n\22\3\23\3\23\7\23\u01f6\n\23\f\23\16\23\u01f9\13\23\3\23"+
		"\3\23\3\24\3\24\7\24\u01ff\n\24\f\24\16\24\u0202\13\24\3\24\6\24\u0205"+
		"\n\24\r\24\16\24\u0206\5\24\u0209\n\24\3\25\3\25\3\26\3\26\3\26\3\26\3"+
		"\26\6\26\u0212\n\26\r\26\16\26\u0213\3\27\3\27\3\27\3\30\3\30\3\30\3\31"+
		"\5\31\u021d\n\31\3\31\3\31\5\31\u0221\n\31\3\31\3\31\3\32\3\32\3\32\3"+
		"\32\3\32\6\32\u022a\n\32\r\32\16\32\u022b\3\33\3\33\3\33\3\34\3\34\3\34"+
		"\3\35\5\35\u0235\n\35\3\35\3\35\5\35\u0239\n\35\3\35\5\35\u023c\n\35\3"+
		"\35\3\35\3\36\3\36\6\36\u0242\n\36\r\36\16\36\u0243\3\36\3\36\5\36\u0248"+
		"\n\36\5\36\u024a\n\36\3\37\5\37\u024d\n\37\3\37\3\37\7\37\u0251\n\37\f"+
		"\37\16\37\u0254\13\37\3\37\5\37\u0257\n\37\3\37\3\37\3 \3 \5 \u025d\n"+
		" \3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u026b\n\"\3#\3#\3#\7"+
		"#\u0270\n#\f#\16#\u0273\13#\3$\3$\3$\5$\u0278\n$\3%\5%\u027b\n%\3%\3%"+
		"\5%\u027f\n%\3%\3%\3%\3%\5%\u0285\n%\3%\3%\5%\u0289\n%\3&\3&\3&\3&\7&"+
		"\u028f\n&\f&\16&\u0292\13&\5&\u0294\n&\3&\3&\3\'\7\'\u0299\n\'\f\'\16"+
		"\'\u029c\13\'\3\'\3\'\3(\3(\3(\3(\3(\7(\u02a5\n(\f(\16(\u02a8\13(\3(\5"+
		"(\u02ab\n(\5(\u02ad\n(\3(\3(\3)\3)\3)\3)\3*\3*\3*\3*\5*\u02b9\n*\5*\u02bb"+
		"\n*\3*\3*\3+\3+\3+\3+\3+\3+\3+\3+\5+\u02c7\n+\5+\u02c9\n+\3,\3,\3,\5,"+
		"\u02ce\n,\3,\3,\7,\u02d2\n,\f,\16,\u02d5\13,\5,\u02d7\n,\3,\3,\3-\3-\5"+
		"-\u02dd\n-\3.\3.\5.\u02e1\n.\3.\5.\u02e4\n.\3.\5.\u02e7\n.\3.\3.\3/\3"+
		"/\3/\3/\3/\3\60\3\60\5\60\u02f2\n\60\3\61\3\61\6\61\u02f6\n\61\r\61\16"+
		"\61\u02f7\5\61\u02fa\n\61\3\62\5\62\u02fd\n\62\3\62\3\62\3\62\3\62\7\62"+
		"\u0303\n\62\f\62\16\62\u0306\13\62\3\63\3\63\5\63\u030a\n\63\3\63\3\63"+
		"\3\63\3\63\5\63\u0310\n\63\3\64\3\64\3\64\3\64\3\64\3\65\3\65\5\65\u0319"+
		"\n\65\3\65\6\65\u031c\n\65\r\65\16\65\u031d\5\65\u0320\n\65\3\66\3\66"+
		"\3\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67\38\38\38\39\39\39\39\39\39\3"+
		"9\59\u0336\n9\3:\3:\3:\7:\u033b\n:\f:\16:\u033e\13:\3:\3:\5:\u0342\n:"+
		"\3;\3;\3;\3;\3;\3;\3<\3<\3<\3<\3<\3<\3=\3=\3=\3>\3>\3>\3?\3?\3?\3@\5@"+
		"\u035a\n@\3@\3@\3@\5@\u035f\n@\3@\3@\3@\5@\u0364\n@\3A\3A\5A\u0368\nA"+
		"\3B\3B\5B\u036c\nB\3C\3C\5C\u0370\nC\3C\3C\3D\3D\3D\7D\u0377\nD\fD\16"+
		"D\u037a\13D\3E\3E\3E\3E\5E\u0380\nE\3F\3F\3F\3F\3F\5F\u0387\nF\3G\3G\3"+
		"G\3G\5G\u038d\nG\3H\5H\u0390\nH\3H\3H\5H\u0394\nH\3H\3H\3H\3H\3H\3I\5"+
		"I\u039c\nI\3I\5I\u039f\nI\3I\3I\5I\u03a3\nI\3I\3I\3J\3J\3J\3J\5J\u03ab"+
		"\nJ\3J\3J\3K\5K\u03b0\nK\3K\3K\3K\3K\3K\5K\u03b7\nK\3K\3K\3L\3L\3L\7L"+
		"\u03be\nL\fL\16L\u03c1\13L\3M\5M\u03c4\nM\3M\3M\3N\3N\3N\3N\3N\3N\3N\3"+
		"N\6N\u03d0\nN\rN\16N\u03d1\3O\3O\3O\3O\3O\3O\7O\u03da\nO\fO\16O\u03dd"+
		"\13O\3O\3O\3O\3P\3P\3P\7P\u03e5\nP\fP\16P\u03e8\13P\3Q\3Q\3Q\5Q\u03ed"+
		"\nQ\3R\3R\3R\5R\u03f2\nR\3R\3R\6R\u03f6\nR\rR\16R\u03f7\3R\3R\5R\u03fc"+
		"\nR\3S\3S\3S\5S\u0401\nS\3S\3S\3T\3T\3T\3T\3T\3T\6T\u040b\nT\rT\16T\u040c"+
		"\3U\3U\3U\3U\3U\3U\5U\u0415\nU\3V\3V\3W\3W\3X\3X\3Y\3Y\3Z\3Z\3Z\3Z\5Z"+
		"\u0423\nZ\3[\3[\3\\\3\\\3\\\3\\\3\\\3\\\3\\\3\\\3\\\3\\\3\\\3\\\3\\\3"+
		"\\\3\\\5\\\u0436\n\\\5\\\u0438\n\\\3]\3]\3]\3]\3]\3^\3^\3^\7^\u0442\n"+
		"^\f^\16^\u0445\13^\3_\3_\5_\u0449\n_\3_\3_\5_\u044d\n_\3`\3`\5`\u0451"+
		"\n`\3`\3`\5`\u0455\n`\3`\3`\3`\3`\3`\5`\u045c\n`\3`\3`\3`\3`\5`\u0462"+
		"\n`\3`\3`\3`\3`\3`\3`\3`\3`\3`\3`\5`\u046e\n`\3a\3a\3a\7a\u0473\na\fa"+
		"\16a\u0476\13a\3a\5a\u0479\na\3b\3b\3b\5b\u047e\nb\3c\3c\5c\u0482\nc\3"+
		"d\3d\3d\3d\3d\5d\u0489\nd\3d\7d\u048c\nd\fd\16d\u048f\13d\3d\3d\3d\5d"+
		"\u0494\nd\3d\5d\u0497\nd\3d\3d\5d\u049b\nd\3e\3e\5e\u049f\ne\3e\3e\3f"+
		"\3f\3f\5f\u04a6\nf\3g\3g\5g\u04aa\ng\3g\5g\u04ad\ng\3h\3h\3h\3h\3h\7h"+
		"\u04b4\nh\fh\16h\u04b7\13h\3h\3h\5h\u04bb\nh\3i\3i\3i\5i\u04c0\ni\5i\u04c2"+
		"\ni\3i\3i\3j\3j\3j\3j\3j\3j\7j\u04cc\nj\fj\16j\u04cf\13j\3j\5j\u04d2\n"+
		"j\5j\u04d4\nj\3j\3j\3k\3k\3k\7k\u04db\nk\fk\16k\u04de\13k\3k\5k\u04e1"+
		"\nk\3l\3l\5l\u04e5\nl\3l\5l\u04e8\nl\3m\3m\5m\u04ec\nm\3m\3m\5m\u04f0"+
		"\nm\3m\3m\6m\u04f4\nm\rm\16m\u04f5\3m\3m\5m\u04fa\nm\3m\6m\u04fd\nm\r"+
		"m\16m\u04fe\5m\u0501\nm\3n\3n\5n\u0505\nn\3n\3n\3n\5n\u050a\nn\3n\5n\u050d"+
		"\nn\3o\3o\3o\7o\u0512\no\fo\16o\u0515\13o\3p\3p\3p\3p\5p\u051b\np\3q\5"+
		"q\u051e\nq\3q\3q\3r\3r\5r\u0524\nr\3r\3r\5r\u0528\nr\3r\3r\5r\u052c\n"+
		"r\3r\3r\5r\u0530\nr\3r\3r\5r\u0534\nr\3r\3r\5r\u0538\nr\3r\3r\5r\u053c"+
		"\nr\3r\3r\5r\u0540\nr\3r\3r\5r\u0544\nr\3r\3r\5r\u0548\nr\3r\5r\u054b"+
		"\nr\3s\3s\3s\3s\3t\3t\3t\5t\u0554\nt\3u\3u\3u\7u\u0559\nu\fu\16u\u055c"+
		"\13u\3u\3u\3v\3v\3v\3v\3v\3v\3v\5v\u0567\nv\3v\5v\u056a\nv\3w\3w\3w\3"+
		"w\3w\3w\3x\3x\7x\u0574\nx\fx\16x\u0577\13x\3x\3x\3y\6y\u057c\ny\ry\16"+
		"y\u057d\3y\6y\u0581\ny\ry\16y\u0582\3z\3z\3z\3z\3z\3z\5z\u058b\nz\3z\3"+
		"z\3z\3z\5z\u0591\nz\3{\3{\3{\3{\5{\u0597\n{\3|\3|\3|\3|\3|\3|\3}\3}\3"+
		"}\3}\3}\3}\3}\3}\3~\3~\3~\5~\u05aa\n~\3~\3~\5~\u05ae\n~\3~\3~\5~\u05b2"+
		"\n~\3~\3~\3~\3\177\3\177\3\177\3\177\5\177\u05bb\n\177\3\u0080\3\u0080"+
		"\3\u0080\3\u0080\3\u0080\5\u0080\u05c2\n\u0080\3\u0080\3\u0080\3\u0080"+
		"\3\u0081\3\u0081\3\u0081\3\u0081\3\u0081\3\u0081\5\u0081\u05cd\n\u0081"+
		"\5\u0081\u05cf\n\u0081\3\u0082\3\u0082\3\u0082\7\u0082\u05d4\n\u0082\f"+
		"\u0082\16\u0082\u05d7\13\u0082\3\u0083\3\u0083\3\u0083\3\u0083\3\u0083"+
		"\3\u0083\3\u0083\3\u0083\3\u0083\3\u0083\5\u0083\u05e3\n\u0083\3\u0083"+
		"\3\u0083\3\u0083\3\u0083\3\u0083\3\u0083\3\u0083\3\u0083\3\u0083\3\u0083"+
		"\3\u0083\5\u0083\u05f0\n\u0083\3\u0083\3\u0083\3\u0083\3\u0083\3\u0083"+
		"\3\u0083\3\u0083\3\u0083\3\u0083\3\u0083\3\u0083\3\u0083\3\u0083\3\u0083"+
		"\3\u0083\3\u0083\3\u0083\3\u0083\3\u0083\3\u0083\3\u0083\3\u0083\3\u0083"+
		"\3\u0083\3\u0083\5\u0083\u060b\n\u0083\3\u0083\3\u0083\7\u0083\u060f\n"+
		"\u0083\f\u0083\16\u0083\u0612\13\u0083\3\u0084\3\u0084\3\u0085\3\u0085"+
		"\3\u0085\3\u0085\3\u0085\3\u0085\3\u0085\5\u0085\u061d\n\u0085\5\u0085"+
		"\u061f\n\u0085\3\u0086\3\u0086\3\u0086\5\u0086\u0624\n\u0086\3\u0087\3"+
		"\u0087\5\u0087\u0628\n\u0087\3\u0088\3\u0088\3\u0088\3\u0088\3\u0088\3"+
		"\u0088\3\u0088\5\u0088\u0631\n\u0088\3\u0088\3\u0088\3\u0088\3\u0088\3"+
		"\u0088\5\u0088\u0638\n\u0088\3\u0089\3\u0089\3\u008a\3\u008a\3\u008a\7"+
		"\u008a\u063f\n\u008a\f\u008a\16\u008a\u0642\13\u008a\3\u008a\3\u008a\3"+
		"\u008a\3\u008a\7\u008a\u0648\n\u008a\f\u008a\16\u008a\u064b\13\u008a\7"+
		"\u008a\u064d\n\u008a\f\u008a\16\u008a\u0650\13\u008a\3\u008b\3\u008b\3"+
		"\u008b\3\u008b\3\u008b\3\u008b\5\u008b\u0658\n\u008b\3\u008b\3\u008b\3"+
		"\u008b\3\u008b\6\u008b\u065e\n\u008b\r\u008b\16\u008b\u065f\3\u008b\3"+
		"\u008b\5\u008b\u0664\n\u008b\3\u008c\3\u008c\3\u008c\7\u008c\u0669\n\u008c"+
		"\f\u008c\16\u008c\u066c\13\u008c\3\u008d\3\u008d\5\u008d\u0670\n\u008d"+
		"\3\u008e\3\u008e\3\u008e\3\u008e\3\u008e\3\u008e\3\u008e\3\u008e\3\u008e"+
		"\3\u008e\3\u008e\3\u008e\3\u008e\3\u008e\3\u008e\5\u008e\u0681\n\u008e"+
		"\3\u008f\3\u008f\3\u008f\3\u008f\5\u008f\u0687\n\u008f\3\u008f\3\u008f"+
		"\5\u008f\u068b\n\u008f\3\u008f\3\u008f\3\u008f\3\u008f\3\u008f\3\u008f"+
		"\3\u008f\3\u008f\5\u008f\u0695\n\u008f\3\u0090\3\u0090\7\u0090\u0699\n"+
		"\u0090\f\u0090\16\u0090\u069c\13\u0090\3\u0090\6\u0090\u069f\n\u0090\r"+
		"\u0090\16\u0090\u06a0\3\u0091\3\u0091\3\u0091\2\4\u0104\u0112\u0092\2"+
		"\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJL"+
		"NPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e"+
		"\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e\u00a0\u00a2\u00a4\u00a6"+
		"\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2\u00b4\u00b6\u00b8\u00ba\u00bc\u00be"+
		"\u00c0\u00c2\u00c4\u00c6\u00c8\u00ca\u00cc\u00ce\u00d0\u00d2\u00d4\u00d6"+
		"\u00d8\u00da\u00dc\u00de\u00e0\u00e2\u00e4\u00e6\u00e8\u00ea\u00ec\u00ee"+
		"\u00f0\u00f2\u00f4\u00f6\u00f8\u00fa\u00fc\u00fe\u0100\u0102\u0104\u0106"+
		"\u0108\u010a\u010c\u010e\u0110\u0112\u0114\u0116\u0118\u011a\u011c\u011e"+
		"\u0120\2\27\4\2HHMM\3\2\\]\5\2FFIIKL\4\2\35\35  \6\2WW``bbdd\3\2eh\6\2"+
		"\3\3\16\16\26\26\34\34\6\2\23\23X[__ii\5\2,-\60\61\65\66\3\2jk\4\2\u009c"+
		"\u009d\u00a1\u00a1\3\2\u009a\u009b\4\2\u008c\u008d\u0093\u0094\4\2\u0092"+
		"\u0092\u0095\u0095\4\2\u008b\u008b\u00a2\u00ab\3\2\u0098\u0099\5\2\u008e"+
		"\u008f\u009a\u009c\u009e\u009e\3\2\u0088\u0089\3\2\u0081\u0081\4\2\u00b9"+
		"\u00b9\u00bb\u00bb\n\2*\61\65:SUWXZ_ccex\177\177\2\u075d\2\u0125\3\2\2"+
		"\2\4\u0135\3\2\2\2\6\u0137\3\2\2\2\b\u013c\3\2\2\2\n\u0152\3\2\2\2\f\u0167"+
		"\3\2\2\2\16\u0175\3\2\2\2\20\u017f\3\2\2\2\22\u0187\3\2\2\2\24\u01a3\3"+
		"\2\2\2\26\u01a5\3\2\2\2\30\u01a9\3\2\2\2\32\u01b4\3\2\2\2\34\u01bc\3\2"+
		"\2\2\36\u01cb\3\2\2\2 \u01e7\3\2\2\2\"\u01f1\3\2\2\2$\u01f3\3\2\2\2&\u0208"+
		"\3\2\2\2(\u020a\3\2\2\2*\u0211\3\2\2\2,\u0215\3\2\2\2.\u0218\3\2\2\2\60"+
		"\u021c\3\2\2\2\62\u0229\3\2\2\2\64\u022d\3\2\2\2\66\u0230\3\2\2\28\u0234"+
		"\3\2\2\2:\u0249\3\2\2\2<\u024c\3\2\2\2>\u025c\3\2\2\2@\u025e\3\2\2\2B"+
		"\u026a\3\2\2\2D\u026c\3\2\2\2F\u0274\3\2\2\2H\u027a\3\2\2\2J\u028a\3\2"+
		"\2\2L\u029a\3\2\2\2N\u029f\3\2\2\2P\u02b0\3\2\2\2R\u02b4\3\2\2\2T\u02c8"+
		"\3\2\2\2V\u02ca\3\2\2\2X\u02dc\3\2\2\2Z\u02de\3\2\2\2\\\u02ea\3\2\2\2"+
		"^\u02f1\3\2\2\2`\u02f9\3\2\2\2b\u02fc\3\2\2\2d\u0307\3\2\2\2f\u0311\3"+
		"\2\2\2h\u031f\3\2\2\2j\u0321\3\2\2\2l\u0326\3\2\2\2n\u032b\3\2\2\2p\u0335"+
		"\3\2\2\2r\u0337\3\2\2\2t\u0343\3\2\2\2v\u0349\3\2\2\2x\u034f\3\2\2\2z"+
		"\u0352\3\2\2\2|\u0355\3\2\2\2~\u0359\3\2\2\2\u0080\u0365\3\2\2\2\u0082"+
		"\u036b\3\2\2\2\u0084\u036d\3\2\2\2\u0086\u0373\3\2\2\2\u0088\u037f\3\2"+
		"\2\2\u008a\u0381\3\2\2\2\u008c\u038c\3\2\2\2\u008e\u038f\3\2\2\2\u0090"+
		"\u039b\3\2\2\2\u0092\u03aa\3\2\2\2\u0094\u03af\3\2\2\2\u0096\u03ba\3\2"+
		"\2\2\u0098\u03c3\3\2\2\2\u009a\u03cf\3\2\2\2\u009c\u03d3\3\2\2\2\u009e"+
		"\u03e1\3\2\2\2\u00a0\u03e9\3\2\2\2\u00a2\u03ee\3\2\2\2\u00a4\u03fd\3\2"+
		"\2\2\u00a6\u040a\3\2\2\2\u00a8\u0414\3\2\2\2\u00aa\u0416\3\2\2\2\u00ac"+
		"\u0418\3\2\2\2\u00ae\u041a\3\2\2\2\u00b0\u041c\3\2\2\2\u00b2\u0422\3\2"+
		"\2\2\u00b4\u0424\3\2\2\2\u00b6\u0437\3\2\2\2\u00b8\u0439\3\2\2\2\u00ba"+
		"\u043e\3\2\2\2\u00bc\u044c\3\2\2\2\u00be\u046d\3\2\2\2\u00c0\u046f\3\2"+
		"\2\2\u00c2\u047a\3\2\2\2\u00c4\u0481\3\2\2\2\u00c6\u049a\3\2\2\2\u00c8"+
		"\u049c\3\2\2\2\u00ca\u04a2\3\2\2\2\u00cc\u04a7\3\2\2\2\u00ce\u04ae\3\2"+
		"\2\2\u00d0\u04bc\3\2\2\2\u00d2\u04c5\3\2\2\2\u00d4\u04d7\3\2\2\2\u00d6"+
		"\u04e7\3\2\2\2\u00d8\u0500\3\2\2\2\u00da\u050c\3\2\2\2\u00dc\u050e\3\2"+
		"\2\2\u00de\u051a\3\2\2\2\u00e0\u051d\3\2\2\2\u00e2\u054a\3\2\2\2\u00e4"+
		"\u054c\3\2\2\2\u00e6\u0550\3\2\2\2\u00e8\u0555\3\2\2\2\u00ea\u0569\3\2"+
		"\2\2\u00ec\u056b\3\2\2\2\u00ee\u0571\3\2\2\2\u00f0\u057b\3\2\2\2\u00f2"+
		"\u0590\3\2\2\2\u00f4\u0596\3\2\2\2\u00f6\u0598\3\2\2\2\u00f8\u059e\3\2"+
		"\2\2\u00fa\u05a6\3\2\2\2\u00fc\u05ba\3\2\2\2\u00fe\u05bc\3\2\2\2\u0100"+
		"\u05ce\3\2\2\2\u0102\u05d0\3\2\2\2\u0104\u05e2\3\2\2\2\u0106\u0613\3\2"+
		"\2\2\u0108\u061e\3\2\2\2\u010a\u0623\3\2\2\2\u010c\u0627\3\2\2\2\u010e"+
		"\u0637\3\2\2\2\u0110\u0639\3\2\2\2\u0112\u063b\3\2\2\2\u0114\u0663\3\2"+
		"\2\2\u0116\u0665\3\2\2\2\u0118\u066f\3\2\2\2\u011a\u0680\3\2\2\2\u011c"+
		"\u0694\3\2\2\2\u011e\u069e\3\2\2\2\u0120\u06a2\3\2\2\2\u0122\u0124\5\4"+
		"\3\2\u0123\u0122\3\2\2\2\u0124\u0127\3\2\2\2\u0125\u0123\3\2\2\2\u0125"+
		"\u0126\3\2\2\2\u0126\u0128\3\2\2\2\u0127\u0125\3\2\2\2\u0128\u0129\7\2"+
		"\2\3\u0129\3\3\2\2\2\u012a\u0136\5\6\4\2\u012b\u0136\5z>\2\u012c\u0136"+
		"\5\u008cG\2\u012d\u0136\5\b\5\2\u012e\u0136\5\f\7\2\u012f\u0136\5\n\6"+
		"\2\u0130\u0136\5\16\b\2\u0131\u0136\5\22\n\2\u0132\u0136\5\26\f\2\u0133"+
		"\u0136\5\30\r\2\u0134\u0136\5|?\2\u0135\u012a\3\2\2\2\u0135\u012b\3\2"+
		"\2\2\u0135\u012c\3\2\2\2\u0135\u012d\3\2\2\2\u0135\u012e\3\2\2\2\u0135"+
		"\u012f\3\2\2\2\u0135\u0130\3\2\2\2\u0135\u0131\3\2\2\2\u0135\u0132\3\2"+
		"\2\2\u0135\u0133\3\2\2\2\u0135\u0134\3\2\2\2\u0136\5\3\2\2\2\u0137\u0138"+
		"\7E\2\2\u0138\u0139\5\u0120\u0091\2\u0139\u013a\7\u0086\2\2\u013a\7\3"+
		"\2\2\2\u013b\u013d\7x\2\2\u013c\u013b\3\2\2\2\u013c\u013d\3\2\2\2\u013d"+
		"\u013e\3\2\2\2\u013e\u013f\7D\2\2\u013f\u0142\5\20\t\2\u0140\u0141\7\u0091"+
		"\2\2\u0141\u0143\5\u0120\u0091\2\u0142\u0140\3\2\2\2\u0142\u0143\3\2\2"+
		"\2\u0143\u0148\3\2\2\2\u0144\u0145\7\u008d\2\2\u0145\u0146\5\32\16\2\u0146"+
		"\u0147\7\u008c\2\2\u0147\u0149\3\2\2\2\u0148\u0144\3\2\2\2\u0148\u0149"+
		"\3\2\2\2\u0149\u014b\3\2\2\2\u014a\u014c\5$\23\2\u014b\u014a\3\2\2\2\u014b"+
		"\u014c\3\2\2\2\u014c\u014e\3\2\2\2\u014d\u014f\5*\26\2\u014e\u014d\3\2"+
		"\2\2\u014e\u014f\3\2\2\2\u014f\u0150\3\2\2\2\u0150\u0151\7A\2\2\u0151"+
		"\t\3\2\2\2\u0152\u0153\7D\2\2\u0153\u0154\5\20\t\2\u0154\u0156\7\u0080"+
		"\2\2\u0155\u0157\5\u0120\u0091\2\u0156\u0155\3\2\2\2\u0156\u0157\3\2\2"+
		"\2\u0157\u0158\3\2\2\2\u0158\u015d\7\u0081\2\2\u0159\u015a\7\u008d\2\2"+
		"\u015a\u015b\5\32\16\2\u015b\u015c\7\u008c\2\2\u015c\u015e\3\2\2\2\u015d"+
		"\u0159\3\2\2\2\u015d\u015e\3\2\2\2\u015e\u0160\3\2\2\2\u015f\u0161\5$"+
		"\23\2\u0160\u015f\3\2\2\2\u0160\u0161\3\2\2\2\u0161\u0163\3\2\2\2\u0162"+
		"\u0164\5*\26\2\u0163\u0162\3\2\2\2\u0163\u0164\3\2\2\2\u0164\u0165\3\2"+
		"\2\2\u0165\u0166\7A\2\2\u0166\13\3\2\2\2\u0167\u0168\7C\2\2\u0168\u016b"+
		"\5\20\t\2\u0169\u016a\7\u0091\2\2\u016a\u016c\5\u0120\u0091\2\u016b\u0169"+
		"\3\2\2\2\u016b\u016c\3\2\2\2\u016c\u016e\3\2\2\2\u016d\u016f\5$\23\2\u016e"+
		"\u016d\3\2\2\2\u016e\u016f\3\2\2\2\u016f\u0171\3\2\2\2\u0170\u0172\5\62"+
		"\32\2\u0171\u0170\3\2\2\2\u0171\u0172\3\2\2\2\u0172\u0173\3\2\2\2\u0173"+
		"\u0174\7A\2\2\u0174\r\3\2\2\2\u0175\u0176\7C\2\2\u0176\u0177\5\20\t\2"+
		"\u0177\u0178\7\u0080\2\2\u0178\u0179\5\u0120\u0091\2\u0179\u017b\7\u0081"+
		"\2\2\u017a\u017c\5\62\32\2\u017b\u017a\3\2\2\2\u017b\u017c\3\2\2\2\u017c"+
		"\u017d\3\2\2\2\u017d\u017e\7A\2\2\u017e\17\3\2\2\2\u017f\u0185\5\u0120"+
		"\u0091\2\u0180\u0181\7\u008d\2\2\u0181\u0182\5\32\16\2\u0182\u0183\7\u008c"+
		"\2\2\u0183\u0186\3\2\2\2\u0184\u0186\5J&\2\u0185\u0180\3\2\2\2\u0185\u0184"+
		"\3\2\2\2\u0185\u0186\3\2\2\2\u0186\21\3\2\2\2\u0187\u0188\7G\2\2\u0188"+
		"\u018d\5\"\22\2\u0189\u018a\7\u008d\2\2\u018a\u018b\5\32\16\2\u018b\u018c"+
		"\7\u008c\2\2\u018c\u018e\3\2\2\2\u018d\u0189\3\2\2\2\u018d\u018e\3\2\2"+
		"\2\u018e\u0192\3\2\2\2\u018f\u0191\5\24\13\2\u0190\u018f\3\2\2\2\u0191"+
		"\u0194\3\2\2\2\u0192\u0190\3\2\2\2\u0192\u0193\3\2\2\2\u0193\u0195\3\2"+
		"\2\2\u0194\u0192\3\2\2\2\u0195\u0196\7A\2\2\u0196\23\3\2\2\2\u0197\u019b"+
		"\t\2\2\2\u0198\u019a\5*\26\2\u0199\u0198\3\2\2\2\u019a\u019d\3\2\2\2\u019b"+
		"\u0199\3\2\2\2\u019b\u019c\3\2\2\2\u019c\u01a4\3\2\2\2\u019d\u019b\3\2"+
		"\2\2\u019e\u01a0\5*\26\2\u019f\u019e\3\2\2\2\u01a0\u01a1\3\2\2\2\u01a1"+
		"\u019f\3\2\2\2\u01a1\u01a2\3\2\2\2\u01a2\u01a4\3\2\2\2\u01a3\u0197\3\2"+
		"\2\2\u01a3\u019f\3\2\2\2\u01a4\25\3\2\2\2\u01a5\u01a6\7G\2\2\u01a6\u01a7"+
		"\5\32\16\2\u01a7\u01a8\7\u0086\2\2\u01a8\27\3\2\2\2\u01a9\u01aa\7>\2\2"+
		"\u01aa\u01af\5\u0120\u0091\2\u01ab\u01ac\7\u0087\2\2\u01ac\u01ae\5\u0120"+
		"\u0091\2\u01ad\u01ab\3\2\2\2\u01ae\u01b1\3\2\2\2\u01af\u01ad\3\2\2\2\u01af"+
		"\u01b0\3\2\2\2\u01b0\u01b2\3\2\2\2\u01b1\u01af\3\2\2\2\u01b2\u01b3\7\u0086"+
		"\2\2\u01b3\31\3\2\2\2\u01b4\u01b9\5\"\22\2\u01b5\u01b6\7\u0087\2\2\u01b6"+
		"\u01b8\5\"\22\2\u01b7\u01b5\3\2\2\2\u01b8\u01bb\3\2\2\2\u01b9\u01b7\3"+
		"\2\2\2\u01b9\u01ba\3\2\2\2\u01ba\33\3\2\2\2\u01bb\u01b9\3\2\2\2\u01bc"+
		"\u01c1\7J\2\2\u01bd\u01be\7\u0080\2\2\u01be\u01bf\5\36\20\2\u01bf\u01c0"+
		"\7\u0081\2\2\u01c0\u01c2\3\2\2\2\u01c1\u01bd\3\2\2\2\u01c1\u01c2\3\2\2"+
		"\2\u01c2\u01c4\3\2\2\2\u01c3\u01c5\5\u00a8U\2\u01c4\u01c3\3\2\2\2\u01c4"+
		"\u01c5\3\2\2\2\u01c5\u01c7\3\2\2\2\u01c6\u01c8\7w\2\2\u01c7\u01c6\3\2"+
		"\2\2\u01c7\u01c8\3\2\2\2\u01c8\u01c9\3\2\2\2\u01c9\u01ca\5\u00a4S\2\u01ca"+
		"\35\3\2\2\2\u01cb\u01d0\5 \21\2\u01cc\u01cd\7\u0087\2\2\u01cd\u01cf\5"+
		" \21\2\u01ce\u01cc\3\2\2\2\u01cf\u01d2\3\2\2\2\u01d0\u01ce\3\2\2\2\u01d0"+
		"\u01d1\3\2\2\2\u01d1\37\3\2\2\2\u01d2\u01d0\3\2\2\2\u01d3\u01e8\7S\2\2"+
		"\u01d4\u01e8\7T\2\2\u01d5\u01e8\7p\2\2\u01d6\u01e8\7s\2\2\u01d7\u01e8"+
		"\7U\2\2\u01d8\u01e8\7l\2\2\u01d9\u01e8\7t\2\2\u01da\u01e8\7m\2\2\u01db"+
		"\u01e8\7q\2\2\u01dc\u01e8\7r\2\2\u01dd\u01de\7n\2\2\u01de\u01df\7\u008b"+
		"\2\2\u01df\u01e8\5\u0120\u0091\2\u01e0\u01e1\7o\2\2\u01e1\u01e2\7\u008b"+
		"\2\2\u01e2\u01e3\5\u0120\u0091\2\u01e3\u01e4\7\u0091\2\2\u01e4\u01e8\3"+
		"\2\2\2\u01e5\u01e8\5\u00acW\2\u01e6\u01e8\5\u0120\u0091\2\u01e7\u01d3"+
		"\3\2\2\2\u01e7\u01d4\3\2\2\2\u01e7\u01d5\3\2\2\2\u01e7\u01d6\3\2\2\2\u01e7"+
		"\u01d7\3\2\2\2\u01e7\u01d8\3\2\2\2\u01e7\u01d9\3\2\2\2\u01e7\u01da\3\2"+
		"\2\2\u01e7\u01db\3\2\2\2\u01e7\u01dc\3\2\2\2\u01e7\u01dd\3\2\2\2\u01e7"+
		"\u01e0\3\2\2\2\u01e7\u01e5\3\2\2\2\u01e7\u01e6\3\2\2\2\u01e8!\3\2\2\2"+
		"\u01e9\u01ea\7\u008d\2\2\u01ea\u01eb\5\32\16\2\u01eb\u01ec\7\u008c\2\2"+
		"\u01ec\u01f2\3\2\2\2\u01ed\u01ef\t\3\2\2\u01ee\u01ed\3\2\2\2\u01ee\u01ef"+
		"\3\2\2\2\u01ef\u01f0\3\2\2\2\u01f0\u01f2\5\u0120\u0091\2\u01f1\u01e9\3"+
		"\2\2\2\u01f1\u01ee\3\2\2\2\u01f2#\3\2\2\2\u01f3\u01f7\7\u0082\2\2\u01f4"+
		"\u01f6\5&\24\2\u01f5\u01f4\3\2\2\2\u01f6\u01f9\3\2\2\2\u01f7\u01f5\3\2"+
		"\2\2\u01f7\u01f8\3\2\2\2\u01f8\u01fa\3\2\2\2\u01f9\u01f7\3\2\2\2\u01fa"+
		"\u01fb\7\u0083\2\2\u01fb%\3\2\2\2\u01fc\u0200\5(\25\2\u01fd\u01ff\5\u00a4"+
		"S\2\u01fe\u01fd\3\2\2\2\u01ff\u0202\3\2\2\2\u0200\u01fe\3\2\2\2\u0200"+
		"\u0201\3\2\2\2\u0201\u0209\3\2\2\2\u0202\u0200\3\2\2\2\u0203\u0205\5\u00a4"+
		"S\2\u0204\u0203\3\2\2\2\u0205\u0206\3\2\2\2\u0206\u0204\3\2\2\2\u0206"+
		"\u0207\3\2\2\2\u0207\u0209\3\2\2\2\u0208\u01fc\3\2\2\2\u0208\u0204\3\2"+
		"\2\2\u0209\'\3\2\2\2\u020a\u020b\t\4\2\2\u020b)\3\2\2\2\u020c\u0212\5"+
		"\u008cG\2\u020d\u0212\5,\27\2\u020e\u0212\5.\30\2\u020f\u0212\5\34\17"+
		"\2\u0210\u0212\5z>\2\u0211\u020c\3\2\2\2\u0211\u020d\3\2\2\2\u0211\u020e"+
		"\3\2\2\2\u0211\u020f\3\2\2\2\u0211\u0210\3\2\2\2\u0212\u0213\3\2\2\2\u0213"+
		"\u0211\3\2\2\2\u0213\u0214\3\2\2\2\u0214+\3\2\2\2\u0215\u0216\7\u009a"+
		"\2\2\u0216\u0217\5\60\31\2\u0217-\3\2\2\2\u0218\u0219\7\u009b\2\2\u0219"+
		"\u021a\5\60\31\2\u021a/\3\2\2\2\u021b\u021d\5@!\2\u021c\u021b\3\2\2\2"+
		"\u021c\u021d\3\2\2\2\u021d\u021e\3\2\2\2\u021e\u0220\5:\36\2\u021f\u0221"+
		"\5\u00ceh\2\u0220\u021f\3\2\2\2\u0220\u0221\3\2\2\2\u0221\u0222\3\2\2"+
		"\2\u0222\u0223\7\u0086\2\2\u0223\61\3\2\2\2\u0224\u022a\5|?\2\u0225\u022a"+
		"\5\u008cG\2\u0226\u022a\5\64\33\2\u0227\u022a\5\66\34\2\u0228\u022a\5"+
		"B\"\2\u0229\u0224\3\2\2\2\u0229\u0225\3\2\2\2\u0229\u0226\3\2\2\2\u0229"+
		"\u0227\3\2\2\2\u0229\u0228\3\2\2\2\u022a\u022b\3\2\2\2\u022b\u0229\3\2"+
		"\2\2\u022b\u022c\3\2\2\2\u022c\63\3\2\2\2\u022d\u022e\7\u009a\2\2\u022e"+
		"\u022f\58\35\2\u022f\65\3\2\2\2\u0230\u0231\7\u009b\2\2\u0231\u0232\5"+
		"8\35\2\u0232\67\3\2\2\2\u0233\u0235\5@!\2\u0234\u0233\3\2\2\2\u0234\u0235"+
		"\3\2\2\2\u0235\u0236\3\2\2\2\u0236\u0238\5:\36\2\u0237\u0239\5\u009eP"+
		"\2\u0238\u0237\3\2\2\2\u0238\u0239\3\2\2\2\u0239\u023b\3\2\2\2\u023a\u023c"+
		"\7\u0086\2\2\u023b\u023a\3\2\2\2\u023b\u023c\3\2\2\2\u023c\u023d\3\2\2"+
		"\2\u023d\u023e\5\u00e8u\2\u023e9\3\2\2\2\u023f\u024a\5> \2\u0240\u0242"+
		"\5<\37\2\u0241\u0240\3\2\2\2\u0242\u0243\3\2\2\2\u0243\u0241\3\2\2\2\u0243"+
		"\u0244\3\2\2\2\u0244\u0247\3\2\2\2\u0245\u0246\7\u0087\2\2\u0246\u0248"+
		"\7\u00ac\2\2\u0247\u0245\3\2\2\2\u0247\u0248\3\2\2\2\u0248\u024a\3\2\2"+
		"\2\u0249\u023f\3\2\2\2\u0249\u0241\3\2\2\2\u024a;\3\2\2\2\u024b\u024d"+
		"\5> \2\u024c\u024b\3\2\2\2\u024c\u024d\3\2\2\2\u024d\u024e\3\2\2\2\u024e"+
		"\u0252\7\u0091\2\2\u024f\u0251\5@!\2\u0250\u024f\3\2\2\2\u0251\u0254\3"+
		"\2\2\2\u0252\u0250\3\2\2\2\u0252\u0253\3\2\2\2\u0253\u0256\3\2\2\2\u0254"+
		"\u0252\3\2\2\2\u0255\u0257\5\u00aaV\2\u0256\u0255\3\2\2\2\u0256\u0257"+
		"\3\2\2\2\u0257\u0258\3\2\2\2\u0258\u0259\5\u0120\u0091\2\u0259=\3\2\2"+
		"\2\u025a\u025d\5\u0120\u0091\2\u025b\u025d\7\30\2\2\u025c\u025a\3\2\2"+
		"\2\u025c\u025b\3\2\2\2\u025d?\3\2\2\2\u025e\u025f\7\u0080\2\2\u025f\u0260"+
		"\5\u00d6l\2\u0260\u0261\7\u0081\2\2\u0261A\3\2\2\2\u0262\u0263\7P\2\2"+
		"\u0263\u0264\5D#\2\u0264\u0265\7\u0086\2\2\u0265\u026b\3\2\2\2\u0266\u0267"+
		"\7?\2\2\u0267\u0268\5D#\2\u0268\u0269\7\u0086\2\2\u0269\u026b\3\2\2\2"+
		"\u026a\u0262\3\2\2\2\u026a\u0266\3\2\2\2\u026bC\3\2\2\2\u026c\u0271\5"+
		"F$\2\u026d\u026e\7\u0087\2\2\u026e\u0270\5F$\2\u026f\u026d\3\2\2\2\u0270"+
		"\u0273\3\2\2\2\u0271\u026f\3\2\2\2\u0271\u0272\3\2\2\2\u0272E\3\2\2\2"+
		"\u0273\u0271\3\2\2\2\u0274\u0277\5\u0120\u0091\2\u0275\u0276\7\u008b\2"+
		"\2\u0276\u0278\5\u0120\u0091\2\u0277\u0275\3\2\2\2\u0277\u0278\3\2\2\2"+
		"\u0278G\3\2\2\2\u0279\u027b\5\u00acW\2\u027a\u0279\3\2\2\2\u027a\u027b"+
		"\3\2\2\2\u027b\u027c\3\2\2\2\u027c\u027e\5\u00b6\\\2\u027d\u027f\5\u00ac"+
		"W\2\u027e\u027d\3\2\2\2\u027e\u027f\3\2\2\2\u027f\u0280\3\2\2\2\u0280"+
		"\u0281\7\u0080\2\2\u0281\u0284\7\u00a0\2\2\u0282\u0285\5\u00acW\2\u0283"+
		"\u0285\5\u00b6\\\2\u0284\u0282\3\2\2\2\u0284\u0283\3\2\2\2\u0284\u0285"+
		"\3\2\2\2\u0285\u0286\3\2\2\2\u0286\u0288\7\u0081\2\2\u0287\u0289\5V,\2"+
		"\u0288\u0287\3\2\2\2\u0288\u0289\3\2\2\2\u0289I\3\2\2\2\u028a\u0293\7"+
		"\u008d\2\2\u028b\u0290\5L\'\2\u028c\u028d\7\u0087\2\2\u028d\u028f\5L\'"+
		"\2\u028e\u028c\3\2\2\2\u028f\u0292\3\2\2\2\u0290\u028e\3\2\2\2\u0290\u0291"+
		"\3\2\2\2\u0291\u0294\3\2\2\2\u0292\u0290\3\2\2\2\u0293\u028b\3\2\2\2\u0293"+
		"\u0294\3\2\2\2\u0294\u0295\3\2\2\2\u0295\u0296\7\u008c\2\2\u0296K\3\2"+
		"\2\2\u0297\u0299\5\u00b0Y\2\u0298\u0297\3\2\2\2\u0299\u029c\3\2\2\2\u029a"+
		"\u0298\3\2\2\2\u029a\u029b\3\2\2\2\u029b\u029d\3\2\2\2\u029c\u029a\3\2"+
		"\2\2\u029d\u029e\5\u00b6\\\2\u029eM\3\2\2\2\u029f\u02a0\7\u008a\2\2\u02a0"+
		"\u02ac\7\u0082\2\2\u02a1\u02a6\5P)\2\u02a2\u02a3\7\u0087\2\2\u02a3\u02a5"+
		"\5P)\2\u02a4\u02a2\3\2\2\2\u02a5\u02a8\3\2\2\2\u02a6\u02a4\3\2\2\2\u02a6"+
		"\u02a7\3\2\2\2\u02a7\u02aa\3\2\2\2\u02a8\u02a6\3\2\2\2\u02a9\u02ab\7\u0087"+
		"\2\2\u02aa\u02a9\3\2\2\2\u02aa\u02ab\3\2\2\2\u02ab\u02ad\3\2\2\2\u02ac"+
		"\u02a1\3\2\2\2\u02ac\u02ad\3\2\2\2\u02ad\u02ae\3\2\2\2\u02ae\u02af\7\u0083"+
		"\2\2\u02afO\3\2\2\2\u02b0\u02b1\5\u0108\u0085\2\u02b1\u02b2\7\u0091\2"+
		"\2\u02b2\u02b3\5\u0104\u0083\2\u02b3Q\3\2\2\2\u02b4\u02b5\7\u008a\2\2"+
		"\u02b5\u02ba\7\u0084\2\2\u02b6\u02b8\5\u0102\u0082\2\u02b7\u02b9\7\u0087"+
		"\2\2\u02b8\u02b7\3\2\2\2\u02b8\u02b9\3\2\2\2\u02b9\u02bb\3\2\2\2\u02ba"+
		"\u02b6\3\2\2\2\u02ba\u02bb\3\2\2\2\u02bb\u02bc\3\2\2\2\u02bc\u02bd\7\u0085"+
		"\2\2\u02bdS\3\2\2\2\u02be\u02bf\7\u008a\2\2\u02bf\u02c0\7\u0080\2\2\u02c0"+
		"\u02c1\5\u0104\u0083\2\u02c1\u02c2\7\u0081\2\2\u02c2\u02c9\3\2\2\2\u02c3"+
		"\u02c6\7\u008a\2\2\u02c4\u02c7\5\u011c\u008f\2\u02c5\u02c7\5\u0120\u0091"+
		"\2\u02c6\u02c4\3\2\2\2\u02c6\u02c5\3\2\2\2\u02c7\u02c9\3\2\2\2\u02c8\u02be"+
		"\3\2\2\2\u02c8\u02c3\3\2\2\2\u02c9U\3\2\2\2\u02ca\u02d6\7\u0080\2\2\u02cb"+
		"\u02ce\5X-\2\u02cc\u02ce\7\"\2\2\u02cd\u02cb\3\2\2\2\u02cd\u02cc\3\2\2"+
		"\2\u02ce\u02d3\3\2\2\2\u02cf\u02d0\7\u0087\2\2\u02d0\u02d2\5X-\2\u02d1"+
		"\u02cf\3\2\2\2\u02d2\u02d5\3\2\2\2\u02d3\u02d1\3\2\2\2\u02d3\u02d4\3\2"+
		"\2\2\u02d4\u02d7\3\2\2\2\u02d5\u02d3\3\2\2\2\u02d6\u02cd\3\2\2\2\u02d6"+
		"\u02d7\3\2\2\2\u02d7\u02d8\3\2\2\2\u02d8\u02d9\7\u0081\2\2\u02d9W\3\2"+
		"\2\2\u02da\u02dd\5n8\2\u02db\u02dd\5\u00d6l\2\u02dc\u02da\3\2\2\2\u02dc"+
		"\u02db\3\2\2\2\u02ddY\3\2\2\2\u02de\u02e0\7\u00a0\2\2\u02df\u02e1\5\u00b6"+
		"\\\2\u02e0\u02df\3\2\2\2\u02e0\u02e1\3\2\2\2\u02e1\u02e3\3\2\2\2\u02e2"+
		"\u02e4\5\u00acW\2\u02e3\u02e2\3\2\2\2\u02e3\u02e4\3\2\2\2\u02e4\u02e6"+
		"\3\2\2\2\u02e5\u02e7\5V,\2\u02e6\u02e5\3\2\2\2\u02e6\u02e7\3\2\2\2\u02e7"+
		"\u02e8\3\2\2\2\u02e8\u02e9\5\u00e8u\2\u02e9[\3\2\2\2\u02ea\u02eb\7\u0084"+
		"\2\2\u02eb\u02ec\5^\60\2\u02ec\u02ed\5`\61\2\u02ed\u02ee\7\u0085\2\2\u02ee"+
		"]\3\2\2\2\u02ef\u02f2\5\u0104\u0083\2\u02f0\u02f2\5\u00b6\\\2\u02f1\u02ef"+
		"\3\2\2\2\u02f1\u02f0\3\2\2\2\u02f2_\3\2\2\2\u02f3\u02fa\5> \2\u02f4\u02f6"+
		"\5b\62\2\u02f5\u02f4\3\2\2\2\u02f6\u02f7\3\2\2\2\u02f7\u02f5\3\2\2\2\u02f7"+
		"\u02f8\3\2\2\2\u02f8\u02fa\3\2\2\2\u02f9\u02f3\3\2\2\2\u02f9\u02f5\3\2"+
		"\2\2\u02faa\3\2\2\2\u02fb\u02fd\5> \2\u02fc\u02fb\3\2\2\2\u02fc\u02fd"+
		"\3\2\2\2\u02fd\u02fe\3\2\2\2\u02fe\u02ff\7\u0091\2\2\u02ff\u0304\5d\63"+
		"\2\u0300\u0301\7\u0087\2\2\u0301\u0303\5d\63\2\u0302\u0300\3\2\2\2\u0303"+
		"\u0306\3\2\2\2\u0304\u0302\3\2\2\2\u0304\u0305\3\2\2\2\u0305c\3\2\2\2"+
		"\u0306\u0304\3\2\2\2\u0307\u0309\5\u0102\u0082\2\u0308\u030a\5\u00acW"+
		"\2\u0309\u0308\3\2\2\2\u0309\u030a\3\2\2\2\u030a\u030f\3\2\2\2\u030b\u030c"+
		"\7\u0082\2\2\u030c\u030d\5\u00d4k\2\u030d\u030e\7\u0083\2\2\u030e\u0310"+
		"\3\2\2\2\u030f\u030b\3\2\2\2\u030f\u0310\3\2\2\2\u0310e\3\2\2\2\u0311"+
		"\u0312\7N\2\2\u0312\u0313\7\u0080\2\2\u0313\u0314\5h\65\2\u0314\u0315"+
		"\7\u0081\2\2\u0315g\3\2\2\2\u0316\u0320\5> \2\u0317\u0319\5> \2\u0318"+
		"\u0317\3\2\2\2\u0318\u0319\3\2\2\2\u0319\u031a\3\2\2\2\u031a\u031c\7\u0091"+
		"\2\2\u031b\u0318\3\2\2\2\u031c\u031d\3\2\2\2\u031d\u031b\3\2\2\2\u031d"+
		"\u031e\3\2\2\2\u031e\u0320\3\2\2\2\u031f\u0316\3\2\2\2\u031f\u031b\3\2"+
		"\2\2\u0320i\3\2\2\2\u0321\u0322\7G\2\2\u0322\u0323\7\u0080\2\2\u0323\u0324"+
		"\5\"\22\2\u0324\u0325\7\u0081\2\2\u0325k\3\2\2\2\u0326\u0327\7@\2\2\u0327"+
		"\u0328\7\u0080\2\2\u0328\u0329\5\u00d6l\2\u0329\u032a\7\u0081\2\2\u032a"+
		"m\3\2\2\2\u032b\u032c\5\u009aN\2\u032c\u032d\5\u00e0q\2\u032do\3\2\2\2"+
		"\u032e\u032f\7Q\2\2\u032f\u0330\7\u0080\2\2\u0330\u0331\5\u0120\u0091"+
		"\2\u0331\u0332\7\u0081\2\2\u0332\u0336\3\2\2\2\u0333\u0334\7Q\2\2\u0334"+
		"\u0336\5\u0104\u0083\2\u0335\u032e\3\2\2\2\u0335\u0333\3\2\2\2\u0336q"+
		"\3\2\2\2\u0337\u0338\7R\2\2\u0338\u033c\5\u00e8u\2\u0339\u033b\5t;\2\u033a"+
		"\u0339\3\2\2\2\u033b\u033e\3\2\2\2\u033c\u033a\3\2\2\2\u033c\u033d\3\2"+
		"\2\2\u033d\u0341\3\2\2\2\u033e\u033c\3\2\2\2\u033f\u0340\7B\2\2\u0340"+
		"\u0342\5\u00e8u\2\u0341\u033f\3\2\2\2\u0341\u0342\3\2\2\2\u0342s\3\2\2"+
		"\2\u0343\u0344\7=\2\2\u0344\u0345\7\u0080\2\2\u0345\u0346\5n8\2\u0346"+
		"\u0347\7\u0081\2\2\u0347\u0348\5\u00e8u\2\u0348u\3\2\2\2\u0349\u034a\7"+
		"O\2\2\u034a\u034b\7\u0080\2\2\u034b\u034c\5\u0104\u0083\2\u034c\u034d"+
		"\7\u0081\2\2\u034d\u034e\5\u00e8u\2\u034ew\3\2\2\2\u034f\u0350\7<\2\2"+
		"\u0350\u0351\5\u00e8u\2\u0351y\3\2\2\2\u0352\u0353\5~@\2\u0353\u0354\7"+
		"\u0086\2\2\u0354{\3\2\2\2\u0355\u0356\5~@\2\u0356\u0357\5\u00e8u\2\u0357"+
		"}\3\2\2\2\u0358\u035a\5\u009aN\2\u0359\u0358\3\2\2\2\u0359\u035a\3\2\2"+
		"\2\u035a\u035b\3\2\2\2\u035b\u035c\5\u0120\u0091\2\u035c\u035e\7\u0080"+
		"\2\2\u035d\u035f\5\u00caf\2\u035e\u035d\3\2\2\2\u035e\u035f\3\2\2\2\u035f"+
		"\u0360\3\2\2\2\u0360\u0361\7\u0081\2\2\u0361\u0363\3\2\2\2\u0362\u0364"+
		"\5\u009cO\2\u0363\u0362\3\2\2\2\u0363\u0364\3\2\2\2\u0364\177\3\2\2\2"+
		"\u0365\u0367\5\u0082B\2\u0366\u0368\5\u0084C\2\u0367\u0366\3\2\2\2\u0367"+
		"\u0368\3\2\2\2\u0368\u0081\3\2\2\2\u0369\u036c\7\7\2\2\u036a\u036c\5\u0120"+
		"\u0091\2\u036b\u0369\3\2\2\2\u036b\u036a\3\2\2\2\u036c\u0083\3\2\2\2\u036d"+
		"\u036f\7\u0080\2\2\u036e\u0370\5\u0086D\2\u036f\u036e\3\2\2\2\u036f\u0370"+
		"\3\2\2\2\u0370\u0371\3\2\2\2\u0371\u0372\7\u0081\2\2\u0372\u0085\3\2\2"+
		"\2\u0373\u0378\5\u0088E\2\u0374\u0375\7\u0087\2\2\u0375\u0377\5\u0088"+
		"E\2\u0376\u0374\3\2\2\2\u0377\u037a\3\2\2\2\u0378\u0376\3\2\2\2\u0378"+
		"\u0379\3\2\2\2\u0379\u0087\3\2\2\2\u037a\u0378\3\2\2\2\u037b\u0380\5\u0080"+
		"A\2\u037c\u0380\5\u011c\u008f\2\u037d\u0380\5\u011e\u0090\2\u037e\u0380"+
		"\5\u008aF\2\u037f\u037b\3\2\2\2\u037f\u037c\3\2\2\2\u037f\u037d\3\2\2"+
		"\2\u037f\u037e\3\2\2\2\u0380\u0089\3\2\2\2\u0381\u0382\5\u0082B\2\u0382"+
		"\u0386\7\u008b\2\2\u0383\u0387\5\u011c\u008f\2\u0384\u0387\5\u0082B\2"+
		"\u0385\u0387\5\u011e\u0090\2\u0386\u0383\3\2\2\2\u0386\u0384\3\2\2\2\u0386"+
		"\u0385\3\2\2\2\u0387\u008b\3\2\2\2\u0388\u038d\5\u008eH\2\u0389\u038d"+
		"\5\u0090I\2\u038a\u038d\5\u0092J\2\u038b\u038d\5\u0094K\2\u038c\u0388"+
		"\3\2\2\2\u038c\u0389\3\2\2\2\u038c\u038a\3\2\2\2\u038c\u038b\3\2\2\2\u038d"+
		"\u008d\3\2\2\2\u038e\u0390\5\u009cO\2\u038f\u038e\3\2\2\2\u038f\u0390"+
		"\3\2\2\2\u0390\u0391\3\2\2\2\u0391\u0393\5\u0120\u0091\2\u0392\u0394\5"+
		"\u009cO\2\u0393\u0392\3\2\2\2\u0393\u0394\3\2\2\2\u0394\u0395\3\2\2\2"+
		"\u0395\u0396\7\u0080\2\2\u0396\u0397\5\u00c6d\2\u0397\u0398\7\u0081\2"+
		"\2\u0398\u0399\7\u0086\2\2\u0399\u008f\3\2\2\2\u039a\u039c\5\u009cO\2"+
		"\u039b\u039a\3\2\2\2\u039b\u039c\3\2\2\2\u039c\u039e\3\2\2\2\u039d\u039f"+
		"\7\37\2\2\u039e\u039d\3\2\2\2\u039e\u039f\3\2\2\2\u039f\u03a0\3\2\2\2"+
		"\u03a0\u03a2\5\u00be`\2\u03a1\u03a3\5\u0120\u0091\2\u03a2\u03a1\3\2\2"+
		"\2\u03a2\u03a3\3\2\2\2\u03a3\u03a4\3\2\2\2\u03a4\u03a5\7\u0086\2\2\u03a5"+
		"\u0091\3\2\2\2\u03a6\u03a7\5\u009aN\2\u03a7\u03a8\5\u009eP\2\u03a8\u03ab"+
		"\3\2\2\2\u03a9\u03ab\5\u009aN\2\u03aa\u03a6\3\2\2\2\u03aa\u03a9\3\2\2"+
		"\2\u03ab\u03ac\3\2\2\2\u03ac\u03ad\7\u0086\2\2\u03ad\u0093\3\2\2\2\u03ae"+
		"\u03b0\5\u009cO\2\u03af\u03ae\3\2\2\2\u03af\u03b0\3\2\2\2\u03b0\u03b1"+
		"\3\2\2\2\u03b1\u03b6\7\37\2\2\u03b2\u03b3\5\u009aN\2\u03b3\u03b4\5\u0096"+
		"L\2\u03b4\u03b7\3\2\2\2\u03b5\u03b7\5\u009aN\2\u03b6\u03b2\3\2\2\2\u03b6"+
		"\u03b5\3\2\2\2\u03b7\u03b8\3\2\2\2\u03b8\u03b9\7\u0086\2\2\u03b9\u0095"+
		"\3\2\2\2\u03ba\u03bf\5\u0098M\2\u03bb\u03bc\7\u0087\2\2\u03bc\u03be\5"+
		"\u0098M\2\u03bd\u03bb\3\2\2\2\u03be\u03c1\3\2\2\2\u03bf\u03bd\3\2\2\2"+
		"\u03bf\u03c0\3\2\2\2\u03c0\u0097\3\2\2\2\u03c1\u03bf\3\2\2\2\u03c2\u03c4"+
		"\5\u00ccg\2\u03c3\u03c2\3\2\2\2\u03c3\u03c4\3\2\2\2\u03c4\u03c5\3\2\2"+
		"\2\u03c5\u03c6\5\u00c6d\2\u03c6\u0099\3\2\2\2\u03c7\u03d0\5\u00aeX\2\u03c8"+
		"\u03d0\5\u009cO\2\u03c9\u03d0\5\u00aaV\2\u03ca\u03d0\5\u00acW\2\u03cb"+
		"\u03d0\5\u00a8U\2\u03cc\u03d0\5\u00b0Y\2\u03cd\u03d0\5\u00b2Z\2\u03ce"+
		"\u03d0\5\u00b6\\\2\u03cf\u03c7\3\2\2\2\u03cf\u03c8\3\2\2\2\u03cf\u03c9"+
		"\3\2\2\2\u03cf\u03ca\3\2\2\2\u03cf\u03cb\3\2\2\2\u03cf\u03cc\3\2\2\2\u03cf"+
		"\u03cd\3\2\2\2\u03cf\u03ce\3\2\2\2\u03d0\u03d1\3\2\2\2\u03d1\u03cf\3\2"+
		"\2\2\u03d1\u03d2\3\2\2\2\u03d2\u009b\3\2\2\2\u03d3\u03d4\7V\2\2\u03d4"+
		"\u03d5\7\u0080\2\2\u03d5\u03d6\7\u0080\2\2\u03d6\u03db\5\u0080A\2\u03d7"+
		"\u03d8\7\u0087\2\2\u03d8\u03da\5\u0080A\2\u03d9\u03d7\3\2\2\2\u03da\u03dd"+
		"\3\2\2\2\u03db\u03d9\3\2\2\2\u03db\u03dc\3\2\2\2\u03dc\u03de\3\2\2\2\u03dd"+
		"\u03db\3\2\2\2\u03de\u03df\7\u0081\2\2\u03df\u03e0\7\u0081\2\2\u03e0\u009d"+
		"\3\2\2\2\u03e1\u03e6\5\u00a0Q\2\u03e2\u03e3\7\u0087\2\2\u03e3\u03e5\5"+
		"\u00a0Q\2\u03e4\u03e2\3\2\2\2\u03e5\u03e8\3\2\2\2\u03e6\u03e4\3\2\2\2"+
		"\u03e6\u03e7\3\2\2\2\u03e7\u009f\3\2\2\2\u03e8\u03e6\3\2\2\2\u03e9\u03ec"+
		"\5\u00e0q\2\u03ea\u03eb\7\u008b\2\2\u03eb\u03ed\5\u010a\u0086\2\u03ec"+
		"\u03ea\3\2\2\2\u03ec\u03ed\3\2\2\2\u03ed\u00a1\3\2\2\2\u03ee\u03fb\t\5"+
		"\2\2\u03ef\u03fc\5\u0120\u0091\2\u03f0\u03f2\5\u0120\u0091\2\u03f1\u03f0"+
		"\3\2\2\2\u03f1\u03f2\3\2\2\2\u03f2\u03f3\3\2\2\2\u03f3\u03f5\7\u0082\2"+
		"\2\u03f4\u03f6\5\u00a4S\2\u03f5\u03f4\3\2\2\2\u03f6\u03f7\3\2\2\2\u03f7"+
		"\u03f5\3\2\2\2\u03f7\u03f8\3\2\2\2\u03f8\u03f9\3\2\2\2\u03f9\u03fa\7\u0083"+
		"\2\2\u03fa\u03fc\3\2\2\2\u03fb\u03ef\3\2\2\2\u03fb\u03f1\3\2\2\2\u03fc"+
		"\u00a3\3\2\2\2\u03fd\u03fe\5\u00a6T\2\u03fe\u0400\5\u00ba^\2\u03ff\u0401"+
		"\5\u00ceh\2\u0400\u03ff\3\2\2\2\u0400\u0401\3\2\2\2\u0401\u0402\3\2\2"+
		"\2\u0402\u0403\7\u0086\2\2\u0403\u00a5\3\2\2\2\u0404\u040b\5\u00aaV\2"+
		"\u0405\u040b\5\u00acW\2\u0406\u040b\5\u00a8U\2\u0407\u040b\5\u00b0Y\2"+
		"\u0408\u040b\5\u00b2Z\2\u0409\u040b\5\u00b6\\\2\u040a\u0404\3\2\2\2\u040a"+
		"\u0405\3\2\2\2\u040a\u0406\3\2\2\2\u040a\u0407\3\2\2\2\u040a\u0408\3\2"+
		"\2\2\u040a\u0409\3\2\2\2\u040b\u040c\3\2\2\2\u040c\u040a\3\2\2\2\u040c"+
		"\u040d\3\2\2\2\u040d\u00a7\3\2\2\2\u040e\u040f\7v\2\2\u040f\u0410\7\u0080"+
		"\2\2\u0410\u0411\5\u0120\u0091\2\u0411\u0412\7\u0081\2\2\u0412\u0415\3"+
		"\2\2\2\u0413\u0415\7u\2\2\u0414\u040e\3\2\2\2\u0414\u0413\3\2\2\2\u0415"+
		"\u00a9\3\2\2\2\u0416\u0417\t\6\2\2\u0417\u00ab\3\2\2\2\u0418\u0419\t\7"+
		"\2\2\u0419\u00ad\3\2\2\2\u041a\u041b\t\b\2\2\u041b\u00af\3\2\2\2\u041c"+
		"\u041d\t\t\2\2\u041d\u00b1\3\2\2\2\u041e\u0423\7\7\2\2\u041f\u0423\7#"+
		"\2\2\u0420\u0423\7\27\2\2\u0421\u0423\5\u00b4[\2\u0422\u041e\3\2\2\2\u0422"+
		"\u041f\3\2\2\2\u0422\u0420\3\2\2\2\u0422\u0421\3\2\2\2\u0423\u00b3\3\2"+
		"\2\2\u0424\u0425\t\n\2\2\u0425\u00b5\3\2\2\2\u0426\u0438\7\"\2\2\u0427"+
		"\u0438\7\6\2\2\u0428\u0438\7\31\2\2\u0429\u0438\7\24\2\2\u042a\u0438\7"+
		"\25\2\2\u042b\u0438\7\17\2\2\u042c\u0438\7\13\2\2\u042d\u0438\7\32\2\2"+
		"\u042e\u0438\7!\2\2\u042f\u0438\5\u00b8]\2\u0430\u0438\5\20\t\2\u0431"+
		"\u0438\5\u00a2R\2\u0432\u0438\5\u00be`\2\u0433\u0435\5\u0120\u0091\2\u0434"+
		"\u0436\5\u00ccg\2\u0435\u0434\3\2\2\2\u0435\u0436\3\2\2\2\u0436\u0438"+
		"\3\2\2\2\u0437\u0426\3\2\2\2\u0437\u0427\3\2\2\2\u0437\u0428\3\2\2\2\u0437"+
		"\u0429\3\2\2\2\u0437\u042a\3\2\2\2\u0437\u042b\3\2\2\2\u0437\u042c\3\2"+
		"\2\2\u0437\u042d\3\2\2\2\u0437\u042e\3\2\2\2\u0437\u042f\3\2\2\2\u0437"+
		"\u0430\3\2\2\2\u0437\u0431\3\2\2\2\u0437\u0432\3\2\2\2\u0437\u0433\3\2"+
		"\2\2\u0438\u00b7\3\2\2\2\u0439\u043a\7a\2\2\u043a\u043b\7\u0080\2\2\u043b"+
		"\u043c\5\u0104\u0083\2\u043c\u043d\7\u0081\2\2\u043d\u00b9\3\2\2\2\u043e"+
		"\u0443\5\u00bc_\2\u043f\u0440\7\u0087\2\2\u0440\u0442\5\u00bc_\2\u0441"+
		"\u043f\3\2\2\2\u0442\u0445\3\2\2\2\u0443\u0441\3\2\2\2\u0443\u0444\3\2"+
		"\2\2\u0444\u00bb\3\2\2\2\u0445\u0443\3\2\2\2\u0446\u044d\5\u00e0q\2\u0447"+
		"\u0449\5\u00e0q\2\u0448\u0447\3\2\2\2\u0448\u0449\3\2\2\2\u0449\u044a"+
		"\3\2\2\2\u044a\u044b\7\u0091\2\2\u044b\u044d\5\u011c\u008f\2\u044c\u0446"+
		"\3\2\2\2\u044c\u0448\3\2\2\2\u044d\u00bd\3\2\2\2\u044e\u0454\7\r\2\2\u044f"+
		"\u0451\5\u0120\u0091\2\u0450\u044f\3\2\2\2\u0450\u0451\3\2\2\2\u0451\u0452"+
		"\3\2\2\2\u0452\u0453\7\u0091\2\2\u0453\u0455\5\u00d6l\2\u0454\u0450\3"+
		"\2\2\2\u0454\u0455\3\2\2\2\u0455\u0461\3\2\2\2\u0456\u045b\5\u0120\u0091"+
		"\2\u0457\u0458\7\u0082\2\2\u0458\u0459\5\u00c0a\2\u0459\u045a\7\u0083"+
		"\2\2\u045a\u045c\3\2\2\2\u045b\u0457\3\2\2\2\u045b\u045c\3\2\2\2\u045c"+
		"\u0462\3\2\2\2\u045d\u045e\7\u0082\2\2\u045e\u045f\5\u00c0a\2\u045f\u0460"+
		"\7\u0083\2\2\u0460\u0462\3\2\2\2\u0461\u0456\3\2\2\2\u0461\u045d\3\2\2"+
		"\2\u0462\u046e\3\2\2\2\u0463\u0464\t\13\2\2\u0464\u0465\7\u0080\2\2\u0465"+
		"\u0466\5\u00d6l\2\u0466\u0467\7\u0087\2\2\u0467\u0468\5\u0120\u0091\2"+
		"\u0468\u0469\7\u0081\2\2\u0469\u046a\7\u0082\2\2\u046a\u046b\5\u00c0a"+
		"\2\u046b\u046c\7\u0083\2\2\u046c\u046e\3\2\2\2\u046d\u044e\3\2\2\2\u046d"+
		"\u0463\3\2\2\2\u046e\u00bf\3\2\2\2\u046f\u0474\5\u00c2b\2\u0470\u0471"+
		"\7\u0087\2\2\u0471\u0473\5\u00c2b\2\u0472\u0470\3\2\2\2\u0473\u0476\3"+
		"\2\2\2\u0474\u0472\3\2\2\2\u0474\u0475\3\2\2\2\u0475\u0478\3\2\2\2\u0476"+
		"\u0474\3\2\2\2\u0477\u0479\7\u0087\2\2\u0478\u0477\3\2\2\2\u0478\u0479"+
		"\3\2\2\2\u0479\u00c1\3\2\2\2\u047a\u047d\5\u00c4c\2\u047b\u047c\7\u008b"+
		"\2\2\u047c\u047e\5\u0104\u0083\2\u047d\u047b\3\2\2\2\u047d\u047e\3\2\2"+
		"\2\u047e\u00c3\3\2\2\2\u047f\u0482\5\u0120\u0091\2\u0480\u0482\7\t\2\2"+
		"\u0481\u047f\3\2\2\2\u0481\u0480\3\2\2\2\u0482\u00c5\3\2\2\2\u0483\u0489"+
		"\5\u0120\u0091\2\u0484\u0485\7\u0080\2\2\u0485\u0486\5\u00e0q\2\u0486"+
		"\u0487\7\u0081\2\2\u0487\u0489\3\2\2\2\u0488\u0483\3\2\2\2\u0488\u0484"+
		"\3\2\2\2\u0489\u048d\3\2\2\2\u048a\u048c\5\u00c8e\2\u048b\u048a\3\2\2"+
		"\2\u048c\u048f\3\2\2\2\u048d\u048b\3\2\2\2\u048d\u048e\3\2\2\2\u048e\u049b"+
		"\3\2\2\2\u048f\u048d\3\2\2\2\u0490\u0491\7\u0080\2\2\u0491\u0493\7\u00a0"+
		"\2\2\u0492\u0494\5\u00acW\2\u0493\u0492\3\2\2\2\u0493\u0494\3\2\2\2\u0494"+
		"\u0496\3\2\2\2\u0495\u0497\5\u0120\u0091\2\u0496\u0495\3\2\2\2\u0496\u0497"+
		"\3\2\2\2\u0497\u0498\3\2\2\2\u0498\u0499\7\u0081\2\2\u0499\u049b\5V,\2"+
		"\u049a\u0488\3\2\2\2\u049a\u0490\3\2\2\2\u049b\u00c7\3\2\2\2\u049c\u049e"+
		"\7\u0084\2\2\u049d\u049f\5\u010c\u0087\2\u049e\u049d\3\2\2\2\u049e\u049f"+
		"\3\2\2\2\u049f\u04a0\3\2\2\2\u04a0\u04a1\7\u0085\2\2\u04a1\u00c9\3\2\2"+
		"\2\u04a2\u04a5\5\u00dco\2\u04a3\u04a4\7\u0087\2\2\u04a4\u04a6\7\u00ac"+
		"\2\2\u04a5\u04a3\3\2\2\2\u04a5\u04a6\3\2\2\2\u04a6\u00cb\3\2\2\2\u04a7"+
		"\u04a9\7\u009c\2\2\u04a8\u04aa\5\u009aN\2\u04a9\u04a8\3\2\2\2\u04a9\u04aa"+
		"\3\2\2\2\u04aa\u04ac\3\2\2\2\u04ab\u04ad\5\u00ccg\2\u04ac\u04ab\3\2\2"+
		"\2\u04ac\u04ad\3\2\2\2\u04ad\u00cd\3\2\2\2\u04ae\u04ba\5\u0120\u0091\2"+
		"\u04af\u04b0\7\u0080\2\2\u04b0\u04b5\5\u011a\u008e\2\u04b1\u04b2\7\u0087"+
		"\2\2\u04b2\u04b4\5\u011a\u008e\2\u04b3\u04b1\3\2\2\2\u04b4\u04b7\3\2\2"+
		"\2\u04b5\u04b3\3\2\2\2\u04b5\u04b6\3\2\2\2\u04b6\u04b8\3\2\2\2\u04b7\u04b5"+
		"\3\2\2\2\u04b8\u04b9\7\u0081\2\2\u04b9\u04bb\3\2\2\2\u04ba\u04af\3\2\2"+
		"\2\u04ba\u04bb\3\2\2\2\u04bb\u00cf\3\2\2\2\u04bc\u04c1\7\u0082\2\2\u04bd"+
		"\u04bf\5\u0102\u0082\2\u04be\u04c0\7\u0087\2\2\u04bf\u04be\3\2\2\2\u04bf"+
		"\u04c0\3\2\2\2\u04c0\u04c2\3\2\2\2\u04c1\u04bd\3\2\2\2\u04c1\u04c2\3\2"+
		"\2\2\u04c2\u04c3\3\2\2\2\u04c3\u04c4\7\u0083\2\2\u04c4\u00d1\3\2\2\2\u04c5"+
		"\u04d3\7\u0082\2\2\u04c6\u04c7\7\u0088\2\2\u04c7\u04cd\5\u0104\u0083\2"+
		"\u04c8\u04c9\7\u0087\2\2\u04c9\u04ca\7\u0088\2\2\u04ca\u04cc\5\u0104\u0083"+
		"\2\u04cb\u04c8\3\2\2\2\u04cc\u04cf\3\2\2\2\u04cd\u04cb\3\2\2\2\u04cd\u04ce"+
		"\3\2\2\2\u04ce\u04d1\3\2\2\2\u04cf\u04cd\3\2\2\2\u04d0\u04d2\7\u0087\2"+
		"\2\u04d1\u04d0\3\2\2\2\u04d1\u04d2\3\2\2\2\u04d2\u04d4\3\2\2\2\u04d3\u04c6"+
		"\3\2\2\2\u04d3\u04d4\3\2\2\2\u04d4\u04d5\3\2\2\2\u04d5\u04d6\7\u0083\2"+
		"\2\u04d6\u00d3\3\2\2\2\u04d7\u04dc\5\u010a\u0086\2\u04d8\u04d9\7\u0087"+
		"\2\2\u04d9\u04db\5\u010a\u0086\2\u04da\u04d8\3\2\2\2\u04db\u04de\3\2\2"+
		"\2\u04dc\u04da\3\2\2\2\u04dc\u04dd\3\2\2\2\u04dd\u04e0\3\2\2\2\u04de\u04dc"+
		"\3\2\2\2\u04df\u04e1\7\u0087\2\2\u04e0\u04df\3\2\2\2\u04e0\u04e1\3\2\2"+
		"\2\u04e1\u00d5\3\2\2\2\u04e2\u04e4\5\u00a6T\2\u04e3\u04e5\5\u00d8m\2\u04e4"+
		"\u04e3\3\2\2\2\u04e4\u04e5\3\2\2\2\u04e5\u04e8\3\2\2\2\u04e6\u04e8\5H"+
		"%\2\u04e7\u04e2\3\2\2\2\u04e7\u04e6\3\2\2\2\u04e8\u00d7\3\2\2\2\u04e9"+
		"\u04eb\5\u00ccg\2\u04ea\u04ec\5\u00d8m\2\u04eb\u04ea\3\2\2\2\u04eb\u04ec"+
		"\3\2\2\2\u04ec\u0501\3\2\2\2\u04ed\u04ef\7\u0080\2\2\u04ee\u04f0\5\u00d8"+
		"m\2\u04ef\u04ee\3\2\2\2\u04ef\u04f0\3\2\2\2\u04f0\u04f1\3\2\2\2\u04f1"+
		"\u04f3\7\u0081\2\2\u04f2\u04f4\5\u00dan\2\u04f3\u04f2\3\2\2\2\u04f4\u04f5"+
		"\3\2\2\2\u04f5\u04f3\3\2\2\2\u04f5\u04f6\3\2\2\2\u04f6\u0501\3\2\2\2\u04f7"+
		"\u04f9\7\u0084\2\2\u04f8\u04fa\5\u010c\u0087\2\u04f9\u04f8\3\2\2\2\u04f9"+
		"\u04fa\3\2\2\2\u04fa\u04fb\3\2\2\2\u04fb\u04fd\7\u0085\2\2\u04fc\u04f7"+
		"\3\2\2\2\u04fd\u04fe\3\2\2\2\u04fe\u04fc\3\2\2\2\u04fe\u04ff\3\2\2\2\u04ff"+
		"\u0501\3\2\2\2\u0500\u04e9\3\2\2\2\u0500\u04ed\3\2\2\2\u0500\u04fc\3\2"+
		"\2\2\u0501\u00d9\3\2\2\2\u0502\u0504\7\u0084\2\2\u0503\u0505\5\u010c\u0087"+
		"\2\u0504\u0503\3\2\2\2\u0504\u0505\3\2\2\2\u0505\u0506\3\2\2\2\u0506\u050d"+
		"\7\u0085\2\2\u0507\u0509\7\u0080\2\2\u0508\u050a\5\u00dco\2\u0509\u0508"+
		"\3\2\2\2\u0509\u050a\3\2\2\2\u050a\u050b\3\2\2\2\u050b\u050d\7\u0081\2"+
		"\2\u050c\u0502\3\2\2\2\u050c\u0507\3\2\2\2\u050d\u00db\3\2\2\2\u050e\u0513"+
		"\5\u00dep\2\u050f\u0510\7\u0087\2\2\u0510\u0512\5\u00dep\2\u0511\u050f"+
		"\3\2\2\2\u0512\u0515\3\2\2\2\u0513\u0511\3\2\2\2\u0513\u0514\3\2\2\2\u0514"+
		"\u00dd\3\2\2\2\u0515\u0513\3\2\2\2\u0516\u0517\5\u009aN\2\u0517\u0518"+
		"\5\u00e0q\2\u0518\u051b\3\2\2\2\u0519\u051b\7\"\2\2\u051a\u0516\3\2\2"+
		"\2\u051a\u0519\3\2\2\2\u051b\u00df\3\2\2\2\u051c\u051e\5\u00ccg\2\u051d"+
		"\u051c\3\2\2\2\u051d\u051e\3\2\2\2\u051e\u051f\3\2\2\2\u051f\u0520\5\u00c6"+
		"d\2\u0520\u00e1\3\2\2\2\u0521\u0523\5\u00e4s\2\u0522\u0524\7\u0086\2\2"+
		"\u0523\u0522\3\2\2\2\u0523\u0524\3\2\2\2\u0524\u054b\3\2\2\2\u0525\u0527"+
		"\5\u00e8u\2\u0526\u0528\7\u0086\2\2\u0527\u0526\3\2\2\2\u0527\u0528\3"+
		"\2\2\2\u0528\u054b\3\2\2\2\u0529\u052b\5\u00eav\2\u052a\u052c\7\u0086"+
		"\2\2\u052b\u052a\3\2\2\2\u052b\u052c\3\2\2\2\u052c\u054b\3\2\2\2\u052d"+
		"\u052f\5\u00f4{\2\u052e\u0530\7\u0086\2\2\u052f\u052e\3\2\2\2\u052f\u0530"+
		"\3\2\2\2\u0530\u054b\3\2\2\2\u0531\u0533\5\u0100\u0081\2\u0532\u0534\7"+
		"\u0086\2\2\u0533\u0532\3\2\2\2\u0533\u0534\3\2\2\2\u0534\u054b\3\2\2\2"+
		"\u0535\u0537\5v<\2\u0536\u0538\7\u0086\2\2\u0537\u0536\3\2\2\2\u0537\u0538"+
		"\3\2\2\2\u0538\u054b\3\2\2\2\u0539\u053b\5x=\2\u053a\u053c\7\u0086\2\2"+
		"\u053b\u053a\3\2\2\2\u053b\u053c\3\2\2\2\u053c\u054b\3\2\2\2\u053d\u053f"+
		"\5p9\2\u053e\u0540\7\u0086\2\2\u053f\u053e\3\2\2\2\u053f\u0540\3\2\2\2"+
		"\u0540\u054b\3\2\2\2\u0541\u0543\5r:\2\u0542\u0544\7\u0086\2\2\u0543\u0542"+
		"\3\2\2\2\u0543\u0544\3\2\2\2\u0544\u054b\3\2\2\2\u0545\u0547\5\u0102\u0082"+
		"\2\u0546\u0548\7\u0086\2\2\u0547\u0546\3\2\2\2\u0547\u0548\3\2\2\2\u0548"+
		"\u054b\3\2\2\2\u0549\u054b\7\u0086\2\2\u054a\u0521\3\2\2\2\u054a\u0525"+
		"\3\2\2\2\u054a\u0529\3\2\2\2\u054a\u052d\3\2\2\2\u054a\u0531\3\2\2\2\u054a"+
		"\u0535\3\2\2\2\u054a\u0539\3\2\2\2\u054a\u053d\3\2\2\2\u054a\u0541\3\2"+
		"\2\2\u054a\u0545\3\2\2\2\u054a\u0549\3\2\2\2\u054b\u00e3\3\2\2\2\u054c"+
		"\u054d\5\u0120\u0091\2\u054d\u054e\7\u0091\2\2\u054e\u054f\5\u00e2r\2"+
		"\u054f\u00e5\3\2\2\2\u0550\u0553\5\u010c\u0087\2\u0551\u0552\7\u00ac\2"+
		"\2\u0552\u0554\5\u010c\u0087\2\u0553\u0551\3\2\2\2\u0553\u0554\3\2\2\2"+
		"\u0554\u00e7\3\2\2\2\u0555\u055a\7\u0082\2\2\u0556\u0559\5\u008cG\2\u0557"+
		"\u0559\5\u00e2r\2\u0558\u0556\3\2\2\2\u0558\u0557\3\2\2\2\u0559\u055c"+
		"\3\2\2\2\u055a\u0558\3\2\2\2\u055a\u055b\3\2\2\2\u055b\u055d\3\2\2\2\u055c"+
		"\u055a\3\2\2\2\u055d\u055e\7\u0083\2\2\u055e\u00e9\3\2\2\2\u055f\u0560"+
		"\7\22\2\2\u0560\u0561\7\u0080\2\2\u0561\u0562\5\u0104\u0083\2\u0562\u0563"+
		"\7\u0081\2\2\u0563\u0566\5\u00e2r\2\u0564\u0565\7\f\2\2\u0565\u0567\5"+
		"\u00e2r\2\u0566\u0564\3\2\2\2\u0566\u0567\3\2\2\2\u0567\u056a\3\2\2\2"+
		"\u0568\u056a\5\u00ecw\2\u0569\u055f\3\2\2\2\u0569\u0568\3\2\2\2\u056a"+
		"\u00eb\3\2\2\2\u056b\u056c\7\36\2\2\u056c\u056d\7\u0080\2\2\u056d\u056e"+
		"\5\u0104\u0083\2\u056e\u056f\7\u0081\2\2\u056f\u0570\5\u00eex\2\u0570"+
		"\u00ed\3\2\2\2\u0571\u0575\7\u0082\2\2\u0572\u0574\5\u00f0y\2\u0573\u0572"+
		"\3\2\2\2\u0574\u0577\3\2\2\2\u0575\u0573\3\2\2\2\u0575\u0576\3\2\2\2\u0576"+
		"\u0578\3\2\2\2\u0577\u0575\3\2\2\2\u0578\u0579\7\u0083\2\2\u0579\u00ef"+
		"\3\2\2\2\u057a\u057c\5\u00f2z\2\u057b\u057a\3\2\2\2\u057c\u057d\3\2\2"+
		"\2\u057d\u057b\3\2\2\2\u057d\u057e\3\2\2\2\u057e\u0580\3\2\2\2\u057f\u0581"+
		"\5\u00e2r\2\u0580\u057f\3\2\2\2\u0581\u0582\3\2\2\2\u0582\u0580\3\2\2"+
		"\2\u0582\u0583\3\2\2\2\u0583\u00f1\3\2\2\2\u0584\u058a\7\5\2\2\u0585\u058b"+
		"\5\u00e6t\2\u0586\u0587\7\u0080\2\2\u0587\u0588\5\u00e6t\2\u0588\u0589"+
		"\7\u0081\2\2\u0589\u058b\3\2\2\2\u058a\u0585\3\2\2\2\u058a\u0586\3\2\2"+
		"\2\u058b\u058c\3\2\2\2\u058c\u058d\7\u0091\2\2\u058d\u0591\3\2\2\2\u058e"+
		"\u058f\7\t\2\2\u058f\u0591\7\u0091\2\2\u0590\u0584\3\2\2\2\u0590\u058e"+
		"\3\2\2\2\u0591\u00f3\3\2\2\2\u0592\u0597\5\u00f6|\2\u0593\u0597\5\u00f8"+
		"}\2\u0594\u0597\5\u00fa~\2\u0595\u0597\5\u00fe\u0080\2\u0596\u0592\3\2"+
		"\2\2\u0596\u0593\3\2\2\2\u0596\u0594\3\2\2\2\u0596\u0595\3\2\2\2\u0597"+
		"\u00f5\3\2\2\2\u0598\u0599\7$\2\2\u0599\u059a\7\u0080\2\2\u059a\u059b"+
		"\5\u0104\u0083\2\u059b\u059c\7\u0081\2\2\u059c\u059d\5\u00e2r\2\u059d"+
		"\u00f7\3\2\2\2\u059e\u059f\7\n\2\2\u059f\u05a0\5\u00e2r\2\u05a0\u05a1"+
		"\7$\2\2\u05a1\u05a2\7\u0080\2\2\u05a2\u05a3\5\u0104\u0083\2\u05a3\u05a4"+
		"\7\u0081\2\2\u05a4\u05a5\7\u0086\2\2\u05a5\u00f9\3\2\2\2\u05a6\u05a7\7"+
		"\20\2\2\u05a7\u05a9\7\u0080\2\2\u05a8\u05aa\5\u00fc\177\2\u05a9\u05a8"+
		"\3\2\2\2\u05a9\u05aa\3\2\2\2\u05aa\u05ab\3\2\2\2\u05ab\u05ad\7\u0086\2"+
		"\2\u05ac\u05ae\5\u0104\u0083\2\u05ad\u05ac\3\2\2\2\u05ad\u05ae\3\2\2\2"+
		"\u05ae\u05af\3\2\2\2\u05af\u05b1\7\u0086\2\2\u05b0\u05b2\5\u0102\u0082"+
		"\2\u05b1\u05b0\3\2\2\2\u05b1\u05b2\3\2\2\2\u05b2\u05b3\3\2\2\2\u05b3\u05b4"+
		"\7\u0081\2\2\u05b4\u05b5\5\u00e2r\2\u05b5\u00fb\3\2\2\2\u05b6\u05b7\5"+
		"\u009aN\2\u05b7\u05b8\5\u009eP\2\u05b8\u05bb\3\2\2\2\u05b9\u05bb\5\u0102"+
		"\u0082\2\u05ba\u05b6\3\2\2\2\u05ba\u05b9\3\2\2\2\u05bb\u00fd\3\2\2\2\u05bc"+
		"\u05bd\7\20\2\2\u05bd\u05be\7\u0080\2\2\u05be\u05bf\5n8\2\u05bf\u05c1"+
		"\7\60\2\2\u05c0\u05c2\5\u0104\u0083\2\u05c1\u05c0\3\2\2\2\u05c1\u05c2"+
		"\3\2\2\2\u05c2\u05c3\3\2\2\2\u05c3\u05c4\7\u0081\2\2\u05c4\u05c5\5\u00e2"+
		"r\2\u05c5\u00ff\3\2\2\2\u05c6\u05c7\7\21\2\2\u05c7\u05cf\5\u0120\u0091"+
		"\2\u05c8\u05cf\7\b\2\2\u05c9\u05cf\7\4\2\2\u05ca\u05cc\7\30\2\2\u05cb"+
		"\u05cd\5\u0104\u0083\2\u05cc\u05cb\3\2\2\2\u05cc\u05cd\3\2\2\2\u05cd\u05cf"+
		"\3\2\2\2\u05ce\u05c6\3\2\2\2\u05ce\u05c8\3\2\2\2\u05ce\u05c9\3\2\2\2\u05ce"+
		"\u05ca\3\2\2\2\u05cf\u0101\3\2\2\2\u05d0\u05d5\5\u0104\u0083\2\u05d1\u05d2"+
		"\7\u0087\2\2\u05d2\u05d4\5\u0104\u0083\2\u05d3\u05d1\3\2\2\2\u05d4\u05d7"+
		"\3\2\2\2\u05d5\u05d3\3\2\2\2\u05d5\u05d6\3\2\2\2\u05d6\u0103\3\2\2\2\u05d7"+
		"\u05d5\3\2\2\2\u05d8\u05d9\b\u0083\1\2\u05d9\u05e3\5\u0108\u0085\2\u05da"+
		"\u05db\7\u0080\2\2\u05db\u05dc\5\u00e8u\2\u05dc\u05dd\7\u0081\2\2\u05dd"+
		"\u05e3\3\2\2\2\u05de\u05df\5\u010e\u0088\2\u05df\u05e0\5\u0106\u0084\2"+
		"\u05e0\u05e1\5\u0104\u0083\3\u05e1\u05e3\3\2\2\2\u05e2\u05d8\3\2\2\2\u05e2"+
		"\u05da\3\2\2\2\u05e2\u05de\3\2\2\2\u05e3\u0610\3\2\2\2\u05e4\u05e5\f\17"+
		"\2\2\u05e5\u05e6\t\f\2\2\u05e6\u060f\5\u0104\u0083\20\u05e7\u05e8\f\16"+
		"\2\2\u05e8\u05e9\t\r\2\2\u05e9\u060f\5\u0104\u0083\17\u05ea\u05ef\f\r"+
		"\2\2\u05eb\u05ec\7\u008d\2\2\u05ec\u05f0\7\u008d\2\2\u05ed\u05ee\7\u008c"+
		"\2\2\u05ee\u05f0\7\u008c\2\2\u05ef\u05eb\3\2\2\2\u05ef\u05ed\3\2\2\2\u05f0"+
		"\u05f1\3\2\2\2\u05f1\u060f\5\u0104\u0083\16\u05f2\u05f3\f\f\2\2\u05f3"+
		"\u05f4\t\16\2\2\u05f4\u060f\5\u0104\u0083\r\u05f5\u05f6\f\13\2\2\u05f6"+
		"\u05f7\t\17\2\2\u05f7\u060f\5\u0104\u0083\f\u05f8\u05f9\f\n\2\2\u05f9"+
		"\u05fa\7\u009e\2\2\u05fa\u060f\5\u0104\u0083\13\u05fb\u05fc\f\t\2\2\u05fc"+
		"\u05fd\7\u00a0\2\2\u05fd\u060f\5\u0104\u0083\n\u05fe\u05ff\f\b\2\2\u05ff"+
		"\u0600\7\u009f\2\2\u0600\u060f\5\u0104\u0083\t\u0601\u0602\f\7\2\2\u0602"+
		"\u0603\7\u0096\2\2\u0603\u060f\5\u0104\u0083\b\u0604\u0605\f\6\2\2\u0605"+
		"\u0606\7\u0097\2\2\u0606\u060f\5\u0104\u0083\7\u0607\u0608\f\5\2\2\u0608"+
		"\u060a\7\u0090\2\2\u0609\u060b\5\u0104\u0083\2\u060a\u0609\3\2\2\2\u060a"+
		"\u060b\3\2\2\2\u060b\u060c\3\2\2\2\u060c\u060d\7\u0091\2\2\u060d\u060f"+
		"\5\u0104\u0083\6\u060e\u05e4\3\2\2\2\u060e\u05e7\3\2\2\2\u060e\u05ea\3"+
		"\2\2\2\u060e\u05f2\3\2\2\2\u060e\u05f5\3\2\2\2\u060e\u05f8\3\2\2\2\u060e"+
		"\u05fb\3\2\2\2\u060e\u05fe\3\2\2\2\u060e\u0601\3\2\2\2\u060e\u0604\3\2"+
		"\2\2\u060e\u0607\3\2\2\2\u060f\u0612\3\2\2\2\u0610\u060e\3\2\2\2\u0610"+
		"\u0611\3\2\2\2\u0611\u0105\3\2\2\2\u0612\u0610\3\2\2\2\u0613\u0614\t\20"+
		"\2\2\u0614\u0107\3\2\2\2\u0615\u061f\5\u010e\u0088\2\u0616\u0617\7\u0080"+
		"\2\2\u0617\u0618\5\u00d6l\2\u0618\u0619\7\u0081\2\2\u0619\u061c\3\2\2"+
		"\2\u061a\u061d\5\u0108\u0085\2\u061b\u061d\5\u010a\u0086\2\u061c\u061a"+
		"\3\2\2\2\u061c\u061b\3\2\2\2\u061d\u061f\3\2\2\2\u061e\u0615\3\2\2\2\u061e"+
		"\u0616\3\2\2\2\u061f\u0109\3\2\2\2\u0620\u0624\5\u0104\u0083\2\u0621\u0624"+
		"\5\u00d0i\2\u0622\u0624\5\u00d2j\2\u0623\u0620\3\2\2\2\u0623\u0621\3\2"+
		"\2\2\u0623\u0622\3\2\2\2\u0624\u010b\3\2\2\2\u0625\u0628\5\u0120\u0091"+
		"\2\u0626\u0628\5\u011c\u008f\2\u0627\u0625\3\2\2\2\u0627\u0626\3\2\2\2"+
		"\u0628\u010d\3\2\2\2\u0629\u0638\5\u0112\u008a\2\u062a\u0630\7\33\2\2"+
		"\u062b\u0631\5\u010e\u0088\2\u062c\u062d\7\u0080\2\2\u062d\u062e\5\u00b6"+
		"\\\2\u062e\u062f\7\u0081\2\2\u062f\u0631\3\2\2\2\u0630\u062b\3\2\2\2\u0630"+
		"\u062c\3\2\2\2\u0631\u0638\3\2\2\2\u0632\u0633\t\21\2\2\u0633\u0638\5"+
		"\u010e\u0088\2\u0634\u0635\5\u0110\u0089\2\u0635\u0636\5\u0108\u0085\2"+
		"\u0636\u0638\3\2\2\2\u0637\u0629\3\2\2\2\u0637\u062a\3\2\2\2\u0637\u0632"+
		"\3\2\2\2\u0637\u0634\3\2\2\2\u0638\u010f\3\2\2\2\u0639\u063a\t\22\2\2"+
		"\u063a\u0111\3\2\2\2\u063b\u063c\b\u008a\1\2\u063c\u0640\5\u011a\u008e"+
		"\2\u063d\u063f\5\u0114\u008b\2\u063e\u063d\3\2\2\2\u063f\u0642\3\2\2\2"+
		"\u0640\u063e\3\2\2\2\u0640\u0641\3\2\2\2\u0641\u064e\3\2\2\2\u0642\u0640"+
		"\3\2\2\2\u0643\u0644\f\3\2\2\u0644\u0645\t\23\2\2\u0645\u0649\5\u0120"+
		"\u0091\2\u0646\u0648\5\u0114\u008b\2\u0647\u0646\3\2\2\2\u0648\u064b\3"+
		"\2\2\2\u0649\u0647\3\2\2\2\u0649\u064a\3\2\2\2\u064a\u064d\3\2\2\2\u064b"+
		"\u0649\3\2\2\2\u064c\u0643\3\2\2\2\u064d\u0650\3\2\2\2\u064e\u064c\3\2"+
		"\2\2\u064e\u064f\3\2\2\2\u064f\u0113\3\2\2\2\u0650\u064e\3\2\2\2\u0651"+
		"\u0652\7\u0084\2\2\u0652\u0653\5\u0104\u0083\2\u0653\u0654\7\u0085\2\2"+
		"\u0654\u0664\3\2\2\2\u0655\u0657\7\u0080\2\2\u0656\u0658\5\u0116\u008c"+
		"\2\u0657\u0656\3\2\2\2\u0657\u0658\3\2\2\2\u0658\u0659\3\2\2\2\u0659\u0664"+
		"\7\u0081\2\2\u065a\u065d\7\u0080\2\2\u065b\u065e\7\u0087\2\2\u065c\u065e"+
		"\n\24\2\2\u065d\u065b\3\2\2\2\u065d\u065c\3\2\2\2\u065e\u065f\3\2\2\2"+
		"\u065f\u065d\3\2\2\2\u065f\u0660\3\2\2\2\u0660\u0661\3\2\2\2\u0661\u0664"+
		"\7\u0081\2\2\u0662\u0664\t\21\2\2\u0663\u0651\3\2\2\2\u0663\u0655\3\2"+
		"\2\2\u0663\u065a\3\2\2\2\u0663\u0662\3\2\2\2\u0664\u0115\3\2\2\2\u0665"+
		"\u066a\5\u0118\u008d\2\u0666\u0667\7\u0087\2\2\u0667\u0669\5\u0118\u008d"+
		"\2\u0668\u0666\3\2\2\2\u0669\u066c\3\2\2\2\u066a\u0668\3\2\2\2\u066a\u066b"+
		"\3\2\2\2\u066b\u0117\3\2\2\2\u066c\u066a\3\2\2\2\u066d\u0670\5\u0104\u0083"+
		"\2\u066e\u0670\5\u00b6\\\2\u066f\u066d\3\2\2\2\u066f\u066e\3\2\2\2\u0670"+
		"\u0119\3\2\2\2\u0671\u0681\5\u0120\u0091\2\u0672\u0681\5\u011c\u008f\2"+
		"\u0673\u0681\5\u011e\u0090\2\u0674\u0675\7\u0080\2\2\u0675\u0676\5\u0104"+
		"\u0083\2\u0676\u0677\7\u0081\2\2\u0677\u0681\3\2\2\2\u0678\u0681\5\\/"+
		"\2\u0679\u0681\5f\64\2\u067a\u0681\5j\66\2\u067b\u0681\5l\67\2\u067c\u0681"+
		"\5N(\2\u067d\u0681\5R*\2\u067e\u0681\5T+\2\u067f\u0681\5Z.\2\u0680\u0671"+
		"\3\2\2\2\u0680\u0672\3\2\2\2\u0680\u0673\3\2\2\2\u0680\u0674\3\2\2\2\u0680"+
		"\u0678\3\2\2\2\u0680\u0679\3\2\2\2\u0680\u067a\3\2\2\2\u0680\u067b\3\2"+
		"\2\2\u0680\u067c\3\2\2\2\u0680\u067d\3\2\2\2\u0680\u067e\3\2\2\2\u0680"+
		"\u067f\3\2\2\2\u0681\u011b\3\2\2\2\u0682\u0695\7\u00af\2\2\u0683\u0695"+
		"\7\u00b0\2\2\u0684\u0695\7\u00b1\2\2\u0685\u0687\t\r\2\2\u0686\u0685\3"+
		"\2\2\2\u0686\u0687\3\2\2\2\u0687\u0688\3\2\2\2\u0688\u0695\7\u00b2\2\2"+
		"\u0689\u068b\t\r\2\2\u068a\u0689\3\2\2\2\u068a\u068b\3\2\2\2\u068b\u068c"+
		"\3\2\2\2\u068c\u0695\7\u00b3\2\2\u068d\u0695\7\u00ad\2\2\u068e\u0695\7"+
		"\62\2\2\u068f\u0695\7\64\2\2\u0690\u0695\7;\2\2\u0691\u0695\7\63\2\2\u0692"+
		"\u0695\7(\2\2\u0693\u0695\7)\2\2\u0694\u0682\3\2\2\2\u0694\u0683\3\2\2"+
		"\2\u0694\u0684\3\2\2\2\u0694\u0686\3\2\2\2\u0694\u068a\3\2\2\2\u0694\u068d"+
		"\3\2\2\2\u0694\u068e\3\2\2\2\u0694\u068f\3\2\2\2\u0694\u0690\3\2\2\2\u0694"+
		"\u0691\3\2\2\2\u0694\u0692\3\2\2\2\u0694\u0693\3\2\2\2\u0695\u011d\3\2"+
		"\2\2\u0696\u069a\7\u00ae\2\2\u0697\u0699\t\25\2\2\u0698\u0697\3\2\2\2"+
		"\u0699\u069c\3\2\2\2\u069a\u0698\3\2\2\2\u069a\u069b\3\2\2\2\u069b\u069d"+
		"\3\2\2\2\u069c\u069a\3\2\2\2\u069d\u069f\7\u00ba\2\2\u069e\u0696\3\2\2"+
		"\2\u069f\u06a0\3\2\2\2\u06a0\u069e\3\2\2\2\u06a0\u06a1\3\2\2\2\u06a1\u011f"+
		"\3\2\2\2\u06a2\u06a3\t\26\2\2\u06a3\u0121\3\2\2\2\u00e0\u0125\u0135\u013c"+
		"\u0142\u0148\u014b\u014e\u0156\u015d\u0160\u0163\u016b\u016e\u0171\u017b"+
		"\u0185\u018d\u0192\u019b\u01a1\u01a3\u01af\u01b9\u01c1\u01c4\u01c7\u01d0"+
		"\u01e7\u01ee\u01f1\u01f7\u0200\u0206\u0208\u0211\u0213\u021c\u0220\u0229"+
		"\u022b\u0234\u0238\u023b\u0243\u0247\u0249\u024c\u0252\u0256\u025c\u026a"+
		"\u0271\u0277\u027a\u027e\u0284\u0288\u0290\u0293\u029a\u02a6\u02aa\u02ac"+
		"\u02b8\u02ba\u02c6\u02c8\u02cd\u02d3\u02d6\u02dc\u02e0\u02e3\u02e6\u02f1"+
		"\u02f7\u02f9\u02fc\u0304\u0309\u030f\u0318\u031d\u031f\u0335\u033c\u0341"+
		"\u0359\u035e\u0363\u0367\u036b\u036f\u0378\u037f\u0386\u038c\u038f\u0393"+
		"\u039b\u039e\u03a2\u03aa\u03af\u03b6\u03bf\u03c3\u03cf\u03d1\u03db\u03e6"+
		"\u03ec\u03f1\u03f7\u03fb\u0400\u040a\u040c\u0414\u0422\u0435\u0437\u0443"+
		"\u0448\u044c\u0450\u0454\u045b\u0461\u046d\u0474\u0478\u047d\u0481\u0488"+
		"\u048d\u0493\u0496\u049a\u049e\u04a5\u04a9\u04ac\u04b5\u04ba\u04bf\u04c1"+
		"\u04cd\u04d1\u04d3\u04dc\u04e0\u04e4\u04e7\u04eb\u04ef\u04f5\u04f9\u04fe"+
		"\u0500\u0504\u0509\u050c\u0513\u051a\u051d\u0523\u0527\u052b\u052f\u0533"+
		"\u0537\u053b\u053f\u0543\u0547\u054a\u0553\u0558\u055a\u0566\u0569\u0575"+
		"\u057d\u0582\u058a\u0590\u0596\u05a9\u05ad\u05b1\u05ba\u05c1\u05cc\u05ce"+
		"\u05d5\u05e2\u05ef\u060a\u060e\u0610\u061c\u061e\u0623\u0627\u0630\u0637"+
		"\u0640\u0649\u064e\u0657\u065d\u065f\u0663\u066a\u066f\u0680\u0686\u068a"+
		"\u0694\u069a\u06a0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}