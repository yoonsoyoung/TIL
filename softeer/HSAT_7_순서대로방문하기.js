const input = require('fs').readFileSync('/dev/stdin', 'utf8').toString().trim().split("\n").map((el) => el.split(" ").map(Number));
const n = input[0][0];
const m = input[0][1];
const map = input.slice(1, n + 1);
const point = input.slice(n + 1, input.length);
let reqPoint = point.map(pair => pair.map(num => num - 1));

// 통과 0.048초 7.57MB 메모리
const dr = [-1, 1, 0, 0];
const dc = [0, 0, -1, 1];
let visited = Array.from({length: n}, () => Array(n).fill(false));
let ans = 0;
console.log(dfs(reqPoint[0][0], reqPoint[0][1], 0));

function dfs(r, c, idx) {
    if(r === reqPoint[idx][0] && c === reqPoint[idx][1]) {
        if(idx === m - 1) {
            ans++;
            return;
        }
        idx++;
    }

    visited[r][c] = true;
    for(let d = 0; d < 4; d++) {
        let nr = r + dr[d];
        let nc = c + dc[d];

        if(nr < 0 || nc < 0 || nr >= n || nc >= n)
            continue;
        if(map[nr][nc] === 1 || visited[nr][nc])
            continue;
        
        dfs(nr, nc, idx);
    }
    visited[r][c] = false;
    return ans;
}
