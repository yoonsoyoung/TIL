package com.sw.d3;

import java.util.Arrays;
import java.util.Scanner;

public class Sum_1209 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;
		int MAX_SIZE = 100;
		for (int test_case = 1; test_case <= T; test_case++) {
			int[] sum = new int[4]; //[0]:가로 [1]:세로 [2]:우측대각선 [3]:좌측대각선
			int ans = 0;
			int cn = sc.nextInt(); //케이스 번호
			int[][] arr = new int[MAX_SIZE][MAX_SIZE];
			int garo = 0;
			int[] sero = new int[MAX_SIZE];
			for(int i =0; i<MAX_SIZE; i++) {
				for(int j = 0; j<MAX_SIZE; j++) {
					arr[i][j] = sc.nextInt();
					garo += arr[i][j]; // 가로합, i번째의 가로줄 모두 더함
					sero[j] += arr[i][j]; // 세로합, 각 인덱스를 i행으로 놓고 i번째 j열 값들을 누적해서 더함
					if(i==j) { // 우측 대각선 합 위함
						sum[2] += arr[i][j];
					}
				}
				if(sum[0] <= garo) { // 기존에 있던 가로합보다 새로 더한 합이 크거나 같으면
					sum[0] = garo; // 가로합을 업데이트
				}
				garo = 0;
				for(int j = 0; j<sero.length; j++) { // 세로합의 최대값을 구하기 위함
					if(sum[1] <= sero[j]) {
						sum[1] = sero[j];
					}
				}
				int max = MAX_SIZE;
				sum[3] += arr[i][--max]; // 좌측 대각선 합
				int ans1 = Math.max(sum[0], sum[1]);
				int ans2 = Math.max(sum[2], sum[3]);
				ans = Math.max(ans1, ans2);
			}
			System.out.println("#" + cn + " " + ans);
//			System.out.println(Arrays.toString(sum));
			
		}
	}

}
