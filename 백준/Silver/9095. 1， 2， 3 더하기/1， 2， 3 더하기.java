import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int T;
	static int[]D;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		D = new int[12];
		
		D[0] = 0;
		D[1] = 1;
		D[2] = 2;
		D[3] = 4;
		
		for (int i = 4; i <= 11; i++) {
			// f(n) = f(n-1) + f(n-2) + f(n-3)
			D[i] = D[i-1] + D[i-2] + D[i-3];
		}

		for (int i = 1; i <= T; i++) {
			int x = Integer.parseInt(br.readLine());
			System.out.println(D[x]);
		}
	}

}
