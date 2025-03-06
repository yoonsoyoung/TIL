import java.io.*;
import java.util.*;

public class Main {

    static int map[][], N, M, K, area[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); // map 크기
        M = Integer.parseInt(st.nextToken()); // 포자 수
        K = Integer.parseInt(st.nextToken()); // 가능한 연결 칸 수

        map = new int[N][N];
        area = new int[N*N + 1];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()) * -1;
            }
        }

        int cnt = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 0) {
                    dfs(i, j, ++cnt);
                }
            }
        }

        int needs = 0;
        for(int i = 1; i < area.length; i++) {
            if(area[i] > 0) {
                needs += (area[i] % K == 0 ? area[i] / K : area[i] / K + 1);
            }
        }

        if(cnt > 0 && M >= needs) {
            System.out.printf("%s\n%d", "POSSIBLE", M - needs);
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }

    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};
    private static void dfs(int r, int c, int idx) {
        map[r][c] = idx;
        area[idx]++;

        for(int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(nr < 0 || nc < 0 || nr >= N || nc >= N)
                continue;
            if(map[nr][nc] == 0) {
                dfs(nr, nc, idx);
            }
        }
    }
}
