import java.io.*;
import java.util.*;

// 통과 0.417초 52.41MB 
public class Main {

    static int weight[], ans;
    static ArrayList<Integer[]> adjList;
    static boolean strong[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken()); // 회원 수
        int m = Integer.parseInt(st.nextToken()); // 친분 수
        weight = new int[n];
        adjList = new ArrayList<>();
        strong = new boolean[n];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            adjList.add(new Integer[] {from, to});
        }

        // 지면 true, 이기면 false
        for(Integer[] a : adjList) {
            if(weight[a[0]] > weight[a[1]]) {
                strong[a[1]] = true;
            } else if(weight[a[0]] < weight[a[1]]) {
                strong[a[0]] = true;
            } else {
                strong[a[1]] = true;
                strong[a[0]] = true;
            }
        }

        ans = 0;
        for(int i = 0; i < n; i++) {
            if(!strong[i]) {
                ans++;
            }
        }

        System.out.println(ans);
    }

}
