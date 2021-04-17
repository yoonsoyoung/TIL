package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 통과 580ms
public class 말이되고픈원숭이_1600 {
	static int K, W, H, ans;
	static boolean[][][] visitied; // 행, 열, 말 이동횟수
	static int[][] map;

	static class Node {
		int r; // 행
		int c; // 열
		int cnt; // 이동
		int k; // 말처럼 이동 횟수

		public Node(int r, int c, int cnt, int k) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.k = k;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		K = Integer.parseInt(br.readLine()); // 움직일 수 있는 횟수 0<= K <= 30

		st = new StringTokenizer(br.readLine(), " ");
		W = Integer.parseInt(st.nextToken()); // 가로, 열 1<= W <= 200
		H = Integer.parseInt(st.nextToken()); // 세로, 행 1<= H <= 200

		map = new int[H][W];
		visitied = new boolean[H][W][K + 1]; // h,w,k

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		ans = -1;
		bfs();
		System.out.println(ans);

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[] hr = { -2, -2, -1, -1, 1, 1, 2, 2 };
	static int[] hc = { -1, 1, -2, 2, -2, 2, -1, 1 };

	private static void bfs() {
		Queue<Node> q = new LinkedList<Node>();

		visitied[0][0][0] = true;
		q.add(new Node(0, 0, 0, 0));

		while (!q.isEmpty()) {
			Node curr = q.poll();
			int r = curr.r;
			int c = curr.c;
			int cnt = curr.cnt;
			int k = curr.k;

			if (r == H - 1 && c == W - 1) { // 도착
				ans = cnt;
				return;
			}

			// 사방 탐색
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (nr < 0 || nc < 0 || nr >= H || nc >= W) // 범위 넘어감
					continue;
				if (map[nr][nc] == 1) // 장애물임
					continue;
				if(visitied[nr][nc][k]) // 방문한 곳임
					continue;
				visitied[nr][nc][k] = true;
				q.add(new Node(nr,nc,cnt+1,k));
				
			}
			if (k < K) { // 말 처럼 움직일 수 있다면
				for (int d = 0; d < 8; d++) {
					int nr = r + hr[d];
					int nc = c + hc[d];

					if (nr < 0 || nc < 0 || nr >= H || nc >= W) // 범위 넘어감
						continue;
					if (map[nr][nc] == 1) // 장애물임
						continue;
					if(visitied[nr][nc][k+1]) // 방문한 곳임
						continue;
					visitied[nr][nc][k+1] = true;
					q.add(new Node(nr,nc,cnt+1, k+1));
				}
			}

		}
	}

}
