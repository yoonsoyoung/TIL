package com.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//통과 461ms
public class 종교_1863 {

	static int n, m;
	static int parents[];
	
	static void make() {
		for (int i = 1; i <= n; i++) {
			parents[i] = i;
		}
	}
	
	static int find(int a) {
		if(parents[a] == a) 
			return a;
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot)
			return false;
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken()); // 학생 수 0< n <= 50,000
		m = Integer.parseInt(st.nextToken()); // 쌍의 수 0<= m <= 100,000
		
		parents = new int[n+1];
		
		make();
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
		}
		
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			if(i == parents[i])
				ans++;
		}
		
		System.out.println(ans);
	}

}
