import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        Stack<Integer> s = new Stack<>();
        s.push(arr[0]);
        for(int n : arr) {
            if(n != s.peek()) {
                s.push(n);
            }
        }
        answer = s.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}