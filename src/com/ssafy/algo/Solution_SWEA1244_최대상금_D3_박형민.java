package com.ssafy.algo;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_SWEA1244_최대상금_D3_박형민 {
	static int answer;
	static int[] arr;
	
	static Max[] max;
	static int turn;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T= Integer.parseInt(sc.next());
		for(int test_case=1;test_case<=T;test_case++) {
			String s = sc.next();
			answer=0;
			turn = Integer.parseInt(sc.next());
			arr= new int[s.length()];
			max = new Max[arr.length];
			for(int i=0;i<arr.length;i++) {
				arr[i]=(int)(s.charAt(i)-'0');
				max[i]=new Max(arr[i],i);
			}
			Arrays.sort(max);
			
			shuffle(0);
			
			
			System.out.println("#"+test_case+" "+answer);
		}
	}
	static void shuffle(int count) {
		
		
		if(count==turn) {
			int sum=0;
			for(int i=0;i<arr.length;i++) {
				sum*=10;
				sum+=arr[i];
			}
			answer = Math.max(answer, sum);
		}
		else {
			boolean flag = true;
			int indexI=0,indexJ=0,min=0;
			for(int i=0;i<arr.length;i++) {
				if(arr[i]<max[i].value) {
					int tmp = arr[i];
					for(int j=i;j<arr.length;j++) {
						if(arr[j]==max[i].value) {
							arr[i]=max[i].value;
							arr[j]=tmp;
							shuffle(count+1);
							arr[j]=arr[i];
							arr[i]=tmp;
							flag=false;
							
						}
						
					}
					
				}
				if(!flag) {
					break;
				}
				
			}
			if(flag) {
				boolean flag2 = true;
				for(int i=0;i<arr.length-1;i++) {
					if(arr[i]==arr[i+1]) {
						flag2 = false;
					}
				}
				if(flag2) {
					int tmp = arr[arr.length-2];
					arr[arr.length-2]=arr[arr.length-1];
					arr[arr.length-1]=tmp;
				}
				shuffle(count+1);
			}
		}
	}
	
	

}

class Max implements Comparable<Max>{
	int value;
	int index;
	public Max(int value, int index) {
		this.value = value;
		this.index = index;
	}
	@Override
	public int compareTo(Max o) {
		if(this.value>o.value) {
			return -1;
		}else if (this.value==o.value) {
			if(this.index<o.index) {
				return 1;
			}
			else {
				return -1;
			}
		}
		else {
			return 1;
		}
	}
}
