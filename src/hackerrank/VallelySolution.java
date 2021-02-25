package hackerrank;
import org.junit.jupiter.api.Test;
import java.util.*;


import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Counting Valleys
 * https://www.hackerrank.com/challenges/counting-valleys/problem?h_r=internal-search
 */
public class VallelySolution {

    // Complete the countingValleys function below.
    static int countingValleys1(String s) {
        char[] paths = s.toCharArray();
        
        int level = 0;
        int valleyCount = 0;
        char prevStep = paths[0];

        for (int i=0; i< paths.length; i++) {
            char currentStep = paths[i];
            boolean isSamePath = (prevStep == currentStep);
            
            System.out.println(isSamePath);

            if (isSamePath) {
                int prevLevel = level;
                level = (currentStep == 'D') ? level - 1: level + 1;
                prevStep = currentStep;
                if (i > 0 && prevLevel == 0) {
                    valleyCount++;
                }
            }
        }
        return valleyCount;
    }

    static int countingValleys2(String s) {
        int valley = 0;

        char[] paths = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char record : paths) {
            if (stack.isEmpty()) {
                stack.push(record);
            } else {
                if (stack.peek() != record) {
                    stack.pop();
                } else {
                    stack.push(record);
                }
                if (stack.isEmpty() && record == 'U') {
                    valley++;
                }
            }
        }
        return valley;
    }

    @Test
    void test1() {
        assertEquals(1, countingValleys2("UDDDUDUU"));
    }

    @Test
    void test2() {
        assertEquals(2, countingValleys2("DDUUDDUDUUUD"));
    }
}
