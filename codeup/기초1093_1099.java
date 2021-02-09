package com.codeup;

import java.util.Arrays;
import java.util.Scanner;

public class 기초1093_1099 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//1093
//		int N = sc.nextInt();
//		int[] arr = new int[N];
//		int[] a = new int[24]; //빈도배열
//		for (int i = 0; i < N; i++) {
//			arr[i] = sc.nextInt();
//			a[arr[i]]++;
//		}
//		for (int i = 1; i < a.length; i++) {
//			System.out.print(a[i] + " ");
//		}
		
		//1094
//		int N = sc.nextInt();
//		int[] arr = new int[N];
//		for (int i = 0; i < N; i++) {
//			arr[i] = sc.nextInt();
//		}
//		for (int i = N-1; i >= 0; i--) {
//			System.out.print(arr[i] + " ");
//		}
		
		//1095
//		int N = sc.nextInt();
//		int[] arr = new int[N];
//		for (int i = 0; i < N; i++) {
//			arr[i] = sc.nextInt();
//		}
//		Arrays.sort(arr);
//		System.out.println(arr[0]);
		
		//1096
//		byte[][] pan = new byte[22][22]; //19*19 주변으로 0인 테두리를 만듬
//		int[] white = new int[2]; //x,y 좌표 넣을 배열
//		int n = sc.nextInt(); //흰 돌 개수
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < 2; j++) {
//				white[j] = sc.nextInt();
//			}
//			
//			pan[white[0]][white[1]] = 1;
//		}
//		
//		for (int i = 1; i <= 19; i++) {
//			for (int j = 1; j <= 19; j++) {
//				System.out.print(pan[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		//1097
//		byte[][] pan = new byte[20][20];
//		for (int i = 1; i <= 19; i++) {
//			for (int j = 1; j <= 19; j++) {
//				pan[i][j] = sc.nextByte();
//			}
//		}
//		
//		int n = sc.nextInt();
//		for (int i = 0; i < n; i++) {
//			int x = sc.nextInt();
//			int y = sc.nextInt();
//			
//			for (int j = 1; j <= 19; j++) { //가로줄
//				if(pan[x][j] == 0)
//					pan[x][j] = 1;
//				else
//					pan[x][j] = 0;
//			}
//			
//			for (int j = 1; j <= 19; j++) { //세로줄
//				if(pan[j][y] == 0)
//					pan[j][y] = 1;
//				else
//					pan[j][y] = 0;
//			}
//		}
//		
//		for (int i = 1; i <= 19; i++) {
//			for (int j = 1; j <= 19; j++) {
//				System.out.print(pan[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		//1098
//		int h = sc.nextInt();
//		int w = sc.nextInt();
//		int n = sc.nextInt();
//		byte[][] arr = new byte[h+1][w+1];
//		for (int i = 0; i < n; i++) {
//			int l = sc.nextInt(); //길이
//			int d = sc.nextInt(); //방향. 가로:0, 세로:1
//			int x = sc.nextInt();
//			int y = sc.nextInt();
//			
//			switch (d) {
//			case 0: //가로
//				for (int j = 0; j < l; j++) {
//					arr[x][y+j] = 1;
//				}
//				break;
//
//			case 1: //세로
//				for (int j = 0; j < l; j++) {
//					arr[x+j][y] = 1;
//				}
//				break;
//			}
//		}
//		for (int j = 1; j <= h; j++) {
//			for (int k= 1; k <= w; k++) {
//				System.out.print(arr[j][k] + " ");
//			}
//			System.out.println();
//		}
		
		//1099
		int[][] a = new int[10][10];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		int end =0;
		int go = 1;
		for (int i = 1; i < 10; i++) {
			if(end != 1) {
				for (int j = go; j < 10; j++) {
					if(a[i][j] == 0) //갈 수 있는 곳
						a[i][j] = 9;
					else if(a[i][j] == 2) { //먹이
						a[i][j] = 9;
						end = 1;
						break;
					} else { //장애물이 있으면
						go = j-1;
						break;
					}
					
				}
				
			} else
				break;
		}
		
		for (int j = 0; j < 10; j++) {
			for (int k= 0; k < 10; k++) {
				System.out.print(a[j][k] + " ");
			}
			System.out.println();
		}
		
		
		
	}

}

/*
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
	}

}
*/