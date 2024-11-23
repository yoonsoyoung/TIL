import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] str = s.split(" ");
        
        // 풀이1
        /*
        for(int i = 0; i < str.length; i++) {
            if("Z".equals(str[i])) {
                answer -= Integer.parseInt(str[i-1]);
            } else {
                answer += Integer.parseInt(str[i]);
            }
        }
        */
        
        // 풀이2 : Stack 이용
        Stack<Integer> stack = new Stack<>();
        for(String i : str) {
            if("Z".equals(i)) {
                // Z라면 이전에 더했던 숫자를 뺀다 -> +- 이므로 이전 숫자를 계산에서 제외
                stack.pop();
            } else {
                stack.push(Integer.parseInt(i));
            }
        }
        for(int n : stack) {
            answer += n;
        }
        return answer;
    }
}
