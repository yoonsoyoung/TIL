import java.util.*;
class Solution {
    public int solution(int n) {
        // 풀이1.
        /*
        int sqrt = (int)Math.sqrt(n);
        return sqrt * sqrt == n ? 1 : 2;
        */
        
        // 풀이2.
        return n % Math.sqrt(n) == 0 ? 1 : 2;
    }
}
