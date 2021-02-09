package com.sw.d1;

import java.util.Arrays;
import java.util.Scanner;

public class 중간값찾기_2063 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int tmp ;
		//버블정렬
//		for (int i = 0; i < arr.length - 1; i++) { //맨 앞부터 뒤에서 1 앞까지
//			for (int j = i+1; j < arr.length; j++) { //맨 앞 그 다음꺼부터 끝까지
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
