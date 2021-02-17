package com.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

//통과
public class 섬의개수_4963 {

	static int w, h, ans;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			w = sc.nextInt(); // 너비 = c
			h = sc.nextInt(); // 높이 = r
			if(w==0 && h==0)
				break;
			map = new int[h][w];
			for (int i = 0; i < h; i++) { // 지도
				for (int j = 0; j < w; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			ans = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1) {
						ans++;
						go(i, j); // 0,0 부터 탐색
					}
				}
			}
			System.out.println(ans);
		}
	}
	
	static int[] dr = { -1, -1, -1, 0, 1, 1, 1, -1 };
	static int[] dc = { -1, 0, 1, 1, 1, 0, -1, 0 };

	private static void go(int r, int c) {
		map[r][c] = 0; // 해당 자리 0으로 바꾸고

		for (int d = 0; d < 8; d++) { // 팔방검색
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr < 0 || nc < 0 || nr >= h || nc >= w) // 범위 벗어나면 다음
				continue;
			if (map[nr][nc] == 1) { // 섬이고
				go(nr, nc);
			}

		}
	}

}
