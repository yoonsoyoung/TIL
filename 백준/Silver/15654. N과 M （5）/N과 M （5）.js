const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split('\n').map((el) => el.split(' ').map(Number));
const N = input[0][0];
const M = input[0][1];
const arr = input[1].slice();

let output = '';
let selected = new Array(N).fill(false);
let res = [];

arr.sort((a, b) => a - b);
function perm(idx) {
    if(idx === M) {
        for(let i = 0; i < M; i++) {
            output += res[i] + ' ';
        }
        output += '\n';
        return;
    }

    for(let i = 0; i < N; i++) {
        if(!selected[i]) {
            selected[i] = true;
            res.push(arr[i]);
            perm(idx + 1);
            selected[i] = false;
            res.pop();
        }
    }
}

perm(0);
console.log(output);