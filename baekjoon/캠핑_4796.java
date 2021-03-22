package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 통과 216ms
public class 캠핑_4796 {

	static int L, P, V, ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		ans = 0;
		int cnt = 1;
		while(true) {
			st = new StringTokenizer(br.readLine(), " ");
			L = Integer.parseInt(st.nextToken()); // 사용 가능한 일 수
			P = Integer.parseInt(st.nextToken()); // 연속하는 일
			V = Integer.parseInt(st.nextToken()); // 휴가 일 수
			if(L==0 && P==0 && V==0)
				break;
			
			if(V/P == 0)
				ans = L*(V/P);
			else {
				if(V%P <= L)
					ans = L*(V/P) + (V%P);
				else
					ans = L*(V/P) + L;
			}
			
			System.out.println("Case " + cnt++ + ": " + ans);
		}
		
	}
}