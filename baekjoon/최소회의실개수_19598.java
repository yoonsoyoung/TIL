package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// ��� 708ms
public class �ּ�ȸ�ǽǰ���_19598 {

	static int N, ans;
	static int[][] room;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine()); // ȸ�� ��
		
		room = new int[N][2]; // [0] : ���۽ð�, [1] : ������ �ð�
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			room[i][0] = Integer.parseInt(st.nextToken()); // ���۽ð�
			room[i][1] = Integer.parseInt(st.nextToken()); // ������ �ð�
		}
		
		Arrays.sort(room, new Comparator<int[]>(){

			@Override
			public int compare(int[] o1, int[] o2) {
				// ���� �ð� �� ���� �� ���� �ð�
				int diff = o1[0]-o2[0];
				return diff != 0 ? diff : o1[1]-o2[1];
			}
		});
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(); // ����ð��� ���� ȸ�ǽ� ����
		q.add(room[0][1]); // ���� ���� �����ϴ� ȸ���� ����ð� �ְ� ����
		
		for (int i = 1; i < N; i++) {
			if(q.peek() <= room[i][0]) {// ���� ȸ�� ����ð��� ���� ȸ���� ���۽ð����� �۰ų� ���ٸ�
				q.poll();
				q.add(room[i][1]); // ���� ȸ���� ����ð��� ť�� ����
			} else
				q.add(room[i][1]);
		}
		
		// ť�� ����� ���� ��.
		System.out.println(q.size());
		
		
	}
	
}
