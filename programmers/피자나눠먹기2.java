public class 피자나눠먹기2 {
    // 통과
    public static void main(String[] args) {
//        int n = 6;
         int n = 4;
        System.out.println(solution(n));
    }
    public static int solution(int n) {
        int answer = 0;
        int lcm = gcd(6, n);
        answer = n / lcm;
        return answer;
    }

    public static int gcd(int a, int b) {
        if(a % b == 0)
            return b;
        return gcd(b, a % b);
    }
}
