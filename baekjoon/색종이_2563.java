package com.baekjoon;

import java.util.Scanner;

//�̿�
public class ������_2563 {
	static int left;
	static int bottom;
	static int[][] paper;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		paper = new int[100][100];

		int T = sc.nextInt();
		int ans = 0;
		for (int tc = 0; tc < T; tc++) {
			left = sc.nextInt();
			bottom = sc.nextInt();

			for (int i = left; i < left+10; i++) {
				for (int j = bottom; j < bottom+10; j++) {
					if(paper[i][j] == 1) //�̹� 1�̸�
						continue;
					paper[i][j] = 1;
					ans+=1; //���� ����
				}
			}
		}
		System.out.println(ans);
	}

}
