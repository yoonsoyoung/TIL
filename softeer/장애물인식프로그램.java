import java.io.*;
import java.util.*;

// 통과 (백준 2667 단지번호붙이기 와 같은 문제)
public class Main {

    static int[][] map;
    static int[] obstacle;
    static int block, n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        obstacle = new int[n * n]; // 각 블럭 내 장애물 수를 담는 배열

        for(int i = 0; i < n; i++) {
            String row = br.readLine();
            for(int j = 0; j < n; j++) {
                map[i][j] = row.charAt(j) - '0';
            }
        }

        block = 0; // 블럭 수
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] == 1) {
                    dfs(i, j);
                    block++;
                }
            }
        }
        System.out.println(block);
        Arrays.sort(obstacle, 0, block);
        for(int i = 0; i < block; i++) {
            System.out.println(obstacle[i]);
        }
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int cnt;
    private static void dfs(int r, int c) {
        map[r][c] = 0;
        obstacle[block]++; // 해당 블럭의 장애물 수 증가

        for(int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            
            if(nr < 0 || nc < 0 || nr >= n || nc >= n) {
                continue;
            }
            if(map[nr][nc] == 1) { // 인접한 장애물이 있으면 이어서 탐색
                dfs(nr, nc);
            }
        }
    }
}
