const input = require('fs').readFileSync('/dev/stdin', 'utf8').replace(/\n+/g, '\n').trim().split('\n');
const num = input[0].split(' ').map(Number);
const n = num[0];
const q = num[1];
const fuel = input[1].trim().split(' ').map(Number).sort((a, b) => a - b); // 그냥 sort()만 하면 문자열로 정렬됨.
const medians = input.slice(2).map(Number);

// 통과 0.268초 72.86MB 메모리
let res = [];
for(let m of medians) {
    let ans = 0;
    let medIdx = binarySearch(0, n - 1, m);
    if(medIdx > 0) {
        ans = medIdx * (n - medIdx - 1);
    }
    res.push(ans);
}
console.log(res.join('\n'));

function binarySearch(left, right, target) {
    let mid = 0;
    while(left < right) {
        mid = Math.floor((left + right) / 2);
        if(fuel[mid] == target) {
            return mid;
        } else if(fuel[mid] < target) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }
    return -1;
}
