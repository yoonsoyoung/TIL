import java.util.Arrays;

// 통과
public class 가장큰수_Solution {
	public static void main(String[] args) {
//		int[] input = {6, 10, 2};
//		int[] input = { 6, 10, 2, 0, 1000, 101 }; // 6 2 101 10 1000 0
		int[] input = { 0, 0, 0 }; // 0
		System.out.println(solution(input));
	}

	public static String solution(int[] numbers) {
		String answer = "";
		answer = sortDigit(numbers);
		return answer;
	}

	public static String sortDigit(int[] numbers) {
		String res = "";
		String[] strNumbers = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new); // int 배열을 String 배열로 변환
		
		// 두 수를 앞/뒤로 조합했을 때 더 큰 숫자가 되도록 정렬
		// comparator를 람다식으로 표현, 기준값.compareTo(비교값) : 문자열의 아스키코드 값으로 비교
		// 기준값이 비교값 보다 큰 경우 1, 작은경우 -1 => 내림차순 정렬을 위해 다음값(o2) 현재값(o1) 순으로 조합했을 때 크면 정렬할 수 있도록 기준값을 o2+o1으로
		Arrays.sort(strNumbers, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
		// 맨 앞 값이 0일 경우 0으로 출력
		if("0".equals(strNumbers[0])) return "0";
		
		// 정렬된 숫자를 하나의 문자열로 합치기
		res = String.join(" ", strNumbers);
		return res;
	}

}
