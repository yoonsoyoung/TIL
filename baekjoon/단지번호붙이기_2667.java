package com.baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//���
public class ������ȣ���̱�_2667 {

	static int N, ans, idx;
	static int[][] map;
	static int[] houseCnt; 

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];

		for (int i = 0; i < N; i++) { // ���� �Է�
			String s = sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = (int) s.charAt(j) - '0'; // j ���ڰ� !!!
			}
		}

		idx = 0;
		houseCnt = new int[N*N]; //�밢������ ���� ���� ���� ���� �����ϱ� N������ �ݸ�ŭ
		for (int i = 0; i < N; i++) { // ���� ã��
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					dfs(i, j); //Ž��
					idx++; //���� ����
				}

			}
		}
		System.out.println(idx);
		Arrays.sort(houseCnt, 0, idx);
		for (int i = 0; i < idx; i++) {
			System.out.println(houseCnt[i]);
		}

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int cnt;

	private static void dfs(int r, int c) {
		map[r][c] = 0;
		houseCnt[idx]++;

		for (int d = 0; d < 4; d++) { //���Ž��
			int nr = r + dr[d];
			int nc = c + dc[d]; //dc ����� ����!
			if (nr < 0 || nc < 0 || nr >= N || nc >= N)
				continue;
			if (map[nr][nc] == 1)
				dfs(nr, nc);
		}
	}

}
