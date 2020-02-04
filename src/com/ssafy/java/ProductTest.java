package com.ssafy.java;

import java.util.Scanner;

public class ProductTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		int menu=1;
		ProductMgr pm = new ProductMgr();

		while(menu!=0) {
			System.out.println(" ===============================");
			System.out.println("| 원하는 기능을 입력하세요.		|");
			System.out.println("| 1. TV 추가하기			|");
			System.out.println("| 2. 냉장고 추가하기			|");
			System.out.println("| 3. 리스트 모두 검색하기		|");
			System.out.println("| 4. 상품명으로 검색하기		|");
			System.out.println("| 5. TV만 검색하기			|");
			System.out.println("| 6. 냉장고만 검색하기		|");
			System.out.println("| 7. 리스트 삭제하기			|");
			System.out.println("| 8. 저장된 제품 금액 합계 출력		|");
			System.out.println("| 0. 종료				|");
			System.out.println(" ===============================");
			menu=scan.nextInt();
			
			if(menu==1) {
				String serial, name,typeOfDisplay;
				int price, stock, size; 
				System.out.println("상품 번호를 입력해주세요.");
				serial=sc.nextLine();
				System.out.println("상품명을 입력해주세요.");
				name=sc.nextLine();
				System.out.println("가격을 입력해주세요. (숫자만)");
				price=scan.nextInt();
				System.out.println("재고를 입력해주세요. (숫자만)");
				stock=scan.nextInt();
				System.out.println("크기를 입력해주세요. (숫자만)");
				size=scan.nextInt();
				System.out.println("desc를 입력해주세요.");
				typeOfDisplay=sc.nextLine();
				pm.addTV(serial, name, price, stock, size, typeOfDisplay);
				
			}
			else if(menu==2) {
				String serial, name,typeOfDisplay;
				int price, stock, size; 
				System.out.println("상품 번호를 입력해주세요.");
				serial=sc.nextLine();
				System.out.println("상품명을 입력해주세요.");
				name=sc.nextLine();
				System.out.println("가격을 입력해주세요. (숫자만)");
				price=scan.nextInt();
				System.out.println("재고를 입력해주세요. (숫자만)");
				stock=scan.nextInt();
				System.out.println("크기를 입력해주세요. (숫자만)");
				size=scan.nextInt();
				pm.addRefrigerator(serial, name, price, stock, size);
			}
			else if(menu==3) {
				pm.showAll();
			}
			else if(menu==4) {
				String s;
				s=sc.nextLine();
				pm.showName(s);
			}
			else if(menu==5) {
				pm.showTV();
				
			}
			else if(menu==6) {
				pm.showRefrigerator();
			}
			else if(menu==7) {
				String serial;
				System.out.println("상품 번호를 입력해주세요.");
				serial=sc.nextLine();
				pm.removeProduct(serial);
			}
			else if(menu==8) {
				pm.showCost();
			}
			else {
				break;
			}

			System.out.println();
			System.out.println();
			
		}
	}

}
