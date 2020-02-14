package SWEA1873;

import java.util.Scanner;

public class Solution {
	static char [][] map;
	static int answer;
	static int N;
	static int M;
	static int[] dR = {-1,1,0,0};
	static int[] dC = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T= sc.nextInt();

		for(int test_case =1; test_case<=T;test_case++) {
			
			
			N = sc.nextInt();
			M = sc.nextInt();
			
			map = new char[N][M];
			int r=0,c=0,dir=0;
			for(int i=0;i<N;i++) {
				String str = sc.next();
				for(int j=0;j<M;j++) {
					map[i][j]=str.charAt(j);
					if(map[i][j]=='<') {
						r=i;
						c=j;
						dir=2;
					}
					else if(map[i][j]=='^') {
						r=i;
						c=j;
						dir=0;
					}else if(map[i][j]=='>') {
						r=i;
						c=j;
						dir=3;
					}else if(map[i][j]=='v') {
						r=i;
						c=j;
						dir=1;
					}
				}
			}
			int num = sc.nextInt();
			String order=sc.next();
			for(int i=0;i<num;i++) {
				if(order.charAt(i)=='U') {
					if(r-1>=0&&map[r-1][c]=='.') {
						map[r][c]='.';
						r=r-1;
					}
					map[r][c]='^';
					dir=0;
				}
				else if(order.charAt(i)=='D') {
					if(r+1<N&&map[r+1][c]=='.') {
						map[r][c]='.';
						r=r+1;
					}
					map[r][c]='v';
					dir=1;
				}
				else if(order.charAt(i)=='R') {
					if(c+1<M&&map[r][c+1]=='.') {
						map[r][c]='.';
						c=c+1;
					}
					map[r][c]='>';
					dir=3;
				}
				else if(order.charAt(i)=='L') {
					if(c-1>=0&&map[r][c-1]=='.') {
						map[r][c]='.';
						c=c-1;
					}
					map[r][c]='<';
					dir=2;
				}else if(order.charAt(i)=='S') {
					int nr=r,nc=c;
					while(true) {
						nr=nr+dR[dir];
						nc=nc+dC[dir];
						if(nr<0||nc<0||nr>N-1||nc>M-1) {
							break;
						}
						else if(map[nr][nc]=='#') {
							break;
						}
						else if(map[nr][nc]=='*') {
							map[nr][nc]='.';
							break;
						}
					}
				}
			}
			
			
			

			System.out.print("#"+test_case+" ");
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
				
		}
	}

}
