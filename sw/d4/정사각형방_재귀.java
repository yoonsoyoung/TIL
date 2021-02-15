package com.sw.d4;

import java.util.Scanner;

public class 정사각형방_재귀 {
	static int N ;
	static int[][] room;
	static int ansCnt; //이동한 방의 횟수
	static int ansStart; //시작 방, 크게 잡
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			room = new int[N+2][N+2];
			
			for (int i = 1; i <= N; i++) { //방 번호 입력
				for (int j = 1; j <= N; j++) {
					room[i][j] = sc.nextInt();
				}
			}
			
			ansCnt = 0; //이동한 방의 횟수
			ansStart = Integer.MAX_VALUE; //시작 방, 크게 잡
			for (int i = 1; i <= N; i++) { // 배열의 크기를 더 키워서 테두리가 0으로 만들었기 때문에 실질적 내용물
				for (int j = 1; j <= N; j++) {
					move(i, j, room[i][j], 1);
				}
			}

			System.out.println("#" + tc + " " + ansStart + " " + ansCnt);
		}
		
	}
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	private static void move(int r, int c, int start, int cnt) { //행, 열, 시작점, 횟수
		if(cnt>ansCnt) { //방 이동했을 때
			ansStart = start;
			ansCnt = cnt;
		} else if(cnt == ansCnt) {
			ansStart = (ansStart>=start ? start : ansStart);
		}
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i]; //상하
			int nc = c + dc[i]; //좌우
			if(room[nr][nc] == room[r][c] + 1)
				move(nr, nc, start, cnt+1);
		}
		
	}

}
