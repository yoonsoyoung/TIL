package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// ��� 388ms
public class DFS��BFS_1260 {

	static int N, M, V;
	static ArrayList<Integer>[] adjList;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // ���� ����
		M = Integer.parseInt(st.nextToken()); // ���� ����
		V = Integer.parseInt(st.nextToken()); // ���� ����
		
		adjList = new ArrayList[N+1]; // 1���� �����Ƿ� N+1
		for (int i = 1; i <= N; i++) { // N ���� ����
			adjList[i] = new ArrayList<Integer>(); // �� �迭�� ��� �ִ� arraylist ����
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			// ������̹Ƿ� from, to �� �� ����� ��.
			adjList[from].add(to);
			adjList[to].add(from);
		}
		
		for (int i = 1; i <= N; i++) {
			Collections.sort(adjList[i]); // �������� ����, �湮 ������ ���� ���� ��� ���� �ͺ��� �湮 ����.
		}
		visited = new boolean[N+1];
		
		dfs(V);
		System.out.println();
		bfs();
		
	}
	private static void bfs() {
		// ť ���� - ó���� ���� ��ȣ ����
		Queue<Integer> q = new LinkedList<Integer>();
		// �湮ó�� �迭 ����
		boolean[] visited = new boolean[N+1];
		
		// ť�� ������ �ֱ�
		q.offer(V);
		// �ش� ������ �湮ó��
		visited[V] = true;
		// ť�� ��� ���� ���� ������ �ݺ���
		while(!q.isEmpty()) {
		// �� ���� ������
			int curr = q.poll();
			System.out.print(curr + " ");
		// �ش� ������ ����� ��������Ʈ��ŭ �ݺ� ���鼭
			for (int temp : adjList[curr]) {
				// �ش� ����Ʈ�� �湮���� �ʾҴٸ� ť�� �ְ� �湮üũ
				if(!visited[temp]) {
					q.offer(temp);
					visited[temp] = true;
				}
			}
		}
	}
	
	private static void dfs(int curr) {
		// �Ű������� ���� ������ �湮üũ
		visited[curr] = true;
		System.out.print(curr + " ");
		// �ش� ������ ����� ��������Ʈ��ŭ �ݺ� ���鼭
		for (int temp : adjList[curr]) {
			// �ش� ����Ʈ�� �湮���� �ʾҴٸ� dfs ���
			if(!visited[temp])
				dfs(temp);
		}
	}

}
