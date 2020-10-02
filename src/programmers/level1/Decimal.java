package programmers.level1;

import java.util.ArrayList;
import java.util.List;

/**
 * 소수 찾기
 * https://programmers.co.kr/learn/courses/30/lessons/12921?language=java
 * [포인트] 
 * 1. 소수의 특성 파악
 * 2. 불필요한 체킹 제거
 */
public class Decimal {
    public static int solution(int n) {
    	int answer = 0;
    	
//		시도 1 : 이중 for문을 이용하여 나머지 유무 체크
//    	int answer = 1;
//    	
//    	for (int i = 2; i <= n; i++) {
//    		int halfIdx = (i / 2) + 1;
//        	for (int j = 2; j <= halfIdx; j++) {
//        		if (i % j == 0) {
//        			break;
//        		}
//        		if (j == halfIdx) {
//        			answer++;
//        		}
//        	}
//		}
    	
//		시도 2 : 소수 리스트를 별도로 저장 및 활용  이용하여 나머지 유무 체크	
    	List<Integer> decimalList = new ArrayList<Integer>();
    	decimalList.add(2);
    	
    	for (int i = 3; i <= n; i++) {
        	for (int j = 0; j < decimalList.size(); j++) {
        		int decimal = decimalList.get(j); 
        		
        		if (i % decimal == 0) {
        			break;
        		}
//         		시도 3 : 소수 리스트를 끝까지 체크	후 추가
//        		if (j == decimalList.size() - 1) {
//        			decimalList.add(i);
//        		}
        		
//         		시도 4 : 소수리스트를 i의 제곱근 만큼만 확인. (그 이후에는 체크 할 필요가 X) 
        		if (Math.sqrt(i) < decimal) {
        			decimalList.add(i);
        			break;
        		}
        	}
		}
    	answer = decimalList.size();
    	
//		번외 시도  : 이렇게 해도 통과  	
    	
    	answer = findDecimal(n);
    	
    	return answer;
    }
	private static int findDecimal(int n) {
		int answer = 1;
		for (int i = 2; i <= n; i++) {
    		int maxIdx = (int)Math.sqrt(i) + 1;
	    	for (int j = 2; j <= maxIdx; j++) {
	    		if (i % j == 0) {
	    			break;
	    		}
	    		if (j == maxIdx) {
	    			answer++;
	    		}
	    	}
    	}
		return answer;
	}
    public static void main(String args[]) {
    	System.out.println(solution(100));
    }
}
