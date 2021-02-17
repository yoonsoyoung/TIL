package com.baekjoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ȸ�ǽǹ���_1931 {

	static int N, ans;
	static int[][] time;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		time = new int[N][2]; //0���� ���۽ð� 1���� ������ �ð�
		for (int i = 0; i < N; i++) {
			time[i][0] = sc.nextInt(); //���� �ð�
			time[i][1] = sc.nextInt(); //������ �ð�
		}
		
		// ������ �ð��� �̸� ������ ���� -> �͸�Ŭ���� comparator�� ���� ��������= ����-���ǲ� 
		Arrays.sort(time, new Comparator<int[]>() { //���� �����ϴ� ����
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) //������ �ð� ���ٸ�
					return o1[0]-o2[0]; //�� ���� �����ϴ� �ַ�
				else
					return o1[1]-o2[1]; //�� ���� ������ ��
			}
		});
		int currS = time[0][0]; //���� ���� ������ ȸ���� ���� �ð�
		int currE = time[0][1]; //���� ���� ������ ȸ���� ���� �ð�
		ans = 1; //���� ���� ������ ȸ�� �⺻���� �ְ� ����.
		for (int i = 1; i < N; i++) {
			//���� ȸ���� ���۽ð��� �ֱ� ȸ���� ����ð��� ���ų� ������ ��
			if(time[i][0] >= currE) {
				currS = time[i][0];
				currE = time[i][1];
//				System.out.println(time[i][0] + ", " + time[i][1]);
				ans++;
			}
		}
		
		System.out.println(ans);
	}
	
}
