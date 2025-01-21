class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        int idx = 0;
        for(String[] p : photo) {
            for(String s : p) {
                for(int i = 0; i < name.length; i++) {
                    if(s.equals(name[i])) {
                        answer[idx] += yearning[i];
                        break;
                    }
                }
            }
            idx++;
        }
        return answer;
    }
}