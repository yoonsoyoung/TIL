package com.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

//통과
public class 파이프옮기기1_17070 {

	static int N, ans;
	static int[][] house;
	static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		house = new int[N + 1][N + 1]; // 1,1 부터 시작하기 위함
		visited = new boolean[N + 1][N + 1];
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				house[r][c] = sc.nextInt();
			}
		}

		// 끝점을 기준으로 탐색 방향 3가지 dr= {0,1,1}, dc={1,0,1} 가로: 0,1 세로: 1,0, 대각선: 1,1
		// 1.가로 : 1)밀기 f(r,c) b(r,c+1) -> nf(r, c+1) nb(r,c+2) => nf=cb , nb=(cr,cc+1)
		// => 시작점이 끝점되고 끝점은 이전 좌표에서 c+1
		// 2)밀고 대각선: f(r, c) b(r,c+1) -> nf(r,c+1) nb(r+1, c+1) => nf=cb, nb(cr+1, cc+1)
		// => 시작점이 끝점이 되고 끝점은 이전좌표에서 r+1, c+1
		// 2.세로 : 1) 밀기 f(r,c) b(r+1, c) -> nf(r+1, c) nb(r+2, c) => nf=cb, nb(cr+1, cc)
		// => 시작점이 끝점되고 끝점은 이전 좌표에서 r+1
		// 2) 밀고 대각선 : f(r, c) b(r+1, c) -> nf(r+1, c) nb(r+2, c+1) => nf=cb, nb(cr+1, cc+1);
		// 3.대각선 : 시작점이 끝점되고, 끝점은 이전 끝점좌표에서 ( 가로 c+1 || 세로 r+1 || 대각선 r+1, c+1 )

		// 처음 파이프는 (1,1), (1,2)
		visited[1][1] = true;
		visited[1][2] = true;

		ans = 0;
		dfs(1, 2, 1); // 끝점을 기준으로 보냄, 가로부터 탐색
		System.out.println(ans);
	}

	static int[] dr = { 0, 1, 1 };
	static int[] dc = { 1, 0, 1 };

	private static boolean deltaCheck(int r, int c) {

		if (r < 1 || c < 1 || c > N || r > N || house[r][c] == 1)
			return false;
		return true;
	}

//	private static boolean deltaCheck(int r, int c, int dir) {
//
//		for (int d = 0; d < 3; d++) { // 삼방향 탐색
//			int nr = r + dr[d];
//			int nc = c + dc[d];
//			if (nr < 1 || nc < 1 || nc > N || nr > N || house[nr][nc] == 1)
//				return false;
//		}
//		return true;
//	}

	private static void dfs(int r, int c, int dir) {
		if (r == N && c == N) { // 끝에 다다르면
			ans++;
			return;
		}

		if (dir == 1) { // 1. 가로
			// 1) 가로 밀기
			if (deltaCheck(r, c + 1))
				dfs(r, c + 1, 1);
			// 2) 대각선 회전
			if (deltaCheck(r + 1, c + 1) && deltaCheck(r, c + 1) && deltaCheck(r + 1, c))
				dfs(r + 1, c + 1, 3);
		} else if (dir == 2) { // 2. 세로
			// 1) 세로 밀기
			if (deltaCheck(r + 1, c))
				dfs(r + 1, c, 2);
			// 2) 대각선 회전
			if (deltaCheck(r + 1, c + 1) && deltaCheck(r, c + 1) && deltaCheck(r + 1, c))
				dfs(r + 1, c + 1, 3);
		} else if (dir == 3) { // 3. 대각선
			// 1) 가로
			if (deltaCheck(r, c + 1))
				dfs(r, c + 1, 1);
			// 2) 세로
			if (deltaCheck(r + 1, c))
				dfs(r + 1, c, 2);
			// 3) 대각선
			if (deltaCheck(r + 1, c + 1) && deltaCheck(r, c + 1) && deltaCheck(r + 1, c))
				dfs(r + 1, c + 1, 3);
		}

	}

}
