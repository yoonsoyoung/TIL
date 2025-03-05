function solution(begin, target, words) {
    var answer = 0;
    
    class Word {
        constructor(word, cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }
    
    function bfs() {
        let selected = Array(words.length).fill(false);
        let q = [];
        q.push(new Word(begin, 0));
        
        while(q.length > 0) {
            let curr = q.shift();
            let now_w = curr.word;
            let now_cnt = curr.cnt;
            
            if(now_w === target) {
                return now_cnt;
            }
            
            for(let i = 0; i < words.length; i++) {
                let diffCnt = 0;
                for(let j = 0; j < words[i].length; j++) {
                    if(now_w.charAt(j) !== words[i].charAt(j)) {
                        diffCnt++;
                    }
                    
                    if(diffCnt > 1) {
                        break;
                    }
                }
                
                if(!selected[i] && diffCnt === 1) {
                    selected[i] = true;
                    q.push(new Word(words[i], now_cnt + 1));
                }
                
                diffCnt = 0;
            }
        }
        return 0;
    }
    
    answer = bfs();
    return answer;
}