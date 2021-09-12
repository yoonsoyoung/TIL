import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 통과 360ms
public class 스타트와링크_14889 {

	static int N, ans;
	static int[][] map;
	static boolean[] team; // t: 스타트팀, f: 링크팀

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine()); // 직원 수
		map = new int[N][N];
		team = new boolean[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		ans = Integer.MAX_VALUE; // 최솟값을 구해야 하기 때문에 초기 가장 큰 값을 가지고 비교 
		combi(0, 0);
		System.out.println(ans);
	}

	// 스타트팀에 들어가는 경우, 링크팀에 들어가는 경우에서 각 재귀를 돌림
	private static void combi(int idx, int cnt) {
		// 기저
		if (cnt == N / 2) { // 팀 조합 완료
			int start = 0;
			int link = 0;

			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					if (team[i] && team[j]) { // 스타트팀
						start += (map[i][j] + map[j][i]); // Sij + Sji 값을 스타트 팀에 누적합
					} else if (!team[i] && !team[j]) { // 링크팀
						link += (map[i][j] + map[j][i]); // Sij + Sji 값을 링크 팀에 누적합
					}
				}
			}

			// 두 팀간 차이
			int diff = Math.abs(start - link);
			if (diff == 0) { // 0 일 때 가장 최소
				System.out.println(diff);
				System.exit(0); // 다른 거 안 보고 끝내버림
			}

			ans = Math.min(ans, diff);
			return;
		}

		for (int i = idx; i < N; i++) {
			if (team[i])
				continue;
			team[i] = true; // i번째 사람을 스타트팀으로 넣어봄
			combi(i + 1, cnt + 1); // 재귀
			team[i] = false; // 링크팀으로 넣어봄
		}
	}

}
