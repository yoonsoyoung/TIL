import java.io.*;

public class Main_2438 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		// 통과 212ms
//		for (int i = 0; i < T; i++) {
//			for (int j = 0; j <= i; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		// 통과 132ms
		String res = "";
		for (int i = 0; i < T; i++) {
			res += "*";
			System.out.println(res);
		}
	}
}
