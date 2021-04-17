package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// ��� 136ms
public class ������_1309 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N+1][3];
		
		// ����-����, ����-���� �پ� ������ �� �� & �� ������ ��ġ ���ص� ���+1 => ������� ��ġ �Ǵ� ������ ��ġ
		// N=1 => 3
		//  [1][0]  (0,0), 
		//  [1][��1] (1,0),
		//  [1][��2] (0,1) 
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
		
		// ����� �� % 9901
		for (int i = 2; i <= N; i++) {
			dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2])%9901; // i��° �ٿ� �� ������ ��ġ ���� ��� �� �� �ٿ� ��� ���� ��
			dp[i][1] = (dp[i-1][0] + dp[i-1][2])%9901; // i��° �ٿ� ���ʿ� �η��� �� �� �ٿ� �ƹ��͵� ���� �ʰų� �����ʿ� �־� ��
			dp[i][2] = (dp[i-1][0] + dp[i-1][1])%9901; // i��° �ٿ� �����ʿ� �η��� �� �� �ٿ� �ƹ��͵� ���� �ʰų� ���ʿ� �־� ��
		}
		
		// ���
		int ans = dp[N][0] + dp[N][1] + dp[N][2];
		System.out.println(ans%9901); // �� ��½� %9901 ����  
		
		
	}

}
