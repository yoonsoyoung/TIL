import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int D[] = new int[10001];

		D[0] = 0;
		D[1] = 1;
		D[2] = 2; // 1+1, 2
		D[3] = 3; // 1+1+1, 2+1, 3

		for(int i = 4; i < D.length; i++) {
			D[i] = D[i-3] + (i/2) + 1;
		}
		for(int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(D[n]).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
