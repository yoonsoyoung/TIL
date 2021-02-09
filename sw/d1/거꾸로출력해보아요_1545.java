package com.sw.d1;

import java.util.Scanner;

public class 거꾸로출력해보아요_1545 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		for(int i = a; i>=0; i--) {
			System.out.print(i + " ");
		}
	}

}
