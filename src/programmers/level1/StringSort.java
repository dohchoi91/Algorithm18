package programmers.level1;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * 문자열 내 마음대로 정렬하기
 * https://programmers.co.kr/learn/courses/30/lessons/12915?language=java
 * [포인트] 
 * 1. 정렬 기준 파악
 * 2. Comparator를 구현
 */
public class StringSort {
	class SolutionComparator implements Comparator<String> {
		private int index;

		public SolutionComparator(int n) {
			this.index = n;
		}

		@Override
		public int compare(String targetStr, String compareStr) {
			int target = (int) targetStr.charAt(index);
			int compare = (int) compareStr.charAt(index);

			if (target > compare || (target == compare && targetStr.compareTo(compareStr) > 0)) {
				return 1; // 오름 차순
			}
			return -1;
		}
	}

	public String[] solution(String[] strings, int n) {
		List<String> stringList = new ArrayList<>();
		for (int i = 0; i < strings.length; i++) {
			stringList.add(strings[i]);
		}

		Collections.sort(stringList, new SolutionComparator(n));
		String[] answer = stringList.toArray(new String[stringList.size()]); // List to Array

//		시도 1 : 버블정렬 -> 실 테스트 케이스 실패 			
//		String temp = null;
//		for (int i = 0; i < strings.length; i++) {
//			int target = (int) strings[i].charAt(n);
//			for (int j = i + 1; j < strings.length; j++) {
//				int compare = (int) strings[j].charAt(n);
//				if (target < compare || (target == compare && strings[i].compareTo(strings[j]) < 0)) {
//					temp = strings[i];
//					strings[i] = strings[j];
//					strings[j] = temp;
//				}
//			}
//		}

		return answer;
	}

	@Test
	void test1() {
		assertArrayEquals(new String[] { "car", "bed", "sun" }, solution(new String[] { "sun", "bed", "car" }, 1));
	}
	@Test
	void test2() {
		assertArrayEquals(new String[] { "abcd", "abce", "cdx" }, solution(new String[] { "abce", "abcd", "cdx" }, 2));

	}
}
