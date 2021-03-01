package com.baekjoon;

import java.util.Scanner;

//통과
public class 직사각형네개합집합면적구하기_2669 {

	static int bX, bY, uX, uY, ans;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		map = new int[101][101];
		for (int k = 0; k < 4; k++) {
			bX = sc.nextInt();
			bY = sc.nextInt();
			uX = sc.nextInt();
			uY = sc.nextInt();
			
			for (int i = bX; i < uX; i++) {
				for (int j = bY; j < uY; j++) {
					map[i][j] = 1;
				}
			}
		}
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if(map[i][j] == 1)
					ans++;
			}
		}
		
		System.out.println(ans);
	}

}
