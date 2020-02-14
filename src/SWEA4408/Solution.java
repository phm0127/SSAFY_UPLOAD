package SWEA4408;

import java.util.Scanner;

public class Solution {
	static int[] path;

	static int answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T= sc.nextInt();
		
		for(int test_case =1; test_case<=T;test_case++) {
			answer = 1;
			
			int N = sc.nextInt();
			
			path=new int[200];
			int start,end;
			for(int i=0;i<N;i++) {
				start=(sc.nextInt()-1)/2;
				end=(sc.nextInt()-1)/2;
				if(start>end) {
					int temp=end;
					end=start;
					start=temp;
				}
				for(int j=start;j<=end;j++) {
					path[j]++;
				}
			}
			for(int i=0;i<200;i++) {
				answer= Math.max(answer, path[i]);
			}
			
			System.out.println("#"+test_case+" "+answer);
		}
	}
}


