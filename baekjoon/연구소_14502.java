package com.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 통과 1068ms
public class 연구소_14502 {

	static int N, M, ans;
	static int[][] map, temp;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class virus {
		int r, c;

		public virus(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 세로, 행
		M = sc.nextInt(); // 가로, 열

		map = new int[N][M];

		// 원본 배열(map)
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		// DFS - 벽 세우기 : 3개 세웠을 때 BFS호출, 안정영역 cnt++ -> max 업데이트
		// BFS - 바이러스 퍼트리기
		ans = 0;
		dfs(0);
		System.out.println(ans);
	}

	static void dfs(int cnt) { // 벽 세우기
		// 기저 조건
		if (cnt == 3) {
			// virus 타입 큐 생성
			temp = new int[N][M];
			// 복사본 배열 만들면서
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					temp[i][j] = map[i][j];
				}
			}
			ans = Math.max(ans, bfs());
			return;
		}

		// map 돌면서
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// 해당 칸 미방문이고 갈 수 있는 곳이면
				if (map[i][j] == 0) {
					// 해당 칸 벽 세우기
					map[i][j] = 1;
					// 재귀
					dfs(cnt + 1);
					// 벽 복구
					map[i][j] = 0;
				}
			}
		}
	}

	private static int bfs() { // 바이러스 퍼트리기
		// virus 타입 큐 생성
		Queue<virus> q = new LinkedList<virus>();
		// 복사본 배열 돌면서 바이러스를 만나면
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (temp[i][j] == 2)
					// 큐에 삽입
					q.add(new virus(i, j));
			}
		}

		// 큐가 빌 때까지 반복문
		while (!q.isEmpty()) {
			// virus v = q.poll();
			virus v = q.poll();
			int r = v.r;
			int c = v.c;
			// 사방 탐색
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				// 범위 체크
				if (nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;
				// 0 인 곳 바이러스(2) 로 갱신
				if (temp[nr][nc] == 0) {
					temp[nr][nc] = 2;
					// 큐에 삽입
					q.add(new virus(nr, nc));
				}
			}

		}
		int cnt = 0;
		// 최종 복사본 배열 돌면서
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// 0인 곳 만나면 cnt 증가
				if (temp[i][j] == 0)
					cnt++;
			}
		}
		return cnt;
	}

}
