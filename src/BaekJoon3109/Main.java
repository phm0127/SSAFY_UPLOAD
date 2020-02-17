package BaekJoon3109;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[] dR = {-1,0,1};
	static int[] dC = {1,1,1};
	static int R;
	static int C;
	static char[][] map;
	static boolean flag;
	static int answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R=sc.nextInt();
		C=sc.nextInt();
		map=new char[R][C];
		for(int i=0;i<R;i++) {
			String s = sc.next();
			for(int j=0;j<C;j++) {
				map[i][j]=s.charAt(j);
			}
		}
		for(int i=0;i<R;i++) {
			flag=false;
			go(i,0);
			
		}
		System.out.println(answer);
	}

	static void go(int r,int c) {
		if(c==C-1){
			answer++;
			flag=true;
		}
		else{
			int nr = r,nc = c;
			for(int i=0;i<3&&!flag;i++) {
				nr=r+dR[i];
				nc=c+dC[i];
				if(nr>=0&&nc>=0&&nc<C&&nr<R&&map[nr][nc]=='.'&&!flag) {
					map[nr][nc]='1';
					go(nr,nc);
				}
			}
		}
	}

}
