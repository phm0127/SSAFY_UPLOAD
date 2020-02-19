package com.ssafy.java;

public class DuplicateException extends Exception{
	String msg;
	public DuplicateException(){
		super("Duplicate Exception");
	}
	public DuplicateException(String msg){
		super(msg);
	}
}
