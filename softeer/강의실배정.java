import java.io.*;
import java.util.*;

// 통과 1.817초 79.30MB (백준 회의실배정과 동일로직)
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        int[][] time = new int[n][2];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            time[i][0] = Integer.parseInt(st.nextToken()); // 시작
            time[i][1] = Integer.parseInt(st.nextToken()); // 끝
        }

        // 빨리 끝나는 순으로 정렬
        Arrays.sort(time, (a, b) -> {
            if(a[1] == b[1]) {
                return a[0] - b[0]; // 같으면 빨리 시작하는 순
            }
            return a[1] - b[1];
        });

        int currStart = time[0][0];
        int currEnd = time[0][1];
        int ans = 1;
        for(int i = 1; i < n; i++) {
            if(time[i][0] >= currEnd) { // 현재 시작시간이 최근 종료시간과 같거나 이후면 배정
                currStart = time[i][0];
                currEnd = time[i][1];
                ans++;
            }
        }
        System.out.println(ans);
    }
}
