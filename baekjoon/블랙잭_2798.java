package com.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class ����_2798 {

	static int N, M, ans;
	static int[] card;
	static int[] num;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // ī�� ����
		M = sc.nextInt(); // ��

		card = new int[N];
		num = new int[3]; //3�常 ���� ��
		ans = 0;

		for (int i = 0; i < N; i++) {
			card[i] = sc.nextInt();
		}

		combi(0, 0);
		System.out.println(ans);
	}

	private static void combi(int cnt, int start) {
		if (cnt ==3) {
			int sum = 0;
			for (int i = 0; i < 3; i++) {
				sum += num[i];
			}
			
			if(sum <= M && sum >= ans) //M�� �ִ��� ������ ���� �ִ밪�� ����
				ans = sum;
			return;
		}

		for (int i = start; i < N; i++) {
			num[cnt] = card[i];
			combi(cnt+1, i+1); //start+1 �ƴϰ� i+1 �����ϱ�
		}
	}

}
