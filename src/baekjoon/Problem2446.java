package baekjoon;

import java.util.Scanner;

public class Problem2446 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int total = num * 2 - 1;
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < total; j++) {
				
				if (j >= i && j < (total - i)) {
					System.out.print("*");
				} else if (j < i){
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
		int center = (((2 * num) - 1) / 2) + 1;
		
		for (int i = 2; i <= num; i++) {
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
