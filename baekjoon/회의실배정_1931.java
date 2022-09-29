package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 통과 512ms
public class Main_1931 {

	static int N, ans;
	static int[][] time;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		time = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			time[i][0] = Integer.parseInt(st.nextToken()); // 시작
			time[i][1] = Integer.parseInt(st.nextToken()); // 끝
		}
		
		// 끝나는 시간 오름차순 = 내꺼-남의꺼
		Arrays.sort(time, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) { // 끝나는 시간 같음
					return o1[0] - o2[0]; // 더 먼저 시작
				} else {
					return o1[1] - o2[1]; // 더 먼저 끝
				}
			}
		});
		
		int currStart = time[0][0]; // 빨리 끝나는 회의 시작 시간
		int currEnd = time[0][1]; // 빨리 끝나는 회의 종료 시간
		ans = 1;
		for (int i = 1; i < N; i++) {
			// 다음 회의 시작 시간이 최근 회의의 종료시간과 같거나 이후
			if(time[i][0] >= currEnd) {
				currStart = time[i][0];
				currEnd = time[i][1];
				ans++;
			}
		}
		System.out.println(ans);
	}

}
