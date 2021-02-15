package com.sw.d4;

import java.util.Scanner;

public class ���簢����_��� {
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
			for (int i = 1; i <= N; i++) { // �迭�� ũ�⸦ �� Ű���� �׵θ��� 0���� ������� ������ ������ ���빰
				for (int j = 1; j <= N; j++) {
					move(i, j, room[i][j], 1);
				}
			}

			System.out.println("#" + tc + " " + ansStart + " " + ansCnt);
		}
		
	}
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	private static void move(int r, int c, int start, int cnt) { //��, ��, ������, Ƚ��
		if(cnt>ansCnt) { //�� �̵����� ��
			ansStart = start;
			ansCnt = cnt;
		} else if(cnt == ansCnt) {
			ansStart = (ansStart>=start ? start : ansStart);
		}
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i]; //����
			int nc = c + dc[i]; //�¿�
			if(room[nr][nc] == room[r][c] + 1)
				move(nr, nc, start, cnt+1);
		}
		
	}

}
