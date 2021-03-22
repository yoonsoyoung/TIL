package com.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

// ��� 244ms
public class �ܾ����_1339 {

	static int N, ans;
	static String[] s;
	public static void main(String[] args) {
		
		// �� ���ĺ��� ������� �����ϰ� �ڸ����� ���� ������ ��
		// ���ĺ� �� ������ ���� ���� �Ͽ�
		// ū �� ���� �� ���ĺ��� �ο�.
		// ex. ABC + BCD = 100A + 10B + C + 100B + 10C + D = 110B + 100A + 11C + D
		// => B = 9, A = 8, C = 7, D = 6
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // �ܾ� ���� 1<= N <= 10
		s = new String[N];
		int[] alpha = new int[26]; // ���ĺ� ����. A: 65 Z:90
		for (int i = 0; i < N; i++) {
			String s = sc.next();
			for (int j = 0; j < s.length(); j++) {
				// �ش� ���ĺ�(�ε���)�� �ڸ��� ������
				// 1000, 100, 10 �� �ڸ����� ���� �� ������ �Լ��� Math.pow(x, y) ���� ����. x�� y�ŵ�����
				alpha[(s.charAt(j)-'A')] += (int)Math.pow(10, (s.length()-j-1)); // 1�� �ڸ��� 10^0
			}
		}
		
		Arrays.sort(alpha);
		ans = 0;
		int cnt = 9;
		for (int i = 25; i >= 0; i--) {
			if(cnt == 0) break;
			ans += (alpha[i] * cnt);
			cnt--;
		}
		
		System.out.println(ans);
	}

}
