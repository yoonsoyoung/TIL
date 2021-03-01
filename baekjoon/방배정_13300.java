package com.baekjoon;

import java.util.Scanner;

//��� 292ms
public class �����_13300 {

	static int N, K, S, Y, ans;
	static int[] boy, girl;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();
		boy = new int[7]; // 1: ���л�, 1~6�г�
		girl = new int[7]; // 0: ���л�, 1~6�г�

		for (int i = 0; i < N; i++) {
			S = sc.nextInt(); // ����
			Y = sc.nextInt(); // �г�
			switch (S) {
			case 0: // ���л�
				girl[Y]++;
				break;

			case 1: // ���л�
				boy[Y]++;
				break;
			}
		}

		for (int i = 1; i <= 6; i++) {
			if (girl[i] % K == 0)
				ans += girl[i] / K;
			else
				ans += girl[i] / K + 1;
			if (boy[i] % K == 0)
				ans += boy[i] / K;
			else
				ans += boy[i] / K + 1;

		}

		System.out.println(ans);
	}

}
