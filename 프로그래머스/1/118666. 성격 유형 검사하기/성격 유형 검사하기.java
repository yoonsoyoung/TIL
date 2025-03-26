import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        int[] qScore = {0, -3, -2, -1, 0, 1, 2, 3}; // 성격 유형 점수
        String[][] type = {{"R", "T"}, {"C", "F"}, {"J", "M"}, {"A", "N"}};
        Map<String, Integer> typeScore = new HashMap<>() {{
            put("R", 0);
            put("T", 0);
            put("C", 0);
            put("F", 0);
            put("J", 0);
            put("M", 0);
            put("A", 0);
            put("N", 0);
        }};
        
        
        for(int i = 0; i < survey.length; i++) {
            int choiceScore = qScore[choices[i]];
            String typeStr[] = survey[i].split(""); // 0: 비동의, 1: 동의
            if(choiceScore < 0) { // 비동의 항목
                typeScore.computeIfPresent(typeStr[0], (k, v) -> v + (choiceScore * (-1)));
            } else if(choiceScore > 0) { // 동의 항목
                typeScore.computeIfPresent(typeStr[1], (k, v) -> v + choiceScore);
            }
        }
        
        for(int i = 0; i < 4; i++) {
            int type1 = typeScore.get(type[i][0]);
            int type2 = typeScore.get(type[i][1]);
            answer += (type1 >= type2) ? type[i][0] : type[i][1];
        }

        return answer;
    }
}