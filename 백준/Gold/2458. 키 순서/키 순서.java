import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {

	static int T, N, M, ans;
	static boolean[][] adjM;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken()); // 학생 수
		M = Integer.parseInt(st.nextToken()); // 키 비교 횟수
		adjM = new boolean[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()); // 작음 a<b, a -> b
			int b = Integer.parseInt(st.nextToken()); // 큼
			adjM[a][b] = true;
		}

		// Floyd
		// 경 - 출 - 도
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (adjM[i][k] && adjM[k][j])
						adjM[i][j] = true;
				}
			}
		}

		ans = 0;
		for (int i = 1; i <= N; i++) {
			int cnt = 0;
			for (int j = 1; j <= N; j++) {
				if (i == j)
					continue;
				if (!adjM[i][j] && !adjM[j][i]) // 서로 연결되지 않음
					cnt++;
			}
			if (cnt == 0) // 모두 연결 됨
				ans++;
		}

		System.out.println(ans);
	}

}
