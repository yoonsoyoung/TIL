package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 통과 576ms
public class boj_15651_Main {
	static int N, M, res[];
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken()); // 1~N
		M = Integer.parseInt(st.nextToken()); // 뽑는 수
		res = new int[M+1];
		reperm(1); // 중복 순열
		System.out.println(sb);
		
	}
	private static void reperm(int idx) {
		if(idx-1 == M) {
			for(int i = 1; i <= M ; i++ ) {
				sb.append(res[i] + " ");
			}
			sb.append("\n");
			return;
		}

		
		for (int i = 1; i <= N; i++) {
			res[idx] = i;
			reperm(idx+1);
		}
	}
}
