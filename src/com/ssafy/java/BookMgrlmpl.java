package com.ssafy.java;

import java.util.ArrayList;

public class BookMgrlmpl implements IBookMgr {
	ArrayList<Book> list = new ArrayList<Book>();
	int THIS_YEAR = 2020;
	
	@Override
	public void add(Book b) {
		list.add(b);
		
	}
	@Override
	public ArrayList<Book> searchAll() {
		
		return list;
	}
	@Override
	public Book searchIsbn(String isbn) {
		Book ret = null;
		for(Book b : list) {
			if(b.getIsbn().equals(isbn)) {
				ret=b;
				break;
			}
		}

		return ret;
	}
	@Override
	public ArrayList<Book> searchTitle(String title) {
		ArrayList<Book> ret = new ArrayList<>();
		for(Book b : list) {
			if(b.getTitle().contains(title)) {
				ret.add(b);
			}
		}
		return ret;
	}
	@Override
	public ArrayList<Book> searchBook() {
		ArrayList<Book> ret = new ArrayList<>();
		for(Book b : list) {
			if(!(b instanceof Magazine)) {
				ret.add(b);
			}
		}
		return ret;
	}
	@Override
	public ArrayList<Book> searchMagazine() {
		ArrayList<Book> ret = new ArrayList<>();
		for(Book b : list) {
			if((b instanceof Magazine)) {
				ret.add(b);
			}
		}
		return ret;
	}
	@Override
	public ArrayList<Book> searchMagazinePublishedThisYear() {
		ArrayList<Book> ret = new ArrayList<>();
		Magazine m;
		for(Book b : list) {
			if((b instanceof Magazine)) {
				m=(Magazine)b;
				if(m.getYear()==THIS_YEAR) {
					ret.add(b);
				}
			}
		}
		return ret;
	}
	@Override
	public ArrayList<Book> searchByPublisher(String publisher) {
		ArrayList<Book> ret = new ArrayList<>();
		for(Book b : list) {
			if(b.getPublisher().equals(publisher)) {
				ret.add(b);
			}
		}
		return ret;
	}
	@Override
	public ArrayList<Book> searchByPrice(int price) {
		ArrayList<Book> ret = new ArrayList<>();
		for(Book b : list) {
			if(b.getPrice()==price) {
				ret.add(b);
			}
		}
		return ret;
	}
	@Override
	public int totalPrice() {
		int sum=0;
		for(Book b : list) {
			sum+=b.getPrice();
		}
		return sum;
	}
	@Override
	public int averageOfBooks() {
		int avg=0;
		for(Book b : list) {
			avg+=b.getPrice();
		}
		avg/=list.size();
		return avg;
	}
	
}