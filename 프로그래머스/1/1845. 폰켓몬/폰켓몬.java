import java.util.HashMap;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        HashMap<Integer, Boolean> selNum = new HashMap<Integer, Boolean>();
        for(int num : nums) {
        	selNum.put(num, true);
        }
        
        answer = selNum.size() > nums.length/2 ? nums.length/2 : selNum.size();
        
        return answer;
    }
}