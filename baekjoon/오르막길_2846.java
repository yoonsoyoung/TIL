package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ��� 140ms
public class ��������_2846 {

	static int N, map[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;
		int res = 0;
		// �տ������� ���鼭
		// ��  ���� �ְ� ������ ũ�ٸ� ������. ū �ʿ��� ���� �� ���� ������ 
		for (int i = 1; i < N; i++) {
			if(map[i-1]<map[i]) {
				sum += map[i] - map[i-1];
				res = Math.max(res, sum); // ������ �ִ밪 ����
			}
			else { // �������� ����
				sum = 0; // ������ ����
			}
		}
		System.out.println(res);
	}

}
