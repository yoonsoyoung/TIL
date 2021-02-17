package com.baekjoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 회의실배정_1931 {

	static int N, ans;
	static int[][] time;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		time = new int[N][2]; //0열은 시작시간 1열은 끝나는 시간
		for (int i = 0; i < N; i++) {
			time[i][0] = sc.nextInt(); //시작 시간
			time[i][1] = sc.nextInt(); //끝나는 시간
		}
		
		// 끝나는 시간이 이른 순으로 정렬 -> 익명클래스 comparator로 정렬 오름차순= 내꺼-남의꺼 
		Arrays.sort(time, new Comparator<int[]>() { //먼저 시작하는 순서
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) //끝나는 시간 같다면
					return o1[0]-o2[0]; //더 먼저 시작하는 애로
				else
					return o1[1]-o2[1]; //더 먼저 끝나는 애
			}
		});
		int currS = time[0][0]; //가장 빨리 끝나는 회의의 시작 시간
		int currE = time[0][1]; //가장 빨리 끝나는 회의의 종료 시간
		ans = 1; //가장 빨리 끝나는 회의 기본으로 넣고 시작.
		for (int i = 1; i < N; i++) {
			//다음 회의의 시작시간이 최근 회의의 종료시간과 같거나 이후일 때
			if(time[i][0] >= currE) {
				currS = time[i][0];
				currE = time[i][1];
//				System.out.println(time[i][0] + ", " + time[i][1]);
				ans++;
			}
		}
		
		System.out.println(ans);
	}
	
}
