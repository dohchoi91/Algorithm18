package baekjoon;

import java.util.Scanner;

public class Problem2522 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int total = 2 * num - 1;

		for (int i = 0; i < total; i++) {
			for (int j = 0; j < num; j++) {
				if (i < num) {
					if (j >= num - (i + 1)) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				} else {
					if (j > i % num) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				}
			}
			if (i != total - 1) {
				System.out.println();
			}
		}
	}
}
