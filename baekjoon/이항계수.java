package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 통과 180ms
public class boj_11401_Main {

	static int N, K;
	static final int P = 1000000007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		// nCk mod 1000000007
		System.out.println(modul(N, K));
	}

	// 모듈러
	private static long modul(int n, int k) {
		long res = 1L;
		if (k == 0)
			return res;

		long fac[] = new long[n + 1]; // 팩토리얼 배열
		fac[0] = 1;

		for (int i = 1; i <= n; i++) {
			fac[i] = fac[i - 1] * i % P;
		}

		// nCk = n! / k!(n-k)! = n! * {k! * (n-k)! }^P-2 
		// = n! * (k!)^P-2 * (n-k!)^P-2
		res = (fac[n] * power(fac[k], P - 2) % P * power(fac[n - k], P - 2) % P) % P;
		return res;
	}

	// 제곱승
	private static long power(long a, int b) {
		long res = 1L;
		if (b == 0) // 0 제곱승은 1
			return res;

		long m = power(a, b / 2); // 지수/2
		long temp = m * m % P; // 밑 제곱

		if (b % 2 == 0) // 짝수
			return temp;
		else
			return a * temp % P;

	}

}
