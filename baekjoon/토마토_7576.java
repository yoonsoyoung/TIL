package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 통과 716ms
public class 토마토_7576 {

	static int M, N, map[][], ans;
	static Queue<Tomato> q;

	static class Tomato {
		int r, c, day;

		public Tomato(int r, int c, int day) {
			super();
			this.r = r;
			this.c = c;
			this.day = day;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		M = Integer.parseInt(st.nextToken()); // 열
		N = Integer.parseInt(st.nextToken()); // 행
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		q = new LinkedList<Tomato>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) { // 익은 토마토(1)
					q.offer(new Tomato(i, j, 0));
				}
			}
		}

		System.out.println(bfs());
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	private static int bfs() {
		int max = 0;
		while (!q.isEmpty()) {
			Tomato tomato = q.poll();
			int r = tomato.r;
			int c = tomato.c;
			int day = tomato.day;
			max = Math.max(day, max);
			
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) // 범위 체크
					continue;
				
				if(map[nr][nc] == -1) // 빈칸이면 넘어가
					continue;
				
				if(map[nr][nc] == 1) // 이미 익은 애면 넘어가
					continue;
				
				q.offer(new Tomato(nr, nc, day+1));
				map[nr][nc] = 1; // 익은 토마토로 만들어주기
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) { // 다 돌고 왔는데 안 익은 게 있다면 
					return -1;
				}
			}
		}
		return max;
	}

}
