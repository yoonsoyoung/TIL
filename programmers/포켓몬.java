import java.util.HashMap;

// 통과
public class 포켓몬_Solution {

	public static void main(String[] args) {
//		int[] input = {3,3,3,2,2,4};
		int[] input = {3,1,2,3};
		System.out.println(solution(input));
	}
	
	public static int solution(int[] nums) {
        int answer = 0;
        HashMap<Integer, Boolean> selNum = new HashMap<Integer, Boolean>();
        for(int num : nums) {
        	selNum.put(num, true);
        }
        
        answer = selNum.size() > nums.length/2 ? nums.length/2 : selNum.size();
        return answer;
    }

}
