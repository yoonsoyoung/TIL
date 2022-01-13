package 자료구조;

import java.util.HashMap;

// 해시 문제
// 통과 1013점
public class progmers_완주하지못한선수_Solution {

	public static void main(String[] args) {
		String[] participant = {"mislav", "mislav", "mislav"};
		String[] completion = {"mislav", "mislav"};

		/*
		input : participant
		"leo", "kiki", "eden"
		"marina", "josipa", "nikola", "vinko", "filipa"
		"mislav", "stanko", "mislav", "ana"
		*/
		
		/*
		 input : comletion
		 "eden", "kiki"
		 "josipa", "filipa", "marina", "nikola"
		 "stanko", "ana", "mislav"
		 */
		
		
		System.out.println(solution(participant, completion));
		
	}
	
	public static String solution(String[] participant, String[] completion) {
		String answer = "";
        HashMap<String, Integer> map = new HashMap();

        for (String s : participant) {
        	if(map.containsKey(s)) {
        		int cnt = map.get(s);
        		map.put(s, cnt+1);
        	} else {
        		map.put(s, 1);
        	}
        }
        for (String s : completion) {
        	if(map.containsKey(s)) {
        		int cnt = map.get(s);
        		map.put(s, cnt-1);
        	} else
        		map.put(s, 1);
		}
        
        for (String key : map.keySet()) {
			if(map.get(key) != 0) {
				answer = key;
			}
		}
        return answer;
    }
}
