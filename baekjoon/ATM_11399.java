package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

//통과 160ms
public class ATM_11399 {

	static int N, sum;
	static int[] man;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 사람 수

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		man = new int[N];
		for (int i = 0; i < N; i++) {
			man[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(man);
		int cnt = 0;
		while(cnt<N) {
			for (int i = 0; i <= cnt; i++) {
				sum += man[i];
			}
			cnt++;
		}
		
		System.out.println(sum);
	}

}
