function solution(k, dungeons) {
    var answer = -1;
    let visited = Array(dungeons.length).fill(false);
    
    function dfs(idx, cnt) {
        answer = Math.max(answer, cnt);
        for(let i = 0; i < dungeons.length; i++) {
            if(!visited[i] && (k >= dungeons[i][0])) {
                visited[i] = true;
                k -= dungeons[i][1];
                
                dfs(idx + 1, cnt + 1);
                
                // 복구
                visited[i] = false;
                k += dungeons[i][1];
            }
        }
    }
    
    dfs(0, 0);
    return answer;
}