package com.sw.d1;

import java.util.Scanner;

public class 알파벳을숫자로변환_2050 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// A=65, Z=90
		String s = sc.next(); 
		for (int i = 0; i < 26; i++) {
			char a = s.charAt(i);
			System.out.print(a-64 + " ");
		}
	}

}
