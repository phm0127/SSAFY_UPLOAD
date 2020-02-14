package SWEA1258;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
	static int N;
	static int[][] arr;
	static boolean[][] check;
	static int[] dR= {1,0};
	static int[] dC= {0,1};
	static ArrayList<Square> list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T= sc.nextInt();
		
		for(int test_case =1; test_case<=T;test_case++) {
			
			N= sc.nextInt();
			arr =new int[N][N];
			check = new boolean[N][N];
			list =new ArrayList<Square>();
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					arr[i][j]=sc.nextInt();
				}
			}
			
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(!check[i][j]&&arr[i][j]!=0) {
						cal(i,j);
						check[i][j]=true;
					}
					
				}
			}
			Collections.sort(list);
			
			System.out.print("#"+test_case+" "+list.size());
			for(Square s : list) {
				System.out.print(" "+s.h+" "+s.w);
			}
			System.out.println();
		}

	}
	
	static void cal(int r, int c) {
		int w=0,h=0;
		int or=r,oc=c;
		while(true) {
			if(r>=N) {
				break;
			}
			if(arr[r][c]==0||check[r][c]) {
				break;
			}
			check[r][c]=true;
			r+=1;
			h++;
		}
		check[or][oc]=false;
		while(true) {
			if(c>=N) {
				break;
			}
			if(arr[or][c]==0||check[or][c]) {
				break;
			}
			check[or][c]=true;
			c+=1;
			w++;
			
		}
		for(int i=or;i<r;i++) {
			for(int j=oc;j<c;j++) {
				check[i][j]=true;
			}
		}
		
		list.add(new Square(w,h));
	}

}

class Square implements Comparable<Square>{
	int w;
	int h;
	Square(int w,int h){
		this.w=w;
		this.h=h;
	}
	@Override
	public int compareTo(Square o) {
		if(w*h>o.w*o.h) {
			return 1;
		}
		else if(w*h<o.w*o.h) {
			return -1;
		}else {
			if(w>o.w) {
				return -1;
			}
			else {
				return 1;
			}
		}
	}
}
