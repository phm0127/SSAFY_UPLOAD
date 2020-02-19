package BaekJoon17825;

import java.util.Scanner;

public class Main {
	static int score=0;
	static int map1[] = {0,2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38};
	static int map2[] = {10,13,16,19};
	static int map3[] = {20,22,24};
	static int map4[] = {30,28,27,26};
	static int map5[] = {25,30,35};
	static int[] dice;
	static int[] player;
	static int[] state;
	static boolean[][] b;
	static boolean[] pb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		dice= new int[10];
		for(int i=0;i<10;i++) {
			dice[i]=sc.nextInt();
		}
		/*
		20개 짜리 맵

		 */
		player= new int[4];
		state = new int[4];
		b=new boolean[6][20];
		pb=new boolean[4];
		game(-1,0);
		System.out.println(score);
	}
	static void game(int index, int sum) {
		score= Math.max(score, sum);
		
		if(index>=9) {
		}
		else {
			int tmp,tmp2,go;
			
			if(!pb[0]) {
				tmp=state[0];
				tmp2=player[0];
				player[0]+=dice[index+1];
				go=go(index+1,player[0],0);
				if((!b[state[0]][player[0]])) {
					b[tmp][tmp2]=false;
					if(!pb[0]) {
						b[state[0]][player[0]]=true;
					}
					game(index+1,sum+go);
					b[tmp][tmp2]=true;
					b[state[0]][player[0]]=false;
				}
				pb[0]=false;
				state[0]=tmp;
				player[0]=tmp2;
			}
			
			
			if(!pb[1]) {
				tmp=state[1];
				tmp2=player[1];
				player[1]+=dice[index+1];
				go=go(index+1,player[1],1);
				if((!b[state[1]][player[1]])) {
					b[tmp][tmp2]=false;
					if(!pb[1]) {
						b[state[1]][player[1]]=true;
					}
					game(index+1,sum+go);
					b[tmp][tmp2]=true;
					b[state[1]][player[1]]=false;
				}
				pb[1]=false;
				state[1]=tmp;
				player[1]=tmp2;
			}
			
			
			if(!pb[2]) {
				tmp=state[2];
				tmp2=player[2];
				player[2]+=dice[index+1];
				go=go(index+1,player[2],2);
				
				if((!b[state[2]][player[2]])) {
					b[tmp][tmp2]=false;
					if(!pb[2]) {
						b[state[2]][player[2]]=true;
					}
					game(index+1,sum+go);
					b[tmp][tmp2]=true;
					b[state[2]][player[2]]=false;
				}
				pb[2]=false;
				state[2]=tmp;
				player[2]=tmp2;
			}
			
			if(!pb[3]) {
				tmp=state[3];
				tmp2=player[3];
				player[3]+=dice[index+1];
				go=go(index+1,player[3],3);
				if((!b[state[3]][player[3]])) {
					b[tmp][tmp2]=false;
					if(!pb[3]) {
						b[state[3]][player[3]]=true;
					}
					game(index+1,sum+go);
					b[tmp][tmp2]=true;
					b[state[3]][player[3]]=false;
				}
				pb[3]=false;
				state[3]=tmp;
				player[3]=tmp2;
				
			}
		}
		
	}

	static int go(int index ,int pos, int p) {
		if(index>=10) {
			return 0;
		}
		
		else if(state[p]==0) {
			if(pos>20) {
				player[p]=0;
				pb[p]=true;
				return 0;
			}
			else if(pos==20) {
				player[p]=0;
				state[p]=4;
				return 40;
			}
			int ret = map1[pos];
			if((pos)%5==0) {
				state[p]=pos/5;
				player[p]=0;
			}
			return ret;
		}
		else if(state[p]==1) {
			if(pos>=8) {
				pb[p]=true;
				return 0;
			}else if(pos==7) {
				state[p]=4;
				player[p]=0;
				return 40;
			}else if(pos>=4){
				state[p]=5;
				player[p]-=4;
				return map5[player[p]];
			}
			return map2[pos];
		}
		else if(state[p]==2) {
			if(pos>6) {
				pb[p]=true;
				return 0;
			}else if(pos==6) {
				state[p]=4;
				player[p]=0;
				return 40;
			}
			else if(pos>=3){
				state[p]=5;
				player[p]-=3;
				return map5[player[p]];
			}
			return map3[pos];
		}
		else if(state[p]==3) {
			if(pos>=8) {
				pb[p]=true;
				return 0;
			}else if(pos==7) {
				state[p]=4;
				player[p]=0;
				return 40;
			}else if(pos>=4){
				state[p]=5;
				player[p]-=4;
				return map5[player[p]];
			}
			return map4[pos];
		}else if(state[p]==4) {
			b[4][0]=true;
			pb[p]=true;
			return 0;
		}else if(state[p]==5) {
			if(pos>3) {
				pb[p]=true;
				return 0;
			}else if(pos==3) {
				state[p]=4;
				player[p]=0;
				return 40;
			}
			return map5[pos];
		}
		pb[p]=true;
		return 0;
	}

}
