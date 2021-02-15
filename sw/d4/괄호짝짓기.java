package com.sw.d4;

import java.util.Scanner;
import java.util.Stack;

// 16
// {[()]}<>[<{}><>[
public class 괄호짝짓기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int tc = 1; tc <= T; tc++) {
			int strLength = sc.nextInt();
			String str = sc.next();
			Stack s = new Stack();
			boolean ans = true;
			// stack 써서, 스택이 남아있으면 아직 남은거임
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[' || str.charAt(i) == '<') {
					//열린 괄호는 그냥 push
					s.push(str.charAt(i));
				} 
				// 닫히는게 만나면 pop해서 짝궁맞는지
				else if(str.charAt(i) == ')') {
					if(!s.pop().equals('(')) { //뽑았는데 짝이 아니라면
						ans = false; 
						break; //나가버림, 다시
					}
				} else if(str.charAt(i) == '}') {
					if(!s.pop().equals('{')) {
						ans = false;
						break;
					}
				} else if(str.charAt(i) == ']') {
					if(!s.pop().equals('[')) {
						ans = false;
						break;
					}
				} else if(str.charAt(i) == '>') {
					if(!s.pop().equals('<')) {
						ans = false;
						break;
					}
				} 
			}
			
			//괄호를 짝 맞춰 닫고 왔는데 스택에 남아있다->열린괄호가 남아있다
			if(!s.isEmpty() && ans == true) {
				ans = false;
			}
			
			System.out.println("#" + tc + " " + (ans?1:0));
		}
	}

}
