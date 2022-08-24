package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 통과 140ms
public class Main_2588 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n1 = Integer.parseInt(br.readLine());
		int n2 = Integer.parseInt(br.readLine());
		int b[] = new int[3];

		b[0] = n2 / 100;
		b[1] = (n2 / 10) % 10;
		b[2] = n2 % 10;

		sb.append(n1 * b[2] + "\n").append(n1 * b[1] + "\n").append(n1 * b[0] + "\n").append(n1 * n2);
		System.out.println(sb);
	}

}
