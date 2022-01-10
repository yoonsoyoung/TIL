package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 통과 128ms
public class boj_2644_Main {

	static int n, m, a, b, ans, visited[];
	static boolean adjM[][];
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		n = Integer.parseInt(br.readLine()); // 전체 사람 수 = 정점

		st = new StringTokenizer(br.readLine(), " ");
		a = Integer.parseInt(st.nextToken()); // 촌수 계산 사람 번호 1
		b = Integer.parseInt(st.nextToken()); // 촌수 계산 사람 번호 2

		m = Integer.parseInt(br.readLine()); // 관계 개수 = 간선

		adjM = new boolean[n+1][n+1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjM[from][to] = adjM[to][from] = true;
		}
		
		visited = new int[n+1];
		ans = 0;
		bfs(a);
		
		if(visited[b] != 0)
			System.out.println(visited[b]-1);
		else
			System.out.println(-1);
	}

	private static void bfs(int curr) {
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(curr);
		visited[curr] = 1;
		
		while (!q.isEmpty()) {
			int c = q.poll();
			for (int i = 1; i <= n; i++) {
				if(adjM[c][i] && visited[i] == 0) {
					q.offer(i);
					visited[i] = visited[c]+1;
				}
			}
			
		}
	}
}
