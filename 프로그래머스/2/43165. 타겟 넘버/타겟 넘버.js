function solution(numbers, target) {
    var answer = 0;
    
    function dfs(cnt, sum) {
        if(cnt === numbers.length) {
            if(sum === target) {
                answer++;
            }
            return;
        }
        
        dfs(cnt + 1, sum + numbers[cnt]);
        dfs(cnt + 1, sum - numbers[cnt]);
    }
    
    dfs(0, 0);
    return answer;
}