package com.sw.d1;

import java.util.Scanner;

public class Å«³ğÀÛÀº³ğ°°Àº³ğ_2070 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			char ans;
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(a<b)
				ans = '<';
			else if(a==b)
				ans = '=';
			else
				ans = '>';
			System.out.println("#" + tc + " " + ans);
		}
	}

}
