package com.baekjoon;

import java.util.Scanner;

// ���
public class ����_2564 {

	static int r, c, store;
	static int[] dist;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		c = sc.nextInt(); // ����, ��
		r = sc.nextInt(); // ����, ��
		int circ = (c + r) * 2; // �ѷ�
		store = sc.nextInt(); // ���� ��
		dist = new int[store + 1]; // �������� ���� ��ġ

		for (int i = 0; i < dist.length; i++) {
			int dir = sc.nextInt(); // ����
			int pos = sc.nextInt(); // ��ġ
			// �ݴ� ������ �ѷ��� �̿�
			// �ð� ������ 0,0�� �������� �Ÿ� ����
			// - ��1: �׳� ��ġ, ��4: ����+�Ÿ�, ��2: ����+����+(����-���Ÿ�), ��3: �ѷ�-���Ÿ�
			switch (dir) { // �ð���⿡���� �Ÿ�
			case 1: // ��= pos
				dist[i] = pos;
				break;

			case 2: // ��= c + r + c - pos
				dist[i] = c + r + c - pos;
				break;

			case 3: // ��= circ - pos
				dist[i] = circ - pos;
				break;

			case 4: // ��= c + pos
				dist[i] = c + pos;
				break;
			}
		}
		// �������� ��ŭ ���鼭
		int myDist = dist[store];
		int ans = 0;
		for (int j = 0; j < store; j++) {
			// �ð� ������ �� ��ġ(dist �迭�� ������ ��)���� �� ������ �Ÿ��� �� �ſ� ����
			// ��: 22 / 1: 4 / 2: 27/ 3: 17 / �ѷ�:30
			int clock = Math.abs(myDist - dist[j]);
			// �ݽð� ������ �ѷ����� �ð���� �Ÿ� �� ��.
			// �� �� �� �ּ��� ���� �������ϸ� ��
			// ���� 1 18,12 / ���� 2 6, 24 / ���� 3
			ans += Math.min(clock, circ - clock);

		}
		System.out.println(ans);
	}

}
