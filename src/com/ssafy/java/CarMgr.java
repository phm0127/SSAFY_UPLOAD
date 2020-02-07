package com.ssafy.java;

public class CarMgr {
	private static Car[] cars = new Car[100];
	private int index=0;
	
	public void add(Car c) {
		cars[index]=c;
		index++;
	}
	
	public Car[] search() {
		return cars;
	}
	
	public Car search(String num) {
		Car c=null;
		for(int i=0;i<index;i++) {
			if(cars[i].getNum().equals(num)) {
				c=cars[i];
				break;
			}
		}
		
		return c;
	}
	
	public Car[] search(int price) {
		int count=0;
		for(int i=0;i<index;i++) {
			if(cars[i].getPrice()<price) {
				count++;
			}
		}
		Car[] newlist=new Car[count];
		count=0;
		for(int i=0;i<index;i++) {
			if(cars[i].getPrice()<price) {
				newlist[count++]=cars[i];
			}
		}
		
		return newlist;
	}
	public void update(String num,int price) {
		for(int i=0;i<index;i++) {
			if(cars[i].getNum().equals(num)) {
				cars[i].setPrice(price);
			}
		}
	}
	
	public void delete(String num) {
		int tmpIndex=-1;
		for(int i=0;i<index-1;i++) {
			if(cars[i].getNum().equals(num)) {
				tmpIndex=i;
				break;
			}
		}
		if(tmpIndex>=0) {
			for(int i=tmpIndex;i<index-1;i++) {
				cars[i]=cars[i+1];
			}
			index--;
		}
	}
	
	public int size() {
		return index;
	}
	
	public int totalPrice() {
		int total=0;
		for(int i=0;i<index;i++) {
			total+=cars[i].getPrice();
		}
		return total;
	}
	
	
}
