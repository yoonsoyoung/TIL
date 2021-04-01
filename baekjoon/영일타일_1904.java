package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 통과 152ms
public class 영일타일_1904 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] D = new int[N + 2];

		// f(n) = f(n-2) + f(n-1)
		D[1] = 1;
		D[2] = 2;
		for (int i = 3; i <= N; i++) {
			// 개수 % 15746
			D[i] = (D[i - 2] + D[i - 1]) % 15746;
		}
		System.out.println(D[N]);

	}

}
