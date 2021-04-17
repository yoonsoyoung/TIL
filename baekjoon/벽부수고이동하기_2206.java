package com.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// ��� 828ms
public class ���μ����̵��ϱ�_2206 {

	static int N, M, ans;
	static boolean[][][] visited; // ��, ��, �μ�����[0]: �Ⱥμ�, [1]: �μ�
	static int[][] map;

	static Node[] adjList;

	static class Node {
		int y; // ��
		int x; // ��
		int cnt; // �̵�
		boolean destr; // �μ� ����

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
		N = sc.nextInt(); // ��
		M = sc.nextInt(); // ��

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

		q.offer(new Node(0, 0, 1, false)); // ��, ��, �̵�, �μ�����
		visited[0][0][0] = true; // 0,0 ���� �����ϴµ� �Ⱥμ� ����

		while (!q.isEmpty()) {
			Node curr = q.poll();
			int c = curr.x; // �� M
			int r = curr.y; // �� N

			if (c == M - 1 && r == N - 1) { // ����
				ans = curr.cnt;
				return;
			}

			// ���Ž��
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M) { // ���� üũ
					continue;
				}

				// ���� ���·� ���� ��ġ �湮
				if (visited[nr][nc][curr.destr ? 1 : 0])
					continue;

				if (map[nr][nc] == 1 && !curr.destr) { // ��
					// �μ� �� �ְ� ���� �湮���� �ʾҴٸ� ���� �μ��� �湮üũ
					visited[nr][nc][1] = true;
					// q�� ���� (��, ��, Ƚ��+1, true) ���� �ֱ�
					q.offer(new Node(nr, nc, curr.cnt + 1, true));
				} 
				if (map[nr][nc] == 0){ // �� �ƴ� -> ���� else �� �ƴ�!
					visited[nr][nc][curr.destr ? 1 : 0] = true;
					q.offer(new Node(nr, nc, curr.cnt + 1, curr.destr));
				}

			}

		}
	}
}
