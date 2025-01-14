import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> truck = new LinkedList<>(); // 다리를 건너는 트럭 관리
        Queue<Integer> bridge = new LinkedList<>(); // 시간 별 다리 상태 관리
        for(int t : truck_weights) {
            truck.offer(t);
        }
        for(int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }
        
        int cumulWeight = 0; // 누적 무게
        while(!bridge.isEmpty()) {
            answer++;
            cumulWeight -= bridge.poll();
            
            if(!truck.isEmpty()) {
                int t = truck.peek();
                if(cumulWeight + t <= weight) { // 건널 수 있음
                    bridge.offer(truck.poll());
                    cumulWeight += t;
                } else {
                    bridge.offer(0);
                }
            }
            
        }
        return answer;
    }
}