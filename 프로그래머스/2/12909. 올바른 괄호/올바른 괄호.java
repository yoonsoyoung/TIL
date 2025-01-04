import java.util.*;
class Solution {
    boolean solution(String s) {
        Stack<Boolean> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if('(' == c) {
                stack.push(true);
            } else {
                if(stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return !stack.isEmpty() ? false : true;
    }
}