import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		long cnt_zero = s.chars().filter(c -> c == '0').count();
		long cnt_one = s.chars().filter(c -> c == '1').count();
		
		char[] charArr = s.toCharArray();
		Arrays.sort(charArr);
		String str = new String(charArr);
		int mid_zero = (int) (cnt_zero % 2 == 0 ? cnt_zero / 2 : cnt_zero / 2 + 1); 
		int mid_one = (int) (cnt_one % 2 == 0 ? cnt_one / 2 : cnt_one / 2 + 1); 
		System.out.println(str.substring(mid_zero, str.length() - mid_one));

	}

}
