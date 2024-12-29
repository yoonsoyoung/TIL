class Solution {
    // 풀이1 (메모리 85 MB, 시간: 0.37 ms)
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int sum = 0;
        for(int i = total + num; i >= 0; i--) {
            for(int j = 0; j < num; j++) {
                sum += i - j;
            }
            if(sum == total) {
                int cnt = num - 1;
                for(int j = 0; j < num; j++) {
                    answer[j] = i - cnt--;
                }
                break;
            }
            sum = 0;
        }
        return answer;
    }
    // 풀이2: 다른 사람 풀이 참고 개선(메모리: 83.3 MB, 시간: 0.02 ms)
    public int[] solution2(int num, int total) {
        int[] answer = new int[num];
        int mid = num % 2 == 0 ? total / num + 1 : total / num; // 중간값 찾기
        int start = mid - num / 2; // 시작 숫자는 중간값으로부터 연속된 num개의 중간 개수개를 뺀 숫자부터
        for(int i = 0; i < num; i++) {
            answer[i] = start + i;
        }
        return answer;
    }
}
