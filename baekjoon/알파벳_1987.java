package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 통과 864ms
public class boj_1987_Main {

	static int R, C, ans;
	static boolean[] alphabet;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken()); // 행
		C = Integer.parseInt(st.nextToken()); // 열

		map = new int[R][C];
		alphabet = new boolean[26];

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j) - 'A';
			}
		}

		ans = 0;
		dfs(0,0,1);
		System.out.println(ans);

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	private static void dfs(int r, int c, int cnt) {
		alphabet[map[r][c]] = true; // 현재 칸 알파벳 방문 체크 
		ans = Math.max(ans, cnt);
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			// 범위
			if(nr < 0 || nc < 0 || nr >= R || nc >= C)
				continue;
			
			// 직전에 알파벳 나온 곳
			if(alphabet[map[nr][nc]])
				continue;
			
			dfs(nr, nc, cnt+1);
			
		}
		// 백트래킹을 위한 초기화
		cnt -= 1;
		alphabet[map[r][c]] = false;
	}

}
