package com.ssafy.java;

import java.util.ArrayList;

public interface IBookMgr {
	public void add(Book b);
	public ArrayList<Book> searchAll();
	public Book searchIsbn(String isbn);
	public ArrayList<Book> searchTitle(String title);
	public ArrayList<Book> searchBook();
	public ArrayList<Book> searchMagazine();
	public ArrayList<Book> searchMagazinePublishedThisYear();
	public ArrayList<Book> searchByPublisher(String publisher);
	public ArrayList<Book> searchByPrice(int price);
	public int totalPrice();
	public int averageOfBooks();
	
}
