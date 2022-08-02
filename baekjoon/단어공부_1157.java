package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 통과 296ms , flag 없이 304ms
public class Main_1157 {

	static int[] alpha;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		alpha = new int[26];
		char c[] = br.readLine().toUpperCase().toCharArray();
		
		for (int i = 0; i < c.length; i++) {
			int n_alpha = c[i] - 65;
			alpha[n_alpha]++;
		}
		
		int max = 0;
		int flag = 0;
		char al = ' ';
		for (int i = 0; i < alpha.length; i++) {
			if(max < alpha[i]) {
				max = alpha[i];
				al = (char)(i+65);
				flag = 0;
			} else if (max == alpha[i]) {
				flag++;
//				al = '?';
			}
		}
//		System.out.println(al);
		if(flag > 0) {
			System.out.println("?");
		} else {
			System.out.println(al);
		}
	}

}
