package com.sw.d1;

import java.util.Arrays;
import java.util.Scanner;

public class �߰���ã��_�󵵹迭��� {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //�Է� ����
		int[] arr = new int[N]; //������ŭ ���� ���� �迭
		int[] cnt = new int[101]; // ���� �󵵸� ����
		int ans = 0;

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt(); //�迭�� �Է�
			cnt[arr[i]]++;
		}

		int hop = 0;
		for (int i = 0; i < cnt.length; i++) {
			hop += cnt[i];
			if(hop > N/2) { //���� �������� �߰������ �Ѿ�� ����
				ans = i;
				break;
			}
			
		}
		
			System.out.println(ans);
	}

}
