package programmers.level1;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * 제일 작은 수 제거하기 
 * https://programmers.co.kr/learn/courses/30/lessons/12935
 */
public class RemoveMin {
	public int[] solution(int[] arr) {
		int a = 5;
		int b = 3;
		StringBuilder stb = new StringBuilder();
		for (int i = 0; i < b; i++) {
			
			for (int j = 0; j < a; j++) {
				stb.append("*");
			}
			System.out.println(stb.toString());
			stb.setLength(0);
		}
		
		if (arr.length == 1) {
			arr[0] = -1;
			return arr;
		} else {
			int[] res = new int[arr.length - 1];

			int[] newArr = Arrays.copyOf(arr, arr.length);
			Arrays.sort(newArr);
			int min = newArr[0];
			
			int idx = 0;
			for (int i : arr) {
				if (i != min) {
					res[idx++] = i;
				}
			}
			return res;
		}
	}

	@Test
	void test1() {
		assertArrayEquals(new int[] { 4, 3, 2 }, solution(new int[] { 4, 3, 2, 1 }));
	}

	@Test
	void test2() {
		assertArrayEquals(new int[] { -1 }, solution(new int[] { 10 }));
	}
}
