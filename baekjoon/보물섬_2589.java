package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 통과 524ms
public class 보물섬_2589 {

	static int R, C, ans;
	static char[][] map;

	static class Node {
		int r, c, dist;

		public Node(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken()); // 행
		C = Integer.parseInt(st.nextToken()); // 열
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		ans = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'L')
					bfs(i, j);
			}
		}
		
		System.out.println(ans);
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void bfs(int x, int y) {
		Queue<Node> q = new LinkedList<Node>();
		boolean[][] visited = new boolean[R][C];

		q.offer(new Node(x, y, 0));
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			int r = curr.r;
			int c = curr.c;
			int dist = curr.dist;
			ans = Math.max(ans, dist);
			
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr<0 || nc <0 || nr >= R || nc >= C)
					continue;
				if(map[nr][nc] == 'W')
					continue;
				if(visited[nr][nc])
					continue;
				
				q.offer(new Node(nr, nc, dist+1));
				visited[nr][nc] = true;
			}
		}
	}

}
