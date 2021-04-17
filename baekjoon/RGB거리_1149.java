package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ��� 156ms
public class RGB�Ÿ�_1149 {

	static int N, ans;
	static int[][] rgb, D;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine()); // ���� ��
		rgb = new int[N+1][3]; // �� �� RGB ��� [0]: R, [1]: G, [2]: B
		D = new int[N+1][3]; // �� �� ĥ�ϴ� ���

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				rgb[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		D[0][0] = rgb[0][0];
		D[0][1] = rgb[0][1];
		D[0][2] = rgb[0][2];

		// 1�� �� �� != 2�� �� ��
		// N�� �� �� != N-1�� �� ��
		// i(2<= i <= N-1, �� �߰���)�� �� �� != �¿� �� ��
		for (int i = 1; i < N; i++) {
			// �� ������ ĥ�� ������� ��� = ���� ĥ�� �� �ִ� �� �� �ּ��� �� + ���� ��� 
			// �� �� ���� (G ĥ���� �� ��� vs B ĥ���� �� ���) �� �ּ� + R ĥ�� ��� -> ���� R ĥ�� ���   
			D[i][0] = Math.min(D[i-1][1], D[i-1][2]) + rgb[i][0]; // G || B -> R 
			D[i][1] = Math.min(D[i-1][0], D[i-1][2]) + rgb[i][1]; // R || B -> G
			D[i][2] = Math.min(D[i-1][0], D[i-1][1]) + rgb[i][2]; // R || G -> B
		}
		ans = 0;
		ans = Math.min(Math.min(D[N-1][0], D[N-1][1]), D[N-1][2]); // R, G, B �� 
		
		System.out.println(ans);
	}

}
