package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 통과 248ms
public class boj_10773_Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Integer> s = new Stack<>();
		long k = Long.parseLong(br.readLine());
		long sum = 0;
		for (int i = 0; i < k; i++) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0) s.pop();
			else s.add(n);
		}
		
		while(s.size() > 0) {
			sum += s.pop();
		}
		
		System.out.println(sum);
	}

}
