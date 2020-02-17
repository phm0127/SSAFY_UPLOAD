package com.ssafy.java;

import java.util.ArrayList;

public class ProductMgr {
	protected ArrayList<Product> list;
	
	
	public ProductMgr() {
		this.list = new ArrayList<Product>();
	}
	
	public void addTV(String serial,String name,int price,int stock,int size,String typeOfDisplay) {
		TV tv = new TV(serial,name,price,stock,size,typeOfDisplay);
		
		
		list.add(tv);
	}
	
	public void addRefrigerator(String serial,String name,int price,int stock,int size) {
		Refrigerator refrigerator = new Refrigerator(serial,name,price,stock,size);
		
		list.add(refrigerator);
	}
	
	public void showAll() {
		for(Product p : list) {
			System.out.println(p);
		}
		if(list.isEmpty()) {
			System.out.println("리스트가 비어있습니다.");
		}
	}
	
	public void showSerial(String serial) {
		boolean flag=true;
		for(Product p : list) {
			if(p.getSerial().equals(serial)) {
				System.out.println(p);
				flag=false;
			}
		}
		if(flag) {
			System.out.println("리스트에 상품 번호가 "+serial+"인 제품이 없습니다.");
		}
	}
	
	public void showName(String name) {
		boolean flag=true;
		for(Product p : list) {
			if(p.getName().contains(name)) {
				System.out.println(p);
				flag=false;
			}
		}
		if(flag) {
			System.out.println("리스트에 상품명이 "+name+"인 제품이 없습니다.");
		}
	}
	
	
	public void showTV() {
		boolean flag=true;
		for(Product p : list) {
			if(p instanceof TV) {
				System.out.println(p);
				flag=false;
			}
		}
		if(flag) {
			System.out.println("리스트에 TV가 없습니다.");
		}
	}
	
	public void showRefrigerator() {
		boolean flag=true;
		for(Product p : list) {
			if(p instanceof Refrigerator) {
				System.out.println(p);
				flag=false;
			}
		}
		if(flag) {
			System.out.println("리스트에 냉장고가 없습니다.");
		}
	}
	
	public void removeProduct(String serial) {
		boolean flag=true;
		int index=0;
		for(Product p : list) {
			if(p.getSerial().equals(serial)) {
				flag=false;
				break;
			}
			index++;
		}
		if(flag) {
			System.out.println("리스트에 상품 번호가 "+serial+"인 제품이 없습니다.");
		}
		else {
			list.remove(index);
		}
	}
	
	public void showCost() {
		int sum=0;
		for(Product p : list) {
			sum+=p.getPrice()*p.getStock();
		}
		if(list.isEmpty()) {
			System.out.println("리스트가 비어있습니다.");
		}else {
			System.out.println("리스트 내 재고의  총 가격은 "+sum+"원 입니다.");
		}
	}
	
	
}
