package com.sw.d1;

import java.util.Scanner;

public class 연월일달력_2056 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] dd = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		for (int tc = 1; tc <= T; tc++) {
			int in = sc.nextInt();
			int year = in / 10000;
			int month = (in % 10000) / 100;
			int day = in % 100;

			System.out.print("#" + tc + " ");
			if ((month >= 1 || month <= 12) && (day <= dd[month]))
				System.out.printf("%04d/%02d/%02d\n", year, month, day);
			else
				System.out.println("-1");
		}
	}
}
