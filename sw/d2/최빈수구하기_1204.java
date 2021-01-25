package com.sw.d2;

import java.util.Arrays;
import java.util.Scanner;

public class 최빈수구하기_1204 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		int MAX_SIZE = 1000;
		int ans = 0;
		for (int test_case = 1; test_case <= T; test_case++) {
			int cn = sc.nextInt(); //케이스 번호
			int[] students = new int[MAX_SIZE]; //학생 점수
			int[] cnt = new int[101]; //수의 빈도를 위함
			for(int i = 0; i<MAX_SIZE; i++) { //0~100까지 점수의 빈도 구하기
				students[i] = sc.nextInt();
				cnt[students[i]]++;
			}
			int[] max = new int[2];
			for(int i =0; i<cnt.length; i++) {
				//System.out.println(i + " = " + cnt[i]);
				if(max[0] < cnt[i]) {
					max[0] = cnt[i]; //max[0] 은 빈도수
					max[1] = i; //max[1] 는 해당 점수
				} else if (max[0] == cnt[i]) { // 같은 빈도수라면
					max[1] = Math.max(max[1], i); // 기존에 있던 것과 비교하여 점수가 더 큰 것을 저장
				}
				ans = max[1]; // 최종 점수를 정답으로
			}
			System.out.println("#" + cn + " " + ans);
		}
	}

}
