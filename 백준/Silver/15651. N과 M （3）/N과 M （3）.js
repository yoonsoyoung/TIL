const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split(' ').map(Number);
const N = input[0];
const M = input[1];

let output = '';
let selected = new Array(N + 1).fill(false);
let res = [];

function reperm(idx) {
    if(idx === M) {
        for(let i = 0; i < M; i++) {
            output += res[i] + ' ';
        }
        output += '\n';
        return;
    }

    for(let i = 1; i <= N; i++) {
        res[idx] = i;
        reperm(idx + 1);
    }
}

reperm(0);
console.log(output);