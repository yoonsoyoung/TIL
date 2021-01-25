package com.sw.d2;

import java.util.Arrays;
import java.util.Scanner;

public class �ֺ�����ϱ�_1204 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		int MAX_SIZE = 1000;
		int ans = 0;
		for (int test_case = 1; test_case <= T; test_case++) {
			int cn = sc.nextInt(); //���̽� ��ȣ
			int[] students = new int[MAX_SIZE]; //�л� ����
			int[] cnt = new int[101]; //���� �󵵸� ����
			for(int i = 0; i<MAX_SIZE; i++) { //0~100���� ������ �� ���ϱ�
				students[i] = sc.nextInt();
				cnt[students[i]]++;
			}
			int[] max = new int[2];
			for(int i =0; i<cnt.length; i++) {
				//System.out.println(i + " = " + cnt[i]);
				if(max[0] < cnt[i]) {
					max[0] = cnt[i]; //max[0] �� �󵵼�
					max[1] = i; //max[1] �� �ش� ����
				} else if (max[0] == cnt[i]) { // ���� �󵵼����
					max[1] = Math.max(max[1], i); // ������ �ִ� �Ͱ� ���Ͽ� ������ �� ū ���� ����
				}
				ans = max[1]; // ���� ������ ��������
			}
			System.out.println("#" + cn + " " + ans);
		}
	}

}
