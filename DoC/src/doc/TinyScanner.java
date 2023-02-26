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
import java.util.*;

public class TinyScanner {
	public int line;
        String buffer = "";
        boolean eoi = false;
	Cases current = Cases.START;
	ArrayList<Tokens> tokens;
	String tinyInput;
	int currentChar = 0;
	boolean comment = false;
	
	char nextChar() {
		char ch=this.tinyInput.charAt(this.currentChar++);
                this.buffer = this.buffer + ch;
		return ch;
	}

	void prevChar() {
		this.currentChar--;
                this.buffer = this.buffer.substring(0,this.buffer.length()-1);
		// return one step behind
	}
	
	// check input 
        public void clearBuffer(){
            this.buffer = "";
        }

        public TinyScanner(String tinyInput) {
            this.tokens = new ArrayList<Tokens>();
            this.tinyInput = tinyInput.trim();
        }
        
	private boolean hasMoreChars(){

		this.eoi = !( this.currentChar < this.tinyInput.length() );
		return !this.eoi;
	}
	// clear storage
	
	tokensType tokenCases (Cases tinyCase) {
		tokensType token;
		switch(tinyCase) {
		
		case INASSIGN:
			token = tokensType.ASSIGN_OPERATOR;
			break;
		case INID:
			token = tokensType.IDENTIFIER;
			break;
		case INNUM:
			token = tokensType.NUMBER;
			break;
		default:
			token = tokensType.ERROR;
		}
		return token;
	}

	tokensType tokenChar( char ch ){

		tokensType token;

		switch( ch ){

		case '=':
			token=tokensType.EQUAL_OPERATOR;
			break;

		case '<':
			token=tokensType.LT_OPERATOT;
			break;
                        
                case '>':
			token=tokensType.GT_OPERATOR;
			break;      
                      
		case '+':
			token=tokensType.ADDITION_OPERATOR;
			break;

		case '-':
			token=tokensType.SUBRACT_OPERATOR;
			break;

		case '*':
			token=tokensType.MULTIPLICATION_OPERATOR;
			break;

		case '/':
			token=tokensType.DIVISION_OPERATOR;
			break;

		case '(':
			token=tokensType.OPEN_BRACKET;
			break;

		case ')':
			token=tokensType.CLOSE_BRACKET;
			break;

		case ';':
			token=tokensType.SEMICOLON_OPERATOR;
			break;

		default:
			token=tokensType.ERROR;
		}

		return token;
	}

	Tokens nextToken() {
		tokensType token= tokensType.ERROR;
		while( this.current != Cases.DONE && !this.eoi ){
			if( this.hasMoreChars() ){
				char ch = this.nextChar();
				switch( this.current ){

				case START:
					//initial state
					if( Character.isDigit( ch ) ){

						this.current = Cases.INNUM;

					} else if( Character.isLetter( ch ) ){

						this.current = Cases.INID;

					} else if( Character.isWhitespace( ch ) ){

						if( ch == '\n' )
							this.line++;
						this.clearBuffer();

					} else if( ch == ':' ){

						this.current = Cases.INASSIGN;

					} else if( ch == '{' ){

						this.current = Cases.INCOMMENT;
						this.comment = true;
						this.clearBuffer();

					} else {

						this.current = Cases.DONE;
						token = this.tokenChar( ch );
					}

					break;

				case INCOMMENT:

					if( ch == '}' ){

						this.current = Cases.DONE;
						this.comment = false;
						token = tokensType.COMMENT;

					} else if( ch == '\n' )
						this.line++;

					break;

				case INID:

					if( !Character.isLetter( ch ) ){

						if( Character.isDigit( ch ) ){

							this.current = Cases.DONE;
							token = tokensType.ERROR;
							break;
						}

						this.prevChar();
						this.current = Cases.DONE;
						token = tokensType.IDENTIFIER;
					}

					break;

				case INNUM:

					if( !Character.isDigit( ch ) ){

						if( Character.isLetter( ch ) ){

							this.current = Cases.DONE;
							token = tokensType.ERROR;
							break;
						}

						this.prevChar();
						this.current = Cases.DONE;
						token = tokensType.NUMBER;
					}

					break;

				case INASSIGN:

					if( ch == '=' ){

						token = tokensType.ASSIGN_OPERATOR;

					} else {

						this.prevChar();
						token=tokensType.ERROR;
					}

					this.current = Cases.DONE;
					break;
				default:
					break;
				}	
			}
                }
	
	
	Tokens token2 = null;

	if( this.current == Cases.DONE )
		token2 = new Tokens( token, this.buffer, this.line );

	else if( !this.buffer.isEmpty() )
		token2 = new Tokens( this.tokenCases(this.current ), this.buffer, this.line );

	this.current = Cases.START;
	this.clearBuffer();
	return token2;
	}
	
	public ArrayList<Tokens> analyze(){

		Tokens token = this.nextToken();

		while( token != null ){

			if( token.getToken() != tokensType.COMMENT )
				this.tokens.add( token );
			token = this.nextToken();
		}

		return this.tokens;
	}

	
	//Print out all tokens with their description.
        @Override
		public String toString(){
			String string = "All Tokens: " + this.tokens.size() + "\n\n";
			for( Tokens thisToken : this.tokens )
				string += thisToken.toString() + "\n";
			return string;
		}
}
