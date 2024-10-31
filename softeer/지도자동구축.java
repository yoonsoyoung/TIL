import java.io.*;
import java.util.*;

// 통과 (백준 2903 중앙 이동 알고리즘 과 동일한 문제)
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 단계

        // (2^n + 1) * (2^n + 1)
        long res = 1;
        for(int i = 0; i < n; i++) {
            res *= 2;
        }
        res = res + 1;
        System.out.println(res * res);
        /*
        2 -> 3 -> 5-> 9 -> 17 -> 33
        0    1    2   3    4
             1    2   4    8     16
        */
    }
}
