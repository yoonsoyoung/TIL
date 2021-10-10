package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

// 통과 152ms
public class 영역구하기_2583 {

	static int M, N, K, area;
	static int[][] map;
	static int[] cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		M = Integer.parseInt(st.nextToken()); // 열
		N = Integer.parseInt(st.nextToken()); // 행
		K = Integer.parseInt(st.nextToken()); // 직사각형 수
		map = new int[N][M];
		cnt = new int[N * M];

		for (int i = 0; i < K; i++) {
			int r1 = 0, r2 = 0, c1 = 0, c2 = 0;
			st = new StringTokenizer(br.readLine(), " ");
			r1 = Integer.parseInt(st.nextToken());
			c1 = Integer.parseInt(st.nextToken());
			r2 = Integer.parseInt(st.nextToken());
			c2 = Integer.parseInt(st.nextToken());

			for (int r = r1; r < r2; r++) { // 행
				for (int c = c1; c < c2; c++) { // 열
					map[r][c] = 1;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					dfs(i, j);
					area++;
				}
			}
		}
		
		System.out.println(area); // 전체 영역의 개수
		Arrays.sort(cnt, 0, area);
		for (int i = 0; i < area; i++) {
			System.out.print(cnt[i] + " ");
		}

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	private static void dfs(int r, int c) {
		map[r][c] = 1;
		cnt[area]++;

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr < 0 || nc < 0 || nr >= N || nc >= M) 
				continue;
			if (map[nr][nc] == 0)
				dfs(nr, nc);
		}
	}

}
