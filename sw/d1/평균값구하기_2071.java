package com.sw.d1;

import java.util.Scanner;

public class 평균값구하기_2071 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		double[] arr = new double[10];

		for (int tc = 1; tc <= T; tc++) {
			double ans = 0;
			for (int i = 0; i < 10; i++) {
				arr[i] = sc.nextDouble();
				ans += arr[i];
			}
			System.out.println("#" + tc + " " + Math.round(ans/10));
		}
	}

}
