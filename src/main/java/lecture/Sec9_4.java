import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//
public class Main {

	static class Schedule implements Comparable<Schedule> {
		int amount;
		int day;

		public Schedule(int amount, int day) {
			this.amount = amount;
			this.day = day;
		}

		@Override
		public int compareTo(Schedule schedule) {
			int result = schedule.day - day;
			if (schedule.day == day) {
				result = schedule.amount - amount;
			}
			return result;
		}

		@Override
		public String toString() {
			return "Schedule{" +
					"amount=" + amount +
					", day=" + day +
					'}';
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		List<Schedule> list = new ArrayList<>();

		int maxDay = 0;

		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int amount = Integer.parseInt(st.nextToken());
			int day = Integer.parseInt(st.nextToken());

			maxDay = Math.max(maxDay, day);

			list.add(new Schedule(amount, day));
		}

		Collections.sort(list);

//		for (Schedule schedule : list) {
//			System.out.println(schedule);
//		}

		int answer = 0;
//		int cnt = 0;

		for (int i = 0; i < list.size() - 1; i++) {
			Schedule schedule = list.get(i);
			int amount = schedule.amount;
			int day = schedule.day;

			// 만약 현재 탐색일보다 작으면 큐에 삽입을 멈추고 가장 큰 값을 꺼낸다.

			if (day != maxDay) {
				Integer poll = priorityQueue.poll();

				// 값이 없으면 넘어감
				if (poll == null) {
//					System.out.println("day : " + maxDay + " 없음");
					maxDay = day;
					i--;
					continue;
				}

				answer += poll;
//				System.out.println("day : " + maxDay + " , out : " + poll);
//				System.out.println(priorityQueue);
//				cnt++;
				maxDay--;
				i--;
			} else {
				priorityQueue.offer(amount);
//				System.out.println(priorityQueue);
			}
		}


		// 마지막
		Integer poll = priorityQueue.poll();
//		System.out.println("day : " + maxDay + " , out : " + poll);
		answer += poll;
//		cnt++;

		System.out.println(answer);
//		System.out.println(cnt);
	}
}

