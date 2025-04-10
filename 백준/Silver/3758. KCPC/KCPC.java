import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken()); // 팀 개수
			int k = Integer.parseInt(st.nextToken()); // 문제 개수
			int t = Integer.parseInt(st.nextToken()); // 팀 id
			int m = Integer.parseInt(st.nextToken()); // 로그 개수
			
			int[][] team = new int[n+1][4]; // [0]:id,[1]:cnt,[2]:total,[3]:ltime
			int[][] ans = new int[n+1][k+1]; // 팀 별 문제 득점 관리
			for(int r = 1; r <= n; r++) {
				team[r][0] = r;
			}
			
			for(int e = 0; e < m; e++) {
				st = new StringTokenizer(br.readLine(), " ");
				int i = Integer.parseInt(st.nextToken()); // id
				int j = Integer.parseInt(st.nextToken()); // 문제 번호
				int s = Integer.parseInt(st.nextToken()); // 점수
				team[i][1]++; // 제출 횟수 증가
				team[i][3] = e + 1; // 마지막 제출 시간 갱신
				if(ans[i][j] <= s) { // 새 풀이가 더 높은 점수
					team[i][2] += s - ans[i][j]; // 총점에 차이만큼 추가
					ans[i][j] = s; // 해당 문제 득점 갱신
				}
			}
			
			// map 정렬 - 1. 최종 점수[2] 내림차, 2. 제출 횟수[1] 오름차, 3. 제출 시간[3] 오름차
			Arrays.sort(team, (o1, o2) -> {
				if(o1[2] == o2[2]) { // 최종 점수 같음
					if(o1[1] == o2[1]) { // 제출 횟수 같음
						return o1[3] - o2[3];
					}
					return o1[1] - o2[1];
				}
				return o2[2] - o1[2];
			});
			
			for(int r = 0; r < team.length; r++) {
				if(team[r][0] == t) {
					sb.append(r+1).append("\n");
				}
			}
		}
		System.out.println(sb.toString());
	}

}
