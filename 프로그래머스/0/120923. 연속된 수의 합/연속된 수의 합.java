class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int mid = num % 2 == 0 ? total / num + 1 : total / num;
        int start = mid - num / 2;
        for(int i = 0; i < num; i++) {
            answer[i] = start + i;
        }
        return answer;
    }
}