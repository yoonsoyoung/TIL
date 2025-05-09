const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split(' ').map(Number);
const N = input[0];
const M = input[1];

let output = '';
let res = [];

function combi(idx, start) {
    if (idx === M) {
        for (let i = 0; i < M; i++) {
            output += res[i] + ' ';
        }
        output += '\n';
        return;
    }

    for (let i = 1; i <= N; i++) {
        if (i >= start) { // 비내림차순 위함
            res[idx] = i;
            combi(idx + 1, i);
        }
    }

}
    combi(0, 1);
    console.log(output);