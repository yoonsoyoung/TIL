package com.baekjoon;

import java.util.Scanner;

public class ����_2615 {

	static int[][] pan;
	static int ans;
	// ������: 1, ��: 2, ����: 0
	// ������ ��: 1, �� ��: 2, �º� �̰�: 0
	// �̱� ���� ���� ���ʿ� �ִ� �ٵϾ� i,j ��ǥ ���
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		pan = new int[20][20]; // 1~19���� ���� ����
		for (int i = 1; i <= 19; i++) { // �� �Է�
			for (int j = 1; j <= 19; j++) {
				pan[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 1; i <= 19; i++) { 
			for (int j = 1; j <= 19; j++) {
				if(pan[i][j] != 0) {
					omok(i,j);
				}
			}
		}
	}
	
	static int[] dr = { -1, -1, -1, 0, 1, 1, 1, -1 };
	static int[] dc = { -1, 0, 1, 1, 1, 0, -1, 0 };
	private static void omok(int r, int c) {
		
	}

}
