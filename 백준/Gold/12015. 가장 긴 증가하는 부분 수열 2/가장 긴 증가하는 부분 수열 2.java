import java.io.*;
import java.util.*;

public class Main {
    static int[] lis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        lis = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        lis[0] = arr[0];
        int len = 1;
        for(int i = 1; i < n; i++) {
            if(lis[len - 1] <arr[i]) {
                lis[len++] = arr[i];
            } else {
                int pos = binarySearch(0, len - 1, arr[i]);
                lis[pos] = arr[i];
            }
        }

        System.out.println(len);
    }

    private static int binarySearch(int left, int right, int target) {
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
