package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 통과 184ms
public class 주사위굴리기_14499 {

	static int N, M, x, y, K;
	static int[][] map;
	static int[] dice, order;
	//동 서 북 남
	static int[] dr = {0,0,0,-1,1};
	static int[] dc = {0,1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); // map 세로(행) 1<= N,M <= 20
		M = Integer.parseInt(st.nextToken()); // map 가로(열)
		x = Integer.parseInt(st.nextToken()); // 주사위 놓은 곳 좌표 x 0<= x <= N-1
		y = Integer.parseInt(st.nextToken()); // 주사위 놓은 곳 좌표 y 0<= y <= M-1
		K = Integer.parseInt(st.nextToken()); // 명령어 개수 1<= K <= 1000
		map = new int[N][M];
		order = new int[K]; // 명령어 담을 배열
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			order[i] = Integer.parseInt(st.nextToken());
		}
		
		// 가장 처음 주사위에는 모든 면에 0이 적혀져 있다.
		dice = new int[7]; // 1~6까지 쓰기 위함.
		
		int nr = x;
		int nc = y;
		
		for (int i = 0; i < K; i++) {
			int d = order[i]; // 지금 내가 움직여야 할 방향이
			int tempX = nr;
			int tempY = nc;
			nr = nr + dr[d];
			nc = nc + dc[d];
			// 맵 바깥으로 이동 시킬 경우 해당 명령 무시, 출력 x
			if(nr < 0 || nc < 0 || nr >= N || nc >= M) {
				// 이동해봤던 거 돌려놓고
				nr = tempX;
				nc = tempY;
				continue;
			}
			
			// K명령어=> 1: 동, 2: 서, 3: 북, 4: 남
			if(d == 1) // 동
				east();
			else if(d == 2) // 서
				west();
			else if(d == 3) // 북
				north();
			else // 남
				south();
			
			// 이동한 map[i][j] == 0 -> map[i][j] = dice[3]; 주사위 바닥면 수가 맵에 복사
			// map[i][j] != 0 -> dice[3] = map[i][j]; map[i][j] = 0;
			if(map[nr][nc] == 0)
				map[nr][nc] = dice[3];
			else {
				dice[3] = map[nr][nc];
				map[nr][nc] = 0;
			}
			
			// 이동할 때마다 윗면 출력
			System.out.println(dice[1]);
		}
	}

	// 주사위는 1이 윗면, 동쪽이 3으로 (x,y)에 놓인다.
	// [1]윗면 [2]오른쪽면 [3]바닥면 [4]왼쪽면 [5]앞면 [6]뒷면
	static void east() { // 동쪽으로 굴리면
		int t = dice[3]; // 먼저 바닥면 킵
		dice[3] = dice[2]; // 바닥면은 그 전에 오른쪽면이었던 부분이 바닥면이 됨
		dice[2] = dice[1]; // 오른쪽면은 그 전에 윗면이었던 부분
		dice[1] = dice[4]; // 윗면은 그 전에 왼쪽면이었던 부분
		dice[4] = t; // 왼쪽면은 그 전에 바닥면이었던 부분
	}
	static void west() { // 서쪽으로 굴리면
		int t = dice[4]; // 먼저 왼쪽면 킵
		dice[4] = dice[1]; // 왼쪽면은 그 전에 윗면이었던 부분
		dice[1] = dice[2]; // 윗면은 그 전에 오른쪽면이었던 부분
		dice[2] = dice[3]; // 오른쪽면은 그 전에 바닥면이었던 부분
		dice[3] = t; // 바닥면은 그 전에 왼쪽면이었던 부분
	}
	static void south() { // 남쪽으로 굴리면
		int t = dice[5]; // 먼저 앞면 킵
		dice[5] = dice[1]; // 윗면이 앞면이 됨 
		dice[1] = dice[6]; // 뒷면이 윗면이 됨
		dice[6] = dice[3]; // 바닥면이 뒷면이 됨
		dice[3] = t; // 앞면이 바닥면이 됨
	}
	static void north() { // 북쪽으로 굴리면
		int t = dice[3]; // 먼저 바닥면 킵
		dice[3] = dice[6]; // 뒷면이 바닥면이 됨 
		dice[6] = dice[1]; // 윗면이 뒷면이 됨
		dice[1] = dice[5]; // 앞면이 윗면이 됨
		dice[5] = t; // 바닥면이 앞면이 됨
	}
	
}
