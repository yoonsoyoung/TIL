package com.sw.d1;

import java.util.Scanner;

public class �����Ǻ�й�ȣ_2043 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int p = sc.nextInt();
		int k = sc.nextInt();
		int cnt = 1;
		for (int i = k; i <= p; i++) {
			if (i == p) {
				System.out.println(cnt);
			} else
				cnt++;
		}
	}

}
