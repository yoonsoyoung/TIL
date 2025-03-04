function solution(maps) {
    var answer = 0;
    
    class Robot {
        constructor (r, c, cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
    
    const dr = [-1, 1, 0, 0];
    const dc = [0, 0, -1, 1];
    function bfs() {
        const n = maps.length - 1;
        const m = maps[0].length - 1;
        let visited = Array.from({length: n + 1}, () => Array(m + 1).fill(false));
        let q = [];
        
        q.push(new Robot(0, 0, 1));
        visited[0][0] = true;
        
        while(q.length !== 0) {
            let curr = q.shift();
            
            if(curr.r === n && curr.c === m) {
                return curr.cnt;
            }
            
            for(let d = 0; d < 4; d++) {
                let nr = curr.r + dr[d];
                let nc = curr.c + dc[d];
                let cnt = curr.cnt;
                
                if(nr < 0 || nc < 0 || nr > n || nc > m )
                    continue;
                if(maps[nr][nc] !== 0 && !visited[nr][nc]) {
                    q.push(new Robot(nr, nc, cnt+1));
                    visited[nr][nc] = true;
                }
            }
        }
        
        return -1;
    }
    
    answer = bfs();
    return answer;
}