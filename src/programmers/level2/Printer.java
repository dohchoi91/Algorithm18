package programmers.level2;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Test;

/**
 * 프린터
 * https://programmers.co.kr/learn/courses/30/lessons/42587
 * [포인트]
 * 초기 index 값 처리. 
 */
public class Printer {
	class Node {
		int index;
		int priority;

		Node(int index, int priority) {
			this.index = index;
			this.priority = priority;
		}
	}

	public int solution(int[] priorities, int location) {
		int order = 0;

		Queue<Node> queue = new LinkedList<>();
		
		for (int i = 0; i < priorities.length; i++) {
			queue.add(new Node(i, priorities[i]));
		}
		
		while (queue.isEmpty()) {
			boolean isPrint = true;
			Node node = queue.poll();
			for (Node waitNode : queue) {
				if (node.priority < waitNode.priority) {
					isPrint = false;
					break;
				}
			}
			
			if (isPrint) {
				order++;
				if (location == node.index) {
					break;
				}
			} else {
				queue.add(node);
			}
		}

		return order;
	}

	@Test
	void test1() {
		assertEquals(1, solution(new int[] { 2, 1, 3, 2}, 2));
	}
	@Test
	void test2() {
		assertEquals(5, solution(new int[] { 1, 1, 9, 1, 1, 1}, 0));
	}
}
