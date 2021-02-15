package com.sw.d4;

import java.util.Scanner;

public class 쇠막대기자르기_5432 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			String s = sc.next();
			String ns = s.replace("()", "R"); //() 는 레이저
			int ans = 0;
			int open = 0; //막대기 열려있는
			int close = 0; //완전히 닫힌  수
			int stick = 0; //총 쇠막대기 수
			int[] raser = new int[1000000];
			for (int i = 0; i < ns.length()-1; i++) {
				if(ns.charAt(i) == '(') { //쇠막대기 시작
					open++;
					stick++;
				} else if(ns.charAt(i) == 'R') { //레이저면
					for (int j = close; j < open+close; j++) {
						raser[j]++; //해당 위치 레이저 추가
					}
				} else if(ns.charAt(i)==')') { //막대기 닫히면
					close++;
					open--;
				}
			}
			
			for (int i = 0; i < stick; i++) {
				ans = ans + raser[i] +1; //쇠막대기를 레이저가 n번 자르면 n+1개가 됨
				//ex. 1개의 막대를 1번 자르면 2개나옴, 1개의 막대를 2번 자르면 3개 나옴.
			}
			System.out.println("#" + tc + " " + ans);
		}
	}

}
