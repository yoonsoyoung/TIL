package com.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 통과 828ms
public class 벽부수고이동하기_2206 {

	static int N, M, ans;
	static boolean[][][] visited; // 행, 열, 부순여부[0]: 안부숨, [1]: 부숨
	static int[][] map;

	static Node[] adjList;

	static class Node {
		int y; // 행
		int x; // 열
		int cnt; // 이동
		boolean destr; // 부순 여부

		public Node(int y, int x, int cnt, boolean destr) {
			super();
			this.y = y;
			this.x = x;
			this.cnt = cnt;
			this.destr = destr;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 행
		M = sc.nextInt(); // 열

		map = new int[N][M];
		visited = new boolean[N][M][2];
		for (int i = 0; i < N; i++) {
			String s = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		ans = -1;
		bfs();
		System.out.println(ans);

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	private static void bfs() {
		Queue<Node> q = new LinkedList<Node>();

		q.offer(new Node(0, 0, 1, false)); // 행, 열, 이동, 부순여부
		visited[0][0][0] = true; // 0,0 부터 시작하는데 안부순 상태

		while (!q.isEmpty()) {
			Node curr = q.poll();
			int c = curr.x; // 열 M
			int r = curr.y; // 행 N

			if (c == M - 1 && r == N - 1) { // 도착
				ans = curr.cnt;
				return;
			}

			// 사방탐색
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M) { // 범위 체크
					continue;
				}

				// 같은 상태로 같은 위치 방문
				if (visited[nr][nc][curr.destr ? 1 : 0])
					continue;

				if (map[nr][nc] == 1 && !curr.destr) { // 벽
					// 부술 수 있고 아직 방문하지 않았다면 벽을 부수고 방문체크
					visited[nr][nc][1] = true;
					// q에 다음 (행, 열, 횟수+1, true) 으로 넣기
					q.offer(new Node(nr, nc, curr.cnt + 1, true));
				} 
				if (map[nr][nc] == 0){ // 벽 아님 -> 벽의 else 가 아님!
					visited[nr][nc][curr.destr ? 1 : 0] = true;
					q.offer(new Node(nr, nc, curr.cnt + 1, curr.destr));
				}

			}

		}
	}
}
