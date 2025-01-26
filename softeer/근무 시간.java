import java.io.*;
import java.util.*;

// 통과 0.068초 10.22MB 메모리
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int hour = 0;
        int minute = 0;

        for(int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String[] start = st.nextToken().split(":");
            String[] end = st.nextToken().split(":");

            int startH = Integer.parseInt(start[0]);
            int startM = Integer.parseInt(start[1]);
            int endH = Integer.parseInt(end[0]);
            int endM = Integer.parseInt(end[1]);

            hour += endH - startH;
            minute += endM - startM;
        }

        System.out.println(hour * 60 + minute);
    }
}
