package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// ��� 148ms
public class ���_1080 {

	static int n, m, cnt;
	static int[][] a, b;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken()); // ��
		m = Integer.parseInt(st.nextToken()); // ��

		a = new int[n][m]; // ���� ���
		b = new int[n][m]; // ��ȯ �� ���

		for (int i = 0; i < n; i++) { // a ��� �Է�
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				a[i][j] = s.charAt(j) - '0';
			}
		}

		for (int i = 0; i < n; i++) { // b ��� �Է�
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				b[i][j] = s.charAt(j) - '0';
			}
		}

		cnt = 0;

		// a�� b�� ����� ���� ������ ��ȯ
		// ���� �Ѿ�ų� �ٲ� �� ���ٸ� -1 ���
		// ��ȯ�ؼ� �������� �׶����� cnt ���
		out: for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (a[i][j] != b[i][j]) {
					cnt++;
					change(i, j);
				}
				if(cnt == -1) // �ٲ��� ������ �� 
					break out; // �ݺ��� �ƿ� ����������
			}
		}
		System.out.println(cnt);

	}

	private static void change(int si, int sj) {
		if (si + 3 > n || sj + 3 > m) { // 3*3 ��ȯ�ϴµ� ��� ������ �Ѿ�� x
			cnt = -1;
			return;
		}

		// 3*3 ����̴ϱ� i���� i+2���� ��ȯ
		for (int i = si; i <= si + 2; i++) {
			for (int j = sj; j <= sj + 2; j++) {
				a[i][j] = 1 - (a[i][j]); // 1�̸� 0, 0�̸� 1�� ��
			}
		}
	}

}
