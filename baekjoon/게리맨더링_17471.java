package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 통과 140ms
public class 게리맨더링T_17471 {

	static int N, population[];
	static boolean[][] adjM;
	static boolean[] isSelected, visited;
	static boolean[] gu;
	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 선거구 수

		population = new int[N + 1]; // 1~N까지 인덱스가 각 선거구로 해당 선거구의 인구수 담을 배열
		adjM = new boolean[N + 1][N + 1]; // 1~N까지의 선거구가 서로 인접한 지 담을 배열
		isSelected = new boolean[N + 1]; // powerSet에서 쓸 선택 배열. true는 A선거구, false는 B선거구

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}

		// 선거구 별 인접정보
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int adjNum = Integer.parseInt(st.nextToken()); // 인접한 구의 수
			for (int j = 0; j < adjNum; j++) {
				int from = Integer.parseInt(st.nextToken());
				adjM[i][from] = adjM[from][i] = true;
			}
		}

		min = 987654321;
		PowerSet(1);

		System.out.println(min == 987654321 ? -1 : min);
	}

	private static void PowerSet(int cnt) {
		if (cnt == N + 1) {
			if (check()) {
				// isSelected 에 따라 T : A, F : B 로 각각 유권자의 수의 합을 계산.
				int sumA = 0, sumB = 0;
				for (int i = 1; i <= N; i++) {
					if (isSelected[i])
						sumA += population[i];
					else
						sumB += population[i];
				}

				min = Math.min(min, Math.abs(sumA - sumB));
			}
			return;
		}

		isSelected[cnt] = true;
		PowerSet(cnt + 1);
		isSelected[cnt] = false;
		PowerSet(cnt + 1);
	}

	// 전부 연결이 되었는지 체크하는 함수
	private static boolean check() {
		int red = 0;
		int blue = 0;
		for (int i = 1; i <= N; i++) {
			if (isSelected[i]) { // 선택된 true 곳 중
				red = i;
			} else {
				blue = i;
			}
		}

		// 선거 구 중 구역이 없는 경우
		if (red == 0 || blue == 0)
			return false;

		visited = new boolean[N + 1]; // DFS에서 쓸 선택 배열
		dfs(red, true);
		dfs(blue, false);

		// 모든 선거구 방문되었다면
		for (int i = 1; i <= N; i++) {
			if (!visited[i])
				return false;
		}
		return true;
	}

	private static void dfs(int idx, boolean gu) {
		visited[idx] = true; // 방문체크

		// 방문한 적 없고, 연결 돼 있고, 같은 선거구
		for (int i = 1; i <= N; i++) {
			if (!visited[i] && adjM[idx][i] && isSelected[i] == gu) {
				dfs(i, gu);
			}
		}
	}

}
