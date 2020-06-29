package programmers;

import java.util.ArrayList;
import java.util.List;

/*
 * 체육복
 * https://programmers.co.kr/learn/courses/30/lessons/42862?language=java
 * 
 * [포인트] 
 * 1. 절대 이중 for문을 쓸 수 없다 -> 시간 초과 -> 이중 포문으로 두되 reserve의 길이를 동적으로 줄인다.
 * 2. 정답 = n(전체 학생 수) - lost(도난 학생 수) + calculate(빌릴 수 있는 체육복 수)
 * 3. 기준 설정 : lost를  기준으로 두고 reserve와 비교한다.
 * 4. 주의 사항 : 도난 학생이 여벌을 가지고 있을 경우 이 경우를 최우선으로 처리한다.    
 *	  ex) solution(5, [2,3], [3,4]) 케이스
 * 5. 비고 : 만약 lost, reserve가 정렬되지않는 배열로 들어올 경우 틀릴 수도 있음.
 */
public class WorkoutClothes {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        int count = lost.length;
        List<Integer> reserveList = new ArrayList<Integer>();
        
        for (int i = 0; i < reserve.length; i++) {
        	reserveList.add(reserve[i]);
		} 
        
        for (int i = 0; i < lost.length; i++) {
        	int findIdx = -1;
        	
        	for (int j = 0; j < reserveList.size(); j++) {
        		int compare = reserveList.get(j);
        		
        		if (lost[i] == compare || lost[i] - 1 == compare) { 
	    			findIdx = j;
        		} else if (lost[i] + 1 == compare) {
        			findIdx = j;
        			if (i < lost.length - 1) { // 배열 index 초과 되지 않게 설정
        				// 다음 lost의 번호와 reserve가 일치할 경우 스킵한다.
        				if (lost[i+1] == compare) { 
        	    			findIdx = -1;
        				}
        			}
        		}
        		if (findIdx > -1) {
        			break;
        		}
			}
        	
        	if (findIdx > -1) {
        		count--;
        		reserveList.remove(findIdx);	
        	}
			
		}
        answer -= count; 
        return answer;
    } 
}
