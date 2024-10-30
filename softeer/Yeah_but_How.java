package 소프티어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 통과
public class YeahbutHow {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // v1. 첫 풀이 -> 테스트 케이스 1~5번 오답으로 통과 못함
        /*
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split("");
        Queue<String> res = new LinkedList<>();
        boolean isClosed = false;
        res.offer(input[0]);
        for(int i = 1; i < input.length; i++) {
            if(")".equals(input[i])) {
                if(!isClosed) {
                    res.offer("1+1");
                } else { // v2. 해당 else 문 제거 -> 테케 1번 오답
                    res.offer("+1");
                }
                isClosed = true;
            } else if("(".equals(input[i])) {
                if(isClosed) {
                    res.offer("+");
                    isClosed = false;
                }
            }
            res.offer(input[i]);
        }

        while(!res.isEmpty()) {
            sb.append(res.poll());
        }
        System.out.println(sb.toString());*/

        // v3. v2 제거 후 축소 -> res.offer("1"); 정답.
        /*StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split("");
        Queue<String> res = new LinkedList<>();
        boolean isClosed = false;
        res.offer(input[0]);
        for(int i = 1; i < input.length; i++) {
            if(")".equals(input[i])) {
                if(!isClosed) {
                    res.offer("1+1");
                }
                isClosed = true;
            } else if("(".equals(input[i])) {
                if(isClosed) {
                    res.offer("+");
                    isClosed = false;
                }
            }
            res.offer(input[i]);
        }

        while(!res.isEmpty()) {
            sb.append(res.poll());
        }
        System.out.println(sb.toString());*/

        // v4. 다른 사람 풀이 참고 -> 기본적인 경우를 고려한 테케 공략, 기존 내가 푼 풀이는 테케의 경우를 벗어난 경우일 듯 예상
        String input = br.readLine();
        input = input.replace("()", "(1)").replace(")(", ")+(");
        System.out.println(input);
    }

}
