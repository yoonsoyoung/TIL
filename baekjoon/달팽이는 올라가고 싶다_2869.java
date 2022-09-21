package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 통과 124ms
public class Main_2869 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int a = Integer.parseInt(st.nextToken()); // 낮에 올라가는 높이
		int b = Integer.parseInt(st.nextToken()); // 밤에 미끄러지는 높이
		int v = Integer.parseInt(st.nextToken()); // 나무막대 높이

		if ((v - b) % (a - b) == 0) {
			System.out.println((v - b) / (a - b));
		} else {
			System.out.println((v - b) / (a - b) + 1);
		}

	}

}
