import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int F, S, G, U, D;
	static boolean[] check;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		if (S == G) {
			System.out.println(0);
			return;
		}

		check = new boolean[F + 1];

		int result = BFS();

		if (result == -1) {
			System.out.println("use the stairs");
			return;
		}

		System.out.print(result);

	}

	private static int BFS() {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(S);
		int index = 0;
		check[S] = true;

		while (!queue.isEmpty()) {
			int len = queue.size();

			for (int i = 0; i < len; i++) {
				Integer poll = queue.poll();

				if (validOffer(poll + U, queue)) return index + 1;
				if (validOffer(poll - D, queue)) return index + 1;
			}
			index++;
		}

		return -1;
	}

	private static boolean validOffer(Integer poll, Queue<Integer> queue) {
		if (poll > 0 && poll <= F) {
			if (!check[poll]) {
				if (poll == G) return true;
				check[poll] = true;
				queue.offer(poll);
			}
		}
		return false;
	}
}

