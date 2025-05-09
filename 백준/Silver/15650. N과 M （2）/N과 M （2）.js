const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split(' ').map(Number);
const N = input[0];
const M = input[1];

let output = '';
let selected = new Array(N + 1).fill(false);

function combi(idx, cnt) {
    if(cnt === M) {
        for(let i = 1; i <= N; i++) {
            if(selected[i]) {
                output += i + ' ';
            }
        }
        output += '\n';
    }

    for(let i = idx; i <= N; i++) {
        if(!selected[i]) {
            selected[i] = true;
            combi(i+1, cnt+1);
            selected[i] = false;
        }
    }
}

combi(1, 0);
console.log(output);