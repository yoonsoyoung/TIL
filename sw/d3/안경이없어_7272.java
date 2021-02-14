package com.sw.d3;

import java.util.Scanner;

public class �Ȱ��̾���_7272 {

	static int T;
	static String[] zeroHole = { "C", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "S", "T", "U", "V", "W", "X",
			"Y", "Z" };
	static String[] oneHole = { "A", "D", "O", "P", "Q", "R" };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();
		boolean ans = false;

		for (int tc = 1; tc <= T; tc++) {
			String a = sc.next();
			String b = sc.next();

			if (a.length() != b.length()) { // �� ���ڿ��� ���̰� �ٸ� ���
				ans = false;
			} else {
				for (int i = 0; i < zeroHole.length; i++) { // ���� ���� ���ĺ� ġȯ
					if (a.contains(zeroHole[i]))
						a = a.replaceAll(zeroHole[i], "0");
					if (b.contains(zeroHole[i]))
						b = b.replaceAll(zeroHole[i], "0");
				}

				for (int i = 0; i < oneHole.length; i++) { // ���� �ϳ� ���ĺ� ġȯ
					if (a.contains(oneHole[i]))
						a = a.replaceAll(oneHole[i], "1");
					if (b.contains(oneHole[i]))
						b = b.replaceAll(oneHole[i], "1");
				}

				for (int i = 0; i < a.length(); i++) { //�� ���ڿ��� ��
					if(a.equals(b))
						ans = true;
					else
						ans = false;
				}
			}

			System.out.println("#" + tc + " " + (ans ? "SAME" : "DIFF"));
		}
	}

}
