import java.io.*;
import java.util.StringTokenizer;

// 통과 140ms
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		int[] chess = { 1, 1, 2, 2, 2, 8 }; // 킹, 퀸, 룩, 비숍, 나이트, 폰

		for (int i = 0; i < 6; i++) {
			int n = Integer.parseInt(st.nextToken());
			sb.append((chess[i] - n) + " ");
		}

		System.out.println(sb.toString());

	}

}
