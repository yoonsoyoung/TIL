// 통과
class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 0;
        for(int i = 0; i < k; i++) {
            answer = (i * 2) % numbers.length;
        }
        return numbers[answer];
    }

  // 다른 풀이 : 수식화
  public int solution2(int[] numbers, int k) {
    int idx = 2 * (k - 1); // 우측으로 한칸 건너띄어 던지므로 2칸씩 이동하는 인덱스(k는 명수이므로 인덱스는 k-1)
    return numbers[idx % numbers.length]; // 배열의 크기로 나눈 나머지는 인덱스 순환
  }
   /*
    k = 2
    idx [0][1][2][3]
    val  1  2  3  4
    sin  1     2

    k = 5
    idx [0][1][2][3][4][5]
    val  1  2  3  4  5  6
    sin  1     2     3
         4     5
    
    k = 3
    idx [0][1][2]
    val  1  2  3
    sin  1     2
            3
    */
}
