const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split(' ').map(Number);
const N = input[0];
const M = input[1];

let output = '';
let selected = new Array(N+1).fill(false);
let res = [];

function perm(idx) {
    if(idx === M) {
        output += res.join(' ') + '\n';
        return;
    }

    for(let i = 1; i <= N; i++) {
        if(!selected[i]) {
            selected[i] = true;
            res.push(i);
            perm(idx + 1);
            selected[i] = false;
            res.pop();
        }
    }
}

perm(0);
console.log(output);
