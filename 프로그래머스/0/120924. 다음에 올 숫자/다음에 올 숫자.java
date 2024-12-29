class Solution {
    public int solution(int[] common) {
        int answer = 0;
        int midIdx = common.length / 2;
        int prev = common[midIdx] - common[midIdx - 1];
        int next = common[midIdx + 1] - common[midIdx];
        if(prev == next) {
            answer = common[common.length - 1] + prev;
        } else {
            answer = common[common.length - 1] * (next / prev);
        }
        return answer;
    }
}