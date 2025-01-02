import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int r = 0; r < commands.length; r++) {
            int i = commands[r][0];
            int j = commands[r][1];
            int k = commands[r][2];
            
            int[] splitArr = Arrays.copyOfRange(array, i-1, j);
            Arrays.sort(splitArr);
            answer[r] = splitArr[k-1];
        }
        
        return answer;
    }
}