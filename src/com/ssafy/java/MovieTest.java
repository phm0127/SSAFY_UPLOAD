package com.ssafy.java;

import java.util.Scanner;

public class MovieTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int menu=-1;
		MovieMgr ml = new MovieMgr();
		Movie[] l;
		while(true) {
			if(menu==0) {
				break;
			}
			menu=-1;
			System.out.println("<<< 영화 관리 프로그램 >>>");
			System.out.println(" 1. 영화 정보 입력");
			System.out.println(" 2. 영화 정보 전체 검색");
			System.out.println(" 3. 영화명 검색");
			System.out.println(" 4. 영화 장르별 검색");
			System.out.println(" 5. 영화 정보 삭제");
			System.out.println(" 0. 종료");
			System.out.println(" 원하는 번호를 고르세요.");
			String a= sc.nextLine();
			menu= a.charAt(0)-'0';
			if(menu==1) {
				String title,director,genre;
				System.out.println("입력할 영화의 제목을 쓰세요.");
				title=sc.nextLine();
				System.out.println("입력할 영화의 감독을 쓰세요.");
				director=sc.nextLine();
				System.out.println("입력할 영화의 장르를 쓰세요.");
				genre=sc.nextLine();
				Movie m = new Movie(title,director,0,genre);
				ml.add(m);
				
			}
			else if(menu==2) {
				l=ml.search();
				for(int i=0;i<ml.size();i++) {
					System.out.println(l[i].toString());
				}
				if(ml.size()==0) {
					System.out.println("등록된 영화가 없습니다.");
				}
			}
			else if(menu==3) {
				System.out.println("찾을 영화 제목을 입력하세요");
				String s = sc.nextLine();
				l=ml.search(s);
				for(int i=0;i<l.length;i++) {
					System.out.println(l[i].toString());
				}
				if(l.length==0) {
					System.out.println("찾는 영화가 없습니다.");
				}
			}
			else if(menu==4) {
				System.out.println("찾을 영화 장르를 입력하세요.");
				String s = sc.nextLine();
				l=ml.searchGenre(s);
				for(int i=0;i<l.length;i++) {
					System.out.println(l[i].toString());
				}
				if(l.length==0) {
					System.out.println("찾는 영화가 없습니다.");
				}
			}
			else if(menu==5) {
				System.out.println("지울 영화 제목을 입력하세요");
				String s = sc.nextLine();
				ml.delete(s);
			}
			else {
				break;
			}
		}
	}

}
