import java.util.*;
class Solution {
    static Queue<Boom> q;
    static int[][] map;
    static class Boom {
        int r, c;
        Boom(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public int solution(int[][] board) {
        int answer = 0;
        map = board;
        q = new LinkedList<Boom>();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == 1) {
                    q.offer(new Boom(i, j));
                }
            }
        }
        answer = bfs(board.length);
        return answer;
    }
    static int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};
    public static int bfs(int n) {
        int res = 0;
        while(!q.isEmpty()) {
            Boom b = q.poll();
            int r = b.r;
            int c = b.c;
            for(int d = 0; d < 8; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                
                if(nr < 0 || nc < 0 || nr >= n || nc >= n) 
                    continue;
                
                if(map[nr][nc] == 1)
                    continue;
                
                if(map[nr][nc] == 2)
                    continue;
                
                map[nr][nc] = 2;
            }
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] == 0) {
                    res++;
                }
            }
        }
        return res;
    }
}
