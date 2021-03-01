package com.baekjoon;

import java.util.Scanner;

//��� 260ms
public class ������_10163 {

	static int N, J, I, H, W; // N: ������ ��, J: ��, I: ��, H: ����, W:�ʺ�
	static int[][] map = new int[101][101];
	static int[] ans;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		ans = new int[N + 1]; // 1���� N �� �ε����� ���� ����

		for (int n = 1; n <= N; n++) {
			I = sc.nextInt(); // ��
			J = sc.nextInt(); // ��
			H = sc.nextInt(); // (�ʺ� ��������) ���̷� ���
			W = sc.nextInt(); // (���� ��������) �ʺ�� ���

			for (int i = I; i < I + H; i++) {
				for (int j = J; j < J + W; j++) {
					map[i][j] = n;
				}
			}
		}

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				ans[map[i][j]]++;
			}
		}

		for (int i = 1; i <= N; i++) {
			System.out.println(ans[i]);
		}
	}
}
