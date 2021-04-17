package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 통과 136ms
public class 동물원_1309 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N+1][3];
		
		// 가로-가로, 세로-세로 붙어 있으면 안 됨 & 한 마리도 배치 안해도 경우+1 => 지그재그 배치 또는 띄엄띄엄 배치
		// N=1 => 3
		//  [1][0]  (0,0), 
		//  [1][왼1] (1,0),
		//  [1][오2] (0,1) 
		// N=2 => 7
		//		  (0,0 , (1,0 , (0,1 , 
		//	[2][0] 0,0)   0,0)   0,0) : 3 = [N-1][0] + [N-1][1] + [N-1][2]
		//   	   (0,0 , (1,0
		//	[2][1]  1,0)   0,1) : 2 = [N-1][0] + [N-1][2]
		//		   (0,0 , (1,0
		//  [2][2]  0,1)   0,1) : 2 = [N-1][0] + [N-1][1] 
		
		dp[1][0] = 1;
		dp[1][1] = 1;
		dp[1][2] = 1;
		
		// 경우의 수 % 9901
		for (int i = 2; i <= N; i++) {
			dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2])%9901; // i번째 줄에 한 마리도 배치 않을 경우 그 전 줄에 어떻게 놔도 됨
			dp[i][1] = (dp[i-1][0] + dp[i-1][2])%9901; // i번째 줄에 왼쪽에 두려면 그 전 줄에 아무것도 두지 않거나 오른쪽에 둬야 함
			dp[i][2] = (dp[i-1][0] + dp[i-1][1])%9901; // i번째 줄에 오른쪽에 두려면 그 전 줄에 아무것도 두지 않거나 왼쪽에 둬야 함
		}
		
		// 출력
		int ans = dp[N][0] + dp[N][1] + dp[N][2];
		System.out.println(ans%9901); // 답 출력시 %9901 주의  
		
		
	}

}
