function solution(brown, yellow) {
    var answer = [];
    for(let i = 1; i * i <= yellow; i++) { // yellow의 약수를 구함, i*i -> 제곱근 만큼만
        if(yellow % i === 0) {
            let width = yellow / i;
            let height = i;
            if((width + height) * 2 + 4 === brown) {
                answer.push(width + 2, height + 2);
                break;
            }
        }
    }
    return answer;
}