import java.io.*;

public class Main {
    static String[] channel;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        channel = new String[N];
        int targetIdx = 0; // kbs1, kbs2 인덱스
        for(int t = 0; t < N; t++) {
            channel[t] = br.readLine();
            if("KBS1".equals(channel[t])) {
                targetIdx = t;
            }
        }

        // 1. KBS1 인덱스까지 화살표 이동 후
        sb.append("1".repeat(targetIdx));
        // 2. 위와 스왑하며 [0]까지 배치
        for(int i = targetIdx; i > 0; i--) {
            String temp = channel[i - 1];
            channel[i - 1] = channel[i];
            channel[i] = temp;
            sb.append("4");
        }

        // 3. KBS2 인덱스 찾고
        for(int i = 1; i < N; i++) {
            if("KBS2".equals(channel[i])) {
                targetIdx = i;
            }
        }
        // 4. KBS2 인덱스까지 화살표 이동 후
        sb.append("1".repeat(targetIdx));
        // 5. 위와 스왑하며 [1]까지 배치
        for(int i = targetIdx; i > 1; i--) {
            String temp = channel[i - 1];
            channel[i - 1] = channel[i];
            channel[i] = temp;
            sb.append("4");
        }
        
        System.out.println(sb.toString());
    }
}
