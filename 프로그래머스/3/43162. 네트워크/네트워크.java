import java.util.*;
class Solution {
    static boolean[] visited;
    static ArrayList<Integer>[] adjList;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        adjList = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < computers.length; i++) {
            for(int j = 0; j < computers[i].length; j++) {
                if(computers[i][j] == 1) {
                    adjList[i].add(j);
                }
            }
        }
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(i, 0);
                answer++;
            }
        }
    
        return answer;
    }
    
    private static int dfs(int curr, int cnt) {
        visited[curr] = true;
        for(int next : adjList[curr]) {
            if(!visited[next]) {
                dfs(next, cnt + 1);
            }
        }
        return cnt;
    }
}