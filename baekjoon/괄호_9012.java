package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 통과 136ms
public class Main_9012 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			Stack<Character> st = new Stack<Character>();

			String str = br.readLine();
			for (int j = 0; j < str.length(); j++) {
				char c = str.charAt(j);
				if(c == '(') {
					st.push(c);
				} else {
					if(!st.empty()) {
						st.pop();
					} else {
						st.push(c);
						break;
					}
				}
			}
			
			if(!st.empty())
				System.out.println("NO");
			else
				System.out.println("YES");
			
			
		}
	}

}
