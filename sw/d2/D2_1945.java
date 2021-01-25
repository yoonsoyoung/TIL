package com.sw.d2;

import java.util.Scanner;

public class D2_1945 {

	public static void main(String[] args) {
		// 소인수분해
		// N = 2^a * 3^b * 5^c * 7^d * 11^e
		// (2 <= N <= 10,000,000)

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt(); // 테스트 케이스 개수

		int[] n = new int[T];
		for (int test_case = 1; test_case <= T; test_case++) {
			n[test_case] = sc.nextInt();

			while (true) {
				if (n[test_case] == 1) {
					return;
				} else {
					for (int i = 2; i <= n[test_case]; i++) {

					}
				}
			}

		}
	}

}
