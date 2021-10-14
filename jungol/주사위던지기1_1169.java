package com.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 통과 308ms
public class 주사위던지기1_1169 {

	static int M, N, res[];
	static boolean[] selected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken()); // 던진 횟수
		M = Integer.parseInt(st.nextToken()); // 출력 모양

		res = new int[N+1];
		selected = new boolean[7]; // 주사위 눈 숫자

		if (M == 1) {
			sol1(0);
		} else if (M == 2) {
			sol2(0, 1);
		} else if (M == 3) {
			sol3(0);
		}

	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			System.out.print(res[i] + " ");
		}
		System.out.println();
	}

	private static void sol1(int i) { // 중복 순열(중복o, 순서o)
		if (i == N) {
			print();
			return;
		}

		for (int j = 1; j <= 6; j++) {
			res[i] = j;
			sol1(i + 1);
		}
	}

	private static void sol2(int i, int start) { // 조합(중복x, 순서x)
		if (i == N) {
			print();
			return;
		}

		for (int j = start; j <= 6; j++) {
			res[i] = j;
			sol2(i + 1, j);
		}
	}

	private static void sol3(int i) { // 순열(중복x, 순서o)
		if (i == N) {
			print();
			return;
		}

		for (int j = 1; j <= 6; j++) {
			if(!selected[j]) {
				selected[j] = true;
				res[i] = j;
				sol3(i + 1);
				selected[j] = false;
			}
		}
	}

}
