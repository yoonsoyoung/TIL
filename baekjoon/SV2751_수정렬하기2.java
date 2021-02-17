package com.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

//���.�ð�2820ms �� ���� �ʿ���.
public class SV2751_�������ϱ�2 {
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
