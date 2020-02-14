package BaekJoon1600;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int K;
	static int N,M;
	static int[][] map;
	static int answer = 0;
	static int[] dR = {-1,1,0,0};
	static int[] dC = {0,0,-1,1};
	static int[] dhR = {-2,-2,2,2,-1,-1,1,1};
	static int[] dhC = {-1,1,-1,1,-2,2,-2,2};
	
	static boolean[][][] isVisited;
	
	static Queue<Point> q;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K=sc.nextInt();
		N=sc.nextInt();
		M=sc.nextInt();
		map = new int[N][M];
		q=new LinkedList<Point>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				map[i][j]= sc.nextInt();
			}
		}
		isVisited = new boolean[K+1][N][M];
		isVisited[0][0][0]=true;
		int r=0, c=0, count, jump;
		boolean flag=true;
		q.add(new Point(0,0,0,0));
		while(!q.isEmpty()) {
			Point p = q.poll();
			jump=p.jump;
			count=(p.count+1);
		
			r=p.r;
			c=p.c;
			if(r==N-1&&c==M-1) {
				answer = count-1;
				flag=false;
				break;
			}
			for(int i=0;i<4;i++) {
				int nr=r+dR[i];
				int nc=c+dC[i];
				if(nr>=0&&nc>=0&&nr<N&&nc<M&&map[nr][nc]==0&&!isVisited[jump][nr][nc]) {
					isVisited[jump][nr][nc]=true;
					q.add(new Point(nr,nc,count,jump));
				}
			}
			for(int i=0;i<8&&jump<K;i++) {
				int nr=r+dhR[i];
				int nc=c+dhC[i];
				if(nr>=0&&nc>=0&&nr<N&&nc<M&&map[nr][nc]==0&&!isVisited[jump+1][nr][nc]) {
					isVisited[jump+1][nr][nc]=true;
					q.add(new Point(nr,nc,count,jump+1));
				}
			}
			
		}
		if(flag) {
			answer=-1;
		}
		
		System.out.println(answer);
	}
	
	
}

class Point{
	int r;
	int c;
	int count;
	int jump;
	public Point(int r,int c,int count,int jump) {
		this.r=r;
		this.c=c;
		this.count=count;
		this.jump=jump;
	}
}