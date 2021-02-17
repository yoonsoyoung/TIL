package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class SV10989_수정렬하기3 {
	static int T;
	static int[] num, arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		arr = new int[T];
		for (int i = 0; i < T; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		br.close();

		num = new int[10001];
		for (int i = 0; i < T; i++) {
			num[arr[i]]++;
		}
		for (int i = 1; i < num.length; i++) {
			if (num[i] > 0)
				for (int j = 0; j < num[i]; j++)
					sb.append(i).append("\n");
		}
		System.out.print(sb);

	}

}
