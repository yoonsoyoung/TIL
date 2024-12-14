class Solution {
    public int solution(String before, String after) {
        int answer = 1;
        for(char c : before.toCharArray()) {
            int befCharCnt = before.length() - before.replace(String.valueOf(c), "").length();
            int aftCharCnt = after.length() - after.replace(String.valueOf(c), "").length();
            if(befCharCnt != aftCharCnt) {
                return 0;
            }
        }
        return answer;
    }
}