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
			Pattern p = Pattern.compile(sel); //���� ����("���Խ�")
			Matcher m = p.matcher(s);//("���Խ��� ������ ã�ƺ� ���ڿ�")
			
			while(m.find()) { //���Խ����� ���ڿ��� �ݺ��ؼ� ã��
				ans++; //ã�������� ī��Ʈ
			}
			System.out.println("#" + cn + " " + ans);
//			String[] arrStr = s.split(sel);
//			if (s.indexOf(sel) == s.length()) { // ���� ���� �־��� ���ڰ� ���� ���
//				ans = arrStr.length;
//			}
//			ans = arrStr.length - 1;
		}
	}

}
