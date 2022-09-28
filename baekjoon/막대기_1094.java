package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 통과 156ms
public class Main_1094 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		if(x == 64) {
			System.out.println(1);
			System.exit(0);
		}
		
		Stack<Integer> stick = new Stack<Integer>();
		stick.add(64);
		int sum = 0;
		while (sum != x) {
			// 나무막대 꺼내서 
			int nowStick = stick.pop();
			
			// 절반으로 자른다
			int splitStick = nowStick/2;
			// 자른막대(1)+현재 막대 합(sum) >= x 이면, 자른막대(2)를 버리고 자른막대(1) add
			if(splitStick + sum >= x) {
				stick.add(splitStick);
				if(splitStick+sum == x) {
					break;
				}
			} else {
				// 아니면 막대합+자른막대(1), 자른막대(1),(2) add
				sum += splitStick;
				stick.add(splitStick);
				stick.add(splitStick);
			}
			
		}
		
		System.out.println(stick.size());
	}

}
