package com.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 카드2_Queue {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Queue<Integer> q = new LinkedList<Integer>();
		
		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}
		
		int ans = 0;
		while(q.size()!=1) {
			q.poll(); //먼저 넣은 애 = 앞 카드 뱀
			ans = q.poll(); //그 다음꺼 빼서 일단 ans에 저장
			q.offer(ans); //맨 끝으로 다시 넣음
		}
		System.out.println(q.poll());
	}

}
