import java.io.*;
import java.util.*;

// 통과 0.076초 10.23MB 
public class Main {
    static int[][] map, reqPoints;
    static boolean[][] visited;
    static int n, m, ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken()); // 격자 크기
        m = Integer.parseInt(st.nextToken()); // 방문 칸 수

        map = new int[n][n];
        visited = new boolean[n][n];
        reqPoints = new int[m][2];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            reqPoints[i][0] = Integer.parseInt(st.nextToken()) - 1;
            reqPoints[i][1] = Integer.parseInt(st.nextToken()) - 1;
        }

        dfs(reqPoints[0][0], reqPoints[0][1], 0);
        System.out.println(ans);
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    private static void dfs(int r, int c, int idx) {
        // 현재 지점이 순차적 방문해야 하는 지점
        if(r == reqPoints[idx][0] && c == reqPoints[idx][1]) {
            // 근데 마지막 지점이면 경우의 수 증가, 리턴
            if(idx == m - 1) {
                ans++;
                return;
            } else {
                // 아니면 순차 인덱스 증가
                idx++;
            }
        }

        visited[r][c] = true;
        // 사방탐색
        for(int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(nr < 0 || nc < 0 || nr >= n || nc >= n)
                continue;
            if(map[nr][nc] == 1)
                continue;
            if(!visited[nr][nc]) {
                dfs(nr, nc, idx);
            }
        }

        // 탐색 끝내고 돌아왔을 때 해당 지점 방문 원복, 리턴
        visited[r][c] = false;
        return;
    }
}
