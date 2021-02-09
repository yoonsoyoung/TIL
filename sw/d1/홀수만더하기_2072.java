package com.sw.d1;

import java.util.Scanner;

public class 홀수만더하기_2072 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int[] arr = new int[10];
		
		for(int tc = 1; tc<=T; tc++) {
			int ans = 0;
			for(int i = 0; i<10; i++) {
				arr[i] = sc.nextInt();
				if(arr[i]%2==1)
					ans += arr[i];
			}
			System.out.println("#" + tc + " " + ans);
		}
	}

}
