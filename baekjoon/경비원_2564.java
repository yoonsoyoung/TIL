package com.baekjoon;

import java.util.Scanner;

// 통과
public class 경비원_2564 {

	static int r, c, store;
	static int[] dist;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		c = sc.nextInt(); // 가로, 열
		r = sc.nextInt(); // 세로, 행
		int circ = (c + r) * 2; // 둘레
		store = sc.nextInt(); // 가게 수
		dist = new int[store + 1]; // 마지막은 동근 위치

		for (int i = 0; i < dist.length; i++) {
			int dir = sc.nextInt(); // 방향
			int pos = sc.nextInt(); // 위치
			// 반대 방향은 둘레를 이용
			// 시계 방향은 0,0을 기준으로 거리 통일
			// - 북1: 그냥 위치, 동4: 가로+거리, 남2: 가로+세로+(가로-내거리), 서3: 둘레-내거리
			switch (dir) { // 시계방향에서의 거리
			case 1: // 북= pos
				dist[i] = pos;
				break;

			case 2: // 남= c + r + c - pos
				dist[i] = c + r + c - pos;
				break;

			case 3: // 서= circ - pos
				dist[i] = circ - pos;
				break;

			case 4: // 동= c + pos
				dist[i] = c + pos;
				break;
			}
		}
		// 상점갯수 만큼 돌면서
		int myDist = dist[store];
		int ans = 0;
		for (int j = 0; j < store; j++) {
			// 시계 방향은 내 위치(dist 배열의 마지막 값)에서 각 나와의 거리를 뺀 거에 절댓값
			// 나: 22 / 1: 4 / 2: 27/ 3: 17 / 둘레:30
			int clock = Math.abs(myDist - dist[j]);
			// 반시계 방향은 둘레에서 시계방향 거리 뺀 값.
			// 둘 중 더 최소인 값을 누적합하면 답
			// 나와 1 18,12 / 나와 2 6, 24 / 나와 3
			ans += Math.min(clock, circ - clock);

		}
		System.out.println(ans);
	}

}
