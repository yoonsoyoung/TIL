import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); // 지름길 개수
        int D = Integer.parseInt(st.nextToken()); // 고속도로의 길이

        int dp[] = new int[D + 1];
        int route[][] = new int[N][3];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            route[i][0] = from;
            route[i][1] = to;
            route[i][2] = len;
        }

        Arrays.sort(route, (a, b) -> {
            if(a[0] == b[0]) {
                if(a[1] == b[1]) {
                    return a[2] - b[2];
                }
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        for(int i = 0; i <= D; i++) {
            dp[i] = i; // 각 거리별 그냥 운전했을 때 거리
        }

        // 현 지점에 도달하는 점을 기준으로 dp
        for(int i = 1; i <= D; i++) {
            dp[i] = Math.min(dp[i], dp[i - 1] + 1);

            for(int j = 0; j < N; j++) {
                if(route[j][1] == i) { // 지름길의 도착지점이 현재 지점일 경우
                    // 그냥 현재 지점으로 오는 것과 지름길 시작에서 타고 온 것 중 최소값
                    dp[i] = Math.min(dp[i], dp[route[j][0]] + route[j][2]);
                }
            }
        }
        System.out.println(dp[D]);
    }
}
