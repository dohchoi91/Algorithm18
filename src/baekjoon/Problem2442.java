package baekjoon;

import java.util.Scanner;


public class Problem2442 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		int center = (((2 * num) - 1) / 2) + 1;
		
		for (int i = 1; i <= num; i++) {
			
			for (int j = 1; j <= ((2 * num) - 1); j++) {

				int minScope = center - (i - 1);
				int maxScope = center + (i - 1);
				
				if (j >= minScope && j <= maxScope) {
					System.out.print("*");
				} else if (j < minScope) {
					System.out.print(" ");
				}			
			}
			if (i != num) {
				System.out.println();	
			}
		}
	}
}
