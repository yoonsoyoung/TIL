package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ��� 204ms
public class ����ѹ賶_12865 {
	
	static int N, K, w[], v[];
	static int[][] D;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); // ���� ����
		K = Integer.parseInt(st.nextToken()); // �ִ� ����
		w = new int[N+1]; // ���ǵ��� ����
		v = new int[N+1]; // ���ǵ��� ��ġ
		D = new int[N+1][K+1]; // �ش� ���Ǳ��� ����Ͽ� �ش� ���Ը� ���� ���� �ִ� ��ġ 
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) { // ù ���Ǻ���
			for (int j = 1; j <= K; j++) { // ���� 1����
				if(w[i] <= j) // ���� ���Ժ��� ���� ���Ժ��� �۴ٸ� ���濡 ���� �� ����
					// ���� ���Ǳ��� �� ������ ������ + �ڽ��� ��ġ, �� �־��� ���� ��ġ �� ū ���� ����
					D[i][j] = Math.max(D[i-1][j-w[i]] + v[i], D[i-1][j]);
				else // ���濡 ���� ����
					D[i][j] = D[i-1][j]; // �� ���� ���Ǳ��� �����ߴ� ���� ������
			}
		}
		
		System.out.println(D[N][K]);
		
	}

}
