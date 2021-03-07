package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 통과 148ms
public class 행렬_1080 {

	static int n, m, cnt;
	static int[][] a, b;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken()); // 행
		m = Integer.parseInt(st.nextToken()); // 열

		a = new int[n][m]; // 원본 행렬
		b = new int[n][m]; // 변환 된 행렬

		for (int i = 0; i < n; i++) { // a 행렬 입력
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				a[i][j] = s.charAt(j) - '0';
			}
		}

		for (int i = 0; i < n; i++) { // b 행렬 입력
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				b[i][j] = s.charAt(j) - '0';
			}
		}

		cnt = 0;

		// a와 b의 행렬이 같지 않으면 변환
		// 범위 넘어가거나 바꿀 수 없다면 -1 출력
		// 변환해서 같아지면 그때까지 cnt 출력
		out: for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (a[i][j] != b[i][j]) {
					cnt++;
					change(i, j);
				}
				if(cnt == -1) // 바꾸지 못했을 때 
					break out; // 반복문 아예 빠져나가기
			}
		}
		System.out.println(cnt);

	}

	private static void change(int si, int sj) {
		if (si + 3 > n || sj + 3 > m) { // 3*3 변환하는데 행렬 범위를 넘어가면 x
			cnt = -1;
			return;
		}

		// 3*3 행렬이니까 i부터 i+2까지 변환
		for (int i = si; i <= si + 2; i++) {
			for (int j = sj; j <= sj + 2; j++) {
				a[i][j] = 1 - (a[i][j]); // 1이면 0, 0이면 1이 됨
			}
		}
	}

}
