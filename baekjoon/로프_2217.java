package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

// ��� 476ms
public class ����_2217 {

	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Integer w[] = new Integer[N];
		for (int i = 0; i < N; i++) {
			w[i] = Integer.parseInt(br.readLine());
		}

		// �������� : ū->�� ���� ����
		Arrays.sort(w, Collections.reverseOrder());
		// int �� �⺻Ÿ�� �迭�� ���� �Ұ�! Integer �� Wrapper Ŭ���� ���
		
		int max = 0; // �ִ� �߷� ���ſ�
		
		// �� w/k ��ŭ�� �߷��� �����ϱ� ������ w * k �� �ϸ� 
		for (int i = 0; i < N; i++) {
			int maxW = w[i] * (i+1); //(i+1)�� 1��°, 2��°...
			max = Math.max(maxW, max);
		}
		System.out.println(max);
	}

}
