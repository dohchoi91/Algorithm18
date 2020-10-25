package hackerrank.greedy;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
/**
 * Minimum Absolute Difference in an Array
 * https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=greedy-algorithms
 *
 */
public class MinimumAbsoluteDifference {
	static int minimumAbsoluteDifference(int[] arr) {

		Arrays.sort(arr);
		int min = (int) (2 * Math.pow(10, 9)); // 범위를 표현 할 수 있는 최대 수

		for (int i = 0; i < arr.length - 1; i++) {
			int distance = Math.abs(arr[i] - arr[i + 1]);

			if (distance < min) {
				min = distance;
				if (min == 0) {
					return 0;
				}
			}
		}
		return min;
	}
	@Test
	void test1() {
		assertEquals(1, minimumAbsoluteDifference(new int[] {-59, -36, -13, 1, -53, -92, -2, -96, -54, 75}));
	}
	
}
