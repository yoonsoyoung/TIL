import java.util.*;

class Solution {
    static int[] depth;
    static ArrayList<Integer>[] adjList;
    static int max;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        depth = new int[n + 1];
        adjList = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        for(int[] e : edge) {
            int from = e[0];
            int to = e[1];
            adjList[from].add(to);
            adjList[to].add(from);
        }
        
        max = 0;
        bfs();     
        for(int d : depth) {
            if(d == max) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        depth[1] = 1;
        
        while(!q.isEmpty()) {
            int curr = q.poll();
            
            for(int e : adjList[curr]) {
                if(depth[e] == 0) {
                    depth[e] = depth[curr] + 1;
                    q.offer(e);
                    max = max > depth[e] ? max : depth[e];
                }
            }
        }
    }
}