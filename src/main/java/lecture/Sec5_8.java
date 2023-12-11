import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");

		Queue<Customer> queue = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			if (i == target) queue.offer(new Customer(n, true));
			else queue.offer(new Customer(n, false));

		}

		int cnt = 0;
		while (true) {
			Customer poll = queue.poll();

			if (queue.stream().anyMatch(a -> a.number > poll.number)) {
				queue.offer(poll);
			} else {
				// 더 위험도가 큰 사람이 없으면 치료.
				cnt++;

				if (poll.isTarget) {
					System.out.print(cnt);
					break;
				}
			}
		}
	}

	static class Customer {
		int number;
		boolean isTarget;

		public Customer(int number, boolean isTarget) {
			this.number = number;
			this.isTarget = isTarget;
		}
	}
}

