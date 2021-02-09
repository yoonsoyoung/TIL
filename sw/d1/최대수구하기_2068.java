package com.sw.d1;

import java.util.Scanner;

public class 최대수구하기_2068 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int ans = 0;
			for (int i = 0; i < 10; i++) {
				int a = sc.nextInt();
				if (ans < a)
					ans = a;
			}
			System.out.println("#" + tc + " " + ans);
		}
	}

}
