import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 통과 120ms
public class Main {

	static int N, num[], visit[], ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		num = new int[N+1]; // 1부터 쓰기 위함
		visit = new int[N+1]; // cycle 확인을 위해 int형으로
		
		for (int i = 1; i <= N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}

		ans = 0;
		for (int i = 1; i <= N; i++) {
			dfs(i);
			for (int j = 1; j <= N; j++) { // 사이클 도는 거 발견 후 돌아왔을 때
				if(visit[j] < 2)
					visit[j] = 0; // 사이클 돌려다 만 거 원상 복귀
			}
			if(visit[i] == 2)
				ans++;
		}
		
		System.out.println(ans);
		for (int i = 1; i <= N; i++) {
			if(visit[i] == 2) // 사이클이 생긴 애들이 답
				System.out.println(i);
		}
		
		
	}

	private static void dfs(int idx) {
		if(visit[idx] >= 2) // 사이클이 발생했다
			return;
		visit[idx]++; // 방문마다 증가
		dfs(num[idx]); // 연결된 애 호출
	}

}
