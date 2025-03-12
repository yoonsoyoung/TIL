import java.io.*;
import java.util.*;

public class Main {

	static int N, K, time, cnt;
    static boolean visited[];
    static class Subin {
        int pos;
        int sec;
        Subin(int pos, int sec) {
            this.pos = pos;
            this.sec = sec;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); // 수빈 위치
        K = Integer.parseInt(st.nextToken()); // 동생 위치
        time = 987654321;
        cnt = 0;
        visited = new boolean[100001];

        if(N >= K) {
            System.out.printf("%d\n%d", N - K, 1);
        } else {
            bfs();
            System.out.printf("%d\n%d", time, cnt);
        }
    }

    static int[] dr = {-1, 1, 2};
    private static void bfs() {
        Queue<Subin> q = new LinkedList<>();
        q.offer(new Subin(N, 0));

        while(!q.isEmpty()) {
            Subin curr = q.poll();
            int cp = curr.pos;
            int cs = curr.sec;

            visited[cp] = true;
            if(time < cs) return;
            if(cp == K) {
                time = cs;
                cnt++;
            }

            for(int d = 0; d < 3; d++) {
                int np = 0;
                if(dr[d] != 2) {
                    np = cp + dr[d];
                } else {
                    np = cp * dr[d];
                }

                if(np < 0 || np > 100000)
                    continue;
                if(visited[np])
                    continue;

                q.offer(new Subin(np, cs + 1));
            }
        }
    }

}
