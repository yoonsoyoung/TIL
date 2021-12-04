package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 통과 588ms
public class boj_1158_Main {
	static int N, K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken()); // 1~N
		K = Integer.parseInt(st.nextToken()); // K번째 제거
		
		/*
		// 큐 2개
		Queue<Integer> q = new LinkedList<Integer>();
		Queue<Integer> res = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}
		
		int cnt = 1;
		sb.append("<");
		while (!q.isEmpty()) {
			if(cnt == K) {
				res.offer(q.poll());
				cnt = 1;
			} else {
				q.offer(q.poll());
				cnt++;
			}
			
		}
		
		for (int i = 0; i < N; i++) {
			if(i == N-1)
				sb.append(res.poll() + ">");
			else
				sb.append(res.poll() + ", ");
		}
		System.out.println(sb);
		*/
		
		// 큐 1개 배열 1개
		// 512ms
		Queue<Integer> q = new LinkedList<Integer>();
		int res[] = new int[N];
		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}
		
		int cnt = 0;
		while (!q.isEmpty()) {
			for (int i = 1; i <= K; i++) {
				if(i == K)
					res[cnt++] = q.poll();
				else
					q.offer(q.poll());
			}
		}
		
		sb.append("<");
		for (int i = 0; i < N; i++) {
			sb.append(res[i]);
			if(i < N-1)
				sb.append(", ");
		}
		sb.append(">");
		System.out.println(sb);
	}
}
