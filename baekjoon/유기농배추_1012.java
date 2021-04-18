package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 통과 172ms
public class 유기농배추_1012 {

	static int T, M, N, K, map[][];
	static boolean[][] visited;
	static class Node {
		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 열
			M = Integer.parseInt(st.nextToken()); // 행
			K = Integer.parseInt(st.nextToken()); // 배추 개수
			map = new int[M][N];
			visited = new boolean[M][N];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken()); // 가로 좌표
				int y = Integer.parseInt(st.nextToken()); // 세로 좌표
				map[y][x] = 1; // 여기에 배추가 있음
			}

			int cnt = 0;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						bfs(i, j);
						cnt++;
					}
				}
			}

			System.out.println(cnt);
		}

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	private static void bfs(int sR, int sC) {
		Queue<Node> q = new LinkedList<Node>();

		q.offer(new Node(sR, sC));
		visited[sR][sC] = true;

		while (!q.isEmpty()) {
			Node curr = q.poll();
			int r = curr.r;
			int c = curr.c;

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr < 0 || nc < 0 || nr >= M || nc >= N)
					continue;
				if(visited[nr][nc])
					continue;
				if(map[nr][nc] == 0)
					continue;
				
				q.offer(new Node(nr, nc));
				visited[nr][nc] = true;
			}
		}
	}

}
