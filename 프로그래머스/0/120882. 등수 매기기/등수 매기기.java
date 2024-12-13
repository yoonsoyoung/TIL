import java.util.*;
class Solution {
    public int[] solution(int[][] score) {
        int len = score.length;
        int[] answer = new int[len];
        float[][] avgScore = new float[len][2];
        for(int i = 0; i < len; i++) {
            avgScore[i][0] = i;
            avgScore[i][1] = (float)(score[i][0] + score[i][1]) / 2;
        }
        Arrays.sort(avgScore, (a, b) -> Float.compare(b[1], a[1]));
        
        int rank = 1;
        answer[(int)avgScore[0][0]] = rank;
        for(int i = 1; i < len; i++) {
            int idx = (int)avgScore[i][0];
            if(avgScore[i-1][1] > avgScore[i][1]) {
                rank = answer[idx] + i + 1;
            }
            answer[idx] = rank;
        }
        return answer;
    }
}