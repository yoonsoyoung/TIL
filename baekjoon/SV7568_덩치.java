package com.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class SV7568_��ġ {

	static int N; // ��ü ��� ��
	static int[][] man; // [][0]: ������, [][1]: Ű [][2]: ���

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		man = new int[N][3];

		for (int i = 0; i < N; i++) {
			man[i][0] = sc.nextInt(); // ������
			man[i][1] = sc.nextInt(); // Ű
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// �� ����� �� ������� ��ġ�� ������ ��� ++
				if(i!=j && man[i][0] < man[j][0] && man[i][1] < man[j][1])
					man[i][2]++;
			}
		}

		for (int i = 0; i < N; i++) {
			System.out.print((man[i][2]+1) + " ");
		}
//		for (int[] m : man) {
//			System.out.println(Arrays.toString(m));
//		}
	}
	
}
