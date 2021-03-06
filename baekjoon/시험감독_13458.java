package com.baekjoon;

import java.util.Scanner;

//통과 1560ms
public class 시험감독_13458 {

	static int N, b, c;
	static int[] a;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 시험장 개수 1<=N<=1,000,000
		a = new int[N];
		for (int i = 0; i < N; i++) { // 각 시험장에 있는 응시자의 수 1<= <= 1,000,000
			a[i] = sc.nextInt();
		}

		b = sc.nextInt(); // 총감독관 감시 가능 수 <= 1,000,000
		c = sc.nextInt(); // 부감독관 감시 가능 수 <= 1,000,000

		long cnt = 0;
		for (int i = 0; i < N; i++) {
			a[i] -= b; // 총감독은 한 명뿐
			cnt++;
			if (a[i] > 0) { // 이 조건 필수
				if (a[i] % c == 0)
					cnt += a[i] / c;
				else
					cnt += a[i] / c + 1;
			}
		}

		System.out.println(cnt);
	}

}
