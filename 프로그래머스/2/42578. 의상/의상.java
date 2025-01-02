import java.util.HashMap;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;

		HashMap<String, Integer> typeCaseMap = new HashMap<String, Integer>(); // 종류에 따른 의상 경우의 수를 담는 map
		for(String[] clothing : clothes) {
			typeCaseMap.put(clothing[1], typeCaseMap.getOrDefault(clothing[1], 1)+1); // 첫 종류일 때 입지 않는 경우 1을 가지고 +1(입는 경우 의상)
		}
		// 각 종류별 조합은 n * m * k ... 
		for(String type : typeCaseMap.keySet()) {
			answer = answer * typeCaseMap.get(type);
		}

		// - 1(다 안 입는 경우는 제외)
		return answer - 1;
    }
}