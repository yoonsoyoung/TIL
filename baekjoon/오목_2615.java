package com.baekjoon;

import java.util.Scanner;

public class 오목_2615 {

	static int[][] pan;
	static int ans;
	// 검은돌: 1, 흰돌: 2, 없음: 0
	// 검은돌 승: 1, 흰돌 승: 2, 승부 미결: 0
	// 이긴 돌의 가장 왼쪽에 있는 바둑알 i,j 좌표 출력
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		pan = new int[20][20]; // 1~19까지 쓰기 위함
		for (int i = 1; i <= 19; i++) { // 판 입력
			for (int j = 1; j <= 19; j++) {
				pan[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 1; i <= 19; i++) { 
			for (int j = 1; j <= 19; j++) {
				if(pan[i][j] != 0) {
					omok(i,j);
				}
			}
		}
	}
	
	static int[] dr = { -1, -1, -1, 0, 1, 1, 1, -1 };
	static int[] dc = { -1, 0, 1, 1, 1, 0, -1, 0 };
	private static void omok(int r, int c) {
		
	}

}
