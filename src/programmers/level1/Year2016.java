package programmers.level1;

import java.util.Date;

/*
 * 2016년
 * https://programmers.co.kr/learn/courses/30/lessons/12901
 * 
 */
public class Year2016 {
    public static String solution(int a, int b) {
        String[] weekdays = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
        Date date = new Date(2016, a - 1, b - 1);
        return weekdays[date.getDay()];
    }
    
    public static void main(String args[]) {
    	System.out.println(solution(5,24));
    }
}
