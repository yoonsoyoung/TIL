class Solution {
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
}