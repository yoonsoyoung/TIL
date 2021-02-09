package com.codeup;

import java.util.Scanner;

public class 기초1053_1072 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 1053
//		int a = sc.nextInt();
//		System.out.println(a==0? 1:0);

		// 1054
//		int a = sc.nextInt();
//		int b = sc.nextInt();
//		System.out.println(a==1 && b==1? 1:0);

		// 1055
//		int a = sc.nextInt();
//		int b = sc.nextInt();
//		System.out.println(a==1 || b==1? 1:0);

		// 1056
//		int a = sc.nextInt();
//		int b = sc.nextInt();
//		System.out.println(a!=b? 1:0);

		// 1057
//		int a = sc.nextInt();
//		int b = sc.nextInt();
//		System.out.println(a==b? 1:0);

		// 1058
//		int a = sc.nextInt();
//		int b = sc.nextInt();
//		System.out.println(a==0 &&b==0? 1:0);

		// 1059
//		int a = sc.nextInt();
//		System.out.printf("%d", ~a);
		/*
		 * 비트단위(bitwise) 연산자는, ~(bitwise not), &(bitwise and), |(bitwise or),
		 *  ^(bitwise xor), <<(bitwise left shift), >>(bitwise right shift)
		 */

		// 1060
//		int a = sc.nextInt();
//		int b = sc.nextInt();
//		System.out.println(a&b);
		
		// 1061
//		int a = sc.nextInt();
//		int b = sc.nextInt();
//		System.out.println(a|b);
		
		// 1062
//		int a = sc.nextInt();
//		int b = sc.nextInt();
//		System.out.println(a^b);
		
		// 1063
//		int a = sc.nextInt();
//		int b = sc.nextInt();
//		System.out.println(a>b?a:b);
		
		// 1064
//		int a = sc.nextInt();
//		int b = sc.nextInt();
//		int c = sc.nextInt();
//		System.out.println((a>b?b:a)<c? (a>b?b:a):c );
		
		// 1065
//		int a = sc.nextInt();
//		int b = sc.nextInt();
//		int c = sc.nextInt();
//		if(a%2==0)
//			System.out.println(a);
//		if(b%2==0)
//			System.out.println(b);
//		if(c%2==0)
//			System.out.println(c);
		
		// 1066
//		int[] arr = new int[3];
//		for(int i =0; i<3; i++) {
//			arr[i] = sc.nextInt();
//			if(arr[i] % 2 == 0)
//				System.out.println("even");
//			else
//				System.out.println("odd");
//		}

		// 1067
//		int a = sc.nextInt();
//		if(a%2==0) {
//			if(a<0)
//				System.out.println("minus\neven");
//			else
//				System.out.println("plus\neven");
//		} else {
//			if(a<0)
//				System.out.println("minus\nodd");
//			else
//				System.out.println("plus\nodd");
//		}
		
		// 1068
//		int a = sc.nextInt();
//		if(a>89)
//			System.out.println("A");
//		else if(a>69)
//			System.out.println("B");
//		else if(a>39)
//			System.out.println("C");
//		else
//			System.out.println("D");
		
		// 1069
//		char s = sc.next().charAt(0);
//		switch(s) {
//		case 'A':
//			System.out.println("best!!!");
//			break;
//		case 'B':
//			System.out.println("good!!");
//			break;
//		case 'C':
//			System.out.println("run!");
//			break;
//		case 'D':
//			System.out.println("slowly~");
//			break;
//		default:
//			System.out.println("what?");
//		}
		
		// 1070
//		int a = sc.nextInt();
//		switch (a) {
//		case 12:
//		case 1:
//		case 2:
//			System.out.println("winter");
//			break;
//		case 3:
//		case 4:
//		case 5:
//			System.out.println("spring");
//			break;
//		case 6:
//		case 7:
//		case 8:
//			System.out.println("summer");
//			break;
//		case 9:
//		case 10:
//		case 11:
//			System.out.println("fall");
//			break;
//		}
		
		// 1071
//		int a =1;
//		while(a!=0) {
//			a = sc.nextInt();
//			if(a!=0)
//			System.out.println(a);
//		}
		
		// 1072
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i =0; i<n; i++) {
			a[i] = sc.nextInt();
			System.out.println(a[i]);
		}
	}
}
/*
import java.util.Scanner;
 
public class Main {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
  
  
} }
 */
