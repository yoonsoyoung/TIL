package com.baekjoon;

import java.util.Scanner;

// 통과 672ms
public class 경로찾기_11403 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 정점의 개수
		int[][] adjM = new int[N][N]; // 인접행렬
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				adjM[i][j] = sc.nextInt();
			}
		}
		// 경유 k - 출발 i (출==경) continue - 도착 j (출==도 || 경==도) continue
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 경유 한 게 더 최소면 갱신
					if (adjM[i][k] ==1 && adjM[k][j] ==1)
						adjM[i][j] = 1;
						
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(adjM[i][j]+ " ");
			}
			System.out.println();
		}
	}

}
