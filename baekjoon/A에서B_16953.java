package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ��� 164ms
public class A����B_16953 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());

		// B���� A�� �������ϱ�
		// B�� �� �ڸ��� 1�̸� 1 ����, 2�� ����
		// B�� A�� ������ �� ���� �ݺ�. �̶� B�� A���� �۾����� -1 ���

		int cnt = 1; // ó�� ���ں��� Ƚ�� ����
		while (B != A) {
			if (B < A) { // �ݺ� ���ٰ� B�� A���� �۾����� ���� �� ���� ���
				System.out.println("-1");
				System.exit(0);
			}

			// ���ʿ� 2�ε� �ȳ������� �� �ڸ��� 1�� �ƴ϶�� ���� �� ���� ���
			String s = Long.toString(B);
			String last = s.substring(s.length() - 1, s.length());
			if ((!last.equals("1")) && B % 2 != 0) {
				System.out.println("-1");
				System.exit(0);
			}

			if (B % 2 == 0) {
				B /= 2;
			} else {
				s = s.substring(0, s.length() - 1);
				B = Long.parseLong(s);
			}

			cnt++;
		}
		
		System.out.println(cnt);
	}

}
