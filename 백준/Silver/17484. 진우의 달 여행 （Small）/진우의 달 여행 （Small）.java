import java.io.*;
import java.util.*;

public class Main {

	static int N, M, map[][], ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		ans = 987654321;
		for(int i = 0; i < M; i++) {
			dfs(0, i, -1, map[0][i]);
		}
		
		System.out.println(ans);
	}
	
	static int dc[] = {-1, 0, 1};
	private static void dfs(int r, int c, int dir, int puel) {
		if(r == N - 1) { // 가장 끝 행 도착
			ans = Math.min(ans, puel);
			return;
		}
		
		for(int d = 0; d < 3; d++) {
			if(d != dir) { // 같은 방향이 아니고
				int nr = r + 1;
				int nc = c + dc[d];
				if(nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;
				
				dfs(nr, nc, d, puel + map[nr][nc]);
			}
		}
	}

}
