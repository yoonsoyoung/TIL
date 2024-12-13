import java.util.*;
class Solution {
    public int[] solution(int[] numlist, int n) {
        int[] answer = new int[numlist.length];
        Integer[] list = Arrays.stream(numlist).boxed().toArray(Integer[]::new);
        Arrays.sort(list, (a , b) -> {
                int diff = Math.abs(a - n) - Math.abs(b - n);
                if(diff !=0) return diff; 
                return b - a; // 같은 거리일 땐 내림차순
            });
        Arrays.setAll(answer, i -> list[i]);
        return answer;
    }
}