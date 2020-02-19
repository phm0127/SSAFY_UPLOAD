package com.ssafy.java;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductTest {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		int menu=1;
		ArrayList<Product> list;
		ProductMgrlmpl pm = new ProductMgrlmpl();

		while(menu!=0) {
			System.out.println(" ===============================");
			System.out.println("| 원하는 기능을 입력하세요.		|");
			System.out.println("| 1. TV 추가하기			|");
			System.out.println("| 2. 냉장고 추가하기			|");
			System.out.println("| 3. 리스트 모두 검색하기		|");
			System.out.println("| 4. 제품번호로 검색하기		|");
			System.out.println("| 5. 제품명으로 검색하기		|");
			System.out.println("| 6. TV만 검색하기			|");
			System.out.println("| 7. 냉장고만 검색하기		|");
			System.out.println("| 8. 400L 이상의 냉장고 검색하기	|");
			System.out.println("| 9. 50인치 이상의 TV 검색하기		|");
			System.out.println("|10. 제품 번호로 가격 변경하기		|");
			System.out.println("|11. 리스트 삭제하기			|");
			System.out.println("|12. 저장된 제품 금액 합계 출력		|");
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
				System.out.println("디스플레이 타입을 입력해주세요.");
				typeOfDisplay=sc.nextLine();
				pm.add(new TV(serial, name, price, stock, size, typeOfDisplay));
				
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
				pm.add(new Refrigerator(serial, name, price, stock, size));
			}
			else if(menu==3) {
				list=pm.searchAll();
				for(Product p : list) {
					System.out.println(p);
				}
			}
			else if(menu==4) {
				String s;
				Product ret;
				s=sc.nextLine();
				ret=pm.searchID(s);
				System.out.println(ret);
				
			}
			else if(menu==5) {
				String s;
				s=sc.nextLine();
				list=pm.searchName(s);
				for(Product p : list) {
					System.out.println(p);
				}
				
			}
			else if(menu==6) {
				list=pm.searchTV();
				for(Product p : list) {
					System.out.println(p);
				}
				
			}
			else if(menu==7) {
				list=pm.searchRefrigerator();
				for(Product p : list) {
					System.out.println(p);
				}
			}
			else if(menu==8) {
				list=pm.searchRefrigeratorOver400L();
				for(Product p : list) {
					System.out.println(p);
				}
			}
			else if(menu==9) {
				list=pm.searchTVOver50Inch();
				for(Product p : list) {
					System.out.println(p);
				}
			}
			else if(menu==10) {
				String s;
				s=sc.nextLine();
				int price = scan.nextInt();
				pm.setPriceWithID(s, price);
				
			}
			else if(menu==11) {
				String s;
				s=sc.nextLine();
				pm.deleteWithID(s);
			}
			else if(menu==12) {
				System.out.println(pm.totalPrice());
			}
			else {
				pm.save();
				break;
			}

			System.out.println();
			System.out.println();
			
		}
	}

}
