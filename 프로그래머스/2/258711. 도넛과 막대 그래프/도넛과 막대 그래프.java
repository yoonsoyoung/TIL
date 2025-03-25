import java.util.*;
class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4]; // 0: 생성 정점 번호, 1: 도넛, 2: 막대, 3: 8자
        Map<Integer, int[]> nodes = new HashMap<>(); // [0]: 출발 간선 수, [1]: 도착 간선 수
        
        int max = 0;
        for(int[] e : edges) {
            int from = e[0];
            int to = e[1];
            nodes.computeIfAbsent(from, k -> new int[]{0, 0})[0]++;
            nodes.computeIfAbsent(to, k -> new int[]{0, 0})[1]++;
            max = Math.max(max, nodes.get(from)[0]);
        }
        
        // 생성 정점: 출발 간선 수 = 총 그래프 수, 도착 간선 = 0
        // 막대 그래프: (단말 노드 기준) 출발 간선 수 = 0, 도착 간선 > 0
        // 8자 그래프: (중앙 노드 기준) 출발 간선 수 = 2, 도착 간선 수 >= 2
        // 도넛 그래프: 막대의 중간 노드와 혼돈있을 수 있으니 전체 그래프 수 - 막대 - 8자
        for(int k : nodes.keySet()) {
            int out = nodes.get(k)[0];
            int in = nodes.get(k)[1];
            if(out == max && in == 0) { // 생성 정점
                answer[0] = k;
            } else if (out == 0 && in > 0) { // 막대
                answer[2]++;
            } else if (out == 2 && in >= 2) { // 8자
                answer[3]++;
            }
        }
        answer[1] = max - answer[2] - answer[3];
        return answer;
    }
}