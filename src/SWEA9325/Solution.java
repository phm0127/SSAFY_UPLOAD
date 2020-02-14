package SWEA9325;

import java.util.Scanner;

public class Solution {
	static long answer=0;
	static long[] discount;
	static int D;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			answer=0;
			int N=sc.nextInt();
			long P=sc.nextLong();
			D=sc.nextInt();
			if(N>D) {
				discount= new long[N-D];	
				int[] arr = new int[N];
				for (int i = 0; i < N; i++) {
					arr[i]=sc.nextInt();
				}
				
				cal(arr,D);
				buy(arr,0,0,P,0,false);
				answer+=D;
				
				System.out.println("#"+test_case+" "+answer);
			}
			else {
				System.out.println("#"+test_case+" "+N);
			}
			
		}
		
	}
	static void cal(int[] arr,int D) {
		for(int i=0;i<discount.length;i++) {
			for(int j=i;j<i+D;j++) {
				discount[i]+=arr[j];
			}
		}
	}
	static void buy(int[]arr, int index,int select, long money,int count,boolean bs) {
		if(money<0) {
			
		}
		else if(index>=arr.length) {
			answer = Math.max(answer, count);
		}
		else {
			if(bs) {
				buy(arr,index+1,select,money,count,bs);
				buy(arr,index+1,select,money-arr[index],count+1,bs);
			}
			else if(!bs) {
				buy(arr,index,select+1,money-arr[index],count,bs);
				if(select<D) {
					buy(arr,index,select,money+discount[select],count,!bs);
				}
			}
		}
	}

}

