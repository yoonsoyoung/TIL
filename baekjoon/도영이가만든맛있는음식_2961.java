package com.baekjoon;

import java.util.Scanner;

public class 도영이가만든맛있는음식_2961 {

	static int N, sel, ans;
	static int[] sour; //신맛
	static int[] bitters; //쓴맛
	static int[] numbers; //선택한 인덱스 저장
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		sour = new int[N];
		bitters = new int[N];
		numbers = new int[N];
		ans = Integer.MAX_VALUE;
		for (int n = 0; n < N; n++) {
			sour[n] = sc.nextInt();
			bitters[n] = sc.nextInt();
		}
		
		for (int i = 1; i < N+1; i++) { //적어도 한 개 이상 뽑아야 한다.
			sel = i;
			combi(0,0);
		}
		
		System.out.println(ans);
	}
	
	static void combi(int cnt, int idx) {
		if(cnt == sel) {
			int sum = 0;
			int mul = 1;
			for (int j = 0; j < sel; j++) {
				System.out.println(sour[j] + " " + bitters[j]);
				mul *= sour[numbers[j]];
				sum += bitters[numbers[j]];
			}
			ans = Math.min(ans, Math.abs(sum - mul));
			return;
		}
		
		for (int j = idx; j < N; j++) {
			numbers[cnt] = j;
			combi(cnt+1, j+1);
		}
	}

	
}
