import java.util.HashMap;
class Solution {
    public String solution(String[] participant, String[] completion) {
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