// 통과
public class 배열두배만들기_Solution {

	public static void main(String[] args) {
		int[] input = { 1, 2, 3, 4, 5 };
		solution(input);
	}

	public static int[] solution(int[] numbers) {
		int[] answer = new int[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			answer[i] = numbers[i] << 1; 
		}
		return answer;
	}

}
