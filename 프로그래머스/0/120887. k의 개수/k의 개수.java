class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        for(int n = i; n <= j; n++) {
            sb.append(String.valueOf(n));
        }
        String str = sb.toString();
        answer = str.length() - str.replace(String.valueOf(k), "").length();
        return answer;
    }
}