import java.io.*;
import java.util.*;

public class Main {

	static int lis[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int a[] = new int[n]; 
		lis = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		lis[0] = a[0];
		int len = 1;
		for(int i = 1; i < n; i++) {
			if(lis[len - 1] < a[i]) { // 최장 증가 부분 수열 끝 값보다 현재 값이 크면
				lis[len++] = a[i]; // 부분 수열 끝에 현재값 추가
			} else {
				int pos = lisBinarySearch(0,  len - 1, a[i]); // 현재 값이 들어가야 할 부분 수열 위치 탐색
				lis[pos] = a[i]; // 찾은 자리에 현재값 추가
			}
		}
		
		System.out.println(len);
		
	}
	
	// 들어갈 자리만 찾는 간략한 이분탐색
	private static int lisBinarySearch(int left, int right, int target) {
		int mid = 0;
		while(left < right) {
			mid = (left + right) / 2;
			if(lis[mid] < target) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return right;
	}

}
