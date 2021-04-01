package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 통과 452ms
// Kruskal
public class 집합의표현_1717 {

	static int n, m;
	static int[] parents;
	static Edge[] edgeList;
	
	static class Edge {
		int from, to;

		public Edge(int from, int to) {
			super();
			this.from = from;
			this.to = to;
		}
		
	}
	
	static void make() {
		for (int i = 0; i <= n; i++) {
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
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parents = new int[n+1];
		edgeList = new Edge[n];
		
		make();
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int op = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(op == 0) {
				union(a, b);
			} else {
				if(find(a) == find(b))
					sb.append("YES\n");
				else
					sb.append("NO\n");
			}
			
		}
		System.out.println(sb);
	}

}
