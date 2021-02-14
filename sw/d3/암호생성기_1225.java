package com.sw.d3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
1
10 6 12 8 9 4 1 3
 */
public class 암호생성기_1225 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		Queue<Integer> q = new LinkedList<Integer>();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 케이스 번호인데 무용지물
			for (int i = 0; i < 8; i++) {
				int num = sc.nextInt();
				q.offer(num);
			}
			int p = 0;
			boolean check = true;

			while (check) {
				for (int i = 1; i <= 5; i++) {
					p = q.poll();
					p = p-i; //빼주고
					if (p <= 0) {
						q.offer(0);
						check = false;
						break;
					}
					q.offer(p); //넣어야 함. offer(p-i) 로 하면 안나옴..!
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
