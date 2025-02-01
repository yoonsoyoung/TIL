import java.io.*;
import java.util.*;

// 통과 0.597초 67.99 MB 메모리
public class Main {

    static ArrayList<Integer>[] adjList, adjListR;
    static boolean[] v1, v2, v3, v4;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken()); // 정점 수
        int m = Integer.parseInt(st.nextToken()); // 간선 수

        adjList = new ArrayList[n + 1]; // 정방향
        adjListR = new ArrayList[n + 1]; // 역방향
        v1 = new boolean[n + 1];
        v2 = new boolean[n + 1];
        v3 = new boolean[n + 1];
        v4 = new boolean[n + 1];
        for(int i = 0; i <= n; i++) {
            adjList[i] = new ArrayList<>();
            adjListR[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            adjList[from].add(to);
            adjListR[to].add(from);
        }

        st = new StringTokenizer(br.readLine(), " ");
        int s = Integer.parseInt(st.nextToken()); // 집 정점 번호, 퇴근길 목적
        int t = Integer.parseInt(st.nextToken()); // 회사 정점 번호, 출근길 목적지

        // 1. S에서 출발하는 모든 정점
        v1[t] = true;
        dfs(s, adjList, v1);

        // 2. S로 도착하는 모든 정점
        dfs(s, adjListR, v2);

        // 3. T에서 출발하는 모든 정점
        v3[s] = true;
        dfs(t, adjList, v3);

        // 4. T로 도착하는 모든 정점
        dfs(t, adjListR, v4);

        // 위 4경우에 대한 공통 방문 정점 카운팅
        int ans = 0;
        for(int i = 1; i <= n; i++) {
            if(v1[i] && v2[i] && v3[i] && v4[i]) {
                ans++;
            }
        }

        System.out.println(ans - 2); // s,t 제외
    }

    private static void dfs(int v, ArrayList<Integer>[] route, boolean[] visited) {
        if(visited[v]) {
            return;
        }

        visited[v] = true;
        for(int curr : route[v]) {
            dfs(curr, route, visited);
        }
    }
}
