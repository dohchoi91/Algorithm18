package codility.timecomplexity;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * FrogJmp
 * Count minimal number of jumps from position X to Y.
 * https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp/
 */
public class FrogJmp {
    public int solution(int X, int Y, int D) {
        return ((Y - X) % D == 0) ? (Y - X) / D : (Y - X) / D + 1;
    }

    @Test
    void test1() {
        assertEquals(7, solution(10, 85, 30));
    }
}
