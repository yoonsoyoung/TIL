package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ��� 132ms , �� �� ���� �ʿ�
public class ���_14501 {

	static int N, max;
	static int[] t, p, maxP;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		t = new int[N + 2]; // ���Ⱓ, 1�Ϻ��� n+1�ϱ���
		p = new int[N + 2]; // �ݾ�, 1�Ϻ��� n+1�ϱ���
		maxP = new int[N + 2]; // �ִ� ����
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}

		max = 0;

		// i ��° ���� ���� �ϸ� i + t[i] ���� p[i] �ݾ� ����
		for (int i = 1; i < N + 2; i++) {
			maxP[i] = Math.max(maxP[i], max);
			if (i + t[i] <= N + 1) // ��㳡���� ����ϱ��� ���� ����
				maxP[i + t[i]] = Math.max(maxP[i + t[i]], p[i] + maxP[i]);
			max = Math.max(maxP[i], max); // i�ϱ��� �ִ� ����
		}

		System.out.println(max);
	}

}
