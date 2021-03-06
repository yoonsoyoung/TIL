package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 통과 132ms , 좀 더 이해 필요
public class 퇴사_14501 {

	static int N, max;
	static int[] t, p, maxP;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		t = new int[N + 2]; // 상담기간, 1일부터 n+1일까지
		p = new int[N + 2]; // 금액, 1일부터 n+1일까지
		maxP = new int[N + 2]; // 최대 수익
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}

		max = 0;

		// i 번째 날에 일을 하면 i + t[i] 날에 p[i] 금액 정산
		for (int i = 1; i < N + 2; i++) {
			maxP[i] = Math.max(maxP[i], max);
			if (i + t[i] <= N + 1) // 상담끝일이 퇴사일까지 정산 가능
				maxP[i + t[i]] = Math.max(maxP[i + t[i]], p[i] + maxP[i]);
			max = Math.max(maxP[i], max); // i일까지 최대 수익
		}

		System.out.println(max);
	}

}
