package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// ��� 144ms
public class ���ǹ��_16561 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		// 3�� ��� => 3���� ������ �� 0
		// ���� ������ �� �� ���� ������ �ϳ��� �ڵ����� �������� ��

		int cnt = 0;
		for (int i = 1; i < n / 3; i++) { // ���⼭ ���� ���� 3���ϰ�
			for (int j = 1; j < n / 3; j++) { // ���⼭ ���� ���� 3 ���ϰ�
				int sum = 0;
				sum = i * 3 + j * 3;
				// �� �� ���� ���� n���� �۰� n���� �� �� ���� �� �� ���� 3�� ����� ���+1
				if (n > sum && (n - sum) % 3 == 0)
					cnt++;
			}
		}
		
		System.out.println(cnt);

	}

}
