package com.sw.d1;

import java.util.Scanner;

public class 더블더블_2019 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int ans = 1;
		for(int i =0; i<=a; i++) {
			System.out.print(ans + " ");
			ans *= 2;
		}
	}

}
