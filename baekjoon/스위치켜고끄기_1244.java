package com.baekjoon;

import java.util.Scanner;

//���� Ʋ������
public class ����ġ�Ѱ����_1244 {

	static int N, K, S, sNum;
	static int[] condi;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // ����ġ ����
		condi = new int[N + 1]; // 1~N���� ��������

		for (int i = 1; i <= N; i++) {
			condi[i] = sc.nextInt();
		}

		K = sc.nextInt(); // �л� ��
		for (int k = 0; k < K; k++) {
			S = sc.nextInt(); // ����
			sNum = sc.nextInt(); // ��ȣ

			if (S == 1) { // ���л�
				for (int i = 1; i <= N; i++) {
					if (i % sNum == 0)
						change(i);
				}

			} else { // ���л�
				for (int j = 1; j <= N; j++) {
					if ((sNum - j > 0 && sNum + j <= N) && condi[sNum - j] == condi[sNum + j]) {
						change(sNum - j);
						change(sNum + j);
					} else {
						change(sNum);
						break;
					}
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			System.out.print(condi[i] + " ");
			if (i % 20 == 0) {
				System.out.println();
			}
		}
	}

	static void change(int b) {
		if (condi[b] == 1)
			condi[b] = 0;
		else
			condi[b] = 1;

	}
}
