package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 통과 344ms
// KMP
public class 나는친구가적다Large_16172 {

	// 파이테이블
	static int[] getPi(String pattern) {
		int[] pi = new int[pattern.length()];

		int j = 0;
		for (int i = 1; i < pattern.length(); i++) {
			// pattern내에서 i와 j가 가리키는 값이 달라지는 점
			while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
				j = pi[j - 1];
			}
			// 같다면
			pi[i] = ++j; // i번째의 최대 길이는 ++j
		}

		return pi;
	}

	// KMP함수
	static void KMP(String parent, String pattern) {
		// 정수형 table배열에 파이테이블 넣기
		int[] table = getPi(pattern);
		// 파이테이블처럼 j 인덱스로 두고
		int j = 0;
		// 원본 문자열 길이만큼 돌면서 i와 j포인트 글자가 같지 않은 부분을 찾음
		for (int i = 0; i < parent.length(); i++) {
			//받은 부모 문자열 숫자 없애기
			if(parent.charAt(i) >= '0' && parent.charAt(i) <= '9')
				continue;
			while (j > 0 && parent.charAt(i) != pattern.charAt(j))
				j = table[j - 1];

			// 부모와 패턴의 문자가 일치하는 지점인데
			if (parent.charAt(i) == pattern.charAt(j)) {
				// j 가 부모의 문자열 길이-1 랑 같아지면 한 사이클 다 찾음
				if (j == pattern.length() - 1) {
					// 찾았다고 처리 => j인덱스의 table값을 j로
					j = table[j];
					System.out.println(1);
					System.exit(0);;
				}
				else {
					// 다 찾은 건 아니라면 j증가
					j++;
				}
			}
		}
		System.out.println(0); // 위에서 출력하지 못했다면 아닌 것
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String par = br.readLine();
		String patt = br.readLine();
		
		KMP(par, patt);
		
	}

}
