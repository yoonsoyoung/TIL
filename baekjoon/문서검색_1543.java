package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 통과 128ms
public class Main_1543 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String search = br.readLine();

		int l = search.length();
		int cnt = 0;
		
		for (int i = 0; i+l <= str.length() && i < str.length(); i++) {
			if(str.substring(i, i+l).equals(search)) {
				cnt++;
				i = i + l - 1;
			}
		}
		System.out.println(cnt);
		
	}

}
