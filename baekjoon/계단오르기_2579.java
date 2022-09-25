import java.io.*;

// 통과 124ms
public class Main {
// n까지 오는 거리는 2개
// 마지막에 1칸 뛸 경우, 2칸 뛸 경우
// 직전 칸에서 올 경우는 2칸 뛸 경우로
// 두 칸 전에서 올 경우는 1칸 경우 ,2칸 경우 중 큰 값으로
	
	static int n;
	static int[] D, f;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		f = new int[n+1];
		D = new int[n+1];
		
		for (int i = 1; i <= n; i++) {
			f[i] = Integer.parseInt(br.readLine());
		}
        if(n == 1) {
			System.out.println(f[n]);
			return;
		}
		
		D[1] = f[1];
		D[2] = f[1]+f[2];
		if (n >= 3)
			D[3] = Math.max(f[1] + f[3], f[2] + f[3]);
		
		for (int i = 4; i <= n; i++) {
			// 두 칸 전에서 현재 칸 밟거나, 한 칸 전(연달아 못하므로 여기의 두 칸 전 경로 밟고)에서 밟고 현재 칸 밟거나
			D[i] = Math.max(D[i-2]+f[i], D[i-3]+f[i-1]+f[i]); 
		}
		System.out.println(D[n]);
	}

}
