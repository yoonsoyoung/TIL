import java.util.Scanner;
import java.util.Stack;

public class 계산기2_2 {
	// 곱하기가 더하기보다 연산 우선순위가 높고,
	// 곱하기는 연산자의 앞, 뒤 피연산자 값이 중요!
	// 그러므로 숫자는 stack에 넣고 곱하기를 먼저 처리.
	// 곱하기의 앞, 뒤 피연산자의 연산 값을 넣고
	// stack에 있는 모든 숫자를 더하면 끝.
	
	static Stack<Integer> stack = new Stack<>();
	static int T = 10;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); //문자열 길이
			String s = sc.next(); //연산할 문자열
			int ans = 0;
			
			for (int i = 0; i < N; i++) {
				if('0' <= s.charAt(i) && s.charAt(i) <= '9') { //숫자면
					stack.push((int)(s.charAt(i)-'0')); //문자에 '0'을 뺌으로써 아스키코드가 숫자와 같아짐 그리고 int형변환
				} else if (s.charAt(i) == '*') { //곱셈이라면
					int a = stack.pop(); //넣어둔 피연산자
					int b = (int)(s.charAt(++i) - '0'); //곱셈 다음 숫자(피연산자)
					int mul = a*b; 
					stack.push(mul);
				}
			}
			while(!stack.isEmpty()) { //덧셈은 연산 우선순위가 낮음. 곱셈 제외 나머지는 덧셈 
				ans+=stack.pop();
			}
			System.out.println("#" + tc + " " + ans);
		}
		
	}

}
