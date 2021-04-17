package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 통과 164ms
public class A에서B_16953 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());

		// B에서 A로 역추적하기
		// B의 끝 자리가 1이면 1 빼고, 2로 나눔
		// B가 A와 같아질 때 까지 반복. 이때 B가 A보다 작아지면 -1 출력

		int cnt = 1; // 처음 숫자부터 횟수 포함
		while (B != A) {
			if (B < A) { // 반복 돌다가 B가 A보다 작아지면 만들 수 없는 경우
				System.out.println("-1");
				System.exit(0);
			}

			// 애초에 2로도 안나눠지고 끝 자리가 1이 아니라면 만들 수 없는 경우
			String s = Long.toString(B);
			String last = s.substring(s.length() - 1, s.length());
			if ((!last.equals("1")) && B % 2 != 0) {
				System.out.println("-1");
				System.exit(0);
			}

			if (B % 2 == 0) {
				B /= 2;
			} else {
				s = s.substring(0, s.length() - 1);
				B = Long.parseLong(s);
			}

			cnt++;
		}
		
		System.out.println(cnt);
	}

}
