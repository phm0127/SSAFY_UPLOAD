package com.ssafy.java;

public class TV extends Product{
	private String typeOfDisplay;
	
	public TV(String serial, String name, int price, int stock,int size,String typeOfDisplay) {
		this.serial = serial;
		this.name = name;
		this.price=price;
		this.stock=stock;
		this.size = size;
		this.typeOfDisplay=typeOfDisplay;
	}
	
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
