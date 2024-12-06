import java.util.*;
class Solution {
    public int solution(int a, int b) {
        b /= getGcd(a, b);
        
        // 유한소수 판별 2, 5로 소인수 분해
        while(b % 2 == 0) {
            b /= 2;
        }
        while(b % 5 == 0) {
            b /= 5;
        }
        
        // 위 소인수 분해 결과 몫이 1이 아니라면 무한소수
        return b == 1 ? 1 : 2;
    }
    
    // 유클리드 호제법 재귀
    public static int getGcd(int a, int b) {
        return b == 0 ? a : getGcd(b, a % b);
    }
}
