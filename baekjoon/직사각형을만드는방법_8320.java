package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//��� 132ms
public class ���簢��������¹��_8320 {

	static int N, sum;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		sum = 0;
		
		// �̰� �� �����ΰɱ�?
//		int sum2 = 0;
//		for (int i = 0; i < N; i++) { // �׳� �� �ٷ� ���� ���簢��
//			sum2++;
//			if(i>2 && i*i <= N) // 3*3 ���� n*n ���簢��
//				sum2++;
//		}
//		if(i>=2) { //���͵� �� �߰�, �����ߴµ� ���� ��� Ȯ�� ���غ�
//		for (int j = 0; j <= N-i*i; j+=i) { // i*i ���簢������ i���� ���� ���簢��
//			if(i*i+j <= N)
//				sum2++;
//		}}
//		System.out.println(sum2);
		
		for (int i = 1; i <= N; i++) { //����
			for (int j = i; i*j <= N; j++) { //����
				// 1*1, 1*2, 1*3, ... , 2*2, 2*3, ... , 3*3, 3*4, ... , N*N ���� 
				sum++;
			}
		}
		System.out.println(sum);
	}

}
