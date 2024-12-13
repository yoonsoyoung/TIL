import java.util.*;
class Solution {
    public int[] solution(int[][] score) {
        int len = score.length;
        int[] answer = new int[len];
        // 풀이 2.
        List<Integer> sumList = new ArrayList<>(); // indexOf 사용을 위해 객체형으로 관리
        for(int i = 0; i < len; i++) {
            // 어차피 같은 2로 나누니 합으로만 판단 => 평균을 위한 dobule 변환 과정 생략
            sumList.add(score[i][0] + score[i][1]); 
        }
        Collections.sort(sumList, (a, b) -> b - a);
        for(int i = 0; i < len; i++) {
            // sumList는 score의 두 합을 담았으니 그 동일 값으로 index를 찾음 => 중복값 판단 과정 생략
            answer[i] = sumList.indexOf(score[i][0] + score[i][1]) + 1;
        }
        return answer;
    }
}
