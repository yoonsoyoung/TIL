import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] soldier = new int[n];
        StringTokenizer st =new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            soldier[i] = Integer.parseInt(st.nextToken());
        }

        int[] lds = new int[n];
        int max = 0;
        for(int i = 0; i < n; i++) {
            lds[i] = 1;
            for(int j = 0; j < i; j++) {
                if(soldier[i] < soldier[j]) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);

                }
            }
            max = max < lds[i] ? lds[i] : max;
        }

        System.out.println(n - max);
    }
}
