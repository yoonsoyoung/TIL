package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 통과 124ms
public class boj_1026_Main {

	static int N, a[], loc[];
	static ArrayList<Integer> b;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		a = new int[N];
		b = new ArrayList<Integer>();
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			b.add(Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(a);
		// 내림차순 정렬
		b.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += a[i] * b.get(i);
		}
		
		System.out.println(sum);
	}

}
