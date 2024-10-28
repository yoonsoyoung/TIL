package 소프티어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 통과
public class 금고털이 {
    static class Jewel {
        int m, p; // m: 무게, p: 가격
        Jewel(int m, int p) {
            this.m = m;
            this.p = p;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int w = Integer.parseInt(st.nextToken()); // 배낭 무게
        int n = Integer.parseInt(st.nextToken()); // 귀금속 종류

        ArrayList<Jewel> jewels = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            jewels.add(new Jewel(m, p));
        }

        // 가격이 비싼 순으로 선정렬
        Collections.sort(jewels, (n1, n2) -> Integer.compare(n2.p, n1.p));
        // 비싼거 우선으로 가득 넣고 남은 양만큼 그다음 비싼거 채우기
        int max = 0; // 최대값
        int weight = w; // 잔여무게
        for (Jewel j : jewels) {
            if (weight - j.m >= 0) { // 전체 다 뺄 수 있으면 빼고
                weight = weight - j.m;
                max = max + j.m * j.p;
            } else {
                max = max + weight * j.p;
                break;
            }
        }

        System.out.println(max);
    }
}
