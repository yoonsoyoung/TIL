package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 통과 124ms
public class Main_16173 {

	static int N, map[][];
	static boolean[][] visited;
	static Queue<Jelly> q;
	static String ans;
	static class Jelly {
		int r, c;

		public Jelly(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		q = new LinkedList<Jelly>();
		ans = "Hing";
		bfs(0, 0);
		
		System.out.println(ans);

	}

	static int[] dr = { 1, 0 };
	static int[] dc = { 0, 1 };

	private static void bfs(int r, int c) {
		q.add(new Jelly(r, c));
		visited[r][c] = true;

		while (!q.isEmpty()) {
			Jelly nj = q.poll();

			for (int i = 0; i < 2; i++) {
				int nr = nj.r + dr[i] * map[r][c];
				int nc = nj.c + dc[i] * map[r][c];

				if (nr < 0 || nc < 0 || nr >= N || nc >= N)
					continue;
				if (visited[nr][nc])
					continue;
				if (nr == N - 1 && nc == N - 1)
					ans = "HaruHaru";
				
				bfs(nr, nc);
			}

		}
	}

}
