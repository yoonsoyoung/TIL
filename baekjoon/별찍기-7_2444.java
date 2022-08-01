package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 통과 Sys.out 464ms / StringBuilder 140ms
public class Main_2444 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		int last = T;
		for (int i = 1; i < T; i++) {
			for (int j = 0; j < last; j++) {
				if (j < T - i) {
					sb.append(" ");
				} else {
					sb.append("*");
				}
			}
			sb.append("\n");
			last++;
		}
		last = T * 2 - 1;
		for (int i = 0; i < T; i++) {
			for (int j = 0; j < last; j++) {
				if (i > 0 && j < i) {
					sb.append(" ");
				} else {
					sb.append("*");
				}
			}
			sb.append("\n");
			last--;
		}
		
		System.out.println(sb);
	}
}
