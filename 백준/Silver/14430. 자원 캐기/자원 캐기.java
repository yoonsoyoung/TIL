import java.io.*;
import java.util.*;

public class Main {

	static int N, M, map[][], dp[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dp = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = map[0][0];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				// 왼쪽에서 도달(왼쪽에 값이 있음)
				if(j - 1 >= 0) {
					dp[i][j] = dp[i][j] < dp[i][j-1] + map[i][j] ? dp[i][j-1] + map[i][j] : dp[i][j]; 
				}
				
				// 윗쪽에서 도달(윗쪽에 값이 있음)
				if(i - 1 >= 0) {
					dp[i][j] = dp[i][j] < dp[i-1][j] + map[i][j] ? dp[i-1][j] + map[i][j] : dp[i][j];
				}
			}
		}
		System.out.println(dp[N-1][M-1]);

	}

}