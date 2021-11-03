package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 통과 124ms
public class boj_1759_Main {

	static int L, C;
	static char[] str;
	static boolean[] selected;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		L = Integer.parseInt(st.nextToken()); // 알파벳 개수
		C = Integer.parseInt(st.nextToken()); // 사용 개수
		str = new char[C];
		selected = new boolean[C];
		sb = new StringBuilder();

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < C; i++) {
			str[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(str);

		combi(0, 0, 0, 0);
		System.out.println(sb);
	}

	// con : 자음, vow : 모음
	private static void combi(int idx, int start, int con, int vow) {
		if (idx == L) {
			// 모음 없을 때 x
			if (vow == 0)
				return;
			// 자음이 2개 미만 x
			if (con < 2)
				return;
			// 그 외에 반복문 돌며 출력
			for (int i = 0; i < C; i++) {
				if (selected[i])
					sb.append(str[i]);
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i < C; i++) {
			selected[i] = true;
			char c = str[i];
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') // 모음
				combi(idx + 1, i + 1, con, vow + 1);
			else
				combi(idx + 1, i + 1, con + 1, vow);

			selected[i] = false;
		}
	}

}
