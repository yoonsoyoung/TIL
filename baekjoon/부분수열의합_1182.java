package com.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

//통과
public class 부분수열의합_1182 {
	
	static int N, S, sum, ans;
	static int[] s;
	static boolean[] v;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		S = sc.nextInt();
		
		s = new int[N];
		v = new boolean[N];
		ans = 0;
		for (int i = 0; i < N; i++) {
			s[i] = sc.nextInt();
		}
		
		subset(0,0);
		System.out.println(ans);
	}
	
	static void subset(int cnt, int sum) {
		if(cnt >= N) {
			return;
		}
		if(sum+s[cnt] == S)
			ans++;
		
		subset(cnt+1, sum+s[cnt]);
		subset(cnt+1, sum);
		
		
	}

}
