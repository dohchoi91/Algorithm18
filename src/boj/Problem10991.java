package boj;

import java.util.Scanner;

public class Problem10991 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int total = 2 * num - 1;
		
		for (int i = 0; i < num; i++) {
			int start = num - i - 1;
			int count = 0;
			boolean flag = true;
			for (int j = 0; j < total; j++) {
				if (start <= j) {
					if (flag) {
						System.out.print("*");
						count++;
					} else {
						System.out.print(" ");
					}
					flag = !flag;
				} else {
					System.out.print(" ");
				}
				if (count == i + 1) {
					break;
				}
			}
			System.out.println();
		}
	}
}
