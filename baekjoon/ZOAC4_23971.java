package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 통과
public class zoac4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken()); // 행
        int w = Integer.parseInt(st.nextToken()); // 열
        int n = Integer.parseInt(st.nextToken()); // 행 거리두기
        int m = Integer.parseInt(st.nextToken()); // 열 거리두기

        // 100ms : 각 거리를 둬야하는 거리에 기본적으로 앉게되는 +1 후에 아래 계산
        n = n+1;
        m = m+1;
        int h_seat = h % n == 0 ? h / n : h / n + 1;
        int w_seat = w % m == 0 ? w / m : w / m + 1;
        System.out.println(h_seat * w_seat);

        // 504ms
//        int seat = 0;
//        for (int i = 0; i < h; i += n + 1) {
//            for (int j = 0; j < w; j += m + 1). {
//                seat++;
//            }
//        }
//        System.out.println(seat);
    }
}
