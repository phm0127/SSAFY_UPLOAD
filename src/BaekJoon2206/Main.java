package BaekJoon2206;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N,M;
	static int[] dR= {-1,1,0,0};
	static int[] dC= {0,0,-1,1};
	static int[][] map;
	static boolean[][][] b;
	static Queue<Point> q;
	static int answer=-1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in );
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		for(int i=0;i<N;i++) {
			String s = sc.next();
			for(int j=0;j<M;j++) {
				map[i][j]=s.charAt(j)-'0';
			}
		}
		b = new boolean[2][N][M];
		//b[0]은 한칸도 안부심 b[1]은 한칸 부심.
		q= new LinkedList<Point>();
		q.add(new Point(0,0,0,0));
		b[0][0][0]=true;
		bfs();
		System.out.println(answer);
	}
	static void bfs() {
		int r,c,count;
		Point p;
		while(!q.isEmpty()) {
			p=q.poll();
			r=p.r;
			c=p.c;
			count=p.count+1;
			if(r==N-1&&c==M-1) {
				answer=count;
				break;
			}
			
			for(int i=0;i<4;i++) {
				r=p.r+dR[i];
				c=p.c+dC[i];
				if(r>=0&&r<N&&c>=0&&c<M) {
					if(map[r][c]==0&&!b[p.punch][r][c]) {
						b[p.punch][r][c]=true;
						q.add(new Point(r,c,count,p.punch));
					}
					if(map[r][c]==1&&p.punch==0&&!b[1][r][c]) {
						b[1][r][c]=true;
						q.add(new Point(r,c,count,1));
					}
				}
			}
		}
	}

}
class Point{
	int r;
	int c;
	int count;
	int punch;
	public Point(int r,int c,int count,int punch) {
		this.r=r;
		this.c=c;
		this.count=count;
		this.punch=punch;
	}
}
