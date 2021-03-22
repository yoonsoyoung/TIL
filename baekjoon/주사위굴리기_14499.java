package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ��� 184ms
public class �ֻ���������_14499 {

	static int N, M, x, y, K;
	static int[][] map;
	static int[] dice, order;
	//�� �� �� ��
	static int[] dr = {0,0,0,-1,1};
	static int[] dc = {0,1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); // map ����(��) 1<= N,M <= 20
		M = Integer.parseInt(st.nextToken()); // map ����(��)
		x = Integer.parseInt(st.nextToken()); // �ֻ��� ���� �� ��ǥ x 0<= x <= N-1
		y = Integer.parseInt(st.nextToken()); // �ֻ��� ���� �� ��ǥ y 0<= y <= M-1
		K = Integer.parseInt(st.nextToken()); // ��ɾ� ���� 1<= K <= 1000
		map = new int[N][M];
		order = new int[K]; // ��ɾ� ���� �迭
		
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
		
		// ���� ó�� �ֻ������� ��� �鿡 0�� ������ �ִ�.
		dice = new int[7]; // 1~6���� ���� ����.
		
		int nr = x;
		int nc = y;
		
		for (int i = 0; i < K; i++) {
			int d = order[i]; // ���� ���� �������� �� ������
			int tempX = nr;
			int tempY = nc;
			nr = nr + dr[d];
			nc = nc + dc[d];
			// �� �ٱ����� �̵� ��ų ��� �ش� ��� ����, ��� x
			if(nr < 0 || nc < 0 || nr >= N || nc >= M) {
				// �̵��غô� �� ��������
				nr = tempX;
				nc = tempY;
				continue;
			}
			
			// K��ɾ�=> 1: ��, 2: ��, 3: ��, 4: ��
			if(d == 1) // ��
				east();
			else if(d == 2) // ��
				west();
			else if(d == 3) // ��
				north();
			else // ��
				south();
			
			// �̵��� map[i][j] == 0 -> map[i][j] = dice[3]; �ֻ��� �ٴڸ� ���� �ʿ� ����
			// map[i][j] != 0 -> dice[3] = map[i][j]; map[i][j] = 0;
			if(map[nr][nc] == 0)
				map[nr][nc] = dice[3];
			else {
				dice[3] = map[nr][nc];
				map[nr][nc] = 0;
			}
			
			// �̵��� ������ ���� ���
			System.out.println(dice[1]);
		}
	}

	// �ֻ����� 1�� ����, ������ 3���� (x,y)�� ���δ�.
	// [1]���� [2]�����ʸ� [3]�ٴڸ� [4]���ʸ� [5]�ո� [6]�޸�
	static void east() { // �������� ������
		int t = dice[3]; // ���� �ٴڸ� ŵ
		dice[3] = dice[2]; // �ٴڸ��� �� ���� �����ʸ��̾��� �κ��� �ٴڸ��� ��
		dice[2] = dice[1]; // �����ʸ��� �� ���� �����̾��� �κ�
		dice[1] = dice[4]; // ������ �� ���� ���ʸ��̾��� �κ�
		dice[4] = t; // ���ʸ��� �� ���� �ٴڸ��̾��� �κ�
	}
	static void west() { // �������� ������
		int t = dice[4]; // ���� ���ʸ� ŵ
		dice[4] = dice[1]; // ���ʸ��� �� ���� �����̾��� �κ�
		dice[1] = dice[2]; // ������ �� ���� �����ʸ��̾��� �κ�
		dice[2] = dice[3]; // �����ʸ��� �� ���� �ٴڸ��̾��� �κ�
		dice[3] = t; // �ٴڸ��� �� ���� ���ʸ��̾��� �κ�
	}
	static void south() { // �������� ������
		int t = dice[5]; // ���� �ո� ŵ
		dice[5] = dice[1]; // ������ �ո��� �� 
		dice[1] = dice[6]; // �޸��� ������ ��
		dice[6] = dice[3]; // �ٴڸ��� �޸��� ��
		dice[3] = t; // �ո��� �ٴڸ��� ��
	}
	static void north() { // �������� ������
		int t = dice[3]; // ���� �ٴڸ� ŵ
		dice[3] = dice[6]; // �޸��� �ٴڸ��� �� 
		dice[6] = dice[1]; // ������ �޸��� ��
		dice[1] = dice[5]; // �ո��� ������ ��
		dice[5] = t; // �ٴڸ��� �ո��� ��
	}
	
}
