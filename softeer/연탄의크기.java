package 소프티어;
import java.io.*;
import java.util.*;

// 통과
public class 연탄의크기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine()); // 집의 수
        int[] stove = new int[n]; // 각 집 난로의 반지름 길이를 담는 배열
        int[] briquet = new int[n]; // 연탄에 따라 가능한 최대 난로 수 담는 배열
        int result = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            stove[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(stove);
        for(int i = 2; i <= stove[n-1]; i++) { // 연탄 반지름 2 ~ 난로 최대 반지름까지
            int cnt = 0;
            for(int j = 0; j < n; j++) {
                if(stove[j] % i == 0) {
                    cnt++;
                }
            }
            briquet[i] = cnt;
        }

        for(int i = 2; i <= stove[n-1]; i++) {
            result = result > briquet[i] ? result : briquet[i];
        }
        System.out.println(result);
    }
}
