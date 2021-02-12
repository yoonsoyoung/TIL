package com.baekjoon;

import java.util.Scanner;

public class 색종이2_2567 {
	static int left;
	static int bottom;
	static int[][] paper;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		paper = new int[102][102]; //범위 테두리 크게

		int T = sc.nextInt();
		int ans = 0;
		for (int tc = 0; tc < T; tc++) {
			left = sc.nextInt();
			bottom = sc.nextInt();

			for (int i = left;  i < left + 10; i++) {
				for (int j = bottom;  j < bottom + 10; j++) {
					if (paper[i][j] == 1) // 이미 1이면
						continue;
					paper[i][j] = 1;
				}
			}
		}

		for (int i = 0; i < 100; i++) {
			for (int j = 0;  j < 100; j++) {
				if (paper[i][j] == 1) { // 채워진 색종이에서 둘레만 해야하므로
					for (int d = 0; d < 4; d++) { // 사방탐색 중 사방이 모두 1이면 안쪽이라는 뜻. 그게 아닌 경우에 둘레를 1씩더해줌
						int nR = i + dr[d]; // 행
						int nC = j + dc[d]; // 열
						if (paper[nR][nC] == 0)
							ans++;
					}
				}
			}
		}
		System.out.println(ans);
	}

}
