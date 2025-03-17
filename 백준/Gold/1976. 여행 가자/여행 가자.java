import java.io.*;
import java.util.*;

public class Main {
    static int n, m, parents[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine()); // 도시 수
        m = Integer.parseInt(br.readLine()); // 여행 도시 수
        parents = new int[n + 1];

        make();
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= n; j++) {
                if(Integer.parseInt(st.nextToken()) == 1) {
                    union(i, j);
                }
            }
        }

        boolean flag = true;
        st = new StringTokenizer(br.readLine(), " ");
        int startPoint = Integer.parseInt(st.nextToken());
        for(int i = 1; i < m; i++) {
            int p = Integer.parseInt(st.nextToken());
            if(parents[startPoint] != find(p)) { // 계획 여행지들이 모두 시작점과 이어져있어야 함
                flag = false;
                break;
            }
        }

        System.out.println(flag ? "YES" : "NO");
    }

    static void make() {
        // 일단 초기 부모는 자기 자신
        for(int i = 0; i <= n; i++) {
            parents[i] = i;
        }
    }

    static int find(int a) {
        if(parents[a] == a) { // 부모면 리턴
            return a;
        }
        return parents[a] = find(parents[a]); // 아닐 경우 부모 찾아 재귀
    }

    static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot == bRoot) { // 부모가 같으면 같은 집합
            return false;
        }
        parents[bRoot] = aRoot; // 아니면 한쪽으로 합침
        return true;
    }
}