package D1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 통과 98ms
public class Solution_1936 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		// 1: 가위, 2: 바위, 3: 보

		// A가 이기는 경우
		if ((a == 1 && b == 3) || (a == 2 && b == 1) || (a == 3 && b == 2)) {
			System.out.println("A");
		} else { // B가 이기는 경우
			System.out.println("B");
		}
	}

}
