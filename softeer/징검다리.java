import java.io.*;
import java.util.*;

// 통과 0.095초 10.95MB 메모
public class Main {

    static int[] lis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] stone = new int[n];
        lis = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            stone[i] = Integer.parseInt(st.nextToken());
        }

        lis[0] = stone[0];
        int len = 1;
        for(int i = 1; i < n; i++) {
            if(lis[len - 1] < stone[i]) { // 최장 증가 부분 수열 끝값보다 현재값이 크면
                lis[len++] = stone[i]; // 부분 수열 끝에 현재값 추가
            } else {
                int pos = lisBinarySearch(0, len - 1, stone[i]); // 현재값이 들어가야 할 부분수열 자리 탐색
                lis[pos] = stone[i];
            }
        }

        System.out.println(len); // 최장 증가 부분수열의 길이
    }

    // 최장 증가 부분 수열의 삽입 위치를 찾기 위한 이진탐색 
    private static int lisBinarySearch(int left, int right, int target) {
        int mid = 0;
        while(left < right) {
            mid = (left + right) / 2;
            if(lis[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
