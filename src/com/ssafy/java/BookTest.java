package com.ssafy.java;

import java.util.ArrayList;
import java.util.Scanner;

public class BookTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		ArrayList<Book> list;
		BookMgrlmpl Mgr = new BookMgrlmpl();

		int menu=1;

		while(menu!=0) {
			System.out.println(" ===============================");
			System.out.println("| 원하는 기능을 입력하세요.		|");
			System.out.println("| 1. 책/잡지 추가하기			|");
			System.out.println("| 2. 책 전체 검색하기			|");
			System.out.println("| 3. lsbn으로 검색하기		|");
			System.out.println("| 4. 제목으로 검색하기		|");
			System.out.println("| 5. 책만 검색하기			|");
			System.out.println("| 6. 잡지만 검색하기			|");
			System.out.println("| 7. 올해 발행된 잡지 검색		|");
			System.out.println("| 8. 출판사로 검색하기		|");
			System.out.println("| 9. 가격으로 검색하기		|");
			System.out.println("|10. 저장된 도서의 금액 합계 출력		|");
			System.out.println("|11. 저장된 도서의 금액 평균 출력		|");
			System.out.println("| 0. 종료				|");
			System.out.println(" ===============================");
			menu=scan.nextInt();

			if(menu==1) {
				int BorM;
				String lsbn,title,publisher,author,desc;
				int price,year,month;
				System.out.println("책이면 1번 잡지면 2번을 눌러주세요.");
				BorM=scan.nextInt();
				System.out.println("lsbn을 입력해주세요.");
				lsbn=sc.nextLine();
				System.out.println("제목을 입력해주세요.");
				title=sc.nextLine();
				System.out.println("저자를 입력해주세요.");
				author=sc.nextLine();
				System.out.println("출판사를 입력해주세요.");
				publisher=sc.nextLine();
				System.out.println("가격을 입력해주세요. (숫자만)");
				price=scan.nextInt();
				System.out.println("desc를 입력해주세요.");
				desc=sc.nextLine();
				if(BorM==1) {
					Book b = new Book();
					b.setIsbn(lsbn);
					b.setTitle(title);
					b.setPrice(price);
					b.setAuthor(author);
					b.setPublisher(publisher);
					b.setDesc(desc);
					Mgr.add(b);
				}
				else if(BorM==2) {
					System.out.println("출판년도를 입력해주세요.");
					year=scan.nextInt();
					System.out.println("출간월을 입력해주세요.");
					month=scan.nextInt();
					Magazine b = new Magazine();
					b.setIsbn(lsbn);
					b.setTitle(title);
					b.setPrice(price);
					b.setAuthor(author);
					b.setPublisher(publisher);
					b.setDesc(desc);
					b.setYear(year);
					b.setMonth(month);
					Mgr.add(b);
				}
			}
			else if(menu==2) {
				list=Mgr.searchAll();
				for(Book b : list) {
					System.out.println(b);
				}
			}
			else if(menu==3) {
				String s;
				System.out.println("lsbn을 입력해주세요.");
				s=sc.nextLine();
				Book b = Mgr.searchIsbn(s);
				if(b!=null) {
					System.out.println(b);
				}
				else {
					System.out.println("null");
				}
			}
			else if(menu==4) {
				String s;
				System.out.println("책 제목을 입력해주세요.");
				s=sc.nextLine();
				list=Mgr.searchTitle(s);
				for(Book b : list) {
					System.out.println(b);
				}
			}
			else if(menu==5) {
				list = Mgr.searchBook();
				for(Book b : list) {
					System.out.println(b);
				}
			}
			else if(menu==6) {
				list = Mgr.searchMagazine();
				for(Book b : list) {
					System.out.println(b);
				}
			}else if(menu==7) {
				list = Mgr.searchMagazinePublishedThisYear();
				for(Book b : list) {
					System.out.println(b);
				}
			}
			else if(menu==8) {
				String s;
				System.out.println("출판사 을 입력해주세요.");
				s=sc.nextLine();
				list=Mgr.searchByPublisher(s);
				for(Book b : list) {
					System.out.println(b);
				}

			}
			else if(menu==9) {
				int p;
				System.out.println("가격을 입력해주세요.");
				p=scan.nextInt();
				list = Mgr.searchByPrice(p);
				for(Book b : list) {
					System.out.println(b);
				}
			}
			else if(menu==10) {
				System.out.println(Mgr.totalPrice());
			}
			else if(menu==11) {
				System.out.println(Mgr.averageOfBooks());
			}
			else {
				break;
			}

			System.out.println();
			System.out.println();

		}


	}

}

