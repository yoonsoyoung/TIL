package com.jungol;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//통과
public class 냉장고_1828 {
	static int N;
	static int[][] temper;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //화학물질의 수
		temper = new int[N][2]; //[0]: 최저기온, [1]: 최고기온
		int ans = 0; //최소로 필요한 냉장고의 대수
		
		for (int i = 0; i < N; i++) {
			temper[i][0] = sc.nextInt();
			temper[i][1] = sc.nextInt();
		}

		Arrays.sort(temper, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1], o2[1]);
			}
			//Intger에서 제공하는 compare함수가 있음.
		});
		
		int currH = temper[0][1]; 
		ans = 1;
		for (int i = 1; i < N; i++) {
			if(temper[i][0] > currH) {
				currH = temper[i][1];
				ans++;
			}
		}
		
		System.out.println(ans);
	}

}
