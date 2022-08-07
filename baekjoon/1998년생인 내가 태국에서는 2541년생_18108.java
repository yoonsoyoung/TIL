package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 통과 변수 140ms, 바로 출력 136ms
public class boj_18108_Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		int y = Integer.parseInt(br.readLine()); // 불기 연도
		
		System.out.println(Integer.parseInt(br.readLine())-543);

	}

}
