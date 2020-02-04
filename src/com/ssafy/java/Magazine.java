package com.ssafy.java;

public class Magazine extends Book{
	private int year;
	private int month;
	
	
	
	public void setYear(int year) {
		this.year=year;
	}
	public void setMonth(int month) {
		this.month=month;
	}
	public int getYear() {
		return this.year;
	}
	public int getMonth() {
		return this.month;
	}
	
	
	public String toString() {
		String str = isbn+"	|"+title+"	|"+author+"	|"+publisher+"	|"+price+"	|"+desc+"		|"+ year+"."+month;
		return str;
	}
}
