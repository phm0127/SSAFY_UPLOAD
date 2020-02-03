package com.ssafy.java;

public class BookTest {

	public static void main(String[] args) {
		Book book1 = new Book();
		Book book2 = new Book();
		Magazine magazine1 = new Magazine();
		
		book1.setIsbn("21424");
		book1.setTitle("Java Pro");
		book1.setAuthor("김하나");
		book1.setPublisher("Jaen.kr");
		book1.setPrice(15000);
		book1.setDesc("Java 기본 문법");
		
		book2.setIsbn("35355");
		book2.setTitle("분석 설계	");
		book2.setAuthor("소나무");
		book2.setPublisher("Jaen.kr");
		book2.setPrice(30000);
		book2.setDesc("SW 모델링");
		
		magazine1.setIsbn("35535");
		magazine1.setTitle("Java World");
		magazine1.setAuthor("편집부");
		magazine1.setPublisher("java.com");
		magazine1.setPrice(7000);
		magazine1.setDesc("첫 걸음");
		magazine1.setYear(2018);
		magazine1.setMonth(2);
		
		System.out.println("********************* 도서 목록 *********************");
		System.out.println(book1);
		System.out.println(book2);
		System.out.println(magazine1);
		
	}

}
