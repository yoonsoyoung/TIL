class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        boolean[] isSelected = new boolean[4];
        isSelected[0] = true;
        
        for(int i = 1; i < 4; i++) {
            isSelected[i] = true;
            int a = 0;
            int b = 0;
            for(int j = 1; j < 4; j++) {
                if(!isSelected[j] && a == 0) {
                    a = j;
                } else if(!isSelected[j] && b == 0) {
                    b = j;
                }
            }
            double tanA = (double)(dots[0][1] - dots[i][1]) / (double)(dots[0][0] - dots[i][0]);
            double tanB = (double)(dots[a][1] - dots[b][1]) / (double)(dots[a][0] - dots[b][0]);
            if(tanA == tanB) {
                return 1;
            }
            isSelected[i] = false;
        }
        
        return answer;
    }
}