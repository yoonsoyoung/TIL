package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 통과 
public class boj_1942 {

	static int[] month_day = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }; // 1~12월의 끝 일자
	static String[] str_day = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"}; // 요일명, 1월 1일은 MON

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int m = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		for (int i = 1; i < m; i++) { // m 월까지의
			d += month_day[i]; // 일자
		}
		
		System.out.println(str_day[d%7]);
		
	}

}
