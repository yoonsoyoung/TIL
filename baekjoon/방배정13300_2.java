package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 방배정13300_2 {

	static int N, K, S, Y, ans;
	static int[][] students;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken()); // 전체 학생 수
		K = Integer.parseInt(st.nextToken()); // 한 방 최대 인원
		students = new int[2][7]; // 0,1: 성별, 1~6: 학년
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			S = Integer.parseInt(st.nextToken()); // 성별 - 0: 여, 1: 남
			Y = Integer.parseInt(st.nextToken()); // 학년
			students[S][Y]++;
		}

		ans = 0;
		for (int i = 0; i < 2; i++) { // 행: 성별 0,1
			for (int j = 1; j < 7; j++) { // 열: 학년 1~6
				int r = students[i][j];
				if (r == 0)
					continue;
				if (r % K == 0) //통과 144ms
					ans += r / K;
				else
					ans += r / K + 1;
//				ans += (r - 1) / K + 1; // 통과 144ms
			}
		}
		System.out.println(ans);

	}
}
