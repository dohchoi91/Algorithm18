package boj;

import java.util.Scanner;

public class Problem2444 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int center = (((2 * num) - 1) / 2) + 1;
		int total = 2 * num - 1;
		
		for (int i = 1; i <= total; i++) {
			for (int j = 1; j <= ((2 * num) - 1); j++) {
				int minScope = (i <= center) ? center - (i - 1) : center - (total - i);
				int maxScope = (i <= center) ? center + (i - 1) : center + (total - i);
				
				if (j >= minScope && j <= maxScope) {
					System.out.print("*");
				} else if (j < minScope) {
					System.out.print(" ");
				}
			}
			
			if (i != (num * 2) - 1) {
				System.out.println();	
			}
		}
	}
}
