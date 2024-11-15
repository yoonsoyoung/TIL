package com.baekjoon;

import java.io.*
import java.util.*;

// 통과 104ms
public class 삼각형과세변_5073 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Integer[] lenArr = new Integer[3]; 
			lenArr[0] = Integer.parseInt(st.nextToken());
			lenArr[1] = Integer.parseInt(st.nextToken());
			lenArr[2] = Integer.parseInt(st.nextToken());
			
			if(lenArr[0] == 0) {
				break;
			}
			
			Arrays.sort(lenArr, (a, b) -> b - a); // 내림차순 정렬
			
			if(lenArr[0] >= lenArr[1] + lenArr[2]) {
				sb.append("Invalid\n");
				continue;
			} 
			
			/* Integer와 같은 wrapper 타입의 값 비교는 equals 메서드 사용해야 함
			 *  -> -128 ~ 127 의 범위 내 값에서는 원시타입으로 변환되어 '==' 비교가 가능하지만 그 이상일 때는 잘못된 비교값을 내뱉음
			 */
			if(lenArr[0].equals(lenArr[1]) && lenArr[1].equals(lenArr[2])) {
				sb.append("Equilateral\n");
			} else if(lenArr[0].equals(lenArr[1]) || lenArr[0].equals(lenArr[2]) || lenArr[1].equals(lenArr[2])) {
				sb.append("Isosceles\n");
			} else {
				sb.append("Scalene\n");				
			}
						
		}
		
		System.out.println(sb.toString());
		
	}

}
