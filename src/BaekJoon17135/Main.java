package BaekJoon17135;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int D;
	static int[][] map;
	static int[][] copyMap;
	static ArrayList<Enemy> list;
	static Queue<Enemy> remove;
	static int answer;
	static int[] arc;
	static boolean flag;
	static int remain;
	static ArrayList<Enemy> copy;
	static int realAnswer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		answer=0;
		realAnswer=0;
		N = sc.nextInt();
		M = sc.nextInt();
		D = sc.nextInt();
		map = new int[N][M];
		copyMap = new int[N][M];
		arc=new int[3];
		remain=0;
		list = new ArrayList<Enemy>();
		copy = new ArrayList<Enemy>();
		remove = new LinkedList<Enemy>();
		flag=false;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				copyMap[i][j]=sc.nextInt();
				if(copyMap[i][j]==1) {
					copy.add(new Enemy(i,j));
					remain++;
				}
			}
		}
		chooseArc(0,0);
		

		System.out.println(realAnswer);

	}
	static void chooseArc(int index, int count) {
		if(count==3) {
			answer=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(copyMap[i][j]==1) {
						map[i][j]=1;
						list.add(new Enemy(i, j));
					}
				}
			}
			play(arc[0],arc[1],arc[2]);
			realAnswer=Math.max(answer, realAnswer);
		}
		else if(index>=M||count>3) {
			//do Nothing
		}
		
		else {
			chooseArc(index+1, count);
			arc[count]=index;
			chooseArc(index+1, count+1);
		}

	}

	static void play(int c1, int c2,int c3) {
		while(!list.isEmpty()) {
			
			flag=false;
			attack(N,c1);
			flag=false;
			attack(N,c2);
			flag=false;
			attack(N,c3);
			remove();
			next();
			
		}
	}


	/*
	 	가장 왼쪽에 있는애 먼저 공격	r = -1 -> -D -> -1
	 	      ㅁ   				c = -(D-1) -> 0 -> D+1
	 	   ㅁ   ㅁ 
	 	ㅁ         ㅁ
	 */
	static void attack(int r, int c) {	//r은 무조건 -1!!
		int nr,nc;
		Queue<Enemy> q = new LinkedList<>();
		q.add(new Enemy(r-1, c));
		while(!q.isEmpty()) {
			Enemy e = q.poll();
			nr=e.r;
			nc=e.c;
			if(nr<0||nc<0||nc>=M) {
				continue;
			}
			if(r-nr+Math.abs(nc-c)>D) {
				break;
			}
			if(map[nr][nc]==1) {
				remove.add(e);
				break;
			}
			q.add(new Enemy(nr,nc-1));
			q.add(new Enemy(nr-1,nc));
			q.add(new Enemy(nr,nc+1));

		}



	}

	
	static void remove() {
		int r,c;

		while(!remove.isEmpty()) {
			Enemy enemy = remove.poll();
			r= enemy.r;
			c= enemy.c;
			
			for(Iterator<Enemy> it = list.iterator() ; it.hasNext() ; )
			{
				Enemy e = it.next();
				if(r==e.r&&c==e.c) {
					it.remove();
					map[r][c]=0;
					answer++;
					break;
				}

			}
		}
		
	}

	static void next() {
		int r,c;
		
		for(Iterator<Enemy> it = list.iterator() ; it.hasNext() ; )
		{
			Enemy e = it.next();
			r=e.r;
			c=e.c;
			map[r][c]--;
			r++;
			//System.out.println(r+","+c);
			if(r>=N)
			{
				//System.out.println("remove : "+r+","+c);
				it.remove();
			}
			else {
				//System.out.println("set"+r+","+c);
				e.setR(r);
				map[r][c]++;
			}
		}
	}

}

class Enemy{
	int r;
	int c;
	public Enemy(int r, int c) {
		this.r=r;
		this.c=c;
	}
	public void setR(int r) {
		this.r=r;
	}
}
