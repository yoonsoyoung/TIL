package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 통과 1208ms - sysout,  528ms - stringbuilder
public class Main_1620 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken()); // 포켓몬 수
		int M = Integer.parseInt(st.nextToken()); // 문제 수
		Map<Integer, String> dogam_number = new HashMap(); // 번호로 찾
		Map<String, Integer> dogam_name = new HashMap(); // 이름으로 찾
		
		// 포켓몬 입력
		for (int i = 1; i <= N; i++) {
			String name = br.readLine();
			dogam_number.put(i, name);
			dogam_name.put(name, i);
		}
		
		// 문제 맞추기
		for (int i = 0; i < M; i++) {
			String question = br.readLine();
			if(question.charAt(0) > 48 && question.charAt(0) <= 57) {
				// 입력값 첫 글자가 1~9(ASCII) 사이 = 숫자
				sb.append(dogam_number.get(Integer.parseInt(question))).append("\n");
			} else {
				// 입력값이 문자열
				sb.append(dogam_name.get(question)).append("\n");
			}
		}
		
		System.out.println(sb.toString());
		
	}
}
