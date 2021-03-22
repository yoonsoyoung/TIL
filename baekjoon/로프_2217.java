package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

// 통과 476ms
public class 로프_2217 {

	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Integer w[] = new Integer[N];
		for (int i = 0; i < N; i++) {
			w[i] = Integer.parseInt(br.readLine());
		}

		// 내림차순 : 큰->작 으로 정렬
		Arrays.sort(w, Collections.reverseOrder());
		// int 의 기본타입 배열은 적용 불가! Integer 의 Wrapper 클래스 사용
		
		int max = 0; // 최대 중량 갱신용
		
		// 각 w/k 만큼의 중량을 받으니까 역으로 w * k 를 하면 
		for (int i = 0; i < N; i++) {
			int maxW = w[i] * (i+1); //(i+1)은 1번째, 2번째...
			max = Math.max(maxW, max);
		}
		System.out.println(max);
	}

}
