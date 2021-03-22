package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ��� 216ms
public class ķ��_4796 {

	static int L, P, V, ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		ans = 0;
		int cnt = 1;
		while(true) {
			st = new StringTokenizer(br.readLine(), " ");
			L = Integer.parseInt(st.nextToken()); // ��� ������ �� ��
			P = Integer.parseInt(st.nextToken()); // �����ϴ� ��
			V = Integer.parseInt(st.nextToken()); // �ް� �� ��
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