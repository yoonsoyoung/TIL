import java.io.*;
import java.util.*;

// 통과
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] gear = new int[8];
        for(int i = 0; i < 8; i++) {
            gear[i] = Integer.parseInt(st.nextToken());
        }
        
        String sort = "ascending";
        for(int i = 1; i < 8; i++) {
            if(gear[0] + i == gear[i]) {
                sort = "ascending";
            } else if (gear[0] - i == gear[i]) {
                sort = "descending";
            } else {
                sort = "mixed";
                break;
            }
        }

        System.out.println(sort);
    }
}
