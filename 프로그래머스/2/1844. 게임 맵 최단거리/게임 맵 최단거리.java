import java.util.*;
class Solution {
    static class Robot {
        int r, c, cnt;
        Robot(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
    static int n, m;
    public int solution(int[][] maps) {
        int answer = 0;
        n = maps.length - 1;
        m = maps[0].length - 1;     
        answer = bfs(maps);
        return answer;
    }
    
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    private static int bfs(int[][] maps) {
        Queue<Robot> q = new LinkedList<>();
        boolean[][] visited = new boolean[n + 1][m + 1];
        
        q.offer(new Robot(0, 0, 1));
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            Robot curr = q.poll();
            
            if(curr.r == n && curr.c == m) {
                return curr.cnt;
            }
            
            for(int d = 0; d < 4; d++) {
                int nr = curr.r + dr[d];
                int nc = curr.c + dc[d];
                int cnt = curr.cnt;
                
                if(nr < 0 || nc < 0 || nr > n || nc > m) 
                    continue;
                if(maps[nr][nc] == 0)
                    continue;
                if(visited[nr][nc])
                    continue;
                
                q.offer(new Robot(nr, nc, cnt+1));
                visited[nr][nc] = true;
            }
        }
        return -1;
    }
}