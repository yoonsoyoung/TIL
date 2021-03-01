package com.baekjoon;

import java.util.Scanner;

public class �����̿�ģ����_1592 {

	static int N, M, L, ans, ballCnt;
	static int[] man;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // �ڸ� ��
		M = sc.nextInt(); // ���� ���� �ִ� Ƚ��
		L = sc.nextInt(); // M������ ���� ���� ������κ��� L ��° �ִ� ���
		ans = 0;
		man = new int[N+1]; //�ε����� 1��~N�� �ڸ��� �ϱ� ����
		ballCnt = 1;
		man[1] = 1; //1�� ����� �ް� ����
		while(true) {
			// ������ �޾Ҵµ�
			if(man[ballCnt] % 2 == 1) { // Ȧ����
				ballCnt += L; // �ð� �������� L ��° -> ����������
				if(ballCnt > N) 
					ballCnt %= N; // �� �Ѿ <- ������
			} else { // ¦����
				ballCnt -= L; // �ݽð� ���� -> ��������
				 if(ballCnt < 1) // 1�� �ڸ��� �ּ�
					 ballCnt += N;  
			}
			
			man[ballCnt]++; //�ް�
			ans++; //����
			if(man[ballCnt] == M) // ���� �� M�� ������ ��
				break;
		}
		
		System.out.println(ans);

	}

}
