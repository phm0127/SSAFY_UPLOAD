package com.ssafy.java;

public class Product {
	protected String serial;
	protected String name;
	protected int price;
	int stock;
	protected int size;
	
	public void setSerial(String serial) {
		this.serial=serial;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setPrice(int price) {
		this.price=price;
	}
	public void setStock(int stock) {
		this.stock=stock;
	}
	public void setSize(int size) {
		this.size=size;
	}
	
	
	public String getSerial() {
		return this.serial;
	}
	public String getName() {
		return this.name;
	}
	public int getPrice() {
		return this.price;
	}
	public int getStock() {
		return this.stock;
	}
	public int getSize() {
		return this.size;
	}
	
}
