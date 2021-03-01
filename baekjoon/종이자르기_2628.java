package com.baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
//통과 240ms
public class 종이자르기_2628 {

	static int x, y, c, ans;
	static int max = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> garo = new ArrayList<Integer>();
		List<Integer> sero = new ArrayList<Integer>();
		garo.add(0);
		sero.add(0);
		
		y = sc.nextInt(); // 가로, 행, 0
		x = sc.nextInt(); // 세로, 열, 1
		c = sc.nextInt(); // 자르는 횟수
		
		garo.add(y);
		sero.add(x);
		
		for (int i = 0; i < c; i++) {
			int cutD = sc.nextInt();
			if(cutD == 1)
				garo.add(sc.nextInt());
			else
				sero.add(sc.nextInt());
		}
		
		Collections.sort(garo);
		Collections.sort(sero);
		
		ans = 0;
		for (int i = 1; i < garo.size(); i++) {
			for (int j = 1; j < sero.size(); j++) {
				ans = (garo.get(i) - garo.get(i-1) ) * (sero.get(j) - sero.get(j-1));
				max = Math.max(max, ans);
			}
		}
		
		System.out.println(max);
	}

}
