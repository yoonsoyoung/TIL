package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// ��� 580ms
public class ���̵ǰ��¿�����_1600 {
	static int K, W, H, ans;
	static boolean[][][] visitied; // ��, ��, �� �̵�Ƚ��
	static int[][] map;

	static class Node {
		int r; // ��
		int c; // ��
		int cnt; // �̵�
		int k; // ��ó�� �̵� Ƚ��

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

		K = Integer.parseInt(br.readLine()); // ������ �� �ִ� Ƚ�� 0<= K <= 30

		st = new StringTokenizer(br.readLine(), " ");
		W = Integer.parseInt(st.nextToken()); // ����, �� 1<= W <= 200
		H = Integer.parseInt(st.nextToken()); // ����, �� 1<= H <= 200

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

			if (r == H - 1 && c == W - 1) { // ����
				ans = cnt;
				return;
			}

			// ��� Ž��
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (nr < 0 || nc < 0 || nr >= H || nc >= W) // ���� �Ѿ
					continue;
				if (map[nr][nc] == 1) // ��ֹ���
					continue;
				if(visitied[nr][nc][k]) // �湮�� ����
					continue;
				visitied[nr][nc][k] = true;
				q.add(new Node(nr,nc,cnt+1,k));
				
			}
			if (k < K) { // �� ó�� ������ �� �ִٸ�
				for (int d = 0; d < 8; d++) {
					int nr = r + hr[d];
					int nc = c + hc[d];

					if (nr < 0 || nc < 0 || nr >= H || nc >= W) // ���� �Ѿ
						continue;
					if (map[nr][nc] == 1) // ��ֹ���
						continue;
					if(visitied[nr][nc][k+1]) // �湮�� ����
						continue;
					visitied[nr][nc][k+1] = true;
					q.add(new Node(nr,nc,cnt+1, k+1));
				}
			}

		}
	}

}
