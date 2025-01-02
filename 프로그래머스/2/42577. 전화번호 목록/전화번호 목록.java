import java.util.Arrays;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length - 1; i++) {
			int pattern_hash = phone_book[i].hashCode();
			for (int j = 0; j < phone_book[i + 1].length(); j++) {
				int now_hash = phone_book[i + 1].substring(0, j).hashCode();
				if (pattern_hash == now_hash) {
					return false;
				}

			}
		}
        return answer;
    }
}