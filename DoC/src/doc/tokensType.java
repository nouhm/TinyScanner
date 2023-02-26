/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doc;

/**
 *
 * @author youse
 */
public enum tokensType {
	IF, //if
	THEN, // then
	ELSE, // else
	ADDITION_OPERATOR, // +
	SUBRACT_OPERATOR, // -
	MULTIPLICATION_OPERATOR, // *
	DIVISION_OPERATOR, // /
	EQUAL_OPERATOR,  // =
	SEMICOLON_OPERATOR,  // ;
	ASSIGN_OPERATOR,   // :=
	IDENTIFIER,  // variable name
	NUMBER,  // number
	ERROR, // none
	COMMENT, // { }
	LT_OPERATOT, // < 
        GT_OPERATOR, // >
	END,  // closing if
	REPEAT, // do
	UNTIL,  // + while
	READ,   // input
	WRITE,  // output
        OPEN_BRACKET, // (
        CLOSE_BRACKET; // )
}