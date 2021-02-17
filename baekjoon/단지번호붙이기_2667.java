package com.baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//통과
public class 단지번호붙이기_2667 {

	static int N, ans, idx;
	static int[][] map;
	static int[] houseCnt; 

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];

		for (int i = 0; i < N; i++) { // 지도 입력
			String s = sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = (int) s.charAt(j) - '0'; // j 인자값 !!!
			}
		}

		idx = 0;
		houseCnt = new int[N*N]; //대각선으로 있을 때가 가장 많이 나오니까 N제곱의 반만큼
		for (int i = 0; i < N; i++) { // 단지 찾기
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					dfs(i, j); //탐색
					idx++; //단지 시작
				}

			}
		}
		System.out.println(idx);
		Arrays.sort(houseCnt, 0, idx);
		for (int i = 0; i < idx; i++) {
			System.out.println(houseCnt[i]);
		}

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int cnt;

	private static void dfs(int r, int c) {
		map[r][c] = 0;
		houseCnt[idx]++;

		for (int d = 0; d < 4; d++) { //사방탐색
			int nr = r + dr[d];
			int nc = c + dc[d]; //dc 제대로 쓰기!
			if (nr < 0 || nc < 0 || nr >= N || nc >= N)
				continue;
			if (map[nr][nc] == 1)
				dfs(nr, nc);
		}
	}

}
