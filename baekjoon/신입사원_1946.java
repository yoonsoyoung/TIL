package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 통과 3208ms
public class 신입사원_1946 {
	
	static int T, N, ans;
	static int[][] workers;
	public static void main(String[] args) throws NumberFormatException, IOException {

		// 성적과 면접시험 성적 둘 다 떨어진 경우 선발x
		// 회의실 배정과 비슷한 정렬을 이용해 풀어보자
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine()); // 테케수
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine()); // 지원자 수
			workers = new int[N][2]; // [0]열: 서류성적 순위, [1]열: 면접성적 순위
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				workers[i][0] = Integer.parseInt(st.nextToken());
				workers[i][1] = Integer.parseInt(st.nextToken());
			}
			
			// 서류성적 기준 오름차순 정렬
			Arrays.sort(workers, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0]-o2[0];
				}
			});

			// 서류성적이 정렬되었으니 이때의 면접점수가 그 전꺼(합격)보다 높은 등급이어야함
			// 서류성적1순위는 일단 뽑고 시작
			int lank = workers[0][1];
			ans = 1;
			
			// 그리고 그 다음 애의 면접점수와 비교하여 비교대상 갱신
			for (int i = 1; i < N; i++) {
				if(lank > workers[i][1]) { // lank 보다 작아야 높은 순위!
					lank = workers[i][1];
					ans++;
				}
			}
			
			
			System.out.println(ans);
		}
	}

}
