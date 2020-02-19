package com.ssafy.java;

public class CodeNotFoundException extends Exception{
public CodeNotFoundException() {
		super("Code Not Found Exception.");
	}
	public CodeNotFoundException(String msg) {
		super(msg);
	}
}
