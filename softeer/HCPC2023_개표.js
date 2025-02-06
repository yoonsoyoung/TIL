const fs = require('fs');
let input = fs.readFileSync('/dev/stdin', 'utf8').trim().split('\n').map(Number);
const [t, ...n] = input;

let ans = [];
for(let vote of n) {
    let str = "++++ ".repeat(vote/5) + "|".repeat(vote%5);
    ans.push(str.trim());
}
console.log(ans.join('\n'));
