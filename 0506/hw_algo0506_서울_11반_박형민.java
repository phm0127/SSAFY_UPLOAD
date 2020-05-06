import java.util.Scanner;

public class hw_algo0506_서울_11반_박형민 {
	static int[][] result;
	static int answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		result = new int[6][3];
		
		for(int i=0;i<4;i++) {
			boolean flag=true;
			for(int j=0;j<6;j++) {
				int sum=0;
				for(int k=0;k<3;k++) {
					result[j][k]= sc.nextInt();
					sum+=result[j][k];
				}
				if(sum!=5) {
					flag=false;
				}
			}
			answer=0;
			if(flag) {
				cal(0,1);
			}
			System.out.print(answer+" ");
		}
		

	}

	public static void cal(int p, int q) {
		
		if(p==6) {
			answer=1;
			return;
		}
		if(q==6) {
			cal(p+1,p+2);
		}
		else{
			result[p][0]--;
			result[q][2]--;
			if(result[p][0]>=0&&result[q][2]>=0) {
				cal(p,q+1);
			}
			result[p][0]++;
			result[q][2]++;
			result[p][1]--;
			result[q][1]--;
			if(result[p][1]>=0&&result[q][1]>=0) {
				cal(p,q+1);
			}
			result[p][1]++;
			result[q][1]++;
			result[p][2]--;
			result[q][0]--;
			if(result[p][2]>=0&&result[q][0]>=0) {
				cal(p,q+1);
			}
			result[p][2]++;
			result[q][0]++;
		}
		
		
	}

}
