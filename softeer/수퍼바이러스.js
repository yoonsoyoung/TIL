const [k, p, n] = require('fs').readFileSync('/dev/stdin', 'utf8').trim().split(' ').map(BigInt); // 큰 수를 다루기 때문에 BigInt로 변환
const mod = 1000000007n;

// 통과 0.047초 6.99MB 메모리

// p^(n * 10) * k
let ans = (power(p, n * 10n) * k) % mod;
console.log(ans.toString()); // 정수는 모두 끝에 'n'을 붙여 BigInt형으로 맞춰야 계산 가능(BigInt, Number 혼합 계산 안됨)

// 분할 정복 활용 제곱승 구하기(재귀 대신 반복문)
function power(a, b) {
    let result = 1n;
    let base = a;

    while(b > 0n) { // 10^17승까지 커질 수 있으므로 재귀는 stack overflow 가능 -> 반복문으로 변환
        if(b % 2n === 1n) {
            result = (result * base) % mod;
        }
        base = (base * base) % mod;
        b = b / 2n;
    }
    return result;    
}
