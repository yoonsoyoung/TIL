const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split('\n').map((el) => el.split(' ').map(Number));
const [N, D] = input[0];
const route = input.slice(1);
let dp = Array.from({length: D + 1}, (v, i) => i);

for(let i = 1; i <= D; i++) {
    dp[i] = Math.min(dp[i], dp[i-1] + 1);
    route.forEach((v, j) => {
       if(i === route[j][1]) {
           dp[i] = Math.min(dp[i], dp[route[j][0]] + route[j][2]);
       }
    });
}
console.log(dp[D]);