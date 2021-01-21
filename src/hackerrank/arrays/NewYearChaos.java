package hackerrank.arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * New Year Chaos
 * https://www.hackerrank.com/challenges/new-year-chaos/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 * 10-22 : 실패
 */
public class NewYearChaos {
    public String minimumBribes(int[] q) {
        for (int i = 0; i < q.length; i++) {
            if (q[i] - (i + 1) > 2) {
                return "Too chaotic";
            }
        }

        int count = 0;

        for (int i = 0; i < q.length; i++) {
            if (i + 1 != q[i]) {
                int tmpS = i + 1;
                for (int j = i + 1; j < q.length; j++) {

                    if (q[j] == tmpS) {
                        int tmp = q[j - 1];
                        q[j - 1] = q[j];
                        q[j] = tmp;
                        count ++;
                        i--; // 다시 점검하기 위해 index 리셋.
                        break;
                    }
                }
            }
        }
        return String.valueOf(count);
    }

    @Test
    public void test1() {
        assertEquals("3", minimumBribes(new int[] { 2, 1, 5, 3, 4 }));
        assertEquals("Too chaotic", minimumBribes(new int[] { 2, 5, 1, 3, 4 }));

    }

    @Test
    public void test2() {
        assertEquals("Too chaotic", minimumBribes(new int[] { 5, 1, 2, 3, 7, 8, 6, 4 }));
        assertEquals("7", minimumBribes(new int[] { 1, 2, 5, 3, 7, 8, 6, 4 }));

    }
}
