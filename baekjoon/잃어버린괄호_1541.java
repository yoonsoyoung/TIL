package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//통과 140ms
public class 잃어버린괄호_1541 {

	static String input;
	static String[] plus;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 덧셈을 묶어 먼저 계산 후 빼주자
		// 1. 문자열로 입력을 받고
		input = br.readLine();
		
		// 2. '-'를 기준으로 분리
		plus = input.split("-");

		int ans = plusSum(plus[0]); //0번은 처음 - 앞까지니까 일단 계산 넣고
		
		// 3. 분리된 각 배열값들은 + 식들-> 덧셈해주고 와서 빼줌
		for (int i = 1; i < plus.length; i++) {
			ans -= plusSum(plus[i]);
		}
		
		System.out.println(ans);
	}

	static int plusSum(String str) {
		int sum = 0;
		String[] s = str.split("\\+");
		
		for (int i = 0; i < s.length; i++) {
			sum += Integer.parseInt(s[i]);
		}
		
		return sum;
		
	}
}
