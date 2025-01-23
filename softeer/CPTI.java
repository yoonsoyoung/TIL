import java.io.*;
import java.util.*;

// 통과
public class Main {
    static int n, m, cpti[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken()); // 사람 수
        m = Integer.parseInt(st.nextToken()); // 유형 수
        cpti = new int[n];
        int answer = 0;

        for(int i = 0; i < n; i++) {
            cpti[i] = Integer.parseInt(br.readLine(), 2); // 이진수를 정수형으로 변환
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(int c : cpti) {
            // 1. 자기 자신과 동일
            answer += map.getOrDefault(c, 0);

            // 2. 1비트만 다름(XOR)
            for(int i = 0; i < m; i++) {
                int diffOne = c ^ (1 << i);
                answer += map.getOrDefault(diffOne, 0); // 해당 경우의 수 저장

                // 3. 2비트 다름
                for(int j = i + 1; j < m; j++) {
                    int diffTwo = diffOne ^ (1 << j);
                    answer += map.getOrDefault(diffTwo, 0);
                }
            }

            map.put(c, map.getOrDefault(c, 0) + 1); // 현재 cpti의 친밀감 수 저장
        }

        System.out.println(answer);
    }
}
