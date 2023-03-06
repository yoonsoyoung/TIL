package 재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10872 {

	static int res;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		res = 1;
		factorial(n);
		System.out.println(res);
		
	}
	
	static void factorial(int a) {
		if(a == 0) {
			return; 
		}
		
		res = res * (a);
		factorial(a-1);
	}

}
