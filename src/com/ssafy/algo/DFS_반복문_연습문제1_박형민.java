package com.ssafy.algo;

import java.util.Scanner;
import java.util.Stack;

public class DFS_반복문_연습문제1_박형민 {

	static int[][] G;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> s = new Stack<>();
		int V = sc.nextInt();
		int E = sc.nextInt();
		G = new int [V][V];
		visited = new boolean[V];
		for(int i=0;i<E;i++) {
			int r = sc.nextInt()-1;
			int c = sc.nextInt()-1;
			G[r][c] = G[c][r]= 1;
		}
		visited[0]=true;
		s.push(0);
		int p=0;
		boolean flag=false;
		System.out.print(p+1);
		while(!s.isEmpty()) {
			flag=true;
			for(int i=0;i<V;i++) {
				if(!visited[i]&&G[p][i]==1) {
					visited[i]=true;
					System.out.print(" - ");
					System.out.print(i+1);
					s.push(i);
					flag=false;
					break;
				}
			}
			p=s.peek();
			if(flag) {
				p=s.pop();
			}
		}
	}

}
