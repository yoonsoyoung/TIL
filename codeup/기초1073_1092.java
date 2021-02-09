package com.codeup;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class 기초1073_1092 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		// 1073
//		int n = sc.nextInt(); 
//		while(n!=0) {
//			System.out.println(n);
//			n = sc.nextInt();
//		}

		// 1074
//		int n = sc.nextInt();
//		for (int i = n; i > 0; i--) {
//			System.out.println(i);
//		}

		// 1075
//		int n = sc.nextInt();
//		for (int i = n-1; i >= 0; i--) {
//			System.out.println(i);
//		}

		// 1076
//		char c = sc.next().charAt(0);
//		//A:65 ~ Z:90 a:97~z:122
//		for (int i = 97; i <= c; i++) {
//			System.out.print((char)i + " ");
//		}

		// 1077
//		int n = sc.nextInt();
//		for (int i = 0; i <= n; i++) {
//			System.out.println(i);
//		}

		// 1078
//		int n = sc.nextInt();
//		int sum = 0;
//		for (int i = 1; i <= n; i++) {
//			if(i%2 ==0 )
//				sum += i;
//		}
//		System.out.println(sum);

		// 1079
//		while(true) {
//			char c = sc.next().charAt(0);
//			System.out.println(c);
//			if(c=='q')
//				break;
//		}

		// 1080
//		int n = sc.nextInt();
//		int sum = 0;
//		for (int i = 1; i <= n; i++) {
//			sum += i;
//			if(sum>=n) {
//				System.out.println(i);
//				break;
//			}
//		}

		// 1081
//		int n = sc.nextInt();
//		int m = sc.nextInt();
//		for (int i = 1; i <= n; i++) {
//			for (int j = 1; j <= m; j++) {
//				System.out.println(i + " " + j);
//			}
//		}

		// 1082
//		String c = sc.next();
//		int ci = Integer.parseInt(c, 16);
//		String ans;
//		int mul=0;
//		for (int i = 1; i < 16; i++) {
//			mul = ci * i;
//			ans = Integer.toHexString(mul);
//			System.out.println(c + "*" + Integer.toHexString(i).toUpperCase() + "=" + ans.toUpperCase());
//		}

		// 1083
//		int n = sc.nextInt();
//		for (int i = 1; i <= n; i++) {
//			if(i%3 == 0) {
//				System.out.print("X ");
//				continue;
//			}
//			
//			System.out.print(i + " ");
//		}

		// 1084
		// 시간초과됨
//		int r = sc.nextInt();
//		int g = sc.nextInt();
//		int b = sc.nextInt();
//		int cnt = 0;
//		for (int i = 0; i < r; i++) {
//			for (int j = 0; j < g; j++) {
//				for (int k = 0; k < b; k++) {
//					System.out.println(i+ " " + j + " " + k);
//					cnt++;
//				}
//			}
//		}
//		System.out.println(cnt);
		// 버퍼드리더 사용
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		String n = br.readLine();
//		String[] num = n.split(" ");
//		int r = Integer.parseInt(num[0]);
//		int g = Integer.parseInt(num[1]);
//		int b = Integer.parseInt(num[2]);
//		int cnt = 0;
//		for (int i = 0; i < r; i++) {
//			for (int j = 0; j < g; j++) {
//				for (int k = 0; k < b; k++) {
//					bw.write(i + " " + j + " " + k + "\n");
//					cnt++;
//				}
//			}
//		}
//		bw.flush();
//		System.out.println(cnt);

		// 1085
//		double h = sc.nextInt(); //Hz
//		double b = sc.nextInt(); //bit
//		double c= sc.nextInt(); //chanel
//		double s = sc.nextInt(); //time s
//		//h*b*c*s / 8 / 1024 / 1024
//		
//		double mb;
//		mb = (h*b*c*s)/8/1024/1024;
//		double ans = (Math.round(mb*10))/10.0;
//		System.out.println(ans + " MB");

		// 1086
//		double w = sc.nextDouble();
//		double h = sc.nextDouble();
//		double b = sc.nextDouble();
//		//w*h*b / 8 / 1024 / 1024
//		
//		double mb;
//		mb = (w*h*b)/8/1024/1024;
//		double ans = (Math.round(mb*100))/100.0;
//		System.out.printf("%.2f MB", ans);

		// 1087
//		int n = sc.nextInt();
//		int sum =0;
//		int cnt =1;
//		while(true) {
//			sum += cnt;
//			cnt++;
//			if(sum>=n) {
//				System.out.println(sum);
//				break;
//			}
//		}

		// 1088
//		int n = sc.nextInt();
//		for (int i = 1; i <= n; i++) {
//			if(i%3==0)
//				continue;
//			System.out.print(i + " ");
//		}

		// 1089
//		int a = sc.nextInt(); //시작값
//		int d = sc.nextInt(); //등차
//		int n = sc.nextInt(); //몇번째
//		
//		for(int i = 0; i<n-1; i++) {
//			a += d;
//		}
//		System.out.println(a);

		// 1090
//		long a = sc.nextInt(); //시작값
//		int r = sc.nextInt(); //등비
//		int n = sc.nextInt(); //몇번째
//		
//		for(int i = 0; i<n-1; i++) {
//			a *= r;
//			System.out.println(i +"번째 " + a);
//		}
//		System.out.println(a);

		// 1091
//		long a = sc.nextInt(); //시작값
//		int m = sc.nextInt(); //곱할 값
//		int d = sc.nextInt(); //더할 값
//		int n = sc.nextInt(); //몇번째
//		
//		for(int i = 0; i<n-1; i++) {
//			a = a*m+d;
//		}
//		System.out.println(a);

		// 1092
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int day = 1; // 날짜
		while (day % a != 0 || day % b != 0 || day % c != 0) {
			day++;
		}
		System.out.println(day);
	}
}
/*
import java.util.Scanner;
 
public class Main {
 
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
 
} }
 */