package com.sw.d4;

import java.util.Comparator;
import java.util.Scanner;
/*
2
2
1 2
3 4
3
9 3 4
6 1 5
7 8 2

 */
public class ���簢����_compare {
	static int N ;
	static int[][] room;
	static int ansCnt; //�̵��� ���� Ƚ��
	static int ansStart; //���� ��, ũ�� ��
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			room = new int[N+2][N+2];
			
			for (int i = 1; i <= N; i++) { //�� ��ȣ �Է�
				for (int j = 1; j <= N; j++) {
					room[i][j] = sc.nextInt();
				}
			}
			
			ansCnt = 0; //�̵��� ���� Ƚ��
			ansStart = Integer.MAX_VALUE; //���� ��, ũ�� ��
			
			ans = new Ans(Integer.MAX_VALUE, 0);
			for (int i = 1; i <= N; i++) { // �迭�� ũ�⸦ �� Ű���� �׵θ��� 0���� ������� ������ ������ ���빰
				for (int j = 1; j <= N; j++) {
					move(i, j, new Ans(room[i][j], 1));
				}
			}

			System.out.println("#" + tc + " " + ans.start + " " + ans.cnt);
		}
		
	}
	static class Ans implements Comparable<Ans> {
		int start;
		int cnt;
		Ans(int start, int cnt) {
			this.start = start;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Ans o) {
			if(this.cnt!= o.cnt)
				return Integer.compare(o.cnt, this.cnt); //�� �̵� Ƚ��
			else 
				return Integer.compare(this.start, o.start);
		}
		
	}
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static Ans ans;
	private static void move(int r, int c, Ans a) { //��, ��, ������, Ƚ��
		if(ans.compareTo(a) > 0) { 
			ans = a; 
		}
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i]; //����
			int nc = c + dc[i]; //�¿�
			if(room[nr][nc] == room[r][c] + 1)
				move(nr, nc, new Ans(a.start, a.cnt+1));
		}
		
	}

}
