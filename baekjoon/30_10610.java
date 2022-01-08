package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 통과 208ms
public class boj_10610_Main {

	static String N;
	static char num[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = br.readLine();
		num = N.toCharArray();

		if (!N.contains("0")) {
			System.out.println("-1"); 
			System.exit(0);
		} else {
			Arrays.sort(num);
			int sum = 0;
			for (int i = 0; i < num.length; i++) {
				sum += num[i];
				sb.append(num[i]);
			}
			if(sum % 3 != 0) {
				System.out.println("-1"); 
				System.exit(0);
			}
				
		}
		
		System.out.println(sb.reverse());
		
	}

}
