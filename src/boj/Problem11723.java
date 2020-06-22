package boj;
import java.util.Scanner;

public class Problem11723 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int cnt = 0;
		int x = 0;
		int S = 0;
		String str = null;
		StringBuilder answer = new StringBuilder();
		
		while (cnt++ < num) {
			str = sc.next();
			
			if (str.equals("all")) {
				S = (1 << 21) - 1;
			} else if (str.equals("empty")) {
				S = 0;
			} else {
				x = (1 << sc.nextInt());
				if (str.equals("add")) {
					S = S | x;	
				} else if (str.equals("toggle")) {
					S = S ^ x;
				} else if (str.equals("remove")) {
					S = S & ~ x;	
				} else if (str.equals("check")) {
					if (((S & x) == 0)) {
						answer.append("0\n");
					} else {
						answer.append("1\n");
					}
				}
			}	
		}
		System.out.println(answer);
	}
}