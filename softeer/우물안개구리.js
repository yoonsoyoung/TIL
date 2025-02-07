const input = require('fs').readFileSync('/dev/stdin', 'utf8').trim().split('\n').map((el) => el.split(' ').map(Number));
const n = input[0][0];
const m = input[0][1];
const weight = input[1];
const adj = input.slice(2);

// 통과 0.232초 58.56MB 메모리
let strong = Array.from({length: n}).fill(true);
let ans = 0;
for(let [...a] of adj) {
    let curr = a[0] - 1;
    let next = a[1] - 1;
    if(weight[curr] < weight[next]) {
        strong[curr] = false;
    } else if (weight[curr] > weight[next]) {
        strong[next] = false;
    } else {
        strong[curr] = strong[next] = false;
    }
}

for(let i = 0; i < n; i++) {
    if(strong[i]) {
        ans++;
    }
}

console.log(ans);
