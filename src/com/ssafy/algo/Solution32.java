package com.ssafy.algo;

import java.util.Scanner;

public class Solution32 {
	
	static int[] dR={0,1,0,-1};
	static int[] dC={1,0,-1,0};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int test=sc.nextInt();
		for(int test_case=1;test_case<=test;test_case++) {
			int answer=0;
			int Y = sc.nextInt();
			int X = sc.nextInt();
			int N = sc.nextInt();
			int[][] map = new int[Y][X];
			
			for(int i=0;i<Y;i++) {
				for(int j=0;j<X;j++) {
					map[i][j]=sc.nextInt();
				}
			}
			int[] pC = new int[N];
			int[] pR = new int[N];
			int[] pN = new int[N];
			for(int i=0;i<N;i++) {
				pR[i]=sc.nextInt()-1;
				pC[i]=sc.nextInt()-1;
				pN[i]=sc.nextInt();
			}
			int t=sc.nextInt();
			
			for(int i=0;i<t;i++) {
				int a=sc.nextInt()-1;
				int b=sc.nextInt()-1;
				map[a][b]=0;
			}
			answer-=1000*N;
			
			for(int i=0;i<N;i++) {
				while(pN[i]>0) {
					if(pR[i]<0||pC[i]<0||pR[i]>Y-1||pC[i]>X-1) {
						//answer-=1000;
						break;
					}
					if(map[pR[i]][pC[i]]==0) {
						//answer-=1000;
						break;
					}
					
					int dir = (map[pR[i]][pC[i]]/10)-1;
					int dist = map[pR[i]][pC[i]]%10;
					
					pR[i]+= dR[dir]*dist;
					pC[i]+= dC[dir]*dist;
					pN[i]--;
					
				}
				if(pN[i]==0) {
					answer+=(map[pR[i]][pC[i]]*100);
				}
			}
			
			
			
			System.out.println("#"+test_case+" "+answer);
		}
		
	}

}
