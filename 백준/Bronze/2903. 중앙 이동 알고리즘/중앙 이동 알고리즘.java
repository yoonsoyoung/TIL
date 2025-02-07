import java.io.*;
import java.util.*;

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
    }
}
