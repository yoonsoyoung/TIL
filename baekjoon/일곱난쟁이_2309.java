package com.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class 일곱난쟁이_2309 {
	static boolean[] isSelected;
	static int[] nanjaeng;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		nanjaeng = new int[9];
		isSelected = new boolean[9];
		
		for (int i = 0; i < 9; i++) {
			nanjaeng[i] = sc.nextInt(); //난쟁이 키 입력받음
		}
		Arrays.sort(nanjaeng);
		PowerSet(0);
	}
	
	private static void PowerSet(int cnt) {
		//기저
		if(cnt == nanjaeng.length) {
			
			int sum = 0;
			int trueCnt = 0;
			for (int i = 0; i < 9; i++) {
				if(isSelected[i]) {
					sum += nanjaeng[i];
					trueCnt++;
				}
			}
			
			//true의 개수가 7개이고 true인 값들의 합이 100이 맞다면
			if(trueCnt ==7 && sum==100) {
				for (int i = 0; i < 9 ; i++) {
					if (isSelected[i]) {
						System.out.println(nanjaeng[i]);
					}
				}
				//system.exit(0); 로 종료시키기
				System.exit(0);
			}
			return;
		}
		
		//유도
		isSelected[cnt] = true;
		PowerSet(cnt+1);
		isSelected[cnt] = false;
		PowerSet(cnt+1);
	}

}
