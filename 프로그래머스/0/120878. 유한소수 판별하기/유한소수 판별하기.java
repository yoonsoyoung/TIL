import java.util.*;
class Solution {
    public int solution(int a, int b) {
        int answer = 1;
        int gcd = getGcd(a, b); // 최대공약수
        a /= gcd;
        b /= gcd;
        
        for(int i = 2; i <= 5; i+=3) { // 유한소수 판별 2, 5로 소인수 분해
            while(b % i == 0) {
                b /= i;
            }
        }
        
        if(b != 1) answer = 2; // 위 소인수 분해 결과 몫이 1이 아니라면 무한소수
        return answer;
    }
    
    public static int getGcd(int a, int b) {
        int remain = 1;
        int max = a > b ? a : b;
        int min = a < b ? a : b;
        while(true) {
            remain = max % min;
            if(remain == 0) {
                return min;
            }
            max = min;
            min = remain;
        }
    }
}