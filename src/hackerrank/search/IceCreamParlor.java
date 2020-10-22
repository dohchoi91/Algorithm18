package hackerrank.search;

import java.util.HashMap;

/**
 * Hash Tables: Ice Cream Parlor
 * https://www.hackerrank.com/challenges/ctci-ice-cream-parlor/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=search
 * [포인트]
 * 1. HashTable or HashMap
 * 2. key값의 설정 : key가 동일 값 일 수도 있다.
 */
public class IceCreamParlor {
	String whatFlavors(int[] cost, int money) {

		HashMap<Integer, Integer> hashmap = new HashMap<>();
		
        int first = 0;
        int second = 0;

        for (int i = 0; i < cost.length; i++) {
            if (cost[i] < money) {
                int remain = money - cost[i];

                if (hashmap.get(remain) != null) {
                    first = i+1;
                    second = hashmap.get(remain);
                    break;
                } else {
                    hashmap.put(cost[i], i+1);
                }
            }
        }
        return Math.min(first, second) + " " + Math.max(first, second);

        // Fail : 남은 금액을 순차 적으로 조회 시 시간초과
        // boolean isFind = false;
        // for (int i = 0; i < cost.length; i++) {
        //     if (cost[i] < money) {
        //         int remain = money - cost[i];
        //         for(int j = i+1; j < cost.length; j++) {
        //             if (remain == cost[j]) {
        //                 first = i+1;
        //                 second = j+1;
        //                 isFind = true;
        //                 break;
        //             }
        //         }
        //     }
        //     if (isFind) {
        //         break;
        //     }
        // }
		
    }
}
