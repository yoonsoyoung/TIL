class Solution {
    public int solution(String s) {
        int answer = 0;
        if("-".equals(s.substring(0))) {
            answer = Integer.parseInt(s.substring(0, s.length())) * -1;
        } else if("+".equals(s.substring(0))) {
            answer = Integer.parseInt(s.substring(0, s.length()));
        } else {
            answer = Integer.parseInt(s);
        }
        return answer;
    }
}