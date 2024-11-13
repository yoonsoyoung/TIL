// 통과
class Solution {
    public int solution(int price) {
        int answer = 0;
        float discount = 1.0f;
        
        if(price >= 500000) {
            discount = 0.8f;
        } else if(price >= 300000) {
            discount = 0.9f;
        } else if(price >= 100000) {
            discount = 0.95f;
        }
        
        answer = (int)(price * discount);
        return answer;
    }
}
