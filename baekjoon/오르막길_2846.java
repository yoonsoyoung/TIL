package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 통과 140ms
public class 오르막길_2846 {

	static int N, map[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;
		int res = 0;
		// 앞에서부터 보면서
		// 내  다음 애가 나보다 크다면 오르막. 큰 쪽에서 작은 쪽 차이 누적합 
		for (int i = 1; i < N; i++) {
			if(map[i-1]<map[i]) {
				sum += map[i] - map[i-1];
				res = Math.max(res, sum); // 오르막 최대값 갱신
			}
			else { // 오르막이 끊김
				sum = 0; // 누적합 복구
			}
		}
		System.out.println(res);
	}

}
