import java.util.HashMap;

// 통과 코드로 녹이는 방식은 해설 참고
public class 의상_Solution {

	public static void main(String[] args) {
//		String[][] input = { { "yellow_hat", "headgear" }, { "blue_sunglasses", "eyewear" }, { "green_turban", "headgear" } }; // return 5
//		String[][] input = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}}; // return 3
		String[][] input = {{"crow_mask", "face"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}; // return 7

		System.out.println(solution(input));
	}

	public static int solution(String[][] clothes) {
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
