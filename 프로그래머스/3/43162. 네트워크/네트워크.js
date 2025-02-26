function solution(n, computers) {
    var answer = 0;
    let visited = Array(n).fill(false);
    
    for(let i = 0; i < n; i++) {
        if(!visited[i]) {
            dfs(i);
            answer++;
        }
    }
    
    function dfs(idx) {
        visited[idx] = true;
        
        for(let i = 0; i < n; i++) {
            if(computers[idx][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(i);
            }
        }
    }
    return answer;
}