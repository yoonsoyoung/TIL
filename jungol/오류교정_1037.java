package com.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ��������_1037 {

	static int N, rowSum, colSum, chkR, chkC, corruptCnt;
	static int[][] arr;
	static boolean chk;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];

		colSum = 0;

		for (int i = 0; i < N; i++) { // �迭 �Է�
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// �迭 ���鼭 �˻�
		// �� ���� ��� ¦���� & �� ���� ��� ¦�� �� => OK
		// �� �� �� �ϳ� Ȧ����(j) & �� �� �� �ϳ� Ȧ�� ��(i) => �� �ڸ�(i,j) Change bit
		// �� ��� ���� 1���� �����Ѵ� �����Ƿ� i,j ��� �� +1 �� �������
		// �� ���� ���� �� �� �̻� Ȧ�� �� => Corrupt

		corruptCnt = 0; // �ٲ�� �� ��ǥ ������ 2�� �̻��̸� �׳� Corrupt
		// �� ���� �� �˻�
		for (int i = 0; i < N; i++) {
			rowSum = 0;
			for (int j = 0; j < N; j++) {
				rowSum += arr[i][j]; // i���� ��� 1 ������
			}
			if (rowSum % 2 != 0) { // ���� ¦�� ���� �ƴϸ�
				chkR = i; // �� �� ��ǥ ���
				corruptCnt++; // �ٲ�� �� ��ǥ ���� ����
				chk = true; // ������ ����
			} else if(corruptCnt>1 && chk) { // �̹� �ٲ� ��ǥ�� 2�� �̻��̰� ������ �ִٸ�
				corruptCnt++;
				break;
			}
		}
		
		// �� ���� �� �˻�
		if(corruptCnt>1) {
			
		} else {
			corruptCnt = 0; // �������� �ٲ�� �� ��ǥ ���� ���� �ʱ�ȭ
			chk = false; // �������� ���� ���θ� ���� �ʱ�ȭ
			for (int i = 0; i < N; i++) {
				colSum = 0;
				for (int j = 0; j < N; j++) {
					colSum += arr[j][i]; // �� ���� �� �� ������
				}
				if (colSum % 2 != 0) { // ���� ¦�� ���� �ƴϸ�
					chkC = i; // �� ��ǥ ���
					corruptCnt++; // �ٲ�� �� ��ǥ ���� ����
					chk = true; // ������ ����
				} else if(corruptCnt>1 && chk) { // �̹� �ٲ� ��ǥ�� 2�� �̻��̰� ������ �ִٸ�
					corruptCnt++;
					break;
				}
			}	
		}
		
		if(corruptCnt == 0) // �ٲ� ��ǥ�� ����
			System.out.println("OK");
		else if (corruptCnt == 1) // �ϳ� �ٲ�
			System.out.println("Change bit (" + (chkR+1) + "," + (chkC+1) + ")");
		else
			System.out.println("Corrupt");
	}

}
