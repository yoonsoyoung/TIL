const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split('\n').map((el) => el.split(' ').map(Number));
const N = input[0][0];
const M = input[0][1];
const arr = input[1].slice();

let out = '';
let selected = new Array(N).fill(false);

arr.sort((a, b) => a - b);

function combi(cnt, idx) {
    if(cnt === M) {
        for(let i = 0; i < N; i++) {
            if(selected[i]) {
                out += arr[i] + ' ';
            }
        }
        out += '\n';
        return;
    }

    for(let i = idx; i < N; i++) {
        if(!selected[i]) {
            selected[i] = true;
            combi(cnt + 1, i + 1);
            selected[i] = false;
        }
    }
}

combi(0, 0);
console.log(out);