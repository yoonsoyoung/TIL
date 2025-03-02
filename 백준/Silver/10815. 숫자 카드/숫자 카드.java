import java.io.*;
import java.util.*;
public class Main {

	static int N, M;
    static long arr[];
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		arr = new long[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		// 이분탐색을 위한 배열 정렬, 오름차순
		Arrays.sort(arr);
		
		M = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			int a = Integer.parseInt(st.nextToken());
			binarySearch(a);
		}

		System.out.println(sb.toString());
	}

	static void binarySearch(int n) {
		int start = 0;
		int last = N - 1;

		// 탐색 시작 인덱스가 끝보다 작거나 같아질 때까지
		while (start <= last) {
			// 중간값은 현재 시작과 끝의 중간
			int mid = (start + last) / 2;
			// 중간값이 찾으려는 값과 일치하면 1 찍고 리턴
			if (n == arr[mid]) {
				sb.append("1 ");
				return;
			} else {
				// 중간보다 큰 값이면 시작지점을 중간 한칸 뒤
				if (n > arr[mid])
					start = mid + 1;
				// 작다면 시작지점을 중간 한칸 앞
				else
					last = mid - 1;
			}
		}
		sb.append("0 ");
	}

}
