package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 통과 128ms
public class Main_1110 {

	static int arr[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[2];

		insertArr(n);

		int cnt = 0;
		int res = -1;
		while (res != n) {
			res = arr[0] + arr[1];
			res = changeArr(res);
			insertArr(res);
			cnt++;
		}

		System.out.println(cnt);

	}

	static void insertArr(int num) {
		if (num < 10) {
			arr[0] = 0;
			arr[1] = num;
		} else {
			arr[0] = num / 10;
			arr[1] = num % 10;
		}
	}

	static int changeArr(int num) {
		arr[0] = arr[1];
		arr[1] = (num % 10);
		
		return arr[0] * 10 + arr[1];
		
	}

}
