import java.util.*;
class Solution {
    static int size;
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        size = game_board.length;
        
        // 1. game_board의 도형 추출
        // 1-1. 추출 도형 정규화
        List<List<int[]>> bBlocks = findBlocks(game_board, 0);
        // 2. table의 도형 추출
        // 2-1. 추출 도형 정규화
        List<List<int[]>> tBlocks = findBlocks(table, 1);
        
        boolean[] tBlockUsed = new boolean[tBlocks.size()];
        // 3. 2-1 도형 회전해보며 1-1 리스트와 일치하는 도형 탐색
        // 3-1. 일치하는 도형은 두 도형의 좌표리스트가 동일
        // 4. 일치하면 해당 도형의 칸 수 답에 합산
        // 5. 해당 도형 사용처리
        for(List<int[]> bBlock : bBlocks) {
            for(int i = 0; i < tBlocks.size(); i++) {
                if(tBlockUsed[i]) continue; // 사용한 도형은 건너뛰기
                
                List<int[]> tBlock = tBlocks.get(i);
                if(bBlock.size() != tBlock.size()) continue; // 칸 수가 다르면 같은 도형일 확률 없음
                
                if(isMatch(bBlock, tBlock)) {
                    answer += bBlock.size();
                    tBlockUsed[i] = true;
                    break;
                }
            }
        }
        
        
        return answer;
    }
    
    // 도형들 추출
    /**
        map: 도형 찾을 바탕 2차원 배열
        standNum: 탐색 블럭 기준 숫자(game_board: 0, table: 1)
    */
    private static List<List<int[]>> findBlocks(int[][] map, int standNum) {
        List<List<int[]>> blocks = new ArrayList<>();
        boolean[][] visited = new boolean[map.length][map[0].length];
        
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(map[i][j] == standNum && !visited[i][j]) {
                    blocks.add(bfs(map, visited, i, j, standNum));
                }
            }
        }
        
        return blocks;
    }
    
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    // 도형 탐색
    /**
        map: 도형 찾을 바탕 2차원 배열
        visited: 탐색을 위한 방문처리 배열
        r, c: 탐색 시작 점 좌표
        standNum: 탐색 블럭 기준 숫자(game_board: 0, table: 1)
    */
    private static List<int[]> bfs(int[][] map, boolean[][] visited, int r, int c, int standNum) {
        List<int[]> points = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        
        q.offer(new int[]{r, c});
        visited[r][c] = true;
        
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int cr = curr[0];
            int cc = curr[1];
            points.add(curr);
            
            for(int d = 0; d < 4; d++) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];
                
                if(nr < 0 || nc < 0 || nr >= size || nc >= size)
                    continue;
                if(map[nr][nc] != standNum)
                    continue;
                if(visited[nr][nc])
                    continue;
                
                q.offer(new int[]{nr, nc});
                visited[nr][nc] = true;
            }
        }
        
        points = normalize(points);
        
        return points;
    }
    
    // 좌표 정규화 (0,0)에 가깝게 이동 후 좌표 순서 정렬
    private static List<int[]> normalize(List<int[]> points) {
        int minR = 987654321, minC = 987654321;
        for(int[] p : points) {
            minR = Math.min(minR, p[0]);
            minC = Math.min(minC, p[1]);
        }
        
        for(int[] p : points) {
            p[0] -= minR;
            p[1] -= minC;
        }
        
        // 좌표의 순서를 좌상->우하 방향으로 통일하기 위한 정렬
        points.sort((a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        return points;
    }
    
    /**
        base: board에서 추출한 도형(기준)
        target: table에서 추출한 도형(대상)
    */
    private static boolean isMatch(List<int[]> base, List<int[]> target) {
        List<int[]> rotated = target;
        
        for(int i = 0; i < 4; i++) { // 90도씩 돌려봄
            if(isSame(base, rotated)) {
                return true;
            }
            rotated = rotate90(rotated);
        }
        return false; // 360도 끝까지 돌렸으면 실패
    }
    
    // 좌표 일치 확인
    private static boolean isSame(List<int[]> b, List<int[]> t) {
        // 좌표를 정규화, 정렬을 시켜놨기 때문에 안 맞는 좌표가 발견되면 즉시 실패
        for(int i = 0; i < b.size(); i++) {
            if(b.get(i)[0] != t.get(i)[0] || b.get(i)[1] != t.get(i)[1]) {
                return false;
            }
        }
        return true;
    }
    
    private static List<int[]> rotate90(List<int[]> block) {
        List<int[]> rotated = new ArrayList<>();
        int maxR = 0; // 회전 후 음수가 될 수 있으므로 원좌표 최댓값을 기준으로 변환
        for(int[] p : block) {
            maxR = Math.max(maxR, p[0]);
        }
        
        for(int[] p : block) {
            rotated.add(new int[]{p[1], maxR - p[0]});
        }
        
        return normalize(rotated); // 회전 후 좌표 정규화
    }
}