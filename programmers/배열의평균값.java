public class 배열의평균값 {
    // 통과
    public static void main(String[] args) {
//        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // return 5.5
        int[] input = {89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99}; // return 94.0
        System.out.print(solution(input));
    }

    public static double solution(int[] numbers) {
        double answer = 0;
        for(int num : numbers) {
            answer += num;
        }
        answer /= numbers.length;
        return answer;
    }

}
