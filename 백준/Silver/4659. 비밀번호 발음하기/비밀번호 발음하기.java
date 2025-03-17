import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] vow = {"a", "e", "i", "o", "u"};
        while(true) {
            boolean flag = true;
            String pwd = br.readLine();
            if("end".equals(pwd)) break;

            char[] pwdArr = pwd.toCharArray();
            int vowReq = 0;
            int vowDupl = 0; // 모음
            int conDupl = 0; // 자음
            if(Arrays.asList(vow).contains(Character.toString(pwdArr[0]))) {
                vowReq++;
                vowDupl++;
            } else {
                conDupl++;
            }
            for(int i = 1; i < pwdArr.length; i++) {
                if(Arrays.asList(vow).contains(Character.toString(pwdArr[i]))) {
                    vowReq++;
                    vowDupl++;
                    conDupl = 0;
                } else {
                    conDupl++;
                    vowDupl = 0;
                }

                // ee, oo를 제외한 같은 글자가 두 번 연속 안됨
                if(pwdArr[i] == pwdArr[i-1]) {
                    if(pwdArr[i] == 'e' || pwdArr[i] == 'o') {
                        vowDupl = 0;
                    } else {
                        flag = false;
                        break;
                    }
                }

                // 모음/자음이 3개 연속으로 오면 안됨
                if(vowDupl == 3 || conDupl == 3) {
                    flag = false;
                    break;
                }
            }
            // 모음 하나를 반드시 포함
            if(vowReq == 0) {
                flag = false;
            }
            if(flag) {
                sb.append("<" + pwd + "> is acceptable.\n");
            } else {
                sb.append("<" + pwd + "> is not acceptable.\n");
            }
        }
        System.out.print(sb.toString());
    }
}
