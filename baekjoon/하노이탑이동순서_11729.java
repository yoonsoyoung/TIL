package 재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 통과 468ms
public class boj_11729_Main {
	static int ans;
	static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int k = Integer.parseInt(br.readLine());
		
		ans = 0;
		Hanoi('1', '2', '3', k); // 시작 원판, 중간, 최종 원판, 원판 수
		System.out.println(ans);
		System.out.println(sb);
	}
	private static void Hanoi(char a, char b, char c, int n) {
		if(n==1) { // 마지막 원반
			++ans;
			sb.append(a + " " + c + "\n");
		} else {
			Hanoi(a, c, b, n-1);
			++ans;
			sb.append(a + " " + c + "\n");
			Hanoi(b, a, c, n-1);
		}
	}
}
