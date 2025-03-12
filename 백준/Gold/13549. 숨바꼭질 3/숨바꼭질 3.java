import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static boolean visited[];
    static class Subin {
        int pos = 0;
        int sec = 0;
        Subin(int pos, int sec) {
            this.pos = pos;
            this.sec = sec;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];

        if(N >= K) {
            System.out.println(N - K);
        } else {
            System.out.println(bfs());
        }
    }

    static int dr[] = {2, -1, 1};
    private static int bfs() {
        Queue<Subin> q = new LinkedList<>();
        q.offer(new Subin(N, 0));

        while(!q.isEmpty()) {
            Subin curr = q.poll();
            int cp = curr.pos;
            int cs = curr.sec;

            if(cp == K) {
                return cs;
            }

            visited[cp] = true;
            for(int d = 0; d < 3; d++) {
                int np = 0;
                int ns = cs;
                if(d != 0) {
                    np = cp + dr[d];
                    ns = cs + 1;
                } else {
                    np = cp * dr[d];
                }

                if(np < 0 || np > 100000)
                    continue;
                if(visited[np])
                    continue;

                q.offer(new Subin(np, ns));
            }
        }

        return 0;
    }
}
