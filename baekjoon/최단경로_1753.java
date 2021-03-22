package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// ��������� 2��x2������ �޸��ʰ� �߻� => ����Ʈ �̿��ϱ�
// ��� 2304ms
public class �ִܰ��_1753 {

	static int V, E, K;
	static int[] D;
	static ArrayList<Node>[] adjL; // ��������Ʈ �迭�̿�
	
	static class Node implements Comparable<Node> {
		int v; // ������ ��ȣ
		int w; // ����ġ
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
		
		V = Integer.parseInt(st.nextToken()); // ������ ���� 1~V���� ��ȣ�� �Ű��� ���� 1<= V <= 20,000
		E = Integer.parseInt(st.nextToken()); // ������ ����  1<= V <= 300,000
		K = Integer.parseInt(br.readLine()); // ���� ������ ��ȣ

		D = new int[V+1];
		Arrays.fill(D, Integer.MAX_VALUE);
		
		adjL = new ArrayList[V+1];
		// �� �迭�� ����ִ� ArrayList ����������.
		for (int i = 1; i <= V; i++) {
			adjL[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken()); // u 
			int to = Integer.parseInt(st.nextToken()); // v
			int w = Integer.parseInt(st.nextToken()); // ����ġ
			adjL[from].add(new Node(to, w));
		}
		
		dijkstra(K); // �������� ������
		
		for (int i = 1; i <= V; i++) {
			System.out.println(D[i] == Integer.MAX_VALUE ? "INF" : D[i]);
		}
	}

	private static void dijkstra(int a) {
		boolean[] visited = new boolean[V+1];
		D[a] = 0; // �������� 0���� ����
		
		for (int i = 0; i < V-1; i++) {
			int minIdx = -1;
			int min = Integer.MAX_VALUE;
			for (int j = 1; j <= V; j++) {
				if(!visited[j] && D[j] < min) {
					min = D[j];
					minIdx = j;
				}
			}
			
			// ���Ḯ��Ʈ���� ������� ���� ���
			if(minIdx == -1)
				break;
			
			visited[minIdx] = true;
			
			// ���õ� minIdx�� ����� ������
			for (int j = 0; j < adjL[minIdx].size(); j++) {
				Node cur = adjL[minIdx].get(j); // ���� ����Ʈ���� �� ����� ����
				// minIdx ������ ���� ����Ʈ ��� �� �湮���� �ʰ� �����ϴ� ���� �˷��� ������ �۴ٸ� ����  
				if(!visited[cur.v] && D[minIdx] + cur.w < D[cur.v])
					D[cur.v] = D[minIdx] + cur.w;
			}
		}
		
		
	}

}
