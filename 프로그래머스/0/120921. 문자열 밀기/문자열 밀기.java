class Solution {
    public int solution(String A, String B) {
        int answer = 0;
        if(!B.equals(A)) {
            for(int i = 0; i < A.length(); i++) {
                A = A.charAt(A.length() - 1) + A.substring(0, A.length() - 1);
                if(B.equals(A)) {
                    return i + 1;
                }
            }
            return -1;
        }
        return answer;
    }
}