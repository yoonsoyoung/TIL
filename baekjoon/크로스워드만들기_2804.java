package com.baekjoon;

import java.util.Scanner;

public class 크로스워드만들기_2804 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String a = sc.next();
		String b = sc.next();
		char[] cA = new char[a.length()];
		char[] cB = new char[b.length()];
		int pointR = 0;
		int pointC = 0;

		for (int i = 0; i < a.length(); i++) {
			cA[i] = a.charAt(i);
		}
		for (int i = 0; i < b.length(); i++) {
			cB[i] = b.charAt(i);
		}

		int cnt = 0;
		boolean check = true;
		while (check) {
			for (int j = 0; j < b.length(); j++) {
				if (cB[j] == cA[cnt]) {
					pointR = j;
					pointC = cnt;
					check = false;
					break;
				}
			}
			cnt++;
		}

		for (int i = 0; i < cB.length; i++) {
			if (i == pointR) { // 그 행이면
				System.out.println(a); // a문자 그대로 출력
			} else {
				for (int j = 0; j < cA.length; j++) {
					if (j == pointC)
						System.out.print(cB[i]);
					else
						System.out.print(".");

				}
				System.out.println();
			}
		}
	}

}
