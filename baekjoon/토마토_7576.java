package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// ��� 716ms
public class �丶��_7576 {

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

		M = Integer.parseInt(st.nextToken()); // ��
		N = Integer.parseInt(st.nextToken()); // ��
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
				if (map[i][j] == 1) { // ���� �丶��(1)
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
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) // ���� üũ
					continue;
				
				if(map[nr][nc] == -1) // ��ĭ�̸� �Ѿ
					continue;
				
				if(map[nr][nc] == 1) // �̹� ���� �ָ� �Ѿ
					continue;
				
				q.offer(new Tomato(nr, nc, day+1));
				map[nr][nc] = 1; // ���� �丶��� ������ֱ�
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) { // �� ���� �Դµ� �� ���� �� �ִٸ� 
					return -1;
				}
			}
		}
		return max;
	}

}
