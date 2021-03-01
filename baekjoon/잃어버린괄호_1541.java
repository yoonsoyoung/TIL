package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//��� 140ms
public class �Ҿ������ȣ_1541 {

	static String input;
	static String[] plus;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// ������ ���� ���� ��� �� ������
		// 1. ���ڿ��� �Է��� �ް�
		input = br.readLine();
		
		// 2. '-'�� �������� �и�
		plus = input.split("-");

		int ans = plusSum(plus[0]); //0���� ó�� - �ձ����ϱ� �ϴ� ��� �ְ�
		
		// 3. �и��� �� �迭������ + �ĵ�-> �������ְ� �ͼ� ����
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
