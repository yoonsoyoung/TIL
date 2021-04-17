package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 통과 160ms
public class 미로탐색_2178 {

	static int N, M, map[][];

	static class Node {
		int r, c, cnt;

		public Node(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken()); // 행
		M = Integer.parseInt(st.nextToken()); // 열
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		System.out.println(bfs());
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	private static int bfs() {
		Queue<Node> q = new LinkedList<Node>();
		boolean[][] visited = new boolean[N][M];

		q.offer(new Node(0, 0, 1));
		visited[0][0] = true;

		while (!q.isEmpty()) {
			Node curr = q.poll();
			int r = curr.r;
			int c = curr.c;
			int cnt = curr.cnt;

			if(r == N-1 && c == M-1) {
				return cnt;
			}
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;
				if(visited[nr][nc])
					continue;
				if(map[nr][nc] == 0)
					continue;

				q.offer(new Node(nr, nc, cnt+1));
				visited[nr][nc] = true;
			}
		}

		return -1;
	}

}
