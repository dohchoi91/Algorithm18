package programmers.level3;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * 여행경로
 * https://programmers.co.kr/learn/courses/30/lessons/43164
 */
public class TravelPath {

    Queue<String> pq = new PriorityQueue<>();

    static boolean[] visited;
    static StringBuilder route;

    public String[] solution(String[][] tickets) {
        for (int i = 0; i < tickets.length; i++) {
            visited = new boolean[tickets.length];

            String start = tickets[i][0];
            String end = tickets[i][1];

            if (start.equals("ICN")) {
                route = new StringBuilder(start).append(",");
                visited[i] = true;
                dfs(tickets, end, 1);
            }
        }
        String result = pq.poll();
        return result != null ? result.split(",") : null;
    }

    private void dfs(String[][] tickets, String end, int n) {
        route.append(end).append(",");
        if (n == tickets.length) {
            System.out.println(route.toString());
            pq.offer(route.toString());
        } else {
            for (int i = 0; i < tickets.length; i++) {
                String s = tickets[i][0];
                String e = tickets[i][1];

                if (s.equals(end) && !visited[i]) {
                    visited[i] = true;
                    dfs(tickets, e, n + 1);
                    visited[i] = false;
                    route.delete(route.length() - 4, route.length());
                }
            }
        }
    }

    @Test
    void test1() {
        assertArrayEquals(new String[]{"ICN", "JFK", "HND", "IAD"},
                solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}}));
    }
    @Test
    void test2() {
        assertArrayEquals(new String[]{"ICN", "ATL", "ICN", "SFO", "ATL", "SFO"},
                solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}}));
    }
}
