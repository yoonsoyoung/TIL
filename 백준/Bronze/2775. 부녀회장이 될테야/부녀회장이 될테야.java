import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int apart[][] = new int[15][14]; // 0~14층, 1~14호
		for(int i = 0; i < apart.length; i++) {
			for(int j = 0; j < apart[i].length; j++) {
				if(i == 0) {
					apart[0][j] = j + 1;
				} else {
					apart[i][j] = j > 0 ? apart[i-1][j] + apart[i][j-1] : apart[i-1][j];
				}
			}
		}
		
		int T = Integer.parseInt(br.readLine()); // 테케 수
		for(int t = 0; t < T; t++) {
			int k = Integer.parseInt(br.readLine()); // 층
			int n = Integer.parseInt(br.readLine()); // 호
			sb.append(apart[k][n-1]).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
