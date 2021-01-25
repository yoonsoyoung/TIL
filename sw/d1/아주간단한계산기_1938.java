package com.sw.d1;

import java.util.Scanner;

public class 아주간단한계산기_1938 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a, b;
		a = sc.nextInt();
		b = sc.nextInt();
		if (a >= 1 && a <= 9 && b >= 1 && b <= 9) {
			System.out.println(a + b);
			System.out.println(a - b);
			System.out.println(a * b);
			System.out.println(a / b);
		}

	}

}
