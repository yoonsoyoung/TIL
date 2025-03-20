import java.io.*;
import java.util.*;

public class Main {

	static int n, room[], money;
	static boolean visited[], res;
	static ArrayList<Integer>[] adjList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		n = -1;
		while (n != 0) {
			n = Integer.parseInt(br.readLine()); // 미로의 방 수
			if (n == 0)
				break;
			room = new int[n + 1]; // 인덱스가 방번호, 비용을 담고있음
			visited = new boolean[n + 1];
			adjList = new ArrayList[n + 1];

			for (int i = 0; i <= n; i++) {
				adjList[i] = new ArrayList<Integer>();
			}

			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				String info = st.nextToken(); // 방 정보
				if (info.equals("E") || info.equals("L")) { // 빈 방(0) 또는 레프리콘(소지금 충전)
					room[i] = Integer.parseInt(st.nextToken()); // 해당 방의 +요금
				} else if (info.equals("T")) { // 트롤 : 금액 차감
					room[i] = Integer.parseInt(st.nextToken()) * (-1); // 트롤은 -요금
				}
				int a = Integer.parseInt(st.nextToken());
				while (a != 0) {
					adjList[i].add(a); // i 방과 연결된 방 번호
					a = Integer.parseInt(st.nextToken());
				}
			}

			money = 0;
			visited[1] = true;
			res = false;
			moveRoom(1);
			
			System.out.println(res ? "Yes" : "No");

		}

	}

	// 방 이동
	private static void moveRoom(int now) {
		if (now == n) {
			res = true;
			return;
		}

		for (int i = 0; i < adjList[now].size(); i++) {
			int next = adjList[now].get(i); // 다음 갈 방 번호
			if(visited[next]) continue; // 다음 갈 방이 방분한 곳이면 넘어감
			
			int pay = room[next]; // 다음 방의 비용
			int change = money + pay; // 지불했을 때 잔돈
			if (change >= 0) { // 지불 가능
				if (pay > 0) {
					// 레프리콘(방 비용이 +)인데 소지금보다 적다면 기존금액 그대로
					// 레프리콘인데 소지금보다 많다면 그만큼 충전
					money = pay <= money ? money : pay;
				} else {
					money = change;
				}
				visited[next] = true;
				moveRoom(next); // 그 방으로 이동
			}
			visited[next] = false;
		}

	}


}
