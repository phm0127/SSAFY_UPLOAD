package com.ssafy.java;

public class Car {
	private String num;
	private String model;
	private int price;
	
	
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	
	public Car() {
		this("","",0);
	}
	public Car(String num, String model, int price) {
		this.num=num;
		this.model=model;
		this.price=price;
	}
	
	public String getNum() {
		return this.num;
	}
	
	public void setNum(String num) {
		this.num=num;
	}
	
	public String toString() {
		
		return "Car [num=" + this.num + ", model=" + this.model + ", price=" + this.price + "]";
	}
	
}
