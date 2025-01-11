import java.io.*;
import java.util.*;

public class Main {

	static int[][] map;
	static int N, M;

	static class Node {
		int r, c, cnt;

		public Node(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		bfs(0, 0);

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	private static void bfs(int i, int j) {
		Queue<Node> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		q.add(new Node(i, j, 1));
		visited[i][j] = true;
		
		while (!q.isEmpty()) {
			Node curr = q.poll();
			
			if(curr.r == N-1 && curr.c == M-1) {
				System.out.println(curr.cnt);
				return;
			}
			
			for (int d = 0; d < 4; d++) {
				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];
				int cnt = curr.cnt;

				if (nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;
				if (map[nr][nc] == 0)
					continue;
				if (visited[nr][nc])
					continue;

				q.add(new Node(nr, nc, cnt+1));
				visited[nr][nc] = true;
			}
		}
	}

}
