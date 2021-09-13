package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 통과 184ms
public class boj_14888_Main {

	static int N, max, min;
	static int[] num, oper;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine()); // 수의 개수
		num = new int[N];
		oper = new int[4]; // 0: +, 1: -, 2: *, 3: /

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 4; i++) {
			oper[i] = Integer.parseInt(st.nextToken());
		}

		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		dfs(num[0], 1); // 첫 번째 수와 다음 인덱스를 보냄

		System.out.println(max + "\n" + min);

	}

	private static void dfs(int res, int idx) {
		// 기저
		if (idx == N) { // idx는 다음 인덱스를 가리키므로 N이면 N-1까지 연산자 사용 후 끝난 셈.
			max = Math.max(res, max);
			min = Math.min(res, min);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (oper[i] == 0)
				continue;
			oper[i]--; // 연산자 개수 차감
			switch (i) {
			case 0: // +
				dfs(res + num[idx], idx + 1); // 누적값에 다음 숫자를 계산하고, idx를 1증가 시켜 다음 숫자를 가리키게 함.
				break;
			case 1: // -
				dfs(res - num[idx], idx + 1);
				break;
			case 2: // *
				dfs(res * num[idx], idx + 1);
				break;
			case 3: // /(몫)
				dfs(res / num[idx], idx + 1);
				break;
			}

			oper[i]++; // 다시 복구
		}
	}

}
