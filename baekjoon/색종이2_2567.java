package com.baekjoon;

import java.util.Scanner;

public class ������2_2567 {
	static int left;
	static int bottom;
	static int[][] paper;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		paper = new int[102][102]; //���� �׵θ� ũ��

		int T = sc.nextInt();
		int ans = 0;
		for (int tc = 0; tc < T; tc++) {
			left = sc.nextInt();
			bottom = sc.nextInt();

			for (int i = left;  i < left + 10; i++) {
				for (int j = bottom;  j < bottom + 10; j++) {
					if (paper[i][j] == 1) // �̹� 1�̸�
						continue;
					paper[i][j] = 1;
				}
			}
		}

		for (int i = 0; i < 100; i++) {
			for (int j = 0;  j < 100; j++) {
				if (paper[i][j] == 1) { // ä���� �����̿��� �ѷ��� �ؾ��ϹǷ�
					for (int d = 0; d < 4; d++) { // ���Ž�� �� ����� ��� 1�̸� �����̶�� ��. �װ� �ƴ� ��쿡 �ѷ��� 1��������
						int nR = i + dr[d]; // ��
						int nC = j + dc[d]; // ��
						if (paper[nR][nC] == 0)
							ans++;
					}
				}
			}
		}
		System.out.println(ans);
	}

}
