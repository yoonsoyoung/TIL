package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 통과 
public class boj_15649_Main {

	static int N, M, res[];
	static boolean selected[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken()); // 1~N 까지 자연수
		M = Integer.parseInt(st.nextToken()); // nCm
		res = new int[N + 1]; // 1부터 사용
		selected = new boolean[N + 1]; // 1부터 사용

		// 중복 순열
		perm(0);

	}

	private static void perm(int idx) {
		if (idx == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 1; i <= N; i++) {
			if(selected[i]) continue;
			selected[i] = true;
			res[idx] = i;
			perm(idx+1);
			selected[i] = false;
			
		}

	}

}
