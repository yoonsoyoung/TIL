package com.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

// 통과 244ms
public class 단어수학_1339 {

	static int N, ans;
	static String[] s;
	public static void main(String[] args) {
		
		// 각 알파벳을 변수라고 생각하고 자릿수에 대한 덧셈을 함
		// 알파벳 앞 정수에 대한 정렬 하여
		// 큰 수 부터 그 알파벳에 부여.
		// ex. ABC + BCD = 100A + 10B + C + 100B + 10C + D = 110B + 100A + 11C + D
		// => B = 9, A = 8, C = 7, D = 6
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 단어 개수 1<= N <= 10
		s = new String[N];
		int[] alpha = new int[26]; // 알파벳 개수. A: 65 Z:90
		for (int i = 0; i < N; i++) {
			String s = sc.next();
			for (int j = 0; j < s.length(); j++) {
				// 해당 알파벳(인덱스)에 자릿수 누적합
				// 1000, 100, 10 등 자릿수를 구할 때 제곱수 함수로 Math.pow(x, y) 쓰면 편함. x의 y거듭제곱
				alpha[(s.charAt(j)-'A')] += (int)Math.pow(10, (s.length()-j-1)); // 1의 자리는 10^0
			}
		}
		
		Arrays.sort(alpha);
		ans = 0;
		int cnt = 9;
		for (int i = 25; i >= 0; i--) {
			if(cnt == 0) break;
			ans += (alpha[i] * cnt);
			cnt--;
		}
		
		System.out.println(ans);
	}

}
