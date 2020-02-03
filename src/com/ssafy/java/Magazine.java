package com.ssafy.java;

public class Magazine {
	private String isbn;
	private String title;
	private String author;
	private String publisher;
	private int year;
	private int month;
	private int price;
	private String desc;
	
	public void setIsbn(String isbn) {
		this.isbn=isbn;
	}
	public void setTitle(String title) {
		this.title=title;
	}
	public void setAuthor(String author) {
		this.author=author;
	}
	public void setPublisher(String publisher) {
		this.publisher=publisher;
	}
	public void setYear(int year) {
		this.year=year;
	}
	public void setMonth(int month) {
		this.month=month;
	}
	public void setPrice(int price) {
		this.price=price;
	}
	public void setDesc(String desc) {
		this.desc=desc;
	}
	
	public String toString() {
		String str = isbn+"	|"+title+"	|"+author+"	|"+publisher+"	|"+price+"	|"+desc+"		|"+ year+"."+month;
		return str;
	}
}
