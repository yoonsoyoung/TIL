function solution(tickets) {
    var answer = [];
    let routes = [];
    let selected = Array(tickets.length).fill(false);
    
    function dfs(cnt, now, route) {
        if(cnt == tickets.length) {
            routes.push(route);
            return;
        }
        
        for(let i = 0; i < tickets.length; i++) {
            let next = tickets[i][1];
            if(!selected[i] && now === tickets[i][0]) {
                selected[i] = true;
                dfs(cnt + 1, next, route + ',' + next);
                selected[i] = false;
            }
        }
    }
    
    dfs(0, 'ICN', 'ICN');
    routes.sort();
    answer = routes[0].split(',');
    return answer;
}