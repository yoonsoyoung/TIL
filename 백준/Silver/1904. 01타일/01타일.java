import java.io.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N+1];
		dp[0] = 1;
		dp[1] = 2;
		
		if(N > 1) {
			for (int i = 2; i < N; i++) {
				dp[i] = (dp[i-2] + dp[i-1]) % 15746;
			}
		}
		
		System.out.println(dp[N-1]);

	}

}