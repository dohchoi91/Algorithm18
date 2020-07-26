package programmers.level1.kakao;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

/**
 * 2018 KAKAO BLIND RECRUITMENT : 다트 게임
 * https://programmers.co.kr/learn/courses/30/lessons/17682
 * [포인트]
 * 1. 구간에 대한 기준
 * 2. 옵션에 대한 이해 (특히 옵션 범위)
 */
public class DartGame {
    public int solution(String dartResult) {
    	char[] ch = dartResult.toCharArray();
    	
    	int result = 0;
    	int prevScore = 0;
    	int score = 0;
    	int pow = 0;
    	
    	StringBuilder numBuilder = new StringBuilder();
    	for (int i = 0; i < ch.length; i++) {
    		
    		switch(ch[i]) {
	    		case '0':case '1':case '2':case '3':case '4':
	    		case '5':case '6':case '7':case '8':case '9':
	    			prevScore = score;
	    			numBuilder.append(ch[i]);
	    			break;
	    			
	    		case 'T': pow++;
	    		case 'D': pow++;
	    		case 'S': pow++;
	    			score = Integer.parseInt(numBuilder.toString());
	    			score = (int)Math.pow(score, pow);
	    			result += score;
	    			numBuilder.setLength(0);
	    			pow = 0;
	    			break;
	    			
	    		case '*': 
	    			result += (prevScore + score);
	    			score *= 2;
	    			break;
	    		case '#': 
	    			result -= (score * 2);
	    			score -= score * 2;
	    			break;
    		}
		}
        return result;
    }
    
	@Test
	void test1() {
		assertEquals(37, solution("1S2D*3T"));
	}
	
	@Test
	void test2() {
		assertEquals(9, solution("1D2S#10S"));
	}

	@Test
	void test3() {
		assertEquals(3, solution("1D2S0T"));
	}
	
	@Test
	void test4() {
		assertEquals(23, solution("1S*2T*3S"));
	}
	@Test
	void test5() {
		assertEquals(5, solution("1D#2S*3S"));
	}
	@Test
	void testEtc() {
		assertAll(()->{
			assertEquals(-4, solution("1T2D3D#"));
			assertEquals(59, solution("1D2S3T*"));
			
		});
	}
    
}
