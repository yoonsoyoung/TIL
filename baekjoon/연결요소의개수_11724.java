import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

// 통과 512ms
public class 연결요소의개수_11724 {

	static int N, M, parent[];
	static Node[] nodeList;

	static class Node {
		int from, to;

		public Node(int from, int to) {
			this.from = from;
			this.to = to;
		}
	}
	
	static void make() {
		for (int i = 0; i <= N; i++) {
			parent[i] = i; // 처음 각 점의 부모는 자기 자신
		}
	}
	
	static int find(int a) { // 부모 찾기
		if(parent[a] == a) // 찾으려는 애가 곧 부모
			return a; // 자기 자신 리턴
		else
			return parent[a] = find(parent[a]); // 찾으려는 애의 부모를 찾아 부모 저장
	}
	
	static boolean union(int a, int b) { // 합침
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) // 이미 같은 애
			return false;
		parent[bRoot] = aRoot; // b 부모를 a 부모로 
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken()); // 정점의 개수
		M = Integer.parseInt(st.nextToken()); // 간선의 개수
		parent = new int[N + 1];
		nodeList = new Node[N];

		make();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			union(a, b);
		}
		
//		int[] set = new int[N + 1];
//		for (int i = 1; i <= N; i++) {
//			set[find(i)]++;
//		}
//		
//		int ans = 0;
//		for (int a : set) {
//			if(a != 0)
//				ans++;
//		}
//		System.out.println(ans);
		
		// 통과 484ms
		HashSet<Integer> set = new HashSet<>();
		for (int i = 1; i <= N; i++) {
			set.add(find(i)); // hashset은 중복을 비허용하므로 이미 있는 요소가 나오면 무시
		}
		
		System.out.println(set.size());
	}
}
