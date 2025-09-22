import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] numToStr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] strToNum = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        for(int i = 0; i < numToStr.length; i++) {
            s = s.replace(numToStr[i], strToNum[i]);
        }
        
        answer = Integer.parseInt(s);
        return answer;
    }
}