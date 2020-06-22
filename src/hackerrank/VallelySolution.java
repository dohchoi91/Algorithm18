package hackerrank;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class VallelySolution {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        
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

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = 8;
        String s = "UDDDUDUU";
        int result = countingValleys(n, s);
        System.out.println(result);
    }
}
