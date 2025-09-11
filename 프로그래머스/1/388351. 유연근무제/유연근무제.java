import java.util.*;
class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for(int i = 0; i < timelogs.length; i++) {
            int mm = schedules[i] % 100;
            int hh = schedules[i] - mm;
            if(mm + 10 > 59) {
                mm = (mm + 10) % 60;
                hh = hh + 100;
            } else {
                mm = mm + 10;
            }
            int workTime = hh + mm; // 출근 인정 시간
            
            boolean isPerfect = true;
            int day = startday;
            for(int j = 0; j < 7; j++) {
                if(5 - day < 0) {
                    day = day % 7 + 1;
                    continue;
                }
                day = day % 7 + 1;
                if(timelogs[i][j] > workTime) { // 인정 시간보다 늦게 옴
                    isPerfect = false;
                    break;
                }
            }
            
            if(isPerfect) {
                answer++;
            }
        }
        
        return answer;
    }
}