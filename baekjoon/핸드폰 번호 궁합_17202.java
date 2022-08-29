package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 통과 120ms
public class Main_17202 {

	static String a, b, res;
	static int[] temp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		a = br.readLine();
		b = br.readLine();

		temp = new int[16];
		int j = -1;
		for (int i = 0; i < 8; i++) {
			temp[++j] = a.charAt(i) - '0';
			temp[++j] = b.charAt(i) - '0';

		}

		int n = 16;
		while (n > 2) {
			temp = addNumber(temp, n);
			n--;
		}

		for (int i = 0; i < 2; i++) {
			System.out.print(temp[i]);
		}

	}

	static int[] addNumber(int[] t, int n) {
		for (int i = 0; i < n - 1; i++) {
			t[i] = (temp[i] + temp[i + 1]) % 10;
		}
		return t;
	}

}
