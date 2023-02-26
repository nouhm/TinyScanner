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
public class Tokens{
	private tokensType token;
	private String string;
	private int line=0;
	
	public Tokens(tokensType token , String string) {
		this.token = token;
		this.string = string;
		
		if(token == tokensType.IDENTIFIER)
			this.determineType();
	}

	public Tokens( tokensType token, String string, int line ){

		this(token , string );
		this.line = line;
	}
	
	private void determineType(){

		if( this.string.equals( "if" ) )
			this.token = tokensType.IF;

		else if( this.string.equals( "then" ) )
			this.token= tokensType.THEN;

		else if( this.string.equals( "else" ) )
			this.token= tokensType.ELSE;

		else if( this.string.equals( "end" ) )
			this.token= tokensType.END;

		else if( this.string.equals( "read" ) )
			this.token = tokensType.READ;

		else if( this.string.equals( "write" ) )
			this.token = tokensType.WRITE;

		else if( this.string.equals( "repeat" ) )
			this.token = tokensType.REPEAT;

		else if( this.string.equals( "until" ) )
			this.token = tokensType.UNTIL;
	}
	
	public String toString() {
		return  this.string + " : \t" + this.token ;
	}
	
	public tokensType getToken() {
		return this.token;
	}
	public String getString() {
		return this.string;
	}
	public int getLine() {
		return this.line;
	}



}