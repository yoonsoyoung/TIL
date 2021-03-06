package com.baekjoon;

import java.util.Scanner;

//��� 1560ms
public class ���谨��_13458 {

	static int N, b, c;
	static int[] a;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // ������ ���� 1<=N<=1,000,000
		a = new int[N];
		for (int i = 0; i < N; i++) { // �� �����忡 �ִ� �������� �� 1<= <= 1,000,000
			a[i] = sc.nextInt();
		}

		b = sc.nextInt(); // �Ѱ����� ���� ���� �� <= 1,000,000
		c = sc.nextInt(); // �ΰ����� ���� ���� �� <= 1,000,000

		long cnt = 0;
		for (int i = 0; i < N; i++) {
			a[i] -= b; // �Ѱ����� �� ���
			cnt++;
			if (a[i] > 0) { // �� ���� �ʼ�
				if (a[i] % c == 0)
					cnt += a[i] / c;
				else
					cnt += a[i] / c + 1;
			}
		}

		System.out.println(cnt);
	}

}
