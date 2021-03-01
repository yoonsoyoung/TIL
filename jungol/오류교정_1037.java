package com.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 오류교정_1037 {

	static int N, rowSum, colSum, chkR, chkC, corruptCnt;
	static int[][] arr;
	static boolean chk;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];

		colSum = 0;

		for (int i = 0; i < N; i++) { // 배열 입력
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 배열 돌면서 검사
		// 각 행이 모두 짝수합 & 각 열이 모두 짝수 합 => OK
		// 각 행 중 하나 홀수합(j) & 각 열 중 하나 홀수 합(i) => 그 자리(i,j) Change bit
		// 각 행과 열은 1부터 시작한다 했으므로 i,j 출력 시 +1 씩 해줘야함
		// 각 열의 합이 두 개 이상 홀수 합 => Corrupt

		corruptCnt = 0; // 바꿔야 할 좌표 개수가 2개 이상이면 그냥 Corrupt
		// 각 행의 합 검사
		for (int i = 0; i < N; i++) {
			rowSum = 0;
			for (int j = 0; j < N; j++) {
				rowSum += arr[i][j]; // i행의 모든 1 누적합
			}
			if (rowSum % 2 != 0) { // 행이 짝수 합이 아니면
				chkR = i; // 그 행 좌표 기억
				corruptCnt++; // 바꿔야 할 좌표 개수 증가
				chk = true; // 문제가 있음
			} else if(corruptCnt>1 && chk) { // 이미 바꿀 좌표가 2개 이상이고 문제가 있다면
				corruptCnt++;
				break;
			}
		}
		
		// 각 열의 합 검사
		if(corruptCnt>1) {
			
		} else {
			corruptCnt = 0; // 열에서의 바꿔야 할 좌표 개수 위한 초기화
			chk = false; // 열에서의 문제 여부를 위한 초기화
			for (int i = 0; i < N; i++) {
				colSum = 0;
				for (int j = 0; j < N; j++) {
					colSum += arr[j][i]; // 각 행의 열 값 누적합
				}
				if (colSum % 2 != 0) { // 열이 짝수 합이 아니면
					chkC = i; // 그 좌표 기억
					corruptCnt++; // 바꿔야 할 좌표 개수 증가
					chk = true; // 문제가 있음
				} else if(corruptCnt>1 && chk) { // 이미 바꿀 좌표가 2개 이상이고 문제가 있다면
					corruptCnt++;
					break;
				}
			}	
		}
		
		if(corruptCnt == 0) // 바꿀 좌표가 없다
			System.out.println("OK");
		else if (corruptCnt == 1) // 하나 바꿈
			System.out.println("Change bit (" + (chkR+1) + "," + (chkC+1) + ")");
		else
			System.out.println("Corrupt");
	}

}
