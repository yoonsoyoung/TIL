package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class �����13300_2 {

	static int N, K, S, Y, ans;
	static int[][] students;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken()); // ��ü �л� ��
		K = Integer.parseInt(st.nextToken()); // �� �� �ִ� �ο�
		students = new int[2][7]; // 0,1: ����, 1~6: �г�
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			S = Integer.parseInt(st.nextToken()); // ���� - 0: ��, 1: ��
			Y = Integer.parseInt(st.nextToken()); // �г�
			students[S][Y]++;
		}

		ans = 0;
		for (int i = 0; i < 2; i++) { // ��: ���� 0,1
			for (int j = 1; j < 7; j++) { // ��: �г� 1~6
				int r = students[i][j];
				if (r == 0)
					continue;
				if (r % K == 0) //��� 144ms
					ans += r / K;
				else
					ans += r / K + 1;
//				ans += (r - 1) / K + 1; // ��� 144ms
			}
		}
		System.out.println(ans);

	}
}
