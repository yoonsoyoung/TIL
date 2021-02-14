package com.sw.d3;

import java.util.Scanner;
/*
4
3 45
20 20 20
6 10
1 2 5 8 9 11
4 100
80 80 60 60
4 20
10 5 10 16

 */
public class �Ѻ��̿�SpotMart_9229 {
	
	static int T, N, M, ans;
	static int[] a ;
	static boolean[] isSelect;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); //���� ����
			M = sc.nextInt(); //�� ���� ���� �ִ밪
			a = new int[N];
			isSelect = new boolean[N];
			ans = 0;
			for (int i = 0; i < N; i++) {
				a[i] = sc.nextInt();
			}
			combi(0, 0, 0); //�ε���, ������, ��������
			if(ans == 0) ans = -1;
			System.out.println("#" + tc + " " + ans);
			
			
		}
	}
	
	static void combi(int cnt, int start, int sum) {
		if(cnt == 2) { //��Ȯ�� �� ����
			if(sum<=M) { //���� �ִ밪 ���ϸ�
				ans = Math.max(ans, sum);
				return;
			}
		}
		if(sum>M) return; //���� �Ѿ�� ����.
		
		
		for (int i = start; i < N; i++) {
			//dfs ������ �˻�
			if(isSelect[i]) continue;
			isSelect[i] = true;
			combi(cnt+1, i+1, sum + a[i]);
			isSelect[i] = false;
		}
	}
	/*
	static void subset(int cnt) {
		//����
		if(cnt == 2) { // ��Ȯ�� �� ������
			int sum = 0;
			int selectCnt = 0; 
			for (int i = 0; i < 2; i++) {
				if(isSelect[i]) {
					sum+= a[i];
					selectCnt++;
				}
			}
			
			if(sum<=M && selectCnt>0) { //���� �ִ밪 ���� && ������ ����
				System.out.println(sum);
			} else //�� ����� ���� ���
				System.out.println("-1");
		}
		//����
		isSelect[cnt] = true;
		subset(cnt+1);
		isSelect[cnt] = false;
		subset(cnt+1);
	}
	*/
	

}
