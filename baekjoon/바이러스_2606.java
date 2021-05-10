package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ��� 132ms
public class ���̷���_2606 {

	static int V, E, ans;

	static class Node {
		int v; // ���� ��ȣ
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

		V = Integer.parseInt(br.readLine()); // ��ǻ�� �� = ���� ��
		E = Integer.parseInt(br.readLine()); // ���� �� ��ǻ�� ��

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
		dfs(1); // 1�� ��ǻ�ͷκ��� ���̷����� ��������
		
		System.out.println(ans);
	}

	private static void dfs(int curr) {
		visited[curr] = true; // �湮ó��
		for (Node tmp = adjList[curr]; tmp != null; tmp = tmp.next) { // ���� ���� ����
			if(!visited[tmp.v]) { // �湮���� ���� ���̸�
				ans++; // ī����
				dfs(tmp.v); // �¸� �� Ÿ��Ÿ��...
			}
		}
	}

}
