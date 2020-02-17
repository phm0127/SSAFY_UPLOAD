package BaekJoon4963;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int w,h;
	static int[][] map;
	static ArrayList<Land> list;
	static ArrayList<Land> rank;
	static int answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			answer=0;
			w=sc.nextInt();
			h=sc.nextInt();
			if(w==0&&h==0) {
				break;
			}
			map= new int[h][w];
			list=new ArrayList<>();
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					map[i][j]=sc.nextInt();
					if(map[i][j]==1) {
						list.add(new Land(i,j));
					}
				}
			}
			Land a,b;
			for(int i=0;i<list.size();i++) {
				a=list.get(i);
				for(int j=i;j<list.size();j++) {
					b=list.get(j);
					if((Math.abs(a.r-b.r)==1&&Math.abs(a.c-b.c)<=1)||(Math.abs(a.c-b.c)==1&&Math.abs(a.r-b.r)<=1)) {
						Land rootA = a;
						Land rootB = b;
						while(true) {
							if(rootA == rootA.root) {
								break;
							}
							rootA=rootA.root;
						}
						while(true) {
							if(rootB == rootB.root) {
								break;
							}
							rootB=rootB.root;
						}
						if(a.rank>b.rank) {
							rootB.root=rootA;
						}
						else if(a.rank<b.rank) {
							rootA.root=rootB;
						}
						else {
							rootA.root=rootB;
							a.rank++;
						}
					}
					
				}
			}
			
			for(int i=0;i<list.size();i++) {
				if(list.get(i)==list.get(i).root) {
					answer++;
				}
			}
			
			System.out.println(answer);


		}
	}



}

class Land{
	int r;
	int c;
	Land root = this;
	int rank;
	public Land(int r, int c) {
		this.r=r;
		this.c=c;
		this.root = this;
		this.rank = 1;
	}
	public Land(int r, int c, Land root,int rank) {
		this.r=r;
		this.c=c;
		this.root = root;
		this.rank = rank;
	}
}
