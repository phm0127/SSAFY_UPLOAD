package BaekJoon17143;

import java.util.Scanner;

public class Main {
	static int R,C,M;
	static int[][] map;
	static Shark[] list;
	static int answer;
	static int[] dR = {-1,1,0,0};
	static int[] dC = {0,0,1,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R=sc.nextInt();
		C=sc.nextInt();
		map=new int[R][C];
		M = sc.nextInt();
		list = new Shark[M];
		answer=0;
		for(int i=0;i<M;i++) {
			int r = sc.nextInt()-1;
			int c = sc.nextInt()-1;
			int s = sc.nextInt();
			int d = sc.nextInt();
			int z = sc.nextInt();
			map[r][c]=i+1;
			list[i] = new Shark(r,c,s,d,z);
		}
		turn(0);

		System.out.println(answer);

	}
	static void turn(int turn) {
		if(turn == C) {
			return;
		}
		for(int i=0;i<R;i++) {
			if(map[i][turn]>0&&!list[map[i][turn]-1].dead) {
				Shark s = list[map[i][turn]-1];
				answer+=s.z;
				s.dead=true;
				map[i][turn]=0;
				break;
			}
		}
		int nr,nc;
		map=new int[R][C];
		for(int j=0; j<list.length;j++) {
			if(!list[j].dead) {
				nr=list[j].r;
				nc=list[j].c;
				for(int i=0;i<list[j].s;i++) {
					nr+=dR[list[j].d-1];
					nc+=dC[list[j].d-1];
					if(nr<0) {
						nr=1;
						list[j].d=2;
					}
					else if(nr>=R) {
						nr=R-2;
						list[j].d=1;
					}
					else if(nc<0) {
						nc=1;
						list[j].d=3;
					}
					else if(nc>=C) {
						nc=C-2;
						list[j].d=4;
					}
				}
				list[j].r=nr;
				list[j].c=nc;
				if(map[nr][nc]>0) {
					if(list[j].z>list[map[nr][nc]-1].z) {
						list[map[nr][nc]-1].dead=true;
						map[nr][nc]=j+1;
					}
					else {
						list[j].dead=true;
					}
				}
				else {
					map[nr][nc]=j+1;
				}

			}
			
		}
		turn(turn+1);

	}
}

class Shark{
	int r;
	int c;
	int s;
	int d;
	int z;
	boolean dead;
	public Shark(int r,int c,int s, int d, int z) {
		this.r=r;
		this.c=c;
		this.s=s;
		this.d=d;
		this.z=z;
		dead=false;
	}
}
