package 소프티어;
import java.io.*;
import java.util.*;

// 통과
public class X_marks_the_Spot {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String indexing = st.nextToken().toLowerCase();
            String indirect = st.nextToken();
            char c = indirect.charAt(indexing.indexOf('x'));
            // a: 97~122
            if(97 <= c-0 && c-0 <= 122) {
                sb.append((char)(c-32));
            } else {
                sb.append(c);
            }
        }
        System.out.println(sb.toString());
    }
}
