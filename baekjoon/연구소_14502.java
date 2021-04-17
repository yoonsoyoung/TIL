package com.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// ��� 1068ms
public class ������_14502 {

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
		N = sc.nextInt(); // ����, ��
		M = sc.nextInt(); // ����, ��

		map = new int[N][M];

		// ���� �迭(map)
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		// DFS - �� ����� : 3�� ������ �� BFSȣ��, �������� cnt++ -> max ������Ʈ
		// BFS - ���̷��� ��Ʈ����
		ans = 0;
		dfs(0);
		System.out.println(ans);
	}

	static void dfs(int cnt) { // �� �����
		// ���� ����
		if (cnt == 3) {
			// virus Ÿ�� ť ����
			temp = new int[N][M];
			// ���纻 �迭 ����鼭
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					temp[i][j] = map[i][j];
				}
			}
			ans = Math.max(ans, bfs());
			return;
		}

		// map ���鼭
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// �ش� ĭ �̹湮�̰� �� �� �ִ� ���̸�
				if (map[i][j] == 0) {
					// �ش� ĭ �� �����
					map[i][j] = 1;
					// ���
					dfs(cnt + 1);
					// �� ����
					map[i][j] = 0;
				}
			}
		}
	}

	private static int bfs() { // ���̷��� ��Ʈ����
		// virus Ÿ�� ť ����
		Queue<virus> q = new LinkedList<virus>();
		// ���纻 �迭 ���鼭 ���̷����� ������
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (temp[i][j] == 2)
					// ť�� ����
					q.add(new virus(i, j));
			}
		}

		// ť�� �� ������ �ݺ���
		while (!q.isEmpty()) {
			// virus v = q.poll();
			virus v = q.poll();
			int r = v.r;
			int c = v.c;
			// ��� Ž��
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				// ���� üũ
				if (nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;
				// 0 �� �� ���̷���(2) �� ����
				if (temp[nr][nc] == 0) {
					temp[nr][nc] = 2;
					// ť�� ����
					q.add(new virus(nr, nc));
				}
			}

		}
		int cnt = 0;
		// ���� ���纻 �迭 ���鼭
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// 0�� �� ������ cnt ����
				if (temp[i][j] == 0)
					cnt++;
			}
		}
		return cnt;
	}

}
