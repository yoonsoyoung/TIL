package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 통과 564ms
public class 이동하기_11048 {

	public static void main(String[] args) throws IOException {
		// 배열을 N+1, M+1 로 만듦으로써 범위체크를 하지 않아도 됨.
		// 그리고 나서 (r+1, c), (r, c+1), (r+1, c+1)칸 중에 max를 찾아
		// 그 값에 현재 내 위치 값을 더한 걸 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N+1][M+1];
		int[][] candy = new int[N+1][M+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				candy[i][j] = Math.max(candy[i-1][j], Math.max(candy[i][j-1], candy[i-1][j-1])) + map[i][j];
			}
		}
		
		System.out.println(candy[N][M]);
		
		
		
	}

}
