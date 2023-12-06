import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N, K;
	static int[] check;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		if (N == K) {
			System.out.println(0);
			return;
		}

		check = new int[200001];

		System.out.print(BFS(N));

	}

	private static int BFS(int current) {
		Queue<Integer> queue = new LinkedList<>();
		int index = 0;
		queue.offer(current);

		while (!queue.isEmpty()) {
			int len = queue.size();

			for (int i = 0; i < len; i++) {
				Integer poll = queue.poll();

				if (poll - 1 == K || poll + 1 == K || poll * 2 == K) return index + 1;

				if (poll != 0) {
					validOffer(poll - 1, queue);
				}
				if (poll < K) {
					validOffer(poll + 1, queue);
					validOffer(poll * 2, queue);
				}
			}
			index++;
		}
		return index;
	}

	private static void validOffer(Integer poll, Queue<Integer> queue) {
		if (check[poll] != 1) {
			check[poll] = 1;
			queue.offer(poll);
		}
	}
}

