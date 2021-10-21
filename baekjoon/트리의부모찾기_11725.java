package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 통과 1448ms
public class boj_11725_Main {

	static int N, parent[];
	static boolean visited[];
	static ArrayList<Integer> adjList[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		parent = new int[N+1];
		adjList = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		for (int i = 0; i <= N; i++) {
			adjList[i] = new ArrayList<Integer>(); // 초기화
		}
		
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjList[from].add(to);
			adjList[to].add(from);
		}
		
		dfs(1, 0);
		
		for (int i = 2; i <= N; i++) {
			System.out.println(parent[i]);
		}

	}

	private static void dfs(int child, int par) {
		visited[child] = true;
		parent[child] = par; // child 의 부모 갱신
		for (int a : adjList[child]) { // child와 연결된 자식들을 보면서
			if(!visited[a]) { // 본 애가 아닐 때
				dfs(a, child); // 그 자식과 부모를 가지고 재귀
			}
			
		}
	}


}
