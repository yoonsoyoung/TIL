import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static boolean[] visited;

	static class Node {
		int pos, sec;

		public Node(int pos, int sec) {
			this.pos = pos;
			this.sec = sec;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken()); // 수빈 위치
		K = Integer.parseInt(st.nextToken()); // 동생 위치

		visited = new boolean[100001];
        
        if(N >= K) {
			System.out.println(N-K);
			return;
		}
		System.out.println(bfs(N));
	}

	static int[] dr = { -1, 1, 2 };

	private static int bfs(int n) {
		Queue<Node> q = new LinkedList<>();

		q.offer(new Node(n, 0)); // 맨 처음 위치와 시간은 0초
		visited[n] = true;

		while (!q.isEmpty()) {
			Node curr = q.poll();
			int p = curr.pos;
			int s = curr.sec;
			
			if(p == K) // 동생의 위치와 같아지면
				return s; // 바로 현재 시간 리턴
			
			for (int d = 0; d < 3; d++) {
				int np ;
				if(dr[d] != 2) {
					np = p + dr[d];
				} else {
					np = p * dr[d];
				}
				
				if(np < 0 || np > 100000)
					continue;
				if(visited[np])
					continue;
				
				q.offer(new Node(np, s+1)); // 다음 위치와 시간 1 증가
				visited[np] = true; // 방문처리
			}
		}
		return 0;
	}

}
