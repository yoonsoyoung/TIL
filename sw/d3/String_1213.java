package com.sw.d3;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class String_1213 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1; test_case <= 10; test_case++) {
			int ans = 0;
			int cn = sc.nextInt();
			String sel = sc.next();
			String s = sc.next();
			Pattern p = Pattern.compile(sel); //패턴 생성("정규식")
			Matcher m = p.matcher(s);//("정규식을 가지고 찾아볼 문자열")
			
			while(m.find()) { //정규식으로 문자열을 반복해서 찾음
				ans++; //찾을때마다 카운트
			}
			System.out.println("#" + cn + " " + ans);
//			String[] arrStr = s.split(sel);
//			if (s.indexOf(sel) == s.length()) { // 문장 끝에 주어진 문자가 있을 경우
//				ans = arrStr.length;
//			}
//			ans = arrStr.length - 1;
		}
	}

}
