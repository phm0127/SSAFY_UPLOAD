
package SWEA1494;

import java.util.Scanner;

public class Solution {
	static long answer=Long.MAX_VALUE;
	static int N;
	static int n;
	static Vector[] v;
	static Vector[] plus;
	static Vector[] minus;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			answer=Long.MAX_VALUE;
			N=sc.nextInt();
			n=N/2;
			v= new Vector[N];
			plus= new Vector[n];
			minus= new Vector[n];
			for(int i=0;i<N;i++) {
				int r= sc.nextInt();
				int c= sc.nextInt();
				Vector vec=new Vector(r, c);
				v[i]=vec;
			}
			match(0,0,0);

			System.out.println("#"+test_case+" "+answer);

		}

	}
	static void match(int index, int p,int m) {
		if(index==N) {
			answer=Math.min(answer, cal());
		}
		else {
			if(p<n) {
				plus[p]=v[index];
				match(index+1,p+1,m);
			}
			if(m<n) {
				minus[m]=v[index];
				match(index+1,p,m+1);
			}
			
		}
	}
	
	static long cal() {
		long x=0,y=0;
		
		for(int i=0;i<n;i++) {
			x+=plus[i].r-minus[i].r;
			y+=plus[i].c-minus[i].c;
		}
		return x*x+y*y;
	}


}

class Vector{
	int r;
	int c;
	
	Vector(int r, int c){
		this.r=r;
		this.c=c;
	}
}
