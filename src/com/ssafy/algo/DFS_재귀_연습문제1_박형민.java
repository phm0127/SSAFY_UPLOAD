package com.ssafy.algo;

import java.util.Scanner;
/*
    // vertex , edge
7 8	
1 2
1 3
2 4
2 5
4 6
5 6
6 7
3 7

 */
public class DFS_재귀_연습문제1_박형민 {
	static int[][] G;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
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
		dfs(0);
	}
	
	static void dfs(int start) {
		System.out.print(start+1);
		for(int i=0;i<G.length;i++) {
			if(!visited[i]&&G[start][i]==1) {
				visited[i]=true;
				System.out.print("-");
				dfs(i);
			}
		}
	}

}
