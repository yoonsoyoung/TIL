import java.io.*;
import java.util.*;

public class Main {

	static int N, K, adjM[][], ans;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); // 행성 수
		K = Integer.parseInt(st.nextToken()); // 시작 행성 번호
		adjM = new int[N][N];
		visited = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				adjM[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int k = 0; k < N; k++) { // 경
			for(int i = 0; i < N; i++) { // 출
				for(int j = 0; j < N; j++) { // 도
					adjM[i][j] = Math.min(adjM[i][k] + adjM[k][j], adjM[i][j]);
				}
			}
		}
		
		ans = 987654321;
		visited[K] = true;
		dfs(1, 0, K);
		System.out.println(ans);
	}
	
	private static void dfs(int cnt, int time, int curr) {
		if(cnt == N) {
			ans = Math.min(ans, time);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(cnt+1, time + adjM[curr][i], i);
				visited[i] = false;
			}
		}
	}

}