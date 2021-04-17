package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 탐색 172ms
public class 일로만들기2_12852 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		int[] D = new int[x + 1];
		int[] ans = new int[x + 1];

		D[1] = 0;
		for (int i = 2; i <= x; i++) {
			int min = Integer.MAX_VALUE;
			if (D[i - 1] + 1 < min) {
				min = D[i - 1] + 1;
				ans[i] = i - 1;
			}
			if (i % 3 == 0 && D[i / 3] + 1 < min) {
				min = D[i / 3] + 1;
				ans[i] = i / 3;
			}
			if (i % 2 == 0 && D[i / 2] + 1 < min) {
				min = D[i / 2] + 1;
				ans[i] = i / 2;
			}
			D[i] = min;
		}
		System.out.println(D[x]);
		int cur = x;
		while(cur != 0) {
			System.out.print(cur + " ");
			cur = ans[cur];
		}
	}

}
