import java.io.*;
import java.util.*;

// 통과
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken()); // 터치 전 이동 가능 거리, 터치 후 기다릴 시간
        int b = Integer.parseInt(st.nextToken()); // 터치 후 이동 가능 거리, 터치 후 기다릴 시간
        int d = Integer.parseInt(st.nextToken()); // 총 거리

        int time = 0;
        int goTime = (d / a) * a;
        int waitTime = d - goTime > 0 ? (d / a) * b : 0;
        // 갈 때
        time += (goTime + d - goTime + waitTime);
        // 돌아갈 때
        goTime = (d / b) * b;
        waitTime = (d / b) * a;
        time += (goTime + d - goTime + waitTime);

        System.out.println(time);
    }

}
