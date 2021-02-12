package com.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ī��2_Queue {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Queue<Integer> q = new LinkedList<Integer>();
		
		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}
		
		int ans = 0;
		while(q.size()!=1) {
			q.poll(); //���� ���� �� = �� ī�� ��
			ans = q.poll(); //�� ������ ���� �ϴ� ans�� ����
			q.offer(ans); //�� ������ �ٽ� ����
		}
		System.out.println(q.poll());
	}

}
