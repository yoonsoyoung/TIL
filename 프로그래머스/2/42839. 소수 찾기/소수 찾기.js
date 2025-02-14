let answer = 0;
let result = new Set(); // 중복 방지 set
function solution(numbers) {
    let numArr = numbers.split("").map(Number);
    let selected = Array(numArr.length).fill(false);
    perm([], selected, numArr);
    result.forEach((v, i) => {
        if(isPrime(v)) {
            answer++;
        }
    })
    return answer;
}

// 순열
function perm(arr, selected, origin) {
    if(arr.length > 0) {
        result.add(parseInt(arr.join("")));
    }
    
    for(let i = 0; i < origin.length; i++) {
        if(!selected[i]) {
            selected[i] = true;
            arr.push(origin[i]);
            perm(arr, selected, origin);
            arr.pop();
            selected[i] = false;
        }
    }
    
}

// 소수 판별
function isPrime(num) {
    if(num <= 1) return false;
    if(num % 2 === 0) return num === 2 ? true : false; // 짝수 중 유일한 소수는 2
    
    const sqrt = parseInt(Math.sqrt(num));
    for(let i = 3; i <= sqrt; i++) {
        if(num % i === 0) { // 중간에 나눠지는 경우가 생기면 소수가 아님
            return false;
        }
    }
    return true;
}