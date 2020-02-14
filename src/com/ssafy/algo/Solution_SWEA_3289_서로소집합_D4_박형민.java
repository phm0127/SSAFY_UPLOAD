package com.ssafy.algo;

import java.util.Scanner;

public class Solution_SWEA_3289_서로소집합_D4_박형민 {
	static int n,m;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1 ; test_case<=T; test_case++) {
			n=sc.nextInt();
			int[] hash = new int[n+1];
			int[] rank = new int[n+1];
			for(int i=0;i<=n;i++) {
				hash[i]= i;
				rank[i]= 1;
			}
			
			System.out.print("#"+test_case+" ");
			m=sc.nextInt();
			for(int i=0;i<m;i++) {
				int o = sc.nextInt();
				int a = sc.nextInt();
				int b = sc.nextInt();
				int keyA=a;
				int keyB=b;
				while(true) {
					if(keyA==hash[keyA]) {
						break;
					}
					keyA = hash[keyA];
				}
				while(true) {
					if(keyB==hash[keyB]) {
						break;
					}
					keyB = hash[keyB];
				}
				
				if(o==0) {
					if(rank[keyA]>rank[keyB]) {
						hash[keyB]= keyA;
					}
					else if(rank[keyA]<rank[keyB]) {
						hash[keyA]= keyB;
					}
					else {
						hash[keyA]= keyB;
						rank[keyA]= rank[keyA]+1;
					}
				}
				else {
					if(keyA==keyB) {
						System.out.print(1);
					}
					else {
						System.out.print(0);
					}
				}
				
			}
			System.out.println();
			
		}
	}
	
	

}
