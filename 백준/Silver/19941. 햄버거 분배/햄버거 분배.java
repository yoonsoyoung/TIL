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
				boolean isFind = false;
				for(int j = M; j > 0; j--) {
					if(i - j >= 0 && table[i - j] == 'H') {
						table[i - j] = ' ';
						ans++;
						isFind = true;
						break;
					}
				}
				
				if(!isFind) {
					for(int j = 1; j <= M; j++) {
						if(i + j < N && table[i + j] == 'H') {
							table[i + j] = ' ';
							ans++;
							break;
						}
					}					
				}
			}
		}
		
		System.out.println(ans);
	}

}
