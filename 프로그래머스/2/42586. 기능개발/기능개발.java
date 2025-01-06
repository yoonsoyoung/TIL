import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        List<Integer> ansList = new ArrayList<>();
        Stack<Integer> days = new Stack<>();
        int day = 0;
        for(int i = 0; i < progresses.length; i++) {
            int restProg = 100 - progresses[i];
            day = (restProg + speeds[i] - 1) / speeds[i]; // 나머지 활용 올림
            if(days.isEmpty()) {
                days.push(day);
            } else {
                int curDay = days.peek();
                // 앞선 작업이 현재 작업보다 오래 걸리는 경우
                if(curDay >= day) {
                    days.push(curDay); // days 적재
                } else {
                    // 현재 작업이 더 오래 걸리는 경우
                    // 기존 dyas 크기 ansList에 삽입, days 갱신
                    ansList.add(days.size());
                    days.clear();
                    days.push(day);
                }
            }
        }
        ansList.add(days.size());
        answer = ansList.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}