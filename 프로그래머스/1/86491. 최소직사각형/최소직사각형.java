import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        Arrays.sort(sizes, (a, b) -> b[0] - a[0]);
        
        int w = 0;
        int h = 0;
        for(int[] a : sizes) {
            w = Math.max(w, a[0] < a[1] ? a[1] : a[0]);
            h = Math.max(h, a[0] < a[1] ? a[0] : a[1]);
        }
        
        return w * h;
    }
}