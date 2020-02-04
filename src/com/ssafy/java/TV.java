package com.ssafy.java;

public class TV extends Product{
	private String typeOfDisplay;
	
	public void setTypeOfDisplay(String typeOfDisplay) {
		this.typeOfDisplay=typeOfDisplay;
	}
	
	public String getTypeOfDisplay() {
		return this.typeOfDisplay;
	}
	
	public String toString() {
		String str=serial+"	|"+name+"	|"+price+"	|"+stock+"	|"+size+"	|"+typeOfDisplay;
		return str;
	}
}
