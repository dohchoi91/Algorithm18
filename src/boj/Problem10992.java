package boj;

import java.util.Scanner;

public class Problem10992 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int total = 2 * num - 1;
		
		for (int i = 0; i < num - 1; i++) {
			int start = num - i - 1;
			for (int j = 0; j < total; j++) {
				if (start == j) {
					System.out.print("*");
					for (int k = 0; k < (2 * i - 1); k++) {
						System.out.print(" ");
						if (k == (2 * i - 2)) {
							System.out.print("*");
						}
					}
					break;
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
		for (int j = 0; j < total; j++) {
			System.out.print("*");
		}
	}
}
