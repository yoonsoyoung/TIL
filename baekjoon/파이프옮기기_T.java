package com.baekjoon;

import java.util.Scanner;

public class �������ű��_T {
//3�� Ʈ���� ����

	static int N, ans;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		ans = 0;
		dfs(0,1,0); //0,1���� ������ ������ ���� ����
		//0: ������, 1: ����, 2: �밢��
		System.out.println(ans);
		
	}

	static void dfs(int r, int c, int dir) {
		if (r == N - 1 && c == N - 1) {
			ans++;
			return;
		}

		// �κ������� ���� ��. �� ���� ��. ���
		// ���������� �� �� ������ ����������
		if (dir != 1 && c + 1 < N && map[r][c + 1] == 0) { // ���� �Ʒ��� ���� ���� �ʰ�, �����ʿ� ������ ���������鼭 ��ֹ��� ����� ��
			dfs(r, c + 1, 0);
		}

		// �Ʒ��� �� �� ������ �Ʒ���
		if (dir != 0 && r + 1 < N && map[r + 1][c] == 0) {
			dfs(r + 1, c, 1);
		}

		// �밢���� �� �� ������
		if (r + 1 < N && c + 1 < N && map[r + 1][c] + map[r][c + 1] + map[r + 1][c + 1] == 0) { // ��� ������ ��ֹ��� ���ٴ� �� ����
			dfs(r + 1, c + 1, 2);
		}
	}

}
