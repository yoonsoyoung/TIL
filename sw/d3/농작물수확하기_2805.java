package com.sw.d3;

import java.util.Scanner;

public class 농작물수확하기_2805 {

	static int T, N;
	static int[][] farm;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); // 농장의 크기
			farm = new int[N][N];
			int ans = 0;
			
			for (int i = 0; i < N; i++) { //farm 배열에 값 입력
				String val = sc.next();
				for (int j = 0; j < N; j++) {
					farm[i][j] = val.charAt(j) - '0';
				}
			}

			//마름모형 농작물 가치 수확
			int mid = N/2;
			int d = mid;
			//윗 삼각형
			for (int i = 0; i < mid ; i++) { //0~가운데줄까지
				for (int j = d; j <N-d; j++) { //가운데부터 시작해서 그 다음줄에는 그 한 칸 전부터... 
					ans += farm[i][j];
				}
				d--;
			}

			//아래 삼각형
			for (int i = mid; i < N; i++) {
				for (int j = d; j < N-d; j++) {
					ans += farm[i][j];
				}
				d++;
			}
			
			System.out.println("#" + tc + " " + ans);
		}
	}

}
