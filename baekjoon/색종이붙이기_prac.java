package com.baekjoon;

import java.util.Scanner;

//통과
public class 색종이붙이기_prac {

	static int[][] paper = new int[10][10]; //종이
	static int[] colorPaper = {0, 5, 5, 5, 5, 5}; //색종이
	static int ans = Integer.MAX_VALUE; 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				paper[i][j] = sc.nextInt();
			}
		}
		
		backtrack(0);
		System.out.println(ans == Integer.MAX_VALUE? -1: ans);
		
	}

	
	private static void backtrack(int cnt) {
		// 처음으로 1을 만나는 곳
		int sR = -1, sC = -1;
		out: for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (paper[i][j] ==1) {
					sR = i;
					sC = j;
					break out;
				}
			}
		}
		
		// 아예 안 거침
		if( sR == -1 && sC == -1) {
			ans = Math.min(ans, cnt);
			return;
		}
		
		// 붙일 수 있는 색종이의 사이즈
		int max = 5;
		while(max > 0) {
			boolean isCheck = true;
			out: for(int i = 0; i<max; i++ ) {
				for(int j = 0 ; j<max; j++) {
					if(sR + i>=10 || sC+j >=10 || paper[sR+i][sC+j] == 0) {
						isCheck = false;
						break out;
					}
				}
			}
			
			if(isCheck)
				break;
			
			max--;
		}
		
		// 그 색종이로 붙이고
		for(int i = 1 ; i<=max ; i++) {
			if(colorPaper[i] == 0)
				continue;
			
			for(int j = sR; j<sR+i; j++) {
				for(int k = sC; k<sC+i ; k++) {
					paper[j][k] = 0;
				}
			}
			
			colorPaper[i]--;
			
			backtrack(cnt + 1);
			
			for(int j = sR; j<sR+i; j++) {
				for(int k = sC; k<sC+i; k++) {
					paper[j][k] = 1;
				}
			}
			
			colorPaper[i]++;
		}
		
		
	}
}
