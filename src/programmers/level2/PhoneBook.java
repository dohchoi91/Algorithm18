package programmers.level2;

/*
 * 전화번호 목록
 * https://programmers.co.kr/learn/courses/30/lessons/42577?language=java
 * 
 * [포인트] 
 * 1. 접두어의 조건 정확하게 파악.
 * 2. 아는 메소드가 많을 수록 유리
 */

public class PhoneBook {
	public static boolean solution(String[] phone_book) {
		// 18~ 25라인을 Array.sort로 대체 가능!!
		String prefixStr = phone_book[0];
		int prefixIdx = 0;
		for (int i = 1; i < phone_book.length; i++) {
			if (prefixStr.length() > phone_book[i].length()) {
				prefixStr = phone_book[i];
				prefixIdx = i;
			}
		}
		
		for (int i = 0; i < phone_book.length; i++) {
			String targetStr = phone_book[i].substring(0, prefixStr.length());
			if (i != prefixIdx && prefixStr.equals(targetStr)) { // String.startWith로 대체 가능!!
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String[] phone_book = { "119", "97674223", "1195524421" };
		// String[] phone_book = {"123","456","789"};;
		System.out.println(solution(phone_book));

	}

}
