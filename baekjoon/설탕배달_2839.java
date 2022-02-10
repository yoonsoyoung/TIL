package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 통과 132ms
public class boj_2839_Main {

	static int N, min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		min = Integer.MAX_VALUE;

		if (N < 8 && N % 3 != 0 && N % 5 != 0)
			System.out.println(-1);
		else {
			for (int i = 0; i < N / 3 + 1; i++) {
				for (int j = 0; j < N / 5 + 1; j++) {
					int res = 3*i + 5*j;
					if(res == N) {
						min = Math.min(min, i+j);
					}
				}
			}
			System.out.println(min);
		}
	}

}

/*
 * 다른 사람 풀이 70ms
 int res = 0;
 
  while(N > 0) {
  	if(N%5 == 0) {
  		res += N/5;
  		break;
  	}
  	N -= 3; // 3으로 나누는 셈
  	res++;
  }
  if(N < 0)
  	res = -1;
  	
  System.out.println(res);
  
  
*/
