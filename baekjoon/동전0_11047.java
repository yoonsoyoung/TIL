package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//��� 340ms
public class ����0_11047 {

	static int N, cnt;
	static int[] a;
	static long K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken()); // ���� ���� �� 1<= N <= 10
		K = Long.parseLong(st.nextToken()); // ��ġ�� �� 1<= K <= 100,000,000

		a = new int[N];

		for (int i = 0; i < N; i++) { // N�� ������ ��ġ A�� ������������ �־���
			st = new StringTokenizer(br.readLine());
			a[i] = Integer.parseInt(st.nextToken()); // 1<= a <= 1,000,000
		}

		cnt = 0;

		//��� 340ms
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

		//��� 144ms
		for (int i = N - 1; i >= 0; i--) {
			if (K >= a[i]) {
				cnt += K / a[i];
				K = K % a[i];
			}
		}
		System.out.println(cnt);
	}
}
