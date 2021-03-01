package com.baekjoon;

import java.util.Scanner;

//통과
public class SV2609_최대공약수와최소공배수 {

	static int a, b;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		a = sc.nextInt();
		b = sc.nextInt();
		int remain = 1; // 나머지
		int max = Math.max(a, b);
		int min = Math.min(a, b);
		while (true) { //유클리드 호제법 : 최대공약수
			remain = max % min;
			if (remain == 0) {
				System.out.println(min);
				break;
			}
			max = min;
			min = remain;
		}

		//최소 공배수 = 두 수의 곱 / 최대공약수
		System.out.println(a*b/min);
	}

}
