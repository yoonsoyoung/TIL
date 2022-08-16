package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 방법1. 통과 124ms, 방법2. 통과 124ms
public class Main_2920 {

	static int[] asc = { 1, 2, 3, 4, 5, 6, 7, 8 };
	static int[] desc = { 8, 7, 6, 5, 4, 3, 2, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int input[] = new int[8];
		for (int i = 0; i < 8; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		// 방법1. Arrays.equals 로 배열 내용이 같은지 비교
		if (Arrays.equals(input, asc)) {
			System.out.println("ascending");
		} else if (Arrays.equals(input, desc)) {
			System.out.println("descending");
		} else {
			System.out.println("mixed");
		}
		
		
		/*
		final String DESC = "descending";
		final String ASC = "ascending";
		String ans = "mixed";
		for (int i = 0; i < 8; i++) {
			input[i] = Integer.parseInt(st.nextToken());
			// 방법2.
			if (i > 0) {
				if (input[i] == input[i - 1] + 1) { // asc 
					if(DESC.equals(ans)) {
						ans = "mixed";
						break;
					} else {
						ans = ASC;
					}
				} else if (input[i] == input[i - 1] - 1) { // desc
					if(ASC.equals(ans)) {
						ans = "mixed";
						break;
					} else {
						ans = DESC;
					}
				} else {
					ans = "mixed";
					break;
				}
			}
		}

		// 방법2. 입력을 받으면서 확인
		System.out.println(ans);
		*/
	}

}
