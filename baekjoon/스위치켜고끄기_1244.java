package com.baekjoon;

import java.util.Scanner;

//뭐가 틀린거져
public class 스위치켜고끄기_1244 {

	static int N, K, S, sNum;
	static int[] condi;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 스위치 개수
		condi = new int[N + 1]; // 1~N까지 쓰기위함

		for (int i = 1; i <= N; i++) {
			condi[i] = sc.nextInt();
		}

		K = sc.nextInt(); // 학생 수
		for (int k = 0; k < K; k++) {
			S = sc.nextInt(); // 성별
			sNum = sc.nextInt(); // 번호

			if (S == 1) { // 남학생
				for (int i = 1; i <= N; i++) {
					if (i % sNum == 0)
						change(i);
				}

			} else { // 여학생
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
