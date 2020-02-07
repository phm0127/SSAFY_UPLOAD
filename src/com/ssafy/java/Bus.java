package com.ssafy.java;

public class Bus extends Car{
	private int seat;
	public Bus() {
		this("","",0,0);
	}
	public Bus(String num,String model,int price, int seat) {
		super(num,model,price);
		this.seat=seat;
	}
	public int getSeat() {
		return seat;
	}
	public void setSeat(int seat) {
		this.seat = seat;
	}
	public String toString() {
		return "Bus [num="+ super.getNum() + ", model=" + super.getModel() + ", price=" + super.getPrice() +", seat=" + seat + "]";
	}
	
}
