package com.baekjoon;

import java.util.Scanner;

//통과 260ms
public class 색종이_10163 {

	static int N, J, I, H, W; // N: 색종이 수, J: 행, I: 열, H: 높이, W:너비
	static int[][] map = new int[101][101];
	static int[] ans;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		ans = new int[N + 1]; // 1부터 N 의 인덱스를 쓰기 위함

		for (int n = 1; n <= N; n++) {
			I = sc.nextInt(); // 행
			J = sc.nextInt(); // 열
			H = sc.nextInt(); // (너비 차례지만) 높이로 취급
			W = sc.nextInt(); // (높이 차례지만) 너비로 취급

			for (int i = I; i < I + H; i++) {
				for (int j = J; j < J + W; j++) {
					map[i][j] = n;
				}
			}
		}

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				ans[map[i][j]]++;
			}
		}

		for (int i = 1; i <= N; i++) {
			System.out.println(ans[i]);
		}
	}
}
