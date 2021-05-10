package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 통과 136ms
public class 비슷한단어_2607 {

	static int T, alpha[], ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		String s = br.readLine(); // 비교할 기준 문자열
		alpha = new int[26];
		for (int i = 0; i < s.length(); i++) {
			alpha[s.charAt(i) - 'A']++;
		}
		ans = 0;
		for (int tc = 0; tc < T - 1; tc++) {
			int temp[] = alpha.clone(); // 각 비교할 문자들의 알파벳 감소 카운팅 배열(그냥 temp[] = alpha 하면 두 번째 루프에서부터 복사안됨!)
			int cnt = 0;

			String t = br.readLine(); // 비교할 문자열
			for (int i = 0; i < t.length(); i++) {
				if (temp[t.charAt(i) - 'A'] > 0) { // 비교할 문자의 인덱스가 존재하는 경우(=기준 문자열에 들어있던 문자)
					cnt++; // 동일 문자 개수 카운팅
					temp[t.charAt(i) - 'A']--; // 하나 비교 완료, 감소
				}
			}

			// 기준문자열과 비교문자열의 길이가 같으면서 구성이 일치
			// 기준문자열+-1
			int sLen = s.length();
			int tLen = t.length();

			if (sLen == tLen && (cnt == sLen || cnt == sLen - 1))
				ans++;
			else if (sLen + 1 == tLen && cnt == sLen)
				ans++;
			else if (sLen - 1 == tLen && cnt == tLen)
				ans++;
		}
		System.out.println(ans);
	}

}
