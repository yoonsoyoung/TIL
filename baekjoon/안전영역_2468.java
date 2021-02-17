package com.baekjoon;

import java.util.Scanner;

//���
public class ��������_2468 {

	static int N, ans, cnt, maxAns;
	static int[][] map; //����
	static int[][] zone; //�帶 ��

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		map = new int[N][N];
		zone = new int[N][N];
		int high = 0; // ���� ���� ���� �˱� ����
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				high = Math.max(high, map[i][j]);
			}
		}
		maxAns = 0;
		cnt = 0; //���� �� -> �ƹ� ������ ���� ����� ���� ���� �ִٴ� ������ �ֱ� ������ 0���� ����� ��.
		while(cnt < high) {
			ans = 0;
//			System.out.println("���� �� : " + cnt);
			for (int i = 0; i < N; i++) { //�帶 �� ��-> zone
				for (int j = 0; j < N; j++) {
					if (map[i][j] <= cnt) {
						zone[i][j] = 0;
					} else
						zone[i][j] = 1;
//					System.out.print(zone[i][j] +" ");
				}
//				System.out.println();
			}
			
			for (int i = 0; i < N; i++) { //�� zone�� ������ ��� ���� 0, ������ 1
				for (int j = 0; j < N; j++) {
					if(zone[i][j] == 1) {
						safeZone(i, j);
						ans++;
					}
				}
			}
//			System.out.println(ans);
			maxAns = Math.max(maxAns, ans);
			cnt++;
		}
		
		System.out.println(maxAns);

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	private static void safeZone(int r, int c) {
		zone[r][c] = 0; // �ش� �ڸ� 0���� �ٲٰ�

		for (int d = 0; d < 4; d++) { // ���˻�
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr < 0 || nc < 0 || nr >= N || nc >= N) // ���� ����� ����
				continue;
			if (zone[nr][nc] == 1) { // ���̰�
				safeZone(nr, nc);
			}

		}
		
	}

}
