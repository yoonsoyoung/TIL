// 통과
public class 분수의덧셈_Solution {

	public static void main(String[] args) {
		solution(1, 2, 3, 4);
//		solution(9, 2, 1, 3);
	}

	public static int[] solution(int numer1, int denom1, int numer2, int denom2) {
		int[] answer = new int[2];

		int numer = numer1 * denom2 + numer2 * denom1;
		int denom = denom1 * denom2;
		int gcd = gcd(numer, denom);
		numer /= gcd;
		denom /= gcd;

		answer[0] = numer;
		answer[1] = denom;
		return answer;
	}

	// 최대 공약수
	public static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return gcd(b, a % b);
		}
	}
}
