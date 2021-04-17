package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 통과 156ms
public class 일로만들기_1463 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		int[] D = new int[x+1];
		
		D[1] = 0;
		for (int i = 2; i <= x; i++) {
			int min = Integer.MAX_VALUE;
			if(D[i-1]+1 < min)
				min = D[i-1]+1;
			if(i%3 == 0 && D[i/3]+1 < min)
				min = D[i/3]+1;
			if(i%2==0 && D[i/2]+1 < min)
				min = D[i/2]+1;
			D[i] = min;
		}
		System.out.println(D[x]);
	}

}
