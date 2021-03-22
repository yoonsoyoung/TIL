package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 인접행렬은 2만x2만으로 메모리초과 발생 => 리스트 이용하기
// 통과 2304ms
public class 최단경로_1753 {

	static int V, E, K;
	static int[] D;
	static ArrayList<Node>[] adjL; // 인접리스트 배열이용
	
	static class Node implements Comparable<Node> {
		int v; // 정점의 번호
		int w; // 가중치
		public Node(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}
		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		V = Integer.parseInt(st.nextToken()); // 정점의 개수 1~V까지 번호가 매겨져 있음 1<= V <= 20,000
		E = Integer.parseInt(st.nextToken()); // 간선의 개수  1<= V <= 300,000
		K = Integer.parseInt(br.readLine()); // 시작 정점의 번호

		D = new int[V+1];
		Arrays.fill(D, Integer.MAX_VALUE);
		
		adjL = new ArrayList[V+1];
		// 각 배열에 비어있는 ArrayList 만들어놔야함.
		for (int i = 1; i <= V; i++) {
			adjL[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken()); // u 
			int to = Integer.parseInt(st.nextToken()); // v
			int w = Integer.parseInt(st.nextToken()); // 가중치
			adjL[from].add(new Node(to, w));
		}
		
		dijkstra(K); // 시작점을 가지고
		
		for (int i = 1; i <= V; i++) {
			System.out.println(D[i] == Integer.MAX_VALUE ? "INF" : D[i]);
		}
	}

	private static void dijkstra(int a) {
		boolean[] visited = new boolean[V+1];
		D[a] = 0; // 시작정점 0으로 세팅
		
		for (int i = 0; i < V-1; i++) {
			int minIdx = -1;
			int min = Integer.MAX_VALUE;
			for (int j = 1; j <= V; j++) {
				if(!visited[j] && D[j] < min) {
					min = D[j];
					minIdx = j;
				}
			}
			
			// 연결리스트에서 연결되지 않은 경우
			if(minIdx == -1)
				break;
			
			visited[minIdx] = true;
			
			// 선택된 minIdx의 연결된 정점들
			for (int j = 0; j < adjL[minIdx].size(); j++) {
				Node cur = adjL[minIdx].get(j); // 연결 리스트들의 각 노드의 정보
				// minIdx 정점을 갖는 리스트 노드 중 방문하지 않고 경유하는 값이 알려진 값보다 작다면 갱신  
				if(!visited[cur.v] && D[minIdx] + cur.w < D[cur.v])
					D[cur.v] = D[minIdx] + cur.w;
			}
		}
		
		
	}

}
