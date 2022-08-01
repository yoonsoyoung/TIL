package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 통과 404ms
public class Main_2442 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		int last = T;
		for (int i = 1; i <= T; i++) {
			for (int j = 0; j < last; j++) {
				if (j < T - i) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
			last++;
		}
	}
}
