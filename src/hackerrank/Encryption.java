package hackerrank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Encryption
 * https://www.hackerrank.com/challenges/encryption/problem
 * [포인트]
 * 1. rows 값의 산정 기준
 * 2. Array 길이에 대한 처리.
 */
public class Encryption {
	static String encryption(String s) {
		char[] ch = s.replaceAll(" ", "").toCharArray();

		double rawValue = Math.sqrt(s.length());
		int rows = ((int) rawValue < rawValue) ? (int) rawValue : (int) rawValue - 1;
		int cols = rows + 1;
		if (ch.length > rows * cols) {
			rows++;
		}

		char[][] grid = new char[rows][cols];
		boolean isEnd = false;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (((i * cols) + j) < ch.length) {
					grid[i][j] = ch[((i * cols) + j)];
				} else {
					isEnd = true;
					break;
				}
			}
			if (isEnd) {
				break;
			}
		}

		StringBuilder res = new StringBuilder();
		for (int i = 0; i < cols; i++) {
			for (int j = 0; j < rows; j++) {
				if ((int)grid[j][i] > 96) {
					res.append(grid[j][i]);
				} else {
					break;
				}
			}
			if (i < cols - 1) {
				res.append(" ");	
			}
		}
		return res.toString();
	}
	
	@Test
	void test1() {
		assertEquals("hae and via ecy", encryption("haveaniceday"));
	}
	@Test
	void test2() {
		assertEquals("fto ehg ee dd", encryption("feedthedog"));
	}
	@Test
	void test3() {
		assertEquals("clu hlt io", encryption("chillout"));
	}
	@Test
	void test4() {
		assertEquals("isieae fdtonf fotrga anoyec cttctt tfhhhs", encryption("iffactsdontfittotheorychangethefacts"));
	}
}
