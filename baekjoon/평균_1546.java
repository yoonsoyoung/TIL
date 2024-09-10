import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 성공 104ms
public class boj_1546_Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine()); // 과목수
		int[] grade = new int[n];
		float max = 0;
		float total = 0;
		float res = 0;
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			grade[i] = Integer.parseInt(st.nextToken());
			max = (max < grade[i]) ? grade[i] : max;
			total += grade[i];
		}
		
		res = (total / n) / max * 100;
		System.out.println(res);
	}
}
