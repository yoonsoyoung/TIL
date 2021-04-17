package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 통과 156ms
public class RGB거리_1149 {

	static int N, ans;
	static int[][] rgb, D;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine()); // 집의 수
		rgb = new int[N+1][3]; // 각 집 RGB 비용 [0]: R, [1]: G, [2]: B
		D = new int[N+1][3]; // 각 집 칠하는 비용

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				rgb[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		D[0][0] = rgb[0][0];
		D[0][1] = rgb[0][1];
		D[0][2] = rgb[0][2];

		// 1번 집 색 != 2번 집 색
		// N번 집 색 != N-1번 집 색
		// i(2<= i <= N-1, 즉 중간집)번 집 색 != 좌우 집 색
		for (int i = 1; i < N; i++) {
			// 각 색깔을 칠한 현재까지 비용 = 다음 칠할 수 있는 색 중 최소인 애 + 현재 비용 
			// 그 전 집을 (G 칠했을 때 비용 vs B 칠했을 때 비용) 중 최소 + R 칠한 비용 -> 현재 R 칠한 비용   
			D[i][0] = Math.min(D[i-1][1], D[i-1][2]) + rgb[i][0]; // G || B -> R 
			D[i][1] = Math.min(D[i-1][0], D[i-1][2]) + rgb[i][1]; // R || B -> G
			D[i][2] = Math.min(D[i-1][0], D[i-1][1]) + rgb[i][2]; // R || G -> B
		}
		ans = 0;
		ans = Math.min(Math.min(D[N-1][0], D[N-1][1]), D[N-1][2]); // R, G, B 중 
		
		System.out.println(ans);
	}

}
