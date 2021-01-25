package com.sw.d3;

import java.util.Arrays;
import java.util.Scanner;

public class Sum_1209 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;
		int MAX_SIZE = 100;
		for (int test_case = 1; test_case <= T; test_case++) {
			int[] sum = new int[4]; //[0]:���� [1]:���� [2]:�����밢�� [3]:�����밢��
			int ans = 0;
			int cn = sc.nextInt(); //���̽� ��ȣ
			int[][] arr = new int[MAX_SIZE][MAX_SIZE];
			int garo = 0;
			int[] sero = new int[MAX_SIZE];
			for(int i =0; i<MAX_SIZE; i++) {
				for(int j = 0; j<MAX_SIZE; j++) {
					arr[i][j] = sc.nextInt();
					garo += arr[i][j]; // ������, i��°�� ������ ��� ����
					sero[j] += arr[i][j]; // ������, �� �ε����� i������ ���� i��° j�� ������ �����ؼ� ����
					if(i==j) { // ���� �밢�� �� ����
						sum[2] += arr[i][j];
					}
				}
				if(sum[0] <= garo) { // ������ �ִ� �����պ��� ���� ���� ���� ũ�ų� ������
					sum[0] = garo; // �������� ������Ʈ
				}
				garo = 0;
				for(int j = 0; j<sero.length; j++) { // �������� �ִ밪�� ���ϱ� ����
					if(sum[1] <= sero[j]) {
						sum[1] = sero[j];
					}
				}
				int max = MAX_SIZE;
				sum[3] += arr[i][--max]; // ���� �밢�� ��
				int ans1 = Math.max(sum[0], sum[1]);
				int ans2 = Math.max(sum[2], sum[3]);
				ans = Math.max(ans1, ans2);
			}
			System.out.println("#" + cn + " " + ans);
//			System.out.println(Arrays.toString(sum));
			
		}
	}

}
