package com.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

/*
4 4 2
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16 
 
5 4 7
1 2 3 4
7 8 9 10
13 14 15 16
19 20 21 22
25 26 27 28

 */

//���� - �ٽ� ¥��!!! 
public class �迭������_16926 {

	static int[][] a;
	static int N, M, R;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // ��
		M = sc.nextInt(); // ��
		R = sc.nextInt(); // ȸ�� ��

		a = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				a[i][j] = sc.nextInt();
				System.out.print(a[i][j] + " ");
			}

			System.out.println();
		}

		int rot = Math.min(N, M) / 2; // ����Ŭ������ ���� ���� /2 ��

		for (int i = 0; i < R; i++) { // R����ŭ ȸ��
			for (int j = 0; j < rot; j++) { //����Ŭ
				int satrt = a[i][i];
				//��: �������� <
				for (int k = 0; k < M; k++) {
					
				}
				//��: �Ʒ������� v
				
				//��: ���������� >
				
				//��: �������� ^
				
			}
		}

		// ���
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}

}
