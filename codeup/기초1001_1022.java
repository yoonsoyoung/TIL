package com.codeup;

import java.util.regex.Pattern;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ����1001_1022 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//1001
//		System.out.println("Hello");
		//1002
//		System.out.println("Hello World");
		//1003
//		System.out.printf("Hello\nWorld");
		//1004
//		System.out.printf("'Hello'");
		//1005
//		System.out.printf("\"Hello World\"");
		//1006
//		System.out.println("\"!@#$%^&*()\"");
		//1007
//		System.out.println("\"C:\\Download\\hello.cpp\"");
		//1008
//		System.out.println("\u250C\u252C\u2510");
//		System.out.println("\u251C\u253C\u2524");
//		System.out.println("\u2514\u2534\u2518");
		//1010
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		System.out.println(n);
		//1011
//		char x = sc.next().charAt(0);
//		System.out.println(x);
		//1012
//		float x = sc.nextFloat();
//		System.out.printf("%f",x);
		//1013
//		int a = sc.nextInt();
//		int b = sc.nextInt();
//		System.out.println(a + " " + b);
		//1014
//		char x = sc.next().charAt(0);
//		char y = sc.next().charAt(0);
//		System.out.println(y + " " + x);
		//1015
//		float x = sc.nextFloat();
//		System.out.printf("%.2f", x);
		//1017
//		int x = sc.nextInt();
//		System.out.println(x + " " + x + " " + x); //for�� �Ⱦ��� �� ��¦ �� ����
//		for(int i = 0; i<3; i++) {
//			System.out.print(x + " ");
//		}
		//1018
//		sc = new Scanner(System.in).useDelimiter("\\s|:"); //���� ��� ":"�� �����Ͽ� �޾ƿ��ڴ�
//		int hour = sc.nextInt();
//		int minute = sc.nextInt();
//		System.out.println(hour + ":" + minute);
		//Pattern���� Ǫ�� �ǵ� �� �𸣰���
//		String pattern = "^[0-9]*:[0-9]*$"; //0-9���� *(�ϳ��Ǵ¾���)
//        String line = sc.nextLine();
//        sc.close();
//        if(Pattern.matches(pattern, line)) {
//            System.out.println(line);
//        }
		//1019
//		String input = sc.next();
//		StringTokenizer st = new StringTokenizer(input, ".");
//		int[] day = new int[3];
//		for(int i =0; st.hasMoreTokens(); i++) { //��ȯ ��ū�� �����ִ°�
//			day[i] = Integer.parseInt(st.nextToken()); //���� ��ū
//		}
//		int year = day[0];
//		int mm = day[1];
//		int dd = day[2];
//		
//		System.out.printf("%04d.", year);
//		System.out.printf("%02d.", mm);
//		System.out.printf("%02d", dd);
		//2020
//		String input = sc.next();
//		StringTokenizer st = new StringTokenizer(input, "-");
//		while(st.hasMoreTokens()) {
//			System.out.print(st.nextToken());
//		}
		//1021
//		String data = sc.next();
//		if(data.length() <= 50) {
//			System.out.println(data);
//		}
		//1022
		String data = sc.nextLine();
		if(data.length()<=2000) {
			System.out.println(data);
		}
	}
}
