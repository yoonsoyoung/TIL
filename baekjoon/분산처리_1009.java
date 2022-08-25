package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1009 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()); // 밑
			int b = Integer.parseInt(st.nextToken()); // 지수승

			long res = pow(a, b, 10);
			if(res == 0) {
				System.out.println(10);
			} else {
				System.out.println(res);
			}
		}
	}

	private static long pow(int a, int b, int p) {
		if (b == 0) {
			return 1L;
		}

		long m = pow(a, b / 2, p); // 지수 반으로 나눔
		long temp = m * m % p; // 밑 제곱

		if (b % 2 == 0) {
			return temp;
		} else {
			return a * temp % p;
		}
	}

}
