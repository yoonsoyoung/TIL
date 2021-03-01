package com.baekjoon;

import java.util.Scanner;

public class 영식이와친구들_1592 {

	static int N, M, L, ans, ballCnt;
	static int[] man;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 자리 수
		M = sc.nextInt(); // 공을 받은 최대 횟수
		L = sc.nextInt(); // M번보다 적게 받은 사람으로부터 L 번째 있는 사람
		ans = 0;
		man = new int[N+1]; //인덱스를 1번~N번 자리로 하기 위함
		ballCnt = 1;
		man[1] = 1; //1번 사람이 받고 시작
		while(true) {
			// 던져서 받았는데
			if(man[ballCnt] % 2 == 1) { // 홀수번
				ballCnt += L; // 시계 방향으로 L 번째 -> 오른쪽으로
				if(ballCnt > N) 
					ballCnt %= N; // 더 넘어간 <- 나머지
			} else { // 짝수번
				ballCnt -= L; // 반시계 방향 -> 왼쪽으로
				 if(ballCnt < 1) // 1번 자리가 최소
					 ballCnt += N;  
			}
			
			man[ballCnt]++; //받고
			ans++; //던짐
			if(man[ballCnt] == M) // 받은 게 M번 받으면 끝
				break;
		}
		
		System.out.println(ans);

	}

}
