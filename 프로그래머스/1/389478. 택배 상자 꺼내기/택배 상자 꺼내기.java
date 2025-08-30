import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int h = n % w == 0 ? n/w : n/w +1;
        int[][] box = new int[h][w];
        
        // 상자 쌓기
        int no = 1;
        for(int i = 0; i < box.length; i++) {
            if(i % 2 == 0) {
                for(int j = 0; j < box[i].length; j++) {
                    box[i][j] = no++;
                    if(no > n) break;
                }
            } else {
                for(int j = w - 1; j >= 0; j--) {
                    box[i][j] = no++;
                    if(no > n) break;
                }
            }
        }
        
        // 상자 꺼내기
        boolean isFind = false;
        int findC = 0;
        for(int i = 0; i < box.length; i++) {
            if(isFind) {
                answer = box[i][findC] > 0 ? answer+1 : answer;
            } else {
                for(int j = 0; j < box[i].length; j++) {
                    if(box[i][j] == num) {
                        isFind = true;
                        findC = j;
                    }
                }
            }
            
        }
        
        return answer + 1;
    }
}