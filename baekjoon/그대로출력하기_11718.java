package com.baekjoon;

import java.util.Scanner;

// 통과 244ms
public class 그대로출력하기_11718 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()) {
			String s = sc.nextLine();
			System.out.println(s);
		}
		sc.close();
	}

}
