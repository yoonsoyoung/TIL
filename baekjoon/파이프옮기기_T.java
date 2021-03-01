package com.baekjoon;

import java.util.Scanner;

public class 파이프옮기기_T {
//3진 트리의 문제

	static int N, ans;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		ans = 0;
		dfs(0,1,0); //0,1에서 오른쪽 방향을 보고 시작
		//0: 오른쪽, 1: 왼쪽, 2: 대각선
		System.out.println(ans);
		
	}

	static void dfs(int r, int c, int dir) {
		if (r == N - 1 && c == N - 1) {
			ans++;
			return;
		}

		// 부분집합은 고르고 가. 안 고르고 가. 라면
		// 오른쪽으로 갈 수 있으면 오른쪽으로
		if (dir != 1 && c + 1 < N && map[r][c + 1] == 0) { // 내가 아래를 보고 있지 않고, 오른쪽에 공간이 남아있으면서 장애물이 없어야 함
			dfs(r, c + 1, 0);
		}

		// 아래로 갈 수 있으면 아래로
		if (dir != 0 && r + 1 < N && map[r + 1][c] == 0) {
			dfs(r + 1, c, 1);
		}

		// 대각으로 갈 수 있으면
		if (r + 1 < N && c + 1 < N && map[r + 1][c] + map[r][c + 1] + map[r + 1][c + 1] == 0) { // 모든 방향이 장애물이 없다는 건 더한
			dfs(r + 1, c + 1, 2);
		}
	}

}
