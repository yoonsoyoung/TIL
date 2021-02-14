package com.sw.d3;

import java.util.Scanner;
import java.util.Stack;

public class 비밀번호_1234 {

	static int T = 10, N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= T; tc++) {
			Stack<Integer> st = new Stack();
			int pwLen = sc.nextInt(); // 문자열 길이
			String pw = sc.next();
			for (int i = 0; i < pwLen; i++) {
				if (st.size() >= 1) { // 스택의 맨 위에 있는 값이 현재 들어온 값과 같다면
					int a = st.peek();
					if (a == (int) pw.charAt(i) - '0') {
						st.pop(); // 그 맨 윗 값 빼고
						continue; // 다음으로 넘김
					}
				}
				st.push((int) pw.charAt(i) - '0');

			}

			// 답 출력
			System.out.print("#" + tc + " ");
			for (int i = 0; i < st.size(); i++) {
				System.out.print(st.get(i));
			}
			System.out.println();
		}
	}

}
