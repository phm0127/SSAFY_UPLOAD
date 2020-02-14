package BaekJoon9465;

import java.util.Scanner;

public class Main {
	static int N;
	static int[][] stiker;
	static boolean[] b;
	static int answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T= sc.nextInt();
		for(int t=0;t<T;t++) {
			
			answer=0;
			N=sc.nextInt();
			stiker = new int[2][N];
			b = new boolean[N];
			for(int i=0;i<2;i++) {
				for(int j=0;j<N;j++) {
					stiker[i][j]= sc.nextInt();
				}
			}
			
			go(0,0,0);
			
			System.out.println(answer);
		}
	}
	
	static void go(int index,int index2, int score) {
		if(index>=N&&index2>=N) {
			answer=Math.max(answer, score);
		}
		else {
			if(index>=N) {
				go(index,index2+1,score);
				if(!b[index2]) {
					b[index2]=true;
					go(index,index2+2,score+stiker[1][index2]);
					b[index2]=false;
				}

			}else if (index2>=N) {
				go(index+1,index2,score);
				if(!b[index]) {
					b[index]=true;
					go(index+2,index2,score+stiker[0][index]);
					b[index]=false;
				}
			}else {
				go(index+1,index2+1,score);
				if(!b[index]) {
					b[index]=true;
					go(index+2,index2+1,score+stiker[0][index]);
					b[index]=false;
				}
				if(!b[index2]) {
					b[index2]=true;
					go(index+1,index2+2,score+stiker[1][index2]);
					b[index2]=false;
				}
				
			}
		}
	}

}
