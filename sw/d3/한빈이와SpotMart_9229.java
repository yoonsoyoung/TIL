package com.sw.d3;

import java.util.Scanner;
/*
4
3 45
20 20 20
6 10
1 2 5 8 9 11
4 100
80 80 60 60
4 20
10 5 10 16

 */
public class 한빈이와SpotMart_9229 {
	
	static int T, N, M, ans;
	static int[] a ;
	static boolean[] isSelect;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); //과자 개수
			M = sc.nextInt(); //두 봉지 무개 최대값
			a = new int[N];
			isSelect = new boolean[N];
			ans = 0;
			for (int i = 0; i < N; i++) {
				a[i] = sc.nextInt();
			}
			combi(0, 0, 0); //인덱스, 시작점, 누적무게
			if(ans == 0) ans = -1;
			System.out.println("#" + tc + " " + ans);
			
			
		}
	}
	
	static void combi(int cnt, int start, int sum) {
		if(cnt == 2) { //정확히 두 봉지
			if(sum<=M) { //무게 최대값 이하면
				ans = Math.max(ans, sum);
				return;
			}
		}
		if(sum>M) return; //무게 넘어가면 끝냄.
		
		
		for (int i = start; i < N; i++) {
			//dfs 끝까지 검색
			if(isSelect[i]) continue;
			isSelect[i] = true;
			combi(cnt+1, i+1, sum + a[i]);
			isSelect[i] = false;
		}
	}
	/*
	static void subset(int cnt) {
		//기저
		if(cnt == 2) { // 정확히 두 봉지만
			int sum = 0;
			int selectCnt = 0; 
			for (int i = 0; i < 2; i++) {
				if(isSelect[i]) {
					sum+= a[i];
					selectCnt++;
				}
			}
			
			if(sum<=M && selectCnt>0) { //무게 최대값 이하 && 공집합 제외
				System.out.println(sum);
			} else //갈 방법이 없는 경우
				System.out.println("-1");
		}
		//유도
		isSelect[cnt] = true;
		subset(cnt+1);
		isSelect[cnt] = false;
		subset(cnt+1);
	}
	*/
	

}
