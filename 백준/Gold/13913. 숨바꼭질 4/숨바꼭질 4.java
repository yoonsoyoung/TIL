import java.io.*;
import java.util.*;

public class Main {
    static int N, K, time;
    static String res;
    static boolean visited[];
    static ArrayList<Integer> routeList;
    static class Subin {
        int pos;
        int sec;
        ArrayList<Integer> path;
        Subin(int pos, int sec, ArrayList<Integer> path) {
            this.pos = pos;
            this.sec = sec;
            this.path = new ArrayList<>(path);
            this.path.add(pos);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); // 수빈 위치
        K = Integer.parseInt(st.nextToken()); // 동생 위치
        visited = new boolean[100001];
        routeList = new ArrayList<>();
        res = "";

        StringBuilder sb = new StringBuilder();
        if(N == K) {
            System.out.printf("%d\n%d", N - K, K);
        } else if (N > K) {
            System.out.println(N - K);
            while(N != K) {
                sb.append(N--).append(" ");
            }
            sb.append(K);
        } else {
            bfs();
            System.out.println(time);
            for(int r : routeList) {
                sb.append(r).append(" ");
            }
        }
        res = sb.toString().trim();
        System.out.println(res);
    }

    static int[] dr = {-1, 1, 2};
    private static void bfs() {
        Queue<Subin> q = new LinkedList<>();
        q.offer(new Subin(N, 0, new ArrayList<>()));

        while(!q.isEmpty()) {
            Subin curr = q.poll();
            int cp = curr.pos;
            int cs = curr.sec;
            ArrayList<Integer> path = curr.path;

            visited[cp] = true;
            if(cp == K) {
                time = cs;
                routeList = path;
                return;
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

                q.offer(new Subin(np, cs + 1, path));
            }
        }
    }
}
