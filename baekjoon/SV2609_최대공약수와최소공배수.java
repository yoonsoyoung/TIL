package com.baekjoon;

import java.util.Scanner;

//���
public class SV2609_�ִ��������ּҰ���� {

	static int a, b;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		a = sc.nextInt();
		b = sc.nextInt();
		int remain = 1; // ������
		int max = Math.max(a, b);
		int min = Math.min(a, b);
		while (true) { //��Ŭ���� ȣ���� : �ִ�����
			remain = max % min;
			if (remain == 0) {
				System.out.println(min);
				break;
			}
			max = min;
			min = remain;
		}

		//�ּ� ����� = �� ���� �� / �ִ�����
		System.out.println(a*b/min);
	}

}
