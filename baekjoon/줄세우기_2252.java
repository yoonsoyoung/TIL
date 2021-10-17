package 위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 통과 920ms
public class boj_2252_Main {

	static int N, M, indegree[];
	static LinkedList<Integer> adjList[]; // 인접 리스트
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); // 학생 번호 1~N
		M = Integer.parseInt(st.nextToken()); // 비교 횟수
		
		indegree = new int[N+1]; // 1번부터 쓰기 위함
		adjList = new LinkedList[N+1];
		
		// 인접 리스트 초기화
		for (int i = 0; i <= N; i++) {
			adjList[i] = new LinkedList<>(); // 각 배열에 연결리스트 초기화
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjList[from].add(to); // 인접리스트 연결
			indegree[to]++; // 진입차수 증가
		}
		
		topological(); // 위상정렬
		
	}
	private static void topological() {
		Queue<Integer> search = new LinkedList<>(); // 탐색 큐
		Queue<Integer> result = new LinkedList<>(); // 결과 큐
		
		// 처음 진입차수가 0인 노드 탐색해서 탐색 큐에 삽입
		for (int i = 1; i <= N; i++) {
			if(indegree[i] == 0)
				search.offer(i);
		}
		
		// 탐색 큐 빌 때까지 탐색
		while (!search.isEmpty()) {
			// 진입노드가 0인 노드와 연결된 노드 탐색하기 위해 큐에서 하나 꺼냄
			int zero = search.poll();
			// 일단 꺼낸 건 진입노드가 0이므로 정렬이 완료된 것. 결과 큐에 넣어줌
			result.offer(zero);
			// 진입노드0과 연결되어 있던 애들을 반복문 돌면서 꺼내서
			for (int linked : adjList[zero]) {
				// 연결되어 있던 노드 차수 -1 -> 위에서 0인 애 결과큐에 넣었으니까 차수 갱신
				indegree[linked]--;
				
				// 근데 갱신 후 진입차수가 0인 애면 탐색 큐에 삽입
				if(indegree[linked] == 0)
					search.offer(linked);
			}
			
		}
		
		// 결과 큐가 빌 때까지 큐에서 꺼내서 출력 = 정렬된 값
		while(!result.isEmpty()) {
			System.out.print(result.poll() + " ");
		}
	}

}
