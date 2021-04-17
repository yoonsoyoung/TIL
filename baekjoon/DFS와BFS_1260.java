package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 통과 388ms
public class DFS와BFS_1260 {

	static int N, M, V;
	static ArrayList<Integer>[] adjList;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 정점 개수
		M = Integer.parseInt(st.nextToken()); // 간선 개수
		V = Integer.parseInt(st.nextToken()); // 시작 정점
		
		adjList = new ArrayList[N+1]; // 1부터 넣으므로 N+1
		for (int i = 1; i <= N; i++) { // N 포함 까지
			adjList[i] = new ArrayList<Integer>(); // 각 배열에 비어 있는 arraylist 생성
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			// 양방향이므로 from, to 둘 다 해줘야 함.
			adjList[from].add(to);
			adjList[to].add(from);
		}
		
		for (int i = 1; i <= N; i++) {
			Collections.sort(adjList[i]); // 오름차순 정렬, 방문 정점이 여러 개인 경우 작은 것부터 방문 위함.
		}
		visited = new boolean[N+1];
		
		dfs(V);
		System.out.println();
		bfs();
		
	}
	private static void bfs() {
		// 큐 생성 - 처리할 정점 번호 관리
		Queue<Integer> q = new LinkedList<Integer>();
		// 방문처리 배열 생성
		boolean[] visited = new boolean[N+1];
		
		// 큐에 시작점 넣기
		q.offer(V);
		// 해당 시작점 방문처리
		visited[V] = true;
		// 큐가 비어 있지 않을 때까지 반복문
		while(!q.isEmpty()) {
		// 앞 정점 꺼내서
			int curr = q.poll();
			System.out.print(curr + " ");
		// 해당 정점에 연결된 인접리스트만큼 반복 돌면서
			for (int temp : adjList[curr]) {
				// 해당 리스트를 방문하지 않았다면 큐에 넣고 방문체크
				if(!visited[temp]) {
					q.offer(temp);
					visited[temp] = true;
				}
			}
		}
	}
	
	private static void dfs(int curr) {
		// 매개변수로 받은 시작점 방문체크
		visited[curr] = true;
		System.out.print(curr + " ");
		// 해당 정점에 연결된 인접리스트만큼 반복 돌면서
		for (int temp : adjList[curr]) {
			// 해당 리스트를 방문하지 않았다면 dfs 재귀
			if(!visited[temp])
				dfs(temp);
		}
	}

}
