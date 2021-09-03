package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 통과 404ms
public class boj_1520_Main {

	static int M, N, ans;
	static int[][] map;
	static int[][] memo;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		M = Integer.parseInt(st.nextToken()); // 행
		N = Integer.parseInt(st.nextToken()); // 열

		map = new int[M][N];
		memo = new int[M][N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				memo[i][j] = -1;
			}
		}
		System.out.println(dfs(0, 0));

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	private static int dfs(int r, int c) {
		if (r == M - 1 && c == N - 1) // 끝점
			return 1;

		if (memo[r][c] == -1) { // 해당 경로를 방문한 적이 없으면
			memo[r][c] = 0; // 처음 방문 표시
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (nr < 0 || nc < 0 || nr >= M || nc >= N)
					continue;
				if (map[nr][nc] < map[r][c])
					memo[r][c] += dfs(nr, nc); // 경로에 값 누적
			}
		}
		return memo[r][c];
	}
	// dfs(0,0) 맨 처음에 재귀로 경로를 쭉 타고(0을 남기며 방문) 들어가 끝점을 만나면서 1을 채우면서 역으로 돌아옴
	// 그 다음 경로에 또 0을 남기며 방문하고 이전 누적합을 채우면서 돌아오고...
	// 모든 재귀를 복귀하면 마지막 누적합이 리턴
}
