const input = require('fs').readFileSync('/dev/stdin', 'utf8').toString().split("\n").map((el) => el.split(" ").map(Number));
const n = input[0][0]; // 정점 수
const m = input[0][1]; // 간선 수
const connect = input.slice(1, m + 1);
const s = input[m + 1][0]; // 집
const t = input[m + 1][1]; // 회사

// 통과 0.651초 105.38MB 메모리 
let v1 = [...Array(n + 1)].fill(false);
let v2 = [...Array(n + 1)].fill(false);
let v3 = [...Array(n + 1)].fill(false);
let v4 = [...Array(n + 1)].fill(false);
let adjList = {};
let adjListR = {};
for(let i = 0; i <= n; i++) {
    adjList[i] = [];
    adjListR[i] = [];
}

for(let i = 0; i < m; i++) {
    let from = connect[i][0];
    let to = connect[i][1];
    adjList[from].push(to);
    adjListR[to].push(from);
}

// 1. s에서 출발
v1[t] = true;
dfs(s, adjList, v1);
// 2. s로 도착
dfs(s, adjListR, v2);
// 3. t에서 출발
v3[s] = true;
dfs(t, adjList, v3);
// 4. t로 도착
dfs(t, adjListR, v4);

let ans = 0;
for(let i = 0; i <= n; i++) {
    if(v1[i] && v2[i] && v3[i] && v4[i]) {
        ans++;
    }
}

console.log(ans - 2);

function dfs(start, route, visited) {
    // JS의 재귀 깊이제한을 고려하여 stack을 사용한 반복문 기반 DFS로 작성
    let stack = [start];
    while(stack.length > 0) {
        let v = stack.pop();
        if(visited[v]) {
            continue;
        }
    
        visited[v] = true;
        for(let next of route[v]) {
            stack.push(next); // java에서는 여기서 재귀호출 했음 dfs(next, route, visited)
        }
        
    }
}
