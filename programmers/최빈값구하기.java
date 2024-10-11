import java.util.Arrays;
import java.util.HashMap;

public class 최빈값구하기 {

	public static void main(String[] args) {
		int[] input = {1, 2, 3, 3, 3, 4};
//		int[] input = {1, 1, 2, 2};
//		int[] input = {1};
		System.out.println(solution2(input));
	}

	// 통과
	public static int solution(int[] array) {
        int answer = 0;
        int[] number = new int[1000];
        int maxCnt = 0;
        int maxIdx = 0;
        
        Arrays.sort(array);
        for(int i : array) {
        	number[i] += 1;
        	if(number[i] > maxCnt) {
        		maxCnt = number[i];
        		maxIdx = i;
        	}
        }
        
        // 최빈값이 여러 개인 경우 거르기
        for(int i = maxIdx+1; i < number.length; i++) {
        	if(number[i] == maxCnt) return -1;
        }
        answer = maxIdx;
        return answer;
    }
	
	// 해쉬맵을 이용한 또다른 풀이 : 최빈 카운팅과 중복 최빈값 여부까지
	public static int solution2(int[] array) {
		int maxCnt = 0;
		int answer = 0;
		
		HashMap<Integer, Integer> number = new HashMap<Integer, Integer>();
		for(int num : array) {
			int nowCnt = number.getOrDefault(num, 0) + 1;
			if(nowCnt > maxCnt) {
				maxCnt = nowCnt;
				answer = num;
			} else if(nowCnt == maxCnt) { // 최빈 카운팅이 현재 값 빈도수랑 같다면 중복
				answer = -1;
			}
			number.put(num, nowCnt);
		}
		
		return answer;
	}
}
