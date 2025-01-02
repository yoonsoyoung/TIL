import java.util.Arrays;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        answer = sortDigit(numbers);
        return answer;
    }
    
    public static String sortDigit(int[] numbers) {
		String res = "";
		String[] strNumbers = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new); 
        // int 배열을 String 배열로 변환
		
		// 두 수를 앞/뒤로 조합했을 때 더 큰 숫자가 되도록 정렬
		Arrays.sort(strNumbers, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        // 맨 앞 값이 0일 경우 0으로 출력
		if("0".equals(strNumbers[0])) return "0";
		
		// 정렬된 숫자를 하나의 문자열로 합치기
		res = String.join("", strNumbers);
		return res;
	}
}