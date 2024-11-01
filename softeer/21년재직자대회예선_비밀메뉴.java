import java.io.*;
import java.util.*;

// 통과
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken()); // 조작법
        int n = Integer.parseInt(st.nextToken()); // 사용자 조작
        int k = Integer.parseInt(st.nextToken()); // 버튼 수

        String hidenMenu = br.readLine();
        String userMenu = br.readLine();

        if(userMenu.contains(hidenMenu)) {
            System.out.println("secret");
        } else {
            System.out.println("normal");
        }
    } 
}
