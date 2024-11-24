import java.util.*;

// 통과 (+17)
class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        Arrays.sort(array);
        int min = 101;
        for(int i = 0; i < array.length; i++) {
            int dis = Math.abs(array[i] - n);
            if(min > dis) {
                min = dis;
                answer = array[i];
            }
        }
        return answer;
    }
}
