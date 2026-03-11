import java.util.*;
class Solution {
    static int map[][];
    final static int SIZE = 101; 
    static class Node {
        int x, y, cnt;
        Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        map = new int[SIZE][SIZE];
        
        for(int[] point : rectangle) {
            // 자원 재정의: 값들을 모두 2배로 키워 점을 칸으로
            int x1 = point[0] * 2;
            int y1 = point[1] * 2;
            int x2 = point[2] * 2;
            int y2 = point[3] * 2;
            // 재정의 된 자원을 기준으로 맵에 표기    
            for(int i = x1; i <= x2; i++) {
                for(int j = y1; j <= y2; j++) {
                    // 가장 자리 라인만 이동 가능 표기: 1
                    if(i == x1 || i == x2 || j == y1 || j == y2) {
                        if(map[i][j] == 0) {
                            map[i][j] = 1;
                        }
                    } else {
                        // 겹치게 된 안쪽 라인은 이동 불가 표기: 2
                        map[i][j] = 2;
                    }
                }
            }
        }
        
        // 최단거리 찾기
        answer = bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
        
        return answer;
    }
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    private static int bfs(int cx, int cy, int ix, int iy) {
        Queue<Node> q = new LinkedList<Node>();
        boolean[][] visited = new boolean[SIZE][SIZE];

        q.offer(new Node(cx, cy, 0));
        visited[cx][cy] = true;

        while(!q.isEmpty()) {
            Node curr = q.poll();
            int x = curr.x;
            int y = curr.y;
            int cnt = curr.cnt;

            // 아이템에 도착하면 반환하며 종료
            if(x == ix && y == iy) {
                return cnt / 2; // 2배 했던 값 복구
            }

            for(int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if(nx < 0 || ny < 0 || nx >= SIZE || ny >= SIZE)
                    continue;
                if(visited[nx][ny])
                    continue;
                if(map[nx][ny] != 1)
                    continue;

                q.offer(new Node(nx, ny, cnt+1));
                visited[nx][ny] = true;
            }
        }
        
        return -1;
    }
}