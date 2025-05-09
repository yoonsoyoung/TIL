const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split('\n').map((el) => el.split(' ').map(Number));
const [N, M, R] = input[0];
const conn = input.slice(1);

let adjList = Array.from({length: N+1}, () => []);
let visited = new Array(N+1).fill(false);
let res = new Array(N+1).fill(0);

conn.forEach((v, i) => {
    adjList[v[0]].push(v[1]);
    adjList[v[1]].push(v[0]);
});
adjList.forEach((r) => r.sort((a, b) => a - b));

function bfs(r) {
    let order = 1;
    let q = [];
    q.push(r);
    visited[r] = true;
    res[r] = order++;

    while(q.length > 0) {
        let curr = q.shift();

        for(let next of adjList[curr]) {
            if(!visited[next]) {
                q.push(next);
                visited[next] = true;
                res[next] = order++;
            }
        }
    }
}

bfs(R);
console.log(res.slice(1).join('\n'));
