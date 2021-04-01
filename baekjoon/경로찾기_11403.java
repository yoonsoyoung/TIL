package com.baekjoon;

import java.util.Scanner;

// ��� 672ms
public class ���ã��_11403 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // ������ ����
		int[][] adjM = new int[N][N]; // �������
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				adjM[i][j] = sc.nextInt();
			}
		}
		// ���� k - ��� i (��==��) continue - ���� j (��==�� || ��==��) continue
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// ���� �� �� �� �ּҸ� ����
					if (adjM[i][k] ==1 && adjM[k][j] ==1)
						adjM[i][j] = 1;
						
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(adjM[i][j]+ " ");
			}
			System.out.println();
		}
	}

}
