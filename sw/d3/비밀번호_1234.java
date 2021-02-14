package com.sw.d3;

import java.util.Scanner;
import java.util.Stack;

public class ��й�ȣ_1234 {

	static int T = 10, N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= T; tc++) {
			Stack<Integer> st = new Stack();
			int pwLen = sc.nextInt(); // ���ڿ� ����
			String pw = sc.next();
			for (int i = 0; i < pwLen; i++) {
				if (st.size() >= 1) { // ������ �� ���� �ִ� ���� ���� ���� ���� ���ٸ�
					int a = st.peek();
					if (a == (int) pw.charAt(i) - '0') {
						st.pop(); // �� �� �� �� ����
						continue; // �������� �ѱ�
					}
				}
				st.push((int) pw.charAt(i) - '0');

			}

			// �� ���
			System.out.print("#" + tc + " ");
			for (int i = 0; i < st.size(); i++) {
				System.out.print(st.get(i));
			}
			System.out.println();
		}
	}

}
