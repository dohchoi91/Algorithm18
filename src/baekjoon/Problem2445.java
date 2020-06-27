package baekjoon;

import java.util.Scanner;

public class Problem2445 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int total = 2 * num;
		
		for (int i = 1; i <= total - 1; i++) {
			for (int j = 1; j <= total; j++) {
				
				if (i <= num) {
					if (j <= num) {
						if (i >= j) {
							System.out.print("*");
						} else {
							System.out.print(" ");
						}	
					} else {
						if ((total - i) < j) {
							System.out.print("*");
						} else {
							System.out.print(" ");
						}	
					}	
				} else {
					if (j <= num) {
						if (i - (2 * (i % num)) >= j) {
							System.out.print("*");
						} else {
							System.out.print(" ");
						}	
					} else {
						if ((total - (i - (2 * (i % num)))) < j) {
							System.out.print("*");
						} else {
							System.out.print(" ");
						}	
					}
				}
			}
			
			if (i != total) {
				System.out.println();	
			}
		}
	}
}
