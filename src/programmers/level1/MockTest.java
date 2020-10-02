package programmers.level1;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

/*
 * 모의고사
 * https://programmers.co.kr/learn/courses/30/lessons/42840
 * 
 */

public class MockTest {
	public int[] solution(int[] answers) {
		List<int[]> patternList = new ArrayList<int[]>();
		patternList.add(new int[] { 1, 2, 3, 4, 5 });
		patternList.add(new int[] { 2, 1, 2, 3, 2, 4, 2, 5 });
		patternList.add(new int[] { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 });

		int[] ansCountArray = { 0, 0, 0 };

		for (int i = 0; i < answers.length; i++) {
			for (int j = 0; j < patternList.size(); j++) {
				int[] pattern = patternList.get(j);
				if (answers[i] == pattern[i % pattern.length]) {
					ansCountArray[j]++;
				}
			}
		}

		List<Integer> maxAnsList = new ArrayList<Integer>();
		maxAnsList.add(1);
		int maxIdx = 1;
		int maxValue = ansCountArray[0];

		for (int i = 1; i < ansCountArray.length; i++) {
			if (maxValue < ansCountArray[i]) {
				maxAnsList.clear();
				maxIdx = i + 1;
				maxValue = ansCountArray[i];
				maxAnsList.add(maxIdx);

			} else if (maxValue == ansCountArray[i]) {
				maxIdx = i + 1;
				maxValue = ansCountArray[i];
				maxAnsList.add(maxIdx);
			}
		}

		int[] answer = new int[maxAnsList.size()];
		for (int i = 0; i < maxAnsList.size(); i++) {
			System.out.println(maxAnsList.get(i));
			answer[i] = maxAnsList.get(i);
		}
		return answer;
	}

	@Test
	void test1() {
		assertArrayEquals(new int[] { 1 }, solution(new int[] { 1, 2, 3, 4, 5 }));
	}

	@Test
	void test2() {
		assertArrayEquals(new int[] { 1, 2, 3 }, solution(new int[] {1, 3, 2, 4, 2}));
	}
}
