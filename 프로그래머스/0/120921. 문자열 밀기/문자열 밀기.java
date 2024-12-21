class Solution {
    // 풀이 1: 반복문을 통한 한 글자씩 밀어보며 비교
    public int solution(String A, String B) {
        int answer = 0;
        if(!B.equals(A)) {
            for(int i = 0; i < A.length(); i++) {
                A = A.charAt(A.length() - 1) + A.substring(0, A.length() - 1);
                if(B.equals(A)) {
                    return i + 1;
                }
            }
            return -1;
        }
        return answer;
    }

    // 풀이 2: 다른 사람 풀이 참고
    public int solution2(String A, String B) {
        return (B+B).indexOf(A); // 밀어서 만들어진 B를 두 번 합친(한 사이클 밀었을 때를 가정) 문자열에 기존 문자열 A의 인덱스 판단

        // java 11부터 가능한 String repeat 메소드 응용
        // return B.repeat(2).indexOf(A);
    }
}
