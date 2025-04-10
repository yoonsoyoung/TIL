import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		long cnt_zero = s.chars().filter(c -> c == '0').count();
		long cnt_one = s.chars().filter(c -> c == '1').count();
		int mid_zero = (int) cnt_zero / 2; 
		int mid_one = (int) cnt_one / 2; 
		
		char[] cArr = s.toCharArray();
		for(int i = 0; i < cArr.length; i++) { // 앞에서부터 '1' 절반 제거
			if(cArr[i] == '1' && mid_one > 0) {
				cArr[i] = ' ';
				mid_one--;
			}
		}
		for(int i = cArr.length - 1; i > 0; i--) { // 뒤에서부터 '0' 절반 제거
			if(cArr[i] == '0' && mid_zero > 0) {
				cArr[i] = ' ';
				mid_zero--;
			}
		}
		
		String ns = "";
		for(char c : cArr) {
			if(c != ' ') {
				ns += c;
			}
		}
		
		System.out.println(ns);

	}

}
