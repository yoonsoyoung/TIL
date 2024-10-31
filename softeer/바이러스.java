import java.io.*;
import java.util.*;

// 통과
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long k = Long.parseLong(st.nextToken()); // 바이러스 수
        long p = Long.parseLong(st.nextToken()); // 증가율
        long n = Long.parseLong(st.nextToken()); // 시간
        long mod = 1000000007;

        long res = k % mod;
        for(int i = 0; i < (n % mod); i++) {
            res = (res * p) % mod;
        }

        System.out.println(res);
    }
}
