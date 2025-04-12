import java.io.*;
import java.util.*;

public class Main {

	static int N, Q;
	static ArrayList<Video>[] adjList;
	static class Video {
		int id, usado;
		Video(int id, int usado) {
			this.id = id;
			this.usado = usado;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken()); // 동영상 수
		Q = Integer.parseInt(st.nextToken()); // 질문 수

		adjList = new ArrayList[N+1]; // 연결 정점 관리
		for(int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			adjList[p].add(new Video(q, r));
			adjList[q].add(new Video(p, r));
		}
		
		for(int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int k = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int ans = dfs(v, k);
			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	private static int dfs(int v, int w) {
		int ans = 0;
		boolean[] visited = new boolean[N + 1];
		Queue<Video> q = new LinkedList<>();
		
		q.offer(new Video(v, w));
		visited[v] = true;
		
		while(!q.isEmpty()) {
			Video curr = q.poll();
			int id = curr.id;
			
			for(Video temp : adjList[id]) { // 해당 영상과 연결된 인접리스트 돌면서
				int ni = temp.id;
				int nu = temp.usado;
				if(!visited[ni] && nu >= w) { // 해당 영상 방문 x, 유사도가 기준값보다 크면 다음 탐색
					q.offer(new Video(ni, nu));
					visited[ni] = true;
					ans++;
				}
			}
		}
		
		return ans;
	}

}
