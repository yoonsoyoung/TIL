package com.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 요세푸스문제_1158 {
	static int N, K;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 1~N 번
		K = sc.nextInt(); // K번째 제거
		int cnt = 0;
		Queue<Integer> q = new LinkedList<>();
		int[] ans = new int[N];
		for (int i = 1; i <= N; i++) {
			q.offer(i); //일단 1~N까지의 숫자를 넣고
		}
		while (!q.isEmpty()) { //뭔가 값이 있을 때까지 돌림
			for (int j = 0; j < K; j++) { //K번째 사이클
				if(j == K-1) { //K번째면 뺌 인덱스는 0부터 시작이니까
					ans[cnt++] = q.poll(); //출력 위한 결과값 배열에 저장
				} else { //아니면 계속 뒤에 이어붙여서 사이클을 이어감
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
