package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// ��� 344ms
// KMP
public class ����ģ��������Large_16172 {

	// �������̺�
	static int[] getPi(String pattern) {
		int[] pi = new int[pattern.length()];

		int j = 0;
		for (int i = 1; i < pattern.length(); i++) {
			// pattern������ i�� j�� ����Ű�� ���� �޶����� ��
			while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
				j = pi[j - 1];
			}
			// ���ٸ�
			pi[i] = ++j; // i��°�� �ִ� ���̴� ++j
		}

		return pi;
	}

	// KMP�Լ�
	static void KMP(String parent, String pattern) {
		// ������ table�迭�� �������̺� �ֱ�
		int[] table = getPi(pattern);
		// �������̺�ó�� j �ε����� �ΰ�
		int j = 0;
		// ���� ���ڿ� ���̸�ŭ ���鼭 i�� j����Ʈ ���ڰ� ���� ���� �κ��� ã��
		for (int i = 0; i < parent.length(); i++) {
			//���� �θ� ���ڿ� ���� ���ֱ�
			if(parent.charAt(i) >= '0' && parent.charAt(i) <= '9')
				continue;
			while (j > 0 && parent.charAt(i) != pattern.charAt(j))
				j = table[j - 1];

			// �θ�� ������ ���ڰ� ��ġ�ϴ� �����ε�
			if (parent.charAt(i) == pattern.charAt(j)) {
				// j �� �θ��� ���ڿ� ����-1 �� �������� �� ����Ŭ �� ã��
				if (j == pattern.length() - 1) {
					// ã�Ҵٰ� ó�� => j�ε����� table���� j��
					j = table[j];
					System.out.println(1);
					System.exit(0);;
				}
				else {
					// �� ã�� �� �ƴ϶�� j����
					j++;
				}
			}
		}
		System.out.println(0); // ������ ������� ���ߴٸ� �ƴ� ��
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String par = br.readLine();
		String patt = br.readLine();
		
		KMP(par, patt);
		
	}

}
