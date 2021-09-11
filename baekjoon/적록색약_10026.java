package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 통과 188ms
public class boj_10026_Main {

	static int N, cnt_rgb, cnt_rb;
	static char[][] map, mapRB;
	static boolean[][] visited_rgb; // 일반인
	static boolean[][] visited_rb; // 적록색약: 빨=초
	
	static class Node {
		int r, c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		mapRB = new char[N][N];
		visited_rgb = new boolean[N][N];
		visited_rb = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				mapRB[i][j] = str.charAt(j);
				map[i][j] = str.charAt(j);
				if(str.charAt(j) == 'G')
					mapRB[i][j] = 'R';
			}
		}

		cnt_rgb = bfs(map, visited_rgb);
		cnt_rb = bfs(mapRB, visited_rb);
		System.out.println(cnt_rgb + " " + cnt_rb);
	}

	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	private static int bfs(char m[][], boolean[][] visited) {
		int area = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(visited[i][j])
					continue;
				
				Queue<Node> q = new LinkedList<Node>();
				q.offer(new Node(i, j));
				visited[i][j] = true;
				area++;
				
				while(!q.isEmpty()) {
					Node curr = q.poll();
					int r = curr.r;
					int c = curr.c;
					
					for (int d = 0; d < 4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						
						if(nr < 0 || nc < 0 || nr >= N || nc >= N)
							continue;
						if(visited[nr][nc])
							continue;
						if(m[nr][nc] != m[r][c])
							continue;
						
						q.offer(new Node(nr, nc));
						visited[nr][nc] = true;
					}
				}
			}
		}
		
		return area;
	}



}
