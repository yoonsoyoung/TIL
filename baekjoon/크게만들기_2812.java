package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 통과 1792ms
public class 크게만들기_2812 {

	static int N, K, numArr[];
	static String input;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken()); // 자리 수
		K = Integer.parseInt(st.nextToken()); // 지울 개수
		numArr = new int[N];

		input = br.readLine();
		for (int i = 0; i < N; i++) {
			numArr[i] = input.charAt(i) - '0';
		}

		Stack<Integer> num = new Stack<Integer>();
		num.clear();
		// peek < numArr[i] 이면 넣어져 있던 거 빼고(횟수 차감) 이번 꺼 넣고 
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			while (cnt < K && !num.isEmpty() && num.peek() < numArr[i]) {
				num.pop(); // 지움
				cnt++; // 지움 횟수 증가
			}
			num.push(numArr[i]);
		}

		for (int i = 0; i < N-K; i++) {
			System.out.print(num.get(i));
		}
	}

}
