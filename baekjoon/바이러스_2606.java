package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 통과 132ms
public class 바이러스_2606 {

	static int V, E, ans;

	static class Node {
		int v; // 정점 번호
		Node next;

		public Node(int v, Node next) {
			super();
			this.v = v;
			this.next = next;
		}
	}

	static Node[] adjList;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		V = Integer.parseInt(br.readLine()); // 컴퓨터 수 = 정점 수
		E = Integer.parseInt(br.readLine()); // 연결 된 컴퓨터 쌍

		adjList = new Node[V + 1];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from, adjList[to]);
		}

		visited = new boolean[V + 1];
		ans = 0;
		dfs(1); // 1번 컴퓨터로부터 바이러스가 퍼져나감
		
		System.out.println(ans);
	}

	private static void dfs(int curr) {
		visited[curr] = true; // 방문처리
		for (Node tmp = adjList[curr]; tmp != null; tmp = tmp.next) { // 인접 정점 따라
			if(!visited[tmp.v]) { // 방문하지 않은 곳이면
				ans++; // 카운팅
				dfs(tmp.v); // 걔를 또 타고타고...
			}
		}
	}

}
