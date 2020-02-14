package Jungol1863;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;


public class Main {
	static int N;
	static int M;
	static HashMap<Integer, Integer> hash;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //선언
		String[] s = br.readLine().split(" "); //String

		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		
		int a,b;
		hash=new HashMap<>();
		
		for(int i=0;i<M;i++) {
			String[] s1 = br.readLine().split(" ");
			a= Integer.parseInt(s1[0]);
			b = Integer.parseInt(s1[1]);
			if(a>b) {
				int tmp=b;
				b=a;
				a=b;
			}
			if(hash.containsKey(a)&&!hash.containsKey(b)) {
				hash.put(b, hash.get(a));
			}
			else if(!hash.containsKey(a)&&hash.containsKey(b)) {
				hash.put(a, hash.get(b));
			}
			else if(hash.containsKey(a)&&hash.containsKey(b)) {
				if(hash.get(a)<hash.get(b)) {
					hash.put(hash.get(b), hash.get(a));
					hash.put(b, hash.get(a));
				}else {
					hash.put(hash.get(a), hash.get(b));
					hash.put(a, hash.get(b));
				}
			}else {
				hash.put(a, a);
				hash.put(b, a);
			}
			
			
		}
		int count=N-hash.size();
		Set<Integer> key = hash.keySet();
		for(int i: key) {
			if(hash.get(i)==i) {
				count++;
			}
		}
			
		
		System.out.println(count);
	}

}

