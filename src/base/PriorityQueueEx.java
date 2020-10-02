package base;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 우선순위 큐 예제
 */
public class PriorityQueueEx {
	static class Prisoner implements Comparable<Prisoner> {
		String name;
		int weight; // 형량

		public Prisoner(String name, int weight) {
			this.name = name;
			this.weight = weight;
		}

		@Override
		public int compareTo(Prisoner target) {
			// 형량이 낮은 순으로 오름차순
			return (this.weight >= target.weight) ? 1 : -1;
		}
		
	}

	public static void main(String[] args) {
		Queue<Prisoner> priorityQueue = new PriorityQueue<Prisoner>();

		priorityQueue.add(new Prisoner("james", 5));
		priorityQueue.add(new Prisoner("schofield", 99));
		priorityQueue.add(new Prisoner("alex", 14));
		priorityQueue.add(new Prisoner("silvia", 10));
		priorityQueue.add(new Prisoner("thomson", 1));

		while (!priorityQueue.isEmpty()) {
			System.out.println(priorityQueue.poll().name);
		}
	}
}
