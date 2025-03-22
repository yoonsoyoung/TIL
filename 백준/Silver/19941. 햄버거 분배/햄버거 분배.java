import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken()); // 식탁의 길이
		int M = Integer.parseInt(st.nextToken()); // 선택 거리

		char table[] = new char[N];
		table = br.readLine().toCharArray();

		int ans = 0;
		for (int i = 0; i < N; i++) {
			if (table[i] == 'P') {
				for(int j = i - M; j <= i + M; j++) {
					if(j >= 0 && j < N && table[j] == 'H') {
						table[j] = ' ';
						ans++;
						break;
					}
				}
			}
		}
		
		System.out.println(ans);
	}

}
