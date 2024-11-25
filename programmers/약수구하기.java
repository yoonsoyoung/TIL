import java.util.*;
class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        // 풀이1
        /*
        for(int i = 1; i <= Math.sqrt(n); i++) {
              if(n == 1) {
                  list.add(n);
                  break;
              } 
              if(n % i == 0) {
                  list.add(i);
                  list.add(n / i);
              }
          }
          return list.stream().sorted().distinct().mapToInt(Integer::intValue).toArray();
        */

        // 풀이2
        for(int i = 1; i <= n/2; i++) { 
            if(n % i == 0) {
                list.add(i);
            }
        }
        list.add(n);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
