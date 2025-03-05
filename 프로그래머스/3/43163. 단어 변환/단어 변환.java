import java.util.*;
class Solution {
    static class Word {
        String word;
        int cnt;
        public Word(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        answer = bfs(begin, target, words);
        return answer;
    }
    
    private static int bfs(String begin, String target, String[] words) {
        boolean selected[] = new boolean[words.length];
        Queue<Word> q = new LinkedList<>();
        q.offer(new Word(begin, 0));
        
        while(!q.isEmpty()) {
            Word curr = q.poll();
            String n_word = curr.word;
            int n_cnt = curr.cnt;
            
            if(n_word.equals(target)) {
                // 3. 이때까지의 cnt 리턴
                return n_cnt;
            }
            
            for(int i = 0; i < words.length; i++) {
                // 1. n_word와 현재 words의 글자수 차이가 1인지 체크
                int diffCnt = 0;
                for(int j = 0; j < words[i].length(); j++) {
                    if(n_word.charAt(j) != words[i].charAt(j)) {
                        diffCnt++;
                    }
                    
                    if(diffCnt > 1) {
                        break;
                    }
                }
                // 2. 현재 인덱스가 selected 되지 않으면서 1에 해당되면
                if(!selected[i] && diffCnt == 1) {
                    // 2-1. 해당 인덱스 선택 처리, words와 cnt+1 큐 삽입
                    selected[i] = true;
                    q.offer(new Word(words[i], n_cnt + 1));
                }
                diffCnt = 0;
            }
        }
        
        return 0;
    }
}