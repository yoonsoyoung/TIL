package com.baekjoon;

import java.util.Scanner;

public class 도영이가만든맛있는음식_부분집합 {

	static int N, sel, ans;
	static int[] sour; // 신맛
	static int[] bitters; // 쓴맛
	static boolean[] isSelected;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		sour = new int[N];
		bitters = new int[N];
		isSelected = new boolean[N];
		ans = Integer.MAX_VALUE;
		for (int n = 0; n < N; n++) {
			sour[n] = sc.nextInt();
			bitters[n] = sc.nextInt();
		}
		for (int i = 1; i < N + 1; i++) {
			sel = i;
			powerSet(0);
		}

		System.out.println(ans);
	}

	static void powerSet(int cnt) {
		if (cnt == sel) {
			int sum = 0;
			int mul = 1;
			for (int j = 0; j < sel; j++) {
				if (isSelected[j]) {
					mul *= sour[j];
					sum += bitters[j];
					ans = Math.min(ans, Math.abs(sum - mul));
				}
			}
			return;
		}

		isSelected[cnt] = true;
		powerSet(cnt + 1);
		isSelected[cnt] = false;
		powerSet(cnt + 1);
	}

}
