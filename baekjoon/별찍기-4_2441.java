package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 통과 280ms
public class Main_2441 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			for (int j = T; j > 0; j--) {
				if (j > T-i) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		

	}

}
