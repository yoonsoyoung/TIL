package com.baekjoon;

import java.util.Scanner;

//통과 292ms
public class 방배정_13300 {

	static int N, K, S, Y, ans;
	static int[] boy, girl;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();
		boy = new int[7]; // 1: 남학생, 1~6학년
		girl = new int[7]; // 0: 여학생, 1~6학년

		for (int i = 0; i < N; i++) {
			S = sc.nextInt(); // 성별
			Y = sc.nextInt(); // 학년
			switch (S) {
			case 0: // 여학생
				girl[Y]++;
				break;

			case 1: // 남학생
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
