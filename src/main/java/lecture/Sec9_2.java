import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 회의실 배정
public class Main {
	static class TimeLine implements Comparable<TimeLine> {
		int start;
		int end;

		public TimeLine(int height, int weight) {
			this.start = height;
			this.end = weight;
		}

		@Override
		public int compareTo(TimeLine b) {
			if (end == b.end) return start - b.start;
			return end - b.end;
		}

		@Override
		public String toString() {
			return "TimeLine{" +
					"start=" + start +
					", end=" + end +
					'}';
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		List<TimeLine> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			list.add(new TimeLine(start, end));
		}

		Collections.sort(list);

		int cnt = 1;
		int end = list.get(0).end;
		for (int i = 1; i < N; i++) {

			TimeLine target = list.get(i);
			if (end <= target.start) {
				cnt++;
				end = target.end;
			}
		}
		System.out.print(cnt);
	}
}

