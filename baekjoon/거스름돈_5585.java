package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//통과 124ms
public class 거스름돈_5585 {

	static int pay, cnt;
	static int[] coin = {500, 100, 50, 10, 5, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		pay = Integer.parseInt(br.readLine());
		cnt = 0;
		int change = 1000-pay;
		for (int i = 0; i < coin.length; i++) {
			if (change >= coin[i]) {
				cnt += change / coin[i];
				change = change % coin[i];
			}
		}
		System.out.println(cnt);
	}
}
