package main.java.text;

public enum TokenType {
	Identifier,
	SingleQuotedStr,
	DoubleQuotedStr,
	Whitespace,
	Operator,
	Comment,
	Variable,
	// = < > >> | ;
	Newline,
	Error,
}