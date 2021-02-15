package com.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class 소트인사이드_arraySort {
	static String N;
	static int n;
	static int[] input;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.next();
		n = N.length();
		input = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = (int)(N.charAt(i)-'0');
		}
		
		Arrays.sort(input);
		for (int i = n-1; i >= 0; i--) {
			System.out.print(input[i]);
		}
	}
}
