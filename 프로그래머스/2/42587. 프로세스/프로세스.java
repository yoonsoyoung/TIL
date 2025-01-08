import java.util.*;
class Solution {
    static class Process {
        int idx;
        int prior;
        Process(int idx, int prior) {
            this.idx = idx;
            this.prior = prior;
        }
    }
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Process> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < priorities.length; i++) {
            q.offer(new Process(i, priorities[i]));
            pq.offer(priorities[i]);
        }
        
        while(!q.isEmpty()) {
            Process np = q.poll();
            int nIdx = np.idx;
            int nPrior = np.prior;
            if(nPrior < pq.peek()) {
                q.offer(new Process(nIdx, nPrior));
            } else {
                answer++;
                if(nIdx == location) {
                    return answer;
                }
                pq.poll();
            }
        }
        return answer;
    }
}