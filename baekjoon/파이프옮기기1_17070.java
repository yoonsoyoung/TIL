package com.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

//���
public class �������ű��1_17070 {

	static int N, ans;
	static int[][] house;
	static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		house = new int[N + 1][N + 1]; // 1,1 ���� �����ϱ� ����
		visited = new boolean[N + 1][N + 1];
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				house[r][c] = sc.nextInt();
			}
		}

		// ������ �������� Ž�� ���� 3���� dr= {0,1,1}, dc={1,0,1} ����: 0,1 ����: 1,0, �밢��: 1,1
		// 1.���� : 1)�б� f(r,c) b(r,c+1) -> nf(r, c+1) nb(r,c+2) => nf=cb , nb=(cr,cc+1)
		// => �������� �����ǰ� ������ ���� ��ǥ���� c+1
		// 2)�а� �밢��: f(r, c) b(r,c+1) -> nf(r,c+1) nb(r+1, c+1) => nf=cb, nb(cr+1, cc+1)
		// => �������� ������ �ǰ� ������ ������ǥ���� r+1, c+1
		// 2.���� : 1) �б� f(r,c) b(r+1, c) -> nf(r+1, c) nb(r+2, c) => nf=cb, nb(cr+1, cc)
		// => �������� �����ǰ� ������ ���� ��ǥ���� r+1
		// 2) �а� �밢�� : f(r, c) b(r+1, c) -> nf(r+1, c) nb(r+2, c+1) => nf=cb, nb(cr+1, cc+1);
		// 3.�밢�� : �������� �����ǰ�, ������ ���� ������ǥ���� ( ���� c+1 || ���� r+1 || �밢�� r+1, c+1 )

		// ó�� �������� (1,1), (1,2)
		visited[1][1] = true;
		visited[1][2] = true;

		ans = 0;
		dfs(1, 2, 1); // ������ �������� ����, ���κ��� Ž��
		System.out.println(ans);
	}

	static int[] dr = { 0, 1, 1 };
	static int[] dc = { 1, 0, 1 };

	private static boolean deltaCheck(int r, int c) {

		if (r < 1 || c < 1 || c > N || r > N || house[r][c] == 1)
			return false;
		return true;
	}

//	private static boolean deltaCheck(int r, int c, int dir) {
//
//		for (int d = 0; d < 3; d++) { // ����� Ž��
//			int nr = r + dr[d];
//			int nc = c + dc[d];
//			if (nr < 1 || nc < 1 || nc > N || nr > N || house[nr][nc] == 1)
//				return false;
//		}
//		return true;
//	}

	private static void dfs(int r, int c, int dir) {
		if (r == N && c == N) { // ���� �ٴٸ���
			ans++;
			return;
		}

		if (dir == 1) { // 1. ����
			// 1) ���� �б�
			if (deltaCheck(r, c + 1))
				dfs(r, c + 1, 1);
			// 2) �밢�� ȸ��
			if (deltaCheck(r + 1, c + 1) && deltaCheck(r, c + 1) && deltaCheck(r + 1, c))
				dfs(r + 1, c + 1, 3);
		} else if (dir == 2) { // 2. ����
			// 1) ���� �б�
			if (deltaCheck(r + 1, c))
				dfs(r + 1, c, 2);
			// 2) �밢�� ȸ��
			if (deltaCheck(r + 1, c + 1) && deltaCheck(r, c + 1) && deltaCheck(r + 1, c))
				dfs(r + 1, c + 1, 3);
		} else if (dir == 3) { // 3. �밢��
			// 1) ����
			if (deltaCheck(r, c + 1))
				dfs(r, c + 1, 1);
			// 2) ����
			if (deltaCheck(r + 1, c))
				dfs(r + 1, c, 2);
			// 3) �밢��
			if (deltaCheck(r + 1, c + 1) && deltaCheck(r, c + 1) && deltaCheck(r + 1, c))
				dfs(r + 1, c + 1, 3);
		}

	}

}
