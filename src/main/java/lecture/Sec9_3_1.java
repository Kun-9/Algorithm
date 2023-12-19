import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 회의실 배정
public class Main {

	static class Person implements Comparable<Person> {
		int startTime;
		int endTime;

		public Person(int startTime, int endTime) {
			this.startTime = startTime;
			this.endTime = endTime;
		}

		@Override
		public int compareTo(Person person) {
			return endTime - person.endTime;
		}


		@Override
		public String toString() {
			return "Person{" +
					"startTime=" + startTime +
					", endTime=" + endTime +
					'}';
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		List<Person> personList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int startTime = Integer.parseInt(st.nextToken());
			int endTime = Integer.parseInt(st.nextToken());

			personList.add(new Person(startTime, endTime));
		}
		Collections.sort(personList);
		List<Person> sortByEndTime = personList;

		personList.sort(((o1, o2) -> o1.startTime - o2.startTime));
		List<Person> sortByStartTime = personList;

		int max = Integer.MIN_VALUE;

		List<Integer> tempList = new ArrayList<>();

		int maxNum = sortByEndTime.get(sortByEndTime.size() - 1).endTime;

		int cnt = 0;
		int answer = 0;

		for (int i = 0; i < maxNum; i++) {
			for (Person person : sortByEndTime) {
				int startTime = person.startTime;
				int endTime = person.endTime;

				if (i == endTime) {
					cnt--;
				} else if (i == startTime) {
					cnt++;
				}

				answer = Math.max(answer, cnt);
			}
		}

		System.out.println(answer);

	}
}

