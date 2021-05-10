package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// ��� 136ms
public class ����Ѵܾ�_2607 {

	static int T, alpha[], ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		String s = br.readLine(); // ���� ���� ���ڿ�
		alpha = new int[26];
		for (int i = 0; i < s.length(); i++) {
			alpha[s.charAt(i) - 'A']++;
		}
		ans = 0;
		for (int tc = 0; tc < T - 1; tc++) {
			int temp[] = alpha.clone(); // �� ���� ���ڵ��� ���ĺ� ���� ī���� �迭(�׳� temp[] = alpha �ϸ� �� ��° ������������ ����ȵ�!)
			int cnt = 0;

			String t = br.readLine(); // ���� ���ڿ�
			for (int i = 0; i < t.length(); i++) {
				if (temp[t.charAt(i) - 'A'] > 0) { // ���� ������ �ε����� �����ϴ� ���(=���� ���ڿ��� ����ִ� ����)
					cnt++; // ���� ���� ���� ī����
					temp[t.charAt(i) - 'A']--; // �ϳ� �� �Ϸ�, ����
				}
			}

			// ���ع��ڿ��� �񱳹��ڿ��� ���̰� �����鼭 ������ ��ġ
			// ���ع��ڿ�+-1
			int sLen = s.length();
			int tLen = t.length();

			if (sLen == tLen && (cnt == sLen || cnt == sLen - 1))
				ans++;
			else if (sLen + 1 == tLen && cnt == sLen)
				ans++;
			else if (sLen - 1 == tLen && cnt == tLen)
				ans++;
		}
		System.out.println(ans);
	}

}
