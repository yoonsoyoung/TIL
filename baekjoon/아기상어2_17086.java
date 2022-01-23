package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 통과 512ms
public class boj_17086_Main {

	static int N, M, map[][], ans;
	static boolean visited[][];

	static class Safe {
		int r, c, dist;

		public Safe(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken()); // 행
		M = Integer.parseInt(st.nextToken()); // 열
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0)
					bfs(i, j);
			}
		}
		
		System.out.println(ans+1);

	}

	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };

	private static void bfs(int x, int y) {
		Queue<Safe> q = new LinkedList<Safe>();
		visited = new boolean[N][M];
		
		q.offer(new Safe(x, y, 0));
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			Safe curr = q.poll();
			int r = curr.r;
			int c = curr.c;
			int dist = curr.dist;
			ans = Math.max(ans, dist);
			
			for (int d = 0; d < 8; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;
				if(map[nr][nc] == 1)
					return;
				if(visited[nr][nc])
					continue;
				
				q.offer(new Safe(nr, nc, dist+1));
				visited[nr][nc] = true;
			}
		}
	}

}
