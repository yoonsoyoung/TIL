import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 통과 108ms
public class 로봇청소기_14503_Main {
/*
 > return 57
11 10
7 4 0
1 1 1 1 1 1 1 1 1 1
1 0 0 0 0 0 0 0 0 1
1 0 0 0 1 1 1 1 0 1
1 0 0 1 1 0 0 0 0 1
1 0 1 1 0 0 0 0 0 1
1 0 0 0 0 0 0 0 0 1
1 0 0 0 0 0 0 1 0 1
1 0 0 0 0 0 1 1 0 1
1 0 0 0 0 0 1 1 0 1
1 0 0 0 0 0 0 0 0 1
1 1 1 1 1 1 1 1 1 1

 > return 5
4 5
2 2 0
1 1 1 1 1
1 0 0 0 1
1 1 0 0 1
1 1 1 1 1

 > return 4
4 5
2 2 3
1 1 1 1 1
1 1 0 0 1
1 0 0 0 1
1 1 1 1 1
 */
	static int N, M, R, C, D, map[][];
	static class Robot{
		int r, c, d;
		Robot(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(cleanUp(R, C, D));
	}
	
	// 0:북, 1:동, 2:남, 3:서
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	public static int cleanUp(int sr, int sc, int sd) {
		int res = 1; // 첫 진입 칸은 청소를 하고 간다
		map[sr][sc] = 2;
		Queue<Robot> q = new LinkedList<Robot>();
		q.offer(new Robot(sr, sc, sd));
		
		while(!q.isEmpty()) {
			Robot curr = q.poll();
			int cr = curr.r;
			int cc = curr.c;
			int cd = curr.d;
			
			boolean isBack = true; // 후진 플래그값
			for(int d = 3; d >= 0; d--) {
				// 반시계 90도로 회전
				int nd = (cd + d) % 4;
				int nr = cr + dr[nd];
				int nc = cc + dc[nd];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;
				if(map[nr][nc] == 1)
					continue;
				if(map[nr][nc] == 0) {
					q.add(new Robot(nr, nc, nd));
					map[nr][nc] = 2;
					res++;
					isBack = false;
					break;
				}
			}
			
			// 사방 청소되지 않은 빈칸이 없는 경우 현재 방향으로 후진
			if(isBack) {
				int nr = cr - dr[cd];
				int nc = cc - dc[cd];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;
				if(map[nr][nc] == 1)
					continue;
				q.add(new Robot(nr, nc, cd));
			}
		}
		
		return res;
	}

}
