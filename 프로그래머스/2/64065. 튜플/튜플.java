import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        
        s = s.replace("},{", "-");
        s = s.replaceAll("\\{\\{|\\}\\}", "");
        String[] strArr = s.split("-");
        Arrays.sort(strArr, (s1, s2) -> s1.length() - s2.length());
        
        ArrayList<String> strList = new ArrayList<>();
        for(String str : strArr) {
            for(String n : str.split(",")) {
                if(strList.contains(n)) {
                    continue;
                } else {
                    strList.add(n);
                }
            }
        }
        
        answer = strList.stream().mapToInt(Integer::parseInt).toArray();
        return answer;
    }
}