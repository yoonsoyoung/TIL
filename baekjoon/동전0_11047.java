package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//통과 340ms
public class 동전0_11047 {

	static int N, cnt;
	static int[] a;
	static long K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken()); // 동전 종류 수 1<= N <= 10
		K = Long.parseLong(st.nextToken()); // 가치의 합 1<= K <= 100,000,000

		a = new int[N];

		for (int i = 0; i < N; i++) { // N개 동전의 가치 A가 오름차순으로 주어짐
			st = new StringTokenizer(br.readLine());
			a[i] = Integer.parseInt(st.nextToken()); // 1<= a <= 1,000,000
		}

		cnt = 0;

		//통과 340ms
//		while(K >0) {
//			for (int i = N-1; i >= 0; ) {
//				if(K >= a[i]) {
//					K -= a[i];
//					cnt++;
//				} else {
//					i--;
//				}
//			}
//		} 

		//통과 144ms
		for (int i = N - 1; i >= 0; i--) {
			if (K >= a[i]) {
				cnt += K / a[i];
				K = K % a[i];
			}
		}
		System.out.println(cnt);
	}
}
