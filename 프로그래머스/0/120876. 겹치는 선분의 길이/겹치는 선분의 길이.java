class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        int[] width = new int[201];
        for(int[] arr : lines) {
            for(int n = arr[0]; n < arr[1]; n++) {
                width[n + 100]++;
            }
        }
        
        for(int cnt : width) {
            if(cnt > 1) {
                answer++;
            }
        }
        return answer;
    }
}