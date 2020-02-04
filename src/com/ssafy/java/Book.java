package com.ssafy.java;

public class Book {
	protected String isbn;
	protected String title;
	protected String author;
	protected String publisher;
	protected int price;
	protected String desc;
	
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
	public void setPrice(int price) {
		this.price=price;
	}
	public void setDesc(String desc) {
		this.desc=desc;
	}
	
	public String getIsbn() {
		return this.isbn;
	}
	public String getTitle() {
		return this.title;
	}
	public String getAuthor() {
		return this.author;
	}
	public String getPublisher() {
		return this.publisher;
	}
	public int getPrice() {
		return this.price;
	}
	public String getDesc() {
		return this.desc;
	}
	
	public String toString() {
		String str = isbn+"	|"+title+"	|"+author+"	|"+publisher+"	|"+price+"	|"+ desc;
		return str;
	}
}
