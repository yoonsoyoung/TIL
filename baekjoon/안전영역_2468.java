package com.baekjoon;

import java.util.Scanner;

//통과
public class 안전영역_2468 {

	static int N, ans, cnt, maxAns;
	static int[][] map; //원본
	static int[][] zone; //장마 후

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		map = new int[N][N];
		zone = new int[N][N];
		int high = 0; // 제일 높은 곳을 알기 위함
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				high = Math.max(high, map[i][j]);
			}
		}
		maxAns = 0;
		cnt = 0; //비의 양 -> 아무 지역도 물에 잠기지 않을 수도 있다는 조건이 있기 때문에 0부터 해줘야 함.
		while(cnt < high) {
			ans = 0;
//			System.out.println("비의 양 : " + cnt);
			for (int i = 0; i < N; i++) { //장마 후 맵-> zone
				for (int j = 0; j < N; j++) {
					if (map[i][j] <= cnt) {
						zone[i][j] = 0;
					} else
						zone[i][j] = 1;
//					System.out.print(zone[i][j] +" ");
				}
//				System.out.println();
			}
			
			for (int i = 0; i < N; i++) { //그 zone을 가지고 잠긴 곳은 0, 육지는 1
				for (int j = 0; j < N; j++) {
					if(zone[i][j] == 1) {
						safeZone(i, j);
						ans++;
					}
				}
			}
//			System.out.println(ans);
			maxAns = Math.max(maxAns, ans);
			cnt++;
		}
		
		System.out.println(maxAns);

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	private static void safeZone(int r, int c) {
		zone[r][c] = 0; // 해당 자리 0으로 바꾸고

		for (int d = 0; d < 4; d++) { // 사방검색
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr < 0 || nc < 0 || nr >= N || nc >= N) // 범위 벗어나면 다음
				continue;
			if (zone[nr][nc] == 1) { // 섬이고
				safeZone(nr, nc);
			}

		}
		
	}

}
