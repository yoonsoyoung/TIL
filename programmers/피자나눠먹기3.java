public class 피자나눠먹기3 {
    // 통과
    public static void main(String[] args) {
//        int slice = 7, n = 10; // return 2
        int slice = 4, n = 12; // return 3
        System.out.println(solution(slice, n));
    }

    public static int solution(int slice, int n) {
        int answer = n % slice == 0 ? n / slice : n / slice + 1;
        return answer;
    }
}
