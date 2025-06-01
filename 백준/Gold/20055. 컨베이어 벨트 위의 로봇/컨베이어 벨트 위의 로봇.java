import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] belt = new int[2 * N];
		boolean[] robot = new boolean[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 2 * N; i++) {
			belt[i] = Integer.parseInt(st.nextToken());
		}

		int ans = 0;
		while (K > 0) {
			ans++;
			// 1. 벨트 회전(로봇과 함께)
			int temp = belt[belt.length - 1];
			for (int i = belt.length - 1; i > 0; i--) {
				belt[i] = belt[i - 1];
			}
			belt[0] = temp;
			for (int i = N - 1; i > 0; i--) {
				robot[i] = robot[i - 1];
				robot[i - 1] = false;
			}
			robot[N - 1] = false; // N번 칸은 즉시 내림

			// 2. 로봇 이동
			for (int i = N - 1; i > 0; i--) {
				if(belt[i] < 1 || robot[i]) continue; // 이동하려는 칸의 내구성이 1미만이고 이미 로봇이 있다면 가만히 있는다
				if(robot[i-1]) { // 이동하려는 칸에 문제가 없고 이동할 로봇이 있다면 이동.
					robot[i] = robot[i - 1];
					robot[i - 1] = false;
					belt[i]--;
				}

				robot[N - 1] = false; // N번 칸은 즉시 내림
			}

			// 3. 로봇 올리기
			if (belt[0] > 0 && !robot[0]) {
				robot[0] = true;
				belt[0]--;
			}

			// 전체 벨트에 내구도가 0인 벨트 수 체크
			int cnt = 0;
			for (int n : belt) {
				if (n == 0) {
					cnt++;
				}
			}

			if (cnt >= K)
				break;
			
		}

		System.out.println(ans);
	}

}