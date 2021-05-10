package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// ��� 1792ms
public class ũ�Ը����_2812 {

	static int N, K, numArr[];
	static String input;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken()); // �ڸ� ��
		K = Integer.parseInt(st.nextToken()); // ���� ����
		numArr = new int[N];

		input = br.readLine();
		for (int i = 0; i < N; i++) {
			numArr[i] = input.charAt(i) - '0';
		}

		Stack<Integer> num = new Stack<Integer>();
		num.clear();
		// peek < numArr[i] �̸� �־��� �ִ� �� ����(Ƚ�� ����) �̹� �� �ְ� 
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			while (cnt < K && !num.isEmpty() && num.peek() < numArr[i]) {
				num.pop(); // ����
				cnt++; // ���� Ƚ�� ����
			}
			num.push(numArr[i]);
		}

		for (int i = 0; i < N-K; i++) {
			System.out.print(num.get(i));
		}
	}

}
