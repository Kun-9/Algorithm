package lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 회의실 배정
public class Sec9_3_2 {

	static class Person implements Comparable<Person> {
		int time;
		int type;

		public Person(int time, int type) {
			this.time = time;
			this.type = type;
		}

		@Override
		public int compareTo(Person person) {
			int result = time - person.time;
			if (time == person.time) {
				result = type - person.type;
			}
			return result;
		}

		@Override
		public String toString() {
			return "Person{" +
					"time=" + time +
					", type='" + type + '\'' +
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

			// 1은 들어온것, 0은 나간것
			personList.add(new Person(startTime, 1));
			personList.add(new Person(endTime, 0));
		}

		Collections.sort(personList);


		int cnt = 0;
		int answer = 0;

		for (Person person : personList) {
			int time = person.time;
			int type = person.type;

			if (type == 1) {
				cnt++;
			} else {
				cnt--;
			}

			answer = Math.max(cnt, answer);
		}

		System.out.println(answer);
	}
}

