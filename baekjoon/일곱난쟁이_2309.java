package com.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class �ϰ�������_2309 {
	static boolean[] isSelected;
	static int[] nanjaeng;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		nanjaeng = new int[9];
		isSelected = new boolean[9];
		
		for (int i = 0; i < 9; i++) {
			nanjaeng[i] = sc.nextInt(); //������ Ű �Է¹���
		}
		Arrays.sort(nanjaeng);
		PowerSet(0);
	}
	
	private static void PowerSet(int cnt) {
		//����
		if(cnt == nanjaeng.length) {
			
			int sum = 0;
			int trueCnt = 0;
			for (int i = 0; i < 9; i++) {
				if(isSelected[i]) {
					sum += nanjaeng[i];
					trueCnt++;
				}
			}
			
			//true�� ������ 7���̰� true�� ������ ���� 100�� �´ٸ�
			if(trueCnt ==7 && sum==100) {
				for (int i = 0; i < 9 ; i++) {
					if (isSelected[i]) {
						System.out.println(nanjaeng[i]);
					}
				}
				//system.exit(0); �� �����Ű��
				System.exit(0);
			}
			return;
		}
		
		//����
		isSelected[cnt] = true;
		PowerSet(cnt+1);
		isSelected[cnt] = false;
		PowerSet(cnt+1);
	}

}
