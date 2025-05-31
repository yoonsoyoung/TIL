import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		
		int block[] = new int[w];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < w; i++) {
			block[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = 0;
		for(int i = 1; i < w - 1; i++) { // 각 블럭을 기준으로
			int now = block[i];
			int leftH = 0;
			int rightH = 0;
			for(int c = 0; c < i; c++) { // 왼쪽의 높은 블럭 탐색
				if(now < block[c]) {
					leftH = leftH < block[c] ? block[c] : leftH;
				}
			}
			
			for(int c = i + 1; c < w; c++) { // 오른쪽의 높은 블럭 탐색
				if(now < block[c]) {
					rightH = rightH < block[c] ? block[c] : rightH;
				}
			}
			
			if(leftH > 0 && rightH > 0) { // 탐색한 높은 블록이 존재해야 함
				int lowH = leftH < rightH ? leftH : rightH;
				ans += (lowH - now);
			}
		}
		
		System.out.println(ans);
	}

}
