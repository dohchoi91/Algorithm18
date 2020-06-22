package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MakingAnagrams {
	public static int numberNeeded(String first, String second) {
        int sum = 0;
        int [] alphabet = new int[26];
        for (char c : first.toCharArray()){
            alphabet[c - 'a']++;
        }
        for (char c : second.toCharArray()){
            alphabet[c - 'a']--;
        }
        for (int i : alphabet){
            sum += Math.abs(i);
        }
        
        for (int i = 0; i < alphabet.length; i++) {
        	System.out.print(alphabet[i] + " ");	
		}
        System.out.println();
        System.out.println(alphabet['c' - 'a']);
        return sum;
    }
    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
    	char[] charA = a.toCharArray();
    	char[] charB = b.toCharArray();
    	
    	Set<Character> delList = new HashSet();
    	
    	for (int i = 0; i < charA.length; i++) {
    		for (int j = 0; j < charB.length; j++) {
				if (charA[i] == charB[j]) {
					delList.add(charA[i]);
					break;
				}
			}
		}
    	
    	int delete = (a.length() + b.length());
    	
    	Iterator<Character> iteratoor = delList.iterator();
    	while (iteratoor.hasNext()) {
    		char target = iteratoor.next();
    		
    		int matchFreqA = 0;
        	int matchFreqB = 0;
        	
    		for (int j = 0; j < charA.length; j++) {
    			if (target == charA[j]) {
    				matchFreqA++;
    			}
			}
    		for (int j = 0; j < charB.length; j++) {
    			if (target == charB[j]) {
    				matchFreqB++;
    			}
			}
    		
			int delTarget = (matchFreqA > matchFreqB) ? matchFreqB : matchFreqA; 
			delete -= (delTarget * 2);
		}
    	
		return delete;
		
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String a = "fcrxzwscanmligyxyvym";
        String b = "jxwtrhvujlmrpdoqbisbwhmgpmeoke";

        int res = numberNeeded(a, b);


        scanner.close();
    }
}
