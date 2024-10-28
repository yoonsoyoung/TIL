package 소프티어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 통과
public class 나무공격 {
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 행
        int m = Integer.parseInt(st.nextToken()); // 열
        map = new int[n][m];
        int[] attack = new int[2]; // 공격 정보 시작 행을 담음

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            attack[i] = Integer.parseInt(st.nextToken());
        }

        for(int r : attack) {
            goAttack(r);
        }

        int result = 0;
        for(int i = 0 ; i < n; i++) {
            for(int j = 0 ; j < m; j++) {
                if(map[i][j] == 1) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }

    public static void goAttack(int start) {
        for(int i = start - 1 ; i < start + 4; i++) {
            for(int j = 0; j < map[i].length; j++) {
                if(map[i][j] == 1) {
                    map[i][j] = 0;
                    break;
                }
            }
        }
    }
}
