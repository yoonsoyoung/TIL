package com.sw.d1;

import java.util.Arrays;
import java.util.Scanner;

public class �߰���ã��_2063 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int tmp ;
		//��������
//		for (int i = 0; i < arr.length - 1; i++) { //�� �պ��� �ڿ��� 1 �ձ���
//			for (int j = i+1; j < arr.length; j++) { //�� �� �� ���������� ������
//				if (arr[i] > arr[j]) {
//					tmp = arr[i];
//					arr[i] = arr[j];
//					arr[j] = tmp;
//				}
//			}
//		}
		
		Arrays.sort(arr);
		System.out.println(arr[N / 2]);
	}

}
