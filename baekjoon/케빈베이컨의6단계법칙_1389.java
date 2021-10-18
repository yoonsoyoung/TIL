package 플로이드와샬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 통과 124ms
public class boj_1389_Main {

	static int N, M, ans, adjM[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken()); // 유저 수
		M = Integer.parseInt(st.nextToken()); // 관계 수
		adjM = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if( i!=j && adjM[i][j] == 0)
					adjM[i][j] = 987654321;
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			adjM[a][b] = 1;
			adjM[b][a] = 1;
			// a와 b가 친구면 b와 a도 친구다
		}
		
		// Floyd Wharshall 경-출-도
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				if( i == k ) continue;
				for (int j = 0; j < N; j++) {
					if( i == j || k == j) continue;
					if(adjM[i][j] > adjM[i][k] + adjM[k][j]) // 경유지 들리는 게 기존 경로보다 적은 비용
						adjM[i][j] = adjM[i][k] + adjM[k][j]; // 갱신
				}
			}
		}
		
		// 최소값 찾기
		int ans = Integer.MAX_VALUE;
		int n = 0; // 최소 일 때 사람
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < N; j++) {
				sum += adjM[i][j];
			}
			if( ans > sum) { // 더 최소
				ans = sum; // 갱신
				n = i+1; // 1번부터 부여되므로 현재 인덱스에 1 더함
			}
		}
		
		System.out.println(n);

	}

}
