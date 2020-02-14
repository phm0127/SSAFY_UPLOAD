package BaekJoon7576;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[][] box;
	static int tomato;
	static int[] dR = {-1,1,0,0};
	static int[] dC = {0,0,-1,1};
	static int answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M=sc.nextInt();
		N=sc.nextInt();
		box = new int[N][M];
		tomato=0;
		answer=0;
		Queue<A> stack = new LinkedList<>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				box[i][j] = sc.nextInt();
				if(box[i][j]==0) {
					tomato++;
				}else if(box[i][j]==1) {
					stack.add(new A(i,j,0));
				}
			}
		}
		int r,c,count,nr,nc;
		while(!stack.isEmpty()) {
			A a = stack.poll();
			r=a.r;
			c=a.c;
			count=a.count;
			answer=Math.max(count, answer);
			for(int i=0;i<4;i++) {
				nr=r+dR[i];
				nc=c+dC[i];
				if(nr>=0&&nr<N&&nc>=0&&nc<M&&box[nr][nc]==0) {
					box[nr][nc]=count+1;
					stack.add(new A(nr,nc,count+1));
					tomato--;
				}
			}
			
			if(tomato==0) {
				answer=count;
			}else {
				answer=-1;
			}
			
		}
		
		
		System.out.println(answer);
			
	}

}
class A{
	int r;
	int c;
	int count;
	public A(int r, int c,int count){
		this.r=r;
		this.c=c;
		this.count=count;
	}
}