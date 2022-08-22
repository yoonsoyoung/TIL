package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 통과 124ms
public class Main_10870 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int fibo[] = new int[n+2];
		fibo[0] = 0;
		fibo[1] = 1;
		
		if(n > 1) {
			for (int i = 2; i <= n; i++) {
				fibo[i] = fibo[i-1] + fibo[i-2];
			}
		}
		
		System.out.println(fibo[n]);
	}

}
