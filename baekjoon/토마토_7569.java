package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 통과 732ms
public class boj_7569_Main {

	static int M, N, H;
	static int[][][] map;
	static Queue<Node> q;

	static class Node {
		int r, c, h, cnt;

		public Node(int r, int c, int h, int cnt) {
			this.r = r;
			this.c = c;
			this.h = h;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken()); // c:세로
		M = Integer.parseInt(st.nextToken()); // r:가로
		H = Integer.parseInt(st.nextToken()); // h:층

		map = new int[M][N][H];
		q = new LinkedList<Node>();
		for (int z = 0; z < H; z++) {
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j][z] = Integer.parseInt(st.nextToken());
					if (map[i][j][z] == 1) { // 익은 토마토
						q.offer(new Node(i, j, z, 0));
					}
				}
			}
		}

		System.out.println(bfs());

	}

	static int[] dr = { -1, 1, 0, 0, 0, 0 };
	static int[] dc = { 0, 0, -1, 1, 0, 0 };
	static int[] dh = { 0, 0, 0, 0, -1, 1 };

	private static int bfs() {
		int max = 0;
		while(!q.isEmpty()) {
			Node curr = q.poll();
			int r = curr.r;
			int c = curr.c;
			int h = curr.h;
			int day = curr.cnt;
			
			max = Math.max(max, map[r][c][h]-1);
			for (int d = 0; d < 6; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				int nh = h + dh[d];
				
				if(nr < 0 || nc < 0 || nh < 0 || nr >= M || nc >= N || nh >= H)
					continue;
				if(map[nr][nc][nh] == -1)
					continue;
				if(map[nr][nc][nh] != 0)
					continue;
				
				q.add(new Node(nr, nc, nh, day+1));
				map[nr][nc][nh] = map[r][c][h]+1; // 토마토가 익은 날짜를 map에 남김
				
			}
		}
		
		for (int z = 0; z < H; z++) {
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j][z] == 0) { // 다 끝나고 돌았는데 안 익은 토마토가 있다면
						return -1; // 모두 익지 못하는 상황
					}
				}
			}
		}
		return max;
	}

}
