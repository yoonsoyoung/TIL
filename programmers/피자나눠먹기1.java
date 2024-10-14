public class 피자나눠먹기1 {
    // 통과
    public static void main(String[] args) {
        int n = 15;
        System.out.println(solution(n));
    }
    public static int solution(int n) {
        int answer = n % 7 == 0 ? n / 7 : n / 7 + 1;
        return answer;
    }
}
