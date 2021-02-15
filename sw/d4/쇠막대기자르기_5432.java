package com.sw.d4;

import java.util.Scanner;

public class �踷����ڸ���_5432 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			String s = sc.next();
			String ns = s.replace("()", "R"); //() �� ������
			int ans = 0;
			int open = 0; //����� �����ִ�
			int close = 0; //������ ����  ��
			int stick = 0; //�� �踷��� ��
			int[] raser = new int[1000000];
			for (int i = 0; i < ns.length()-1; i++) {
				if(ns.charAt(i) == '(') { //�踷��� ����
					open++;
					stick++;
				} else if(ns.charAt(i) == 'R') { //��������
					for (int j = close; j < open+close; j++) {
						raser[j]++; //�ش� ��ġ ������ �߰�
					}
				} else if(ns.charAt(i)==')') { //����� ������
					close++;
					open--;
				}
			}
			
			for (int i = 0; i < stick; i++) {
				ans = ans + raser[i] +1; //�踷��⸦ �������� n�� �ڸ��� n+1���� ��
				//ex. 1���� ���븦 1�� �ڸ��� 2������, 1���� ���븦 2�� �ڸ��� 3�� ����.
			}
			System.out.println("#" + tc + " " + ans);
		}
	}

}
