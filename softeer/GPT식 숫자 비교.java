import java.io.*;
import java.util.*;

// 통과 0.159초 19.55MB 메모리
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] nums = new String[n];

        for(int i = 0; i < n; i++) {
            nums[i] = br.readLine();
        }

        Arrays.sort(nums, (a, b) -> {
            String[] arr_a = a.split("\\.");
            String[] arr_b = b.split("\\.");

            if(arr_a[0].equals(arr_b[0])) {
                int decimal_a = arr_a.length > 1 ? Integer.parseInt(arr_a[1]) : -1;
                int decimal_b = arr_b.length > 1 ? Integer.parseInt(arr_b[1]) : -1;
                return decimal_a - decimal_b;
            } else {
                return Integer.parseInt(arr_a[0]) - Integer.parseInt(arr_b[0]);
            }
        });

        for(String s : nums) {
            System.out.println(s);
        }
    }
}
