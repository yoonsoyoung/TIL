import java.util.Scanner;

public class 크로아티아알파벳_2941 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] croatiAlphabet = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };
		String s = sc.next();
		int cnt = 0;
		for (int i = 0; i < croatiAlphabet.length; i++) {
			if(s.contains(croatiAlphabet[i])) { //contains 특정 문자열을 포함하는가
				s = s.replaceAll(croatiAlphabet[i], "#"); //그거를 하나의 문자(#)로 퉁치고 다시 문자열 갱신
			}
		}
		cnt = s.length();
		System.out.println(cnt);
	}
}
