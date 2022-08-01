package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 통과 304ms
public class Main_2443 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		int last = T * 2 - 1;
		for (int i = 0; i < T; i++) {
			for (int j = 0; j < last; j++) {
				if (i > 0 && j < i) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
			last--;
		}
	}
}
