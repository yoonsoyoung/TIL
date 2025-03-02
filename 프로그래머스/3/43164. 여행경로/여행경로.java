import java.util.*;
class Solution {
    static ArrayList<String> res;
    static boolean selected[];
    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length + 1];
        res = new ArrayList<>();
        selected = new boolean[tickets.length];
        
        dfs(0, tickets.length, "ICN", "ICN", tickets);
        Collections.sort(res);
        answer = res.get(0).split(",");
        
        return answer;
    }
    
    private static void dfs(int cnt, int len, String now, String route, String[][] tickets) {
        if(cnt == len) {
            res.add(route);
            return;
        }
        
        for(int i = 0; i < len; i++) {
            String next = tickets[i][1];
            if(!selected[i] && now.equals(tickets[i][0])) {
                selected[i] = true;
                dfs(cnt + 1, len, next, route + "," + next, tickets);
                selected[i] = false;
            }
        }
    }
}