import java.io.*;
import java.util.*;

// 통과 0.7초 61.61MB 메모리
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] score = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int sum = 0;
            for(int j = start - 1; j < end; j++) {
                sum += score[j];
            }

            double avg = (double)sum / (end - start + 1);
            sb.append(String.format("%.2f", avg) + "\n");
        }

        System.out.println(sb.toString());
    }
}
