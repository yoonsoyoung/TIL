package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 통과 296ms
public class 나이트의이동_7562 {

	static int T, N, map[][], sR, sC, fR, fC;
	static class Node {
		int r, c, cnt;

		public Node(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine()); // 체스판 크기
			map = new int[N][N];
			
			st = new StringTokenizer(br.readLine(), " ");
			sR = Integer.parseInt(st.nextToken()); // 시작 행
			sC = Integer.parseInt(st.nextToken()); // 시작 열
			
			st = new StringTokenizer(br.readLine(), " ");
			fR = Integer.parseInt(st.nextToken()); // 도착 행
			fC = Integer.parseInt(st.nextToken()); // 도착 열
			
			System.out.println(bfs());
		}
	}
	
	static int[] dr = {-2, -2, -1, 1, 2, 2, 1, -1};
	static int[] dc = {-1, 1, 2, 2, 1, -1, -2, -2};
	
	private static int bfs() {
		Queue<Node> q = new LinkedList<Node>();
		boolean[][] visited = new boolean[N][N];
		
		q.offer(new Node(sR, sC, 0));
		visited[sR][sC] = true;
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			int r = curr.r;
			int c = curr.c;
			int cnt = curr.cnt;
			
			if(r == fR && c == fC)
				return cnt;
			
			for (int d = 0; d < 8; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr<0 || nc<0 || nr>= N || nc>= N)
					continue;
				if(visited[nr][nc])
					continue;
				
				q.offer(new Node(nr, nc, cnt+1));
				visited[nr][nc] = true;
			}
			
		}
		
		return 0;
	}

}
