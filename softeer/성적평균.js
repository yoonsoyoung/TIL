const fs = require('fs');
const input = fs.readFileSync('/dev/stdin', 'utf8').toString().trim().split('\n').map((el) => el.split(" ").map(Number));
const n = input[0][0];
const k = input[0][1];
const score = input[1];
const section = input.slice(2, 2 + k);

// 통과 0.292초 38.25MB 
let ans = [];
for(let [start, end] of section) {
    let sum = 0;
    for(let i = start - 1; i < end; i++) {
        sum += score[i];
    }
    ans.push((Math.round(sum / (end - start + 1) * 100) / 100).toFixed(2));
}
console.log(ans.join('\n'));
