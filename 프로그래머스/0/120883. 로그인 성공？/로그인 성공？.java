import java.util.*;
class Solution {
    public String solution(String[] id_pw, String[][] db) {
        String answer = "";
        Map<String, String> dbMap = new HashMap<>();
        for(int i = 0; i < db.length; i++) {
            dbMap.put(db[i][0], db[i][1]);
        }
        
        String id = id_pw[0];
        String pw = id_pw[1];
        if(!dbMap.containsKey(id)) {
            answer = "fail";
        } else {
            answer = dbMap.get(id).equals(pw) ? "login" : "wrong pw";
        }
        return answer;
    }
}