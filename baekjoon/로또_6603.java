package com.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

//���
public class �ζ�_6603 {

	static int k; // ����
	static int[] s, num;// s[] : k�� ���� ����ִ� �迭
	static boolean[] v;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			k = sc.nextInt();

			if (k == 0)
				break;

			s = new int[k];
			num = new int[k];
			v = new boolean[k];

			for (int i = 0; i < k; i++) {
				s[i] = sc.nextInt();
			}

			Arrays.sort(s);
			dfs(0, 0);
			System.out.println();
		}
	}

	static void dfs(int cnt, int start) {
		if (cnt == 6) {
			for (int i = 0; i < 6; i++) {
				System.out.print(num[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = start; i < k; i++) {
				num[cnt] = s[i];
				dfs(cnt + 1, i + 1); //start+1 �ƴϰ� i +1 !!!
		}
	}

}
