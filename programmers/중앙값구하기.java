import java.util.Arrays;

// 통과
public class 중앙값구하기_Solution {

	public static void main(String[] args) {
		int[] input = {1, 2, 7, 10, 11};
		System.out.println(solution(input));
	}
	
	public static int solution(int[] array) {
        int answer = 0;
        Arrays.sort(array);
        answer = array[array.length / 2];
        return answer;
    }

}
