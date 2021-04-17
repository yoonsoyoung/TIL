package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 통과 144ms
public class 삼의배수_16561 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		// 3의 배수 => 3으로 나눴을 때 0
		// 작은 수부터 두 개 고르면 나머지 하나는 자동으로 정해지는 꼴

		int cnt = 0;
		for (int i = 1; i < n / 3; i++) { // 여기서 뽑힌 수에 3곱하고
			for (int j = 1; j < n / 3; j++) { // 여기서 뽑힌 수에 3 곱하고
				int sum = 0;
				sum = i * 3 + j * 3;
				// 이 두 수의 합이 n보다 작고 n에서 이 두 수를 뺀 것 역시 3의 배수면 경우+1
				if (n > sum && (n - sum) % 3 == 0)
					cnt++;
			}
		}
		
		System.out.println(cnt);

	}

}
