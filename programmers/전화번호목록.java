package 자료구조;

import java.util.Arrays;
import java.util.HashMap;

// 통과 > 하지만 답지 참고
public class progmers_전화번호목록_Solution {

	// 해시 문제
	public static void main(String[] args) {
		String phone_book[] = { "010111", "010" };
		/*
		 * input 
		 * "119", "97674223", "1195524421" > false 
		 * "123","456","789" > true
		 * "12","123","1235","567","88" > false 
		 * "02", "021", "123" > false
		 * "010111", "010" > false : 이런 경우를 위해 정렬 해주면 편함
		 */
		System.out.println(solution(phone_book));
	}

	public static boolean solution(String[] phone_book) {
		boolean answer = true;
		
		// 답지 참고
//		HashMap<String, Integer> map = new HashMap<String, Integer>();
//		for (int i = 0; i < phone_book.length; i++) {
//			map.put(phone_book[i], i);
//		}
//		for (int i = 0; i < phone_book.length; i++) {
//			// 같은 번호가 중복되어 있지 않기 때문에 j = 1부터 시작
//			for (int j = 1; j < phone_book[i].length(); j++) {
//				if (map.containsKey(phone_book[i].substring(0, j))) {
//					// 비교 할 문자열의 앞에서 한 문자씩 늘려가며 비교
//					return false;
//				}
//
//			}
//		}

		// subString 을 참고하여 또 다른 풀이
		Arrays.sort(phone_book); // 정렬시켜서 짧은 문자열이 앞쪽에 위치하도록
		for (int i = 0; i < phone_book.length - 1; i++) {
			int pattern_hash = phone_book[i].hashCode();
			for (int j = 0; j < phone_book[i + 1].length(); j++) {
				int now_hash = phone_book[i + 1].substring(0, j).hashCode();
				if (pattern_hash == now_hash) {
					return false;
				}

			}
		}

		return answer;
	}
}
