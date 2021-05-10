package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 통과 204ms
public class 평범한배낭_12865 {
	
	static int N, K, w[], v[];
	static int[][] D;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); // 물건 개수
		K = Integer.parseInt(st.nextToken()); // 최대 무게
		w = new int[N+1]; // 물건들의 무게
		v = new int[N+1]; // 물건들의 가치
		D = new int[N+1][K+1]; // 해당 물건까지 고려하여 해당 무게를 만들 때의 최대 가치 
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) { // 첫 물건부터
			for (int j = 1; j <= K; j++) { // 무게 1부터
				if(w[i] <= j) // 현재 무게보다 물건 무게보다 작다면 가방에 넣을 수 있음
					// 직전 물건까지 그 무게의 최적해 + 자신의 가치, 안 넣었을 때의 가치 중 큰 값을 저장
					D[i][j] = Math.max(D[i-1][j-w[i]] + v[i], D[i-1][j]);
				else // 가방에 넣지 못함
					D[i][j] = D[i-1][j]; // 그 직전 물건까지 만족했던 무게 최적해
			}
		}
		
		System.out.println(D[N][K]);
		
	}

}
