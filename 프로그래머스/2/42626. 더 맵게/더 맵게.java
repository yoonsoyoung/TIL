import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int n : scoville) {
            pq.offer(n);
        }
        
        while(pq.size() > 1) {
            if(pq.peek() >= K) { // 가장 최소값이 스코빌 지수 이상이면 그 뒤 요소는 모두 해당
                return answer;
            }
            
            int first = pq.poll();
            int second = pq.poll();
            int nk = first + (second * 2);
            pq.offer(nk);
            answer++;
        }
        
        if(answer < 1 || pq.peek() < K) {
            answer = -1;
        }
        return answer;
    }
}