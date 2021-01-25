package com.sw.d1;

import java.util.Scanner;

public class 일대일가위바위보 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		//1 가위 2바위 3보
		if(a==1 & b==3) {
			System.out.println("A");
		} else if(a>b){
			System.out.println("A");
		} else if(b==3 && a==1 ){
			System.out.println("B");
		} else {
			System.out.println("B");
		}
	}

}
