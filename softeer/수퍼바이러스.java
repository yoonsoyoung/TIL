import java.io.*;
import java.util.*;

// 통과 0.070초 10.23MB 메모리
public class Main {

    static final int mod = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int k = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        long n = Long.parseLong(st.nextToken()) * 10;

        long ans = power(p, n) * k;
        // p^n * k
        System.out.println(ans % mod);
    }

    // 분할정복을 이용한 제곱승
    private static long power(int a, long b) {
        if(b == 1)
            return a;

        long m = power(a, b/2);
        long temp = m * m % mod;

        if(b % 2 == 0) {
            return temp;
        } else {
            return a * temp % mod;
        }
    }
}
