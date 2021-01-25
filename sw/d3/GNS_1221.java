package com.sw.d3;

import java.util.Scanner;

public class GNS_1221 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // �׽�Ʈ ���̽�
		for (int tc = 1; tc <= T; tc++) {
			String tcNo = sc.next(); // �׽�Ʈ ���̽� ��ȣ
			int tcLength = sc.nextInt(); // �׽�Ʈ ���̽� ����
			String[] numText = new String[tcLength];
			int[] numCnt = new int[10];
			String[] txt = { "ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN" };
			for (int i = 0; i < numText.length; i++) {
				numText[i] = sc.next();
				for (int j = 0; j < 10; j++) {
					if (numText[i].equals(txt[j])) {
						numCnt[j]++;
					}
				}
			}
			System.out.println("#" + tc);
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < numCnt[i]; j++) {
					System.out.print(txt[i] + " ");
				}
			}
		}
	}

}
