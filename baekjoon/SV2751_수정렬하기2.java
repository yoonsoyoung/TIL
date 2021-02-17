package com.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

//통과.시간2820ms 더 단축 필요함.
public class SV2751_수정렬하기2 {
	static int T;
	static int[] arr;
	static boolean[] num;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		T = sc.nextInt();
		arr = new int[T];
		for (int i = 0; i < T; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		for (int i = 0; i < T; i++) {
			sb.append(arr[i]).append("\n");
		}
		System.out.println(sb.toString());
		
	}
	
}
