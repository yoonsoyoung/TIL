const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split('\n').map((el) => el.split(' ').map(Number));
let N = input[0][0]; // map 크기
let M = input[0][1]; // 포자 수
let K = input[0][2]; // 연결 수
let map = input.slice(1);
let area = Array(N * N + 1).fill(0); // 인접한 구역별 칸 수 관리

const dr = [-1, 1, 0, 0];
const dc = [0, 0, -1, 1];

// 자원 재정의
map.forEach((row, i) => {
   row.forEach((v, j) => {
       if(v === 1) {
           map[i][j] = -1;
       }
    });
});

let cnt = 0;
map.forEach((row, i) => {
    row.forEach((v, j) => {
        if(v === 0) {
            dfs(i, j, ++cnt);
        }
    });
});

let needs = 0; // 필요한 포자 수
area.forEach((v, i) => {
    if(v > 0) {
        needs += (area[i] % K === 0 ? area[i] / K : area[i] / K + 1);
    }
});

if(cnt > 0 && M >= needs) {
    // cnt > 0: 최소 하나라도 포자를 사용해야 함 조건 체크
    // M >= needs: 가지고 있는 포자 수 내에 필요한 포자 수 가능 체크
    console.log('POSSIBLE');
    console.log(M - needs);
} else {
    console.log('IMPOSSIBLE');
}

function dfs(r, c, idx) {
    map[r][c] = idx; // map 원본에 구역 인덱스 표기
    area[idx]++; // 해당 구역 인덱스 칸 수 증가

    for(let d = 0; d < 4; d++) {
        let nr = r + dr[d];
        let nc = c + dc[d];

        if(nr < 0 || nc < 0 || nr >= N || nc >= N)
            continue;
        if(map[nr][nc] === 0) { // 0이 아닌 구역은 불가지역이거나 탐색된(인덱스 표기)구역
            dfs(nr, nc, idx);
        }
    }
}