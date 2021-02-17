package com.baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class SV1316_그룹단어체커 {
	static int T;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		int ans = 0;
		for (int tc = 1; tc <= T; tc++) {
			String s = sc.next();
			Stack<Character> st = new Stack<>();
			for (int i = 0; i < s.length(); i++) { //연달아 들어오는 중복 알파벳 처리
				if (st.isEmpty())
					st.push(s.charAt(i));
				if (st.peek() == s.charAt(i)) {
					continue;
				} else
					st.push(s.charAt(i));

			}
			boolean chk = true;
			out: for (int i = 0; i < st.size(); i++) { //연달아 들어오지 않고 이후에 또 중복된 알파벳 처리
				for (int j = i+1; j < st.size(); j++) {
					if (st.get(i) == st.get(j)) {
						chk = false;
						break out;
					} 
				}
			}
			if(chk == true)
				ans++;
		}
		System.out.println(ans);
	}

}
