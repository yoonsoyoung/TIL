import java.io.*;
import java.util.*;

// 통과 (백준 11971속도위반 문제와 동일)
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 운영 구간 수
        int m = Integer.parseInt(st.nextToken()); // 테스트 구간 수

        int[] prodSpeed = new int[101]; // 운영 구간 별 제한속도
        int[] testSpeed = new int[101]; // 테스트 구간 별 제한속도
        int maxDiff = 0; // 차이 최대값

        int end = 0; // 구간의 마지막 지점
        // 운영
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int range = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            for(int j = end; j < end + range; j++) {
                prodSpeed[j] = speed;
            }
            end += range;
        }

        // 테스트
        end = 0;
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int range = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            for(int j = end; j < end + range; j++) {
                testSpeed[j] = speed;
            }
            end += range;
        }

        // 비교
        for(int i = 0; i < 101; i++) {
            int diff = prodSpeed[i] - testSpeed[i];
            if(diff < 0) {
                maxDiff = maxDiff > -diff ? maxDiff : -diff;
            }
        }

        System.out.println(maxDiff);
    }
    
}
