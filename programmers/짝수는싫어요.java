public class 짝수는싫어요_Solution {

	// 통과
	public static void main(String[] args) {
		int input = 15;
		solution(input);
	}
	
	public static int[] solution(int n) {
        int[] answer = new int[n%2 == 0 ? n/2 : n/2 + 1];
        for(int i = 0; i < answer.length; i++) {
        	answer[i] = (i << 1) + 1;
        	System.out.println(answer[i]);
        }
        return answer;
    }

}
