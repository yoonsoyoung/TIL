package com.sw.d1;

import java.util.Arrays;
import java.util.Scanner;

public class 중간값찾기_빈도배열사용 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //입력 개수
		int[] arr = new int[N]; //개수만큼 점수 받을 배열
		int[] cnt = new int[101]; // 수의 빈도를 위함
		int ans = 0;

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt(); //배열에 입력
			cnt[arr[i]]++;
		}

		int hop = 0;
		for (int i = 0; i < cnt.length; i++) {
			hop += cnt[i];
			if(hop > N/2) { //빈도의 누적합이 중간등수를 넘어가는 순간
				ans = i;
				break;
			}
			
		}
		
			System.out.println(ans);
	}

}
