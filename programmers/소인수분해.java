import java.util.*;
class Solution {
    public int[] solution(int n) {
        Set<Integer> prime = new HashSet<>();
        for(int i = 2; i <= Math.sqrt(n); i++) {
            while(n % i == 0) {
                prime.add(i);
                n /= i;
            }
        }
        if(n != 1) { // 위 소인수분해를 거쳤는데 n 이 1이 아니라면 분해하지 못한 자체가 소수임
            prime.add(n);
        }
        return prime.stream().mapToInt(Integer::intValue).sorted().toArray(); // hashSet은 순서보장이 안되므로 sorted()를 통해 정렬해줌
    }
}
