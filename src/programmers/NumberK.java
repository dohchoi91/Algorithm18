package programmers;

import java.util.*;

/**
 * K번째수 https://programmers.co.kr/learn/courses/30/lessons/42748?language=java#
 * 
 * [포인트] 
 * 1. 이차원 배열 활용법 및 배열 인덱스 이해
 *
 */
public class NumberK {
	public int[] solution(int[] array, int[][] commands) {

		int[] answer = new int[commands.length];
		List<Integer> subsetList = new ArrayList<Integer>();

		for (int i = 0; i < commands.length; i++) {
			int startIdx = commands[i][0] - 1;
			int endIdx = commands[i][1] - 1;
			int findIdx = commands[i][2] - 1;
			
			// subsetList를 추가하는 과정을 Arrays.copyOfRange로 대체하면 손쉽게 구현 가능
			subsetList.clear();

			for (int j = startIdx; j <= endIdx; j++) {
				subsetList.add(array[j]);
			}
			Collections.sort(subsetList);
			
			answer[i] = subsetList.get(findIdx);
		}
		return answer;
	}
}
