import java.util.*;
import java.io.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        // 자원 재정의 friends Map(key:name - value:idx)
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < friends.length; i++) {
            map.put(friends[i], i);
        }

        // 주고 받은 선물 관계
        int relations[][] = new int[friends.length][friends.length];
        // 개별 선물 지수
        int stats[][] = new int[friends.length][3]; // 0: 준 선물 수, 1: 받은 선물 수, 2: 받을 선물 수
        for(String gift : gifts) {
            String from = gift.split(" ")[0]; // 준 친구
            String to = gift.split(" ")[1]; // 받은 친구
            int fromIdx = map.get(from);
            int toIdx = map.get(to);

            relations[fromIdx][toIdx]++;
            stats[fromIdx][0]++;
            stats[toIdx][1]++;
        }
        
        for(int i = 0; i < relations.length; i++) {
            for(int j = 0; i != j && j < relations[i].length; j++) {
                if(relations[i][j] > relations[j][i]) { // 준 사람이 더
                    stats[i][2]++;
                } else if (relations[i][j] < relations[j][i]) { // 받은 사람이 더
                    stats[j][2]++;
                } else { // 같거나 주고 받지 않을 때
                    int iGift = stats[i][0] - stats[i][1];
                    int jGift = stats[j][0] - stats[j][1];
                    if(iGift > jGift) {
                        stats[i][2]++;
                    } else if (iGift < jGift) {
                        stats[j][2]++;
                    }
                }
            }
        }
        
        for(int[] a : stats) {
            answer = answer < a[2] ? a[2] : answer;
        }
        return answer;
    }
}