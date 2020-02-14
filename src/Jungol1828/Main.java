package Jungol1828;
/**
	A : |----------|
	B :    |----------|
	C :     |-----|
	D :            |----|
	
		정렬 방식
		: 각 화학 약품의 최저 온도를 오름차순으로 정렬하되, 최저 온도가 같다면 최고온도 오름차순으로 정렬
		
		생각 넓히기(?)
		1. 최저 온도 기준으로 정렬을 했기 때문에 차례대로 검사를 하면 뒤에 나오는 화학 약품의 최저온도는 이전에 나온 화학약품의 최저온도보다 항상 같거나 큼.
		2. 따라서, 화학 약품이 같은 냉장고에 들어갈 수 있는지 검사(즉, 온도가 겹치는 부분이 있는지를 검사)를 하기 위해 
			후자의 화학 약품의 최저 온도가 전자의 화학 약품의 최고 온도보다 낮으면 겹치는 부분이 있다고 할 수 있음.
		3. 냉장고에 있는 화학 약품의 최저 온도는 순차적으로 증가하나 최고 온도는 순차적이지 않을 수 있기 때문에 
			위 그림처럼 D의 최저 온도가 A의 최고 온도보다 낮으나 같은 냉장고 있는 C의 최고 온도보다 높기 때문에 C와 D는 같은 냉장고에 보관할 수 없음.
			즉, 냉장고에 화학 약품을 넣으면서 냉장고에 보관 할 수 있는 최고 온도를 계속 업데이트할 필요가 있음.
		4. D는 따로 저장을 해야하므로 D가 맨 처음 들어가는 냉장고를 만들어 1~3 과정을 반복.
		
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int min,max;
		ArrayList<Temp> t = new ArrayList<>();
		for(int i=0;i<N;i++) {
			min = sc.nextInt();
			max = sc.nextInt();
			t.add(new Temp(min,max));
		}
		
		int answer=0;
		int curMax=-271;	
		Collections.sort(t);
		for(Temp a : t) {
			if(curMax<a.min) {
				answer++;
				curMax=a.max;
			}else {
				if(curMax>a.max) {
					curMax=a.max;
				}
			}
		}
		
		System.out.println(answer);
	}

}





class Temp implements Comparable<Temp>{
	int min;
	int max;
	public Temp(int min,int max) {
		this.min=min;
		this.max=max;
	}
	@Override
	public int compareTo(Temp o) {
		if(min>o.min) {
			return 1;
		}
		else if(min<o.min) {
			return -1;
		}else {
			if(max>o.max) {
				return 1;
			}else {
				return -1;
			}
		}
	}
	
}