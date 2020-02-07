package com.ssafy.java;

public class CarTest {
	public static void main(String[] args) {
		CarMgr l = new CarMgr();
		System.out.println("Test---------------------------");
		System.out.println("add('1','a',100)");
		System.out.println("add('2','b',200)");
		System.out.println("add('3','c',300)");
		System.out.println("add('4','d',400)");
		System.out.println("-------------------------------");
		Car c= new Car("1","a",100);
		l.add(c);
		c= new Car("2","b",200);
		l.add(c);
		c= new Car("3","c",300);
		l.add(c);
		c= new Car("4","d",400);
		l.add(c);
		Car[] t;
		t=l.search();
		System.out.println("search()-----------------------");
		for(int i=0;i<l.size();i++) {
			System.out.println(t[i].toString());
		}
		System.out.println("-------------------------------");
		System.out.println("search('1')--------------------");
		c = l.search("1");
		System.out.println(c.toString());
		System.out.println("-------------------------------");
		Car[] t2;
		t2=l.search(250);
		System.out.println("search(250)--------------------");
		for(int i=0;i<t2.length;i++) {
			System.out.println(t2[i].toString());
		}
		System.out.println("-------------------------------");
		l.update("2", 250);
		System.out.println("update('2',250) & search()-----");
		for(int i=0;i<l.size();i++) {
			System.out.println(t[i].toString());
		}
		System.out.println("-------------------------------");
		l.delete("3");
		System.out.println("delete('3') & search()---------");
		for(int i=0;i<l.size();i++) {
			System.out.println(t[i].toString());
		}
		System.out.println("-------------------------------");
		System.out.println("size()-------------------------");
		System.out.println(l.size());
		System.out.println("-------------------------------");
		System.out.println("totalPrice()-------------------");
		System.out.println(l.totalPrice());
		System.out.println("-------------------------------");
		
		Bus b = new Bus("10","bus1",1000,25);
		System.out.println("Bus----------------------------");
		System.out.println(b.toString());
		System.out.println("-------------------------------");
		Truck tr = new Truck("10","bus1",1000,2);
		System.out.println("Trcuk--------------------------");
		System.out.println(tr.toString());
		System.out.println("-------------------------------");

		
		
	}
}
