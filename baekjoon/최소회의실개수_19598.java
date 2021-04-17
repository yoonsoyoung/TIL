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

// 통과 708ms
public class 최소회의실개수_19598 {

	static int N, ans;
	static int[][] room;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine()); // 회의 수
		
		room = new int[N][2]; // [0] : 시작시간, [1] : 끝나는 시간
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			room[i][0] = Integer.parseInt(st.nextToken()); // 시작시간
			room[i][1] = Integer.parseInt(st.nextToken()); // 끝나는 시간
		}
		
		Arrays.sort(room, new Comparator<int[]>(){

			@Override
			public int compare(int[] o1, int[] o2) {
				// 시작 시간 선 정렬 후 종료 시간
				int diff = o1[0]-o2[0];
				return diff != 0 ? diff : o1[1]-o2[1];
			}
		});
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(); // 종료시간에 따라 회의실 관리
		q.add(room[0][1]); // 가장 빨리 시작하는 회의의 종료시간 넣고 시작
		
		for (int i = 1; i < N; i++) {
			if(q.peek() <= room[i][0]) {// 직전 회의 종료시간이 현재 회의의 시작시간보다 작거나 같다면
				q.poll();
				q.add(room[i][1]); // 현재 회의의 종료시간을 큐에 담음
			} else
				q.add(room[i][1]);
		}
		
		// 큐의 사이즈가 답이 됨.
		System.out.println(q.size());
		
		
	}
	
}
