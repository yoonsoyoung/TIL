import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1]; // 상근 1, 창영 0
		
		dp[1] = 1;
		for(int i = 2; i <= N; i++) {
			if(i + 1 <= N) {
				dp[i + 1] = 1;
				i = i + 1;
			} else if(i + 3 <= N) {
				dp[i + 3] = 1;
				i = i + 3;
			}
		}
		
		System.out.print(dp[N] == 1 ? "SK" : "CY");

	}

}