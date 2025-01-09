class Solution {
    static int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(0, 0, numbers, target);
        return answer;
    }
    
    public static void dfs(int cnt, int sum, int[] nums, int target) {
        if(cnt == nums.length) {
            if(sum == target) {
                answer++;
            }
            return;
        }
        
        // 각 자리수마다
        dfs(cnt + 1, sum + nums[cnt], nums, target); // 더하거나
        dfs(cnt + 1, sum - nums[cnt], nums, target); // 빼거나
    }
}