package com.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class 소트인사이드_1427 {
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
		
		while(np());
		for (int i = 0; i < n; i++) {
			System.out.print(input[i]);
		}
	}
	private static boolean np() {
		int i = n-1;
		while(i>0 && input[i-1]>=input[i]) --i;
		
		if(i==0) return false;
		
		int j = n-1;
		while(input[i-1]>=input[j]) --j;
		
		swap(i-1, j);
		
		int k = n-1;
		while(i<k) {
			swap(i++, k--);
		}
		return true;
	}

	static void swap(int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
}
