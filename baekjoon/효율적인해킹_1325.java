package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 통과 10032ms
public class Main_1325 {

	static int N, M, res;
	static boolean[] visited;
	static int[] conn;
	static ArrayList<Integer>[] adjList;
	static ArrayList<Integer> ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken()); // 컴퓨터 1~N
		M = Integer.parseInt(st.nextToken()); // 관계 수
		conn = new int[N+1];
		adjList = new ArrayList[N + 1]; // 1번부터 쓰기 위함
		for (int i = 0; i < adjList.length; i++) {
			adjList[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adjList[a].add(b);
		}

		for (int i = 1; i <= N; i++) {
			visited = new boolean[N+1];
			dfs(i);
		}
		
		int max = 0;
		ans = new ArrayList<Integer>();
		for (int i = 1; i <= N; i++) {
			if(max < conn[i]) { // 연결된 수 최대값 갱신
				// max 갱신
				max = conn[i];
				// 그간 쌓았던 ans 리스트 초기화
				ans.clear();
				// 현재 인덱스 적재
				ans.add(i);
			} else if(max == conn[i] ){ // 똑같은 최대값일 땐
				// 이어서 적재
				ans.add(i);
			}
		}
		
		for (int a : ans) {
			System.out.print(a + " ");
		}
	}

	private static void dfs(int curr) {
		visited[curr] = true;
		for (int next : adjList[curr]) { // 연결된 컴퓨터를 따라 
			if(!visited[next]) { // 방문하지 않았을 때
				conn[next]++; // 해당 컴퓨터 연결수 증가
				dfs(next); // 타고..타고...
			}
		}
	}

}
