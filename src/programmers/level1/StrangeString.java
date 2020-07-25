package programmers.level1;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * 이상한 문자 만들기
 * https://programmers.co.kr/learn/courses/30/lessons/12930
 */
public class StrangeString {
    public String solution(String s) {
    	StringBuilder answer = new StringBuilder();
    	String[] letters = s.split("");
    	
    	int idx = 0;
    	for (String letter : letters) {
			if (letter.equals(" ")) {
				idx = 0;
			} else {
				letter = (idx % 2 == 0) ? letter.toUpperCase() : letter.toLowerCase(); 
				idx++;
			}
			answer.append(letter);
		}
        return answer.toString();
    }
	@Test
	void test1 () {
		assertEquals("TrY HeLlO WoRlD", solution("try hello world"));
	}
}
