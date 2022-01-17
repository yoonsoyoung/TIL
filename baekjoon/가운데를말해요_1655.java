package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

// 통과 536ms , 다른사람 풀이 참고
public class boj_1655_Main {

	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine()); // 정수의 개수
		PriorityQueue<Integer> maxPq = new PriorityQueue<Integer>(Collections.reverseOrder()); // 내림차순
		PriorityQueue<Integer> minPq = new PriorityQueue<Integer>(); // 오름차순
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (i % 2 == 0) {
				maxPq.offer(num);
			} else {
				minPq.offer(num);
			}

			// 최대 힙의 최상단값 = 중간값
			// -> 그러므로 최소힙의 최소값 < 최대힙의 최대값 이면 swap 해서 더 작은 수가 최대힙의 상단으로 들어가 뽑히도록
			// 양쪽에 나란히 들어간 후(i>0)부터 각 힙의 top을 확인해서 swap 결정
			if (i > 0 && minPq.peek() < maxPq.peek()) {
				int tmp = maxPq.poll();
				maxPq.offer(minPq.poll());
				minPq.offer(tmp);
			}
			
			sb.append(maxPq.peek() + "\n");
		}
		
		System.out.println(sb.toString());
	}

}
