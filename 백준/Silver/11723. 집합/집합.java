import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		Integer[] initArr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
		int M = Integer.parseInt(br.readLine()); // 연산 수
		HashSet<Integer> s = new HashSet<>();
		for (int t = 0; t < M; t++) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			if ("add".equals(cmd)) {
				int x = Integer.parseInt(st.nextToken());
				s.add(x);
			} else if ("remove".equals(cmd)) {
				int x = Integer.parseInt(st.nextToken());
				s.remove(x);
			} else if ("check".equals(cmd)) {
				int x = Integer.parseInt(st.nextToken());
				int check = s.contains(x) ? 1 : 0;
				sb.append(check + "\n");
			} else if ("toggle".equals(cmd)) {
				int x = Integer.parseInt(st.nextToken());
				if (s.contains(x)) {
					s.remove(x);
				} else {
					s.add(x);
				}
			} else if ("all".equals(cmd)) {
				s = new HashSet<>(Arrays.asList(initArr));
			} else if ("empty".equals(cmd)) {
				s.clear();
			}
		}
		System.out.println(sb.toString());
	}

}
