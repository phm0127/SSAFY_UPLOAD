package com.ssafy.java;

public class Refrigerator extends Product{
	public Refrigerator(String serial, String name, int price ,int stock, int size) {
		this.serial=serial;
		this.name=name;
		this.price=price;
		this.stock=stock;
		this.size=size;
	}
	public String toString() {
		String str=serial+"	|"+name+"	|"+price+"	|"+stock+"	|"+size;
		return str;
	}
}
