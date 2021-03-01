package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//통과 132ms
public class 직사각형을만드는방법_8320 {

	static int N, sum;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		sum = 0;
		
		// 이건 왜 오답인걸까?
//		int sum2 = 0;
//		for (int i = 0; i < N; i++) { // 그냥 한 줄로 세운 직사각형
//			sum2++;
//			if(i>2 && i*i <= N) // 3*3 부터 n*n 정사각형
//				sum2++;
//		}
//		if(i>=2) { //스터디 후 추가, 수정했는데 아직 결과 확인 안해봄
//		for (int j = 0; j <= N-i*i; j+=i) { // i*i 정사각형에서 i개씩 붙인 직사각형
//			if(i*i+j <= N)
//				sum2++;
//		}}
//		System.out.println(sum2);
		
		for (int i = 1; i <= N; i++) { //세로
			for (int j = i; i*j <= N; j++) { //가로
				// 1*1, 1*2, 1*3, ... , 2*2, 2*3, ... , 3*3, 3*4, ... , N*N 까지 
				sum++;
			}
		}
		System.out.println(sum);
	}

}
