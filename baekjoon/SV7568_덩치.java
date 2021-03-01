package com.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class SV7568_덩치 {

	static int N; // 전체 사람 수
	static int[][] man; // [][0]: 몸무게, [][1]: 키 [][2]: 등급

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		man = new int[N][3];

		for (int i = 0; i < N; i++) {
			man[i][0] = sc.nextInt(); // 몸무게
			man[i][1] = sc.nextInt(); // 키
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 앞 사람이 뒷 사람보다 덩치가 작으면 등급 ++
				if(i!=j && man[i][0] < man[j][0] && man[i][1] < man[j][1])
					man[i][2]++;
			}
		}

		for (int i = 0; i < N; i++) {
			System.out.print((man[i][2]+1) + " ");
		}
//		for (int[] m : man) {
//			System.out.println(Arrays.toString(m));
//		}
	}
	
}
