package programmers.level1;
/**
 * 서울에서 김서방 찾기
 * https://programmers.co.kr/learn/courses/30/lessons/12919?language=java
 */
public class FindKim {
    public String solution(String[] seoul) {
    	int resIdx = -1;
    	for (int i = 0; i < seoul.length; i++) {
    		if (seoul[i].equals("Kim")) {
				resIdx = i;
				break;
			}
		}
        String answer = "김서방은 " + resIdx + "에 있다";
        return answer;
    }
}
