import java.io.*;
import java.util.*;

public class Main {

	static int p = 0;

	public static void main(String[] args) throws IOException {
//		String[][] plans = {{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}};

		String[][] plans = {{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}};

		String[] answer = new String[plans.length];

		Stack<String[]> stack = new Stack<>();

		List<A> list = new ArrayList<>();

		for (String[] str : plans) {
			String[] split = str[1].split(":");

			list.add(new A(str[0], Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(str[2])));
		}

		list.sort(new Comparator<A>() {
			@Override
			public int compare(A o1, A o2) {
				if (o1.getHour() == o2.getHour()) {
					return o1.getMinute() - o2.getMinute();
				} else {
					return o1.getHour() - o2.getHour();
				}
			}
		});

		int size = list.size();

		for (int i = 0; i < size; i++) {

			A current = list.get(i);

			// 스택이 비었고, 다음 요소가 없으면 결과에 넣고 종료
			if (i == size - 1) {
				answer[p++] = current.getSub();

				while (!stack.isEmpty()) {
					answer[p++] = stack.pop()[0];
				}

				break;
			}

			A next = list.get(i + 1);

			// 다음 시간까지의 차이 (분)
			int cal = calMinute(current, next);

			// 만약 다음 시간내에 끝나지 않으면 스택에 삽입
			if (cal < current.getDur()) {
				int remainTime = current.getDur() - cal;
				String sub = current.getSub();
				stack.push(new String[]{sub, String.valueOf(remainTime)});
			} else { // 끝날 수 있는 경우
				answer[p++] = current.getSub();

				int remainTime = cal - current.getDur();

				while (remainTime > 0) {
					if (!stack.isEmpty()) { // 스택이 있는 경우
						String[] pop = stack.pop();

						remainTime = remainTime - Integer.parseInt(pop[1]);

						// 다음 남는 시간 안에 끝날 수 있는 경우
						if (remainTime >= 0) {
							answer[p++] = pop[0];
						} else {
							stack.push(new String[]{pop[0], String.valueOf(remainTime)});
						}
					}
				}
			}
		}

		for (String s : answer) {
			System.out.println(s);
		}



	}

	static private int calMinute(A current, A next) {
		if (next.getHour() == current.getHour()) {
			return next.getMinute() - current.getMinute();
		} else {
			return (next.getHour() - current.getHour()) * 60 + (next.getMinute() - current.getMinute());
		}
	}


}

class A {
	private String sub;
	private int hour;
	private int minute;
	private int dur;

	public A(String sub, int hour, int minute, int dur) {
		this.sub = sub;
		this.hour = hour;
		this.minute = minute;
		this.dur = dur;
	}

	public String getSub() {
		return sub;
	}

	public void setSub(String sub) {
		this.sub = sub;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getDur() {
		return dur;
	}

	public void setDur(int dur) {
		this.dur = dur;
	}

	@Override
	public String toString() {
		return "A{" +
				"sub='" + sub + '\'' +
				", hour=" + hour +
				", minute=" + minute +
				", dur=" + dur +
				'}';
	}
}