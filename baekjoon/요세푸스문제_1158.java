package com.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class �似Ǫ������_1158 {
	static int N, K;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 1~N ��
		K = sc.nextInt(); // K��° ����
		int cnt = 0;
		Queue<Integer> q = new LinkedList<>();
		int[] ans = new int[N];
		for (int i = 1; i <= N; i++) {
			q.offer(i); //�ϴ� 1~N������ ���ڸ� �ְ�
		}
		while (!q.isEmpty()) { //���� ���� ���� ������ ����
			for (int j = 0; j < K; j++) { //K��° ����Ŭ
				if(j == K-1) { //K��°�� �� �ε����� 0���� �����̴ϱ�
					ans[cnt++] = q.poll(); //��� ���� ����� �迭�� ����
				} else { //�ƴϸ� ��� �ڿ� �̾�ٿ��� ����Ŭ�� �̾
					q.offer(q.poll());
				}
			}
		}
		System.out.print("<");
		for (int i = 0; i < N; i++) {
			System.out.print(ans[i]);
			if(i<N-1) {
				System.out.print(", ");
			}
		}
		System.out.println(">");
	}

}
