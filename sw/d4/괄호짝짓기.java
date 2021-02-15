package com.sw.d4;

import java.util.Scanner;
import java.util.Stack;

// 16
// {[()]}<>[<{}><>[
public class ��ȣ¦���� {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int tc = 1; tc <= T; tc++) {
			int strLength = sc.nextInt();
			String str = sc.next();
			Stack s = new Stack();
			boolean ans = true;
			// stack �Ἥ, ������ ���������� ���� ��������
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[' || str.charAt(i) == '<') {
					//���� ��ȣ�� �׳� push
					s.push(str.charAt(i));
				} 
				// �����°� ������ pop�ؼ� ¦�ø´���
				else if(str.charAt(i) == ')') {
					if(!s.pop().equals('(')) { //�̾Ҵµ� ¦�� �ƴ϶��
						ans = false; 
						break; //��������, �ٽ�
					}
				} else if(str.charAt(i) == '}') {
					if(!s.pop().equals('{')) {
						ans = false;
						break;
					}
				} else if(str.charAt(i) == ']') {
					if(!s.pop().equals('[')) {
						ans = false;
						break;
					}
				} else if(str.charAt(i) == '>') {
					if(!s.pop().equals('<')) {
						ans = false;
						break;
					}
				} 
			}
			
			//��ȣ�� ¦ ���� �ݰ� �Դµ� ���ÿ� �����ִ�->������ȣ�� �����ִ�
			if(!s.isEmpty() && ans == true) {
				ans = false;
			}
			
			System.out.println("#" + tc + " " + (ans?1:0));
		}
	}

}
