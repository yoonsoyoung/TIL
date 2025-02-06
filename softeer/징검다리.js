const fs = require('fs');
const input = fs.readFileSync('/dev/stdin', 'utf8').toString().trim().split('\n').map((el) => el.split(" ").map(Number));
const n = input[0][0];
const stone = input[1];
var lis = [];

lis[0] = stone[0];
let len = 1;
for(let i = 1; i < n; i++) {
    if(lis[len - 1] < stone[i]) {
        lis[len++] = stone[i];
    } else {
        let pos = lisBinarySearch(0, len - 1, stone[i]);
        lis[pos] = stone[i];
    }
}

console.log(len);

function lisBinarySearch(left, right, target) {
    let mid = 0;
    while(left < right) {
        mid = (left + right) >> 1; // 자바스크립트의 '/' 연산이 소숫점으로 반환됨 -> 정수로 변환하기 위해 비트연산 또는 Math.floor((left + right) / 2)
        if(lis[mid] < target) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }
    return right;
}
