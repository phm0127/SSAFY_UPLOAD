package SWEA1861;

import java.util.Scanner;

public class Solution {
	static int answer=0;
	static int N;
	static int[][] map;
	static int[][] memo;
	static int[] dR= {-1,1,0,0};
	static int[] dC= {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T= sc.nextInt();
		
		for(int test_case =1; test_case<=T;test_case++) {
			answer=0;
			N= sc.nextInt();
			map = new int[N][N];
			memo=new int[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j]=sc.nextInt();
					memo[i][j]=-1;
				}
			}
			int min = Integer.MAX_VALUE;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					int tmp= cal(i,j,1);
					memo[i][j]=tmp;
					if(answer<tmp) {
							answer = tmp;
							min=map[i][j];	
					}
					else if(answer==tmp) {
						if(min>map[i][j]) {
							answer = tmp;
							min=map[i][j];	
						}
					}
				}
			}
			
			System.out.println("#"+test_case+" "+min+" "+answer);
		}
	}
	static int cal(int r, int c,int count) {
		if(memo[r][c]!=-1) {
			return memo[r][c]+count-1;
		}
		else {
			int nr,nc;
			boolean flag=true;
			for(int i=0;i<4;i++) {
				nr=r+dR[i];
				nc=c+dC[i];
				if(nr>=0&&nc>=0&&nr<N&&nc<N&&map[nr][nc]==map[r][c]+1) {
					
					return cal(nr,nc,count+1);
				}
			}
			
			
			
		}
		
		return count;
	}

}
