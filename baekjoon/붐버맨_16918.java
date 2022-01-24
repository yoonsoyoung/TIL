package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 통과 304ms
public class boj_16918_Main {

	static int R, C, N, time[][];
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken()); // 행
		C = Integer.parseInt(st.nextToken()); // 열
		N = Integer.parseInt(st.nextToken()); // 초

		map = new char[R][C]; // 폭탄 상황 관리
		time = new int[R][C]; // 폭탄이 터질 시간 관리

		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'O')
					time[i][j] = 3; // 폭탄이 터지는 시간은 현재로부터 + 3
			}
		}

		for (int t = 1; t <= N; t++) {
			// 초기상태, 1초는 아무것도 하지 않음
			if (t == 1)
				continue;

			if (t % 2 == 0) {
				// 설치되어 있지 않은 곳에 폭탄 설치
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						if (map[i][j] == '.') {
							map[i][j] = 'O';
							time[i][j] = t + 3; // 해당 칸의 폭탄이 터질 시간 갱신
						}
					}
				}
			} else {
				// 시간이 된 폭탄들은 모두 폭발
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						if (time[i][j] == t)
							boom(i, j, t);
					}
				}
			}
		}

		// 출력
		for (int i = 0; i < R; i++) {
			System.out.println(map[i]);
		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void boom(int r, int c, int t) {
		map[r][c] = '.';
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr < 0 || nc < 0 || nr >= R || nc >= C)
				continue;
			if (time[nr][nc] == t) // 터트려질 곳이므로 주변 연쇄 막음
				continue;
			map[nr][nc] = '.';
			time[nr][nc] = 0;

		}
	}

}
