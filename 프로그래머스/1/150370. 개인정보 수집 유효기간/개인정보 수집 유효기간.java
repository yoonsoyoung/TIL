import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        ArrayList<Integer> ansList = new ArrayList<>();
        int todayYY = Integer.parseInt(today.split("\\.")[0]);
        int todayMM = Integer.parseInt(today.split("\\.")[1]);
        int todayDD = Integer.parseInt(today.split("\\.")[2]);
        
        Map<String, Integer> termsMap = new HashMap<>();
        for(int i = 0; i < terms.length; i++) {
            String type = terms[i].split(" ")[0];
            int month = Integer.parseInt(terms[i].split(" ")[1]);
            termsMap.put(type, month * 28);
        }
        
        for(int i = 0; i < privacies.length; i++) {
            String[] date = privacies[i].split(" ")[0].split("\\.");
            String type = privacies[i].split(" ")[1];
            
            int yy = Integer.parseInt(date[0]);
            int mm = Integer.parseInt(date[1]);
            int dd = Integer.parseInt(date[2]);
            long totalDay = (yy * 12 * 28) + (mm * 28) + dd;
            
            totalDay += (termsMap.get(type) - 1);
            long totalDayToTday = (todayYY * 12 * 28) + (todayMM * 28) + todayDD;
            if(totalDay < totalDayToTday) {
                ansList.add(i + 1);
            }
            
        }
        
        answer = ansList.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}