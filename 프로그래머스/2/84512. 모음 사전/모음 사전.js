function solution(word) {
    var answer = 0;
    const alpha = ['A', 'E', 'I', 'O', 'U'];
    let cnt = 0;
    // A, AA, AAA, AAAA
    // AAAAA, AAAAE, AAAAI, AAAAO, AAAAU
    // AAAE, AAAEA, AAAEE, AAAEI, AAAEO, AAAEU
    // AAAI, AAAIA, AAAIE, AAAII, AAAIO, AAAIU
    
    dfs('');
    
    function dfs(str) {
        if(str === word) return true;
        if(str.length >= 5) return false;
        
        for(let i = 0; i < alpha.length; i++) {
            str += alpha[i];
            cnt++;
            if(dfs(str)) {
                answer = cnt;
                return;
            }
            str = str.slice(0, str.length - 1);
        }
        
        return false;
    }
    
    return answer;
}