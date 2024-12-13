class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for(String str : babbling) {
            String s = str.replaceAll("aya|ye|woo|ma", "");
            if(s.length() == 0) {
                answer++;
            }
        }
        return answer;
    }
}