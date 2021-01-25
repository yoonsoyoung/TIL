package com.codeup;

import java.util.Scanner;

public class 기초1023_1042 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 1023
//		String n = sc.next();
//		String[] a = n.split("\\.");
//		for(int i =0; i<2; i++) {
//			System.out.println(a[i]);
//		}

		// 1024
//		String n = sc.next();
//		String[] a = n.split("");
//		for(int i = 0; i<a.length; i++) {
//			System.out.println("'" + a[i] + "'");
//		}

		// 1025
//		int n = sc.nextInt();
//		for (int i = 10000; i <= n;) {
//			if (i == 0) {
//				break;
//			}
//				System.out.println("[" + (n / i) * i + "]");
//				n = n % i;
//				i = i / 10;
//		}

		// 1026
//		String t = sc.next();
//		String[] time = t.split(":");
//		System.out.println(Integer.parseInt(time[1]));
		
		// 1027
//		Scanner sc = new Scanner(System.in).useDelimiter("\\s|\\."); 
//		int y = sc.nextInt();
//		int m = sc.nextInt();
//		int d = sc.nextInt();
//		System.out.printf("%02d-%02d-%04d", d, m, y);
		
		// 1028
//		long i = sc.nextLong();
//		System.out.println(i);
		
		// 1029
//		double i = sc.nextDouble();
//		System.out.printf("%.11f", i);
		
		// 1030
		// 1028과 같은 코드 long 형
		
		// 1031
//		int i = sc.nextInt();
//		System.out.printf("%o", i);
		
		// 1032
//		int i = sc.nextInt();
//		System.out.printf("%x", i);
		
		// 1033
//		int i = sc.nextInt();
//		System.out.printf("%X", i);
		
		// 1034
//		String i = sc.next();
//		System.out.println(Integer.parseInt(i, 8)); //parseInt(문자열, 문자열을 읽을 진법)을 Integer 정수로 리턴
		
		// 1035
//		String i = sc.next();
//		System.out.printf("%o", Integer.parseInt(i, 16));
		
		// 1036
//		char a = sc.next().charAt(0);
//		System.out.println((int)a);
		
		// 1037
//		int a = sc.nextInt();
//		System.out.println((char)a);
		
		// 1038
//		long a = sc.nextLong();
//		long b = sc.nextLong();
//		System.out.println(a+b);
		
		// 1039
		// 1038과 같음
		
		// 1040
//		int a = sc.nextInt();
//		System.out.println(-a);
		
		// 1041
//		char a = sc.next().charAt(0);
//		System.out.println((char)(a+1));

		
		// 1042
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(a/b);
		
	}

}