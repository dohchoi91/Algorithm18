package hackerrank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;

/**
 * ExtraLongFactorials
 * https://www.hackerrank.com/challenges/extra-long-factorials/problem
 * [포인트]
 * 1. BigInteger 사용방법
 * 2. 곱셈 순서 방향.
 */
public class ExtraLongFactorials {

	static String extraLongFactorials(int n) {
		BigInteger result = BigInteger.ONE;

		for (int i = 0; i < n; i++) {
			result = result.multiply(BigInteger.valueOf(i + 1));
		}
		return result.toString();
	}

	@Test
	void test1() {
		assertEquals("15511210043330985984000000", extraLongFactorials(25));
	}
	@Test
	void test2() {
		assertEquals("2658271574788448768043625811014615890319638528000000000", extraLongFactorials(44));
	}
	
}
