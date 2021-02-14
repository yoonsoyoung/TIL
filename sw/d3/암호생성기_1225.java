package com.sw.d3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
1
10 6 12 8 9 4 1 3
 */
public class ��ȣ������_1225 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		Queue<Integer> q = new LinkedList<Integer>();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // ���̽� ��ȣ�ε� ��������
			for (int i = 0; i < 8; i++) {
				int num = sc.nextInt();
				q.offer(num);
			}
			int p = 0;
			boolean check = true;

			while (check) {
				for (int i = 1; i <= 5; i++) {
					p = q.poll();
					p = p-i; //���ְ�
					if (p <= 0) {
						q.offer(0);
						check = false;
						break;
					}
					q.offer(p); //�־�� ��. offer(p-i) �� �ϸ� �ȳ���..!
				}
			}
			System.out.print("#" + tc + " ");
			for (int i = 0; i < 8; i++) {
				System.out.print(q.poll() + " ");
			}
			System.out.println();
		}
	}

}
