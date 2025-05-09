const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split('\n').map((el) => el.split(' ').map(Number));
const N = input[0][0];
const M = input[0][1];
const arr = input[1].slice();

let out = '';
let res = [];

arr.sort((a, b) => a - b);

function reperm(idx) {
    if(idx === M) {
        for(let i = 0; i < M; i++) {
            out += res[i] + ' ';
        }
        out += '\n';
        return;
    }

    for(let i = 0; i < N; i++) {
        res[idx] = arr[i];
        reperm(idx + 1);
    }
}

reperm(0);
console.log(out);