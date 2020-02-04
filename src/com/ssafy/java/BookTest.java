package com.ssafy.java;

import java.util.ArrayList;
import java.util.Scanner;

public class BookTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
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

		ArrayList<Book> list = new ArrayList<Book>();
//		list.add(book1);
//		list.add(book2);
//		list.add(magazine1);
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
			System.out.println("| 7. 출판사로 검색하기		|");
			System.out.println("| 8. 가격으로 검색하기		|");
			System.out.println("| 9. 저장된 도서의 금액 합계 출력		|");
			System.out.println("|10. 저장된 도서의 금액 평균 출력		|");
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
					list.add(b);
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
					list.add(b);
				}
			}
			else if(menu==2) {
				for(Book b : list) {
					System.out.println(b);
				}
			}
			else if(menu==3) {
				String s;
				boolean flag=true;
				System.out.println("lsbn을 입력해주세요.");
				s=sc.nextLine();
				for(Book b : list) {
					if(b.getIsbn().equals(s)) {
						System.out.println(b);
						flag=false;
					}
				}
				if(flag) {
					System.out.println("리스트에 lsbn가 "+s+"인 책은 없습니다.");
				}
			}
			else if(menu==4) {
				boolean flag=true;
				String s;
				System.out.println("책 제목을 입력해주세요.");
				s=sc.nextLine();
				for(Book b : list) {
					if(b.getTitle().equals(s)) {
						System.out.println(b);
						flag=false;
					}
				}
				if(flag) {
					System.out.println("리스트에 제목이 "+s+"인 책은 없습니다.");
				}
			}
			else if(menu==5) {
				
				boolean flag=true;
				for(Book b : list) {
					if(!(b instanceof Magazine)) {
						System.out.println(b);
						flag=false;
					}
				}
				if(flag) {
					System.out.println("리스트에 책은 없습니다.");
				}
			}
			else if(menu==6) {
				boolean flag=true;
				for(Book b : list) {
					if((b instanceof Magazine)) {
						System.out.println(b);
						flag=false;
					}
				}
				if(flag) {
					System.out.println("리스트에 잡지는 없습니다.");
				}
			}
			else if(menu==7) {
				String s;
				boolean flag=true;
				System.out.println("출판사 을 입력해주세요.");
				s=sc.nextLine();
				for(Book b : list) {
					if(b.getPublisher().equals(s)) {
						System.out.println(b);
						flag=false;
					}
				}
				if(flag) {
					System.out.println("리스트에 출판사가 "+s+"인 책은 없습니다.");
				}
			}
			else if(menu==8) {
				int p;
				boolean flag=true;
				System.out.println("가격을 입력해주세요.");
				p=scan.nextInt();
				for(Book b : list) {
					if(b.getPrice()==p) {
						System.out.println(b);
						flag=false;
					}
				}
				if(flag) {
					System.out.println("리스트에 가격이 "+p+"원 인 책은 없습니다.");
				}
			}
			else if(menu==9) {
				if(!list.isEmpty()) {
					int sum=0;
					for(Book b : list) {
						sum+=b.getPrice();
					}
					System.out.println("리스트에 저장된 도서의 금액 합계는 총 "+sum+"원입니다.");
				}
				else {
					System.out.println("리스트에 책이 하나도 없습니다.");
				}
			}
			else if(menu==10) {
				if(!list.isEmpty()) {
					int avg=0;
					for(Book b : list) {
						avg+=b.getPrice();
					}
					avg/=list.size();
					System.out.println("리스트에 저장된 도서의 금액 합계는 총 "+avg+"원입니다.");
				}
				else {
					System.out.println("리스트에 책이 하나도 없습니다.");
				}
			}
			else {
				break;
			}

			System.out.println();
			System.out.println();
			
		}


	}

}

