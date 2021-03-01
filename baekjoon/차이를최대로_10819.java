package com.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

//통과
public class 차이를최대로_10819 {
	
	static int N, sum;
	static int[] a, num;
	static boolean[] v;
	static int max;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		a = new int[N];
		num = new int[N];
		v = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
		}
		max = Integer.MIN_VALUE;
		
		Arrays.sort(a);
		
		perm(0);
		System.out.println(max);
	}
	private static void perm(int cnt) {
		if(cnt == N) {
			sum = 0;
			for (int i = 0; i < N-1; i++) {
				sum += Math.abs(num[i] - num[i+1]);
			}
			
			max = Math.max(max, sum);
			return;
		}
		
		
		for (int i = 0; i < N; i++) {
			if(v[i]) continue;
			
			num[cnt] = a[i];
			v[i] = true;
			perm(cnt+1);
			v[i] = false;
			
			
		}
	}
}
