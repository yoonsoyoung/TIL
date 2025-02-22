function solution(answers) {
    var answer = [];
    const one = [1,2,3,4,5];
    const two = [2,1,2,3,2,4,2,5];
    const three = [3,3,1,1,2,2,4,4,5,5];
    let cnt = Array(3).fill(0);
    let max = 0;
    
    for(let i = 0; i < answers.length; i++) {
        if(one[i % one.length] === answers[i]) {
            cnt[0]++;
        }
        
        if(two[i % two.length] === answers[i]) {
            cnt[1]++;
        }
        
        if(three[i % three.length] === answers[i]) {
            cnt[2]++;
        }
    }
    
    max = Math.max(...cnt);
    cnt.forEach((v, i) => {
        if(v === max) {
            answer.push(i + 1);
        }
    });
    
    answer.sort((a, b) => a - b);
    return answer;
}