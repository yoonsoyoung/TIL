package com.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

/*
4 4 2
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16 
 
5 4 7
1 2 3 4
7 8 9 10
13 14 15 16
19 20 21 22
25 26 27 28

 */

//실패 - 다시 짜기!!! 
public class 배열돌리기_16926 {

	static int[][] a;
	static int N, M, R;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 행
		M = sc.nextInt(); // 열
		R = sc.nextInt(); // 회전 수

		a = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				a[i][j] = sc.nextInt();
				System.out.print(a[i][j] + " ");
			}

			System.out.println();
		}

		int rot = Math.min(N, M) / 2; // 사이클개수가 작은 수의 /2 개

		for (int i = 0; i < R; i++) { // R번만큼 회전
			for (int j = 0; j < rot; j++) { //사이클
				int satrt = a[i][i];
				//상: 왼쪽으로 <
				for (int k = 0; k < M; k++) {
					
				}
				//좌: 아래쪽으로 v
				
				//하: 오른쪽으로 >
				
				//우: 위쪽으로 ^
				
			}
		}

		// 출력
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}

}
