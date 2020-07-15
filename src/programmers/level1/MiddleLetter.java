package programmers.level1;

/*
 * 가운데 글자 가져오기
 * https://programmers.co.kr/learn/courses/30/lessons/12903?language=java
 * 
 */
public class MiddleLetter {
    public static String solution(String s) {
    	int half = s.length() / 2;
    	String answer = (s.length() % 2 == 0) ? s.substring(half - 1, half + 1) : s.substring(half, half + 1);
    	return answer;
    }
    
    public static void main(String args[]) {
    	System.out.println(solution("abccd"));
    }
}
