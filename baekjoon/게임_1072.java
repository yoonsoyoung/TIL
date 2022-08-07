package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 통과 4600ms, 
public class boj_1072_Main {

	static double x, y;
	static long z;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		x = Integer.parseInt(st.nextToken()); // 게임 횟수
		y = Integer.parseInt(st.nextToken()); // 이긴 게임
		z = (long) (100 * y / x);

		int cnt = 0;
		long new_z = 0;

		if (z >= 99) {
			System.out.println("-1");
			System.exit(0);
		}

		// 방법 1. 무작정 한 판씩 해보며 판단
//		while (z >= new_z) {
//			x = x + 1;
//			y = y + 1;
//			new_z = (long)(100*y/x);
//			cnt++;
//		}
		
		// 방법 2. 100 * (y + n) / (x + n) = z + 1이 되는 n 구하기

		System.out.println(cnt);
	}


}
