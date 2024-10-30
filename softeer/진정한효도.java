import java.io.*;
import java.util.*;

// 통과
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int[][] farm = new int[3][3];
        for(int i = 0; i < farm.length; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j  <farm[i].length; j++) {
                farm[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 최소 비용 = 각 행/열의 최대값-최소값
        int minCost = 100;        
        for(int i = 0; i < 3; i++) {
            int[] areaRow = {farm[i][0], farm[i][1], farm[i][2]}; // 행 탐색
            int[] areaCol = {farm[0][i], farm[1][i], farm[2][i]}; // 열 탐색
            int costRow = Arrays.stream(areaRow).max().orElse(0) - Arrays.stream(areaRow).min().orElse(0);
            int costCol = Arrays.stream(areaCol).max().orElse(0) - Arrays.stream(areaCol).min().orElse(0);
            int cost = costRow > costCol ? costCol : costRow;
            minCost = minCost > cost ? cost : minCost;
        }

        System.out.println(minCost);
    }
}
