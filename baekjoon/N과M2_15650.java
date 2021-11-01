package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 통과 144ms
public class boj_15650_Main {

	static int N, M, res[];
	static boolean selected[];
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken()); // 1~N
		M = Integer.parseInt(st.nextToken()); // 뽑는 수
		res = new int[N+1];
		selected = new boolean[N+1];
		
		combi(1, 0);
		System.out.println(sb);
		
	}
	private static void combi(int idx, int cnt) {
		if(cnt == M) {
			for (int i = 1; i <= N; i++) {
				if(selected[i]) {
					sb.append(i + " ");
				}
			}
			sb.append("\n");
		}
		
		for (int i = idx; i <= N; i++) {
			if(selected[i]) continue;
			selected[i] = true;
			combi(i+1, cnt+1);
			selected[i] = false;
		}
	}
	

}
