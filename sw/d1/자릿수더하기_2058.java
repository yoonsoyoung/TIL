package com.sw.d1;

import java.util.Scanner;

public class �ڸ������ϱ�_2058 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int sum = 0;
		while (n != 0) {
			sum += n % 10; // ���� �ڸ����� ����� ����
			n /= 10; // �����ڸ����� ����...
		}
		System.out.println(sum);
	}

}
