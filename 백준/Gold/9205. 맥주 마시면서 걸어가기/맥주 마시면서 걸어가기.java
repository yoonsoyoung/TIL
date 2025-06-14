import java.io.*;
import java.util.*;

public class Main {

	static int t, n, homeX, homeY, rockX, rockY, stores[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		t = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < t; tc++) {
			n = Integer.parseInt(br.readLine()); // 편의점 개수
			st = new StringTokenizer(br.readLine(), " ");
			
			homeX = Integer.parseInt(st.nextToken());
			homeY = Integer.parseInt(st.nextToken());
			stores = new int[n][2];
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int storeX = Integer.parseInt(st.nextToken());
				int storeY = Integer.parseInt(st.nextToken());
				stores[i][0] = storeX;
				stores[i][1] = storeY;
			}
			st = new StringTokenizer(br.readLine(), " ");
			rockX = Integer.parseInt(st.nextToken());
			rockY = Integer.parseInt(st.nextToken());
			
			// 20병 * 50m => 최대 1000m 이동 가능
			boolean isPossible = bfs();
			sb.append(isPossible ? "happy" : "sad").append("\n");
			
		}
		
		System.out.println(sb.toString());

	}
	
	public static boolean bfs() {
		boolean visited[] = new boolean[n];
		Queue<int[]> q = new LinkedList<>();
		
		// 집에서부터 출발
		q.offer(new int[] {homeX, homeY});

		while(!q.isEmpty()) {
			int now[] = q.poll();
			int x = now[0];
			int y = now[1];
			
            // 현재 위치에서 바로 페스티벌 도착 가능
            if(Math.abs(x - rockX) + Math.abs(y - rockY) <= 1000) {
                return true;
            }
            
			for(int i = 0; i < n; i++) {
				int nx = stores[i][0];
				int ny = stores[i][1];
				
				// 안 갔던 편의점이고 들리기 가능
				if(!visited[i] && (Math.abs(x - nx) + Math.abs(y - ny) <= 1000)) {
					q.offer(new int[] {nx, ny});
					visited[i] = true;
				}
				
			}
		}
		
		return false;
	}

}