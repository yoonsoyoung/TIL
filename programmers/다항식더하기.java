class Solution {
    public String solution(String polynomial) {
        String answer = "";
        int x = 0;
        int num = 0;
        polynomial = polynomial.replace("+ ", "");
        for(String s : polynomial.split(" ")) {
            if(s.contains("x")) {
                s = s.replace("x", "");
                x += Integer.parseInt(s.length() > 0 ? s : "1");
            } else {
                num += Integer.parseInt(s);
            }
        }
        String strX = x > 0 ? String.valueOf(x) : "";
        String strNum = num > 0 ? String.valueOf(num) : "";
        if(!strX.isEmpty()) {
            answer = (x == 1 ? "" : strX) + "x";
            if(!strNum.isEmpty()) {
                answer += " + " + strNum;
            }
        } else {
            answer = strNum;
        }
        return answer;
    }
}
