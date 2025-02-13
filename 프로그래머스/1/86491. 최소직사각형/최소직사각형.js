function solution(sizes) {
    var answer = 99999999;
    sizes.sort((a, b) => {
        if(a[0] === b[0]) {
            return b[1] - a[1];
        }
        return b[0] - a[0];
    });
    let w = 0;
    let h = 0;
    for(let i = 0; i < sizes.length; i++) {
        let nowW = sizes[i][0];
        let nowH = sizes[i][1];
        w = Math.max(w, nowW < nowH ? nowW : nowH);
        h = Math.max(h, nowW < nowH ? nowH : nowW);
    }
    
    answer = w * h;
    return answer;
}