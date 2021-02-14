package com.sw.d3;

import java.util.Scanner;

public class ���۹���Ȯ�ϱ�_2805 {

	static int T, N;
	static int[][] farm;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); // ������ ũ��
			farm = new int[N][N];
			int ans = 0;
			
			for (int i = 0; i < N; i++) { //farm �迭�� �� �Է�
				String val = sc.next();
				for (int j = 0; j < N; j++) {
					farm[i][j] = val.charAt(j) - '0';
				}
			}

			//�������� ���۹� ��ġ ��Ȯ
			int mid = N/2;
			int d = mid;
			//�� �ﰢ��
			for (int i = 0; i < mid ; i++) { //0~����ٱ���
				for (int j = d; j <N-d; j++) { //������� �����ؼ� �� �����ٿ��� �� �� ĭ ������... 
					ans += farm[i][j];
				}
				d--;
			}

			//�Ʒ� �ﰢ��
			for (int i = mid; i < N; i++) {
				for (int j = d; j < N-d; j++) {
					ans += farm[i][j];
				}
				d++;
			}
			
			System.out.println("#" + tc + " " + ans);
		}
	}

}
