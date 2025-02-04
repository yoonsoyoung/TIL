import java.io.*;
import java.util.*;

// 통과 1.230초 52.04MB 
public class Main {

    static int fuel[], medians[], n, q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken()); // 자동차 수
        q = Integer.parseInt(st.nextToken()); // 테스트 수
        fuel = new int[n]; // 자동차별 연비
        medians = new int[q]; // 테스트 별 중앙값

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            fuel[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < q; i++) {
            medians[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(fuel);
        for(int m : medians) {
            int ans = 0;
            // small, m, big 의 형태로 나오는 경우의 수는 small 경우 수 * big 경우 수
            int mediIdx = binarySearch(0, n-1, m); // 중앙값 인덱스 구하기
            if(mediIdx > 0) {
                ans = mediIdx * (n - mediIdx - 1);
            }
            System.out.println(ans);
        }
        
    }

    private static int binarySearch(int left, int right, int target) {
        int mid = 0;
        while(left < right) {
            mid = (left + right) / 2;
            if(fuel[mid] == target) {
                return mid;
            } else if(fuel[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return -1;
    }
}
