package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// ��� 3208ms
public class ���Ի��_1946 {
	
	static int T, N, ans;
	static int[][] workers;
	public static void main(String[] args) throws NumberFormatException, IOException {

		// ������ �������� ���� �� �� ������ ��� ����x
		// ȸ�ǽ� ������ ����� ������ �̿��� Ǯ���
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine()); // ���ɼ�
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine()); // ������ ��
			workers = new int[N][2]; // [0]��: �������� ����, [1]��: �������� ����
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				workers[i][0] = Integer.parseInt(st.nextToken());
				workers[i][1] = Integer.parseInt(st.nextToken());
			}
			
			// �������� ���� �������� ����
			Arrays.sort(workers, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0]-o2[0];
				}
			});

			// ���������� ���ĵǾ����� �̶��� ���������� �� ����(�հ�)���� ���� ����̾����
			// ��������1������ �ϴ� �̰� ����
			int lank = workers[0][1];
			ans = 1;
			
			// �׸��� �� ���� ���� ���������� ���Ͽ� �񱳴�� ����
			for (int i = 1; i < N; i++) {
				if(lank > workers[i][1]) { // lank ���� �۾ƾ� ���� ����!
					lank = workers[i][1];
					ans++;
				}
			}
			
			
			System.out.println(ans);
		}
	}

}
