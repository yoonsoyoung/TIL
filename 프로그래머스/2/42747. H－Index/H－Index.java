import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int h = citations.length;
        Arrays.sort(citations);
        for(int c : citations) {
            if(c >= h) {
                return h;
            }
            h--;
        }
        return answer;
    }
}