import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        Map<String, Integer> game = new HashMap<>(); // 게임 별 인원수
        game.put("Y", 2);
        game.put("F", 3);
        game.put("O", 4);

        int n = Integer.parseInt(st.nextToken()); // 신청 횟수
        String g = st.nextToken(); // 게임 종류

        Set<String> player = new HashSet<>();
        for(int i = 0; i < n; i++) {
            player.add(br.readLine());
        }

        System.out.println(player.size() / (game.get(g) - 1));
    }
}
