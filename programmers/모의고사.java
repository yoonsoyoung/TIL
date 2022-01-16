package 그래프탐색;

import java.util.LinkedList;
import java.util.Queue;

// 통과
public class progrmers_모의고사_Solution {
  
	public static void main(String[] args) {
		int[] answers = { 1, 3, 2, 4, 2 };
		solution(answers);

		// 수포자1 : 1,2,3,4,5 / 5개
		// 수포자2 : 2,1,2,3,2,4,2,5 / 8개
		// 수포자3 : 3,3,1,1,2,2,4,4,5,5 / 10개
	}

	public static int[] solution(int[] answers) {
		int[] answer;
		int[] one = { 1, 2, 3, 4, 5 };
		int[] two = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] three = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

		int[] cnt = new int[3]; // 각 수포자 1,2,3의 맞은 개수

		for (int i = 0; i < answers.length; i++) {

			if (one[i % 5] == answers[i])
				cnt[0]++;
			if (two[i % 8] == answers[i])
				cnt[1]++;
			if (three[i % 10] == answers[i])
				cnt[2]++;
		}

		Queue<Integer> q = new LinkedList<Integer>();
		int max = 0;
		for (int i : cnt) {
			if (i > max)
				max = i;
		}
		for (int i = 0; i < cnt.length; i++) {

			if (cnt[i] == max) {
				q.offer(i + 1);
			}
		}

		answer = new int[q.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = q.poll();
		}

		return answer;
	}
}
