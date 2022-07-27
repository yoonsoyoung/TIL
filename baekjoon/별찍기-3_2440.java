import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 통과 228ms
public class Main_2440 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			for (int j = T; j > i; j--) {
				System.out.print("*");
			}
			System.out.println("");
		}

	}

}
