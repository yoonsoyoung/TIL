package com.sw.d1;

import java.util.Scanner;

public class 자릿수더하기_2058 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int sum = 0;
		while (n != 0) {
			sum += n % 10; // 일의 자리부터 끊어가며 저장
			n /= 10; // 일의자리부터 끊고...
		}
		System.out.println(sum);
	}

}
